import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Sabendo que Verão são os meses Dezembro, Janeiro, Fevereiro, Março. Que Outono 
// são os meses Abril, Maio, Junho, Julho. Que Inverno são os meses Agosto, Setembro, Outubro, Novembro.

//Preciso descobrir dentro da base dadosClimaticos.csv qual a estação que menos chove; 
// qual a estação que mais chove; qual a estação mais quente; qual a estação mais amena.

//Lembrar de documentar corretamente.

public class Clima {
    String ano;
    String mes;
    String temperatura;
    String precipitacao;

    public Clima(String ano, String mes, String temperatura, String precipitacao) {
        this.ano = ano;
        this.mes = mes;
        this.temperatura = temperatura;
        this.precipitacao = precipitacao;
    }

    public String getAno() {
        return ano;
    }

    public String getMes() {
        return mes;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public String getPrecipitacao() {
        return precipitacao;
    }

    //Função para dividir em listas menores por estação do ano
    public String getEstacao() {
        switch (mes.trim()) {
            case "Dezembro":
            case "Janeiro":
            case "Fevereiro":
            case "Março":
                return "Verão";
            case "Abril":
            case "Maio":
            case "Junho":
            case "Julho":
                return "Outono";
            case "Agosto":
            case "Setembro":
            case "Outubro":
            case "Novembro":
                return "Inverno";
            default:
                return "Desconhecida";
        }
    }

    //Função para atribuir um peso à precipitação, onde "pouca" = 1, "média" = 2 e "muita" = 3
    public int getPesoPrecipitacao() {
    switch (precipitacao.trim().toLowerCase()) {
        case "pouca":
            return 1;
        case "média":
        case "media":
            return 2;
        case "muita":
            return 3;
        default:
            return 0;
        }
    }

    /**
     * Soma o peso de precipitação de todos os climas de uma lista usando valor vindo da função getPesoPrecipitacao()
     * @param lista lista de objetos Clima de uma estação
     * @return soma total dos pesos de precipitação
     */
    public static int calcularPesoPrecipitacaoTotal(List<Clima> lista) {
        int total = 0;
        for (Clima clima : lista) {
            total += clima.getPesoPrecipitacao();
        }
        return total;
    }

     /**
     * Filtra uma lista de clima por estação e temperatura.
     * Exemplo: estação "Verão" e temperatura "Quente".
     *
     * @param lista lista completa de climas
     * @param estacao estação desejada (Verão, Outono, Inverno)
     * @param temperatura temperatura desejada (Quente, Ameno, Frio)
     * @return nova lista contendo apenas os itens filtrados
     */
    public static List<Clima> filtrarPorEstacaoETemperatura(List<Clima> lista, String estacao, String temperatura) {
        List<Clima> filtrada = new ArrayList<>();

        for (Clima clima : lista) {
            if (clima.getEstacao().equalsIgnoreCase(estacao)
                    && clima.getTemperatura().equalsIgnoreCase(temperatura)) {
                filtrada.add(clima);
            }
        }

        return filtrada;
    }

    /**
     * Retorna a estação com maior quantidade de registros para uma temperatura.
     *
     * @param quantidadeVerao quantidade de ocorrências no verão
     * @param quantidadeOutono quantidade de ocorrências no outono
     * @param quantidadeInverno quantidade de ocorrências no inverno
     * @return nome da estação com maior quantidade
     */
    public static String descobrirEstacaoMaiorQuantidade(int quantidadeVerao, int quantidadeOutono, int quantidadeInverno) {
        String estacao = "Verão";
        int maior = quantidadeVerao;

        if (quantidadeOutono > maior) {
            maior = quantidadeOutono;
            estacao = "Outono";
        }
        if (quantidadeInverno > maior) {
            estacao = "Inverno";
        }

        return estacao;
    }
    


    //Sobreescreve o método toString para ajeitar a impressão dos objetos de Clima
    @Override
    public String toString() {
        return "Clima [ano=" + ano + ", mes=" + mes + ", temperatura=" + temperatura
                + ", precipitacao=" + precipitacao + "]";
    }

    //Função para ler o arquivo CSV e retornar uma lista inteira de objetos Clima
    public static List<Clima> lerCsv(String caminhoArquivo) {
        List<Clima> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            boolean primeiraLinha = true;

            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                String[] partes = linha.split(",");

                String ano = partes[0].trim();
                String mes = partes[1].trim();
                String temperatura = partes[2].trim();
                String precipitacao = partes[3].trim();

                Clima clima = new Clima(ano, mes, temperatura, precipitacao);
                lista.add(clima);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        return lista;
    }

    //funcao principal roda todas as funcoes: lê o csv, separa por estacao e imprime os resultados
    public static void main(String[] args) {
        List<Clima> todosClimas = lerCsv("Downloads\\dadosClimaticos.csv");

        List<Clima> verao = new ArrayList<>();
        List<Clima> outono = new ArrayList<>();
        List<Clima> inverno = new ArrayList<>();

        for (Clima clima : todosClimas) {
            switch (clima.getEstacao()) {
                case "Verão":
                    verao.add(clima);
                    break;
                case "Outono":
                    outono.add(clima);
                    break;
                case "Inverno":
                    inverno.add(clima);
                    break;
            }
        }

        System.out.println("Verão: " + verao);
        System.out.println("Outono: " + outono);
        System.out.println("Inverno: " + inverno);

        // Calcula o total de peso de precipitação por estação
        int pesoVerao  = calcularPesoPrecipitacaoTotal(verao);
        int pesoOutono = calcularPesoPrecipitacaoTotal(outono);
        int pesoInverno = calcularPesoPrecipitacaoTotal(inverno);

        System.out.println("\nPeso total de precipitação:");
        System.out.println("  Verão:  " + pesoVerao);
        System.out.println("  Outono: " + pesoOutono);
        System.out.println("  Inverno: " + pesoInverno);

        // Descobre a estação que mais chove (maior peso)
        String estacaoMaisChove = "Verão";
        int maiorPeso = pesoVerao;
        if (pesoOutono > maiorPeso) {
            maiorPeso = pesoOutono;
            estacaoMaisChove = "Outono";
        }
        if (pesoInverno > maiorPeso) {
            estacaoMaisChove = "Inverno";
        }

        // Descobre a estação que menos chove (menor peso)
        String estacaoMenosChove = "Verão";
        int menorPeso = pesoVerao;
        if (pesoOutono < menorPeso) {
            menorPeso = pesoOutono;
            estacaoMenosChove = "Outono";
        }
        if (pesoInverno < menorPeso) {
            estacaoMenosChove = "Inverno";
        }

        System.out.println("\nEstação que MAIS chove: " + estacaoMaisChove);
        System.out.println("Estação que MENOS chove: " + estacaoMenosChove);
   
        // Define listas por estação + temperatura (quente)
        List<Clima> verao_quente = filtrarPorEstacaoETemperatura(todosClimas, "Verão", "Quente");
        List<Clima> outono_quente = filtrarPorEstacaoETemperatura(todosClimas, "Outono", "Quente");
        List<Clima> inverno_quente = filtrarPorEstacaoETemperatura(todosClimas, "Inverno", "Quente");

        // Define listas por estação + temperatura (ameno)
        List<Clima> verao_ameno = filtrarPorEstacaoETemperatura(todosClimas, "Verão", "Ameno");
        List<Clima> outono_ameno = filtrarPorEstacaoETemperatura(todosClimas, "Outono", "Ameno");
        List<Clima> inverno_ameno = filtrarPorEstacaoETemperatura(todosClimas, "Inverno", "Ameno");

        // Descobre a estação mais quente (mais registros "Quente" verificando o tamanho da lista com size())
        String estacaoMaisQuente = descobrirEstacaoMaiorQuantidade(
            verao_quente.size(), outono_quente.size(), inverno_quente.size());

        // Descobre a estação mais amena (mais registros "Ameno" verificando o tamanho da lista com size())
        String estacaoMaisAmena = descobrirEstacaoMaiorQuantidade(
            verao_ameno.size(), outono_ameno.size(), inverno_ameno.size());

        System.out.println("\nQuantidade de registros 'Quente':");
        System.out.println("  Verão: " + verao_quente.size());
        System.out.println("  Outono: " + outono_quente.size());
        System.out.println("  Inverno: " + inverno_quente.size());

        System.out.println("\nQuantidade de registros 'Ameno':");
        System.out.println("  Verão: " + verao_ameno.size());
        System.out.println("  Outono: " + outono_ameno.size());
        System.out.println("  Inverno: " + inverno_ameno.size());

        System.out.println("\nEstação MAIS quente: " + estacaoMaisQuente);
        System.out.println("Estação MAIS amena: " + estacaoMaisAmena);
    }
}