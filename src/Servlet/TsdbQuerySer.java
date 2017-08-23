package Servlet;

import com.baidubce.services.tsdb.TsdbConstants;
import com.baidubce.services.tsdb.model.Aggregator;
import com.baidubce.services.tsdb.model.Filters;
import com.baidubce.services.tsdb.model.GroupBy;
import com.baidubce.services.tsdb.model.Query;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.TsdbQueryResult;
import db.TsdbImpl;

@WebServlet(name = "TsdbQuerySer")
public class TsdbQuerySer extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        TsdbImpl tsdb = new TsdbImpl();
        String metric = request.getParameter("Metric");
        String relativeStart = request.getParameter("relativeStartValue")+" "+request.getParameter("relativeStartUnit")+" ago";
        String  sampling = request.getParameter("samplingValue")+" "+request.getParameter("samplingUnit");
        String aggregator = request.getParameter("aggregator");
        List<Query> queries = Arrays.asList(new Query()                          // 创建Query对象
                .withMetric(metric)                                              // 设置metric
//                .withField(FIELD)                                                // 设置查询的域名，不设置表示查询默认域
                .withFilters(new Filters()                                       // 创建Filters对象
                        .withRelativeStart(relativeStart))                     // 设置相对的开始时间，这里设置为2秒前
                .addGroupBy(new GroupBy()                                        // 创建GroupBy对象
                        .withName(TsdbConstants.GROUP_BY_NAME_TIME)              // 设置分组方式为Time
                        .withTimeRangeSize("1 second")                           // 设置目标时长
                        .withGroupCount(1))                                      // 设置分组个数
                .withLimit(10000)                                                  // 设置返回数据点数目限制
                .addAggregator(new Aggregator()                                  // 创建Aggregator对象
                        .withName(aggregator)             // 设置聚合函数
                        .withSampling(sampling)));                             // 设置采样
        TsdbQueryResult tsdbQueryResult = tsdb.query(queries);
        request.setAttribute("tsdbQueryResult",tsdbQueryResult);
        request.getRequestDispatcher("/queryResult.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request,response);
    }
}
