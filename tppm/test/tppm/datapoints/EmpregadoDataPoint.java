/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.datapoints;

import tppm.domains.Empregado;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class EmpregadoDataPoint {
    
    public Empregado empregado;
    public Class exceptionEsperada;

    public EmpregadoDataPoint(Empregado empregado, Class exceptionEsperada) {
        this.empregado = empregado;
        this.exceptionEsperada = exceptionEsperada;
    }
}
