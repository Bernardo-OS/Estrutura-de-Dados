import java.util.ArrayList;
public class Principal {
    public static void main(String[] args) {
        //simulando matriz especial
        int dimensao = 10;
        int matriz[][] = new int[dimensao][dimensao];
        Matriz.inicializarMatriz(matriz, dimensao, dimensao);

        matriz[0][3] = 1;
        matriz[2][5] = 1;
        matriz[5][7] = 1;
        matriz[6][8] = 1;
        Matriz.exibirMatriz(matriz, dimensao, dimensão);

        //converter matriz em lista de dados
        ArrayList<Dado> lista = new ArrayList<>();
        Matriz.converterMatrizLista(matriz, dimensao, dimensao, lista);
        Matriz.exibirLista(lista);
    }
}