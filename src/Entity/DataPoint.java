package Entity;

public class DataPoint
{
    private String id;
    private int fanState;
    private int carbonMonoxide;
    private int alcohol;
    private int temperature;
    private double distance;
    private int aqi;
    private int humidity;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public int getFanState()
    {
        return fanState;
    }

    public void setFanState(int fanState)
    {
        this.fanState = fanState;
    }

    public int getCarbonMonoxide()
    {
        return carbonMonoxide;
    }

    public void setCarbonMonoxide(int carbonMonoxide)
    {
        this.carbonMonoxide = carbonMonoxide;
    }

    public int getAlcohol()
    {
        return alcohol;
    }

    public void setAlcohol(int alcohol)
    {
        this.alcohol = alcohol;
    }

    public int getTemperature()
    {
        return temperature;
    }

    public void setTemperature(int temperature)
    {
        this.temperature = temperature;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public int getAqi()
    {
        return aqi;
    }

    public void setAqi(int aqi)
    {
        this.aqi = aqi;
    }

    public int getHumidity()
    {
        return humidity;
    }

    public void setHumidity(int humidity)
    {
        this.humidity = humidity;
    }

    @Override
    public String toString()
    {
        return id + "&" + temperature + "&" + humidity + "&" + aqi + "&" + carbonMonoxide + "&" + alcohol + "&" + fanState + "&" + distance;
    }
}
