package com.farkalit.demo.web.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.farkalit.demo.exceptions.CustomResourceNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class BaseResource {

	protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	private final static ObjectMapper objectMapper = new ObjectMapper();

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleControllerException(Exception ex) throws CustomResourceNotFoundException {
		LOGGER.info(ex.getMessage());
		throw new CustomResourceNotFoundException(ex.getMessage(), ex);
	}

	public ObjectNode createObjectNode() {
		return objectMapper.createObjectNode();
	}
}
