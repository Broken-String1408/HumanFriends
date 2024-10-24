package entities;

import java.util.Date;

public class Cat extends Pet {
    public Cat(String name, Date dateOfBirth, String owner, String address) {
        super(name, dateOfBirth, owner, address);
    }

    @Override
    public void walk() {
        System.out.println("Ваша кошка " + getName() + " гуляет.");
    }
}
