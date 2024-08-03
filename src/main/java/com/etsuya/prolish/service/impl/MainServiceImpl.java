package com.etsuya.prolish.service.impl;

import com.alibaba.dashscope.app.Application;
import com.alibaba.dashscope.app.ApplicationParam;
import com.alibaba.dashscope.app.ApplicationResult;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.etsuya.prolish.config.AliyunConstant;
import com.etsuya.prolish.domain.SentenceOutput;
import com.etsuya.prolish.domain.SentenceUserAnswer;
import com.etsuya.prolish.domain.SentenceUserInput;
import com.etsuya.prolish.service.MainService;
import com.etsuya.prolish.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

//@Service
@Slf4j
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {

	private final AliyunConstant aliyunConstant;

	@Override
	public SentenceOutput processSentence(SentenceUserAnswer sentenceUserAnswer) {
		String resJson = getStringFromAI(sentenceUserAnswer, aliyunConstant.getSentenceAppId());

		SentenceOutput sentenceOutput = JsonUtils.toObj(resJson, SentenceOutput.class);

		return sentenceOutput;
	}

	@Override
	public String generateSentence(SentenceUserInput sentenceUserInput) {
		String string = getStringFromAI(sentenceUserInput, aliyunConstant.getSentenceGenerationAppId());

		return string;
	}

	private String getStringFromAI(Object userInput, String appId){
		String prompt = JsonUtils.toJson(userInput);

		ApplicationParam param = ApplicationParam.builder()
				.appId(appId)
				.apiKey(aliyunConstant.getApiKey())
				.prompt(prompt)
				.build();

		ApplicationResult call = null;

		try {
			call = new Application().call(param);
		} catch (NoApiKeyException | InputRequiredException e) {
			throw new RuntimeException(e);
		}

		return call.getOutput().getText();
	}
}
