package br.univali.cc.dominio;

/**
 *
 * @author 8640033
 */
abstract public class Despesa {
    protected String descricao;
    
    public Despesa(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    abstract public double calcularCusto();
}
