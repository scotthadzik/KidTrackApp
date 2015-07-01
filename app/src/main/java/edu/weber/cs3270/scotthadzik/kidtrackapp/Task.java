package edu.weber.cs3270.scotthadzik.kidtrackapp;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Joe on 6/30/2015.
 */



@Table(name = "Tasks")
public class Task extends Model {
    @Column(name = "Name", index = true)
    public String name;

    @Column(name = "Person", index = true)
    public Person person;

    public Task() {
        super();
    }

    public Task(String name, Person person) {
        super();
        this.name = name;
        this.person = person;
    }
}