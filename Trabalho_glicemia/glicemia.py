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
    def verificar_turno_maior_glicemia(lista):
        manha = []        
        tarde = []
        noite = []
        for item in lista:
            if '05:00' <= item.hora < '12:00':
                manha.append(int(item.valor))
            elif '12:00' <= item.hora < '18:00':
                tarde.append(int(item.valor))
            elif '18:00' <= item.hora < '05:00':
                noite.append(int(item.valor))

        if lista.calcular_media(manha) > lista.calcular_media(tarde) and lista.calcular_media(manha) > lista.calcular_media(noite):
            return 'Manhã',lista.calcular_media(manha)
        elif lista.calcular_media(tarde) > lista.calcular_media(manha) and lista.calcular_media(tarde) > lista.calcular_media(noite):
            return 'Tarde',lista.calcular_media(tarde)
        elif lista.calcular_media(noite) > lista.calcular_media(manha) and lista.calcular_media(noite) > lista.calcular_media(tarde):
            return 'Noite',lista.calcular_media(noite)
        elif lista.calcular_media(manha) == lista.calcular_media(tarde) and lista.calcular_media(manha) > lista.calcular_media(noite):
            return 'Manhã e Tarde',lista.calcular_media(manha)
        elif lista.calcular_media(manha) == lista.calcular_media(noite) and lista.calcular_media(manha) > lista.calcular_media(tarde):
            return 'Manhã e Noite',lista.calcular_media(manha)
        elif lista.calcular_media(tarde) == lista.calcular_media(noite) and lista.calcular_media(tarde) > lista.calcular_media(manha):
            return 'Tarde e Noite',lista.calcular_media(tarde)
