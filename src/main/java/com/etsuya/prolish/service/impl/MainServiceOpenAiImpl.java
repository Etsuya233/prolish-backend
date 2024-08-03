package com.etsuya.prolish.service.impl;

import com.etsuya.prolish.config.Constants;
import com.etsuya.prolish.domain.SentenceOutput;
import com.etsuya.prolish.domain.SentenceUserAnswer;
import com.etsuya.prolish.domain.SentenceUserInput;
import com.etsuya.prolish.service.MainService;
import com.etsuya.prolish.utils.JsonUtils;
import com.etsuya.prolish.utils.ai.ApiV3Client;
import com.etsuya.prolish.utils.ai.OpenAiRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainServiceOpenAiImpl implements MainService {
	private final ApiV3Client apiV3Client;

	@Override
	public SentenceOutput processSentence(SentenceUserAnswer sentenceUserAnswer) {
		OpenAiRequest openAiRequest = new OpenAiRequest("gpt-4o-mini",
				List.of(OpenAiRequest.Message.of("system", Constants.AiPrompt.sentenceJudgement),
						OpenAiRequest.Message.of("user", JsonUtils.toJson(sentenceUserAnswer))));
		SentenceOutput output = apiV3Client.ai(openAiRequest, SentenceOutput.class);
		output.setTotal(output.getAccuracy().getScore() * 0.3 + output.getCompleteness() * 0.3
				+ output.getFluency() * 0.2 + output.getNaturalness() * 0.2);

		return output;
	}

	@Override
	public String generateSentence(SentenceUserInput sentenceUserInput) {
		OpenAiRequest openAiRequest = new OpenAiRequest("gpt-4o-mini",
				List.of(OpenAiRequest.Message.of("system", Constants.AiPrompt.sentenceGenerate),
						OpenAiRequest.Message.of("user", JsonUtils.toJson(sentenceUserInput))));
		return apiV3Client.ai(openAiRequest);
	}
}
