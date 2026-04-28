package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class Main 
{
    public static void main(String[] args) throws MalformedURLException 
    {


    URL url = new URL("http://10.151.168.5:3114/");
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    try {
        List<Magazine> magazines = Arrays.asList(
            gson.fromJson(new java.io.InputStreamReader(
                    new java.net.URL("http://10.151.168.5:3114/magazines").openStream()
                ),
                Magazine[].class
            )
        );

        List<Book> books = Arrays.asList(
            gson.fromJson(new java.io.InputStreamReader(
                    new java.net.URL("http://10.151.168.5:3114/books").openStream()
                ),
                Book[].class
            )
        );

        for (Book b : books) 
        {
            System.out.println(b);
        }
        for (Magazine m : magazines) 
        {
            System.out.println(m);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}