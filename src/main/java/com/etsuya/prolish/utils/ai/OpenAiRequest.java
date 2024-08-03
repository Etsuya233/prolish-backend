package com.etsuya.prolish.utils.ai;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenAiRequest {
	private String model;
	private List<Message> messages;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Message {
		private String role;
		private String content;

		public static Message of(String role, String content) {
			return new Message(role, content);
		}
	}

	public static OpenAiRequest make(String model, Message... messages) {
		return new OpenAiRequest(model, Arrays.asList(messages));
	}
}
