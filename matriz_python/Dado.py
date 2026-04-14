class Dado():
    def __init__(self, valor, lin, col):      
        self.valor = valor
        self.lin = lin
        self.col = col

    def __eq__(self, value):
        if isinstance(value, Matriz):
            return self.valor == value.valor and self.lin == value.lin and self.col == value.col
        return False
    
    def __str__(self):
        return f'Matriz(valor={self.valor}, lin={self.lin}, col={self.col})'
        