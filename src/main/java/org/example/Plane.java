package org.example;

/**
 * The {@code Plane} class represents a plane with a model and year.
 * It uses custom validation logic to ensure the fields meet specific constraints.
 * <p>
 * The {@code model} field cannot be {@code null} and must have a length between 3 and 100 characters.
 * The {@code year} field must be between 1970 and 2024.
 * </p>
 */
public class Plane {

    public String model;
    public int year;

    /**
     * Constructs a {@code Plane} with the specified model and year.
     *
     * @param model the model of the plane
     * @param year the year of the plane
     */
    public Plane(String model, int year) {
        this.model = model;
        this.year = year;
    }

    /**
     * Validates the fields of the {@code Plane} instance based on the constraints.
     * <p>
     * The {@code model} field must not be {@code null} and must have a length between 3 and 100 characters.
     * The {@code year} field must be between 1970 and 2024.
     * </p>
     *
     * @throws IllegalArgumentException if any validation constraint is violated
     */
    public void validate() {
        if (model == null) {
            throw new IllegalArgumentException("Field 'model' in class Plane cannot be null.");
        }
        if (model.length() < 3 || model.length() > 25) {
            throw new IllegalArgumentException("Field 'model' in class Plane must have length between 3 and 25.");
        }
        if (year < 1970 || year > 2024) {
            throw new IllegalArgumentException("Field 'year' in class Plane must be between 1970 and 2024.");
        }
    }
}
