package homework1;

import homework1.animals.Animal;
import homework1.animals.mammals.Cat;
import homework1.animals.mammals.Dog;
import homework1.animals.birds.Duck;
import homework1.system.EConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static homework1.system.EConstants.valueOf;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<Animal> animals = new ArrayList<>();


        while (true) {
            System.out.println("Введите команду:");
            String dz = scanner.next().toUpperCase(Locale.ROOT).trim();

            if (contains(dz)) {
                switch (EConstants.valueOf(dz)) {
                    case ADD:
                        animals.add(initAnimal());
                        break;
                    case LIST:

                        for (Animal animal : animals) {
                            System.out.println(animal.toString());
                        }
                        break;
                    case EXIT:
                        System.exit(0);
                }
            }
        }
    }

    private static Animal initAnimal() {

        Animal animal = null;
        int age = 0;
        int weight = 0;
        while (animal == null) {

            System.out.println("Какое животное создать? cat/dog/duck");
            String animalAll = scanner.next().toLowerCase(Locale.ROOT).trim();

            switch (animalAll) {
                case "cat":
                    animal = new Cat();
                    break;
                case "dog":
                    animal = new Dog();
                    break;
                case "duck":
                    animal = new Duck();
                    break;
                default:
                    System.out.println("Этого животного нет в списке.Попробуйте снова.");


            }
        }


        System.out.println("Введите имя: ");
        animal.setName(scanner.next());

        System.out.println("Введите возраст: ");

        while (age <= 0) {
            while (!scanner.hasNextInt()) {

                System.out.println("Неверное значение. Попробуйте снова.");
                scanner.next();
            }
            age = scanner.nextInt();
            animal.setAge(age);

    }


        System.out.println("Введите вес: ");
        while (weight <= 0) {
            while (!scanner.hasNextInt()) {
                System.out.println("Неверное значение. Попробуйте снова.");
                scanner.next();
            }
            weight = scanner.nextInt();
            animal.setWeight(weight);


        }


        System.out.println("Введите цвет: ");
        animal.setColor(scanner.next());

        System.out.println("Животное добавлено.");

        return animal;
    }

    private static boolean contains(String inputCommand) {

        for (EConstants c : EConstants.values()) {
            if (c.name().equals(inputCommand)) {
                return true;
            }
        }

        return false;
    }
}
















