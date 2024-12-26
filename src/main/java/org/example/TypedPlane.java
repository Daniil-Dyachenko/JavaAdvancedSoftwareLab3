package org.example;

/**
 * The {@code TypedPlane} class represents an airplane with a model and a manufacturing year.
 * It ensures that the model name is between 3 and 25 characters long, and that the manufacturing year is between 1970 and 2024.
 * <p>
 * The constructor performs validation on the input parameters:
 * <ul>
 *     <li>{@code model} must be a non-null and non-empty string with a length between 3 and 25 characters inclusive.</li>
 *     <li>{@code year} must be an integer between 1970 and 2024 inclusive.</li>
 * </ul>
 * If any of the validation conditions are not met, an {@link IllegalArgumentException} is thrown.
 * </p>
 */
public class TypedPlane {

    private String model;
    private int year;

    /**
     * Constructs a new {@code TypedPlane} with the specified model and manufacturing year.
     * The constructor ensures that the model name is between 3 and 25 characters long, and that the year is between 1970 and 2024.
     *
     * @param model the model of the plane. It must be a non-null and non-empty string with a length between 3 and 25 characters inclusive.
     * @param year the year of manufacture of the plane. It must be between 1970 and 2024 inclusive.
     * @throws IllegalArgumentException if the {@code model} is {@code null} or empty, if its length is less than 3 or greater than 25 characters,
     *         or if the {@code year} is less than 1970 or greater than 2024.
     */
    public TypedPlane(String model, int year) {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Field 'model' in TypedPlane cannot be null or empty.");
        }
        if (model.length() < 3 || model.length() > 25) {
            throw new IllegalArgumentException("Field 'model' in TypedPlane must have length between 3 and 25.");
        }
        if (year < 1970 || year > 2024) {
            throw new IllegalArgumentException("Field 'year' in TypedPlane must be between 1970 and 2024.");
        }
        this.model = model;
        this.year = year;
    }
}