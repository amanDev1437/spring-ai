package com.aman.ollama.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatClient chatClient;

//    public ChatController(ChatClient.Builder chatClientBuilder) {
//        this.chatClient =  chatClientBuilder.build();
//    }

    public ChatController(@Qualifier("ollamaChatClient") ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @RequestMapping("/chat")
    public String chat(@RequestParam String message){
        return chatClient.prompt(message).call().content();
    }
}
