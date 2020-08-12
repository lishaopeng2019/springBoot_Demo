package com.spring.demo.framework.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description: Swagger-ui 界面基本信息配置
 * @Author: Super
 * @CreateDate: 2020/7/14 22:02
 * @Version: 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.pathMapping("/")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.spring.demo.controller")) // 接口类路径
				.paths(PathSelectors.any())
				.build().apiInfo(new ApiInfoBuilder()
						.title("SpringBoot整合Swagger")
						.description("使用Swagger来管理rest接口")
						.version("2.0")
						.build());
	}
}
