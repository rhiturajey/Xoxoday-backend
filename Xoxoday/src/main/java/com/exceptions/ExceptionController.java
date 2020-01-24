package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {



	/*
	 * Customized Method to handle an exception when NotFound exception is raised
	 * i.e. when  a record is not found in the database
	 */
	@ExceptionHandler(NotFound.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public @ResponseBody ErrorMessage exception(NotFound nfe)
	{
		ErrorMessage err=new ErrorMessage();
		err.setMessage(nfe.getMessage());
		return err;
	}
	/*
	 * Customized Method to handle an exception when an exception is raised
	 *  apart from NotFound Exception and DuplicateValue Exception
	 */
	@ExceptionHandler
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorMessage exception2(Exception e)
	{
		ErrorMessage err=new ErrorMessage();
		err.setMessage(e.getMessage());
		return err;
	}
}
