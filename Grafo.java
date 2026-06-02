class Grafo {
    int matrizADJ[][];
    int qtdVertices;

    public Grafo(int qtdVertices) {
        this.qtdVertices = qtdVertices;
        this.matrizADJ = new int[qtdVertices][qtdVertices];

        for (int i = 0; i < qtdVertices; i++) {
            for (int j = 0; j < qtdVertices; j++) {
                this.matrizADJ[i][j] = 0;
            }
        }
    }

    void mostrarMatriz() {
        for (int i = 0; i < this.qtdVertices; i++) {
            System.out.print("   " + i);
        }
        System.out.println();

        for (int i = 0; i < this.qtdVertices; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < this.qtdVertices; j++) {
                System.out.print(this.matrizADJ[i][j] + "   ");
            }
            System.out.println();
        }
    }

    void mostrarGrafo() {
        for (int i = 0; i < this.qtdVertices; i++){
            System.out.print(i + ": ");
            for (int j = 0; j < this.qtdVertices; j++) {
                if (this.matrizADJ[i][j] == 1) {
                    System.out.print(j + "   ");
                }
            }
            System.out.println();
        }
    }

    void inserirAresta(int origem, int destino) {
        if (this.matrizADJ[origem][destino] == 0) {
            this.matrizADJ[origem][destino] = 1;
        }
    }

    void inserirArestaSimetrica(int origem, int destino) {
        if (this.matrizADJ[origem][destino] == 0 && this.matrizADJ[destino][origem] == 0) {
            this.matrizADJ[origem][destino] = 1;
            this.matrizADJ[destino][origem] = 1;
        }
    }

    int grau(int vertice) {
        int total = 0;
        for (int i = 0; i < this.qtdVertices; i++) {
            total = total + this.matrizADJ[vertice][i];
            total = total + this.matrizADJ[i][vertice];
        }

        return total;
    }
}

public class Grafos {
    public static void main(String[] args) {
        // Grafo g1 = new Grafo(4);

        // g1.inserirAresta(0,1);
        // g1.inserirAresta(0,3);
        // g1.inserirAresta(1,2);
        // g1.inserirAresta(2,3);
        // g1.inserirAresta(3,0);
        // g1.inserirAresta(3,1);
        // g1.inserirAresta(3,2);

        // g1.mostrarMatriz();
        
        // System.out.println();
        
        // g1.mostrarGrafo();

        Grafo g2 = new Grafo(4);
        g2.inserirArestaSimetrica(0,1);
        g2.inserirArestaSimetrica(0, 2);
        g2.inserirArestaSimetrica(1, 2);
        g2.inserirArestaSimetrica(1, 3);
        g2.inserirArestaSimetrica(2, 3);
        g2.mostrarGrafo();

        System.out.println("Grau do vértice 0: " + g2.grau(0));
    }
}
