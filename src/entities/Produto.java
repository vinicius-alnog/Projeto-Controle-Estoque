package entities;

public class Produto {

    private String nome;
    private String categoria;
    private int quantidadeEstoque;
    private int quantidadeMinima;
    private double custoUnitario;

    public Produto(String nome, String categoria, int quantidadeEstoque, int quantidadeMinima, double custoUnitario) {
        this.nome = nome;
        this.categoria = categoria;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeMinima = quantidadeMinima;
        this.custoUnitario = custoUnitario;
    }

    // NOME E CATEGORIA NÃO PRECISAM SER ALTERADOS UMA VEZ INFORMADOS PELO USUÁRIO NO
    // ATO DO CADASTRO. POR ISSO, SÓ POSSUEM GET
    public String getNome() { 
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }
    
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public double getCustoUnitario() {
        return custoUnitario;
    }

    public void setCustoUnitario(double custoUnitario) {
        this.custoUnitario = custoUnitario;
    }

    public StatusEstoque statusEstoque() {
        if (quantidadeEstoque == 0) {
            return StatusEstoque.ZERADO;
        } else if (quantidadeEstoque <= quantidadeMinima) {
            return StatusEstoque.BAIXO;
        } else {
            return StatusEstoque.OK;
        }
    }

    @Override
    public String toString() {
        return "Produto " + nome + " || Categoria: " + categoria + " || Quantidade em Estoque: " 
        + quantidadeEstoque + " || Quantidade mínima: " + quantidadeMinima 
        + " || Custo unitário: " + custoUnitario + " || Status: " + statusEstoque().getDescricao();
    }
}
