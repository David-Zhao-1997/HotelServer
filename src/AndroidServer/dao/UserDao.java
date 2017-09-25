package AndroidServer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import AndroidServer.impl.SMSImpl;
import db.Conn;
import utils.Utils;

public class UserDao
{
    private static Connection conn = new Conn().getCon();

    public static boolean createUser(String phoneNum)
    {
        String code = Utils.generatePassword() + "";
        try
        {
//            PreparedStatement stmt = conn.prepareStatement("EXEC register ?,?,?,?,?,?,?");
//            stmt.setString(1, user.getPhone());
//            stmt.setString(2, user.getPassword());
//            stmt.setString(3, user.getID_num());
//            stmt.setInt(4, user.getDeposit());
//            stmt.setString(5, user.getUsername());
//            stmt.setInt(6, user.getRealNameFlag());
//            stmt.setInt(7, user.getInUse());
//            stmt.executeUpdate();
            System.out.println(code);
            PreparedStatement pstmt = conn.prepareStatement("EXEC register ?,?");
            pstmt.setString(1, phoneNum);
            pstmt.setString(2, code);
            pstmt.executeUpdate();
            //向用户发送验证码
            SMSImpl.sendCode(phoneNum, code);
//            System.out.println("短信发送的号码 " + code);
        }
        catch (SQLException e)
        {
//            e.printStackTrace();
            if ("User Already Exist".equals(e.getMessage()))
            {
                //不需要执行注册 直接向用户发送验证码
                changePassword(phoneNum, code);
                //向用户发送验证码
                SMSImpl.sendCode(phoneNum, code);
                return true;
            }
        }
        System.out.println("短信发送的号码 " + code);
        return true;
    }

    public static boolean verifyCode(String phoneNum, String code)
    {
        try
        {
            PreparedStatement pstmt = conn.prepareStatement("EXEC verifyCode ?,?");
            pstmt.setString(1, phoneNum);
            pstmt.setString(2, code);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
//            e.printStackTrace();
            if ("Incorrect Code".equals(e.getMessage()))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean verify_Name_ID(String ID_Num, String realName)
    {
        System.out.println(ID_Num);
        System.out.println(realName);
        return true;
    }

    public static void changePassword(String phone, String code)
    {
        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement("EXEC changePassword ?,?");
            preparedStatement.setString(1, phone);
            preparedStatement.setString(2, code);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("用户密码修改失败");
        }
    }

    public static void main(String[] args)
    {
//        UserDao userDao = new UserDao();
//        User user = new User();
//        user.setPhone("17806261067");
//        user.setPassword(utils.generatePassword()+"");
//        user.setID_num("370782199609284312");
//        user.setDeposit(0);
//        user.setUsername("梁焕祥");
//        user.setRealNameFlag(0);
//        user.setInUse(0);
//        System.out.println(userDao.createUser(user));
        String phonenNum = "18661661838";
        System.out.println(createUser(phonenNum));

    }
}
