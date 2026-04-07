import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class FichaAtendimento {
    /**
     * método de classes gera ficha normal
     * @param filaNormal - fila de fichas não prioritária
     * @param contadoNormal - fila de fichas prioritarias
     * @return
     */
    public static int geraFichaNormal(Queue<Integer> filaNormal, int contadorNormal) {
        System.out.print("Imprimindo ficha normal.... ");
        System.out.println(contadorNormal);
        filaNormal.offer(contadorNormal);
        contadorNormal++;
        return contadorNormal;
    }
    /** */
    public static int geraFichaPrioritaria(Queue<Integer> filaPrioritaria, int contadorPrioritario) {
        System.out.print("Imprimindo ficha normal.... ");
        System.out.println(contadorPrioritario);
        filaPrioritaria.offer(contadorPrioritario);
        contadorPrioritario++;
        return contadorPrioritario;
    }
    /**
     * método para gerar atendimento
     * @param filaNormal
     * @param filaPrioritaria
     * @param 
     */
    public static int geraAtendimento(Queue<Integer> filaPrioritaria, Queue<Integer> filaNormal, int contadorAtendimentos) {
       if (filaNormal.isEmpty() && filaPrioritaria.isEmpty()) {
        System.out.println("Nao ha fichas para chamar"):
        return contadorAtendimentos;
       }

    }
    public static void mostraFichasFaltantes(Queue<Integer> filaNormal, Queue<Integer> filaPrioritaria){
        if (filaNormal.isEmpty() && filaPrioritaria.isEmpty()) {
            System.out.println("ao ha fichas para chamar");
            return;
        }
        System.out.println("Mostrando fichas faltantes.... ");
        if (!filaNormal.isEmpty()) {
            System.out.println("Total de fichas faltantes: " + filaNormal.size() + " - " + filaNormal);
        }
        if (!filaPrioritaria.isEmpty()) {
            System.out.println("Total de fichas faltantes: " + filaNormal.size() + " - " + filaNormal);
        }
    }
    /**
     * método para gerenciar menu
     * @param filaNormal
     * @param filaPrioritaria
     */
    public static void menu(Queue<Integer> filaNormal, Queue<Integer> filaPrioritaria){
        String opcao = "";
        Scanner teclado = new Scanner(System.in);
        int contadorNormal = 1;
        int contadorPrioritario = 501;
        int contadorAtendimentos = 0; 

        do {
            System.out.println("M E N U");
            System.out.println("1 - Ficha normal");
            System.out.println("2 - Ficha prioritaria");
            System.out.println("3 - Chamar ficha");
            System.out.println("4 - Mostrar fichas faltantes");
            System.out.println("5 - Sair");
            System.out.print("Opcao: ");
            opcao = teclado.nextLine();

            switch (opcao) {
                case "1":
                    contadorNormal = geraFichaNormal(filaNormal, contadorNormal);
                    break;
                case "2":
                    contadorPrioritario = geraFichaPrioritaria(filaPrioritaria, contadorPrioritario);
                    break;
                case "3":
                    contadorAtendimentos = geraAtendimento(filaNormal, filaPrioritaria, contadorAtendimentos);
                    break;
                case "4":
                    mostrarFichasFaltantes(filaNormal, filaPrioritaria);
                    break;
                case "5":
                    System.out.println("Obrigado por usar o programa.... ");
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while (!opcao.equals("5"));
    }

    public static void main(String[] args) {
        Queue<Integer> filaNormal = new LinkedList<>();
        Queue<Integer> filaPrioritaria = new LinkedList<>();

        menu(filaNormal, filaPrioritaria);
    }
}
 