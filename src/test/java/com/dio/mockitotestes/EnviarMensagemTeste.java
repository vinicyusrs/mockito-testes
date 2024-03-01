package com.dio.mockitotestes;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EnviarMensagemTeste {
	// Espiar mensagem
	@Spy
    EnviarMensagem enviarMensagem = new EnviarMensagem();

    @Test
    void verificarComportamentoDaClasse() {
    	Mockito.verifyNoInteractions(enviarMensagem);
    	
        Mensagem mensagem = new Mensagem("Hello World");

        enviarMensagem.adicionarMensagem(mensagem);

       // verify(enviarMensagem).adicionarMensagem(mensagem);
        Mockito.verify(enviarMensagem).adicionarMensagem(mensagem);
        
        Assertions.assertFalse(enviarMensagem.getMensagens().isEmpty());
        Assertions.assertEquals(1, enviarMensagem.getMensagens().size());
    }

}
