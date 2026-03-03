#include <iostream>
#include <vector>
#include "minha_biblioteca_em_cpp.cpp"

using namespace std;

int main() {
    vector<int> lista_numerosA;
    vector<int> lista_numerosB;
    vector<int> lista_resusltados;
    srand(time(NULL));

    popular_aleatorio(lista_numerosA, 100);

    string nome_arquivo = "numeros.txt";
    popular_de_arquivo(lista_numerosB, nome_arquivo);

    exibir(lista_numerosA);
    exibir(lista_numerosB);

    vector<int> lista_resultado;
    copiar_lista_sem_replicados(lista_numerosA, lista_resultado);

    exibir(lista_resultado);

    return 0;
}
