package entity;

public class DataPoint
{
    private String id;
    private int carbonMonoxide;
    private int temperature;
    private int humidity;
    private int pm2;
    private int co2;
    private int voc;
    private int mq135;

    public int getMq135()
    {
        return mq135;
    }

    public void setMq135(int mq135)
    {
        this.mq135 = mq135;
    }

    public int getCarbonMonoxide()
    {
        return carbonMonoxide;
    }

    public void setCarbonMonoxide(int carbonMonoxide)
    {
        this.carbonMonoxide = carbonMonoxide;
    }

    public int getTemperature()
    {
        return temperature;
    }

    public void setTemperature(int temperature)
    {
        this.temperature = temperature;
    }

    public int getHumidity()
    {
        return humidity;
    }

    public void setHumidity(int humidity)
    {
        this.humidity = humidity;
    }

    public int getPm2()
    {
        return pm2;
    }

    public void setPm2(int pm2)
    {
        this.pm2 = pm2;
    }

    public int getCo2()
    {
        return co2;
    }

    public void setCo2(int co2)
    {
        this.co2 = co2;
    }

    public int getVoc()
    {
        return voc;
    }

    public void setVoc(int voc)
    {
        this.voc = voc;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return id + "&" + temperature + "&" + humidity + "&" + pm2 + "&" + carbonMonoxide + "&" + co2 + "&" + voc + "&" + mq135;
    }
}
