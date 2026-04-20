#include <iostream>
#include <ctime>
#include <cstdlib>
 
#define TAM 5
 
using namespace std;
 
void popularVetor(int vetor[], int n) {
    srand(time(NULL));
    for (int i = 0; i < n; i++) {
        vetor[i] = rand() % 100;
    }
}

void popularVetorR(int vetor[], int n) {
    if (n >= 1) {
        vetor[n - 1] = rand() % 100;
        popularVetorR(vetor, n - 1);
    }
}
 
void exibirVetor(int vetor[], int n) {
    for (int i = 0; i < n; i++) {
        cout << vetor[i] << endl;
    }
}

void exibirVetorR(int vetor[], int n) {
    if (n >= 1) {
        cout << (n-1) << ")" << vetor[n - 1] << endl;
        exibirVetorR(vetor, n - 1);
    }
}
 
int main() {
    int vetor[TAM];
 
    popularVetorR(vetor,TAM);
    exibirVetorR(vetor, TAM);
 
    return 1;
}