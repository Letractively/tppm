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
import tppm.config.TPPMConfig;
import tppm.datapoints.RegraEmprestimoDataPoint;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */

@RunWith(Theories.class)
public class RegraEmprestimoTest {
    
    @DataPoints
    public static RegraEmprestimoDataPoint[] regrasEmprestimo = {
        new RegraEmprestimoDataPoint(0.70, 6000.00, 4200.00),
        new RegraEmprestimoDataPoint(0.60, 3560.00, 2136.00),
        new RegraEmprestimoDataPoint(0.55, 9367.98, 5152.38),
        new RegraEmprestimoDataPoint(0.45, 3256.00, 1465.20),
        new RegraEmprestimoDataPoint(0.35, 3135.00, 1097.25),
        new RegraEmprestimoDataPoint(0.75, 2658.00, 1993.50),
        new RegraEmprestimoDataPoint(0.40, 3256.00, 1302.40),
    };
    
    public RegraEmprestimoTest() {
    }
    
    @Theory
    public void testCalculaLimiteEmprestimo(RegraEmprestimoDataPoint cenario) {
        Assume.assumeTrue(Arrays.asList(regrasEmprestimo).contains(cenario));
        RegraEmprestimo regra = new RegraEmprestimo(null, 0, 0, null, null, cenario.porcentagemLimiteSalario);
        Double resultado = regra.calculaLimiteEmprestimo(cenario.salario);
        assertEquals(cenario.limite, resultado, TPPMConfig.DELTA_COMPARACAO_DOUBLE);
    }
}
