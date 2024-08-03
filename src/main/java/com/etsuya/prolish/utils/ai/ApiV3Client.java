package com.etsuya.prolish.utils.ai;

import com.etsuya.prolish.config.ApiV3Config;
import com.etsuya.prolish.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ApiV3Client implements OpenAiSdk {

	private final RestTemplate restTemplate;
	private final ApiV3Config apiV3Config;
	private final String generalUrl = "https://api.gpt.ge/v1/chat/completions";

	@Override
	public <T> T ai(OpenAiRequest openAiRequest, Class<T> responseType) {
		OpenAiResponse openAiResponse = OpenAiSdk.sendRequest(restTemplate, generalUrl, apiV3Config.getKey(), openAiRequest);
		String content = openAiResponse.getChoices().getFirst().getMessage().getContent();
		return JsonUtils.toObj(content, responseType);
	}

	@Override
	public String ai(OpenAiRequest openAiRequest) {
		OpenAiResponse openAiResponse = OpenAiSdk.sendRequest(restTemplate, generalUrl, apiV3Config.getKey(), openAiRequest);
		return openAiResponse.getChoices().getFirst().getMessage().getContent();
	}
}
