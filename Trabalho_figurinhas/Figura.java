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
 Classe Figura
-nomeFigura: String
-numeroFigura: int
-descricao: String
-rara: boolean

Menu:
1-Cadastrar/listar figuras repitidas pessoais
2-Cadastrar/listar figuras desejadas pessoais
3-Cadastrar/listar figuras repitidas de outro + match
4-Cadastrar/listar figuras desejadas de outro + match
5-Sair
Opcao:

arquivos.csv/listas:
    figuras_repetidas_pessoais.csv
    figuras_desejadas_pessoais.csv
    figuras_repetidas_outro.csv
    figuras_desejadas_outro.csv
**/

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
    public void alimentar_listas_csv(List<Figura> lista_repetidas_pessoais, List<Figura> lista_desejadas_pessoais, List<Figura> lista_repetidas_outro, List<Figura> lista_desejadas_outro) {
        carregarCsv("figuras_repetidas_pessoais.csv", lista_repetidas_pessoais);
        carregarCsv("figuras_desejadas_pessoais.csv", lista_desejadas_pessoais);
        carregarCsv("figuras_repetidas_outro.csv", lista_repetidas_outro);
        carregarCsv("figuras_desejadas_outro.csv", lista_desejadas_outro);
    }

    /**
     * Lógica para cadastrar figuras desejadas pessoais, exibindo as já cadastradas e salvando no CSV.
     * @param lista_desejadas_pessoais
     */
    public void cadastrar_desejadas_pessoais(List<Figura> lista_desejadas_pessoais) {
        for (Figura figura : lista_desejadas_pessoais) {
            System.out.println("Figura: " + figura.getNomeFigura() + ", Número: " + figura.getNumeroFigura() + ", Descrição: " + figura.getDescricao() + ", Rara: " + figura.isRara());
        }
        System.out.println("Digite o nome da figura desejada:");
        Scanner nomeFigura = new Scanner(System.in);
        System.out.println("Digite o número da figura desejada:");
        Scanner numeroFigura = new Scanner(System.in);
        System.out.println("Digite a descrição da figura desejada:");
        Scanner descricao = new Scanner(System.in);
        isRara = false;
        salvarCsv("figuras_desejadas_pessoais.csv", lista_desejadas_pessoais);
        // Lógica para criar objetos figura e guardar na lista e salvar no CSV
    }

    /**
     * Lógica para cadastrar figuras repetidas pessoais, exibindo as já cadastradas e salvando no CSV.
     * @param lista_repetidas_pessoais
     */
    public void cadastrar_repitidas_pessoais(List<Figura> lista_repetidas_pessoais) {
        for (Figura figura : lista_repetidas_pessoais) {
            System.out.println("Figura: " + figura.getNomeFigura() + ", Número: " + figura.getNumeroFigura() + ", Descrição: " + figura.getDescricao() + ", Rara: " + figura.isRara());
        }
        System.out.println("Digite o nome da figura desejada:");
        Scanner nomeFigura = new Scanner(System.in);
        System.out.println("Digite o número da figura desejada:");
        Scanner numeroFigura = new Scanner(System.in);
        System.out.println("Digite a descrição da figura desejada:");
        Scanner descricao = new Scanner(System.in);
        isRara = false;
        salvarCsv("figuras_repetidas_pessoais.csv", lista_repetidas_pessoais);
        // Lógica para criar objetos figura e guardar na lista e salvar no CSV
    }

    /**
     * Carrega os dados de um arquivo CSV para a lista de figuras correspondente.
     * @param nomeArquivo
     * @param listaDestino
     */
    private void carregarCsv(String nomeArquivo, List<Figura> listaDestino) {
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
    private void salvarCsv(String nomeArquivo, List<Figura> listaOrigem) {
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