package com.dio.mockitotestes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ApiDosCorreiosTeste {
	
	   @Mock
	    private ApiDosCorreios apiDosCorreios;

	    @Test
	    void retornaObjetoQuandoEspecificoValorEhPassado() {
	        when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenReturn(null);

	        DadosLocalizacao dadosLocalizacao = apiDosCorreios.buscaDadosComBaseNoCep("161761");

	        assertNull(dadosLocalizacao);
	    }

	    @Test
	    void retornaObjetoQuandoEspecificoValorEhPassado2() {
	        when(apiDosCorreios.buscaDadosComBaseNoCep("78787878")).thenReturn(new DadosLocalizacao("AM", "Manaus", "Rua Grajaúna", "casa", "Lago Azul"));

	        DadosLocalizacao dadosLocalizacao = apiDosCorreios.buscaDadosComBaseNoCep("78787878");

	        assertEquals("AM", dadosLocalizacao.getUf());
	    }

}
