import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Sabendo que Verão são os meses Dezembro, Janeiro, Fevereiro, Março. Que Outono 
// são os meses Abril, Maio, Junho, Julho. Que Inverno são os meses Agosto, Setembro Primavera: Outubro, Novembro.

//Preciso descobrir dentro da base dadosClimaticos.csv qual a estação que menos chove; 
// qual a estação que mais chove; qual a estação mais quente; qual a estação mais amena.

//Lembrar de documentar corretamente.


/**
 * Class Clima para objetos com dados climáticos
 */
public class Clima {
    String ano;
    String mes;
    String temperatura;
    String precipitacao;

    /**
     * Construtor padrao
     * @param ano representa o ano da avaliação do clima
     * @param mes representa o mes da avaliação do clima
     * @param temperatura representa a temperatura (Ameno, Frio, Quente)
     * @param precipitacao
     */
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

    /**
     * Função para dividir em listas menores por estação do ano
     * @return a estação com os respectivos meses
     */
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
                return "Outono";
            case "Julho":
            case "Agosto":
            case "Setembro":
                return "Inverno";
            case "Outubro":
            case "Novembro":
                return "Primavera";
            default:
                return "Desconhecida";
        }
    }

    
    /**
     * Função para atribuir um peso à precipitação
     * @return um numero referente ao nivel de precipitacao, onde "pouca" = 1, "média" = 2 e "muita" = 3
     */
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
     * @param estacao estação desejada (Verão, Outono, Inverno, Primavera)
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
     * @param quantidadePrimavera quantidade de ocorrências na primavera
     * @return nome da estação com maior quantidade
     */
    public static String descobrirEstacaoMaiorQuantidade(int quantidadeVerao, int quantidadeOutono, int quantidadeInverno, int quantidadePrimavera) {
        String estacao = "Verão";
        int maior = quantidadeVerao;

        if (quantidadeOutono > maior) {
            maior = quantidadeOutono;
            estacao = "Outono";
        }
        if (quantidadeInverno > maior) {
            estacao = "Inverno";
        }
        if (quantidadePrimavera > maior) {
            estacao = "Primavera";
        }

        return estacao;
    }
    


    //Sobreescreve o método toString para ajeitar a impressão dos objetos de Clima
    @Override
    public String toString() {
        return "Clima [ano=" + ano + ", mes=" + mes + ", temperatura=" + temperatura
                + ", precipitacao=" + precipitacao + "]";
    }

    /**
     * Função de classe para ler o arquivo CSV e retornar uma lista inteira de objetos Clima
     * @param caminhoArquivo
     * @return lista com dados do arquivo csv
     */
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
}
