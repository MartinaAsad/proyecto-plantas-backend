package com.martina.plantas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;

@Configuration
public class LoginFallidoHandler extends SimpleUrlAuthenticationFailureHandler {
	 private static final Logger LOGGER = LoggerFactory.getLogger(LoginFallidoHandler.class);
	    
	    @Override
	    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
	        response.getWriter().write("/");
	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	              response.getWriter().write("{\"error\": \"Error de autenticación del Failure Handler: " + exception.getMessage() + "\"}"+" mail ingresado:"+request.getParameter("mail"));
	        LOGGER.equals(exception.getMessage());
	         
	    }
}
