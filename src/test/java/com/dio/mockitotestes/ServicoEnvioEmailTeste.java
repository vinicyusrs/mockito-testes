package com.dio.mockitotestes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServicoEnvioEmailTeste {
	
	@Mock
    private PlataformaDeEnvio plataforma;

    @InjectMocks
    private ServicoEnvioEmail servico;

    @Captor
    private ArgumentCaptor<Email> emailCaptor;

    @Captor
    private ArgumentCaptor<Email> captor;
    @Test
    public void validaDadosEnviadosParaPlataforma() {

        String enderecoDoEmail = "usuario@provedor.com";
        String mensagem = "Mensagem de Teste 123";
        boolean ehFormaHtml = false;

        servico.enviaEmail(enderecoDoEmail, mensagem, ehFormaHtml);
        Mockito.verify(plataforma).enviaEmail(captor.capture());

        Email emailCapturado = captor.getValue();
        
        Assertions.assertEquals(enderecoDoEmail, emailCapturado.getEnderecoEmail());
        Assertions.assertEquals(mensagem, emailCapturado.getMensagem());
        Assertions.assertEquals(Formato.TEXTO, emailCapturado.getFormato());
    }
    
    
    @Test
    public void validaSeEmailEstaComDadosCorretos() {

        String email = "jose.alve@provedor.com";
        String mensagem = "Mensagem de Teste 123";

        servico.enviaEmail(email, mensagem, true);
        Mockito.verify(plataforma).enviaEmail(emailCaptor.capture());

        Email emailCapturado = emailCaptor.getValue();
        Assertions.assertEquals(Formato.HTML, emailCapturado.getFormato());
    }

}
