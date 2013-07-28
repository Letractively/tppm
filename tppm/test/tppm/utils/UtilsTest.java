/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */

@RunWith(Parameterized.class)
public class UtilsTest {
    
    private Date data1;
    private Date data2;
    private int resultadoExperado;
    
    public UtilsTest(Date data1, Date data2, int resultadoExperado) {
        this.data1 = data1;
        this.data2 = data2;
        this.resultadoExperado = resultadoExperado;
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                    new Object[][]{
                        {new GregorianCalendar(2013, GregorianCalendar.APRIL, 20).getTime(), new GregorianCalendar(2025, GregorianCalendar.APRIL, 20).getTime(), 12},
                        {new GregorianCalendar(1992, GregorianCalendar.APRIL, 14).getTime(), new GregorianCalendar(2013, GregorianCalendar.MARCH, 27).getTime(), 20},
                        {new GregorianCalendar(2000, GregorianCalendar.APRIL, 20).getTime(), new GregorianCalendar(2100, GregorianCalendar.JUNE, 20).getTime(), 100},
                        {new GregorianCalendar(1985, GregorianCalendar.JANUARY, 20).getTime(), new GregorianCalendar(2004, GregorianCalendar.DECEMBER, 20).getTime(), 19},
                        {new GregorianCalendar(1962, GregorianCalendar.OCTOBER, 20).getTime(), new GregorianCalendar(2036, GregorianCalendar.JULY, 20).getTime(), 73},
                        {new GregorianCalendar(1934, GregorianCalendar.FEBRUARY, 20).getTime(), new GregorianCalendar(2045, GregorianCalendar.AUGUST, 20).getTime(), 111}
                    }
                );
    };

    @Test
    public void testCalculaDiferencaAnos() {
        int resultado = Utils.calculaDiferencaAnos(data1, data2);
        assertEquals(resultadoExperado, resultado);
    }
}
