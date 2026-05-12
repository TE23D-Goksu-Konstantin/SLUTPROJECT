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
            if(kb.hasNextInt())
            {     
                int output = kb.nextInt();
                kb.nextLine();
                return output;
            }
            else
            { 
                System.out.println("[ERROR] - Invalid integer, kindly choose a number");
                kb.nextLine();
            }
        }
    }


    public static boolean BoolCheck(Scanner kb)
    {
        while(true)
        {
            String output = kb.nextLine().trim().toLowerCase();
            
            if(output.equals("true") || output.equals("y") || output.equals("yes"))
            {
                return true;
            }
            else if (output.equals("no") || output.equals("false") || output.equals("n"))
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
