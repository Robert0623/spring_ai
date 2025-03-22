package com.example.openai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String chat(String message) {
        return chatClient.prompt() // 프롬프트 생성
                .user(message) // 사용자 메시지
                .call() // ai model 호출
                .content(); // ChatResponse에서 문자열로 요청 정보를 받는 부분
    }

    public String chatmessage(String message) {
        return chatClient.prompt() // 프롬프트 생성
                .user(message) // 사용자 메시지
                .call() // ai model 호출
                .chatResponse() // ChatResponse
                .getResult()
                .getOutput()
                .getText(); // getContent -> getText로 변경됨
    }
}
