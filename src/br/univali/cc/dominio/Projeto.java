package br.univali.cc.dominio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 8640033
 */
public class Projeto {
    private String nome;
    private String dataInicio;
    private String dataFim;
    private double margemLucro;
    private List<Despesa> listaDespesas;
    


public Projeto(String nome, String dataInicio, String dataFim, double margemLucro) {
    this.nome = nome;
    this.dataInicio = dataInicio;
    this.dataFim = dataFim;
    this.margemLucro = margemLucro;
    this.listaDespesas = new ArrayList<>();
}

public double margemLucro(){
    return margemLucro;
}

public double calcularCustoTotal(){
    double custoTotal = 0.0;
        
     for (Despesa d : listaDespesas) {
          custoTotal += d.calcularCusto();
     }
     return custoTotal;
}

public double calcularPrecoFinal(){
    return calcularCustoTotal() * (1 + margemLucro);
}

public void adicionarDespesa(String descricao, int qtdeHoras, char dificuldade) {
      listaDespesas.add(new MaoObra(descricao, qtdeHoras, dificuldade));
  }

public void adicionarDespesa(String descricao, double valorUnitario, int qtdeItens) {
     listaDespesas.add(new Aquisicao(descricao, valorUnitario, qtdeItens));
  }

}
