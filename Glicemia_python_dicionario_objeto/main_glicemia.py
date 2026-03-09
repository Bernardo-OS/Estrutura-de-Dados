from glicemia import Glicemia

lista_glicemica = []
nome_arquivo = 'glicemia.txt'

with open(nome_arquivo, 'r', encoding='utf8') as leitor:
    for linha in leitor:
        valor, data, hora = linha.split(',')
        objeto = Glicemia(valor, data, hora)
        if objeto not in lista_glicemica:
            lista_glicemica.append( objeto )


print('Quantidade de dados lidos: ', len(lista_glicemica))
for linha in lista_glicemica:
    print(linha, end="")

print('Media Glicemica', Glicemia.calcular_media(lista_glicemica))