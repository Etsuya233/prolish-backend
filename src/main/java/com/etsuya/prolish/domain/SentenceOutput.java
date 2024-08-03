package com.etsuya.prolish.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SentenceOutput {
	private Double completeness;

	// 将 accuracy 作为一个嵌套对象
	private Accuracy accuracy;

	private Double fluency;

	private Double naturalness;

	private String optimizedTranslation;

	private String naturalTranslation;

	private Double total;

	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Accuracy {
		private Double score; // 直接映射 score
		private Boolean valid; // 直接映射 valid
		private Analysis analysis; // 将 analysis 作为一个对象

		@Data
		@JsonIgnoreProperties(ignoreUnknown = true)
		public static class Analysis {
			private List<DataEntry> data; // List<DataEntry> 表示分析数据

			@Data
			@JsonIgnoreProperties(ignoreUnknown = true)
			public static class DataEntry {
				private String position;
				private String title;
				private String reason;
			}
		}
	}
}