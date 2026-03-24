#include <iostream>
#include <stack>
#include <string>
#include <vector>
#include "Aluno.cpp"

using namespace std;

int main() {
    vector<Aluno> alunos;
    string nome;
    alunos.push_back(Aluno("João Silva", ""));
    alunos.push_back(Aluno("Maria Oliveira", ""));
    for (const auto& aluno : alunos) {
        cout << "Email gerado: " << aluno.getEmail() << endl;
    }
    return 0;
}