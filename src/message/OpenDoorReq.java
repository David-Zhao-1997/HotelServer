package message;

public class OpenDoorReq
{
    private String type="OpenDoorReq";
    private String doorNum;

    public OpenDoorReq(String doorNum)
    {
        this.doorNum = doorNum;
    }

    public String getDoorNum()
    {
        return doorNum;
    }

    public void setDoorNum(String doorNum)
    {
        this.doorNum = doorNum;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
