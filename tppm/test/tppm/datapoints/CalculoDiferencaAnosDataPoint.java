/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.datapoints;

import java.util.Date;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class CalculoDiferencaAnosDataPoint {
    
    public Date data1;
    public Date data2;
    public int resultadoExperado;
    
    public CalculoDiferencaAnosDataPoint(Date data1, Date data2, int resultadoExperado) {
        this.data1 = data1;
        this.data2 = data2;
        this.resultadoExperado = resultadoExperado;
    }
    
}
