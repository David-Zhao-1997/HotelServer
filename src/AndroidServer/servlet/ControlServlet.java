package AndroidServer.servlet;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AndroidServer.dao.UserDao;
import message.OpenDoorReq;
import mqtt.MQTTListener;

@WebServlet(name = "ControlServlet", urlPatterns = "/ControlServlet")
public class ControlServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String content = request.getParameter("content");
        if (content.equals("OpenDoorRequest"))
        {
            PrintWriter out = response.getWriter();
            out.write("请求成功<br>");
            out.write("{\"type\":\"OpenDoorReq\",\"doorNum\":\"id1\"}<br>");
            String phoneNum = request.getParameter("phoneNum");
            String code = request.getParameter("code");
            String doorNum = request.getParameter("doorNum");
            if (UserDao.verifyCode(phoneNum, code))
            {
                Gson gson = new Gson();
                String OpenDoorRequest = gson.toJson(new OpenDoorReq(doorNum));
                System.out.println(OpenDoorRequest);
                MQTTListener.sendMessage(OpenDoorRequest);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
