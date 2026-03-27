package entities;

public enum StatusEstoque {

    OK("OK"),
    BAIXO("Estoque baixo"),
    ZERADO("Zerado");

    private String descricao;

    StatusEstoque(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}