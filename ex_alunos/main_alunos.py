from ex_alunos import Aluno

alunos = Aluno.ler_alunos(r"C:\Users\laboratorio\Downloads\registros_alunos.csv")
print("1. Ordenar por Ano de Ingresso")
print("2. Ordenar por Nome")
print("3. Buscar Aluno por Nome")
print("4. Contar Ingressos por Ano")
opcao = int(input("Digite a opção desejada: "))



match opcao:

    case 1:
        print("Opção 1 selecionada (ORDENAR POR ANO)")
        ordenados_ano = Aluno.ordenar_alunos(alunos, "ano")
        for aluno in ordenados_ano:
            print(aluno)
    case 2:
        print("Opção 2 selecionada (ORDENAR POR NOME)")
        ordenados_nome = Aluno.ordenar_alunos(alunos, "nome")
        for aluno in ordenados_nome:
            print(aluno)
    case 3:
        print("Opção 3 selecionada (BUSCAR ALUNO)")
        buscar_nome = input("Digite o nome do aluno para busca: ")
        print(Aluno.buscar_aluno(alunos, buscar_nome))
    case 4:
        print("Opção 4 selecionada (CONTAR INGRESSOS POR ANO)")
        print(Aluno.contar_ingressos_por_ano(alunos))

    case _:
        print("Opção inválida")