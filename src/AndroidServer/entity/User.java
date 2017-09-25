package AndroidServer.entity;

public class User
{
    private String phone;
    private String password;
    private String ID_num;
    private int deposit;
    private String username;
    private int realNameFlag;
    private int inUse;

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getID_num()
    {
        return ID_num;
    }

    public void setID_num(String ID_num)
    {
        this.ID_num = ID_num;
    }

    public int getDeposit()
    {
        return deposit;
    }

    public void setDeposit(int deposit)
    {
        this.deposit = deposit;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public int getRealNameFlag()
    {
        return realNameFlag;
    }

    public void setRealNameFlag(int realNameFlag)
    {
        this.realNameFlag = realNameFlag;
    }

    public int getInUse()
    {
        return inUse;
    }

    public void setInUse(int inUse)
    {
        this.inUse = inUse;
    }
}
