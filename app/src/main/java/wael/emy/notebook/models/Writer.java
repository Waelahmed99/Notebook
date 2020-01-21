package wael.emy.notebook.models;

import java.util.ArrayList;

public class Writer {
    private Long id;
    private String name;
    private String intro;
    private ArrayList<Long> books;
    private ArrayList<String> interests;
    private String image;

    public Writer(Long id, String name, String intro, ArrayList<Long> books,
                  ArrayList<String> interests, String image) {
        this.id = id;
        this.name = name;
        this.intro = intro;
        this.books = books;
        this.interests = interests;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public ArrayList<Long> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Long> books) {
        this.books = books;
    }

    public ArrayList<String> getInterests() {
        return interests;
    }

    public void setInterests(ArrayList<String> interests) {
        this.interests = interests;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
