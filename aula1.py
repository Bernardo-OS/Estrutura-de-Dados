import random
from util import popular_lista_arquivo
lista=[]

n = int(input('quantos números na lista: '))
i=0
while i < n:
    for i in range(n):
        numero_randomico = random.randint(0,10000)
        if numero_randomico not in lista:
            lista.append(numero_randomico)
            i+=1
        else:
            print('Número pulado')

#lista.append('Ibanez')
#lista.append('Solar')
#lista.append('Shelter')
lista.sort()
#print(lista)
popular_lista_arquivo(lista, "numeros.txt")