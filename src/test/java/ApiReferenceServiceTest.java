import com.tsubaka.query.service.ApiReferenceService;
import com.tsubaka.query.service.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext-test.xml"})
public class ApiReferenceServiceTest {
	@Autowired
	ApiReferenceService apiReferenceService;

	@Test
	public void validateIfPassedApisAreSupported() throws Exception {
		TestHelper.clearSystemProperties();
		System.setProperty("api", "imdb");
		assertThat(apiReferenceService.validateSupportedApis(), is(true));
		System.setProperty("api", "yahoo");
		assertThat(apiReferenceService.validateSupportedApis(), is(true));
	}

	@Test
	public void notValidateIfPassedApiIsNotSupported() throws Exception {
		TestHelper.clearSystemProperties();
		System.setProperty("api", "googlemovies");
		assertThat(apiReferenceService.validateSupportedApis(), is(false));
	}

	@Test
	public void notValidateIfNoApisArePassed() throws Exception {
		TestHelper.clearSystemProperties();
		assertThat(apiReferenceService.validateSupportedApis(), is(false));
	}

	@Test
	public void notValidateIfEmptyApiIsPassed() throws Exception {
		TestHelper.clearSystemProperties();
		System.setProperty("api", "");
		assertThat(apiReferenceService.validateSupportedApis(), is(false));
	}
}
