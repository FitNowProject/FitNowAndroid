package pe.edu.upc.fitnow.model;

/**
 * Created by mac on 11/14/17.
 */

public class Place {
    private String address;
    private String district;
    private String key;

    public Place(String address, String district, String key) {

        this.address = address;
        this.district = district;
        this.key = key;
    }

    public Place() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

