#Trabalho/desafio avaliado.
#Baseado nos programas trabalhados em sala, (lista de objetos ou lista de dicionários), 
# refatorar um dos códigos para que o programa informe qual o turno em que a glicose ou glicemia é mais alta.

#Regras para turnos:
#    Manhã - das 5h 'as 12h
#    Tarde - das 12h 'as 18h
#    Noite - das 18h 'as 5h

#Código dever ser disponibilizado no github pessoal do aluno no repositório da disciplina.
#Data de entrega: 16/03/2026

from math import ceil

from glicemia import Glicemia

lista_dicionarios_glicemica = []
lista_glicemia_manha = []
lista_glicemia_tarde = []
lista_glicemia_noite = []
nome_arquivo = 'glicemia.txt'

def calcular_media(lista):
    soma = 0
    for item in lista:
        soma += int(item["valor"])
    return int(soma/len(lista)) 


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

    for item in lista_dicionarios_glicemica:
        if item["hora"] < "12:00":
            lista_glicemia_manha.append(item)
        elif item["hora"] < "18:00":
            lista_glicemia_tarde.append(item)
        else:
            lista_glicemia_noite.append(item)


print('Quantidade de dados lidos: ', len(lista_dicionarios_glicemica))

print('Valores do arquivo glicemia:')
for item in lista_dicionarios_glicemica:
    print(item["valor"])

print('Valores em ordem crescente de valor:')
for item in sorted(lista_dicionarios_glicemica, key=lambda x: int(x["valor"])):
    print(item["valor"])

print('Média: ', calcular_media(lista_dicionarios_glicemica))

print('Média da manhã: ', sorted(lista_glicemia_manha, key=lambda x: int(x["valor"])))
print('Média da tarde: ', sorted(lista_glicemia_tarde, key=lambda x: int(x["valor"])))
print('Média da noite: ', sorted(lista_glicemia_noite, key=lambda x: int(x["valor"])))

if calcular_media(lista_glicemia_manha) > calcular_media(lista_glicemia_tarde) and calcular_media(lista_glicemia_manha) > calcular_media(lista_glicemia_noite):
    print('O turno com a glicemia mais alta é: Manhã')  
    print('Média da manhã: ', calcular_media(lista_glicemia_manha))
elif calcular_media(lista_glicemia_tarde) > calcular_media(lista_glicemia_manha) and calcular_media(lista_glicemia_tarde) > calcular_media(lista_glicemia_noite):
    print('O turno com a glicemia mais alta é: Tarde')
    print('Média da tarde: ', calcular_media(lista_glicemia_tarde))
elif calcular_media(lista_glicemia_noite) > calcular_media(lista_glicemia_manha) and calcular_media(lista_glicemia_noite) > calcular_media(lista_glicemia_tarde):
    print('O turno com a glicemia mais alta é: Noite')
    print('Média da noite: ', calcular_media(lista_glicemia_noite))
elif calcular_media(lista_glicemia_manha) == calcular_media(lista_glicemia_tarde) and calcular_media(lista_glicemia_manha) > calcular_media(lista_glicemia_noite):
    print('Os turnos com a glicemia mais alta com médias iguais são: Manhã e Tarde')
    print('Média mannhã e tarde: ', calcular_media(lista_glicemia_manha))
elif calcular_media(lista_glicemia_manha) == calcular_media(lista_glicemia_noite) and calcular_media(lista_glicemia_manha) > calcular_media(lista_glicemia_tarde):
    print('Os turnos com a glicemia mais alta com médias iguais são: Manhã e Noite')
    print('Média mannhã e noite: ', calcular_media(lista_glicemia_manha))
elif calcular_media(lista_glicemia_tarde) == calcular_media(lista_glicemia_noite) and calcular_media(lista_glicemia_tarde) > calcular_media(lista_glicemia_manha):
    print('Os turnos com a glicemia mais alta com médias iguais são: Tarde e Noite')
    print('Média tarde e noite: ', calcular_media(lista_glicemia_tarde))