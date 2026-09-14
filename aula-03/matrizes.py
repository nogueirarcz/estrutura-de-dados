"""
AULA 03 - MATRIZES EM PYTHON
============================

Disciplina: Estrutura de Dados
Curso: Engenharia de Softwarej

Na aula 02 vimos a lista: uma sequência de valores em uma única "linha".
Mas muita informação do mundo real vem em forma de TABELA, com linhas e
colunas: as notas de cada aluno em cada prova, um tabuleiro de jogo, uma
planilha, os pixels de uma imagem.

Para isso usamos a MATRIZ. Em Python, uma matriz é simplesmente uma lista
em que cada item é outra lista: uma LISTA DE LISTAS. Cada lista interna é
uma linha da tabela.

Este arquivo está dividido em duas partes:

    PARTE 1 - O BÁSICO (seções 1 a 7)
        Criar, acessar, alterar e percorrer matrizes.

    PARTE 2 - PARA IR ALÉM (seções 8 e 9)
        Uma armadilha clássica e um exercício tradicional.
        Leia depois de praticar a parte 1.

Execute este arquivo para ver os exemplos em ação:

    python3 matrizes.py
"""


def titulo(texto: str) -> None:
    """Imprime um título de seção para organizar a saída no terminal."""
    print()
    print("=" * 70)
    print(texto)
    print("=" * 70)


def mostrar(matriz: list) -> None:
    """Imprime a matriz linha por linha, como uma tabela."""
    for linha in matriz:
        print(f"  {linha}")


# ===========================================================================
# PARTE 1 - O BÁSICO
# ===========================================================================

# ---------------------------------------------------------------------------
# 1. O QUE É UMA MATRIZ
# ---------------------------------------------------------------------------
titulo("1. O que é uma matriz")

# Uma matriz é uma lista de listas. Cada lista interna é uma LINHA.
# Esta matriz tem 2 linhas e 3 colunas (dizemos que é uma matriz 2 x 3):
matriz = [
    [1, 2, 3],   # linha 0
    [4, 5, 6],   # linha 1
]
print(f"matriz = {matriz}")

# Impressa linha por linha fica mais fácil de enxergar a tabela:
print("\nlinha por linha:")
mostrar(matriz)

# O número de linhas é o tamanho da lista de fora.
# O número de colunas é o tamanho de uma das linhas.
print(f"\nlinhas  = len(matriz)    = {len(matriz)}")
print(f"colunas = len(matriz[0]) = {len(matriz[0])}")


# ---------------------------------------------------------------------------
# 2. ACESSANDO UM ITEM: matriz[linha][coluna]
# ---------------------------------------------------------------------------
titulo("2. Acessando um item: matriz[linha][coluna]")

# Cada item tem DOIS índices: primeiro a linha, depois a coluna.
# Os dois começam em 0.
#
#              coluna 0   coluna 1   coluna 2
#   linha 0  [    1,         2,         3    ]
#   linha 1  [    4,         5,         6    ]
matriz = [
    [1, 2, 3],
    [4, 5, 6],
]
print(f"matriz[0][0] = {matriz[0][0]}  <- linha 0, coluna 0")
print(f"matriz[0][2] = {matriz[0][2]}  <- linha 0, coluna 2")
print(f"matriz[1][0] = {matriz[1][0]}  <- linha 1, coluna 0")
print(f"matriz[1][2] = {matriz[1][2]}  <- linha 1, coluna 2 (o último)")

# Com um índice só, pegamos a LINHA inteira, que é uma lista:
print(f"\nmatriz[1]    = {matriz[1]}  <- a linha 1 inteira")

# Dica para não confundir: matriz[1][2] é "pegue a linha 1, depois pegue
# a coluna 2 dentro dela". É o mesmo que fazer em dois passos:
linha = matriz[1]
valor = linha[2]
print(f"linha = matriz[1]; valor = linha[2] -> {valor}")

# Índices que não existem geram IndexError, como nas listas:
try:
    print(matriz[2][0])
except IndexError as erro:
    print(f"\nmatriz[2][0] gera IndexError: {erro}  (só existem as linhas 0 e 1)")


# ---------------------------------------------------------------------------
# 3. ALTERANDO UM ITEM
# ---------------------------------------------------------------------------
titulo("3. Alterando um item")

matriz = [
    [1, 2, 3],
    [4, 5, 6],
]
print("antes:")
mostrar(matriz)

matriz[0][1] = 99       # linha 0, coluna 1
matriz[1][2] = 0        # linha 1, coluna 2
print("\ndepois de matriz[0][1] = 99 e matriz[1][2] = 0:")
mostrar(matriz)


# ---------------------------------------------------------------------------
# 4. CRIANDO UMA MATRIZ CHEIA DE ZEROS
# ---------------------------------------------------------------------------
titulo("4. Criando uma matriz cheia de zeros")

# Muitas vezes precisamos criar uma matriz "vazia" (cheia de zeros) para
# preencher depois. Fazemos isso com um for: para cada linha, criamos uma
# lista NOVA de zeros e adicionamos à matriz.
linhas = 3
colunas = 4
zeros = []
for _ in range(linhas):             # o _ é usado quando não precisamos do valor
    zeros.append([0] * colunas)     # uma linha nova com 4 zeros

print(f"matriz {linhas} x {colunas} de zeros:")
mostrar(zeros)

# Agora dá para preencher posição por posição:
zeros[0][0] = 1
zeros[2][3] = 7
print("\ndepois de zeros[0][0] = 1 e zeros[2][3] = 7:")
mostrar(zeros)

# CUIDADO: existe um atalho que PARECE fazer a mesma coisa, [[0] * 4] * 3,
# mas ele cria uma armadilha. Veja a seção 8.


# ---------------------------------------------------------------------------
# 5. PERCORRENDO A MATRIZ COM DOIS for
# ---------------------------------------------------------------------------
titulo("5. Percorrendo a matriz com dois for")

matriz = [
    [1, 2, 3],
    [4, 5, 6],
]

# O for de fora passa por cada LINHA; o de dentro, por cada VALOR da linha.
print("for linha in matriz:  /  for valor in linha:")
for linha in matriz:
    for valor in linha:
        print(f"  valor {valor}")

# Para imprimir como uma tabela, usamos end=" " para não pular linha a cada
# valor, e um print() vazio ao terminar cada linha:
print("\nimpressa como tabela:")
for linha in matriz:
    for valor in linha:
        print(valor, end=" ")
    print()

# Quando precisamos saber a POSIÇÃO de cada item, usamos índices com range.
# Por convenção, i é o índice da linha e j o da coluna.
print("\nfor i in range(len(matriz)):  /  for j in range(len(matriz[0])):")
for i in range(len(matriz)):
    for j in range(len(matriz[0])):
        print(f"  matriz[{i}][{j}] = {matriz[i][j]}")


# ---------------------------------------------------------------------------
# 6. SOMANDO LINHAS E COLUNAS
# ---------------------------------------------------------------------------
titulo("6. Somando linhas e colunas")

# Notas de 3 alunos em 2 provas. Cada LINHA é um aluno, cada COLUNA é uma prova.
#
#            prova 0   prova 1
#   Ana    [   7.0,      8.0   ]
#   Bruno  [   5.5,      6.5   ]
#   Carla  [   9.0,     10.0   ]
notas = [
    [7.0, 8.0],
    [5.5, 6.5],
    [9.0, 10.0],
]
alunos = ["Ana", "Bruno", "Carla"]

# Soma de uma LINHA: a linha é uma lista, então sum() resolve.
print(f"notas da Ana    = {notas[0]} -> soma = {sum(notas[0])}")

# Soma de uma COLUNA: precisamos pegar o MESMO índice em cada linha.
soma_prova_0 = 0
for linha in notas:
    soma_prova_0 = soma_prova_0 + linha[0]
print(f"soma da prova 0 = {soma_prova_0}")

# Média de cada aluno (uma média por linha):
print("\nmédia por aluno:")
for i in range(len(alunos)):
    media = sum(notas[i]) / len(notas[i])
    print(f"  {alunos[i]}: {media:.1f}")

# Média de cada prova (uma média por coluna):
print("\nmédia por prova:")
for j in range(len(notas[0])):
    soma = 0
    for i in range(len(notas)):
        soma = soma + notas[i][j]
    print(f"  prova {j}: {soma / len(notas):.1f}")

# Soma de TUDO: um for dentro do outro.
total = 0
for linha in notas:
    for valor in linha:
        total = total + valor
print(f"\nsoma de todas as notas = {total}")


# ---------------------------------------------------------------------------
# 7. EXEMPLO PRÁTICO: TABULEIRO DO JOGO DA VELHA
# ---------------------------------------------------------------------------
titulo("7. Exemplo prático: tabuleiro do jogo da velha")

# Um tabuleiro 3 x 3 começa vazio. Usamos "-" para as casas livres.
tabuleiro = []
for _ in range(3):
    tabuleiro.append(["-"] * 3)

# Cada jogada marca uma posição [linha][coluna]:
tabuleiro[0][0] = "X"
tabuleiro[0][1] = "O"
tabuleiro[1][1] = "X"
tabuleiro[2][0] = "O"
tabuleiro[2][2] = "X"

print("tabuleiro:")
for linha in tabuleiro:
    print("  " + " ".join(linha))     # join junta os itens da linha com espaço

# Alguém venceu na linha 0? Os três precisam ser iguais e não podem ser "-".
linha = tabuleiro[0]
if linha[0] != "-" and linha[0] == linha[1] and linha[1] == linha[2]:
    print(f"\n{linha[0]} venceu na linha 0!")
else:
    print("\nninguém venceu na linha 0")

# E na diagonal principal? São as posições [0][0], [1][1] e [2][2].
diagonal = [tabuleiro[0][0], tabuleiro[1][1], tabuleiro[2][2]]
print(f"diagonal principal = {diagonal}")
if diagonal[0] != "-" and diagonal[0] == diagonal[1] and diagonal[1] == diagonal[2]:
    print(f"{diagonal[0]} venceu na diagonal!")


# ===========================================================================
# PARTE 2 - PARA IR ALÉM
# ===========================================================================
# Daqui em diante o conteúdo é mais avançado. Leia depois de praticar a parte 1.

# ---------------------------------------------------------------------------
# 8. A ARMADILHA DE CRIAR A MATRIZ COM MULTIPLICAÇÃO
# ---------------------------------------------------------------------------
titulo("8. [Além] A armadilha de criar a matriz com multiplicação")

# Parece um atalho bom: [[0] * 3] * 3 cria 3 linhas com 3 zeros...
errada = [[0] * 3] * 3
print("errada = [[0] * 3] * 3")
mostrar(errada)

# ...mas as 3 "linhas" são a MESMA lista repetida 3 vezes (lembra da aula 02,
# seção 10: duas variáveis, uma só lista?). Alterar uma altera todas:
errada[0][0] = 1
print("\ndepois de errada[0][0] = 1:")
mostrar(errada)
print("  <- as três linhas mudaram!")

# A forma certa é criar uma lista NOVA para cada linha, como na seção 4,
# ou com uma list comprehension (aula 02, seção 11):
certa = [[0] * 3 for _ in range(3)]
certa[0][0] = 1
print("\ncerta = [[0] * 3 for _ in range(3)], depois de certa[0][0] = 1:")
mostrar(certa)


# ---------------------------------------------------------------------------
# 9. TROCANDO LINHAS POR COLUNAS (TRANSPOSTA)
# ---------------------------------------------------------------------------
titulo("9. [Além] Trocando linhas por colunas (transposta)")

# A transposta de uma matriz é a matriz "virada": as linhas viram colunas.
# Uma matriz 2 x 3 vira 3 x 2.
matriz = [
    [1, 2, 3],
    [4, 5, 6],
]
linhas = len(matriz)
colunas = len(matriz[0])

# Criamos a nova matriz com as dimensões trocadas e copiamos cada item
# da posição [i][j] para a posição [j][i]:
transposta = [[0] * linhas for _ in range(colunas)]
for i in range(linhas):
    for j in range(colunas):
        transposta[j][i] = matriz[i][j]

print("matriz (2 x 3):")
mostrar(matriz)
print("\ntransposta (3 x 2):")
mostrar(transposta)
# É um exercício clássico: vale a pena reescrever de cabeça, sem olhar.


# ---------------------------------------------------------------------------
# RESUMO
# ---------------------------------------------------------------------------
titulo("RESUMO")
print("""
Considere:
    m = [
        [1, 2, 3],
        [4, 5, 6],
    ]

| O que fazer             | Como                                   | Resultado   |
|-------------------------|----------------------------------------|-------------|
| Número de linhas        | len(m)                                 | 2           |
| Número de colunas       | len(m[0])                              | 3           |
| Acessar um item         | m[1][2]                                | 6           |
| Pegar uma linha inteira | m[1]                                   | [4, 5, 6]   |
| Alterar um item         | m[0][0] = 9                            | [9, 2, 3]   |
| Somar uma linha         | sum(m[0])                              | 6           |
| Somar uma coluna        | for linha in m: soma += linha[0]       | 5           |
| Percorrer tudo          | for linha in m: / for valor in linha:  |             |
| Percorrer com posições  | for i in range(len(m)): / for j in ... |             |
| Criar L x C de zeros    | for _ in range(L): m.append([0] * C)   |             |

Lembre-se:
  - Primeiro a LINHA, depois a COLUNA: m[linha][coluna]. Os dois começam em 0.
  - m[i] sozinho é a linha inteira (uma lista).
  - Para somar uma coluna, percorra as linhas pegando sempre o mesmo índice.
  - NÃO crie matrizes com [[0] * C] * L: as linhas ficam "coladas" (seção 8).

Próximos passos: dicionários, a coleção de chave e valor.
""")
