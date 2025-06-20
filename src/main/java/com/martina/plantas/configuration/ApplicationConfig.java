
package com.martina.plantas.configuration;

import com.martina.plantas.exception.UsuarioErrorException;
import com.martina.plantas.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Martina
 */
@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
    private final UsuarioRepository usuarioRepository;
    
      @Bean
    public UserDetailsService userDetailsService() {
        return username -> usuarioRepository.findByMail(username)
                .orElseThrow(() -> new UsuarioErrorException("Usuario no encontrado"));
    }

    /**
     * Bean que proporciona un codificador de contraseñas para encriptar y comparar contraseñas.
     *
     * @return BCryptPasswordEncoder que utiliza el algoritmo de hashing bcrypt.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Bean que proporciona un proveedor de autenticación que utiliza los servicios de usuario y codificador de contraseñas.
     *
     * @return DaoAuthenticationProvider configurado con UserDetailsService y PasswordEncoder.
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());

        return provider;
    }

    /**
     * Bean que proporciona el administrador de autenticación para la configuración de Spring Security.
     *
     * @param configuration Configuración de autenticación para obtener el administrador de autenticación.
     * @return AuthenticationManager obtenido de la configuración de autenticación.
     * @throws Exception Si hay un error al obtener el administrador de autenticación.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
    
}
