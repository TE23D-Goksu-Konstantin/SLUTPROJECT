//Konstantin TE23D
package com.example;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Scanner kb = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Magazine> magazines = new ArrayList<>();
        int input;
        HttpResponse<String> books_response;
        HttpResponse<String> magazines_response;

        // These following paragraphs, until the While() loop begins, retrieves
        // the JSON-file inforamtion from the server shown in the URL, making
        // it possible to print all existing books and magazines. 
        try
        {
            books_response = Unirest.get("http://10.151.168.5:3114/books").asString();
        }
            catch (UnirestException e)
        {
            System.out.println("Connection error: " + e.getLocalizedMessage());
            return;
        }

        int status = books_response.getStatus();

        

        try
        {
            magazines_response = Unirest.get("http://10.151.168.5:3114/magazines").asString();
        }
        catch (UnirestException e)
        {
            System.out.println("Connection error: " + e.getLocalizedMessage());
            return;
        }

        status = magazines_response.getStatus();



        while(true)
        {

            try
            {

                System.out.println("Welcome to NTI Library! \n1. Get books\n2. Get magazines\n3. Print books\n4. Print magazines\n5. Add book\n6. Add magazine\n7. [EXIT]");
                input = kb.nextInt();

                if(input > 7 || input < 1)
                {
                    System.out.println("[ERROR] - Kindly choose between 1-5");
                }
                else if(input == 1)
                {

                    if(status != 200)
                    {
                        System.out.println("Server error: " + status);
                        return;
                    }

                    String booksBody = books_response.getBody();

                    try
                    {
                        Files.writeString(Paths.get("books.json"), booksBody);
                    }
                    catch (IOException e)
                    {
                        System.out.println("File error: " + e.getMessage());
                    }

                    Type bookListType = new TypeToken<ArrayList<Book>>(){}.getType();
                    books = gson.fromJson(booksBody, bookListType);


                }
                else if(input == 2)
                {
                    if(status != 200)
                    {
                        System.out.println("Server error: " + status);
                        return;
                    }

                    String magazinesBody = magazines_response.getBody();

                    try
                    {
                        Files.writeString(Paths.get("magazines.json"), magazinesBody);
                    }
                    catch (IOException e)
                    {
                        System.out.println("File error: " + e.getMessage());
                    }

                    Type magazineListType = new TypeToken<ArrayList<Magazine>>(){}.getType();
                    magazines = gson.fromJson(magazinesBody, magazineListType);

                }
                else if(input == 3)
                {
                    for (Book b : books)
                    {
                        System.out.println(b);
                    }
                }
                else if(input == 4)
                {
                    for (Magazine m : magazines)
                    {
                        System.out.println(m);
                    }
                }
                else if(input == 5)
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

                    Book newBook = new Book(genre, pages, "", title, is_Available);

                    String jsonBody = gson.toJson(newBook);

                    HttpResponse<String> postResponse;

                    try
                    {
                        postResponse = Unirest.post("http://10.151.168.5:3114/books")
                            .header("Content-Type", "application/json")
                            .body(jsonBody)
                            .asString();
                    }
                    catch (UnirestException e)
                    {
                        System.out.println("Connection error: " + e.getLocalizedMessage());
                        return;
                    }

                    status = postResponse.getStatus();

                    if(status != 200 && status != 201)
                    {
                        System.out.println("Server error: " + status);
                        return;
                    }

                    String postBody = postResponse.getBody();

                    Book responseBook = gson.fromJson(postBody, Book.class);

                    books.add(responseBook);

                    System.out.println("Saved on server: " + responseBook);
                }
                else if(input == 6)
                {
                    kb.nextLine();

                    System.out.println("Title:");
                    String title = Util.StringCheck(kb);

                    System.out.println("Issue number:");
                    int iss_Number = Util.IntCheck(kb);

                    System.out.println("Published year:");
                    int publishedYear = Util.IntCheck(kb);

                    System.out.println("Available:");
                    boolean is_Available = Util.BoolCheck(kb);

                    Magazine newMagazine = new Magazine(iss_Number, publishedYear, "", title, is_Available);

                    String jsonBody = gson.toJson(newMagazine);

                    HttpResponse<String> postResponse;

                    try
                    {
                        postResponse = Unirest.post("http://10.151.168.5:3114/magazines")
                            .header("Content-Type", "application/json")
                            .body(jsonBody)
                            .asString();
                    }
                    catch (UnirestException e)
                    {
                        System.out.println("Connection error: " + e.getLocalizedMessage());
                        return;
                    }

                    status = postResponse.getStatus();

                    if(status != 200 && status != 201)
                    {
                        System.out.println("Server error: " + status);
                        return;
                    }

                    String postBody = postResponse.getBody();

                    Magazine responseMagazine = gson.fromJson(postBody, Magazine.class);

                    magazines.add(responseMagazine);

                    System.out.println("Saved on server: " + responseMagazine);
                }
                else if(input == 7)
                {
                    kb.close();
                    Unirest.shutDown();
                    System.exit(0);
                }
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e);
            }
        }
    }
}