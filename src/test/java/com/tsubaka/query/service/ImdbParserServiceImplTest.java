package com.tsubaka.query.service;

import com.tsubaka.query.serviceobject.Api;
import com.tsubaka.query.serviceobject.Result;
import com.tsubaka.query.serviceobject.ResultList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class ImdbParserServiceImplTest {

	@Mock
	RestTemplate restTemplate;

	@Mock
	Api api;

	@InjectMocks
	MovieParserService imdbMovieParser = new ImdbParserServiceImpl();

	@Before
	public void setup() {
		String url = "http://www.omdbapi.com/?s=";
		api.setUrl(url);
		initMocks(this);
	}
	@Test
	public void checkIfCorrectResponseIsReceivedFromApi() throws Exception {

		String movieName = "movieName";

		List<Result> resultList = new ArrayList<Result>();
		Result result = new Result();
		result.setTitle("Batman");
		resultList.add(result);
		ResultList resultListMockResponse = new ResultList();
		resultListMockResponse.setResultList(resultList);

		//= Mockito.mock(RestTemplate.class);
		ResponseEntity<ResultList> responseEntity = new ResponseEntity<ResultList>(resultListMockResponse, HttpStatus.OK);
		//ResponseEntity<ResultList> responseEntity = Mockito.mock(ResponseEntity.class);
		Mockito.when(restTemplate.getForEntity(this.api.getUrl(), ResultList.class, movieName)).thenReturn(responseEntity);
		//Mockito.when(responseEntity.getBody()).thenReturn(resultListMockResponse);

		ResultList resultResponse = imdbMovieParser.getMovieDetails(movieName);
		assertThat(resultResponse.getResultList().get(0).getTitle(), is("Batman"));
	}
}