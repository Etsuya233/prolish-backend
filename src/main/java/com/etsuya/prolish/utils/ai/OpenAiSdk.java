package com.etsuya.prolish.utils.ai;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public interface OpenAiSdk {

	<T> T ai(OpenAiRequest openAiRequest, Class<T> responseType);

	String ai(OpenAiRequest openAiRequest);

	static OpenAiResponse sendRequest(RestTemplate restTemplate, String url, String token, OpenAiRequest body){
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAll(Map.of("Authorization", token));

		HttpEntity<OpenAiRequest> requestEntity = new HttpEntity<>(body, httpHeaders);

		ResponseEntity<OpenAiResponse> exchange = restTemplate.exchange(
				url,
				HttpMethod.POST,
				requestEntity,
				OpenAiResponse.class,
				Map.of()
		);

		return exchange.getBody();
	}

}