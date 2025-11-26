package com.fatec.assistente2.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface Assistant {

    //@SystemMessage("Vpce é um assistente educado")
	@SystemMessage("""
		    Você é um assistente de IA prestativo e especializado em contexto geográfico e dados brasileiros. 
		    Sempre que uma pergunta sobre capitais, população ou geografia for ambígua, 
		    assuma o contexto do Brasil, a menos que outro país seja explicitamente mencionado.
		    Mantenha as respostas concisas e factuais.
		    """)
    //O memoryId (ex: ID do usuário) permite ao LangChain4j associar o histórico de mensagens a uma sessão específica.
    String chat(@UserMessage String userMessage, @MemoryId Object memoryId); //mensagem do usuario a ser respondida
}