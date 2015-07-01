package edu.weber.cs3270.scotthadzik.kidtrackapp;

/**
 * Created by Joe on 7/1/2015.
 */
public class PersonRowItem {
    private String name;
    private String type;
    private int id;


    public PersonRowItem(String name, String type, long id) {
        this.name = name;
        this.type = type;
        this.id = (int) id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
