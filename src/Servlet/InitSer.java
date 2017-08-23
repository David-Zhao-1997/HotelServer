package Servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.TsdbImpl;
import testmqttjava.MQTTListener;

@WebServlet(name = "InitSer")
public class InitSer extends HttpServlet
{
    @Override
    public void init() throws ServletException
    {
        super.init();
        MQTTListener.start();//启动MQTT监听
        TsdbImpl tsdb = new TsdbImpl();
        ServletContext application = getServletContext();
        application.setAttribute("Metrics",tsdb.getMetrics());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
