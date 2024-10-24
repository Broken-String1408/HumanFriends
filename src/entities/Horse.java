package entities;

import java.util.Date;

public class Horse extends PackAnimal{
    public Horse(String name, Date dateOfBirth, Integer maxLoad, Integer maxSpeed) {
        super(name, dateOfBirth, maxLoad, maxSpeed);
    }
}
