package br.univali.cc.dominio;

/**
 *
 * @author 8640033
 */
public class Aquisicao extends Despesa {
    private double valorUnitario;
    private int quantidadeItens;
    
    public Aquisicao(String descricao, double valorUnitario, int quantidadeItens){
       
        super(descricao);
        this.valorUnitario = valorUnitario;
        this.quantidadeItens = quantidadeItens;
}
    
    
   @Override
   public double calcularCusto(){
       return this.valorUnitario * quantidadeItens;
   }

}

