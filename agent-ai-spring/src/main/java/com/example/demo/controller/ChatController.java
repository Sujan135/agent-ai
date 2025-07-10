package com.example.demo.controller;


import com.example.demo.pojo.ChatRequest;
import com.example.demo.pojo.ChatResponse;
import com.example.demo.service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest chatRequest) {
        String aiResponse = chatService.getChatResponse(chatRequest);
        return new ChatResponse(aiResponse);
    }
}
