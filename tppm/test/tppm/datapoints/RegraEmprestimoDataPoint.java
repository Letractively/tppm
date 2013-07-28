/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.datapoints;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class RegraEmprestimoDataPoint {
    
    public Double porcentagemLimiteSalario;
    public Double salario;
    
    //resultado esperado
    public Double limite; 
    
    public RegraEmprestimoDataPoint(Double porcentagemLimiteSalario, Double salario, Double limite) {
        this.porcentagemLimiteSalario = porcentagemLimiteSalario;
        this.salario = salario;
        this.limite = limite;
    }
}
