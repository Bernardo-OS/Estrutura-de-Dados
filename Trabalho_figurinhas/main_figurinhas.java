import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class main_figurinhas {
    public static void main(String[] args) {
        List<Figura> lista_desejadas_pessoais = new ArrayList<>();
        List<Figura> lista_repetidas_pessoais = new ArrayList<>();
        List<Figura> lista_desejadas_outro = new ArrayList<>();
        List<Figura> lista_repetidas_outro = new ArrayList<>();

        Figura.alimentar_listas_csv(
            lista_repetidas_pessoais,
            lista_desejadas_pessoais,
            lista_repetidas_outro,
            lista_desejadas_outro
        );

        //Controle com try para garantir que o Scanner seja fechado corretamente
        try (Scanner opcao = new Scanner(System.in)) {
            String escolha;

            do {
                System.out.println("Menu:\r\n" +
                        "1-Cadastrar/listar figuras repitidas pessoais\r\n" +
                        "2-Cadastrar/listar figuras desejadas pessoais\r\n" +
                        "3-Mostrar match de figuras desejadas pessoais com repetidas do outro, e repitidas pessoais com desejadas do outro\r\n" +
                        "4-Registrar troca (retirar um registro de desejada, e outro de repetida pessoal)\r\n" +
                        "5-Sair\r\n" +
                        "Opcao:");

                escolha = opcao.nextLine();

                switch (escolha) {
                    case "1":
                        Figura.cadastrar_repetidas_pessoais(lista_repetidas_pessoais);
                        break;
                    case "2":
                        Figura.cadastrar_desejadas_pessoais(lista_desejadas_pessoais);
                        break;
                    case "3":
                        Figura.mostrar_match(lista_desejadas_pessoais, lista_repetidas_outro, lista_repetidas_pessoais, lista_desejadas_outro);
                        break;
                    case "4":
                        Figura.registrar_troca(lista_desejadas_pessoais, lista_repetidas_pessoais);
                        break;
                    case "5":
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Valor inválido: " + escolha);
                }
            } while (!"5".equals(escolha));
        }
    }
}
