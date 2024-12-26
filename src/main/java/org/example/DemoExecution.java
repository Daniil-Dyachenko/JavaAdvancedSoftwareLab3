package org.example;

import org.example.annotations.Validator;

/**
 * The {@code DemoExecution} class is used to compare two validation methods:
 * 1. Reflection-based approach (using annotations and reflection).
 * 2. Type-safe approach without reflection.
 * <p>
 * The class validates objects of different types (Gamer, Item, Plane, TypedGamer, TypedItem, TypedPlane),
 * invoking the corresponding validation methods and measuring the execution time for each approach.
 * If validation errors are found, the relevant error messages are printed.
 * </p>
 *
 * @see Validator
 * @see Gamer
 * @see Item
 * @see Plane
 * @see TypedGamer
 * @see TypedItem
 * @see TypedPlane
 */
public class DemoExecution {

    /**
     * The main method compares the execution time of reflection-based and non-reflection-based validation.
     * It prints the validation results for each object type and the time taken by each validation approach.
     *
     * @param args the command-line arguments (not used in this class)
     */
    public static void main(String[] args) {
        System.out.println("Starting comparison of reflection-based and no reflection validation...\n");


        System.out.println("--- Reflection-Based Validation ---");
        long reflectionStartTime = System.currentTimeMillis();
        try {
            System.out.println("Validating Gamer...");
            Validator.validate(new Gamer(null, 18));
        } catch (Exception e) {
            System.out.println("Reflection: " + e.getMessage());
        }
        try {
            System.out.println("Validating Item...");
            Validator.validate(new Item("Xiomi Redmi 13T", "T"));
        } catch (Exception e) {
            System.out.println("Reflection: " + e.getMessage());
        }
        try {
            System.out.println("Validating Plane...");
            //There will be no error, because in the Plane class we do not use annotations, but write validation manually.
            Validator.validate(new Plane("B", 1960));
        } catch (Exception e) {
            System.out.println("Reflection: " + e.getMessage());
        }
        long reflectionEndTime = System.currentTimeMillis();
        long reflectionDuration = reflectionEndTime - reflectionStartTime;
        System.out.println("Reflection validation time: " + reflectionDuration + "ms\n");


        System.out.println("--- No reflection Validation ---");
        long typeSafeStartTime = System.currentTimeMillis();
        try {
            System.out.println("Validating TypedGamer...");
            new TypedGamer(null, 18);
        } catch (IllegalArgumentException e) {
            System.out.println("No reflection: " + e.getMessage());
        }
        try {
            System.out.println("Validating TypedItem...");
            new TypedItem("Xiomi Redmi 13T", "Xiomi Redmi 13T — a modern smartphone featuring a high-performance processor, a quality camera, and a sleek design. Perfect for everyday use, gaming, and photography.");
        } catch (IllegalArgumentException e) {
            System.out.println("No reflection: " + e.getMessage());
        }
        try {
            System.out.println("Validating TypedPlane...");
            new TypedPlane("B", 1960);
        } catch (IllegalArgumentException e) {
            System.out.println("No reflection: " + e.getMessage());
        }
        long typeSafeEndTime = System.currentTimeMillis();
        long typeSafeDuration = typeSafeEndTime - typeSafeStartTime;
        System.out.println("No reflection validation time: " + typeSafeDuration + "ms\n");


        System.out.println("=== Comparison Results ===");
        System.out.println("Reflection validation time: " + reflectionDuration + "ms");
        System.out.println("No reflection validation time: " + typeSafeDuration + "ms");
        System.out.println("Difference (Reflection - No reflection: " + (reflectionDuration - typeSafeDuration) + "ms");

        if (reflectionDuration > typeSafeDuration) {
            System.out.println("No reflection validation is faster.");
        } else if (reflectionDuration < typeSafeDuration) {
            System.out.println("Reflection validation is faster.");
        } else {
            System.out.println("Both methods took the same amount of time.");
        }
    }
}
