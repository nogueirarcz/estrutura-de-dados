/*
AULA 02 - LISTAS EM JAVA (ArrayList)
=====================================

Disciplina: Estrutura de Dados
Curso: Engenharia de Software

Na aula 01 vimos os tipos primitivos: um número, um texto, um booleano.
Mas quase todo programa precisa guardar VÁRIOS valores juntos: as notas
de uma turma, os itens de um carrinho, os nomes de uma lista de presença.

Em Java existem duas formas de fazer isso:

    array     -> tamanho FIXO, definido na criação. Escrito com colchetes.
    ArrayList -> tamanho DINÂMICO: cresce, encolhe e pode ser alterado a
                 qualquer momento. É o equivalente da lista (list) do Python
                 e do array do JavaScript.

Nesta aula o foco é o ArrayList. O array aparece só no começo.
São 9 seções curtas, uma para cada coisa que você faz com uma lista
no dia a dia.

Execute este arquivo para ver os exemplos em ação (Java 17 ou superior):

    java Listas.java

Sempre que algo for diferente do Python (veja listas.py), será destacado.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Listas {

    static void titulo(String texto) {
        System.out.println();
        System.out.println("=".repeat(70));
        System.out.println(texto);
        System.out.println("=".repeat(70));
    }

    public static void main(String[] args) {

        // -------------------------------------------------------------------
        // 1. CRIANDO LISTAS
        // -------------------------------------------------------------------
        titulo("1. Criando listas");

        // Primeiro, o array: tamanho fixo, escrito com colchetes.
        int[] notasArray = {7, 8, 6, 9};
        System.out.println("array: " + Arrays.toString(notasArray) + "  <- length = " + notasArray.length + ", e isso nunca muda");
        // Um array de 4 posições terá 4 posições para sempre. Não dá para
        // adicionar um quinto item. Por isso, no dia a dia usamos o ArrayList.

        // ArrayList: o tipo dos itens vai entre < >. Do lado esquerdo escrevemos
        // List (o tipo geral) e do lado direito new ArrayList<>() (a implementação).
        // Por enquanto, apenas siga esse padrão.
        List<String> nomes = new ArrayList<>();                              // lista vazia de textos
        List<Double> notas = new ArrayList<>(List.of(7.5, 8.0, 6.5, 9.0));  // lista já com itens
        System.out.println("\nnomes = " + nomes);
        System.out.println("notas = " + notas);
        // (List.of cria uma lista "travada"; new ArrayList<>(...) copia para uma que pode mudar)

        // size() diz quantos itens a lista tem:
        System.out.println("\nnotas.size() = " + notas.size());
        System.out.println("nomes.size() = " + nomes.size());

        // DIFERENÇA: a lista tem um tipo fixo. Não dá para misturar tipos.
        //   nomes.add(42);   // NÃO COMPILA: int cannot be converted to String
        // Para números, use Integer e Double no lugar de int e double
        // (são as classes wrapper da aula 01, seção 9).


        // -------------------------------------------------------------------
        // 2. ACESSANDO ITENS PELO ÍNDICE
        // -------------------------------------------------------------------
        titulo("2. Acessando itens pelo índice");

        // Cada item tem uma posição, chamada de ÍNDICE. A contagem começa em 0.
        //
        //   "Ana"  "Bruno"  "Carla"  "Davi"
        //     0       1        2       3
        List<String> alunos = new ArrayList<>(List.of("Ana", "Bruno", "Carla", "Davi"));

        // DIFERENÇA: ArrayList não usa colchetes (eles são só para arrays). Usamos get():
        System.out.println("alunos.get(0) = " + alunos.get(0) + "   <- primeiro");
        System.out.println("alunos.get(1) = " + alunos.get(1));
        System.out.println("alunos.get(3) = " + alunos.get(3) + "  <- último");

        // DIFERENÇA: índice negativo não existe. Para o último, calcule com size():
        System.out.println("alunos.get(alunos.size() - 1) = " + alunos.get(alunos.size() - 1) + "  <- último");
        // (a partir do Java 21 também existe alunos.getLast())

        // Acessar uma posição que não existe gera um erro (IndexOutOfBoundsException):
        try {
            System.out.println(alunos.get(4));
        } catch (IndexOutOfBoundsException erro) {
            System.out.println("\nalunos.get(4) gera IndexOutOfBoundsException: " + erro.getMessage());
        }


        // -------------------------------------------------------------------
        // 3. PEGANDO UM PEDAÇO DA LISTA (subList)
        // -------------------------------------------------------------------
        titulo("3. Pegando um pedaço da lista (subList)");

        // lista.subList(início, fim) devolve os itens do início até o fim.
        // O item do índice "fim" NÃO entra.
        List<String> turma = new ArrayList<>(List.of("Ana", "Bruno", "Carla", "Davi", "Elisa"));
        System.out.println("turma                          = " + turma);
        System.out.println("turma.subList(1, 3)            = " + turma.subList(1, 3) + "  <- índices 1 e 2 (o 3 fica de fora)");
        System.out.println("turma.subList(0, 2)            = " + turma.subList(0, 2) + "  <- do início até o índice 2");
        System.out.println("turma.subList(2, turma.size()) = " + turma.subList(2, turma.size()) + "  <- do índice 2 até o fim");

        // CUIDADO: subList devolve uma "janela" para a lista original, não uma cópia.
        // Alterar a janela altera a original. Para ter uma cópia independente:
        List<String> doisPrimeiros = new ArrayList<>(turma.subList(0, 2));
        System.out.println("new ArrayList<>(subList(0, 2)) = " + doisPrimeiros + "  <- cópia independente");


        // -------------------------------------------------------------------
        // 4. ALTERANDO ITENS
        // -------------------------------------------------------------------
        titulo("4. Alterando itens");

        // A lista PODE ser alterada depois de criada: é MUTÁVEL.
        // Usamos set(posição, novoValor):
        List<Integer> numeros = new ArrayList<>(List.of(10, 20, 30));
        System.out.println("antes:  " + numeros);
        numeros.set(0, 99);
        System.out.println("depois: " + numeros + "  <- numeros.set(0, 99)");

        // Com String isso não funciona (aula 01): String é imutável.
        //   String texto = "abc";
        //   texto.charAt(0) = 'z';   // NÃO COMPILA


        // -------------------------------------------------------------------
        // 5. ADICIONANDO ITENS
        // -------------------------------------------------------------------
        titulo("5. Adicionando itens");

        List<String> fila = new ArrayList<>(List.of("Ana"));
        System.out.println("início:                  " + fila);

        fila.add("Bruno");                        // adiciona UM item no FIM (o append do Python)
        System.out.println("add(\"Bruno\")          -> " + fila);

        fila.add(0, "Carla");                     // adiciona na POSIÇÃO 0 (os outros andam para frente)
        System.out.println("add(0, \"Carla\")       -> " + fila);

        fila.addAll(List.of("Davi", "Elisa"));    // adiciona VÁRIOS itens no fim
        System.out.println("addAll(List.of(...)) -> " + fila);

        // DIFERENÇA: em Python, append com uma lista cria "lista dentro de lista"
        // sem querer. Em Java isso nem compila, porque o tipo protege você:
        //   fila.add(List.of("x", "y"));   // NÃO COMPILA
        // Para adicionar vários itens, é sempre addAll.


        // -------------------------------------------------------------------
        // 6. REMOVENDO ITENS
        // -------------------------------------------------------------------
        titulo("6. Removendo itens");

        List<String> letras = new ArrayList<>(List.of("a", "b", "c", "d"));
        System.out.println("início:         " + letras);

        String removida = letras.remove(3);       // remove pela POSIÇÃO e devolve o item
        System.out.println("remove(3)    -> " + letras + "  (removeu \"" + removida + "\")");

        removida = letras.remove(0);
        System.out.println("remove(0)    -> " + letras + "  (removeu \"" + removida + "\")");

        letras.remove("c");                       // remove pelo VALOR (a primeira ocorrência)
        System.out.println("remove(\"c\")  -> " + letras);

        // DIFERENÇA: remover um valor que não existe NÃO dá erro. Devolve false.
        boolean removeu = letras.remove("z");
        System.out.println("remove(\"z\")  -> " + letras + "  (devolveu " + removeu + ")");

        letras.clear();                           // esvazia a lista
        System.out.println("clear()      -> " + letras);

        // CUIDADO com listas de Integer: remove(1) remove a POSIÇÃO 1,
        // e remove(Integer.valueOf(1)) remove o VALOR 1.
        List<Integer> valores = new ArrayList<>(List.of(10, 20, 30));
        valores.remove(1);                        // posição 1: tira o 20
        System.out.println("\n[10, 20, 30].remove(1)               -> " + valores + "  <- tirou a POSIÇÃO 1");
        valores.remove(Integer.valueOf(10));      // valor 10
        System.out.println("[10, 30].remove(Integer.valueOf(10)) -> " + valores + "  <- tirou o VALOR 10");


        // -------------------------------------------------------------------
        // 7. PROCURANDO ITENS
        // -------------------------------------------------------------------
        titulo("7. Procurando itens");

        List<String> frutas = new ArrayList<>(List.of("maçã", "banana", "uva", "banana"));
        System.out.println("frutas = " + frutas);

        // contains() responde se o item está na lista:
        System.out.println("\nfrutas.contains(\"uva\")  -> " + frutas.contains("uva"));
        System.out.println("frutas.contains(\"kiwi\") -> " + frutas.contains("kiwi"));

        // indexOf() diz a posição da PRIMEIRA ocorrência.
        // DIFERENÇA: se não encontrar, devolve -1 em vez de dar erro (como em JavaScript).
        System.out.println("\nfrutas.indexOf(\"banana\") = " + frutas.indexOf("banana"));
        System.out.println("frutas.indexOf(\"kiwi\")   = " + frutas.indexOf("kiwi") + "  <- -1 significa \"não está\"");

        // Para contar quantas vezes um valor aparece, use Collections.frequency:
        System.out.println("\nCollections.frequency(frutas, \"banana\") = " + Collections.frequency(frutas, "banana"));


        // -------------------------------------------------------------------
        // 8. ORDENANDO E INVERTENDO
        // -------------------------------------------------------------------
        titulo("8. Ordenando e invertendo");

        // Collections.sort() ordena a PRÓPRIA lista.
        List<Double> pontos = new ArrayList<>(List.of(7.5, 9.0, 6.0, 8.5));
        System.out.println("pontos = " + pontos);
        Collections.sort(pontos);
        System.out.println("\nCollections.sort(pontos)                             -> " + pontos);
        Collections.sort(pontos, Collections.reverseOrder());
        System.out.println("Collections.sort(pontos, Collections.reverseOrder()) -> " + pontos + "  <- do maior para o menor");
        // DIFERENÇA: como a lista tem tipo, números são ordenados como números
        // (o JavaScript, sem cuidado, ordena como texto).

        // Não existe um sorted() que devolve uma lista nova. Para manter a
        // original, faça uma cópia e ordene a cópia:
        List<Integer> original = new ArrayList<>(List.of(3, 1, 2));
        List<Integer> ordenada = new ArrayList<>(original);
        Collections.sort(ordenada);
        System.out.println("\noriginal = " + original + "  <- continua igual");
        System.out.println("ordenada = " + ordenada);

        // Collections.reverse() inverte a ordem dos itens (sem ordenar):
        List<String> abc = new ArrayList<>(List.of("a", "b", "c"));
        Collections.reverse(abc);
        System.out.println("\nCollections.reverse([a, b, c]) -> " + abc);

        // Strings também são ordenadas (em ordem alfabética):
        List<String> palavras = new ArrayList<>(List.of("uva", "banana", "abacaxi"));
        Collections.sort(palavras);
        System.out.println("Collections.sort([uva, banana, abacaxi]) -> " + palavras);


        // -------------------------------------------------------------------
        // 9. PERCORRENDO A LISTA COM for (E Collections.min, max)
        // -------------------------------------------------------------------
        titulo("9. Percorrendo a lista com for (e Collections.min, max)");

        List<String> compras = new ArrayList<>(List.of("pão", "leite", "café"));

        // O for-each visita cada item, um de cada vez:
        System.out.println("for (String item : compras):");
        for (String item : compras) {
            System.out.println("  - " + item);
        }

        // Se precisar do índice junto, use o for clássico com contador e get(i):
        System.out.println("\nfor (int i = 0; i < compras.size(); i++):");
        for (int i = 0; i < compras.size(); i++) {
            System.out.println("  " + i + ": " + compras.get(i));
        }

        // Exemplo prático: somar as notas com o for.
        // DIFERENÇA: Java não tem sum(). O for é a forma mais simples de somar.
        double soma = 0;
        for (double nota : notas) {
            soma = soma + nota;
        }
        System.out.println("\nsoma com for = " + soma);
        System.out.println("média        = " + String.format("%.2f", soma / notas.size()));

        // Para o menor e o maior existem Collections.min e Collections.max:
        System.out.println("Collections.min(notas) = " + Collections.min(notas));
        System.out.println("Collections.max(notas) = " + Collections.max(notas));


        // -------------------------------------------------------------------
        // RESUMO
        // -------------------------------------------------------------------
        titulo("RESUMO");
        System.out.println("""

                Considere lista = [1, 2, 3]  (um ArrayList<Integer>)

                | O que fazer            | Como                             | Resultado                    |
                |------------------------|----------------------------------|------------------------------|
                | Tamanho                | lista.size()                     | 3                            |
                | Acessar                | lista.get(0)                     | 1                            |
                | Fatiar                 | lista.subList(0, 2)              | [1, 2]  (janela, não cópia)  |
                | Alterar                | lista.set(0, 9)                  | [9, 2, 3]                    |
                | Adicionar no fim       | lista.add(4)                     | [1, 2, 3, 4]                 |
                | Inserir em posição     | lista.add(0, 4)                  | [4, 1, 2, 3]                 |
                | Adicionar vários       | lista.addAll(List.of(4, 5))      | [1, 2, 3, 4, 5]              |
                | Remover por posição    | lista.remove(0)                  | devolve 1, sobra [2, 3]      |
                | Remover por valor      | lista.remove(Integer.valueOf(2)) | [1, 3]                       |
                | Está na lista?         | lista.contains(2)                | true                         |
                | Posição de um valor    | lista.indexOf(2)                 | 1 (ou -1 se não existir)     |
                | Contar                 | Collections.frequency(lista, 2)  | 1                            |
                | Ordenar (no lugar)     | Collections.sort(lista)          | altera a original            |
                | Inverter               | Collections.reverse(lista)       | [3, 2, 1]                    |
                | Menor / maior          | Collections.min / max            | 1 / 3                        |

                Lembre-se:
                  - ArrayList não usa colchetes: get(i) para ler, set(i, x) para alterar.
                  - O primeiro índice é 0. Para o último, use lista.size() - 1.
                  - A lista tem tipo fixo (List<String>, List<Integer>...). Números usam Integer e Double.
                  - remove(1) remove a POSIÇÃO 1. Para remover o VALOR 1, use remove(Integer.valueOf(1)).
                  - Não existe sorted(): copie com new ArrayList<>(lista) e ordene a cópia.

                De Python para Java:

                  len(lista)         -> lista.size()
                  lista[i]           -> lista.get(i)
                  lista[i] = x       -> lista.set(i, x)
                  lista.append(x)    -> lista.add(x)
                  lista.insert(i, x) -> lista.add(i, x)
                  lista.pop(i)       -> lista.remove(i)
                  lista.remove(x)    -> lista.remove(x)  (cuidado com Integer)
                  x in lista         -> lista.contains(x)
                  lista.index(x)     -> lista.indexOf(x)
                  lista.count(x)     -> Collections.frequency(lista, x)
                  lista.sort()       -> Collections.sort(lista)
                  sum(lista)         -> for

                Próximos passos: as outras coleções do Java (arrays, HashSet e HashMap).
                """);
    }
}
