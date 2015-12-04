package com.haoqi.webapp.forly.exception;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class AppExceptionHandler implements HandlerExceptionResolver {

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception ex) {
		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter writer = response.getWriter();
			ERROR err;
			if (ex instanceof AppException) {
				err = ((AppException) ex).getError();
			} else {
				err = ERROR.ERR_SYS;
			}
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode json = mapper.createObjectNode();
			json.put("errorCode", err.getValue());
			json.put("errorMsg", err.getErrorMsg());
			writer.write(json.toString());
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ex.printStackTrace();
		return new ModelAndView("");
	}

}
