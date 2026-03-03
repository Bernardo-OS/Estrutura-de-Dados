from minha_biblioteca import popular_aleatorio, popular_de_arquivo, exibir, copiar_lista_sem_replicados

lista_numerosA = []
lista_numerosB = []

popular_aleatorio(lista_numerosA, 100)

nome_arquivo = 'numeros.txt' 
#popular_de_arquivo(lista_numerosB, nome_arquivo)

exibir(lista_numerosA)
#exibir(lista_numerosB)

lista_resultado = []
copiar_lista_sem_replicados(lista_numerosA, lista_resultado)
exibir(lista_resultado)