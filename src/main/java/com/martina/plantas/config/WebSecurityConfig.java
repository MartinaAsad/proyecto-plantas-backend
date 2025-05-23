package com.martina.plantas.config;

import jakarta.servlet.http.HttpServletResponse;
import com.martina.plantas.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity
//@CrossOrigin
public class WebSecurityConfig {

    @Value("${cors.origins}")
    private String[] corsOrigins;

    @Autowired
    private LoginExitosoHandler loginExitosoHandler;
    @Autowired
    private LogoutExitosoHandler logoutExitosoHandler;
    @Autowired
    private LoginFallidoHandler loginFallidoHandler;
    @Autowired
    private UsuarioAuthenticationProvider usuarioAuthenticationProvider;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                 //.requestMatchers("api/usuario/crearMateria").permitAll()    
                .requestMatchers("/api/usuario/**").permitAll() // Rutas protegidas
                   
                .requestMatchers("/login").permitAll() // Permitir acceso a login sin autenticación
            )
            .cors(withDefaults()) // Habilitar CORS usando la configuración de WebMvcConfigurer
            .formLogin(form -> form.loginProcessingUrl("/login")
                .successHandler( this.loginExitosoHandler)
                .failureHandler( this.loginFallidoHandler)
                .permitAll())
            .authenticationProvider(this.usuarioAuthenticationProvider)
            .exceptionHandling(exception -> exception
                .authenticationEntryPoint((request, response, authException) -> {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.setContentType("application/json");
                    response.getWriter().write("{\"error\": \"No está autenticado o la sesión ha expirado.\"}" + authException.getMessage());
                })
                .accessDeniedHandler((request, response, accessDeniedException) -> {
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    response.setContentType("application/json");
                    response.getWriter().write("{\"error\": \"Acceso denegado.\"}");
                })
            )
            .logout(logout -> logout.logoutUrl("/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(this.logoutExitosoHandler))
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
            .httpBasic(withDefaults()) // Habilitar autenticación HTTP básica
            .csrf(csrf -> csrf.disable()); // Deshabilitar CSRF

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        //.allowedOrigins(corsOrigins)
                        .allowedOrigins("http://localhost:3000")
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
