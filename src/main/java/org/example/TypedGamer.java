package org.example;

/**
 * The {@code TypedGamer} class represents a gamer with a username and age.
 * It ensures that the username is not null or empty, and that the age is within the range of 12 to 100 years.
 * <p>
 * The constructor performs validation on the input parameters:
 * <ul>
 *     <li>{@code username} must be a non-null and non-empty string.</li>
 *     <li>{@code age} must be between 12 and 100 inclusive.</li>
 * </ul>
 * If any of the validation conditions are not met, an {@link IllegalArgumentException} is thrown.
 * </p>
 */
public class TypedGamer {

    private String username;
    private int age;

    /**
     * Constructs a new {@code TypedGamer} with the specified username and age.
     * The constructor ensures that the username is not null or empty, and the age is between 12 and 100 inclusive.
     *
     * @param username the username of the gamer. It must not be {@code null} or empty.
     * @param age the age of the gamer. It must be between 12 and 100 inclusive.
     * @throws IllegalArgumentException if the {@code username} is {@code null} or empty, or if {@code age} is not between 12 and 100 inclusive.
     */
    public TypedGamer(String username, int age) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Field 'username' in TypedGamer cannot be null or empty.");
        }
        if (age < 12 || age > 100) {
            throw new IllegalArgumentException("Field 'age' in TypedGamer must be between 12 and 100.");
        }
        this.username = username;
        this.age = age;
    }
}