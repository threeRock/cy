package io.jianxun.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jianxun.extend.service.BusinessException;
import io.jianxun.rest.vo.ReturnVo;
import io.jianxun.rest.vo.ReturnVo.ErrorMessage;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ReturnVo<ErrorMessage> processValidationError(BindException ex) {
		ex.printStackTrace();
		BindingResult result = ex.getBindingResult();
		return processFieldError(result.getFieldErrors());
	}

	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ReturnVo<ErrorMessage> processServcieExcptionError(BusinessException ex) {
		ex.printStackTrace();
		return ReturnVo.businessError(ex.getMessage());
	}
	
	
	
	@ExceptionHandler(BadCredentialsException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ReturnVo<ErrorMessage> handleBadCredentialsException(BadCredentialsException ex) {
		ex.printStackTrace();
		return ReturnVo.badCredentialsError(ex.getMessage());
	}

	@ExceptionHandler(AccessDeniedException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ReturnVo<ErrorMessage> handleAccessDeniedException(AccessDeniedException ex) {
		ex.printStackTrace();
		return ReturnVo.accessError(ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ReturnVo<ErrorMessage> processExcptionError(Exception ex) {
		ex.printStackTrace();
		return ReturnVo.error("系统未处理异常", ex.getMessage());
	}

	private ReturnVo<ErrorMessage> processFieldError(List<FieldError> errors) {
		ReturnVo<ErrorMessage> rv = null;
		if (errors != null && errors.size() > 0) {
			StringBuilder sb = new StringBuilder();
			for (FieldError error : errors) {
				String msg = error.getDefaultMessage();
				sb.append(msg);

			}
			rv = ReturnVo.bindError(sb.toString());
		}
		return rv;
	}

}
