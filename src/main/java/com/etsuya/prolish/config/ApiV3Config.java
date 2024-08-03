package com.etsuya.prolish.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("ety.apiv3")
@Data
public class ApiV3Config {

	private String key;

}
