package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

//lombok

@Getter
@Setter

public class ApiResponseDTO {
	private String msg;
	private LocalDateTime timeStamp;

	public ApiResponseDTO(String msg) {
		this.msg = msg;
		this.timeStamp = LocalDateTime.now();

	}
}
