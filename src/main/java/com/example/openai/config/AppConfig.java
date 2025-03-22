package com.example.openai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class AppConfig {

    @Value("classpath:/prompt.txt")
    private Resource resource;

    // ChatClient <---- OPEN_API_KEY ----> LLM(openai)
//    @Bean
//    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
//        return chatClientBuilder.build();
//    }
    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
        // System Message: LLM에 역할을 부여
        return chatClientBuilder
                // .defaultSystem("당신은 교육 튜터입니다. 개념을 명확하고 간단하게 설명하세요.")
                // .defaultSystem(resource)
                .build();
    }
}
