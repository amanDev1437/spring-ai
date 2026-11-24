package com.aman.ollama.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/multi")
public class MultiModelChatController {

    //private final ChatClient openAiChatClient;
    private final ChatClient ollamaChatClient;

    public MultiModelChatController(/*@Qualifier("openAiChatClient") ChatClient openAiChatClient,*/ @Qualifier("ollamaChatClient") ChatClient ollamaChatClient) {
        //this.openAiChatClient = openAiChatClient;
        this.ollamaChatClient = ollamaChatClient;
    }

//    @GetMapping("/openai/chat")
//    public String openAiChat(@RequestParam String message){
//        return openAiChatClient.prompt(message).call().content();
//
//    }


    @GetMapping("/ollama/chat")
    public String ollamaChatClient(@RequestParam String message){
        return ollamaChatClient.prompt(message).call().content();
    }
}
