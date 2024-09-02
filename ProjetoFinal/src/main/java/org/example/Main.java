package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grafo grafo = new Grafo();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Inserir Vértice");
            System.out.println("2. Inserir Aresta");
            System.out.println("3. Remover Vértice");
            System.out.println("4. Remover Aresta");
            System.out.println("5. Visualizar Grafo");
            System.out.println("6. Informar Grau de um Vértice");
            System.out.println("7. Verificar se o Grafo é Conexo");
            System.out.println("8. Converter para Matriz de Adjacência");
            System.out.println("9. Busca em Largura");
            System.out.println("10. Busca em Profundidade");
            System.out.println("11. Caminho Mínimo (Dijkstra)");
            System.out.println("12. Árvore Geradora Mínima (Prim)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID do vértice: ");
                    int idVertice = scanner.nextInt();
                    grafo.inserirVertice(idVertice);
                    break;
                case 2:
                    System.out.print("Digite o ID do vértice de origem: ");
                    int origem = scanner.nextInt();
                    System.out.print("Digite o ID do vértice de destino: ");
                    int destino = scanner.nextInt();
                    System.out.print("Digite o peso da aresta: ");
                    int peso = scanner.nextInt();
                    grafo.inserirAresta(origem, destino, peso);
                    break;
                case 3:
                    System.out.print("Digite o ID do vértice a ser removido: ");
                    int verticeRemover = scanner.nextInt();
                    grafo.removerVertice(verticeRemover);
                    break;
                case 4:
                    System.out.print("Digite o ID do vértice de origem: ");
                    int origemAresta = scanner.nextInt();
                    System.out.print("Digite o ID do vértice de destino: ");
                    int destinoAresta = scanner.nextInt();
                    grafo.removerAresta(origemAresta, destinoAresta);
                    break;
                case 5:
                    grafo.visualizarGrafo();
                    break;
                case 6:
                    System.out.print("Digite o ID do vértice: ");
                    int verticeGrau = scanner.nextInt();
                    int grau = grafo.informarGrau(verticeGrau);
                    if (grau == -1) {
                        System.out.println("Vértice não encontrado.");
                    } else {
                        System.out.println("Grau do vértice " + verticeGrau + ": " + grau);
                    }
                    break;
                case 7:
                    System.out.println("O grafo é conexo? " + grafo.verificarConexo());
                    break;
                case 8:
                    int[][] matriz = grafo.converterParaMatrizAdjacencia();
                    MatrizAdjacenciaPanel.mostrarMatrizAdjacencia(matriz);
                    break;
                case 9:
                    System.out.print("Digite o ID do vértice inicial: ");
                    int inicioBFS = scanner.nextInt();
                    System.out.print("Ordem do Caminho em Largura: ");
                    grafo.buscaEmLargura(inicioBFS);
                    break;
                case 10:
                    System.out.print("Digite o ID do vértice inicial: ");
                    int inicioDFS = scanner.nextInt();
                    System.out.print("Ordem do Caminho em Profundidade: ");
                    grafo.buscaEmProfundidade(inicioDFS);
                    break;
                case 11:
                    System.out.print("Digite o ID do vértice inicial: ");
                    int inicioDijkstra = scanner.nextInt();
                    Map<Integer, Integer> distancias = grafo.caminhoMinimoDijkstra(inicioDijkstra);
                    System.out.println("Distâncias mínimas a partir do vértice " + inicioDijkstra + ": " + distancias);
                    break;
                case 12:
                    System.out.print("Digite o ID do vértice inicial: ");
                    int inicioPrim = scanner.nextInt();
                    Set<Aresta> arvore = grafo.arvoreGeradoraMinimaPrim(inicioPrim);
                    System.out.println("Arestas da Árvore Geradora Mínima: " + arvore);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
