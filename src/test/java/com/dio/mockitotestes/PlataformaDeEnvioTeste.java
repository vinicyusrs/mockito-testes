package com.dio.mockitotestes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class PlataformaDeEnvioTeste {

	@Mock
    private PlataformaDeEnvio plataformaDeEnvio;

    @Test
    void tentaEnviarEmailEFalha() {
        Mockito.doThrow(IllegalStateException.class)
                .when(plataformaDeEnvio)
                .enviaEmail(Mockito.any());

        Assertions.assertThrows(IllegalStateException.class, () -> plataformaDeEnvio.enviaEmail(new Email("teste@teste.org", "Teste", Formato.TEXTO)));
    }
}
