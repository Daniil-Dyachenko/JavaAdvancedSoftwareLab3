package org.example;

/**
 * The {@code TypedItem} class represents an item with a title and a description.
 * It ensures that the title is not null or empty, and that the description is within the length range of 3 to 100 characters.
 * <p>
 * The constructor performs validation on the input parameters:
 * <ul>
 *     <li>{@code title} must be a non-null and non-empty string.</li>
 *     <li>{@code description} must have a length between 3 and 100 characters inclusive.</li>
 * </ul>
 * If any of the validation conditions are not met, an {@link IllegalArgumentException} is thrown.
 * </p>
 */
public class TypedItem {

    private String title;
    private String description;

    /**
     * Constructs a new {@code TypedItem} with the specified title and description.
     * The constructor ensures that the title is not null or empty, and that the description length is between 3 and 100 characters inclusive.
     *
     * @param title the title of the item. It must not be {@code null} or empty.
     * @param description the description of the item. It must have a length between 3 and 100 characters inclusive.
     * @throws IllegalArgumentException if the {@code title} is {@code null} or empty, or if {@code description} has a length less than 3 or greater than 100 characters.
     */
    public TypedItem(String title, String description) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Field 'title' in TypedItem cannot be null or empty.");
        }
        if (description == null || description.length() < 3 || description.length() > 100) {
            throw new IllegalArgumentException("Field 'description' in TypedItem must have length between 3 and 100.");
        }
        this.title = title;
        this.description = description;
    }
}
