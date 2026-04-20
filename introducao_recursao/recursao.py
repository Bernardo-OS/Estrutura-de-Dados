import random

def exibir_lista(lista):
    for item in lista:
        print(item)

def popular_lista_r(lista, qtd):
    if (qtd > 0):
        popular_lista_r(lista, qtd - 1)
        lista.append(random.randint(0,100))

    #for i in range(qtd):
    #    lista.append(random.randint(0,100))

def exibir_lista_pares_r(lista, n):
    if (n >= 1):
        exibir_lista_pares_r(lista, n - 1)
        if (lista[n - 1] % 2 == 0):
            print(lista[n -1])

def exibir_lista_r(lista, n):
    if (n >= 1):
        exibir_lista_r(lista, n - 1)
        print(lista[n - 1])

lista = []
popular_lista_r(lista, 5)

exibir_lista_r(lista, len(lista))
print("########")
exibir_lista_pares_r(lista, len(lista))