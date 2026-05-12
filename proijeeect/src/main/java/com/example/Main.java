//Konstantin TE23D


package com.example;

import com.google.gson.*;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        
        URL url = new URL("http://10.151.168.5:3114/");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Scanner kb = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Magazine> magazines = new ArrayList<>();
        int input;


        while(true)
        {
            try
            {        
                magazines = new ArrayList<>(
                    Arrays.asList(
                    gson.fromJson(new java.io.InputStreamReader(
                        new java.net.URL("http://10.151.168.5:3114/magazines").openStream()
                    ),
                    Magazine[].class
                    )
                )
                );
            
                books = new ArrayList<>(
                    Arrays.asList(
                    gson.fromJson(new java.io.InputStreamReader(
                    new java.net.URL("http://10.151.168.5:3114/books").openStream()
                ),
                Book[].class
                )
                )
            );
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }

            try 
            {
                
                
                System.out.println("Welcome to NTI Library! \n1. Print books\n2. Print magazines\n3. Add book\n4. Add magazine\n5. [EXIT]");
                input = kb.nextInt();
            
                        

            if(input > 5 || input < 1)
            {
                System.out.println("[ERROR] - Kindly choose between 1-5");
            }
            else if(input == 1)
            {
                for (Book b : books) 
                {
                    System.out.println(b);
                }
            }
            else if(input == 2)
            {
                for (Magazine m : magazines) 
                {
                    System.out.println(m);
                }
            }
            else if(input == 3)
            {
                kb.nextLine();

                System.out.println("Title:");
                String title = Util.StringCheck(kb);

                System.out.println("Genre:");
                String genre = Util.StringCheck(kb);

                System.out.println("Pages:");
                int pages = Util.IntCheck(kb);

                System.out.println("Available:");
                boolean is_Available = Util.BoolCheck(kb);


                Book newBook = new Book(genre, pages, 0, title, is_Available);
                String json = gson.toJson(newBook);
                
                Files.writeString(Paths.get("proijeeect/src/Books.json"), json);
                System.out.println("Book added!");

            }
            }
            catch (IllegalArgumentException e) 
            {
                System.out.println(e);
            }
        } 
    }
}
