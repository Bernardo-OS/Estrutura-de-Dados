import java.util.Scanner;

public static void main(String[] args) {
    alimentar_listas_csv(lista_repetidas_pessoais, lista_desejadas_pessoais, lista_repetidas_outro, lista_desejadas_outro);

    List<Clima> lista_desejadas_pessoais = new ArrayList<>();
    List<Clima> lista_repetidas_pessoais = new ArrayList<>();
    List<Clima> lista_desejadas_outro = new ArrayList<>();
    List<Clima> lista_repetidas_outro = new ArrayList<>();
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
