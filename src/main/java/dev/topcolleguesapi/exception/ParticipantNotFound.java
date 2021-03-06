package dev.topcolleguesapi.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParticipantNotFound extends RuntimeException  {

	private static final long serialVersionUID = 3927628587334938043L;
	private static final Logger LOGGER = LoggerFactory.getLogger(ParticipantNotFound.class);

	public ParticipantNotFound() {

	}

	public ParticipantNotFound(String msg) {
		LOGGER.error(msg);
}
}
