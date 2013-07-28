/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.domains;

import java.util.Arrays;
import java.util.List;

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
    
    public RegraTaxaDeJuros(RegraTaxaDeJuros regra) {
        this.numeroMinimoDePrestacoes = regra.getNumeroMinimoDePrestacoes();
        this.numeroMaximoDePrestacoes = regra.getNumeroMaximoDePrestacoes();
        this.taxaDeJuros = regra.getTaxaDeJuros();
    }

    @Override
    public boolean equals(Object regraComparada) {
        return getListaPropriedades().equals(((RegraTaxaDeJuros) regraComparada).getListaPropriedades());
    }

    private List<?> getListaPropriedades(){
        return Arrays.asList(getNumeroMinimoDePrestacoes(), getNumeroMaximoDePrestacoes(), getTaxaDeJuros());
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
