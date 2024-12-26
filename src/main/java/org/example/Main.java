package org.example;

import org.example.annotations.Validator;

/**
 * The {@code Main} class demonstrates the usage of the {@link Validator} class
 * to validate objects of different classes using custom annotations.
 * <p>
 * The main method creates instances of {@link Gamer}, {@link Item}, and {@link Plane}
 * classes, and validates them using reflection (for {@link Validator}) and non-reflection
 * based validation (for {@link Plane}).
 * </p>
 */
public class Main {

    /**
     * The main method is the entry point of the application.
     * It creates instances of {@link Gamer}, {@link Item}, and {@link Plane} classes,
     * and validates them. It also measures the time taken for reflection-based and
     * non-reflection-based validations.
     *
     * @param args the command-line arguments (not used in this implementation)
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        try {
            Gamer gamer = new Gamer(null, 18);
            Validator.validate(gamer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Item item = new Item("Xiomi Redmi 13T", "Xiomi Redmi 13T — a modern smartphone featuring a high-performance processor, a quality camera, and a sleek design. Perfect for everyday use, gaming, and photography.");
            Validator.validate(item);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        long endTime = System.currentTimeMillis();
        long reflectionTime = endTime - startTime;
        System.out.println("Reflection completion time: " + reflectionTime + "ms");

        startTime = System.currentTimeMillis();
        try {
            Plane plane = new Plane("Boeing 747", 1890);
            plane.validate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Plane plane = new Plane("Airbus A-320", 1990);
            plane.validate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        endTime = System.currentTimeMillis();
        long noReflectionTime = endTime - startTime;
        System.out.println("No reflection completion time: " + noReflectionTime + "ms");
    }
}