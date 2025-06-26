package hello.grademanager;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("성적 조회 서비스")
                .version("0.0.1")
                .description("<h3></h3>");
        return new OpenAPI().info(info);
    }
}
