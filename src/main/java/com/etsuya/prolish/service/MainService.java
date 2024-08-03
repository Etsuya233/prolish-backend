package com.etsuya.prolish.service;

import com.etsuya.prolish.domain.SentenceOutput;
import com.etsuya.prolish.domain.SentenceUserAnswer;
import com.etsuya.prolish.domain.SentenceUserInput;

public interface MainService {
	SentenceOutput processSentence(SentenceUserAnswer sentenceUserAnswer);

	String generateSentence(SentenceUserInput sentenceUserInput);
}
