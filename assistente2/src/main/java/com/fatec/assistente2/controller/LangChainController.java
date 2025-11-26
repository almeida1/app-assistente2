package com.fatec.assistente2.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.assistente2.service.Assistant;

import dev.langchain4j.model.chat.ChatLanguageModel;

@RestController
@RequestMapping("/api")
public class LangChainController {

    @Autowired
    ChatLanguageModel chatLanguageModel;

    @Autowired
    Assistant assistant;
    //nao considera o contexto das mensagens
    //interage diretamente com um chatLanguageModel (que representa o LLM subjacente) 
    //para gerar uma resposta.
    @PostMapping("/chat-bot")
    public String chatBot(@RequestBody String message) {
    	System.out.println("Modelo selecionado - " + chatLanguageModel.toString());
        return chatLanguageModel.generate(message);
    }
    //no assistant é possivel guardar informacoes anteriores
    @PostMapping("/assistant")
    public String assistant(@RequestBody String message) {
    	System.out.println(">>>>>>  assistente");
        return assistant.chat(message, 1L);
    }

}