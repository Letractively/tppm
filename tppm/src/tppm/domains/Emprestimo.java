/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.domains;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class Emprestimo {
    
    private Empregado empregado;
    private Double valorSolicitado;
    private int numeroPrestacoes;
    private RegraTaxaDeJuros regraTaxaDeJuros;
    
    public Emprestimo(Empregado empregado, Double valorSolicitado, int numeroPrestacoes, RegraTaxaDeJuros regraTaxaDeJuros) {
        this.empregado = empregado;
        this.valorSolicitado = valorSolicitado;
        this.numeroPrestacoes = numeroPrestacoes;
        this.regraTaxaDeJuros = regraTaxaDeJuros;
    }

    public Empregado getEmpregado() {
        return empregado;
    }

    public Double getValorSolicitado() {
        return valorSolicitado;
    }

    public int getNumeroPrestacoes() {
        return numeroPrestacoes;
    }
    
    public Double getValorTotalPagar(){
        return getValorPrestacao() * getNumeroPrestacoes();
    }
    
    public Double getValorPrestacao(){
        return getValorSolicitado() * calcularCF();
    }
    
    private Double calcularCF(){
        return ( getTaxaDeJuros() / ( 1 - ( 1 / ( Math.pow(1+getTaxaDeJuros(), getNumeroPrestacoes())  ) ) ) );
    }
    
    private Double getTaxaDeJuros() {
        return regraTaxaDeJuros.getTaxaDeJuros();
    }
}
