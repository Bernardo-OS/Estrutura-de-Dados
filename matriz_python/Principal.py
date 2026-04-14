import Matriz

lin = 10
col = 10
matriz = [[0 for j in range(col)] for i in range(lin)]
lista = []

matriz_obj = Matriz.Matriz(matriz, lin, col, lista)
matriz_obj.inicializar_matriz(matriz, lin, col)

matriz[0][3] = 1
matriz[2][5] = 1
matriz[5][7] = 1
matriz[6][8] = 1

matriz_obj.exibir_matriz(matriz, lin, col)

#converter matriz em lista
lista = []
matriz_obj.converter_matriz_lista(matriz, lin, col, lista)
matriz_obj.exibir_lista(lista)
