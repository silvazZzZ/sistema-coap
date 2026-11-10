/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.cc.dominio;

/**
 *
 * @author 8640033
 */
public class MaoObra extends Despesa {
    private int quantidadeHoras;
    private char dificuldade;
    private int fatorDificuldade;

 public MaoObra(String descricao, int quantidadeHoras, char dificuldade){
    super(descricao);
    this.quantidadeHoras = quantidadeHoras;
    this.dificuldade = dificuldade;
    }
 
 public int getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public char getDificuldade() {
        return dificuldade;
    }

    public int getFatorDificuldade() {
        return fatorDificuldade;
    }
 
    /**
     *
     * @return
     */
    @Override
 public double calcularCusto(){

     if (this.dificuldade == 'F'){
        fatorDificuldade = 10;
     } 
     else if (this.dificuldade == 'M'){
        fatorDificuldade = 25;
     }
     else if(this.dificuldade == 'D'){
        fatorDificuldade = 50;
 }
      return this.quantidadeHoras * this.fatorDificuldade;
 }
}