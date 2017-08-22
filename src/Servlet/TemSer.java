package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.SharedValues;

@WebServlet(name = "SensorSer")
public class TemSer extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ServletContext application = this.getServletContext();
//        out.write
//(application.getAttribute("temID") + "&" + application.getAttribute("tem") + "&" + application.getAttribute("hudID") + "&" + application.getAttribute("hud"));
        String ID = request.getParameter("ID");
        if (ID == null)
        {
            return;
        }
        try
        {
//            out.write(application.getAttribute(ID).toString());
            out.write(SharedValues.sensorData.get("1").toString());
//            System.out.println(SharedValues.sensorData.get("1").toString());
        }
        catch (Exception e)
        {

        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request, response);
    }
}
