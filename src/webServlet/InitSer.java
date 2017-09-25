package webServlet;

import db.TsdbImpl;
import mqtt.MQTTListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        System.out.println(tsdb.getMetrics());
        application.setAttribute("Metrics", tsdb.getMetrics());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
