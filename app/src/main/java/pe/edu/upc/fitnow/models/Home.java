package pe.edu.upc.fitnow.models;

import java.util.List;

/**
 * Created by Dreads on 29/09/2017.
 */

public class Home {
    private String id;
    private String name;
    private String description;
    private String url;
    private String category;
    private String language;
    private String country;
    private List<String> sortBysAvailable;

    public Home(String id, String name, String description, String url, String category, String language, String country, List<String> sortBysAvailable) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        this.setUrl(url);
        this.setCategory(category);
        this.setLanguage(language);
        this.setCountry(country);
        this.setSortBysAvailable(sortBysAvailable);
    }

    public Home() {
    }

    public String getId() {
        return id;
    }

    public Home setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Home setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Home setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Home setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Home setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public Home setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Home setCountry(String country) {
        this.country = country;
        return this;
    }

    public List<String> getSortBysAvailable() {
        return sortBysAvailable;
    }

    public Home setSortBysAvailable(List<String> sortBysAvailable) {
        this.sortBysAvailable = sortBysAvailable;
        return this;
    }
}
