package org.example.matchlive.configurations

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
open class SpringSecurityConfig {
    @Bean
    open fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {

        http.csrf().disable().authorizeHttpRequests { authorize ->
            authorize.requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/api/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll()
        }
            .httpBasic { }
            .formLogin { form ->
                form
                    .defaultSuccessUrl("/admin/matches", true)
                    .permitAll() }
        return http.build()
    }

    @Autowired
    open fun configureGlobal(auth : AuthenticationManagerBuilder) {
        val encoder = BCryptPasswordEncoder()

            auth.inMemoryAuthentication()
            .passwordEncoder(encoder)
            .withUser("User")
            .password(encoder.encode("User"))
            .roles("USER")
            .and()
            .withUser("Admin")
            .password(encoder.encode("Admin"))
            .roles("ADMIN")
    }
}