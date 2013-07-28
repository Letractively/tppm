/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.domains;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class RegraTaxaDeJuros {
    
    private int numeroMinimoDePrestacoes;
    private int numeroMaximoDePrestacoes;
    private Double taxaDeJuros;

    public RegraTaxaDeJuros(int numeroMinimoDePrestacoes, int numeroMaximoDePrestacoes, Double taxaDeJuros) {
        this.numeroMinimoDePrestacoes = numeroMinimoDePrestacoes;
        this.numeroMaximoDePrestacoes = numeroMaximoDePrestacoes;
        this.taxaDeJuros = taxaDeJuros;
    }

    public int getNumeroMaximoDePrestacoes() {
        return numeroMaximoDePrestacoes;
    }

    public void setNumeroMaximoDePrestacoes(int numeroMaximoDePrestacoes) {
        this.numeroMaximoDePrestacoes = numeroMaximoDePrestacoes;
    }

    public int getNumeroMinimoDePrestacoes() {
        return numeroMinimoDePrestacoes;
    }

    public void setNumeroMinimoDePrestacoes(int numeroMinimoDePrestacoes) {
        this.numeroMinimoDePrestacoes = numeroMinimoDePrestacoes;
    }

    public Double getTaxaDeJuros() {
        return taxaDeJuros;
    }

    public void setTaxaDeJuros(Double taxaDeJuros) {
        this.taxaDeJuros = taxaDeJuros;
    }
    
    public boolean verificaNumeroDePrestacoesPertenceAFaixaDaTaxa(int numeroDePrestacoes){
        return (numeroDePrestacoes >= getNumeroMinimoDePrestacoes() && numeroDePrestacoes <= getNumeroMaximoDePrestacoes());
    }
}
