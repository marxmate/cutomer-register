import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import validation.EmailAddressValidator;

public class EmailAddressValidatorTest {

    private static EmailAddressValidator emailAddressValidator;


    @BeforeClass
    public static void init() {
        emailAddressValidator = new EmailAddressValidator();
    }


    @Test
    public void ValidEmailTest() {

        String[] validEmails = new String[]{"mm@yahoo.com",
                "mm@yahoo.com", "mm.100@yahoo.com",
                "mm@mm.com", "mm-100@mm.net",
                "mm.100@mm.com.au", "mm@1.com",
                "mm@gmail.com.com", "mm+100@gmail.com",
                "mm-100@yahoo-test.com"};

        for (String temp : validEmails) {
            boolean valid = emailAddressValidator.validate(temp);
            System.out.println("Email is valid : " + temp + " , " + valid);
            Assert.assertEquals(valid, true);
        }

    }

    @Test
    public void InValidEmailTest() {

        String[] inValidEmails = new String[]{"mm", "mm@.com.my",
                "mm123@gmail.a", "mm123@.com", "mm123@.com.com",
                ".mm@mm.com", "mm()*@gmail.com", "mm@%*.com",
                "mm..2002@gmail.com", "mm.@gmail.com",
                "mm@mm@gmail.com", "mm@gmail.com.1a", "  "};

        for (String temp : inValidEmails) {
            boolean valid = emailAddressValidator.validate(temp);
            System.out.println("Email is invalid : " + temp + " , " + valid);
            Assert.assertEquals(valid, false);
        }
    }
}