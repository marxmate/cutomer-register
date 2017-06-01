package validation;

public class PhoneNumberValidator extends Validator {

    private static final String PHONE_PATTERN =
            "\\d{2}\\(\\d{2}\\)(\\d+\\-)*\\d+|" + // 06(30)888-88-88, 06(30)8888888
                    "\\d{4}(\\d+\\-)*\\d+|" + // 06308888888, 0630888-88-88
                    "\\d{4}\\/(\\d+\\-)*\\d+|" + // 0630/888-88-88, 0630/8888888
                    "\\d{2}\\/(\\d+\\-)*\\d+"; // 06/30-888-888-8, 06/308888888

    public PhoneNumberValidator() {
        super(PHONE_PATTERN);
    }

    @Override
    public boolean validate(String validatable) {
        if (validatable.replaceAll("\\D", "").length() != 11){
            return false;
        } else {
            return super.validate(validatable);
        }
    }
}