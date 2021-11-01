package com.sectordefectuoso.domino.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.*
import io.swagger.v3.oas.models.servers.Server
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringDocConfig {

    @Bean
    fun openApiConfig(): OpenAPI {
//            val scopes = Scopes()
//            scopes.addString("scopes xd", "deafult")
//            val oAuthFlow = OAuthFlow()
//            oAuthFlow.authorizationUrl("https://example.com/xxxxx/oauth2/v2.0/authorize")
//            oAuthFlow.scopes(scopes)
            return OpenAPI()
                .info(apiDetails())
//                .components(
//                    Components().addSecuritySchemes(
//                        "OAuth", SecurityScheme()
//                            .type(SecurityScheme.Type.OAUTH2)
//                            .scheme("bearer")
//                            .bearerFormat("jwt")
//                            .`in`(SecurityScheme.In.HEADER)
//                            .name("Authorization")
//                            .flows(
//                                OAuthFlows()
//                                    .implicit(oAuthFlow)
//                            )
//                    )
//                )
//                .addSecurityItem(SecurityRequirement().addList("OAuth"))
    }

    private fun apiDetails(): Info {
        return Info()
            .title("Domino Backend")
            .description("Backend para api de examenes de estudiantes")
            .version("0.0.2")
            .contact(
                Contact()
                    .name("Oscar Salcedo")
                    .email("sectordefectuoso@gmail.com")
                    .url("https://anti.click")
            )
    }
}