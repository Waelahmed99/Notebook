package wael.emy.notebook.models;

import java.util.ArrayList;

public class Book {
    private Long id;
    private String name;
    private String intro;
    private Long writerID;
    private float price;
    private ArrayList<String> selections;
    private int nominations;
    private String image;
    private ArrayList<String> types;

    public Book(Long id, String name, String intro, Long writerID, float price,
                ArrayList<String> selections, int nominations, String image, ArrayList<String> types) {
        this.id = id;
        this.name = name;
        this.intro = intro;
        this.writerID = writerID;
        this.price = price;
        this.selections = selections;
        this.nominations = nominations;
        this.image = image;
        this.types = types;
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

    public Long getWriterID() {
        return writerID;
    }

    public void setWriterID(Long writerID) {
        this.writerID = writerID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ArrayList<String> getSelections() {
        return selections;
    }

    public void setSelections(ArrayList<String> selections) {
        this.selections = selections;
    }

    public int getNominations() {
        return nominations;
    }

    public void setNominations(int nominations) {
        this.nominations = nominations;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }
}
