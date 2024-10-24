package entities;

import java.util.Date;

public class Dog extends Pet {
    public Dog(String name, Date dateOfBirth, String owner, String address) {
        super(name, dateOfBirth, owner, address);
    }

    @Override
    public void play() {
        System.out.println("Ваша собака " + getName() + " гоняет котов");
    }
}
