package com.example.demo.service;


import com.example.demo.pojo.ChatRequest;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatService {
    private final OpenAiService openAiService;

    public ChatService(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    public String getChatResponse(ChatRequest chatRequest) {
//        1. prepare chat message
        List<ChatMessage> messages = new ArrayList<>();
        messages.add(new ChatMessage("user", chatRequest.getMessage()));

//        2. Invoke open chat
        ChatCompletionRequest request = ChatCompletionRequest.builder()
                .model("gpt-3.5-turbo")
                .messages(messages)
                .build();

//        3.return the responses
        return openAiService.createChatCompletion(request)
                .getChoices().get(0)
                .getMessage().getContent();
    }
}
