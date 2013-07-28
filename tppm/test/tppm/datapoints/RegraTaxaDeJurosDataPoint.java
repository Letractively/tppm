/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.datapoints;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class RegraTaxaDeJurosDataPoint {
    
    public int numeroMinimoPrestacoes;
    public int numeroMaximoPrestacoes;
    public int numeroDePrestacoes;
    
    //resultado esperado
    public boolean resultadoVerificaPertenceFaixa;

    public RegraTaxaDeJurosDataPoint(int numeroMinimoPrestacoes, int numeroMaximoPrestacoes, int numeroDePrestacoes, boolean resultadoVerificaPertenceFaixa) {
        this.numeroMinimoPrestacoes = numeroMinimoPrestacoes;
        this.numeroMaximoPrestacoes = numeroMaximoPrestacoes;
        this.numeroDePrestacoes = numeroDePrestacoes;
        this.resultadoVerificaPertenceFaixa = resultadoVerificaPertenceFaixa;
    }
}
