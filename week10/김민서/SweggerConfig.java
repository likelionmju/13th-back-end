package com.example.demo;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
@Tag(name = "ContactAPI", description = "주소록 관리 API")
public class SweggerConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("Contact API")
                .version("0.0.1")
                .description("<h3>Contact Service Swagger</h3>");

        return new OpenAPI()
                .info(info);
    }
}
