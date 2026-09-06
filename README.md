# Estrutura de Dados

Material orientador para os alunos da disciplina de **Estrutura de Dados** do curso de **Engenharia de Software**.

## Sobre este repositório

Este diretório reúne o conteúdo trabalhado em sala, organizado aula por aula. A ideia é começar pelo mais básico e avançar aos poucos: primeiro os fundamentos das linguagens, depois as coleções nativas, e então as estruturas de dados clássicas (listas encadeadas, pilhas, filas, árvores, grafos, tabelas hash, etc.) e os algoritmos que as acompanham.

Os conceitos de estrutura de dados são independentes de linguagem. Por isso, os exemplos serão apresentados em **mais de uma linguagem**, principalmente **Python**, **Java** e **JavaScript**, para que você perceba o que é essencial ao conceito e o que é apenas detalhe de sintaxe. Nem toda aula terá exemplos em todas as linguagens.

Cada arquivo é escrito para ser **lido e executado**. Os comentários explicam os conceitos, e a saída no terminal mostra o resultado na prática. Recomendamos ler o código com calma, rodar, alterar os exemplos e observar o que muda.

## Ambiente necessário

Instale apenas o que for usar. As versões abaixo são as mínimas recomendadas:

| Linguagem | Versão | Como verificar |
|-----------|--------|----------------|
| Python | 3.10+ | `python3 --version` |
| Java | 17+ (JDK) | `java --version` |
| JavaScript | Node.js 18+ | `node --version` |

## Como executar os exemplos

Clone o repositório e entre na pasta da aula desejada:

```bash
git clone <url-do-repositorio>
cd estrutura-de-dados/aula-01
```

Depois, execute o arquivo conforme a linguagem:

```bash
# Python
python3 tipos-primitivos.py

# Java (compila e executa em um único passo, Java 11+)
java TiposPrimitivos.java

# JavaScript
node tipos-primitivos.js
```

## Organização

Cada aula fica em uma pasta própria, numerada em ordem crescente. Dentro dela, cada arquivo é identificado pela extensão da linguagem:

```
estrutura-de-dados/
├── aula-01/
│   ├── tipos-primitivos.py      # Python
│   ├── TiposPrimitivos.java     # Java
│   └── tipos-primitivos.js      # JavaScript
├── aula-02/
│   └── ...
└── README.md
```

Convenções de nomes:

- **Python e JavaScript:** nomes em minúsculas separados por hífen (`tipos-primitivos.py`, `tipos-primitivos.js`).
- **Java:** o nome do arquivo precisa ser igual ao da classe pública, em *PascalCase* (`TiposPrimitivos.java`).

## Conteúdo

| Aula | Tema | Python | Java | JavaScript |
|------|------|--------|------|------------|
| 01 | Tipos primitivos: números, booleanos, texto e ausência de valor; tipagem, conversão entre tipos, imutabilidade e identidade | [`tipos-primitivos.py`](aula-01/tipos-primitivos.py) | [`TiposPrimitivos.java`](aula-01/TiposPrimitivos.java) | [`tipos-primitivos.js`](aula-01/tipos-primitivos.js) |
| 02 | Listas: criar, acessar, fatiar, alterar, adicionar, remover, procurar, ordenar e percorrer; ao final, cópia e comprehension | [`listas.py`](aula-02/listas.py) | [`Listas.java`](aula-02/Listas.java) | [`listas.js`](aula-02/listas.js) |

Novas aulas e linguagens serão adicionadas à tabela conforme o semestre avança.

## Contribuindo

Encontrou um erro ou tem uma sugestão de melhoria? Abra uma *issue* ou envie um *pull request*. Dúvidas sobre o conteúdo podem ser levadas para a sala de aula ou registradas como *issue* neste repositório.
