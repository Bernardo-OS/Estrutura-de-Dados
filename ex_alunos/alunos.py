import csv

"""
email para alexz@ufn.edu.br com ASSUNTO: Trabalho ED CC
Gestão Acadêmica

Objetivo: Implementar um sistema que processe o histórico de ingressantes e gere relatórios estatísticos simples. Os dados devem ser 
carregados do arquivo alunos.csv.

Tarefas:
* Criar uma classe Aluno com os atributos correspondentes (ver arquivo - Nome,Curso,Sexo,AnoIngresso).

* Ler o arquivo alunos.csv, instanciar os objetos e armazená-los em uma lista.

* Criar funções (orientadas a objetos) 
     * Ordenar a lista final por "Ano de Ingresso" ou "Nome" antes de exibir
     * Criar um método que busque um aluno pelo nome exato na lista e retorne seus dados.
* Agregação: Calcular quantos alunos ingressaram em cada ano.
"""

class Aluno:
    def __init__(self, nome, curso, sexo, ano_ingresso):
        self.nome = nome
        self.curso = curso
        self.sexo = sexo
        self.ano_ingresso = int(ano_ingresso)

    def __str__(self):
        return f"{self.nome} - {self.curso} - {self.sexo} - {self.ano_ingresso}"

    """_summary_
    método fornecido por IA para ler arquivo e guardar em lista. separando atributos por vírgula e os objetos por nova linha

    
    Args:
        arquivo (str): caminho do arquivo .csv com os registros
    """
    @staticmethod
    def ler_alunos(arquivo):
        alunos = []
        with open(arquivo, newline='', encoding='utf-8') as csvfile:
            reader = csv.reader(csvfile, delimiter=',')
            for linha in reader:
                if not linha:
                    continue

                # Suporta arquivo com cabeçalho opcional.
                if linha[0].strip().lower() == 'nome':
                    continue

                if len(linha) != 4:
                    continue

                nome, curso, sexo, ano_ingresso = [campo.strip() for campo in linha]
                alunos.append(Aluno(nome, curso, sexo, ano_ingresso))
        return alunos

    """_summary_
    método para ordenar alunos por ano ou nome, buscar aluno por nome e contar ingressos por ano
    

    Args:
        alunos (list): lista de objetos Aluno
        criterio (str): critério de ordenação ("ano" ou "nome")
    """
    def ordenar_alunos(alunos, criterio):
        if criterio == "ano":
            return sorted(alunos, key=lambda x: x.ano_ingresso)
        elif criterio == "nome":
            return sorted(alunos, key=lambda x: x.nome)

    """_summary_
    método para buscar aluno por nome e contar ingressos por ano

    
    Args:
        alunos (list): lista de objetos Aluno
        nome (str): nome do aluno a ser buscado
    """
    def buscar_aluno(alunos, nome):
        for aluno in alunos:
            if aluno.nome.upper() == nome.upper():
                return aluno
        return "aluno não encontrado"
    
    """_summary_
    método para contar ingressos por ano (utilizando um dicionário para armazenar a contagem)


    Args:
        alunos (list): lista de objetos Aluno
    """
    def contar_ingressos_por_ano(alunos):
        ingressos = {}
        for aluno in alunos:
            if aluno.ano_ingresso in ingressos:
                ingressos[aluno.ano_ingresso] += 1
            else:
                ingressos[aluno.ano_ingresso] = 1
        return ingressos
