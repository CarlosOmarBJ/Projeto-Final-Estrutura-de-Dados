Vou atualizar o README para incluir todas as funcionalidades do projeto.

---

# Projeto de Grafos em Java

## Visão Geral

Este projeto implementa um sistema de manipulação e visualização de grafos em Java, desenvolvido no IntelliJ IDEA. O foco principal é fornecer ferramentas para análise de grafos, incluindo a verificação de conectividade, cálculo de caminhos mínimos, determinação do grau de vértices, e visualização da árvore geradora mínima. A representação visual do grafo é gerada como uma imagem, oferecendo uma interface gráfica simples para o usuário.

## Funcionalidades

1. **Verificação de Conectividade**: Determina se o grafo é conexo, ou seja, se existe um caminho entre qualquer par de vértices.

2. **Caminho Mínimo (Dijkstra)**: Calcula o menor caminho entre dois vértices em um grafo ponderado.

3. **Informar Grau de um Vértice**: Exibe o grau de um vértice específico, que é o número de arestas conectadas a ele.

4. **Visualização da Árvore Geradora Mínima (Prim)**: Gera e exibe a árvore geradora mínima do grafo, utilizando o algoritmo de Prim. A visualização é renderizada como uma imagem gráfica.

5. **Adicionar Vértice**: Permite a adição de novos vértices ao grafo.

6. **Adicionar Aresta**: Permite a adição de novas arestas ao grafo, conectando dois vértices existentes.

7. **Remover Vértice**: Remove um vértice específico do grafo, junto com todas as arestas conectadas a ele.

8. **Remover Aresta**: Remove uma aresta específica do grafo, desconectando os vértices associados.

9. **Obter Vizinhança de um Vértice**: Exibe os vértices adjacentes (vizinhos) de um vértice específico.

10. **Verificar Ciclos**: Determina se o grafo contém ciclos, ou seja, se há um caminho fechado dentro do grafo.

11. **Listar Componentes Conexos**: Identifica e lista os diferentes componentes conexos do grafo.

12. **Visualização do Grafo Completo**: Exibe a representação gráfica completa do grafo, incluindo todos os vértices e arestas.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal utilizada para o desenvolvimento do projeto.
- **Swing**: Biblioteca gráfica utilizada para criar a interface gráfica (GUI) do projeto.
- **IntelliJ IDEA**: Ambiente de Desenvolvimento Integrado (IDE) utilizado para o desenvolvimento e depuração do projeto.

## Estrutura do Projeto

- **Aresta.java**: Implementação da classe `Aresta`, que representa uma aresta no grafo.
- **Grafo.java**: Implementação da classe `Grafo`, que contém a lógica para manipulação do grafo, incluindo a adição de vértices e arestas, e a execução dos algoritmos de Dijkstra e Prim.
- **GrafoPanel.java**: Implementação da interface gráfica para visualização do grafo.
- **Main.java**: Classe principal que inicializa a aplicação e gerencia a interação do usuário com o sistema.

## Como Executar

1. **Clone o Repositório**: 
   ```bash
   git clone <URL_DO_REPOSITORIO>
   ```
2. **Abra o Projeto no IntelliJ IDEA**: 
   - Abra o IntelliJ IDEA e selecione a opção "Open" para abrir o diretório do projeto.
   
3. **Execute a Classe Principal**: 
   - Navegue até a classe `Main.java` e execute-a.

## Recursos Adicionais

- [Documentação do Java](https://docs.oracle.com/javase/8/docs/api/)
- [Tutoriais de Java no Oracle](https://www.oracle.com/java/technologies/javase-tutorials.html)
- [Referência da Biblioteca Swing](https://docs.oracle.com/javase/8/docs/technotes/guides/swing/)

---

Este README agora reflete todas as funcionalidades do projeto. Caso precise de mais alguma modificação, estou à disposição!
