package org.example;

import org.example.annotations.MaxValue;
import org.example.annotations.MinValue;
import org.example.annotations.NotNull;

/**
 * The {@code Gamer} class represents a gamer with a username and age.
 * It uses custom annotations to enforce validation constraints on the fields.
 * <p>
 * The {@link NotNull} annotation ensures that the {@code username} field cannot be {@code null}.
 * The {@link MinValue} and {@link MaxValue} annotations enforce a minimum and maximum age for the {@code age} field, respectively.
 * </p>
 */
public class Gamer {

    /**
     * The username of the gamer. Cannot be {@code null}.
     */
    @NotNull
    String username;

    /**
     * The age of the human. The value must be between 12 and 100 (inclusive).
     */
    @MinValue(12)
    @MaxValue(100)
    int age;

    /**
     * Constructs a {@code Gamer} with the specified username and age.
     *
     * @param username the username of the gamer
     * @param age the age of the gamer
     */
    public Gamer(String username, int age) {
        this.username = username;
        this.age = age;
    }
}