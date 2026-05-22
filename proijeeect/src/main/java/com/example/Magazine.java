package com.example;

public class Magazine extends LibraryContent
{

    private int issueNumber;
    private int publishedYear;


    public Magazine( int issueNumber, int publishedYear, String id, String title, boolean isAvailable)
    {
        super(id, title, isAvailable);
        this.issueNumber = issueNumber;
        this.publishedYear = publishedYear;
    }


    public int getIssueNumber() {
        return issueNumber;
    }


    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public int getPublishedYear() {
        return publishedYear;
    }


    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }


    @Override
    public String toString() {
        return "Magazine [id=" + id + ", issueNumber=" + issueNumber + ", title=" + title + ", publishedYear="
                + publishedYear + ", isAvailable=" + isAvailable + "]";
    }



}
