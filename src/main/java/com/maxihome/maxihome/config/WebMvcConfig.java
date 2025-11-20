package com.maxihome.maxihome.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 1. LocaleResolver: almacena el locale en la sesión de usuario.
     *    Arranca en español por defecto.
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("es"));
        return slr;
    }

    /**
     * 2. LocaleChangeInterceptor: permite cambiar el locale
     *    pasando ?lang=es o ?lang=en en cualquier URL.
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    /**
     * 3. Registramos el interceptor para que actúe en todas las peticiones.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    /**
     * 4. MessageSource: carga los ficheros messages_*.properties desde classpath.
     *    UTF-8 para caracteres especiales.
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("classpath:messages");
        ms.setDefaultEncoding("UTF-8");
        // Opcional: cada cuánto recargar (en segundos) si cambias los ficheros en caliente
        ms.setCacheSeconds(3600);
        return ms;
    }
}
