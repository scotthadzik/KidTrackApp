package edu.weber.cs3270.scotthadzik.kidtrackapp;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by Joe on 6/30/2015.
 */
@Table(name = "Persons")
public class Person extends Model {
    @Column(name = "Name")
    public String name;

    @Column (name = "PersonType")
    public String personType;

    public List<Task> items() {
        return getMany(Task.class, "Persons");
    }

    public static List<Person> getAllPeople(){
        return new Select()
                .from(Person.class)
                .execute();
    }
}
