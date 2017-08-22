package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Impl.SensorImpl;

@WebServlet(name = "SensorSer")
public class SensorSer extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ServletContext application = this.getServletContext();
        response.setHeader("Access-Control-Allow-Origin", "*");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Enumeration<String> attrNames = request.getParameterNames();
//        System.out.println(attrNames);
        StringBuilder stringBuilder = new StringBuilder();
//        ArrayList arrayList = new ArrayList();
        while (attrNames.hasMoreElements())
        {
            String name = attrNames.nextElement();
            String value = request.getParameter(name);
//            arrayList.add(value);
            stringBuilder.append(value + "&");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        String sensorData = stringBuilder.toString();
        application.setAttribute(sensorData.split("&")[0], sensorData);
        SensorImpl.sensorDataInsert(sensorData);
        int state = SensorImpl.updateFanState(sensorData);
        if (state == SensorImpl.TURN_FAN_ON)
        {
            out.print("ID=" + sensorData.split("&")[0] + "&electric=" + SensorImpl.TURN_FAN_ON);
            System.out.println("风扇开启");
        }
        else if (state == SensorImpl.TURN_FAN_OFF)
        {
            out.print("ID=" + sensorData.split("&")[0] + "&electric=" + SensorImpl.TURN_FAN_OFF);
            System.out.println("风扇关闭");
        }
        else
        {
            out.print("-");
        }
//        String temID = request.getParameter("temID");
//        String tem = request.getParameter("tem");
//        String hudID = request.getParameter("hudID");
//        String hud = request.getParameter("hud");
//        application.setAttribute("temID", temID);
//        application.setAttribute("tem", tem);
//        application.setAttribute("hudID", hudID);
//        application.setAttribute("hud", hud);
        System.out.println((request.getQueryString()));
//        out.write("传感器id是"+username+"\n您的密码是"+password);
//        System.out.println("您的登录名是"+username+"\n您的密码是"+password);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
