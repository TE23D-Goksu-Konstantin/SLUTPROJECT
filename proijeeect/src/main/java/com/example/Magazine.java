package com.example;

public class Magazine extends LibraryContent
{

    private int issueNumber;


    public Magazine( int issueNumber, String id, String title, boolean isAvailable)
    {
        super(id, title, isAvailable);
        this.issueNumber = issueNumber;
    }


    public int getIssueNumber() {
        return issueNumber;
    }


    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }


    @Override
    public String toString() {
        return "Magazine [id=" + id + ", issueNumber=" + issueNumber + ", title=" + title + ", isAvailable="
                + isAvailable + "]";
    }

}
