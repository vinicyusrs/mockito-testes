package com.dio.mockitotestes;

// se colocar essas classes como estatico não precisa ficar escrevendo Mockito antes de chamar por exemplo Mockito.assertEquals
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {

/*
 *  ABRIR MOCKITO DE OUTRA FORMA alem do @ExtendWith(MockitoExtension.class)
 * @BeforeAll
 * void setUp(){
 * 		MockitoAnnotations.initMocks(this);
 * private ApiDosCorreios apiDosCorreioss = Mockito.mock(ApiDosCorreios.class);
 * }
 */
	  
   @Mock
   private ApiDosCorreios apiDosCorreios;

   @InjectMocks
	private CadastrarPessoa cadastrarPessoa;
	
	@Test
	void cadastrarPessoa() {
	
	    DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("MG", "Uberaba", "Rua Castro Alves", "Casa", "Nova Floresta");
	    // AO INVEZ DE CADASTRAR ALGO EM DADOSLOCALIZÃO INSERI EM MOCK ABAIXO 
		Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenReturn(dadosLocalizacao);
		Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("2545854554")).thenReturn(dadosLocalizacao);
		
		Pessoa jose = cadastrarPessoa.cadastrarPessoa("José", "28578527976", LocalDate.of(1947, 1, 15), "69317300");
		
		DadosLocalizacao enderecoJose = jose.getEndereco();
		assertEquals(dadosLocalizacao.getBairro(), enderecoJose.getBairro());
		assertEquals(dadosLocalizacao.getCidade(), enderecoJose.getCidade());
		assertEquals(dadosLocalizacao.getUf(), enderecoJose.getUf());
		
		
		assertEquals("Nova Floresta", enderecoJose.getBairro());
		assertEquals("Uberaba", enderecoJose.getCidade());
		assertEquals("MG", enderecoJose.getUf());
		assertEquals("Casa", enderecoJose.getComplemento());
		
	}

	@Test
	void lancarExceptionQuandoChamarApiDosCorreios() {
	
	    DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("MG", "Uberaba", "Rua Castro Alves", "Casa", "Nova Floresta");
	    // AO INVEZ DE CADASTRAR ALGO EM DADOSLOCALIZÃO INSERI EM MOCK ABAIXO 
//		Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenReturn(dadosLocalizacao);
//		Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("2545854554")).thenReturn(dadosLocalizacao);
		
	    // quando rodar a chamada ele lança exception
	    Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenThrow(IllegalArgumentException.class);
	    Assertions.assertThrows(IllegalArgumentException.class, () -> cadastrarPessoa.cadastrarPessoa("José", "28578527976", LocalDate.of(1947, 1, 15), "69317300"));
	    //outra forma de lançar exceção
	    Mockito.doThrow(IllegalArgumentException.class)
	    		.when(apiDosCorreios)
	    			.buscaDadosComBaseNoCep(anyString());
	    
	    
		//returna Null
	    Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenReturn(null);
		Pessoa joseNullTeste = cadastrarPessoa.cadastrarPessoa("José", "28578527976", LocalDate.of(1947, 1, 15), "69317300");
		assertNull(joseNullTeste.getEndereco());
		
		
		Pessoa joseTeste = cadastrarPessoa.cadastrarPessoa("José", "28578527976", LocalDate.of(1947, 1, 15), "69317300");
		DadosLocalizacao enderecoJose = joseTeste.getEndereco();
		assertEquals(dadosLocalizacao.getBairro(), enderecoJose.getBairro());
		assertEquals(dadosLocalizacao.getCidade(), enderecoJose.getCidade());
		assertEquals(dadosLocalizacao.getUf(), enderecoJose.getUf());
		
		
		assertEquals("Nova Floresta", enderecoJose.getBairro());
		assertEquals("Uberaba", enderecoJose.getCidade());
		assertEquals("MG", enderecoJose.getUf());
		assertEquals("Casa", enderecoJose.getComplemento());
		
	}
	
	@Test
	void tentaCadastrarPessoaMasSistemaDosCorreiosFalha() {
	
		//
	    Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenThrow(RuntimeException.class);
	
	    Assertions.assertThrows(RuntimeException.class, () -> cadastrarPessoa.cadastrarPessoa("José", "28578527976", LocalDate.of(1947, 1, 15), "69317300"));
	}
	}
