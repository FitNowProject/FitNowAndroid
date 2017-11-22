package pe.edu.upc.fitnow.model;

/**
 * Created by mac on 11/15/17.
 */

public class Exercice {
    private String key;
    private String name;
    private String detail;
    private String image;
    private boolean check;

    public Exercice(String key, String name, String detail, String image) {
        this.key = key;
        this.name = name;
        this.detail = detail;
        this.image = image;
    }

    public Exercice() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
