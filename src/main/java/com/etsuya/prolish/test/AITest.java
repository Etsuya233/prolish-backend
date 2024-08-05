package com.etsuya.prolish.test;

import com.alibaba.dashscope.app.Application;
import com.alibaba.dashscope.app.ApplicationParam;
import com.alibaba.dashscope.app.ApplicationResult;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.etsuya.prolish.config.AliyunConstant;
import com.etsuya.prolish.utils.ai.ApiV3Client;
import com.etsuya.prolish.utils.ai.OpenAiRequest;
import org.springframework.beans.factory.annotation.Autowired;

public class AITest {

	@Autowired
	private AliyunConstant aliyunConstant;
	@Autowired
	private ApiV3Client apiV3Client;

	public void test1() throws NoApiKeyException, InputRequiredException {
		ApplicationParam param = ApplicationParam.builder()
				.appId("e0e4a026a01e4edeadbb14a84e907ed7")
				.apiKey("sk-1ffedea80dd04b338160722bc659c630")
				.prompt("{ \"original\": \"当没有 error 字段，可以取 data.total_tokens 作为计算结果\", \"translation\": \"You can used the fields 'data.total_tokens' as caculation result when there's no field 'error'.\"}")
				.build();

		Application application = new Application();
		ApplicationResult result = application.call(param);

		System.out.printf("requestId: %s, text: %s, finishReason: %s\n",
				result.getRequestId(), result.getOutput().getText(), result.getOutput().getFinishReason());
	}

	public void test2(){
		String apiKey = aliyunConstant.getApiKey();
		System.out.println(apiKey);
	}

	public void test3(){
		OpenAiRequest user = OpenAiRequest.make("gpt-4o-mini", OpenAiRequest.Message.of("user", "世界是什么？"));
		String ai = apiV3Client.ai(user);
		System.out.println(ai);
	}
}
