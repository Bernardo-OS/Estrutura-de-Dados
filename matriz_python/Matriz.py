import Dado

class Matriz():
    def __init__(self, matriz, lin, col, lista):      
        self.lin = lin
        self.col = col
        self.matriz = matriz
        self.lista = lista

    def inicializar_matriz(self, matriz, lin, col):
        for i in range(lin):
            for j in range(col):
                matriz[i][j] = 0

    def exibir_matriz(self, matriz, lin, col):
        for i in range(lin):
            for j in range(col):
                print(matriz[i][j], end=' ')
            print()
            
    def converter_matriz_lista(self, matriz, lin, col, lista):    
        for i in range(lin):
            for j in range(col):
                if matriz[i][j] != 0:
                    lista.append(Dado.Dado(matriz[i][j], lin, col))

    def exibir_lista(self, lista):
        for i in range(len(lista)):
            print(lista[i], end=' ')
        print('----------------------------')
        print('total de elementos nao nulos: ', len(lista))

    