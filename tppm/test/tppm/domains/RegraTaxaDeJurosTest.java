/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.domains;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import tppm.datapoints.RegraTaxaDeJurosDataPoint;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */

@RunWith(Theories.class)
public class RegraTaxaDeJurosTest {
    
    @DataPoints
    public static RegraTaxaDeJurosDataPoint[] regrasTaxaDeJuros = {
        new RegraTaxaDeJurosDataPoint(1, 3, 1, true),
        new RegraTaxaDeJurosDataPoint(1, 3, 2, true),
        new RegraTaxaDeJurosDataPoint(1, 3, 3, true),
        new RegraTaxaDeJurosDataPoint(4, 9, 4, true),
        new RegraTaxaDeJurosDataPoint(4, 9, 6, true),
        new RegraTaxaDeJurosDataPoint(4, 9, 9, true),
        new RegraTaxaDeJurosDataPoint(10, 12, 10, true),
        new RegraTaxaDeJurosDataPoint(10, 12, 11, true),
        new RegraTaxaDeJurosDataPoint(10, 12, 12, true),
        new RegraTaxaDeJurosDataPoint(13, 18, 13, true),
        new RegraTaxaDeJurosDataPoint(13, 18, 15, true),
        new RegraTaxaDeJurosDataPoint(13, 18, 18, true)
    };

    @Theory
    public void testVerificaNumeroDePrestacoesPertenceAFaixaDaTaxa(RegraTaxaDeJurosDataPoint cenario) {
        RegraTaxaDeJuros regraTaxaDeJuros = new RegraTaxaDeJuros(cenario.numeroMinimoPrestacoes, cenario.numeroMaximoPrestacoes, null);
        boolean resultado = regraTaxaDeJuros.verificaNumeroDePrestacoesPertenceAFaixaDaTaxa(cenario.numeroDePrestacoes);
        assertEquals(cenario.resultadoVerificaPertenceFaixa, resultado);
    }
}
