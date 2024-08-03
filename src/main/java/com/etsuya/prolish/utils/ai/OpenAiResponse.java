package com.etsuya.prolish.utils.ai;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OpenAiResponse {
	private String id;
	private String object;
	private long created;
	private String model;
	private Usage usage;
	private List<Choice> choices;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Usage {
		private int prompt_tokens;
		private int completion_tokens;
		private int total_tokens;
	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Choice {
		private Message message;
		private Object logprobs; // Assuming logprobs can be null or some object, you can change the type as needed
		private String finish_reason;
		private int index;

		@Data
		@NoArgsConstructor
		@AllArgsConstructor
		public static class Message {
			private String role;
			private String content;
		}
	}
}