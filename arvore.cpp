#include <iostream>
#include <cstdlib>
#include <ctime>
 
using namespace std;
 
typedef struct no {
    int valor;
    struct no  *esq;
    struct no *dir;
} Arvore;
 
//metodo inserir recursivo em arvore binaria de pesquisa = ORDENADO
Arvore *inserir(int valor, Arvore *raiz) {
    if (raiz) {
        //controle de replicados
        if (valor == raiz->valor) return raiz;
 
        if (valor < raiz->valor) { //ir para esquerda
            raiz->esq = inserir(valor, raiz->esq);
        } else { //ir para direita
            raiz->dir = inserir(valor, raiz->dir);
        }
        return raiz;
    } else {
        Arvore *novo;
        novo = (Arvore *)malloc(sizeof(Arvore));
        novo->valor = valor;
        novo->esq = NULL;
        novo->dir = NULL;
        return novo;
    }
}
 
void red(Arvore *raiz) {
    if (raiz) {
        cout << raiz->valor << "\t";
        red(raiz->esq);
        red(raiz->dir);
    }
}
 
void erd(Arvore *raiz) {
    if (raiz) {
        erd(raiz->esq);
        cout << raiz->valor << "\t";
        erd(raiz->dir);
    }
}
 
void edr(Arvore *raiz) {
    if (raiz) {
        edr(raiz->esq);
        edr(raiz->dir);
        cout << raiz->valor << "\t";
    }
}
 
void exibir(int nivel, Arvore *raiz) {
    if (raiz) {
        exibir(nivel + 1, raiz->dir);
 
        for (int i = 0; i < nivel; i++) {
            cout << "   ";
        }
        cout << raiz->valor << "(" << nivel << ")\n";
 
        exibir(nivel + 1, raiz->esq);
    }
}
 
int contarNo(Arvore *raiz) {
    if (raiz) {
        return 1 + contarNo(raiz->esq) + contarNo(raiz->dir);
    }
    return 0;
}


int contarFolha(Arvore *raiz) {
    if (raiz) {
        if(!raiz->esq && !raiz->dir){
            return 1;
        }
        return 0 + contarFolha(raiz->esq) + contarFolha(raiz->dir);
    }
    return 0;
}

int maior(Arvore *raiz) {
    if (!raiz) return -27;

    Arvore *p;
    for (p = raiz; p->esq; p = p->esq);
    return p->valor;
}
 
int menor(Arvore *raiz) {
    if (!raiz) return -27;

    Arvore *p;
    for (p = raiz; p->dir; p = p->dir);
    return p->valor;
}

int encontrou(int valor, Arvore *raiz) {
    if (raiz) {
        if (valor == raiz->valor){
            return 1;
        }
        if (valor < raiz->valor){
            return encontrou(valor, raiz->esq);
        }
        return encontrou(valor, raiz->dir);
    }
    return 0; //não encontrou o valor
}

int nivel(int valor, Arvore *raiz){
    if(raiz){
        if(valor==raiz->valor) return 0;
        if(valor < raiz->valor){
            int resp = nivel(valor, raiz->esq);
            if(resp==-1) return -1;
        }
    } else{
        int resp = nivel(valor, raiz->dir);
        if(resp==-1) return -1;
        return resp+1;
    }
}

int main() {
    Arvore *raiz = NULL;
    srand(time(NULL));
    for (int i = 0; i < 10; i++) {
        raiz = inserir(rand() % 30, raiz);
    }
 
    exibir(0,raiz);
    cout << "Maior valor: " << maior(raiz) << "\n";
    cout << "Menor valor: " << menor(raiz) << "\n";
    cout << "Total de nós: " << contarNo(raiz) << "\n";
    cout << "Total de folhas: " << contarFolha(raiz) << "\n";
 
    int valor = 5;
    cout << "Encontrou: " << valor << "?: " << encontrou(valor, raiz) << "\n";
 
    return 1;
}