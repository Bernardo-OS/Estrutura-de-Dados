import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

/**
 * Anotação lógica para peso de figurinhas:
 * Bronze: 2 Roxas
 * Prata: 5 Roxas || 2.5 Bronzes
 * Ouro: 10 Roxas || 6 Bronzes || 2 Pratas
 */

public class Figura {
    private String nomeFigura;
    private int numeroFigura;
    private String descricao;
    private boolean rara;

    public Figura(String nomeFigura, int numeroFigura, String descricao, boolean rara) {
        this.nomeFigura = nomeFigura;
        this.numeroFigura = numeroFigura;
        this.descricao = descricao;
        this.rara = rara;
    }

    public String getNomeFigura() {
        return nomeFigura;
    }

    public int getNumeroFigura() {
        return numeroFigura;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isRara() {
        return rara;
    }

    /**
     * Alimenta as listas a partir dos arquivos CSV correspondentes.
     * @param lista_repetidas_pessoais
     * @param lista_desejadas_pessoais
     * @param lista_repetidas_outro
     * @param lista_desejadas_outro
     */
    public static void alimentar_listas_csv(List<Figura> lista_repetidas_pessoais, List<Figura> lista_desejadas_pessoais, List<Figura> lista_repetidas_outro, List<Figura> lista_desejadas_outro) {
        carregarCsv("figuras_repetidas_pessoais.csv", lista_repetidas_pessoais);
        carregarCsv("figuras_desejadas_pessoais.csv", lista_desejadas_pessoais);
        carregarCsv("figuras_repetidas_outro.csv", lista_repetidas_outro);
        carregarCsv("figuras_desejadas_outro.csv", lista_desejadas_outro);
    }

    /**
     * Lógica para cadastrar figuras desejadas pessoais, exibindo as já cadastradas, fazendo leitura por meio do scanner 
     * para novos registros, e depois salva no CSV para atualizar os resitros.
     * @param lista_desejadas_pessoais
     */
    public static void cadastrar_desejadas_pessoais(List<Figura> lista_desejadas_pessoais) {
        for (Figura figura : lista_desejadas_pessoais) {
            System.out.println("Figura: " + figura.getNomeFigura() + ", Número: " + figura.getNumeroFigura() + ", Descrição: " + figura.getDescricao() + ", Rara: " + figura.isRara());
        }
        //sendo Java, necessita usar um scanner para ler os dados enformados pelo usuário como um input
        //Depois criar um novo objeto figura,
        //Após adicionando-o à lista para salvar no CSV correspondente pelo método salvarCsv.
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome da figura desejada:");
        String nomeFigura = scanner.nextLine();
        
        System.out.println("Digite o número da figura desejada:");
        int numeroFigura = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        
        System.out.println("Digite a descrição da figura desejada:");
        String descricao = scanner.nextLine();
        
        boolean rara = false;
        
        Figura novaFigura = new Figura(nomeFigura, numeroFigura, descricao, rara);
        lista_desejadas_pessoais.add(novaFigura);
        
        salvarCsv("figuras_desejadas_pessoais.csv", lista_desejadas_pessoais);
    }

    /**
     * Lógica para cadastrar figuras repetidas pessoais, exibindo as já cadastradas, fazendo leitura por meio do scanner 
     * para novos registros, e depois salva no CSV para atualizar os resitros.
     * @param lista_repetidas_pessoais
     */
    public static void cadastrar_repetidas_pessoais(List<Figura> lista_repetidas_pessoais) {
        for (Figura figura : lista_repetidas_pessoais) {
            System.out.println("Figura: " + figura.getNomeFigura() + ", Número: " + figura.getNumeroFigura() + ", Descrição: " + figura.getDescricao() + ", Rara: " + figura.isRara());
        }
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome da figura repetida:");
        String nomeFigura = scanner.nextLine();
        
        System.out.println("Digite o número da figura repetida:");
        int numeroFigura = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        
        System.out.println("Digite a descrição da figura repetida:");
        String descricao = scanner.nextLine();
        
        boolean rara = false;
        
        Figura novaFigura = new Figura(nomeFigura, numeroFigura, descricao, rara);
        lista_repetidas_pessoais.add(novaFigura);
        
        salvarCsv("figuras_repetidas_pessoais.csv", lista_repetidas_pessoais);
    }

    /**
     * Lógica para mostrar os matches entre as figuras desejadas pessoais e repetidas do outro, e entre as figuras repetidas pessoais e desejadas do outro.
     * @param lista_desejadas_pessoais
     * @param lista_repetidas_outro
     * @param lista_repetidas_pessoais
     * @param lista_desejadas_outro
     */
    public static void mostrar_match(List<Figura> lista_desejadas_pessoais, List<Figura> lista_repetidas_outro, List<Figura> lista_repetidas_pessoais, List<Figura> lista_desejadas_outro) {
        System.out.println("Figuras desejadas pessoais que são repetidas do outro:");
        /**
         * Rodando para cada loop em uma lista, um outro dentro conferindo todos se correspondem em Nome, 
         * (pela função java equalsIgnoreCase que compara string ignorando maiúsculas/minúsculas), e Número, 
         * e se há match, exibe.
         */
        int matchCount = 0; // Variável para contar o número de matches encontrados
        for (Figura desejada : lista_desejadas_pessoais) {
            for (Figura repetidaOutro : lista_repetidas_outro) {
                if (desejada.getNomeFigura().equalsIgnoreCase(repetidaOutro.getNomeFigura()) &&
                    desejada.getNumeroFigura() == repetidaOutro.getNumeroFigura()) {
                    System.out.println("Match encontrado: " + desejada.getNomeFigura() + " - Número: " + desejada.getNumeroFigura());
                    matchCount++;
                }
            }
        }
        if (matchCount == 0) {
            System.out.println("Nenhum match encontrado entre desejadas pessoais e repetidas do outro.");
        }
        matchCount = 0; // Resetando a contagem para a próxima comparação

        System.out.println("\nFiguras repetidas pessoais que são desejadas do outro:");
        for (Figura repetida : lista_repetidas_pessoais) {
            for (Figura desejadaOutro : lista_desejadas_outro) {
                if (repetida.getNomeFigura().equalsIgnoreCase(desejadaOutro.getNomeFigura()) &&
                    repetida.getNumeroFigura() == desejadaOutro.getNumeroFigura()) {
                    System.out.println("Match encontrado: " + repetida.getNomeFigura() + " - Número: " + repetida.getNumeroFigura());
                    matchCount++;
                }
            }
        }
        if (matchCount == 0) {
            System.out.println("Nenhum match encontrado entre repetidas pessoais e desejadas do outro.");
        }
    }


    /**
     * Lógica para registrar uma troca, onde o usuário informa o nome e número das figuras que deseja trocar, e o programa verifica
     * se a figura está na lista de repetidas pessoais, e a outra lista de desejadas do outro. Se estiver, a figura é removida da lista correspondente
     * e os arquivos CSV são atualizados.
     * @param lista_desejadas_pessoais
     * @param lista_repetidas_pessoais
     */
    public static void registrar_troca(List<Figura> lista_desejadas_pessoais, List<Figura> lista_repetidas_pessoais) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite o nome da figura que obteve:");
        String nomeFiguraObteve = scanner.nextLine();
        
        System.out.println("Digite o número da figura que obteve:");
        int numeroFiguraObteve = scanner.nextInt();
        scanner.nextLine();

        Figura figuraObteve = null;
        
        // Laço que percorre a lista de desejadas pessoais para encontrar a figura que o usuário recebeu,
        // comparando se nome e número correspondem.
        // Variável de objeto da figura que obteve é preenchida por um da lista caso haja match, e o laço é interrompido.
        for (Figura figura : lista_desejadas_pessoais) {
            if (figura.getNomeFigura().equalsIgnoreCase(nomeFiguraObteve) && figura.getNumeroFigura() == numeroFiguraObteve) {
                figuraObteve = figura;
                break;
            }
        }
        
        // Se a figura para trocar foi encontrada, ela é removida da lista de desejadas pessoais e o CSV é atualizado.
        if (figuraObteve != null) {
            lista_desejadas_pessoais.remove(figuraObteve);
            salvarCsv("figuras_desejadas_pessoais.csv", lista_desejadas_pessoais);
            System.out.println("Figurinha registrada com sucesso!");
        } else {
            System.out.println("Figura não encontrada nas desejadas pessoais.");
        }
        
        System.out.println("Digite o nome da figura que deu:");
        String nomeFiguraDeu = scanner.nextLine();
        
        System.out.println("Digite o número da figura que deu:");
        int numeroFiguraDeu = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        Figura figuraDeu = null;

        // Laço que percorre a lista de repetidas pessoais para encontrar a figura que o usuário deu em troca,
        // comparando se nome e número correspondem.
        // Variável de objeto da figura que deu é preenchida por um da lista caso haja match, e o laço é interrompido.
        for (Figura figura : lista_repetidas_pessoais) {
            if (figura.getNomeFigura().equalsIgnoreCase(nomeFiguraDeu) && figura.getNumeroFigura() == numeroFiguraDeu) {
                figuraDeu = figura;
                break;
            }
        }

        if (figuraDeu != null) {
            lista_repetidas_pessoais.remove(figuraDeu);
            salvarCsv("figuras_repetidas_pessoais.csv", lista_repetidas_pessoais);
            System.out.println("Figurinha removida das repetidas pessoais com sucesso!");
        } else {
            System.out.println("Figura não encontrada nas repetidas pessoais.");
        }
    }


    /**
     * Carrega os dados de um arquivo CSV para a lista de figuras correspondente.
     * @param nomeArquivo
     * @param listaDestino
     */
    private static void carregarCsv(String nomeArquivo, List<Figura> listaDestino) {
        Path caminho = Paths.get(nomeArquivo);

        if (!Files.exists(caminho)) {
            return;
        }

        try (BufferedReader leitor = Files.newBufferedReader(caminho)) {
            String linha;

            while ((linha = leitor.readLine()) != null) {
                linha = linha.trim();

                if (linha.isEmpty()) {
                    continue;
                }

                if (linha.toLowerCase().startsWith("nomefigura")) {
                    continue;
                }

                String[] partes = linha.split("[;,]");

                if (partes.length < 4) {
                    continue;
                }

                String nomeFigura = partes[0].trim();

                int numeroFigura;
                try {
                    numeroFigura = Integer.parseInt(partes[1].trim());
                } catch (NumberFormatException e) {
                    continue;
                }

                String descricao = partes[2].trim();
                boolean rara = Boolean.parseBoolean(partes[3].trim());

                listaDestino.add(new Figura(nomeFigura, numeroFigura, descricao, rara));
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo CSV: " + nomeArquivo, e);
        }
    }

    /**
     * Salva os dados de uma lista de figuras em um arquivo CSV correspondente.
     * @param nomeArquivo
     * @param listaOrigem
     */
    private static void salvarCsv(String nomeArquivo, List<Figura> listaOrigem) {
        Path caminho = Paths.get(nomeArquivo);

        try (BufferedWriter escritor = Files.newBufferedWriter(
                caminho,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE)) {

            escritor.write("nomeFigura;numeroFigura;descricao;rara");
            escritor.newLine();

            for (Figura figura : listaOrigem) {
                escritor.write(figura.getNomeFigura() + ";"
                        + figura.getNumeroFigura() + ";"
                        + figura.getDescricao() + ";"
                        + figura.isRara());
                escritor.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever o arquivo CSV: " + nomeArquivo, e);
        }
    }
}
