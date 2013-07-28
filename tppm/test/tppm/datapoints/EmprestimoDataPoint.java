/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.datapoints;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class EmprestimoDataPoint{
    
    public Double valor;
    public int numeroPrestacoes;
    public Double taxaDeJuros;
    
    //resultado esperado
    public Double valorTotalEmprestimo; 
    
    public EmprestimoDataPoint(Double valor, int numeroPrestacoes, Double taxaDeJuros, Double valorTotalEmprestimo) {
        this.valor = valor;
        this.numeroPrestacoes = numeroPrestacoes;
        this.taxaDeJuros = taxaDeJuros;
        this.valorTotalEmprestimo = valorTotalEmprestimo;
    }
}