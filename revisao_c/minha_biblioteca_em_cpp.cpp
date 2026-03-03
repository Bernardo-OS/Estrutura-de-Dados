#include <vector>
#include <string>
#include <iostream>
#include <fstream>
#include <cstdlib>
#include <ctime>
using namespace std;

void popular_aleatorio(std::vector<int>& lista, int quantidade);
void popular_de_arquivo(std::vector<std::string>& lista, const std::string& nome_arquivo);
void exibir(const std::vector<int>& lista);
void exibir_string(const std::vector<std::string>& lista);
void copiar_lista_sem_replicados(const std::vector<int>& lista_origem, std::vector<int>& lista_destino);

void popular_aleatorio(vector<int>& lista, int quantidade) {
    srand(time(NULL));  // inicializa semente aleatoria
    
    for (int i = 0; i < quantidade; i++) {
        lista.push_back(rand() % 101); // numeros entre 0 e 100
    }
}

void popular_de_arquivo(vector<int>& lista, const string& nome_arquivo) {
    ifstream procurador
    procurador.open(nome_arquivo.c_str());
    
    if (!procurador) {
        cout << "Erro ao abrir o arquivo." << endl;
        exit(0);
    }

    string linha;
    while (!procurador.eof()) {
		getline(procurador, linha);
        lista.push_back(atoi(linha.c_str()));
    }

    procurador.close();
}

void exibir(const vector<int>& lista) {
    for (int elemento : lista) {
        cout << elemento << endl;
    }
    cout << "Quantidade de elementos na lista: " << lista.size() << endl;
}

void copiar_lista_sem_replicados(const vector<int>& lista_origem, vector<int>& lista_destino) {
    for (int numero : lista_origem) {
        bool existe = false;

        for (int item : lista_destino) {
            if (item == numero) {
                existe = true;
                break;
            }
        }

        if (!existe) {
            lista_destino.push_back(numero);
        } else {
            cout << "Numero " << numero << " ja existe na lista destino" << endl;
        }
    }
}
