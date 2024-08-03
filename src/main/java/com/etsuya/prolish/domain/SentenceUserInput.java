package com.etsuya.prolish.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SentenceUserInput {
	/**
	 * 是否口语化
	 */
	private String style;

	private String emotion;

	private String type;

	private Integer size;

	private String custom;
}
