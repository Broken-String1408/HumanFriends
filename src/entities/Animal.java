package entities;

import java.util.*;

public abstract class Animal {
    private final String id;
    private String name;
    private final List<String> commands;
    private Date dateOfBirth;

    public Animal(String name, Date dateOfBirth){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.id = UUID.randomUUID().toString();
        commands = new ArrayList<>();
    }
    public void eat(){
        System.out.println("Животное поело");
    }
    public void sleep(){
        System.out.println("Животное уснуло");
    }
    public void addCommand(String command){
        commands.add(command);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCommands() {
        return commands;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
