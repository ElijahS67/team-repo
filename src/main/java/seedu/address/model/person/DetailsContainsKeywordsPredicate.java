package seedu.address.model.person;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code Person}'s {@code Details} matches any of the keywords given.
 */
public class DetailsContainsKeywordsPredicate implements Predicate<Person> {
    private final List<String> keywords;

    public DetailsContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Person person) {

        boolean isPerson = false;

        if (person.getPhone() != null) {
            isPerson = isPerson || keywords.stream().anyMatch(
                    keyword -> StringUtil.containsPartialWordIgnoreCase(person.getPhone().toString(), keyword));
        }

        if (person.getEmail() != null) {
            isPerson = isPerson || keywords.stream().anyMatch(
                    keyword -> StringUtil.containsPartialWordIgnoreCase(person.getEmail().toString(), keyword));
        }

        if (person.getGitHub() != null) {
            isPerson = isPerson || keywords.stream().anyMatch(
                    keyword -> StringUtil.containsPartialWordIgnoreCase(person.getGitHub().username, keyword));
        }

        return isPerson
                || keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(person.getName().fullName, keyword))
                || keywords.stream()
                .anyMatch(keyword -> StringUtil.containsPartialWordIgnoreCase(person.getTelegram().toString(), keyword)
                );
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DetailsContainsKeywordsPredicate // instanceof handles nulls
                && keywords.equals(((DetailsContainsKeywordsPredicate) other).keywords)); // state check
    }

}