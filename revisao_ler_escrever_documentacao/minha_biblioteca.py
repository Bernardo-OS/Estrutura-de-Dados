from random import randint, random

def popular_aleatorio(lista: int, quantidade: int):
    """_summary_
    métodos que recebe uma lista e uma quantidade, e preenche a lista com números inteiros aleatórios entre 0 e 100, de acordo com a quantidade informada.
    

    Args:
        lista (int): lista de dados inteiros a ser preenchida
        quantidade (int): quantidade de números a serem gerados e inseridos na lista
    """
    for i in range(quantidade):
        lista.append(randint(0, 100))

def popular_de_arquivo(lista, nome_arquivo: str):
    """_summary_
    método que recebe uma lista e a popula com dados de um arquivo
    
    Args:
        lista (_type_): lista genérica
        nome_arquivo (string): nome do arquivo fonte que contém os dados a serem inseridos na lista
    """
    with open(nome_arquivo, "r", encoding='utf8') as leitor:
        for linha in leitor:
            lista.append(linha.strip())

def exibir(lista):
    """_summary_
    método que recebe uma lista genérica, exibe todos os seus elementos na tela e no final a quantidade de elementos na lista.
    
    Args:
        lista (_type_): _description_
    """
    for i in lista:
        print(i)
    print(f'Quantidade de elementos na lista: {len(lista)}')

def copiar_lista_sem_replicados(lista_origem, lista_destino):
    """_summary_
    método que recebe uma lista de origem e copia seus elementos para a lista destino, retirando os replicados
    
    Args:
        lista_origem (_type_): ista com os dados de origem
        lista_destino (_type_): lista para receber
    """
    for i in range(len(lista_origem)):
        numero = lista_origem[i]
        if numero not in lista_destino:
            lista_destino.append(numero)
        else:
            print(f'Número {numero} já existe na lista destino')