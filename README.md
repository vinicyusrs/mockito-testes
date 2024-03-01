# Estudo de Mockito - Projeto Mockito

Este é um projeto de estudo focado no uso do Mockito para testes unitários em Java. O Mockito é uma estrutura de teste de código aberto que permite a criação de objetos mock para simular o comportamento de objetos reais em testes unitários.

## Recursos do Mockito Utilizados

### Mock

O Mockito permite a criação de objetos mock, ou seja, objetos simulados que imitam o comportamento de objetos reais, facilitando o isolamento de unidades de código durante os testes.

### Stubbling (when, thenReturn, thenThrow)

Com o Mockito, podemos configurar comportamentos de objetos mock usando o método `when()`, seguido por métodos como `thenReturn()` para especificar o que o mock deve retornar quando um método é chamado, ou `thenThrow()` para indicar que uma exceção deve ser lançada.

Exemplo:

```java
// Criando um objeto mock
MeuObjetoMock objetoMock = Mockito.mock(MeuObjetoMock.class);

// Configurando um comportamento para o mock
Mockito.when(objetoMock.metodo()).thenReturn(valorRetorno);
