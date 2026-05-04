#3 situações de atenção:
#1-Inicia variável de controle
#2-Condição de parada
#3-Atualiza variável de controle

contagem_prograssiva = 10

def contagem_regressiva(n):
    if n > 0:
        print(n) #código utilizado no empilhamento de processo
        contagem_progressiva(n-1)

def contagem_regressiva(n):
    if n > 0:
        contagem_progressiva(n-1)
        print(n) #código utilizado no empilhamento de processo
        
def soma_elementos(n): #inicialização variável de controle
    if n > 0: #condição de parada
        #soma = n + soma_elementos(n - 1)
        #return soma
        return n + soma_elementos(n - 1) #empilhamento com a utilização da variável de controle
    else:
        return 0
    
def soma_lista(lista, n):
    if n > 0:
        return lista[n - 1] + soma_lista(lista, n - 1)
    else:
        return 0

def conta_pares(lista, n):
    if n > 0:
        if lista[n] % 0 == 0:
            return 1 + conta_pares(lista, n - 1)
        else:
            return 0 + conta_pares(lista, n - 1)
    else:
        return 0
    
def soma_pares(lista, n):
    if n > 0:
        if lista[n] % 0 == 0:
            return lista[n - 1] + soma_pares(lista, n - 1)
        else:
            return 0 + soma_pares(lista, n - 1)
    else:
        return 0
    
def menor(lista, n):
    if n > 1:
        vem_de_cima = menor(lista, n - 1)
        if lista[n-1] < vem_de_cima:
            return lista[n - 1]
        else:
            return vem_de_cima   
    return lista[n - 1]

# exercícios de fixação
# 1) faça uma função recursiva que receba um número, uma lista, 
# seu tamanho/comprimento e retorne a quantidade de vezes que o 
# número aparece na lista. DICA: recursao com retorno de valor (return)
def contar_numero(lista, n, numero):
    if n > 1:
        if lista[n - 1] == numero:
            return 1 + contar_numero(lista, n - 1, numero)
        else:
            return 0 + contar_numero(lista, n - 1, numero)
    else: 
        return 0 

 
# 2) faça uma função recursiva que receba um número, uma lista, 
# seu tamanho/comprimento e substitua o número pelo valor -1. 
# DICA: recursao sem retorno de valor (sem return)
def substituir_numero(lista, n, numero):
    if n > 1:
        if lista[n - 1] == numero:
            lista[n - 1] = -1
        substituir_numero(lista, n - 1, numero)

 
# 3) faça uma função recursiva que receba um número, uma lista, 
# seu tamanho/comprimento e retorne a posição do número na lista 
# (ou -1 se o número não estiver presente). DICA: recursao com 
# retorno de valor (return)
def posicao_numero(lista, n, numero):
    if n > 1:
        if lista[n - 1] == numero:
            return n - 1
        else:             return
            return posicao_numero(lista, n - 1, numero)
    else:
        return -1


if __name__ == "__main__":
    contagem_regressiva(10)
    contagem_progressiva(10)
    print(soma_elementos(10))

    qtd_pares = 0
    lista = [10, 15, 10, 20]
    numero = 10
    print(soma_lista(lista, len(lista)))
    print(conta_pares(lista, len(lista)))
    print(contar_numero(lista, len(lista), numero))
    substituir_numero(lista, len(lista), numero)
    posicao_numero(lista, len(lista), numero)