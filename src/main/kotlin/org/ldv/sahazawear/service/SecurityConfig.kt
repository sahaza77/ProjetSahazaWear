package org.ldv.sahazawear.service

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {

        http
            // ✅ RÉACTIVER LA PROTECTION CSRF

            .authorizeHttpRequests {
                it.requestMatchers(
                    "/SahazaWear/login",
                    "/css/**",
                    "/js/**",
                    "/img/**"
                ).permitAll()

                it.anyRequest().authenticated()
            }

            .formLogin {
                it.loginPage("/SahazaWear/login")
                it.loginProcessingUrl("/SahazaWear/login")
                it.defaultSuccessUrl("/SahazaWear/profil", true)
                it.failureUrl("/SahazaWear/login?error=true")
                it.permitAll()
            }

            .logout {
                it.logoutUrl("/logout")
                it.logoutSuccessUrl("/SahazaWear/login")
                it.permitAll()
            }

        return http.build()
    }
}