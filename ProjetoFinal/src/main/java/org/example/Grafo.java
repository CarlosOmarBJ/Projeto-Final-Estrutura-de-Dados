package org.example;

import java.util.*;

class Grafo {
    private Map<Integer, List<Aresta>> adjacencias;
    private int numVertices;

    public Grafo() {
        adjacencias = new HashMap<>();
        numVertices = 0;
    }

    public void inserirVertice(int id) {
        if (!adjacencias.containsKey(id)) {
            adjacencias.put(id, new ArrayList<>());
            numVertices++;
        }
    }

    public void inserirAresta(int origem, int destino, int peso) {
        adjacencias.computeIfAbsent(origem, k -> new ArrayList<>()).add(new Aresta(destino, peso));
        adjacencias.computeIfAbsent(destino, k -> new ArrayList<>()).add(new Aresta(origem, peso));
    }

    public void removerVertice(int id) {
        adjacencias.values().forEach(list -> list.removeIf(aresta -> aresta.destino == id));
        adjacencias.remove(id);
        numVertices--;
    }

    public void removerAresta(int origem, int destino) {
        adjacencias.getOrDefault(origem, new ArrayList<>()).removeIf(aresta -> aresta.destino == destino);
        adjacencias.getOrDefault(destino, new ArrayList<>()).removeIf(aresta -> aresta.destino == origem);
    }

    public void visualizarGrafo() {
        for (Map.Entry<Integer, List<Aresta>> entry : adjacencias.entrySet()) {
            System.out.print("Vértice " + entry.getKey() + ": ");
            for (Aresta aresta : entry.getValue()) {
                System.out.print("-> " + aresta.destino + " (peso: " + aresta.peso + ") ");
            }
            System.out.println();
        }
    }

    public int informarGrau(int id) {
        return adjacencias.containsKey(id) ? adjacencias.get(id).size() : -1;
    }

    public boolean verificarConexo() {
        if (numVertices == 0) return true;

        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> fila = new LinkedList<>();
        Integer primeiroVertice = adjacencias.keySet().iterator().next();
        fila.add(primeiroVertice);
        visitados.add(primeiroVertice);

        while (!fila.isEmpty()) {
            int atual = fila.poll();
            for (Aresta aresta : adjacencias.get(atual)) {
                if (!visitados.contains(aresta.destino)) {
                    visitados.add(aresta.destino);
                    fila.add(aresta.destino);
                }
            }
        }
        return visitados.size() == numVertices;
    }

    public int[][] converterParaMatrizAdjacencia() {
        int[][] matriz = new int[numVertices][numVertices];
        for (int[] linha : matriz) {
            Arrays.fill(linha, 0);
        }

        for (Map.Entry<Integer, List<Aresta>> entry : adjacencias.entrySet()) {
            int origem = entry.getKey();
            for (Aresta aresta : entry.getValue()) {
                matriz[origem][aresta.destino] = aresta.peso;
            }
        }
        return matriz;
    }

    public void buscaEmLargura(int inicio) {
        Queue<Integer> fila = new LinkedList<>();
        Set<Integer> visitados = new HashSet<>();
        fila.add(inicio);
        visitados.add(inicio);

        while (!fila.isEmpty()) {
            int atual = fila.poll();
            System.out.print(atual + " ");

            for (Aresta aresta : adjacencias.get(atual)) {
                if (!visitados.contains(aresta.destino)) {
                    visitados.add(aresta.destino);
                    fila.add(aresta.destino);
                }
            }
        }
        System.out.println();
    }

    public void buscaEmProfundidade(int inicio) {
        Set<Integer> visitados = new HashSet<>();
        buscaEmProfundidadeRecursivo(inicio, visitados);
        System.out.println();
    }

    private void buscaEmProfundidadeRecursivo(int vertice, Set<Integer> visitados) {
        visitados.add(vertice);
        System.out.print(vertice + " ");

        for (Aresta aresta : adjacencias.get(vertice)) {
            if (!visitados.contains(aresta.destino)) {
                buscaEmProfundidadeRecursivo(aresta.destino, visitados);
            }
        }
    }

    public Map<Integer, Integer> caminhoMinimoDijkstra(int inicio) {
        Map<Integer, Integer> distancias = new HashMap<>();
        PriorityQueue<Aresta> fila = new PriorityQueue<>(Comparator.comparingInt(a -> a.peso));

        for (Integer vertice : adjacencias.keySet()) {
            distancias.put(vertice, Integer.MAX_VALUE);
        }
        distancias.put(inicio, 0);
        fila.add(new Aresta(inicio, 0));

        while (!fila.isEmpty()) {
            Aresta aresta = fila.poll();
            int u = aresta.destino;

            for (Aresta vizinho : adjacencias.get(u)) {
                int novaDistancia = distancias.get(u) + vizinho.peso;
                if (novaDistancia < distancias.get(vizinho.destino)) {
                    distancias.put(vizinho.destino, novaDistancia);
                    fila.add(new Aresta(vizinho.destino, novaDistancia));
                }
            }
        }

        return distancias;
    }

    public Set<Aresta> arvoreGeradoraMinimaPrim(int inicio) {
        Set<Aresta> arvore = new HashSet<>();
        PriorityQueue<Aresta> fila = new PriorityQueue<>(Comparator.comparingInt(a -> a.peso));
        Set<Integer> visitados = new HashSet<>();

        visitados.add(inicio);
        for (Aresta aresta : adjacencias.get(inicio)) {
            fila.add(aresta);
        }

        while (!fila.isEmpty()) {
            Aresta aresta = fila.poll();
            if (visitados.contains(aresta.destino)) continue;

            visitados.add(aresta.destino);
            arvore.add(aresta);

            for (Aresta vizinho : adjacencias.get(aresta.destino)) {
                if (!visitados.contains(vizinho.destino)) {
                    fila.add(vizinho);
                }
            }
        }

        return arvore;
    }
}
