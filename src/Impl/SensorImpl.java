package Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.Conn;

public class SensorImpl
{
    public static final int NORMAL = 1;
    public static final int OVERPROOF = 0;
    public static final int FAN_ON = 1;
    public static final int FAN_OFF = 0;
    public static final int TURN_FAN_ON = 1;
    public static final int TURN_FAN_OFF = 0;
    public static final int CONTINUE = -1;

    public static boolean sensorDataInsert(String sensorData)
    {
        if (sensorData == null || "".equals("sensorData"))
        {
            return false;
        }
        Connection conn = new Conn().getCon();
        StringBuilder stmt = new StringBuilder("insert into sensordata values(?,now(),");
        String[] sensors = sensorData.split("&");
        int sensorNum = sensors.length - 1;
        for (int i = 0; i < sensorNum; i++)
        {
            stmt.append("?,");
        }
        for (int i = 0; i < 17 - sensorNum - 2; i++)
        {
            stmt.append("null,");
        }
        stmt.deleteCharAt(stmt.length() - 1);
        stmt.append(")");
        try
        {
            PreparedStatement pstmt = conn.prepareStatement(stmt.toString());
            pstmt.setString(1, sensors[0]);
            for (int i = 2; i <= sensorNum + 1; i++)
            {
                pstmt.setInt(i, Integer.parseInt(sensors[i - 1]));
            }
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        finally
        {
            try
            {
                conn.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }


    public static int updateFanState(String sensorData)
    {
        String[] sensors = sensorData.split("&");
        String id = sensors[0];
        int temperature = Integer.parseInt(sensors[1]);
        int humidity = Integer.parseInt(sensors[2]);
        int aqi = Integer.parseInt(sensors[3]);
        byte co = Byte.parseByte(sensors[4]);       //1 for normal 0 for overproof
        byte alcohol = Byte.parseByte(sensors[5]);  //1 for normal 0 for overproof
        byte fanState = Byte.parseByte(sensors[6]); //1 for on 0 for off
        if (temperature > 25 || aqi > 95 || co == OVERPROOF || alcohol == OVERPROOF)
        {
            if (fanState == FAN_ON)
            {
                return CONTINUE;
            }
            else
            {
                return TURN_FAN_ON;
            }
        }
        else
        {
            if (fanState == FAN_OFF)
            {
                return CONTINUE;
            }
            else
            {
                return TURN_FAN_OFF;
            }
        }
    }
}
