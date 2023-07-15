package com.api.e_commerce.core.exceptions;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.e_commerce.core.BusinessException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	ProblemDetail produtoInexistenteException(BusinessException e) {

		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(e.status, e.getMessage());

		problemDetail.setTitle(e.title);
		problemDetail.setDetail(e.detail);
		return problemDetail;
	}

}
