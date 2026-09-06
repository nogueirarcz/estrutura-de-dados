"use strict";

/*
AULA 02 - ARRAYS (LISTAS) EM JAVASCRIPT
========================================

Disciplina: Estrutura de Dados
Curso: Engenharia de Software

Na aula 01 vimos os tipos primitivos: um número, um texto, um booleano.
Mas quase todo programa precisa guardar VÁRIOS valores juntos: as notas
de uma turma, os itens de um carrinho, os nomes de uma lista de presença.

Para isso existe o ARRAY: uma sequência de valores, em ordem, que pode
crescer, encolher e ser alterada a qualquer momento. É o equivalente da
lista (list) do Python, e muita gente chama de "lista" também.

Este arquivo está dividido em duas partes:

    PARTE 1 - O BÁSICO (seções 1 a 9)
        Tudo o que você precisa para usar arrays no dia a dia.

    PARTE 2 - PARA IR ALÉM (seção 10)
        Um recurso a mais sobre arrays.
        Leia depois de praticar a parte 1.

Execute este arquivo para ver os exemplos em ação:

    node listas.js

Sempre que algo for diferente do Python (veja listas.py), será destacado.
*/

function titulo(texto) {
  console.log();
  console.log("=".repeat(70));
  console.log(texto);
  console.log("=".repeat(70));
}

// Função auxiliar: transforma um array em texto do mesmo jeito que o
// console.log mostraria, para usarmos dentro das frases. Não se preocupe
// com ela agora.
const util = require("node:util");
function mostrar(array) {
  return util.inspect(array);
}


// ===========================================================================
// PARTE 1 - O BÁSICO
// ===========================================================================

// ---------------------------------------------------------------------------
// 1. CRIANDO ARRAYS
// ---------------------------------------------------------------------------
titulo("1. Criando arrays");

// Um array é escrito entre colchetes, com os itens separados por vírgula.
const notas = [7.5, 8.0, 6.5, 9.0];
const nomes = ["Ana", "Bruno", "Carla"];
const vazio = [];
console.log(`notas = ${mostrar(notas)}`);
console.log(`nomes = ${mostrar(nomes)}`);
console.log(`vazio = ${mostrar(vazio)}`);

// .length diz quantos itens o array tem.
// (É uma propriedade, não uma função: vai sem parênteses.)
console.log(`\nnotas.length = ${notas.length}`);
console.log(`vazio.length = ${vazio.length}`);

// O array aceita qualquer tipo de valor, até misturados:
const misto = [42, "texto", 3.14, true];
console.log(`\nmisto = ${mostrar(misto)}`);


// ---------------------------------------------------------------------------
// 2. ACESSANDO ITENS PELO ÍNDICE
// ---------------------------------------------------------------------------
titulo("2. Acessando itens pelo índice");

// Cada item tem uma posição, chamada de ÍNDICE. A contagem começa em 0.
//
//   "Ana"  "Bruno"  "Carla"  "Davi"
//     0       1        2       3
const alunos = ["Ana", "Bruno", "Carla", "Davi"];
console.log(`alunos[0] = ${alunos[0]}   <- primeiro`);
console.log(`alunos[1] = ${alunos[1]}`);
console.log(`alunos[3] = ${alunos[3]}  <- último`);

// DIFERENÇA: índice negativo NÃO funciona com colchetes. Para contar a partir
// do fim, use .at() ou calcule com length:
console.log(`\nalunos[-1]                = ${alunos[-1]}  <- não funciona!`);
console.log(`alunos.at(-1)             = ${alunos.at(-1)}  <- último`);
console.log(`alunos[alunos.length - 1] = ${alunos[alunos.length - 1]}  <- forma clássica`);

// DIFERENÇA: acessar uma posição que não existe NÃO gera erro. Devolve undefined.
// (Em Python seria IndexError.) Isso esconde bugs, então cuidado com os índices.
console.log(`\nalunos[4] = ${alunos[4]}  <- sem erro!`);


// ---------------------------------------------------------------------------
// 3. PEGANDO UM PEDAÇO DO ARRAY (slice)
// ---------------------------------------------------------------------------
titulo("3. Pegando um pedaço do array (slice)");

// array.slice(início, fim) devolve um NOVO array com os itens do início até o fim.
// O item do índice "fim" NÃO entra.
const turma = ["Ana", "Bruno", "Carla", "Davi", "Elisa"];
console.log(`turma             = ${mostrar(turma)}`);
console.log(`turma.slice(1, 3) = ${mostrar(turma.slice(1, 3))}  <- índices 1 e 2 (o 3 fica de fora)`);
console.log(`turma.slice(0, 2) = ${mostrar(turma.slice(0, 2))}  <- do início até o índice 2`);
console.log(`turma.slice(2)    = ${mostrar(turma.slice(2))}  <- do índice 2 até o fim`);
console.log(`turma.slice(-2)   = ${mostrar(turma.slice(-2))}  <- os dois últimos`);


// ---------------------------------------------------------------------------
// 4. ALTERANDO ITENS
// ---------------------------------------------------------------------------
titulo("4. Alterando itens");

// Diferente das strings (aula 01), o array PODE ser alterado depois de criado.
// Dizemos que o array é MUTÁVEL.
const numeros = [10, 20, 30];
console.log(`antes:  ${mostrar(numeros)}`);
numeros[0] = 99;
console.log(`depois: ${mostrar(numeros)}  <- numeros[0] = 99`);

// Repare: numeros foi declarado com const e mesmo assim mudou. O const impede
// trocar o array por OUTRO (numeros = [...]), mas não impede alterar o conteúdo.

// Com string isso não funciona:
const texto = "abc";
try {
  texto[0] = "z";
} catch {
  console.log(`\ntexto[0] = "z" gera TypeError: string não pode ser alterada`);
}


// ---------------------------------------------------------------------------
// 5. ADICIONANDO ITENS
// ---------------------------------------------------------------------------
titulo("5. Adicionando itens");

const fila = ["Ana"];
console.log(`início:                 ${mostrar(fila)}`);

fila.push("Bruno");                // adiciona UM item no FIM (o append do Python)
console.log(`push("Bruno")           -> ${mostrar(fila)}`);

fila.unshift("Carla");             // adiciona no INÍCIO (os outros andam para frente)
console.log(`unshift("Carla")        -> ${mostrar(fila)}`);

fila.splice(1, 0, "Davi");         // insere na POSIÇÃO 1 (o 0 significa "não remova nada")
console.log(`splice(1, 0, "Davi")    -> ${mostrar(fila)}`);

fila.push("Elisa", "Fábio");       // push aceita VÁRIOS itens de uma vez
console.log(`push("Elisa", "Fábio")  -> ${mostrar(fila)}`);

// CUIDADO: push com um array coloca o array inteiro como UM item só.
const errado = [1, 2];
errado.push([3, 4]);
const certo = [1, 2];
certo.push(...[3, 4]);             // os três pontos (spread) "espalham" os itens
console.log(`\n[1, 2].push([3, 4])    -> ${mostrar(errado)}  <- array dentro de array`);
console.log(`[1, 2].push(...[3, 4]) -> ${mostrar(certo)}    <- o que normalmente queremos`);


// ---------------------------------------------------------------------------
// 6. REMOVENDO ITENS
// ---------------------------------------------------------------------------
titulo("6. Removendo itens");

const letras = ["a", "b", "c", "d"];
console.log(`início:                 ${mostrar(letras)}`);

let removida = letras.pop();       // remove o ÚLTIMO e devolve ele
console.log(`pop()                   -> ${mostrar(letras)}  (removeu "${removida}")`);

removida = letras.shift();         // remove o PRIMEIRO e devolve ele
console.log(`shift()                 -> ${mostrar(letras)}  (removeu "${removida}")`);

// DIFERENÇA: não existe remove(valor). Primeiro descobrimos a posição com
// indexOf, depois removemos com splice(posição, 1).
const posicao = letras.indexOf("c");
letras.splice(posicao, 1);         // remove 1 item a partir da posição
console.log(`splice(indexOf("c"), 1) -> ${mostrar(letras)}`);

letras.length = 0;                 // esvazia o array
console.log(`length = 0              -> ${mostrar(letras)}`);


// ---------------------------------------------------------------------------
// 7. PROCURANDO ITENS
// ---------------------------------------------------------------------------
titulo("7. Procurando itens");

const frutas = ["maçã", "banana", "uva", "banana"];
console.log(`frutas = ${mostrar(frutas)}`);

// includes() responde se o item está no array:
console.log(`\nfrutas.includes("uva")  -> ${frutas.includes("uva")}`);
console.log(`frutas.includes("kiwi") -> ${frutas.includes("kiwi")}`);

// indexOf() diz a posição da PRIMEIRA ocorrência.
// DIFERENÇA: se não encontrar, devolve -1 em vez de dar erro.
console.log(`\nfrutas.indexOf("banana") = ${frutas.indexOf("banana")}`);
console.log(`frutas.indexOf("kiwi")   = ${frutas.indexOf("kiwi")}  <- -1 significa "não está"`);

// DIFERENÇA: não existe count(). Para contar, usamos filter(), que devolve um
// novo array só com os itens que passam no teste, e vemos o tamanho dele:
const quantasBananas = frutas.filter((fruta) => fruta === "banana").length;
console.log(`\nquantas bananas? ${quantasBananas}`);
// (fruta) => fruta === "banana" é uma "arrow function": uma função curta que
// recebe fruta e devolve true ou false. Veremos mais sobre ela nas próximas aulas.


// ---------------------------------------------------------------------------
// 8. ORDENANDO E INVERTENDO
// ---------------------------------------------------------------------------
titulo("8. Ordenando e invertendo");

// sort() ordena o PRÓPRIO array.
const desordenadas = ["c", "a", "b"];
desordenadas.sort();
console.log(`["c", "a", "b"].sort() -> ${mostrar(desordenadas)}`);

// CUIDADO: sort() sem argumento ordena como TEXTO, mesmo com números!
// Ele compara caractere por caractere: "10" vem antes de "9" porque "1" < "9".
const pontos = [10, 9, 1, 25];
pontos.sort();
console.log(`\n[10, 9, 1, 25].sort() -> ${mostrar(pontos)}  <- errado para números!`);

// Para números, passe uma função que diz como comparar dois itens:
pontos.sort((a, b) => a - b);
console.log(`sort((a, b) => a - b) -> ${mostrar(pontos)}  <- crescente`);
pontos.sort((a, b) => b - a);
console.log(`sort((a, b) => b - a) -> ${mostrar(pontos)}  <- decrescente`);

// toSorted() devolve um NOVO array ordenado, sem mexer no original (Node 20+).
// É o equivalente do sorted() do Python.
const original = [3, 1, 2];
const ordenado = original.toSorted((a, b) => a - b);
console.log(`\noriginal = ${mostrar(original)}  <- continua igual`);
console.log(`ordenado = ${mostrar(ordenado)}`);

// reverse() inverte a ordem dos itens (sem ordenar):
const abc = ["a", "b", "c"];
abc.reverse();
console.log(`\n["a", "b", "c"].reverse() -> ${mostrar(abc)}`);


// ---------------------------------------------------------------------------
// 9. PERCORRENDO O ARRAY COM for (E Math.min, Math.max)
// ---------------------------------------------------------------------------
titulo("9. Percorrendo o array com for (e Math.min, Math.max)");

const compras = ["pão", "leite", "café"];

// for...of visita cada item, um de cada vez:
console.log("for (const item of compras):");
for (const item of compras) {
  console.log(`  - ${item}`);
}

// Se precisar do índice junto, use o for clássico com contador:
console.log("\nfor (let i = 0; i < compras.length; i++):");
for (let i = 0; i < compras.length; i++) {
  console.log(`  ${i}: ${compras[i]}`);
}

// Exemplo prático: somar as notas com o for.
// DIFERENÇA: JavaScript não tem sum(). O for é a forma mais simples de somar.
let soma = 0;
for (const nota of notas) {
  soma = soma + nota;
}
console.log(`\nsoma com for = ${soma}`);
console.log(`média        = ${(soma / notas.length).toFixed(2)}`);

// Para o menor e o maior existem Math.min e Math.max. Eles esperam os números
// separados, então usamos os três pontos (spread) para "espalhar" o array:
console.log(`Math.min(...notas) = ${Math.min(...notas)}`);
console.log(`Math.max(...notas) = ${Math.max(...notas)}`);


// ===========================================================================
// PARTE 2 - PARA IR ALÉM
// ===========================================================================
// Daqui em diante o conteúdo é mais avançado. Leia depois de praticar a parte 1.

// ---------------------------------------------------------------------------
// 10. ARRAYS DENTRO DE ARRAYS (MATRIZES)
// ---------------------------------------------------------------------------
titulo("10. [Além] Arrays dentro de arrays (matrizes)");

// Um array pode conter outros arrays. É assim que representamos uma tabela:
const tabela = [
  [1, 2, 3],
  [4, 5, 6],
];
console.log(`tabela       = ${mostrar(tabela)}`);
console.log(`tabela[0]    = ${mostrar(tabela[0])}  <- primeira linha`);
console.log(`tabela[1][2] = ${tabela[1][2]}  <- segunda linha, terceira coluna`);


// ---------------------------------------------------------------------------
// RESUMO
// ---------------------------------------------------------------------------
titulo("RESUMO");
console.log(`
Considere lista = [1, 2, 3]

| O que fazer            | Como                        | Resultado                    |
|------------------------|-----------------------------|------------------------------|
| Tamanho                | lista.length                | 3                            |
| Acessar                | lista[0]  /  lista.at(-1)   | 1  /  3                      |
| Fatiar                 | lista.slice(0, 2)           | [1, 2]                       |
| Alterar                | lista[0] = 9                | [9, 2, 3]                    |
| Adicionar no fim       | lista.push(4)               | [1, 2, 3, 4]                 |
| Adicionar no início    | lista.unshift(0)            | [0, 1, 2, 3]                 |
| Inserir em posição     | lista.splice(1, 0, 9)       | [1, 9, 2, 3]                 |
| Adicionar vários       | lista.push(4, 5)            | [1, 2, 3, 4, 5]              |
| Remover do fim         | lista.pop()                 | devolve 3, sobra [1, 2]      |
| Remover do início      | lista.shift()               | devolve 1, sobra [2, 3]      |
| Remover por posição    | lista.splice(1, 1)          | [1, 3]                       |
| Está no array?         | lista.includes(2)           | true                         |
| Posição de um valor    | lista.indexOf(2)            | 1 (ou -1 se não existir)     |
| Ordenar (no lugar)     | lista.sort((a, b) => a - b) | altera o original            |
| Ordenar (novo array)   | lista.toSorted(...)         | o original não muda          |
| Inverter               | lista.reverse()             | [3, 2, 1]                    |
| Menor / maior          | Math.min(...lista) / max    | 1 / 3                        |

Lembre-se:
  - O primeiro índice é 0. Para o último, use lista.at(-1) ou lista.length - 1.
  - Índice fora do array devolve undefined, sem erro. Confira o length.
  - sort() sem argumento ordena como TEXTO. Para números, passe (a, b) => a - b.
  - Não existe remove(valor): use indexOf() para achar e splice() para tirar.
  - const não impede alterar o conteúdo do array, só impede trocar por outro.

De Python para JavaScript:

  len(lista)         -> lista.length
  lista.append(x)    -> lista.push(x)
  lista.insert(i, x) -> lista.splice(i, 0, x)
  lista.pop(0)       -> lista.shift()
  lista.remove(x)    -> lista.splice(lista.indexOf(x), 1)
  x in lista         -> lista.includes(x)
  lista.index(x)     -> lista.indexOf(x)
  sorted(lista)      -> lista.toSorted(...)
  sum(lista)         -> for

Próximos passos: as outras coleções do JavaScript (objetos, Set e Map).
`);
