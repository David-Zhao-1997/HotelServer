package constant;

public class StringConstants
{
    private static final String TEMPERATURE_VISUALMAP = "top: 10,right: 10,pieces: [{gt: 0,lte: 50,color: '#096'}, {gt: 50,lte: 100,color: '#ffde33'}, {gt: 100,lte: 150,color: '#ff9933'}, {gt: 150,lte: 200,color: '#cc0033'}, {gt: 200,lte: 300,color: '#660099'}, {gt: 300,color: '#7e0023'}],outOfRange: {color: '#999'}";
    private static final String TEMPERATURE_MARKLINE = "silent: true,data: [{yAxis: 50}, {yAxis: 100}, {yAxis: 150}, {yAxis: 200}, {yAxis: 300}]";
    private static final String HUMIDITY_VISUALMAP = "top: 10,right: 10,pieces: [{gt: 0,lte: 50,color: '#096'}, {gt: 50,lte: 100,color: '#ffde33'}, {gt: 100,lte: 150,color: '#ff9933'}, {gt: 150,lte: 200,color: '#cc0033'}, {gt: 200,lte: 300,color: '#660099'}, {gt: 300,color: '#7e0023'}],outOfRange: {color: '#999'}";
    private static final String HUMIDITY_MARKLINE = "silent: true,data: [{yAxis: 50}, {yAxis: 100}, {yAxis: 150}, {yAxis: 200}, {yAxis: 300}]";
    private static final String AQI_VISUALMAP = "top: 10,right: 10,pieces: [{gt: 0,lte: 50,color: '#096'}, {gt: 50,lte: 100,color: '#ffde33'}, {gt: 100,lte: 150,color: '#ff9933'}, {gt: 150,lte: 200,color: '#cc0033'}, {gt: 200,lte: 300,color: '#660099'}, {gt: 300,color: '#7e0023'}],outOfRange: {color: '#999'}";
    private static final String AQI_MARKLINE = "silent: true,data: [{yAxis: 50}, {yAxis: 100}, {yAxis: 150}, {yAxis: 200}, {yAxis: 300}]";
    private static final String ALCOHOL_VISUALMAP = "top: 10,right: 10,pieces: [{gt: 0,lte: 50,color: '#096'}, {gt: 50,lte: 100,color: '#ffde33'}, {gt: 100,lte: 150,color: '#ff9933'}, {gt: 150,lte: 200,color: '#cc0033'}, {gt: 200,lte: 300,color: '#660099'}, {gt: 300,color: '#7e0023'}],outOfRange: {color: '#999'}";
    private static final String ALCOHOL_MARKLINE = "silent: true,data: [{yAxis: 50}, {yAxis: 100}, {yAxis: 150}, {yAxis: 200}, {yAxis: 300}]";
    private static final String CARBONMONOXIDE_VISUALMAP = "top: 10,right: 10,pieces: [{gt: 0,lte: 50,color: '#096'}, {gt: 50,lte: 100,color: '#ffde33'}, {gt: 100,lte: 150,color: '#ff9933'}, {gt: 150,lte: 200,color: '#cc0033'}, {gt: 200,lte: 300,color: '#660099'}, {gt: 300,color: '#7e0023'}],outOfRange: {color: '#999'}";
    private static final String CARBONMONOXIDE_MARKLINE = "silent: true,data: [{yAxis: 50}, {yAxis: 100}, {yAxis: 150}, {yAxis: 200}, {yAxis: 300}]";
    private static final String FANSTATE_VISUALMAP = "top: 10,right: 10,pieces: [{gt: 0,lte: 50,color: '#096'}, {gt: 50,lte: 100,color: '#ffde33'}, {gt: 100,lte: 150,color: '#ff9933'}, {gt: 150,lte: 200,color: '#cc0033'}, {gt: 200,lte: 300,color: '#660099'}, {gt: 300,color: '#7e0023'}],outOfRange: {color: '#999'}";
    private static final String FANSTATE_MARKLINE = "silent: true,data: [{yAxis: 50}, {yAxis: 100}, {yAxis: 150}, {yAxis: 200}, {yAxis: 300}]";
    private static final String DISTANCE_VISUALMAP = "top: 10,right: 10,pieces: [{gt: 0,lte: 50,color: '#096'}, {gt: 50,lte: 100,color: '#ffde33'}, {gt: 100,lte: 150,color: '#ff9933'}, {gt: 150,lte: 200,color: '#cc0033'}, {gt: 200,lte: 300,color: '#660099'}, {gt: 300,color: '#7e0023'}],outOfRange: {color: '#999'}";
    private static final String DISTANCE_MARKLINE = "silent: true,data: [{yAxis: 50}, {yAxis: 100}, {yAxis: 150}, {yAxis: 200}, {yAxis: 300}]";

    public static String getMarkLine(String metric)
    {
        switch (metric)
        {
            case "Temperature":
                return TEMPERATURE_MARKLINE;
            case "Humidity":
                return HUMIDITY_MARKLINE;
            case "AQI":
                return AQI_MARKLINE;
            case "Alcohol":
                return ALCOHOL_MARKLINE;
            case "Carbon_Monoxide":
                return CARBONMONOXIDE_MARKLINE;
            case "Fan_State":
                return FANSTATE_MARKLINE;
            case "Distance":
                return DISTANCE_MARKLINE;
        }
        return "";
    }

    public static String getVisualMap(String metric)
    {
        switch (metric)
        {
            case "Temperature":
                return TEMPERATURE_VISUALMAP;
            case "Humidity":
                return HUMIDITY_VISUALMAP;
            case "AQI":
                return AQI_VISUALMAP;
            case "Alcohol":
                return ALCOHOL_VISUALMAP;
            case "Carbon_Monoxide":
                return CARBONMONOXIDE_VISUALMAP;
            case "Fan_State":
                return FANSTATE_VISUALMAP;
            case "Distance":
                return DISTANCE_VISUALMAP;
        }
        return "";
    }
}
