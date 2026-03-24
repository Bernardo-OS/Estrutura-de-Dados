class Aluno:
    def __init__(self, nome):
        self.nome = nome
        self.email = self.gerar_email(nome)

    def gerar_email(self, nome):
        dados_nome = nome.split()
        self.email = dados_nome[0].lower()+"." + dados_nome[-1].lower() + "@ufn.edu.br"
        return self.email

    def __str__(self):
        return f"Nome: {self.nome}, Email: {self.email}"