package com.example;

import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class Util 
{

    public static String StringCheck(Scanner kb, String input)
    {
        while(true)
        {
            System.out.println(input);
            String output = kb.nextLine().trim();
            
            if(!output.trim().isEmpty())
            {
                return output;
            }
            else
            { 
                System.out.println("[ERROR] - String is empty and therefore invalid");
            }
        }
    }

    public static int IntCheck(Scanner kb, int input)
    {
        while(true)
        {
            System.out.println(input);
            int output = kb.nextInt();
            
            if(kb.hasNextInt())
            {
                return output;
            }
            else
            { 
                System.out.println("[ERROR] - String is empty and therefore invalid");
            }
        }
    }


}
