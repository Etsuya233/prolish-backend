package com.etsuya.prolish.controller;

import com.etsuya.prolish.domain.R;
import com.etsuya.prolish.domain.SentenceOutput;
import com.etsuya.prolish.domain.SentenceUserAnswer;
import com.etsuya.prolish.domain.SentenceUserInput;
import com.etsuya.prolish.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

	private final MainService mainService;

	@PostMapping("/submitSentence")
	public R<SentenceOutput> userSubmitSentence(@RequestBody SentenceUserAnswer sentenceUserAnswer){
		SentenceOutput sentenceOutput = mainService.processSentence(sentenceUserAnswer);
		return R.ok(sentenceOutput);
	}

	@PostMapping("/getSentence")
	public R<String> sentenceGenerate(@RequestBody SentenceUserInput sentenceUserInput){
		String sentence = mainService.generateSentence(sentenceUserInput);
		return R.ok(sentence);
	}

}
