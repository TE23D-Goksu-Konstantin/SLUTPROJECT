package com.example;

public class Book extends LibraryContent
{

    private String genre;
    private int pages;

    public Book(String genre, int pages, int id, String title, boolean isAvailable)
    {
        super(id, title, isAvailable);
        this.genre = genre;
        this.pages = pages;
    }

    public String getGenre() {
        return genre;
    }

    public int getPages() {
        return pages;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Books [id=" + id + ", genre=" + genre + ", title=" + title + ", isAvailable="
                + isAvailable + ", pages=" + pages + "]";
    }
    
}
