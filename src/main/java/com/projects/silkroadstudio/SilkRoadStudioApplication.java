package com.projects.silkroadstudio;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//created branch develop

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="SILKROAD STUDIO API"))
public class SilkRoadStudioApplication {

    public static void main(String[] args) {
        SpringApplication.run(SilkRoadStudioApplication.class, args);
    }

}
