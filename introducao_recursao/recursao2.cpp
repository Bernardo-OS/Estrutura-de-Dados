#include <iostream>
using namespace std;
 
void mostrarSequenciaD(int numero) {
    for (; numero > 0; numero--) {
        cout << numero << endl;
    }
}
 
void mostrarSequenciaC(int numero) {
    for (int i = 1; i <= numero; i++) {
        cout << i << endl;
    }
}
 
 
 
// RECURSÃO COMO REPETIÇÃO, obedece a 3 situações clássicas:
//         a) inicialização da variável de controle
//         b) teste de parada/continuação com a variável de controle
//         c) transformação da variável de controle
 
//         void mostrarSequencia(a) {
//             for (; b; c) {
           
//             }
//         }
 
void mostrarSequenciaRecursiva(int numero) {
    if (numero > 0) {
        //executar codigo no empilhamento
       
        mostrarSequenciaRecursiva(numero - 1); //PONTO DE RECURSAO COM A TRANSFORMAÇÃO DA VARIAVEL DE CONTROLE
       
        //executar codigo no desempilhamento
        cout << numero << endl;
    }
}
 
int main() {
    int numero = 5;
    
 
    mostrarSequenciaRecursiva(numero);
 
    return 1;
}
 
 