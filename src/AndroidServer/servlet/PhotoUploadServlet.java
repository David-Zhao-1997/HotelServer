package AndroidServer.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PhotoUploadServlet", urlPatterns = "/PhotoUploadServlet")
public class PhotoUploadServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private static final String PATH = "C://fileUpload";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //将文件保存到-->PATH目录下
        File file = new File(PATH);
        if (!file.isDirectory() && !file.exists())
        {
            //文件不存在
            System.out.println("文件不存在需要创建");
            file.mkdir();
        }
        PrintWriter pw = response.getWriter();
        try
        {
            //1、创建一个 DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决文件上传文件名的中文乱码
            upload.setHeaderEncoding("utf-8");
            //3、判断提交上来的数据是否是上传表单的数据
            if (!upload.isMultipartContent(request))
            {
                return;
            }
            //4、使用ServletFileUpload解析器解析上传的数据，解析结果是一个List<FileItem>
            //集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item : list)
            {
                //如果fileitem中封装的是普通的输入数据项
                if (item.isFormField())
                {
                    String name = item.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
                    String value = item.getString("utf-8");
                    //
                    System.out.println("name===" + value);
                }
                else
                {//如果是上传的文件
                    String filename = item.getName();
                    System.out.println("filename=" + filename);
                    if (filename == null || filename.trim().equals(""))
                    {
                        continue;
                    }
                    filename = filename.substring(filename.lastIndexOf("\\") + 1);
                    //获取文件上传得到的输入流
                    InputStream is = item.getInputStream();
                    //获取一个文件的输出流
                    FileOutputStream out = new FileOutputStream(PATH + "\\" + filename);
                    //获取数据
                    byte[] b = new byte[1024 * 1024 * 100];
                    int len = 0;
                    while ((len = is.read(b)) != -1)
                    {
                        out.write(b, 0, len);
                        out.flush();
                    }
                    is.close();
                    out.close();
                    //处理文件上传时生成的临时文件
                    item.delete();
                    pw.println("文件上传成功");
                }
            }
        }
        catch (Exception e)
        {
            pw.println("文件上传失败");
        }
    }
}
