package com.example;

//Parent-class to book and magazine which
//contains shared variables
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

        
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "LibraryContent [id=" + id + ", title=" + title + ", isAvailable=" + isAvailable
                + "]";
    }
}
