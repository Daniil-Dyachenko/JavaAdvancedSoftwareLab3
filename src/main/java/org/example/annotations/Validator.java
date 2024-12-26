package org.example.annotations;

import java.lang.reflect.Field;

/**
 * The {@code Validator} class provides a method to validate fields of an object
 * based on custom annotations.
 * <p>
 * The validation checks for various constraints like {@link NotNull}, {@link StringLength},
 * {@link MaxValue}, and {@link MinValue}.
 * </p>
 */
public class Validator {

    /**
     * Validates the fields of the specified object based on the annotations present
     * on those fields.
     *
     * @param obj the object to be validated
     * @throws Exception if any validation fails
     */

    public static void validate(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(obj);

            if (field.isAnnotationPresent(NotNull.class)) {
                validateNotNull(field, value);
            }
            if (field.isAnnotationPresent(StringLength.class)) {
                if (value instanceof String strValue) {
                    validateStringLength(field, strValue, field.getAnnotation(StringLength.class));
                } else {
                    throw new IllegalStateException(getErrorMessage(field, "is not of type String for @StringLength."));
                }
            }
            if (field.isAnnotationPresent(MaxValue.class) || field.isAnnotationPresent(MinValue.class)) {
                if (value instanceof Integer intValue) {
                    if (field.isAnnotationPresent(MaxValue.class)) {
                        validateMaxValue(field, intValue, field.getAnnotation(MaxValue.class));
                    }
                    if (field.isAnnotationPresent(MinValue.class)) {
                        validateMinValue(field, intValue, field.getAnnotation(MinValue.class));
                    }
                } else {
                    throw new IllegalStateException(getErrorMessage(field, "is not of type Integer for numeric validation."));
                }
            }
        }
    }

    /**
     * Validates that the specified field value is not {@code null}.
     *
     * @param field the field to be checked
     * @param value the value of the field
     * @throws IllegalArgumentException if the field value is {@code null}
     */

    private static void validateNotNull(Field field, Object value) {
        if (value == null) {
            throw new IllegalArgumentException(getErrorMessage(field, "cannot be null."));
        }
    }

    /**
     * Validates that the length of the specified string value falls within the
     * bounds defined by the {@link StringLength} annotation.
     *
     * @param field the field to be checked
     * @param value the string value of the field
     * @param annotation the {@link StringLength} annotation with the constraints
     * @throws IllegalArgumentException if the string length is outside the defined range
     */

    private static void validateStringLength(Field field, String value, StringLength annotation) {
        if (value.length() < annotation.min() || value.length() > annotation.max()) {
            throw new IllegalArgumentException(getErrorMessage(field, "must have length between "
                    + annotation.min() + " and " + annotation.max() + "."));
        }
    }

    /**
     * Validates that the specified integer value does not exceed the maximum value
     * defined by the {@link MaxValue} annotation.
     *
     * @param field the field to be checked
     * @param value the integer value of the field
     * @param annotation the {@link MaxValue} annotation with the constraint
     * @throws IllegalArgumentException if the integer value exceeds the maximum value
     */

    private static void validateMaxValue(Field field, int value, MaxValue annotation) {
        if (value > annotation.value()) {
            throw new IllegalArgumentException(getErrorMessage(field, "must be less than or equal to " + annotation.value() + "."));
        }
    }

    /**
     * Validates that the specified integer value is not less than the minimum value
     * defined by the {@link MinValue} annotation.
     *
     * @param field the field to be checked
     * @param value the integer value of the field
     * @param annotation the {@link MinValue} annotation with the constraint
     * @throws IllegalArgumentException if the integer value is less than the minimum value
     */

    private static void validateMinValue(Field field, int value, MinValue annotation) {
        if (value < annotation.value()) {
            throw new IllegalArgumentException(getErrorMessage(field, "must be greater than or equal to " + annotation.value() + "."));
        }
    }

    /**
     * Constructs an error message indicating that the specified field in the given class
     * failed validation with the provided reason.
     *
     * @param field the field that failed validation
     * @param reason the reason for the validation failure
     * @return a detailed error message
     */

    private static String getErrorMessage(Field field, String reason) {
        return "Field '" + field.getName() + "' in class " + field.getDeclaringClass().getSimpleName() + " " + reason;
    }
}
