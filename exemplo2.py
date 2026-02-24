import random
from util import popular_lista_arquivo
letras = 'abcdefghijklmopqrstuvwxyz'
palavras = []
n = int(input('quantas palavras na lista: '))
tamanho_palavra = int(input('Tamanho da palavra: '))
palavra = ''

print('Tamanho da string letras', len(letras))

#for i in range(tamanho_palavra):
 #   posicao_letras = random.randint(0,6)
  #  palavra+=letras[posicao_letras]
   # print("Palavra criada:", palavra)
    #posicao_letras = random.randint(0, len(letras))

i=0
while i < n:
    palavra = ''
    for k in range(tamanho_palavra):
        posicao_letras = random.randint(0,6)
        palavra+=letras[posicao_letras]
        #print(posicao_letras, letras[posicao_letras])
        
        posicao_letras = random.randint(0, len(letras))
    print("Palavra criada:", palavra)
    if palavra not in palavras:
        palavras.append(palavra)
        i+=1
    else:
        print('palavra pulada')

palavras.sort()
#print(palavras)
popular_lista_arquivo(palavras, "palavras.txt")