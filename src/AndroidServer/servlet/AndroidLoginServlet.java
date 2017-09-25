package AndroidServer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AndroidServer.dao.UserDao;

@WebServlet(name = "AndroidLoginServlet")
public class AndroidLoginServlet extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        System.out.println("用户注册");
        PrintWriter out = response.getWriter();
        String content = request.getParameter("content");

        if ("phoneNumber".equals(content))
        {
            String phoneNum = request.getParameter("phoneNum");
            System.out.println("用户" + phoneNum + "注册");
            boolean res = UserDao.createUser(phoneNum);
            System.out.println("注册结果 " + res);
            if (res == false)
            {
                out.write("fail");
            }
            else
            {
                out.write("success");
            }
        }
        else if ("code".equals(content))
        {
            String code = request.getParameter("code");
            System.out.println("用户填写的验证码 " + code);
            String phoneNum = request.getParameter("phoneNum");
            boolean res = UserDao.verifyCode(phoneNum, code);
            System.out.println("验证码验证结果 " + res);
            if (res == false)
            {
                out.write("fail");
            }
            else
            {
                out.write("success");
            }
        }
        else if ("ID_Num&realName".equals(content))
        {
            String ID_Num = request.getParameter("ID_Num");
            String realName = request.getParameter("realName");
            boolean res = UserDao.verify_Name_ID(ID_Num, realName);
            if (res == false)
            {
                out.write("fail");
            }
            else
            {
                out.write("success");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
