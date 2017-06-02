import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import validation.PhoneNumberValidator;

public class PhoneNumberValidatorTest {
    private static PhoneNumberValidator phoneNumberValidator;


    @BeforeClass
    public static void init() {
        phoneNumberValidator = new PhoneNumberValidator();
    }


    @Test
    public void ValidPhoneNumberTest() {

        String[] validPhoneNumbers = new String[]{"06308888888",
                "06308888-888", "0630888-88-88",
                "06/308888888", "06/308888-888",
                "06/3088-88-888", "0630/8888888",
                "0630/888-88-88", "06(30)8888888",
                "06(30)88-88888", "06(30)888-88-88"};

        for (String temp : validPhoneNumbers) {
            boolean valid = phoneNumberValidator.validate(temp);
            System.out.println("Phone number is valid : " + temp + " , " + valid);
            Assert.assertEquals(valid, true);
        }

    }

    @Test
    public void InValidPhoneNumberTest() {

        String[] invalidPhoneNumbers = new String[]{"0630888888", "0630888tr8888",
                "06/30/8888888", ".213412", "06 30 888 88 88",
               };

        for (String temp : invalidPhoneNumbers) {
            boolean valid = phoneNumberValidator.validate(temp);
            System.out.println("Phone number invalid : " + temp + " , " + valid);
            Assert.assertEquals(valid, false);
        }
    }
}
