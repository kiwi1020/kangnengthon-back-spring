package com.hackathon.kangnengthon.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        String oauth2SchemeName = "OAuth2";

        //jwt를 위한 스웨거 테스트 코드임
        OAuthFlow authorizationCodeFlow = new OAuthFlow()
                .authorizationUrl("http://localhost:8080/oauth2/authorization/google")
                .tokenUrl("http://localhost:8080/api/token");

        OAuthFlows oauthFlows = new OAuthFlows()
                .authorizationCode(authorizationCodeFlow);

        SecurityScheme oauth2Scheme = new SecurityScheme()
                .name(oauth2SchemeName)
                .type(SecurityScheme.Type.OAUTH2)
                .flows(oauthFlows);

        SecurityScheme bearerScheme = new SecurityScheme()
                .name("bearerAuth")
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

        SecurityRequirement oauth2Requirement = new SecurityRequirement()
                .addList(oauth2SchemeName);
        SecurityRequirement bearerRequirement = new SecurityRequirement()
                .addList("bearerAuth");

        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes(oauth2SchemeName, oauth2Scheme)
                        .addSecuritySchemes("bearerAuth", bearerScheme))
                .addSecurityItem(oauth2Requirement)
                .addSecurityItem(bearerRequirement)
                .info(new Info().title("API Test").version("1.0"));
    }
}
