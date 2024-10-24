package entities;

import java.util.Date;

public abstract class Pet extends Animal {
    private String owner;
    private String address;
    public Pet(String name, Date dateOfBirth, String owner, String address){
        super(name, dateOfBirth);
        this.owner = owner;
        this.address = address;

    }
    public void walk(){
        System.out.println("Ваш питомец пошёл гулять");
    }
    public void play(){
        System.out.println("Ваш питомец играет");
    }
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Pet {" +
                "name='" + getName() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                ", owner='" + owner + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
