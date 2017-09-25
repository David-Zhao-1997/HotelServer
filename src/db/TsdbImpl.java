package db;

import com.baidubce.BceClientConfiguration;
import com.baidubce.Protocol;
import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.tsdb.TsdbClient;
import com.baidubce.services.tsdb.model.GetMetricsResponse;
import com.baidubce.services.tsdb.model.Group;
import com.baidubce.services.tsdb.model.Query;
import com.baidubce.services.tsdb.model.QueryDatapointsResponse;
import com.baidubce.services.tsdb.model.Result;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import entity.TsdbQueryResult;

public class TsdbImpl
{
    String ACCESS_KEY_ID = "ddc606e5635a4e5ba90aa7ed9d8515c9";               // 用户的Access Key ID
    String SECRET_ACCESS_KEY = "c6353a3ef34a4d8d9f4b6d17bcdac19e";       // 用户的Secret Access Key
    String ENDPOINT = "minihotel.tsdb.iot.gz.baidubce.com";           // 用户的时序数据库域名，形式如databasename.tsdb.iot.gz.baidubce.com
    static TsdbClient tsdbClient;
    BceClientConfiguration config = new BceClientConfiguration()
            .withProtocol(Protocol.HTTPS)   //使用HTTPS协议;不设置，默认使用HTTP协议
            .withCredentials(new DefaultBceCredentials(ACCESS_KEY_ID, SECRET_ACCESS_KEY))
            .withEndpoint(ENDPOINT);

    public TsdbImpl()
    {
    }

    public void close()
    {
        System.out.println("close");
        tsdbClient.shutdown();
    }

    public TsdbClient getClient()
    {
        System.out.println("getClient");
        tsdbClient = new TsdbClient(config);
        return tsdbClient;
    }

    public List<String> getMetrics()
    {
        getClient();
        GetMetricsResponse response = tsdbClient.getMetrics();
        close();
        return response.getMetrics();
    }

    public TsdbQueryResult query(List<Query> queries)
    {
        getClient();
        TsdbQueryResult tsdbQueryResult = new TsdbQueryResult();
        // 查询数据
        QueryDatapointsResponse resp = tsdbClient.queryDatapoints(queries);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String times = "[";
        String values = "[";
// 打印结果
        for (Result result : resp.getResults())
        {
            for (Group group : result.getGroups())
            {
                try
                {
                    for (Group.TimeAndValue timeAndValue : group.getTimeAndValueList())
                    {
                        if (timeAndValue.isDouble())
                        {
                            times += ("\"" + simpleDateFormat.format(new Date(new Long(timeAndValue.getTime()))) + "\",");
                            values += timeAndValue.getDoubleValue() + ",";
                        }
                        else if (timeAndValue.isLong())
                        {
                            times += ("\"" + simpleDateFormat.format(new Date(new Long(timeAndValue.getTime()))) + "\",");
                            values += timeAndValue.getLongValue() + ",";
                        }
                        else
                        {
                            times += ("\"" + simpleDateFormat.format(new Date(new Long(timeAndValue.getTime()))) + "\",");
                            values += timeAndValue.getStringValue() + ",";
                        }
                    }
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        times = times.substring(0, times.length() - 1);
        values = values.substring(0, values.length() - 1);
        times += "]";
        values += "]";
        tsdbQueryResult.setTimes(times);
        tsdbQueryResult.setValues(values);
        close();
        return tsdbQueryResult;
    }
}
