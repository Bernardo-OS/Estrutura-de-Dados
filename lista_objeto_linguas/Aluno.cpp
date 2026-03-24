#include <iostream>
#include <stack>
#include <string>
#include <vector>
#include <cctype>

using namespace std;

class Aluno {
public:
    string nome;
    string email;

    Aluno(string nome, string email) {
        this->nome = nome;
        this->email = gerarEmail(nome);
    }

    string getNome() {
        return nome;
    }

    string getEmail() {
        return email;
    }

    string gerarEmail(string nome) {
        vector<string> dadosNome;
        string temp;
        for (char c : nome) {
            if (c == ' ') {
                dadosNome.push_back(temp);
                temp = "";
            } else {
                temp += c;
            }
        }
        if (!temp.empty()) {
            dadosNome.push_back(temp);
        }
        email = tolower(dadosNome[0]) + "." + tolower(dadosNome[dadosNome.size() - 1]) + "@ufn.edu.br";
        return email;
    }
};