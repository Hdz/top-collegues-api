package dev.topcolleguesapi.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BadRequestException extends RuntimeException {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(BadRequestException.class);

	public BadRequestException() {

	}

	public BadRequestException(String msg) {
		LOGGER.error(msg);
}
}
