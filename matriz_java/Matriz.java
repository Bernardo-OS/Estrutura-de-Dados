import Java.util.ArrayList;

public class Matriz {
    /**
     * método de classe que inicializa uma matriz de inteiros
     * @param matriz - matriz de inteiros a ser inicializada
     * @param qtdL - quantidade de linhas
     * @param qtdC - quantidade de colunas
     */
    public static void inicializarMatriz(int matriz[][], int qtdL, int qtdC) {
        for (int i = 0; i < qtdL; i++) {
            for (int j = 0; j < qtdC; j++) {
                matriz[i][j] = 0;
            }
        }
    }
    /**
     * método de classe que exibe uma matriz de inteiros
    * @param matriz - matriz de inteiros a ser exibida
     * @param qtdL - quantidade de linhas
     * @param qtdC - quantidade de colunas
     */
    public static void exibirMatriz(int matriz[][], int qtdL, int qtdC) {
        for (int i = 0; i < qtdL; i++) {
            for (int j = 0; j < qtdC; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
    /**
    * método de classe que converte matriz em lista de dado
    * @param matriz - matriz de inteiros a ser exibida
    * @param qtdL - quantidade de linhas
    * @param qtdC - quantidade de colunas
    * @param lista - lista de dados lin e col
    */
    public static void converterMatrizLista(int matriz[][], int qtsL, int qtdC, ArrayList<Data> Lista) {
        for (int i = 0; i < qtdL; i++) {
            for (int j = 0; j < qtdC; j++) {
                if (matriz[i][j] != 0) {
                    lista.add(new Dado(matriz[i][j], i,j));
                }
            }
        }
    }

    public static void exibirLista(ArrayList<Dado> lista) {
        for (Dado item : lista) {
            Systema.out.println(item);
        }
        System.out.println("---------------");
        System.out.println("Total de elementos nao nulos :" + lista.size());
    }
}