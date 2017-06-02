package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    protected Pattern pattern;
    protected Matcher matcher;

    public Validator(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public boolean validate(final String validatable) {

        matcher = pattern.matcher(validatable);
        return matcher.matches();
    }
}