from collections import deque


class FichaAtendimento:
    def __init__(self):
        self.fila_normal = deque()
        self.fila_prioritaria = deque()
        self.contador_normal = 0
        self.contador_prioritaria = 0
        self.contador_atendimentos = 0
    
    @staticmethod
    def gera_ficha_normal(fila_normal, contador_normal):
        print("Gerando ficha normal...")
        print(contador_normal)
        fila_normal.append(contador_normal)
        contador_normal += 1
        return fila_normal, contador_normal
    
    @staticmethod
    def gera_ficha_prioritaria(fila_prioritaria, contador_prioritaria):
        print("Gerando ficha prioritaria...")
        print(contador_prioritaria)
        fila_prioritaria.append(contador_prioritaria)
        contador_prioritaria += 1
        return fila_prioritaria, contador_prioritaria
    
    @staticmethod
    def gera_atendimento(fila_normal, fila_prioritaria, contador_atendimentos):
        if not fila_normal and not fila_prioritaria:
            print("Nao ha fichas para chamar")
            return contador_atendimentos

    @staticmethod
    def mostra_fichas_faltantes(fila_normal, fila_prioritaria):
        if not fila_normal and not fila_prioritaria:
            print("Nao ha fichas para chamar")
        
        print("Mostrando fichas faltantes.... ")
        if not fila_normal:
            print("Total de fichas faltantes: " + str(len(fila_normal)) + " - " + str(list(fila_normal)))
        
        if not fila_prioritaria:
            print("Total de fichas faltantes: " + str(len(fila_prioritaria)) + " - " + str(list(fila_prioritaria)))

    @staticmethod
    def menu():
        pass

if __name__ == "__main__":

    FichaAtendimento.menu()
