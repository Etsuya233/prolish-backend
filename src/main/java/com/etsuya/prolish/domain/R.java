package com.etsuya.prolish.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {
	private Integer code;
	private String msg;
	private T data;

	public static <T> R<T> ok(T data) {
		return new R<T>(200, "ok", data);
	}

	public static R<Void> ok() {
		return ok(null);
	}

	public static R<Void> fail(Integer code, String msg) {
		return new R<Void>(code, msg, null);
	}
}
