import java.util.ArrayList;
import java.util.List;

public class Main {
    //funcao principal roda todas as funcoes: lê o csv, separa por estacao e imprime os resultados
    public static void main(String[] args) {
        List<Clima> todosClimas = Clima.lerCsv("C:\\Users\\laboratorio\\Downloads\\dadosClimaticos.csv");

        List<Clima> verao = new ArrayList<>();
        List<Clima> outono = new ArrayList<>();
        List<Clima> inverno = new ArrayList<>();
        List<Clima> primavera = new ArrayList<>();
        
        // Divide os climas em listas menores por estação usando a função getEstacao()
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
                case "Primavera":
                    primavera.add(clima);
                    break;
            }
        }

        System.out.println("Verão: " + verao);
        System.out.println("Outono: " + outono);
        System.out.println("Inverno: " + inverno);
        System.out.println("Primavera: " + primavera);

        // Calcula o total de peso de precipitação por estação
        int pesoVerao  = Clima.calcularPesoPrecipitacaoTotal(verao);
        int pesoOutono = Clima.calcularPesoPrecipitacaoTotal(outono);
        int pesoInverno = Clima.calcularPesoPrecipitacaoTotal(inverno);
        int pesoPrimavera =Clima.calcularPesoPrecipitacaoTotal(primavera);

        System.out.println("\nPeso total de precipitação:");
        System.out.println("  Verão:  " + pesoVerao);
        System.out.println("  Outono: " + pesoOutono);
        System.out.println("  Inverno: " + pesoInverno);
        System.out.println("  Primavera: " + pesoPrimavera);

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
        if (pesoPrimavera > maiorPeso) {
            estacaoMaisChove = "Primavera";
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
        if (pesoPrimavera < menorPeso) {
            estacaoMenosChove = "Primavera";
        }

        System.out.println("\nEstação que MAIS chove: " + estacaoMaisChove);
        System.out.println("Estação que MENOS chove: " + estacaoMenosChove);
   
        // Define listas por estação + temperatura (quente)
        List<Clima> verao_quente = Clima.filtrarPorEstacaoETemperatura(todosClimas, "Verão", "Quente");
        List<Clima> outono_quente = Clima.filtrarPorEstacaoETemperatura(todosClimas, "Outono", "Quente");
        List<Clima> inverno_quente = Clima.filtrarPorEstacaoETemperatura(todosClimas, "Inverno", "Quente");
        List<Clima> primavera_quente = Clima.filtrarPorEstacaoETemperatura(todosClimas, "Primavera", "Quente");

        // Define listas por estação + temperatura (ameno)
        List<Clima> verao_ameno = Clima.filtrarPorEstacaoETemperatura(todosClimas, "Verão", "Ameno");
        List<Clima> outono_ameno = Clima.filtrarPorEstacaoETemperatura(todosClimas, "Outono", "Ameno");
        List<Clima> inverno_ameno = Clima.filtrarPorEstacaoETemperatura(todosClimas, "Inverno", "Ameno");
        List<Clima> primavera_ameno = Clima.filtrarPorEstacaoETemperatura(todosClimas, "Primavera", "Ameno");

        // Descobre a estação mais quente (mais registros "Quente" verificando o tamanho da lista com size())
        String estacaoMaisQuente = Clima.descobrirEstacaoMaiorQuantidade(
            verao_quente.size(), outono_quente.size(), inverno_quente.size(), primavera_quente.size());
        // Descobre a estação mais amena (mais registros "Ameno" verificando o tamanho da lista com size())
        String estacaoMaisAmena = Clima.descobrirEstacaoMaiorQuantidade(
            verao_ameno.size(), outono_ameno.size(), inverno_ameno.size(), primavera_ameno.size());

        System.out.println("\nQuantidade de registros 'Quente':");
        System.out.println("  Verão: " + verao_quente.size());
        System.out.println("  Outono: " + outono_quente.size());
        System.out.println("  Inverno: " + inverno_quente.size());
        System.out.println("  Primavera: " + primavera_quente.size());

        System.out.println("\nQuantidade de registros 'Ameno':");
        System.out.println("  Verão: " + verao_ameno.size());
        System.out.println("  Outono: " + outono_ameno.size());
        System.out.println("  Inverno: " + inverno_ameno.size());
        System.out.println("  Primavera: " + primavera_ameno.size());

        System.out.println("\nEstação MAIS quente: " + estacaoMaisQuente);
        System.out.println("Estação MAIS amena: " + estacaoMaisAmena);
    }
}
