# Estudo de Mockito - Projeto Mockito - Spring Boot(Java)

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

Verify
O método verify() do Mockito é usado para verificar se um método em um objeto mock foi chamado com os argumentos corretos durante o teste

// Verificando se um método foi chamado
Mockito.verify(objetoMock).metodo(argumento);

Captor
O captor (ArgumentCaptor) é usado para capturar argumentos passados para métodos de objetos mock durante os testes, permitindo a verificação desses argumentos.
// Criando um captor
ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

// Capturando argumentos
Mockito.verify(objetoMock).metodo(captor.capture());

// Obtendo o valor capturado
String argumentoCapturado = captor.getValue();

Mockito-inline
O mockito-inline é uma extensão do Mockito que permite o uso de anotações @Mock, @Spy, @Captor diretamente no código de teste sem a necessidade de inicialização manual.
// Usando a anotação @Mock
@Mock
MeuObjetoMock objetoMock;

// Inicializando os mocks
@Before
public void setUp() {
    MockitoAnnotations.initMocks(this);
}
```
Este `README.md` fornece uma visão geral do projeto, explica os recursos do Mockito utilizados e como executar os testes. Espero que isso te ajude!
