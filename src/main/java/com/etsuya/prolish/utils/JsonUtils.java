package com.etsuya.prolish.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtils {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	static {
		MAPPER.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
	}

	// 将对象转换为JSON字符串
	public static String toJson(Object object) {
		try {
			return MAPPER.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("对象->JSON转化异常", e);
		}
	}

	// 将JSON字符串转换为对象
	public static <T> T toObj(String json, Class<T> clazz) {
		try {
			return MAPPER.readValue(json, clazz);
		} catch (JsonProcessingException e) {
			throw new RuntimeException("JSON->对象转化异常", e);
		}
	}

}
