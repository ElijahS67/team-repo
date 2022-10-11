package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import seedu.address.model.tag.Tag;

/**
 * Represents a mod in Mass Linkers.
 * Guarantees: immutable; name is valid as declared in {@link #isValidModName(String)}
 */
public class Mod {
    public static final String MESSAGE_CONSTRAINTS = "Mod names should be alphanumeric";
    public static final String VALIDATION_REGEX = "\\p{Alnum}+";

    public final String modName;

    /**
     * Constructs a {@code Mod}.
     *
     * @param modName A valid mod name.
     */
    public Mod(String modName) {
        requireNonNull(modName);
        checkArgument(isValidModName(modName), MESSAGE_CONSTRAINTS);
        this.modName = modName;
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidModName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Tag // instanceof handles nulls
                && modName.equals(((Tag) other).tagName)); // state check
    }

    @Override
    public int hashCode() {
        return modName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + modName + ']';
    }
}
