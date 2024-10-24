import entities.*;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        AnimalControl animalControl = new AnimalControl();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n*** Animal Control Menu ***");
            System.out.println("1. Add Animal");
            System.out.println("2. Train New Command");
            System.out.println("3. Display Commands");
            System.out.println("4. Get Animals Sorted by Date of Birth");
            System.out.println("5. Get Total Number of Animals");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    addAnimalMenu(animalControl, scanner);
                    break;
                case 2:
                    trainNewCommandMenu(animalControl, scanner);
                    break;
                case 3:
                    displayCommandsMenu(animalControl, scanner);
                    break;
                case 4:
                    displaySortedAnimals(animalControl);
                    break;
                case 5:
                    System.out.println("Total number of animals: " + animalControl.getAnimalsTotal());
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }



    // Sub-menu for adding animals
    private static void addAnimalMenu(AnimalControl animalControl, Scanner scanner) {
        System.out.println("Select the type of animal to add:");
        System.out.println("1. Cat");
        System.out.println("2. Dog");
        System.out.println("3. Hamster");
        System.out.println("4. Horse");
        System.out.println("5. Donkey");
        System.out.println("6. Camel");

        int animalType = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Animal Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
        String dob = scanner.nextLine();
        Date dateOfBirth = Date.valueOf(dob); // Assuming a java.sql.Date format or similar

        Animal animal = null;

        switch (animalType) {
            case 1: // Cat
                System.out.print("Enter Owner's Name: ");
                String catOwner = scanner.nextLine();
                System.out.print("Enter Address: ");
                String catAddress = scanner.nextLine();
                animal = new Cat(name, dateOfBirth, catOwner, catAddress);
                break;
            case 2: // Dog
                System.out.print("Enter Owner's Name: ");
                String dogOwner = scanner.nextLine();
                System.out.print("Enter Address: ");
                String dogAddress = scanner.nextLine();
                animal = new Dog(name, dateOfBirth, dogOwner, dogAddress);
                break;
            case 3: // Hamster
                System.out.print("Enter Owner's Name: ");
                String hamsterOwner = scanner.nextLine();
                System.out.print("Enter Address: ");
                String hamsterAddress = scanner.nextLine();
                animal = new Hamster(name, dateOfBirth, hamsterOwner, hamsterAddress);
                break;
            case 4: // Horse
                System.out.print("Enter Max Load: ");
                int horseMaxLoad = scanner.nextInt();
                System.out.print("Enter Max Speed: ");
                int horseMaxSpeed = scanner.nextInt();
                animal = new Horse(name, dateOfBirth, horseMaxLoad, horseMaxSpeed);
                break;
            case 5: // Donkey
                System.out.print("Enter Max Load: ");
                int donkeyMaxLoad = scanner.nextInt();
                System.out.print("Enter Max Speed: ");
                int donkeyMaxSpeed = scanner.nextInt();
                animal = new Donkey(name, dateOfBirth, donkeyMaxLoad, donkeyMaxSpeed);
                break;
            case 6: // Camel
                System.out.print("Enter Max Load: ");
                int camelMaxLoad = scanner.nextInt();
                System.out.print("Enter Max Speed: ");
                int camelMaxSpeed = scanner.nextInt();
                animal = new Camel(name, dateOfBirth, camelMaxLoad, camelMaxSpeed);
                break;
            default:
                System.out.println("Invalid animal type.");
                return;
        }

        animalControl.addAnimal(animal);
        System.out.println("Animal added successfully!");
    }

    // Sub-menu for training new commands
    private static void trainNewCommandMenu(AnimalControl animalControl, Scanner scanner) {
        List<Animal> animals = animalControl.getAnimalsSortedByDateOfBirth();
        if (animals.isEmpty()) {
            System.out.println("No animals available.");
            return;
        }

        System.out.println("Select an animal by name:");
        for (Animal animal : animals) {
            System.out.println(" - " + animal.getName());
        }

        System.out.print("Enter Animal Name: ");
        String name = scanner.nextLine();

        Animal selectedAnimal = animalControl.findAnimalByName(animalControl, name);
        if (selectedAnimal == null) {
            System.out.println("Animal with the name '" + name + "' not found.");
            return;
        }

        System.out.print("Enter new command to train: ");
        String command = scanner.nextLine();

        animalControl.trainNewCommand(selectedAnimal.getId(), command);
        System.out.println("Command added successfully to " + selectedAnimal.getName() + ".");
    }

    private static void displayCommandsMenu(AnimalControl animalControl, Scanner scanner) {
        List<Animal> animals = animalControl.getAnimalsSortedByDateOfBirth();
        if (animals.isEmpty()) {
            System.out.println("No animals available.");
            return;
        }

        System.out.println("Select an animal by name:");
        for (Animal animal : animals) {
            System.out.println(" - " + animal.getName());
        }

        System.out.print("Enter Animal Name: ");
        String name = scanner.nextLine();

        Animal selectedAnimal = animalControl.findAnimalByName(animalControl, name);
        if (selectedAnimal == null) {
            System.out.println("Animal with the name '" + name + "' not found.");
            return;
        }

        List<String> commands = animalControl.displayCommands(selectedAnimal.getId());
        if (commands != null && !commands.isEmpty()) {
            System.out.println("Commands for " + selectedAnimal.getName() + ":");
            for (String command : commands) {
                System.out.println(" - " + command);
            }
        } else {
            System.out.println(selectedAnimal.getName() + " has no commands.");
        }
    }

    // Display animals sorted by date of birth
    private static void displaySortedAnimals(AnimalControl animalControl) {
        List<Animal> sortedAnimals = animalControl.getAnimalsSortedByDateOfBirth();
        System.out.println("Animals sorted by date of birth:");
        for (Animal animal : sortedAnimals) {
            System.out.println(animal);
        }
    }

}
