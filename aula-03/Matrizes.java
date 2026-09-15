/*
AULA 03 - MATRIZES EM JAVA
==========================

Disciplina: Estrutura de Dados
Curso: Engenharia de Software

Na aula 02 vimos a lista: uma sequência de valores em uma única "linha".
Mas muita informação do mundo real vem em forma de TABELA, com linhas e
colunas: as notas de cada aluno em cada prova, um tabuleiro de jogo, uma
planilha, os pixels de uma imagem.

Para isso usamos a MATRIZ. Em Java, uma matriz é um ARRAY DE ARRAYS: cada
item do array de fora é outro array, que é uma linha da tabela. Escrevemos
o tipo com dois pares de colchetes:

    int[][] matriz   -> matriz de números inteiros
    String[][] nomes -> matriz de textos

Este arquivo está dividido em duas partes:

    PARTE 1 - O BÁSICO (seções 1 a 7)
        Criar, acessar, alterar e percorrer matrizes.

    PARTE 2 - PARA IR ALÉM (seções 8 e 9)
        Matriz de ArrayList e um exercício tradicional.
        Leia depois de praticar a parte 1.

Execute este arquivo para ver os exemplos em ação (Java 17 ou superior):

    java Matrizes.java

Sempre que algo for diferente do Python (veja matrizes.py), será destacado.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matrizes {

    static void titulo(String texto) {
        System.out.println();
        System.out.println("=".repeat(70));
        System.out.println(texto);
        System.out.println("=".repeat(70));
    }

    /** Imprime a matriz linha por linha, como uma tabela. */
    static void mostrar(int[][] matriz) {
        for (int[] linha : matriz) {
            System.out.println("  " + Arrays.toString(linha));
        }
    }

    public static void main(String[] args) {

        // ===================================================================
        // PARTE 1 - O BÁSICO
        // ===================================================================

        // -------------------------------------------------------------------
        // 1. O QUE É UMA MATRIZ
        // -------------------------------------------------------------------
        titulo("1. O que é uma matriz");

        // Uma matriz é um array de arrays. Cada array interno é uma LINHA.
        // Esta matriz tem 2 linhas e 3 colunas (dizemos que é uma matriz 2 x 3):
        int[][] matriz = {
            {1, 2, 3},   // linha 0
            {4, 5, 6},   // linha 1
        };

        // DIFERENÇA: imprimir a matriz direto não mostra os valores, e sim um
        // código interno do Java. Para ver o conteúdo, usamos deepToString:
        System.out.println("System.out.println(matriz)      -> " + matriz);
        System.out.println("Arrays.deepToString(matriz)     -> " + Arrays.deepToString(matriz));

        // Impressa linha por linha fica mais fácil de enxergar a tabela:
        System.out.println("\nlinha por linha:");
        mostrar(matriz);

        // DIFERENÇA: arrays usam length (sem parênteses), não size() nem len().
        // O número de linhas é o tamanho do array de fora.
        // O número de colunas é o tamanho de uma das linhas.
        System.out.println("\nlinhas  = matriz.length    = " + matriz.length);
        System.out.println("colunas = matriz[0].length = " + matriz[0].length);


        // -------------------------------------------------------------------
        // 2. ACESSANDO UM ITEM: matriz[linha][coluna]
        // -------------------------------------------------------------------
        titulo("2. Acessando um item: matriz[linha][coluna]");

        // Cada item tem DOIS índices: primeiro a linha, depois a coluna.
        // Os dois começam em 0. Igualzinho ao Python.
        //
        //              coluna 0   coluna 1   coluna 2
        //   linha 0  [    1,         2,         3    ]
        //   linha 1  [    4,         5,         6    ]
        System.out.println("matriz[0][0] = " + matriz[0][0] + "  <- linha 0, coluna 0");
        System.out.println("matriz[0][2] = " + matriz[0][2] + "  <- linha 0, coluna 2");
        System.out.println("matriz[1][0] = " + matriz[1][0] + "  <- linha 1, coluna 0");
        System.out.println("matriz[1][2] = " + matriz[1][2] + "  <- linha 1, coluna 2 (o último)");

        // Com um índice só, pegamos a LINHA inteira, que é um array:
        System.out.println("\nmatriz[1]    = " + Arrays.toString(matriz[1]) + "  <- a linha 1 inteira");

        // Dica para não confundir: matriz[1][2] é "pegue a linha 1, depois pegue
        // a coluna 2 dentro dela". É o mesmo que fazer em dois passos:
        int[] linha = matriz[1];
        int valor = linha[2];
        System.out.println("int[] linha = matriz[1]; int valor = linha[2] -> " + valor);

        // Índices que não existem geram erro, como nas listas da aula 02:
        try {
            System.out.println(matriz[2][0]);
        } catch (ArrayIndexOutOfBoundsException erro) {
            System.out.println("\nmatriz[2][0] gera ArrayIndexOutOfBoundsException: "
                    + erro.getMessage() + "  (só existem as linhas 0 e 1)");
        }


        // -------------------------------------------------------------------
        // 3. ALTERANDO UM ITEM
        // -------------------------------------------------------------------
        titulo("3. Alterando um item");

        // DIFERENÇA: aqui os colchetes valem tanto para ler quanto para alterar.
        // Não existe get() nem set() em arrays, só em ArrayList (aula 02).
        int[][] alterada = {
            {1, 2, 3},
            {4, 5, 6},
        };
        System.out.println("antes:");
        mostrar(alterada);

        alterada[0][1] = 99;       // linha 0, coluna 1
        alterada[1][2] = 0;        // linha 1, coluna 2
        System.out.println("\ndepois de alterada[0][1] = 99 e alterada[1][2] = 0:");
        mostrar(alterada);


        // -------------------------------------------------------------------
        // 4. CRIANDO UMA MATRIZ CHEIA DE ZEROS
        // -------------------------------------------------------------------
        titulo("4. Criando uma matriz cheia de zeros");

        // Muitas vezes precisamos criar uma matriz "vazia" para preencher depois.
        // Em Java isso é fácil: basta dizer quantas linhas e quantas colunas.
        int linhas = 3;
        int colunas = 4;
        int[][] zeros = new int[linhas][colunas];

        // VANTAGEM SOBRE O PYTHON: o Java já cria todas as posições preenchidas
        // com o valor padrão do tipo, e cada linha é um array NOVO. Não existe
        // aqui a armadilha da multiplicação que o Python tem (matrizes.py, seção 8).
        //   int    -> 0        double  -> 0.0
        //   String -> null     boolean -> false
        System.out.println("new int[" + linhas + "][" + colunas + "]:");
        mostrar(zeros);

        // Agora dá para preencher posição por posição:
        zeros[0][0] = 1;
        zeros[2][3] = 7;
        System.out.println("\ndepois de zeros[0][0] = 1 e zeros[2][3] = 7:");
        mostrar(zeros);

        // Para preencher com outro valor, use um for (ou Arrays.fill em cada linha):
        int[][] uns = new int[2][3];
        for (int[] l : uns) {
            Arrays.fill(l, 1);
        }
        System.out.println("\nmatriz 2 x 3 preenchida com 1:");
        mostrar(uns);


        // -------------------------------------------------------------------
        // 5. PERCORRENDO A MATRIZ COM DOIS for
        // -------------------------------------------------------------------
        titulo("5. Percorrendo a matriz com dois for");

        int[][] tabela = {
            {1, 2, 3},
            {4, 5, 6},
        };

        // O for-each de fora passa por cada LINHA (que é um array);
        // o de dentro, por cada VALOR da linha.
        System.out.println("for (int[] l : tabela)  /  for (int v : l)");
        for (int[] l : tabela) {
            for (int v : l) {
                System.out.println("  valor " + v);
            }
        }

        // Para imprimir como uma tabela, usamos print (sem ln) para não pular
        // linha a cada valor, e um println() vazio ao terminar cada linha:
        System.out.println("\nimpressa como tabela:");
        for (int[] l : tabela) {
            for (int v : l) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

        // Quando precisamos saber a POSIÇÃO de cada item, usamos o for clássico
        // com contador. Por convenção, i é o índice da linha e j o da coluna.
        System.out.println("\nfor (int i = 0; i < tabela.length; i++)  /  for (int j = 0; j < tabela[i].length; j++)");
        for (int i = 0; i < tabela.length; i++) {
            for (int j = 0; j < tabela[i].length; j++) {
                System.out.println("  tabela[" + i + "][" + j + "] = " + tabela[i][j]);
            }
        }


        // -------------------------------------------------------------------
        // 6. SOMANDO LINHAS E COLUNAS
        // -------------------------------------------------------------------
        titulo("6. Somando linhas e colunas");

        // Notas de 3 alunos em 2 provas. Cada LINHA é um aluno, cada COLUNA é uma prova.
        //
        //            prova 0   prova 1
        //   Ana    [   7.0,      8.0   ]
        //   Bruno  [   5.5,      6.5   ]
        //   Carla  [   9.0,     10.0   ]
        double[][] notas = {
            {7.0, 8.0},
            {5.5, 6.5},
            {9.0, 10.0},
        };
        String[] alunos = {"Ana", "Bruno", "Carla"};

        // Soma de uma LINHA: percorremos a linha com um for.
        // DIFERENÇA: Java não tem sum(). O for é a forma mais simples de somar.
        double somaAna = 0;
        for (double nota : notas[0]) {
            somaAna = somaAna + nota;
        }
        System.out.println("notas da Ana    = " + Arrays.toString(notas[0]) + " -> soma = " + somaAna);

        // Soma de uma COLUNA: precisamos pegar o MESMO índice em cada linha.
        double somaProva0 = 0;
        for (double[] l : notas) {
            somaProva0 = somaProva0 + l[0];
        }
        System.out.println("soma da prova 0 = " + somaProva0);

        // Média de cada aluno (uma média por linha):
        System.out.println("\nmédia por aluno:");
        for (int i = 0; i < alunos.length; i++) {
            double soma = 0;
            for (double nota : notas[i]) {
                soma = soma + nota;
            }
            double media = soma / notas[i].length;
            System.out.println("  " + alunos[i] + ": " + String.format("%.1f", media));
        }

        // Média de cada prova (uma média por coluna):
        System.out.println("\nmédia por prova:");
        for (int j = 0; j < notas[0].length; j++) {
            double soma = 0;
            for (int i = 0; i < notas.length; i++) {
                soma = soma + notas[i][j];
            }
            System.out.println("  prova " + j + ": " + String.format("%.1f", soma / notas.length));
        }

        // Soma de TUDO: um for dentro do outro.
        double total = 0;
        for (double[] l : notas) {
            for (double nota : l) {
                total = total + nota;
            }
        }
        System.out.println("\nsoma de todas as notas = " + total);


        // -------------------------------------------------------------------
        // 7. EXEMPLO PRÁTICO: TABULEIRO DO JOGO DA VELHA
        // -------------------------------------------------------------------
        titulo("7. Exemplo prático: tabuleiro do jogo da velha");

        // Um tabuleiro 3 x 3 começa vazio. Usamos "-" para as casas livres.
        // Um array de String começa cheio de null, então preenchemos com "-":
        String[][] tabuleiro = new String[3][3];
        for (String[] l : tabuleiro) {
            Arrays.fill(l, "-");
        }

        // Cada jogada marca uma posição [linha][coluna]:
        tabuleiro[0][0] = "X";
        tabuleiro[0][1] = "O";
        tabuleiro[1][1] = "X";
        tabuleiro[2][0] = "O";
        tabuleiro[2][2] = "X";

        System.out.println("tabuleiro:");
        for (String[] l : tabuleiro) {
            System.out.println("  " + String.join(" ", l));   // join junta os itens da linha com espaço
        }

        // Alguém venceu na linha 0? Os três precisam ser iguais e não podem ser "-".
        // DIFERENÇA: para comparar textos use equals(), não == (veja a aula 01, seção 8).
        String[] primeira = tabuleiro[0];
        if (!primeira[0].equals("-") && primeira[0].equals(primeira[1]) && primeira[1].equals(primeira[2])) {
            System.out.println("\n" + primeira[0] + " venceu na linha 0!");
        } else {
            System.out.println("\nninguém venceu na linha 0");
        }

        // E na diagonal principal? São as posições [0][0], [1][1] e [2][2].
        String[] diagonal = {tabuleiro[0][0], tabuleiro[1][1], tabuleiro[2][2]};
        System.out.println("diagonal principal = " + Arrays.toString(diagonal));
        if (!diagonal[0].equals("-") && diagonal[0].equals(diagonal[1]) && diagonal[1].equals(diagonal[2])) {
            System.out.println(diagonal[0] + " venceu na diagonal!");
        }


        // ===================================================================
        // PARTE 2 - PARA IR ALÉM
        // ===================================================================
        // Daqui em diante o conteúdo é mais avançado. Leia depois de praticar a parte 1.

        // -------------------------------------------------------------------
        // 8. QUANDO O TAMANHO PRECISA MUDAR: LISTA DE LISTAS
        // -------------------------------------------------------------------
        titulo("8. [Além] Quando o tamanho precisa mudar: lista de listas");

        // O int[][] tem tamanho fixo, igual ao array da aula 02: dá para alterar
        // os valores, mas não dá para adicionar uma linha nova. Quando a tabela
        // precisa crescer, usamos uma LISTA DE LISTAS — que é exatamente o que
        // a matriz do Python é por natureza.
        List<List<Integer>> dinamica = new ArrayList<>();
        dinamica.add(new ArrayList<>(List.of(1, 2, 3)));
        dinamica.add(new ArrayList<>(List.of(4, 5, 6)));
        System.out.println("dinamica = " + dinamica);

        // Agora dá para adicionar uma linha nova a qualquer momento:
        dinamica.add(new ArrayList<>(List.of(7, 8, 9)));
        System.out.println("depois de add de uma linha nova:");
        for (List<Integer> l : dinamica) {
            System.out.println("  " + l);
        }

        // DIFERENÇA: aqui voltamos ao get() e ao set() da aula 02, um para cada nível.
        System.out.println("\ndinamica.get(1).get(2) = " + dinamica.get(1).get(2) + "  <- linha 1, coluna 2");
        dinamica.get(0).set(0, 99);
        System.out.println("depois de dinamica.get(0).set(0, 99) -> linha 0 = " + dinamica.get(0));

        // Resumindo: int[][] quando o tamanho é conhecido e fixo (o caso mais comum);
        // List<List<...>> quando a tabela precisa crescer ou encolher.


        // -------------------------------------------------------------------
        // 9. TROCANDO LINHAS POR COLUNAS (TRANSPOSTA)
        // -------------------------------------------------------------------
        titulo("9. [Além] Trocando linhas por colunas (transposta)");

        // A transposta de uma matriz é a matriz "virada": as linhas viram colunas.
        // Uma matriz 2 x 3 vira 3 x 2.
        int[][] original = {
            {1, 2, 3},
            {4, 5, 6},
        };
        int totalLinhas = original.length;
        int totalColunas = original[0].length;

        // Criamos a nova matriz com as dimensões TROCADAS e copiamos cada item
        // da posição [i][j] para a posição [j][i]:
        int[][] transposta = new int[totalColunas][totalLinhas];
        for (int i = 0; i < totalLinhas; i++) {
            for (int j = 0; j < totalColunas; j++) {
                transposta[j][i] = original[i][j];
            }
        }

        System.out.println("original (2 x 3):");
        mostrar(original);
        System.out.println("\ntransposta (3 x 2):");
        mostrar(transposta);
        // É um exercício clássico: vale a pena reescrever de cabeça, sem olhar.


        // -------------------------------------------------------------------
        // RESUMO
        // -------------------------------------------------------------------
        titulo("RESUMO");
        System.out.println("""

                Considere:
                    int[][] m = {
                        {1, 2, 3},
                        {4, 5, 6},
                    };

                | O que fazer             | Como                                      | Resultado   |
                |-------------------------|-------------------------------------------|-------------|
                | Número de linhas        | m.length                                  | 2           |
                | Número de colunas       | m[0].length                               | 3           |
                | Acessar um item         | m[1][2]                                   | 6           |
                | Pegar uma linha inteira | m[1]                                      | [4, 5, 6]   |
                | Alterar um item         | m[0][0] = 9                               | [9, 2, 3]   |
                | Ver o conteúdo          | Arrays.deepToString(m)                    | tudo        |
                | Ver uma linha           | Arrays.toString(m[0])                     | [1, 2, 3]   |
                | Criar L x C de zeros    | new int[L][C]                             |             |
                | Preencher uma linha     | Arrays.fill(m[0], 1)                      | [1, 1, 1]   |
                | Somar uma linha         | for (int v : m[0]) soma += v;             | 6           |
                | Somar uma coluna        | for (int[] l : m) soma += l[0];           | 5           |
                | Percorrer tudo          | for (int[] l : m) / for (int v : l)       |             |
                | Percorrer com posições  | for (i...) / for (j...) com m[i][j]       |             |

                Lembre-se:
                  - Primeiro a LINHA, depois a COLUNA: m[linha][coluna]. Os dois começam em 0.
                  - m[i] sozinho é a linha inteira (um array).
                  - Arrays usam length (sem parênteses) e colchetes para ler e alterar.
                  - println(m) não mostra os valores: use Arrays.deepToString(m).
                  - new int[L][C] já nasce com zeros, e cada linha é um array novo.
                  - Para somar uma coluna, percorra as linhas pegando sempre o mesmo índice.
                  - int[][] tem tamanho fixo. Se a tabela precisa crescer, use List<List<...>> (seção 8).

                De Python para Java:

                  m = [[1, 2], [3, 4]]  -> int[][] m = {{1, 2}, {3, 4}};
                  len(m)                -> m.length
                  len(m[0])             -> m[0].length
                  m[i][j]               -> m[i][j]        (igual!)
                  m[i][j] = x           -> m[i][j] = x    (igual!)
                  print(m)              -> Arrays.deepToString(m)
                  [[0] * C for ...]     -> new int[L][C]
                  sum(m[0])             -> for
                  for linha in m:       -> for (int[] linha : m)

                Próximos passos: dicionários, a coleção de chave e valor.
                """);
    }
}
