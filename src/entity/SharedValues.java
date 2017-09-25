package entity;

import java.util.concurrent.ConcurrentHashMap;

public class SharedValues
{
    public static ConcurrentHashMap<String, DataPoint> sensorData = new ConcurrentHashMap<>();
}
