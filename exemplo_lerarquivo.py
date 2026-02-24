from util import ler_arquivo_lista  
palavras = []
ler_arquivo_lista("palavras.txt", palavras)
print( 'tamanho da lista', len(palavras))
print(palavras)