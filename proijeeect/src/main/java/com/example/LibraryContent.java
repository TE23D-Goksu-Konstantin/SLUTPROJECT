package com.example;

public abstract class LibraryContent 
{

    protected String id;
    protected String title;
    protected boolean isAvailable;

    public LibraryContent(String id, String title, boolean isAvailable)
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
