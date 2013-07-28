/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.datapoints;

import java.util.Date;
import java.util.GregorianCalendar;
import tppm.domains.Empregado;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class EmprestimoEmpregadoDataPoint{
    
    public final String CPF_VALIDO = "12862377775";
    public final String NOME_VALIDO = "Tiago Neves";
    
    public String sexo;
    public Double salario;
    public Date dataNascimento;
    public Double valor;
    public int numeroPrestacoes;
    
    //resultado esperado
    public Double valorTotalEmprestimo; 
    public Class exceptionEsperada;
    
    public EmprestimoEmpregadoDataPoint(String sexo, Date dataNascimento, Double salario, Double valor, int numeroPrestacoes, Double valorTotalEmprestimo, Class exceptionEsperada) {
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
        this.valor = valor;
        this.numeroPrestacoes = numeroPrestacoes;
        this.valorTotalEmprestimo = valorTotalEmprestimo;
        this.exceptionEsperada = exceptionEsperada;
    }
    
    public Date getDataAdmissaoValida(){
        GregorianCalendar dataAdmissao = new GregorianCalendar();
        dataAdmissao.setTime(dataNascimento);
        dataAdmissao.add(GregorianCalendar.YEAR, 18);
        return dataAdmissao.getTime();
    }
    
    public Empregado getEmpregado(){
        return new Empregado(CPF_VALIDO, NOME_VALIDO, sexo, dataNascimento, getDataAdmissaoValida(), salario, null);
    }
}