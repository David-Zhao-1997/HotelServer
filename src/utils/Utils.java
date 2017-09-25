package utils;

import java.util.Random;

public class Utils
{
    public static int generatePassword()
    {
        Random random = new Random();
        int x = random.nextInt(899999);
        x = x + 100000;
        return x;
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.println(generatePassword());
        }
    }
}
