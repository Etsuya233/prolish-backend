package com.etsuya.prolish.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "ety.aliyun")
public class AliyunConstant {
	private String apiKey;
	private String sentenceAppId;
	private String sentenceGenerationAppId;
}
