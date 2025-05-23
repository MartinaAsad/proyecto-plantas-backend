package com.martina.plantas.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
public class LoginExitosoHandler extends SimpleUrlAuthenticationSuccessHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginExitosoHandler.class);
    
    
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
	    //InfoUsuarioDTO user = (InfoUsuarioDTO) authentication;

	    response.setCharacterEncoding("UTF-8");
	    response.setContentType("application/json");  // Asegura que el contenido sea JSON
	    response.setStatus(HttpServletResponse.SC_OK);

	    // Enviar datos en JSON
	    //response.getWriter().write("{\"nombre\":\"" + user.getNombre() + "\", \"apellido\":\"" + user.getApellido() + "\"}");
	    response.getWriter().flush();
	    LOGGER.info("Usuario logueado correctamente");
	}
}
