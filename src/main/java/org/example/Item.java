package org.example;

import org.example.annotations.NotNull;
import org.example.annotations.StringLength;

/**
 * The {@code Item} class represents a product with a title and description.
 * It uses custom annotations to enforce validation constraints on the fields.
 * <p>
 * The {@link NotNull} annotation ensures that the {@code title} field cannot be {@code null}.
 * The {@link StringLength} annotation enforces a minimum and maximum length for the {@code description} field.
 * </p>
 */
public class Item {

    /**
     * The title of the product. Cannot be {@code null}.
     */
    @NotNull
    String title;

    /**
     * The description of the product. The length must be between 3 and 100 characters.
     */
    @StringLength(min = 3, max = 100)
    String description;

    /**
     * Constructs an {@code Item} with the specified title and description.
     *
     * @param title the title of the product
     * @param description the description of the product
     */
    public Item(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
