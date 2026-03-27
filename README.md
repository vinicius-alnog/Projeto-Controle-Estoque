# 🍇 Açaí do Java — Sistema de Controle de Estoque

Sistema de controle de estoque para uma loja de açaí desenvolvido em Java, criado como exercício prático para consolidar conceitos fundamentais de Programação Orientada a Objetos.

---

## 📋 Funcionalidades

- **Cadastrar produto** — registra nome, categoria, quantidade, quantidade mínima e custo unitário
- **Listar produtos** — exibe todos os produtos cadastrados com seu status de estoque
- **Buscar por nome** — localiza produtos pelo nome ou parte dele
- **Filtrar estoque baixo** — lista apenas os produtos abaixo da quantidade mínima
- **Registrar entrada** — adiciona quantidade ao estoque de um produto
- **Registrar saída** — remove quantidade do estoque, com validação para evitar saldo negativo
- **Valor total do estoque** — calcula a soma de `quantidade × custo unitário` de todos os produtos

---

## 🧠 Conceitos praticados

| Conceito | Onde foi aplicado |
|---|---|
| **Classes e Encapsulamento** | Classe `Produto` com atributos privados e getters/setters seletivos |
| **Enumerações:** `StatusEstoque` para classificar o nível do estoque de cada produto
| **Construtor** | Criação de produtos com todos os dados definidos na instanciação |
| **Listas** | `ArrayList<Produto>` para armazenar e gerenciar os produtos |
| **Loops:** `do/while` para o menu e `for each` para percorrer a lista de produtos | 
| **Validações:** verificação de estoque suficiente antes de registrar saída e busca com `contains` e `equalsIgnoreCase` |
| **Busca** | Percorrendo a lista para encontrar produtos pelo nome |
| **Filtro** | Filtrando produtos com status de estoque baixo ou zerado |
| **Cálculos** | Somando o valor total do estoque com base em quantidade e custo |

---

## 🗂️ Estrutura do projeto

```
src/
├── Application/
│   └── App.java          # Classe principal com menu e interação com o usuário
└── entities/
    └── Produto.java      # Entidade com atributos, getters/setters e regras de status
```

---

## 💡 Observações

- O sistema roda inteiramente no console
- Os dados são armazenados em memória — ao encerrar o programa, os dados são perdidos
- Ao digitar o preço, utilize ponto como separador decimal (ex: `3.50`)

---

Desenvolvido como exercício de estudo de Java — feedbacks são bem-vindos! 🚀

## Autor
 
Vinicius Nogueira
* GitHub: **@vinicius-alnog**
* LinkedIn: https://www.linkedin.com/in/viniciusalnogueira/
