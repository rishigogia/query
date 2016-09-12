package com.tsubaka.query;

import com.tsubaka.query.service.ApiReferenceService;
import com.tsubaka.query.service.MovieParserService;
import com.tsubaka.query.service.VmArgsService;
import com.tsubaka.query.serviceobject.Result;
import com.tsubaka.query.serviceobject.ResultList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Query {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		Query query = new Query();
		ResultList resultList = new ResultList();

		VmArgsService vmArgsService = (VmArgsService) applicationContext.getBean("vmArgsService");
		ApiReferenceService apiReferenceService = (ApiReferenceService)applicationContext.getBean("apiReferenceService");
		if (vmArgsService.validateRequiredArguments()) {
			if (apiReferenceService.validateSupportedApis()) {
				switch (System.getProperty("api")) {
					case "imdb" :
						MovieParserService movieParserService =
								(MovieParserService)applicationContext.getBean("imdbMovieParser");
						resultList = movieParserService.getMovieDetails(System.getProperty("movie"));
						break;
				}

			} else {
				System.out.println("Given API is not supported");
			}
		} else {
			System.out.println("Correct Args not specified");
		}

		List<Result> movieList = resultList.getResultList();
		if (movieList != null && !movieList.isEmpty()) {
			for(Result movie:movieList) {
				System.out.println("Movie - Title: " + movie.getTitle() + ", Year: " + movie.getYear());
			}
		} else {
			System.out.println("No data found");
		}
	}
}
