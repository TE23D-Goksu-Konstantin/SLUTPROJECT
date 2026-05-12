package com.example;

public abstract class LibraryContent 
{

    protected int id;
    protected String title;
    protected boolean isAvailable;

    public LibraryContent(int id, String title, boolean isAvailable)
    {
        this.id = id;
        this.title = title;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "LibraryContent [id=" + id + ", title=" + title + ", isAvailable=" + isAvailable
                + "]";
    }
}
