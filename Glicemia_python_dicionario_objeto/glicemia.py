from math import ceil


class Glicemia:
    def __init__(self, valor, data, hora):
        """construtor básico com os 3 atributos de classe

        Args:
            valor (int): de glicemia 
            data (string): dia
            hora (string): hora
        """
        self.valor = valor
        self.data = data
        self.hora = hora
        
    def __eq__(self, outro):
        if not isinstance(outro, Glicemia):
            return False
        return self.data == outro.data and self.hora == outro.hora
    
    def __str__(self):
        return f'valor glicemia: {self.valor}. . Data: {self.data}. Hora: {self.hora}'

    @staticmethod
    def calcular_media(lista):
        soma = 0
        for item in lista:
            soma += int(item.valor)

        return int(soma/len(lista))
    
    @staticmethod
    def calcular_mediana(lista):
        valores = sorted([int(item.valor) for item in lista])
        quantia = len(valores)
        if quantia % 2 == 0:
            mediana = (valores[quantia//2 - 1] + valores[quantia//2]) / 2
        else:
            mediana = valores[quantia//2]
        return ceil(mediana)