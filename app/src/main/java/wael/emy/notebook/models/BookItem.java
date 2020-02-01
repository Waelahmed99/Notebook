package wael.emy.notebook.models;

public class BookItem {
    private String name;
    private String image;
    private String writerID;
    private String type;

    public BookItem() {}

    public BookItem(String name, String image, String writerID, String type) {
        this.name = name;
        this.image = image;
        this.writerID = writerID;
        this.type = type;
    }

    public String toJson() {
        return "{\"name\": \""+name+"\",\n" +
                "\"image\": \""+image+"\",\n" +
                "\"writerID\": \""+writerID+"\",\n" +
                "\"type\": \""+type+"\",\n}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWriterID() {
        return writerID;
    }

    public void setWriterID(String writerID) {
        this.writerID = writerID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
