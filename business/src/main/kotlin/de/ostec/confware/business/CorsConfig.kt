package de.ostec.confware.business

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class CorsConfig {
    private val log = LoggerFactory.getLogger(this::class.java)

    @Bean
    fun allow(@Value("\${api.cors.allowed-origins}") origin:String?): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(registry: CorsRegistry) {
                origin?.let {
                    if (it.trim().isNotEmpty()) {
                        log.info("Enable cors /** for $it")
                        registry.addMapping("/**").allowedOrigins(it)
                    }
                }
            }
        }
    }
}