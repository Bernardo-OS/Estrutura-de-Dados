import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import Figura;

public static void main(String[] args) {
    List<Figura> lista_desejadas_pessoais = new ArrayList<>();
    List<Figura> lista_repetidas_pessoais = new ArrayList<>();
    List<Figura> lista_desejadas_outro = new ArrayList<>();
    List<Figura> lista_repetidas_outro = new ArrayList<>();
    Figura.alimentar_listas_csv(lista_repetidas_pessoais, lista_desejadas_pessoais, lista_repetidas_outro, lista_desejadas_outro);
    System.out.println("Menu:\r\n" + //
                "1-Cadastrar/listar figuras repitidas pessoais\r\n" + //
                "2-Cadastrar/listar figuras desejadas pessoais\r\n" + //
                "3-Cadastrar/listar figuras repitidas de outro + match\r\n" + //
                "4-Cadastrar/listar figuras desejadas de outro + match\r\n" + //
                "5-Sair\r\n" + //
                "Opcao:");
    Scanner opcao = new Scanner(System.in);

    // 
    do {
         switch (opcao.nextLine()) {
            case "1":
                cadastrar_repitidas_pessoais(lista_repetidas_pessoais);
                break;
            case "2":
                cadastrar_desejadas_pessoais(lista_desejadas_pessoais);
                break;
            case "3":
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Valor inválido: " + opcao.nextLine());
        }
    } while (!opcao.nextLine().equals("3"));
    opcao.close();
}
