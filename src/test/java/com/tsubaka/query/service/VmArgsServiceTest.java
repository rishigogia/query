package com.tsubaka.query.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext-test.xml"})
public class VmArgsServiceTest {

	@Autowired
	VmArgsService vmArgsService;

	@Test
	public void validateIfAllRequiredVMArgsAreSupplied() {
		TestHelper.clearSystemProperties();
		System.setProperty("api", "imdb");
		System.setProperty("movie", "movieName");
		assertThat(vmArgsService.validateRequiredArguments(), is(true));
	}

	@Test
	public void notValidateIfNoneOfRequiredVMArgsAreSupplied() {
		TestHelper.clearSystemProperties();
		assertThat(vmArgsService.validateRequiredArguments(), is(false));
	}

	@Test
	public void notValidateIfOnlyOneRequiredVMArgsAreSupplied() {
		TestHelper.clearSystemProperties();
		System.setProperty("api", "imdb");
		assertThat(vmArgsService.validateRequiredArguments(), is(false));
	}
}