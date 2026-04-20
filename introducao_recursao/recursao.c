#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define TAM 5


void popularVetor(int vetor[], int n) {
    srand(time(NULL));
    for (int i = 0; i < n; i++) {
        vetor[i] = rand() % 100;
    }
}

void exibirVetor(int vetor[], int n) {
    srand(time(NULL));
    for (int i = 0; i < n; i++) {
        printf("")
    }
}

int main() {
    int vetor[TAM];

    popularVetor(vetor,TAM);
    exibirVetor(vetor,TAM);

    return 1;
}
