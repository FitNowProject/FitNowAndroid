package pe.edu.upc.fitnow.model;

/**
 * Created by mac on 11/13/17.
 */

public class TypeEvent {
    public String description;
    public String image;
    public String type;
    public String key;

    public TypeEvent(String description, String image, String type, String key) {
        this.description = description;
        this.image = image;
        this.type = type;
        this.key = key;
    }
    public TypeEvent() {

    }

    public String getDescription() {
        return description;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
