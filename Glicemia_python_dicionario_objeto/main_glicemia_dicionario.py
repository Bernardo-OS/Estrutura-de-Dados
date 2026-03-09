from math import ceil

from glicemia import Glicemia

lista_dicionarios_glicemica = []
nome_arquivo = 'glicemia.txt'

def calcular_media(lista):
    soma = 0
    for item in lista:
        soma += int(item["valor"])
    return int(soma/len(lista)) 

def calcular_mediana(lista):
    valores = sorted([int(item["valor"]) for item in lista])
    quantia = len(valores)
    if quantia % 2 == 0:
        mediana = (valores[quantia//2 - 1] + valores[quantia//2]) / 2
    else:
        mediana = valores[quantia//2]
    return ceil(mediana)


with open(nome_arquivo, 'r', encoding='utf8') as leitor:
    for linha in leitor:
        valor, data, hora = linha.split(',')
        dados = {
            "valor": valor,
            "data": data,
            "hora": hora
        }
        if not any(item["data"] == dados["data"] and item["hora"] == dados["hora"] for item in lista_dicionarios_glicemica):
            lista_dicionarios_glicemica.append(dados)


print('Quantidade de dados lidos: ', len(lista_dicionarios_glicemica))

print('Valores do arquivo glicemia:')
for item in lista_dicionarios_glicemica:
    print(item["valor"])

print('Valores em ordem crescente de valor:')
for item in sorted(lista_dicionarios_glicemica, key=lambda x: int(x["valor"])):
    print(item["valor"])

print('Média: ', calcular_media(lista_dicionarios_glicemica))
print('Mediana: ', calcular_mediana(lista_dicionarios_glicemica))