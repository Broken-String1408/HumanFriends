package entities;

import java.util.Date;

public class Hamster extends Pet {

    public Hamster(String name, Date dateOfBirth, String owner, String address) {
        super(name, dateOfBirth, owner, address);
    }

    @Override
    public void walk() {
        System.out.println("Ваш хомяк " + getName() + " бегает в высокой траве");
    }
}
