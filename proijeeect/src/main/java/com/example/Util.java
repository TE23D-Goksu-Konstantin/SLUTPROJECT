package com.example;

import java.util.Scanner;

public class Util 
{

    public static String StringCheck(Scanner kb)
    {
        while(true)
        {
            String output = kb.nextLine().trim();
            
            if(!output.trim().isEmpty())
            {
                return output;
            }
            else
            { 
                System.out.println("[ERROR] - Invalid string, it is empty and therefore invalid");
            }
        }
    }

    public static int IntCheck(Scanner kb)
    {
        while(true)
        {
            int output = kb.nextInt();
            
            if(kb.hasNextInt())
            {
                return output;
            }
            else
            { 
                System.out.println("[ERROR] - Invalid integer, kindly choose a number");
            }
        }
    }


    public static boolean BoolCheck(Scanner kb)
    {
        while(true)
        {
            String output = kb.nextLine();
            
            if(output == "true" || output == "y" || output == "yes")
            {
                return true;
            }
            else if (output == "no" || output == "false" || output == "n")
            { 
                return false;
            }
            else
            {
                System.out.println("[ERROR] - Invalid boolean, kindly put yes or no");
            }
        }
    }


}
