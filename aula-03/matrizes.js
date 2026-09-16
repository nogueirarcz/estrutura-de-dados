"use strict";

/*
AULA 03 - MATRIZES EM JAVASCRIPT
=================================

Disciplina: Estrutura de Dados
Curso: Engenharia de Software

Na aula 02 vimos o array: uma sequência de valores em uma única "linha".
Mas muita informação do mundo real vem em forma de TABELA, com linhas e
colunas: as notas de cada aluno em cada prova, um tabuleiro de jogo, uma
planilha, os pixels de uma imagem.

Para isso usamos a MATRIZ. Em JavaScript, uma matriz é simplesmente um
array em que cada item é outro array: um ARRAY DE ARRAYS. Cada array
interno é uma linha da tabela.

Este arquivo está dividido em duas partes:

    PARTE 1 - O BÁSICO (seções 1 a 7)
        Criar, acessar, alterar e percorrer matrizes.

    PARTE 2 - PARA IR ALÉM (seções 8 e 9)
        Uma armadilha clássica e um exercício tradicional.
        Leia depois de praticar a parte 1.

Execute este arquivo para ver os exemplos em ação:

    node matrizes.js

Sempre que algo for diferente do Python (veja matrizes.py), será destacado.
*/

function titulo(texto) {
  console.log();
  console.log("=".repeat(70));
  console.log(texto);
  console.log("=".repeat(70));
}

// Função auxiliar da aula 02: transforma um array em texto do mesmo jeito
// que o console.log mostraria, para usarmos dentro das frases.
const util = require("node:util");
function texto(array) {
  return util.inspect(array);
}

// Imprime a matriz linha por linha, como uma tabela.
function mostrar(matriz) {
  for (const linha of matriz) {
    console.log(`  ${texto(linha)}`);
  }
}


// ===========================================================================
// PARTE 1 - O BÁSICO
// ===========================================================================

// ---------------------------------------------------------------------------
// 1. O QUE É UMA MATRIZ
// ---------------------------------------------------------------------------
titulo("1. O que é uma matriz");

// Uma matriz é um array de arrays. Cada array interno é uma LINHA.
// Esta matriz tem 2 linhas e 3 colunas (dizemos que é uma matriz 2 x 3):
const matriz = [
  [1, 2, 3],   // linha 0
  [4, 5, 6],   // linha 1
];
console.log(`matriz = ${texto(matriz)}`);

// Impressa linha por linha fica mais fácil de enxergar a tabela:
console.log("\nlinha por linha:");
mostrar(matriz);

// O número de linhas é o tamanho do array de fora.
// O número de colunas é o tamanho de uma das linhas.
// (.length é uma propriedade, vai sem parênteses — como na aula 02.)
console.log(`\nlinhas  = matriz.length    = ${matriz.length}`);
console.log(`colunas = matriz[0].length = ${matriz[0].length}`);


// ---------------------------------------------------------------------------
// 2. ACESSANDO UM ITEM: matriz[linha][coluna]
// ---------------------------------------------------------------------------
titulo("2. Acessando um item: matriz[linha][coluna]");

// Cada item tem DOIS índices: primeiro a linha, depois a coluna.
// Os dois começam em 0. Igualzinho ao Python.
//
//              coluna 0   coluna 1   coluna 2
//   linha 0  [    1,         2,         3    ]
//   linha 1  [    4,         5,         6    ]
console.log(`matriz[0][0] = ${matriz[0][0]}  <- linha 0, coluna 0`);
console.log(`matriz[0][2] = ${matriz[0][2]}  <- linha 0, coluna 2`);
console.log(`matriz[1][0] = ${matriz[1][0]}  <- linha 1, coluna 0`);
console.log(`matriz[1][2] = ${matriz[1][2]}  <- linha 1, coluna 2 (o último)`);

// Com um índice só, pegamos a LINHA inteira, que é um array:
console.log(`\nmatriz[1]    = ${texto(matriz[1])}  <- a linha 1 inteira`);

// Dica para não confundir: matriz[1][2] é "pegue a linha 1, depois pegue
// a coluna 2 dentro dela". É o mesmo que fazer em dois passos:
const linha = matriz[1];
const valor = linha[2];
console.log(`const linha = matriz[1]; const valor = linha[2] -> ${valor}`);

// DIFERENÇA: no Python, um índice que não existe gera IndexError. Em
// JavaScript não há erro: o resultado é undefined (como na aula 02, seção 2).
console.log(`\nmatriz[5]    = ${matriz[5]}  <- não existe, mas não dá erro`);

// CUIDADO: com dois índices o erro aparece, porque tentamos usar [0] em
// undefined, e undefined não tem posições.
try {
  console.log(matriz[5][0]);
} catch (erro) {
  console.log(`matriz[5][0] gera TypeError: ${erro.message}`);
}
// Por isso, confira o length antes de acessar quando não tiver certeza.

// O .at(-1) da aula 02 também funciona, nos dois níveis:
console.log(`\nmatriz.at(-1)       = ${texto(matriz.at(-1))}  <- última linha`);
console.log(`matriz.at(-1).at(-1) = ${matriz.at(-1).at(-1)}  <- último item da última linha`);


// ---------------------------------------------------------------------------
// 3. ALTERANDO UM ITEM
// ---------------------------------------------------------------------------
titulo("3. Alterando um item");

const alterada = [
  [1, 2, 3],
  [4, 5, 6],
];
console.log("antes:");
mostrar(alterada);

alterada[0][1] = 99;       // linha 0, coluna 1
alterada[1][2] = 0;        // linha 1, coluna 2
console.log("\ndepois de alterada[0][1] = 99 e alterada[1][2] = 0:");
mostrar(alterada);

// Lembre-se da aula 02: const não impede alterar o CONTEÚDO, só impede
// trocar a variável por outro array. Por isso o código acima funciona.


// ---------------------------------------------------------------------------
// 4. CRIANDO UMA MATRIZ CHEIA DE ZEROS
// ---------------------------------------------------------------------------
titulo("4. Criando uma matriz cheia de zeros");

// Muitas vezes precisamos criar uma matriz "vazia" (cheia de zeros) para
// preencher depois. Fazemos isso com um for: para cada linha, criamos um
// array NOVO de zeros e adicionamos à matriz com push.
const linhas = 3;
const colunas = 4;
const zeros = [];
for (let i = 0; i < linhas; i++) {
  zeros.push(new Array(colunas).fill(0));   // uma linha nova com 4 zeros
}

console.log(`matriz ${linhas} x ${colunas} de zeros:`);
mostrar(zeros);

// Agora dá para preencher posição por posição:
zeros[0][0] = 1;
zeros[2][3] = 7;
console.log("\ndepois de zeros[0][0] = 1 e zeros[2][3] = 7:");
mostrar(zeros);

// new Array(n).fill(valor) cria um array de n posições preenchidas.
// É o equivalente do [0] * n do Python:
console.log(`\nnew Array(4).fill(0) = ${texto(new Array(4).fill(0))}`);

// CUIDADO: existe um atalho que PARECE fazer a mesma coisa,
// new Array(3).fill([0, 0]), mas ele cria uma armadilha. Veja a seção 8.


// ---------------------------------------------------------------------------
// 5. PERCORRENDO A MATRIZ COM DOIS for
// ---------------------------------------------------------------------------
titulo("5. Percorrendo a matriz com dois for");

const tabela = [
  [1, 2, 3],
  [4, 5, 6],
];

// O for...of de fora passa por cada LINHA (que é um array);
// o de dentro, por cada VALOR da linha.
console.log("for (const l of tabela)  /  for (const v of l)");
for (const l of tabela) {
  for (const v of l) {
    console.log(`  valor ${v}`);
  }
}

// Para imprimir como uma tabela, montamos o texto da linha e imprimimos de
// uma vez. DIFERENÇA: não existe o end=" " do Python; console.log sempre
// pula linha. Por isso juntamos os valores com join (como no Python).
console.log("\nimpressa como tabela:");
for (const l of tabela) {
  console.log(`  ${l.join(" ")}`);
}

// Quando precisamos saber a POSIÇÃO de cada item, usamos o for clássico
// com contador. Por convenção, i é o índice da linha e j o da coluna.
console.log("\nfor (let i = 0; i < tabela.length; i++)  /  for (let j = 0; j < tabela[i].length; j++)");
for (let i = 0; i < tabela.length; i++) {
  for (let j = 0; j < tabela[i].length; j++) {
    console.log(`  tabela[${i}][${j}] = ${tabela[i][j]}`);
  }
}


// ---------------------------------------------------------------------------
// 6. SOMANDO LINHAS E COLUNAS
// ---------------------------------------------------------------------------
titulo("6. Somando linhas e colunas");

// Notas de 3 alunos em 2 provas. Cada LINHA é um aluno, cada COLUNA é uma prova.
//
//            prova 0   prova 1
//   Ana    [   7.0,      8.0   ]
//   Bruno  [   5.5,      6.5   ]
//   Carla  [   9.0,     10.0   ]
const notas = [
  [7.0, 8.0],
  [5.5, 6.5],
  [9.0, 10.0],
];
const alunos = ["Ana", "Bruno", "Carla"];

// Soma de uma LINHA: percorremos a linha com um for.
// DIFERENÇA: JavaScript não tem sum(). O for é a forma mais simples de somar.
let somaAna = 0;
for (const nota of notas[0]) {
  somaAna = somaAna + nota;
}
console.log(`notas da Ana    = ${texto(notas[0])} -> soma = ${somaAna}`);

// Soma de uma COLUNA: precisamos pegar o MESMO índice em cada linha.
let somaProva0 = 0;
for (const l of notas) {
  somaProva0 = somaProva0 + l[0];
}
console.log(`soma da prova 0 = ${somaProva0}`);

// Média de cada aluno (uma média por linha):
console.log("\nmédia por aluno:");
for (let i = 0; i < alunos.length; i++) {
  let soma = 0;
  for (const nota of notas[i]) {
    soma = soma + nota;
  }
  const media = soma / notas[i].length;
  console.log(`  ${alunos[i]}: ${media.toFixed(1)}`);
}

// Média de cada prova (uma média por coluna):
console.log("\nmédia por prova:");
for (let j = 0; j < notas[0].length; j++) {
  let soma = 0;
  for (let i = 0; i < notas.length; i++) {
    soma = soma + notas[i][j];
  }
  console.log(`  prova ${j}: ${(soma / notas.length).toFixed(1)}`);
}

// Soma de TUDO: um for dentro do outro.
let total = 0;
for (const l of notas) {
  for (const nota of l) {
    total = total + nota;
  }
}
console.log(`\nsoma de todas as notas = ${total}`);


// ---------------------------------------------------------------------------
// 7. EXEMPLO PRÁTICO: TABULEIRO DO JOGO DA VELHA
// ---------------------------------------------------------------------------
titulo("7. Exemplo prático: tabuleiro do jogo da velha");

// Um tabuleiro 3 x 3 começa vazio. Usamos "-" para as casas livres.
const tabuleiro = [];
for (let i = 0; i < 3; i++) {
  tabuleiro.push(new Array(3).fill("-"));
}

// Cada jogada marca uma posição [linha][coluna]:
tabuleiro[0][0] = "X";
tabuleiro[0][1] = "O";
tabuleiro[1][1] = "X";
tabuleiro[2][0] = "O";
tabuleiro[2][2] = "X";

console.log("tabuleiro:");
for (const l of tabuleiro) {
  console.log(`  ${l.join(" ")}`);     // join junta os itens da linha com espaço
}

// Alguém venceu na linha 0? Os três precisam ser iguais e não podem ser "-".
// Para comparar textos usamos === (veja a aula 01).
const primeira = tabuleiro[0];
if (primeira[0] !== "-" && primeira[0] === primeira[1] && primeira[1] === primeira[2]) {
  console.log(`\n${primeira[0]} venceu na linha 0!`);
} else {
  console.log("\nninguém venceu na linha 0");
}

// E na diagonal principal? São as posições [0][0], [1][1] e [2][2].
const diagonal = [tabuleiro[0][0], tabuleiro[1][1], tabuleiro[2][2]];
console.log(`diagonal principal = ${texto(diagonal)}`);
if (diagonal[0] !== "-" && diagonal[0] === diagonal[1] && diagonal[1] === diagonal[2]) {
  console.log(`${diagonal[0]} venceu na diagonal!`);
}


// ===========================================================================
// PARTE 2 - PARA IR ALÉM
// ===========================================================================
// Daqui em diante o conteúdo é mais avançado. Leia depois de praticar a parte 1.

// ---------------------------------------------------------------------------
// 8. A ARMADILHA DE CRIAR A MATRIZ COM UM ARRAY SÓ
// ---------------------------------------------------------------------------
titulo("8. [Além] A armadilha de criar a matriz com um array só");

// Parece um atalho bom: fill() com um array pronto cria 3 linhas de 3 zeros...
const errada = new Array(3).fill([0, 0, 0]);
console.log("errada = new Array(3).fill([0, 0, 0])");
mostrar(errada);

// ...mas as 3 "linhas" são o MESMO array repetido 3 vezes (lembra da aula 02,
// seção 10: duas variáveis, um só array?). Alterar uma altera todas:
errada[0][0] = 1;
console.log("\ndepois de errada[0][0] = 1:");
mostrar(errada);
console.log("  <- as três linhas mudaram!");

// A forma certa é criar um array NOVO para cada linha, como na seção 4.
// Um jeito curto de fazer isso é com Array.from, que chama a função uma vez
// para cada linha — e cada chamada devolve um array diferente:
const certa = Array.from({ length: 3 }, () => new Array(3).fill(0));
certa[0][0] = 1;
console.log("\ncerta = Array.from({ length: 3 }, () => new Array(3).fill(0)),");
console.log("depois de certa[0][0] = 1:");
mostrar(certa);

// É a mesma armadilha do Python ([[0] * 3] * 3), com outra roupagem.
// A causa é a mesma: um array só, referenciado em vários lugares.


// ---------------------------------------------------------------------------
// 9. TROCANDO LINHAS POR COLUNAS (TRANSPOSTA)
// ---------------------------------------------------------------------------
titulo("9. [Além] Trocando linhas por colunas (transposta)");

// A transposta de uma matriz é a matriz "virada": as linhas viram colunas.
// Uma matriz 2 x 3 vira 3 x 2.
const original = [
  [1, 2, 3],
  [4, 5, 6],
];
const totalLinhas = original.length;
const totalColunas = original[0].length;

// Criamos a nova matriz com as dimensões TROCADAS e copiamos cada item
// da posição [i][j] para a posição [j][i]:
const transposta = Array.from({ length: totalColunas }, () => new Array(totalLinhas).fill(0));
for (let i = 0; i < totalLinhas; i++) {
  for (let j = 0; j < totalColunas; j++) {
    transposta[j][i] = original[i][j];
  }
}

console.log("original (2 x 3):");
mostrar(original);
console.log("\ntransposta (3 x 2):");
mostrar(transposta);
// É um exercício clássico: vale a pena reescrever de cabeça, sem olhar.


// ---------------------------------------------------------------------------
// RESUMO
// ---------------------------------------------------------------------------
titulo("RESUMO");
console.log(`
Considere:
    const m = [
      [1, 2, 3],
      [4, 5, 6],
    ];

| O que fazer             | Como                                     | Resultado   |
|-------------------------|------------------------------------------|-------------|
| Número de linhas        | m.length                                 | 2           |
| Número de colunas       | m[0].length                              | 3           |
| Acessar um item         | m[1][2]                                  | 6           |
| Último item             | m.at(-1).at(-1)                          | 6           |
| Pegar uma linha inteira | m[1]                                     | [4, 5, 6]   |
| Alterar um item         | m[0][0] = 9                              | [9, 2, 3]   |
| Criar L x C de zeros    | Array.from({length: L}, () => ...)       |             |
| Criar uma linha         | new Array(C).fill(0)                     | [0, 0, 0]   |
| Imprimir uma linha      | m[0].join(" ")                           | 1 2 3       |
| Somar uma linha         | for (const v of m[0]) soma += v;         | 6           |
| Somar uma coluna        | for (const l of m) soma += l[0];         | 5           |
| Percorrer tudo          | for (const l of m) / for (const v of l)  |             |
| Percorrer com posições  | for (i...) / for (j...) com m[i][j]      |             |

Lembre-se:
  - Primeiro a LINHA, depois a COLUNA: m[linha][coluna]. Os dois começam em 0.
  - m[i] sozinho é a linha inteira (um array).
  - .length é propriedade: vai sem parênteses.
  - m[5] devolve undefined sem erro, mas m[5][0] gera TypeError. Confira o length.
  - const não impede alterar o conteúdo da matriz, só trocá-la por outra.
  - NÃO crie matrizes com new Array(L).fill([...]): as linhas ficam "coladas" (seção 8).

De Python para JavaScript:

  m = [[1, 2], [3, 4]]   -> const m = [[1, 2], [3, 4]];
  len(m)                 -> m.length
  len(m[0])              -> m[0].length
  m[i][j]                -> m[i][j]        (igual!)
  m[i][j] = x            -> m[i][j] = x    (igual!)
  m[-1][-1]              -> m.at(-1).at(-1)
  [0] * C                -> new Array(C).fill(0)
  [[0] * C for _ in ...] -> Array.from({length: L}, () => new Array(C).fill(0))
  m.append(linha)        -> m.push(linha)
  sum(m[0])              -> for
  for linha in m:        -> for (const linha of m)
  " ".join(linha)        -> linha.join(" ")

Próximos passos: dicionários, a coleção de chave e valor.
`);
