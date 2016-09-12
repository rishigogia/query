package com.tsubaka.query.service;

import com.tsubaka.query.serviceobject.ResultList;
import org.springframework.stereotype.Service;

@Service("movieParserService")
public interface MovieParserService {

	ResultList getMovieDetails(String movieName);
}
