package com.apps.bookfarm.Author;


import javax.persistence.*;

@Entity
@Table (name= "AUTHOR")

public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "AUTHOR_ID")
    private Long authorID;
    @Column(name = "AUTHOR_NAME")
    private String authorName;
    @Column(name = "PHONE_NUMBER")
    private int phoneNumber;

    public Author(String authorName, int phoneNumber) {

        this.authorName = authorName;
        this.phoneNumber = phoneNumber;
    }

    public Author() {

    }

    public Long getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Long authorID) {
        this.authorID = authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorID=" + authorID +
                ", authorName='" + authorName + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
