import entities.Animal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalControl {

    private final List<Animal> animals;

    public AnimalControl() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public List<String> displayCommands(String id){
        for(Animal animal : animals){
            if(animal.getId().equals(id)){
                return animal.getCommands();
            }
        }
        return null;
    }

    public void trainNewCommand(String id, String command){
        for(Animal animal : animals){
            if(animal.getId().equals(id)){
                animal.addCommand(command);
            }
        }
    }

    public List<Animal> getAnimalsSortedByDateOfBirth(){
        return animals.stream().sorted(Comparator.comparing(Animal::getDateOfBirth).reversed())
                .collect(Collectors.toList());
    }

    public Integer getAnimalsTotal() {
        return animals.size();
    }

    public Animal findAnimalByName(AnimalControl animalControl, String name) {
        for (Animal animal : animalControl.getAnimalsSortedByDateOfBirth()) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }


}
