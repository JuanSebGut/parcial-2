package co.edu.usco.pw.springboot_crud01.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@SuppressWarnings("deprecation")
@Configuration
public class SecurityConfiguration {

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .passwordEncoder(NoOpPasswordEncoder.getInstance())
            .withUser("user_admin").password("password").roles("RECTOR", "ADMIN")
            .and()
            .withUser("user_student").password("password").roles("ESTUDIANTE");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
            .antMatchers("/login", "/h2-console/**").permitAll() // Permitir acceso sin autenticación
            .antMatchers("/", "/add-todo", "/update-todo", "/delete-todo").hasAnyRole("RECTOR", "ADMIN") // Restringir acceso a las URLs de administración solo a usuarios con los roles 'RECTOR' o 'ADMIN'
            .antMatchers("/list-todos").hasRole("ESTUDIANTE") // Permitir acceso a la lista de 'Todo' solo para usuarios con el rol 'ESTUDIANTE'
            .anyRequest().authenticated() // Cualquier otra solicitud requiere autenticación
            .and().formLogin();

        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.build();
    }
}
