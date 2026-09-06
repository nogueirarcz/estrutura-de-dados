"""
AULA 02 - LISTAS EM PYTHON
==========================

Disciplina: Estrutura de Dados
Curso: Engenharia de Software

Na aula 01 vimos os tipos primitivos: um número, um texto, um booleano.
Mas quase todo programa precisa guardar VÁRIOS valores juntos: as notas
de uma turma, os itens de um carrinho, os nomes de uma lista de presença.

Para isso existe a LISTA (list): uma sequência de valores, em ordem,
que pode crescer, encolher e ser alterada a qualquer momento.

Este arquivo está dividido em duas partes:

    PARTE 1 - O BÁSICO (seções 1 a 9)
        Tudo o que você precisa para usar listas no dia a dia.

    PARTE 2 - PARA IR ALÉM (seções 10 a 12)
        Alguns recursos a mais sobre listas.
        Leia depois de praticar a parte 1.

Execute este arquivo para ver os exemplos em ação:

    python3 listas.py
"""


def titulo(texto: str) -> None:
    """Imprime um título de seção para organizar a saída no terminal."""
    print()
    print("=" * 70)
    print(texto)
    print("=" * 70)


# ===========================================================================
# PARTE 1 - O BÁSICO
# ===========================================================================

# ---------------------------------------------------------------------------
# 1. CRIANDO LISTAS
# ---------------------------------------------------------------------------
titulo("1. Criando listas")

# Uma lista é escrita entre colchetes, com os itens separados por vírgula.
notas = [7.5, 8.0, 6.5, 9.0]
nomes = ["Ana", "Bruno", "Carla"]
vazia = []
print(f"notas = {notas}")
print(f"nomes = {nomes}")
print(f"vazia = {vazia}")

# len() diz quantos itens a lista tem:
print(f"\nlen(notas) = {len(notas)}")
print(f"len(vazia) = {len(vazia)}")

# A lista aceita qualquer tipo de valor, até misturados:
mista = [42, "texto", 3.14, True]
print(f"\nmista = {mista}")


# ---------------------------------------------------------------------------
# 2. ACESSANDO ITENS PELO ÍNDICE
# ---------------------------------------------------------------------------
titulo("2. Acessando itens pelo índice")

# Cada item tem uma posição, chamada de ÍNDICE. A contagem começa em 0.
#
#   "Ana"  "Bruno"  "Carla"  "Davi"
#     0       1        2       3
#    -4      -3       -2      -1
alunos = ["Ana", "Bruno", "Carla", "Davi"]
print(f"alunos[0]  = {alunos[0]}   <- primeiro")
print(f"alunos[1]  = {alunos[1]}")
print(f"alunos[3]  = {alunos[3]}  <- último")
print(f"alunos[-1] = {alunos[-1]}  <- índice negativo: conta a partir do fim")

# Acessar uma posição que não existe gera um erro (IndexError):
try:
    print(alunos[4])
except IndexError as erro:
    print(f"\nalunos[4] gera IndexError: {erro}")


# ---------------------------------------------------------------------------
# 3. PEGANDO UM PEDAÇO DA LISTA (FATIAMENTO)
# ---------------------------------------------------------------------------
titulo("3. Pegando um pedaço da lista (fatiamento)")

# lista[início:fim] devolve uma NOVA lista com os itens do início até o fim.
# O item do índice "fim" NÃO entra.
alunos = ["Ana", "Bruno", "Carla", "Davi", "Elisa"]
print(f"alunos      = {alunos}")
print(f"alunos[1:3] = {alunos[1:3]}  <- índices 1 e 2 (o 3 fica de fora)")
print(f"alunos[:2]  = {alunos[:2]}  <- do início até o índice 2")
print(f"alunos[2:]  = {alunos[2:]}  <- do índice 2 até o fim")
print(f"alunos[-2:] = {alunos[-2:]}  <- os dois últimos")


# ---------------------------------------------------------------------------
# 4. ALTERANDO ITENS
# ---------------------------------------------------------------------------
titulo("4. Alterando itens")

# Diferente das strings (aula 01), a lista PODE ser alterada depois de criada.
# Dizemos que a lista é MUTÁVEL.
numeros = [10, 20, 30]
print(f"antes:  {numeros}")
numeros[0] = 99
print(f"depois: {numeros}  <- numeros[0] = 99")

# Com string isso não funciona:
texto = "abc"
try:
    texto[0] = "z"
except TypeError:
    print("\ntexto[0] = 'z' gera TypeError: string não pode ser alterada")


# ---------------------------------------------------------------------------
# 5. ADICIONANDO ITENS
# ---------------------------------------------------------------------------
titulo("5. Adicionando itens")

fila = ["Ana"]
print(f"início:             {fila}")

fila.append("Bruno")             # adiciona UM item no FIM
print(f"append('Bruno')     -> {fila}")

fila.insert(0, "Carla")          # insere na POSIÇÃO indicada (os outros andam para frente)
print(f"insert(0, 'Carla')  -> {fila}")

fila.extend(["Davi", "Elisa"])   # adiciona VÁRIOS itens no fim
print(f"extend([...])       -> {fila}")

# CUIDADO: append com uma lista coloca a lista inteira como UM item só.
errado = [1, 2]
errado.append([3, 4])
certo = [1, 2]
certo.extend([3, 4])
print(f"\n[1, 2].append([3, 4]) -> {errado}  <- lista dentro de lista")
print(f"[1, 2].extend([3, 4]) -> {certo}    <- o que normalmente queremos")


# ---------------------------------------------------------------------------
# 6. REMOVENDO ITENS
# ---------------------------------------------------------------------------
titulo("6. Removendo itens")

letras = ["a", "b", "c", "d"]
print(f"início:      {letras}")

removida = letras.pop()          # remove o ÚLTIMO e devolve ele
print(f"pop()        -> {letras}  (removeu {removida!r})")

removida = letras.pop(0)         # remove pela POSIÇÃO e devolve
print(f"pop(0)       -> {letras}  (removeu {removida!r})")

letras.remove("c")               # remove pelo VALOR (a primeira ocorrência)
print(f"remove('c')  -> {letras}")

letras.clear()                   # esvazia a lista
print(f"clear()      -> {letras}")

# remove() de um valor que não existe gera erro (ValueError):
try:
    letras.remove("z")
except ValueError as erro:
    print(f"\nremove('z') gera ValueError: {erro}")


# ---------------------------------------------------------------------------
# 7. PROCURANDO ITENS
# ---------------------------------------------------------------------------
titulo("7. Procurando itens")

frutas = ["maçã", "banana", "uva", "banana"]
print(f"frutas = {frutas}")

# "in" responde se o item está na lista:
print(f"\n'uva' in frutas  -> {'uva' in frutas}")
print(f"'kiwi' in frutas -> {'kiwi' in frutas}")

# index() diz a posição da PRIMEIRA ocorrência; count() diz quantas vezes aparece:
print(f"\nfrutas.index('banana') = {frutas.index('banana')}")
print(f"frutas.count('banana') = {frutas.count('banana')}")

# index() de um valor que não existe gera ValueError. Por isso, teste com "in" antes:
if "kiwi" in frutas:
    print(frutas.index("kiwi"))
else:
    print("\n'kiwi' não está na lista")


# ---------------------------------------------------------------------------
# 8. ORDENANDO E INVERTENDO
# ---------------------------------------------------------------------------
titulo("8. Ordenando e invertendo")

notas = [7.5, 9.0, 6.0, 8.5]
print(f"notas = {notas}")

# sorted() devolve uma NOVA lista ordenada. A original não muda.
print(f"\nsorted(notas) = {sorted(notas)}")
print(f"notas         = {notas}  <- continua igual")

# sort() ordena a PRÓPRIA lista.
notas.sort()
print(f"\nnotas.sort()             -> {notas}")
notas.sort(reverse=True)
print(f"notas.sort(reverse=True) -> {notas}  <- do maior para o menor")

# CUIDADO: sort() não devolve nada (devolve None). Este erro é muito comum:
resultado = [3, 1, 2].sort()
print(f"\nresultado = [3, 1, 2].sort() -> {resultado}  <- errado! Use sorted() para guardar o resultado")

# reverse() inverte a ordem dos itens (sem ordenar):
letras = ["a", "b", "c"]
letras.reverse()
print(f"\n['a', 'b', 'c'].reverse() -> {letras}")

# Strings também podem ser ordenadas (em ordem alfabética):
print(f"sorted(['uva', 'banana', 'abacaxi']) = {sorted(['uva', 'banana', 'abacaxi'])}")


# ---------------------------------------------------------------------------
# 9. PERCORRENDO A LISTA COM for E FUNÇÕES PRONTAS
# ---------------------------------------------------------------------------
titulo("9. Percorrendo a lista com for (e sum, min, max)")

compras = ["pão", "leite", "café"]

# O for visita cada item, um de cada vez:
print("for item in compras:")
for item in compras:
    print(f"  - {item}")

# Se precisar do índice junto, use enumerate():
print("\nfor i, item in enumerate(compras):")
for i, item in enumerate(compras):
    print(f"  {i}: {item}")

# Exemplo prático: somar as notas com o for.
notas = [7.5, 8.0, 6.5, 9.0]
soma = 0
for nota in notas:
    soma = soma + nota
print(f"\nsoma com for = {soma}")

# Para somar, achar o menor e o maior, o Python já tem funções prontas:
print(f"sum(notas)   = {sum(notas)}")
print(f"min(notas)   = {min(notas)}")
print(f"max(notas)   = {max(notas)}")
print(f"média        = {sum(notas) / len(notas):.2f}")


# ===========================================================================
# PARTE 2 - PARA IR ALÉM
# ===========================================================================
# Daqui em diante o conteúdo é mais avançado. Leia depois de praticar a parte 1.

# ---------------------------------------------------------------------------
# 10. DUAS VARIÁVEIS, UMA SÓ LISTA
# ---------------------------------------------------------------------------
titulo("10. [Além] Duas variáveis, uma só lista")

# Ao fazer b = a, o Python NÃO cria uma lista nova. As duas variáveis passam
# a apontar para a MESMA lista. Alterar por uma altera para a outra.
a = [1, 2, 3]
b = a
b.append(4)
print("a = [1, 2, 3]; b = a; b.append(4)")
print(f"a = {a}  <- mudou também!")
print(f"b = {b}")

# Para ter uma lista independente, faça uma CÓPIA com .copy():
a = [1, 2, 3]
b = a.copy()
b.append(4)
print("\na = [1, 2, 3]; b = a.copy(); b.append(4)")
print(f"a = {a}  <- continua igual")
print(f"b = {b}")


# ---------------------------------------------------------------------------
# 11. LIST COMPREHENSION
# ---------------------------------------------------------------------------
titulo("11. [Além] List comprehension")

# Uma forma curta de criar uma lista a partir de outra.
# Estas duas formas fazem a mesma coisa:
quadrados = []
for n in range(1, 6):
    quadrados.append(n * n)
print(f"com for:           {quadrados}")

quadrados = [n * n for n in range(1, 6)]
print(f"com comprehension: {quadrados}")

# Também dá para filtrar com if:
pares = [n for n in range(1, 11) if n % 2 == 0]
print(f"\npares de 1 a 10:   {pares}")


# ---------------------------------------------------------------------------
# 12. LISTAS DENTRO DE LISTAS (MATRIZES)
# ---------------------------------------------------------------------------
titulo("12. [Além] Listas dentro de listas (matrizes)")

# Uma lista pode conter outras listas. É assim que representamos uma tabela:
tabela = [
    [1, 2, 3],
    [4, 5, 6],
]
print(f"tabela       = {tabela}")
print(f"tabela[0]    = {tabela[0]}  <- primeira linha")
print(f"tabela[1][2] = {tabela[1][2]}  <- segunda linha, terceira coluna")


# ---------------------------------------------------------------------------
# RESUMO
# ---------------------------------------------------------------------------
titulo("RESUMO")
print("""
Considere lista = [1, 2, 3]

| O que fazer            | Como                    | Resultado                    |
|------------------------|-------------------------|------------------------------|
| Tamanho                | len(lista)              | 3                            |
| Acessar                | lista[0]  /  lista[-1]  | 1  /  3                      |
| Fatiar                 | lista[0:2]              | [1, 2]                       |
| Alterar                | lista[0] = 9            | [9, 2, 3]                    |
| Adicionar no fim       | lista.append(4)         | [1, 2, 3, 4]                 |
| Inserir em posição     | lista.insert(0, 4)      | [4, 1, 2, 3]                 |
| Adicionar vários       | lista.extend([4, 5])    | [1, 2, 3, 4, 5]              |
| Remover do fim         | lista.pop()             | devolve 3, sobra [1, 2]      |
| Remover por posição    | lista.pop(0)            | devolve 1, sobra [2, 3]      |
| Remover por valor      | lista.remove(2)         | [1, 3]                       |
| Está na lista?         | 2 in lista              | True                         |
| Posição de um valor    | lista.index(2)          | 1                            |
| Contar                 | lista.count(2)          | 1                            |
| Ordenar (nova lista)   | sorted(lista)           | a original não muda          |
| Ordenar (no lugar)     | lista.sort()            | altera a original            |
| Inverter               | lista.reverse()         | [3, 2, 1]                    |
| Somar / menor / maior  | sum, min, max           | 6 / 1 / 3                    |

Lembre-se:
  - O primeiro índice é 0 e o último é -1.
  - sort() altera a lista e não devolve nada; sorted() devolve uma lista nova.
  - append(x) adiciona UM item; extend([...]) adiciona vários.
  - b = a NÃO copia a lista. Use b = a.copy().

Próximos passos: as outras coleções do Python (tuple, set e dict).
""")
