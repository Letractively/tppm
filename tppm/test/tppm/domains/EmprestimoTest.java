/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.domains;

import java.util.Arrays;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import tppm.datapoints.EmprestimoDataPoint;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */

@RunWith(Theories.class)
public class EmprestimoTest {
    
    final Double DELTA = 0.01;
    
    @DataPoints
    public static EmprestimoDataPoint[] emprestimos = {
        new EmprestimoDataPoint(
            1000.00,
            10,
            0.08,
            1490.30
        ),
        new EmprestimoDataPoint(
            1230.00,
            5,
            0.065,
            1479.90
        ),
        new EmprestimoDataPoint(
            1956.00,
            2,
            0.05,
            2103.89
        ),
        new EmprestimoDataPoint(
            300.00,
            14,
            0.1,
            570.13
        )
    };
    
    public EmprestimoTest() {
    }
    
    @Theory
    public void testGetValorTotalPagar(EmprestimoDataPoint cenario) {
        Assume.assumeTrue(Arrays.asList(emprestimos).contains(cenario));
        
        RegraTaxaDeJuros regraTaxaDeJuros = mock(RegraTaxaDeJuros.class);
        when(regraTaxaDeJuros.getTaxaDeJuros()).thenReturn(cenario.taxaDeJuros);
        
        Emprestimo emprestimo = new Emprestimo(null, cenario.valor, cenario.numeroPrestacoes, regraTaxaDeJuros);
        assertEquals(cenario.valorTotalEmprestimo, emprestimo.getValorTotalPagar(), DELTA);
    }

    @Theory
    public void testGetValorPrestacao(EmprestimoDataPoint cenario) {
        Assume.assumeTrue(Arrays.asList(emprestimos).contains(cenario));
        
        RegraTaxaDeJuros regraTaxaDeJuros = mock(RegraTaxaDeJuros.class);
        when(regraTaxaDeJuros.getTaxaDeJuros()).thenReturn(cenario.taxaDeJuros);
        
        Emprestimo emprestimo = new Emprestimo(null, cenario.valor, cenario.numeroPrestacoes, regraTaxaDeJuros);
        assertEquals(cenario.valorTotalEmprestimo/cenario.numeroPrestacoes, emprestimo.getValorPrestacao(1), DELTA);
    }
}
