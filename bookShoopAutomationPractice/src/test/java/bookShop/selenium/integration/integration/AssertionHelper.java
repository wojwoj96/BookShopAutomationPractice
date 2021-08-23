package bookShop.selenium.integration.integration;

import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AssertionHelper {

	private static final Logger logger = LoggerFactory.getLogger(AssertionHelper.class);
	
	public static void assertValidation(final List expected, final List actuall) {

        SoftAssertions.assertSoftly(softly -> {
            for (int i = 0; i < expected.size(); i++) {
                softly.assertThat(actuall.get(i)).as("Validation").isEqualTo(expected.get(i));
            }
        });
    }
	
	  public static void assertSimply(final Object expected, final Object actuall) {

	        SoftAssertions.assertSoftly(softly -> {
	            softly.assertThat(actuall).as("Validation").isEqualTo(expected);
	        });
	    }
}
