package Application;

import java.util.List;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Produto;
import entities.StatusEstoque;

public class App {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Produto> produto = new ArrayList<>();

        int opcao;
        do {
            System.out.println("=== AÇAÍ DO JAVA ===");
            System.out.println();
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Listar todos os produtos");
            System.out.println("3. Buscar produto por nome");
            System.out.println("4. Filtrar produtos com estoque baixo");
            System.out.println("5. Registrar entrada de estoque");
            System.out.println("6. Registrar saída de estoque");
            System.out.println("7. Ver valor total do estoque");
            System.out.println("0. Sair");
            System.out.println();

            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            System.out.println();

            switch (opcao) {
                case 1: // CADASTRO DE PRODUTO
                    System.out.print("Digite o nome do produto: ");
                    sc.nextLine();
                    String nome = sc.nextLine();
                    System.out.print("Digite a categoria do produto: ");
                    String categoria = sc.nextLine();
                    System.out.print("Quantidade atual em estoque: ");
                    int quantidadeEstoque = sc.nextInt();
                    System.out.print("Quantidade mínima que precisa ter em estoque: ");
                    int quantidadeMinima = sc.nextInt();
                    System.out.print("Preço de custo unitário: ");
                    double custoUnitario = sc.nextDouble();
                    produto.add(new Produto(nome, categoria, quantidadeEstoque, quantidadeMinima, custoUnitario));
                    System.out.println();
                    System.out.println("Produto cadastrado com sucesso!");
                    voltarAoMenu(sc);
                    break;
                
                case 2: // LISTAGEM DE TODOS OS PRODUTOS
                    System.out.println("LISTA DOS PRODUTOS:");
                    for (Produto produtos : produto) {
                        System.out.println(produtos);   
                    }
                    voltarAoMenu(sc);
                    break;

                case 3: // BUSCA DE PRODUTO POR NOME
                    sc.nextLine();
                    boolean achouProduto = false;
    
                    while (!achouProduto) {
                        System.out.print("Digite o nome do produto (ou 0 para voltar): ");
                        String busca = sc.nextLine();
        
                        if (busca.equals("0")) {
                            break;
                        }
                    // PERCORRE TODOS OS PRODUTOS DA LISTA E VERIFICA SE O NOME DE CADA UM
                    // CONTÉM O TERMO DIGITADO PELO USUÁRIO (IGNORANDO MAIÚSCULAS/MINÚSCULAS).
                    for (Produto p : produto) {
                        if (p.getNome().toLowerCase().contains(busca.toLowerCase())) {
                            System.out.println(p);
                            achouProduto = true;
                            voltarAoMenu(sc);
                        }
                    }
                    
                    if (!achouProduto) {
                        System.out.println("Nenhum produto encontrado! Tente novamente ou digite 0 para voltar.");
                        System.out.println();
                    }
                    }
                    break;

                case 4: // FILTRAR PRODUTOS COM ESTOQUE BAIXO
                    System.out.println("PRODUTOS COM ESTOQUE BAIXO:");
                    for (Produto p : produto) {
                        if (p.statusEstoque() == StatusEstoque.BAIXO) {
                            System.out.println(p);
                        }
                    }
                    voltarAoMenu(sc);
                    break;
                
                case 5: // REGISTRAR ENTRADA DE ESTOQUE    
                    System.out.print("Digite o nome do produto para adicionar quantidade:");
                    sc.nextLine();
                    String nomeEntrada = sc.nextLine();

                    boolean achouEntrada = false;
                    for (Produto p : produto) {
                        if (p.getNome().equalsIgnoreCase(nomeEntrada)) {
                            System.out.print("Quantidade a adicionar: ");
                            int qtdEntrada = sc.nextInt();
                            p.setQuantidadeEstoque(p.getQuantidadeEstoque() + qtdEntrada);
                            System.out.println();
                            System.out.println("Estoque atualizado! Nova quantidade: " + p.getQuantidadeEstoque());
                            achouEntrada = true;
                            voltarAoMenu(sc);
                            break;
                        }
                    }

                    if (!achouEntrada) {
                        System.out.println("Nenhum produto encontrado! Tente novamente ou digite 0 para voltar.");
                        System.out.println();
                    }
                    break;
               
                case 6: // REGISTRAR SAIDA DO ESTOQUE
                    System.out.print("Digite o nome do produto para retirar do estoque: ");
                    sc.nextLine();
                    String nomeSaida = sc.nextLine();

                    boolean achouSaida = false;
                    for (Produto p : produto) {
                        if (p.getNome().equalsIgnoreCase(nomeSaida)) {
                            System.out.print("Quantidade a diminuir: ");
                            int qtdSaida = sc.nextInt();
                            if (qtdSaida > p.getQuantidadeEstoque()) {
                                System.out.println("Quantidade insuficiente em estoque!");
                            } else {
                                p.setQuantidadeEstoque(p.getQuantidadeEstoque() - qtdSaida);
                                System.out.println();
                                System.out.println("Estoque atualizado! Nova quantidade: " + p.getQuantidadeEstoque());
                                achouSaida = true;
                            }
                            voltarAoMenu(sc);
                            break;
                        }                        
                    }

                    if (!achouSaida) {
                        System.out.println("Nenhum produto encontrado! Tente novamente ou digite 0 para voltar.");
                        System.out.println();
                    }
                    break;

                case 7: // VALOR TOTAL DO ESTOQUE
                    double valorTotal = 0.0;
                    for (Produto p : produto) {
                        valorTotal += p.getCustoUnitario() * p.getQuantidadeEstoque();
                    }
                    System.out.println("VALOR TOTAL DO ESTOQUE: R$ " + String.format("%.2f", valorTotal));
                    voltarAoMenu(sc);
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
    }while (opcao != 0);
        
        sc.close();
    }

    static void voltarAoMenu(Scanner sc) {
        System.out.println();
        System.out.print("Pressione Enter para voltar ao menu...");
        sc.nextLine();
        sc.nextLine();
    }
}