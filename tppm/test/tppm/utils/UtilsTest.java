/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.utils;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import tppm.datapoints.CalculoDiferencaAnosDataPoint;
import tppm.datapoints.ConverterStringParaDataDataPoint;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */

@RunWith(Theories.class)
public class UtilsTest {
    
    @DataPoints
    public static CalculoDiferencaAnosDataPoint[] calculoDiferencaAnosDataPoints = {
        new CalculoDiferencaAnosDataPoint(new GregorianCalendar(2013, GregorianCalendar.APRIL, 20).getTime(), new GregorianCalendar(2025, GregorianCalendar.APRIL, 20).getTime(), 12),
        new CalculoDiferencaAnosDataPoint(new GregorianCalendar(1992, GregorianCalendar.APRIL, 14).getTime(), new GregorianCalendar(2013, GregorianCalendar.MARCH, 27).getTime(), 20),
        new CalculoDiferencaAnosDataPoint(new GregorianCalendar(2000, GregorianCalendar.APRIL, 20).getTime(), new GregorianCalendar(2100, GregorianCalendar.JUNE, 20).getTime(), 100),
        new CalculoDiferencaAnosDataPoint(new GregorianCalendar(1985, GregorianCalendar.JANUARY, 20).getTime(), new GregorianCalendar(2004, GregorianCalendar.DECEMBER, 20).getTime(), 19),
        new CalculoDiferencaAnosDataPoint(new GregorianCalendar(1962, GregorianCalendar.OCTOBER, 20).getTime(), new GregorianCalendar(2036, GregorianCalendar.JULY, 20).getTime(), 73),
        new CalculoDiferencaAnosDataPoint(new GregorianCalendar(1934, GregorianCalendar.FEBRUARY, 20).getTime(), new GregorianCalendar(2045, GregorianCalendar.AUGUST, 20).getTime(), 111)
    };
    
    @Theory
    public void testCalculaDiferencaAnos(CalculoDiferencaAnosDataPoint cenario) throws Exception {
        Assume.assumeTrue(Arrays.asList(calculoDiferencaAnosDataPoints).contains(cenario));
        int resultado = Utils.calculaDiferencaAnos(cenario.data1, cenario.data2);
        assertEquals(cenario.resultadoExperado, resultado);
    }
    
    
    @DataPoints
    public static ConverterStringParaDataDataPoint[] converterStringParaDataDataPoint = {
        new ConverterStringParaDataDataPoint("14/04/1992", new GregorianCalendar(1992, GregorianCalendar.APRIL, 14).getTime()),
        new ConverterStringParaDataDataPoint("10/10/1956", new GregorianCalendar(1956, GregorianCalendar.OCTOBER, 10).getTime()),
        new ConverterStringParaDataDataPoint("22/03/1987", new GregorianCalendar(1987, GregorianCalendar.MARCH, 22).getTime()),
        new ConverterStringParaDataDataPoint("18/02/1986", new GregorianCalendar(1986, GregorianCalendar.FEBRUARY, 18).getTime()),
        new ConverterStringParaDataDataPoint("06/12/1934", new GregorianCalendar(1934, GregorianCalendar.DECEMBER, 06).getTime()),
        new ConverterStringParaDataDataPoint("28/01/1975", new GregorianCalendar(1975, GregorianCalendar.JANUARY, 28).getTime()),
        new ConverterStringParaDataDataPoint("03/11/1968", new GregorianCalendar(1968, GregorianCalendar.NOVEMBER, 03).getTime()),
        new ConverterStringParaDataDataPoint("12/07/1953", new GregorianCalendar(1953, GregorianCalendar.JULY, 12).getTime()),
        new ConverterStringParaDataDataPoint("23/09/1995", new GregorianCalendar(1995, GregorianCalendar.SEPTEMBER, 23).getTime())
    };
    
    @Theory
    public void testConverterStringParaData(ConverterStringParaDataDataPoint cenario) throws Exception {
        Assume.assumeTrue(Arrays.asList(converterStringParaDataDataPoint).contains(cenario));
        Date resultado = Utils.converterStringParaData(cenario.data);
        assertEquals(cenario.dataConvertidaEsperada, resultado);
    }
}
