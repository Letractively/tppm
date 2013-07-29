/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.services;

import tppm.datapoints.EmprestimoEmpregadoDataPoint;
import java.util.Arrays;
import java.util.GregorianCalendar;
import org.junit.Assume;
import org.junit.Before;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import tppm.config.TPPMConfig;
import tppm.domains.dao.RegraEmprestimoDAO;
import tppm.domains.dao.RegraTaxaDeJurosDAO;
import static org.junit.Assert.*;
import tppm.domains.Empregado;
import tppm.domains.Emprestimo;
import tppm.domains.RegraEmprestimo;
import tppm.domains.RegraTaxaDeJuros;
import tppm.exceptions.validacaoEmprestimoExceptions.IdadeMaiorQueAPermitidaParaEmprestimoException;
import tppm.exceptions.validacaoEmprestimoExceptions.IdadeMenorQueAPermitidaParaEmprestimoException;
import tppm.exceptions.validacaoEmprestimoExceptions.NumeroDePrestacoesMaiorQueOPermitidoException;
import tppm.exceptions.validacaoEmprestimoExceptions.NumeroDePrestacoesMenorQueOPermitidoException;
import tppm.exceptions.validacaoEmprestimoExceptions.ValorSolicitadoMaiorQueOPermitidoException;
import static org.mockito.Mockito.*;

@RunWith(Theories.class)
public class EmprestimoServiceTest {
    
    EmprestimoService emprestimoService;
    
    @DataPoints
    public static EmprestimoEmpregadoDataPoint[] emprestimos = {
        new EmprestimoEmpregadoDataPoint(
            Empregado.SEXO_MASCULINO, 
            new GregorianCalendar(1992, GregorianCalendar.APRIL, 14).getTime(),
            15000.00,
            1000.00,
            10,
            1490.30,
            null
        ),
        new EmprestimoEmpregadoDataPoint(
            Empregado.SEXO_MASCULINO, 
            new GregorianCalendar(1977, GregorianCalendar.MARCH, 28).getTime(),
            3650.00,
            1230.00,
            5,
            1479.90,
            null
        ),
        new EmprestimoEmpregadoDataPoint(
            Empregado.SEXO_MASCULINO, 
            new GregorianCalendar(1966, GregorianCalendar.JUNE, 04).getTime(),
            5698.00,
            1956.00,
            2,
            2103.89,
            null
        ),
        new EmprestimoEmpregadoDataPoint(
            Empregado.SEXO_FEMININO, 
            new GregorianCalendar(1980, GregorianCalendar.FEBRUARY, 20).getTime(),
            1263.00,
            300.00,
            14,
            570.13,
            null
        ),
        new EmprestimoEmpregadoDataPoint(
            Empregado.SEXO_MASCULINO, 
            new GregorianCalendar(1980, GregorianCalendar.FEBRUARY, 20).getTime(),
            1263.00,
            300.00,
            0,
            570.13,
            NumeroDePrestacoesMenorQueOPermitidoException.class
        ),
        new EmprestimoEmpregadoDataPoint(
            Empregado.SEXO_MASCULINO, 
            new GregorianCalendar(1980, GregorianCalendar.FEBRUARY, 20).getTime(),
            1263.00,
            300.00,
            -1,
            570.13,
            NumeroDePrestacoesMenorQueOPermitidoException.class
        ),
        new EmprestimoEmpregadoDataPoint(
            Empregado.SEXO_MASCULINO, 
            new GregorianCalendar(1980, GregorianCalendar.FEBRUARY, 20).getTime(),
            1263.00,
            300.00,
            90000000,
            570.13,
            NumeroDePrestacoesMaiorQueOPermitidoException.class
        ),
        new EmprestimoEmpregadoDataPoint(
            Empregado.SEXO_MASCULINO, 
            new GregorianCalendar(1980, GregorianCalendar.FEBRUARY, 20).getTime(),
            1263.00,
            300.00,
            19,
            570.13,
            NumeroDePrestacoesMaiorQueOPermitidoException.class
        ),
        new EmprestimoEmpregadoDataPoint(
            Empregado.SEXO_MASCULINO, 
            new GregorianCalendar(2012, GregorianCalendar.FEBRUARY, 20).getTime(),
            1263.00,
            300.00,
            10,
            570.13,
            IdadeMenorQueAPermitidaParaEmprestimoException.class
        ),
        new EmprestimoEmpregadoDataPoint(
            Empregado.SEXO_MASCULINO, 
            new GregorianCalendar(2011, GregorianCalendar.FEBRUARY, 20).getTime(),
            1263.00,
            300.00,
            10,
            570.13,
            IdadeMenorQueAPermitidaParaEmprestimoException.class
        ),
        new EmprestimoEmpregadoDataPoint(
            Empregado.SEXO_MASCULINO, 
            new GregorianCalendar(1910, GregorianCalendar.FEBRUARY, 20).getTime(),
            1263.00,
            300.00,
            10,
            570.13,
            IdadeMaiorQueAPermitidaParaEmprestimoException.class
        ),
        new EmprestimoEmpregadoDataPoint(
            Empregado.SEXO_MASCULINO, 
            new GregorianCalendar(1930, GregorianCalendar.FEBRUARY, 20).getTime(),
            1263.00,
            300.00,
            10,
            570.13,
            IdadeMaiorQueAPermitidaParaEmprestimoException.class
        ),
        new EmprestimoEmpregadoDataPoint(
            Empregado.SEXO_FEMININO, 
            new GregorianCalendar(1980, GregorianCalendar.FEBRUARY, 20).getTime(),
            1263.00,
            300000.00,
            14,
            570.13,
            ValorSolicitadoMaiorQueOPermitidoException.class
        )
    };
    
    @Before
    public void setUp() throws Exception{
        RegraEmprestimoDAO regraEmprestimoDAO = mock(RegraEmprestimoDAO.class);
        when(regraEmprestimoDAO.procurar(eq(Empregado.SEXO_MASCULINO), eq(21), eq(15000.00))).thenReturn(new RegraEmprestimo(Empregado.SEXO_MASCULINO, 21, 35, 5000.01, Empregado.SALARIO_MAXIMO, 0.7));
        when(regraEmprestimoDAO.procurar(eq(Empregado.SEXO_MASCULINO), eq(36), eq(3650.00))).thenReturn(new RegraEmprestimo(Empregado.SEXO_MASCULINO, 36, 45, Empregado.SALARIO_MINIMO, 6000.00, 0.45));
        when(regraEmprestimoDAO.procurar(eq(Empregado.SEXO_MASCULINO), eq(47), eq(5698.00))).thenReturn(new RegraEmprestimo(Empregado.SEXO_MASCULINO, 46, 65, Empregado.SALARIO_MINIMO, Empregado.SALARIO_MAXIMO, 0.35));
        when(regraEmprestimoDAO.procurar(eq(Empregado.SEXO_FEMININO), eq(33), eq(1263.00))).thenReturn(new RegraEmprestimo(Empregado.SEXO_FEMININO, 31, 44, Empregado.SALARIO_MINIMO, Empregado.SALARIO_MAXIMO, 0.55));
        when(regraEmprestimoDAO.obterIdadeMinima(anyString())).thenReturn(21);
        when(regraEmprestimoDAO.obterIdadeMaxima(eq(Empregado.SEXO_MASCULINO))).thenReturn(65);
        when(regraEmprestimoDAO.obterIdadeMaxima(eq(Empregado.SEXO_FEMININO))).thenReturn(61);
        
        RegraTaxaDeJurosDAO regraTaxaDeJurosDAO = mock(RegraTaxaDeJurosDAO.class);
        when(regraTaxaDeJurosDAO.procurar(eq(10))).thenReturn(new RegraTaxaDeJuros(10, 12, 0.08));
        when(regraTaxaDeJurosDAO.procurar(eq(5))).thenReturn(new RegraTaxaDeJuros(4, 9, 0.065));
        when(regraTaxaDeJurosDAO.procurar(eq(2))).thenReturn(new RegraTaxaDeJuros(1, 3, 0.05));
        when(regraTaxaDeJurosDAO.procurar(eq(14))).thenReturn(new RegraTaxaDeJuros(13, 18, 0.1));
        when(regraTaxaDeJurosDAO.obterNumeroMinimoPrestacoes()).thenReturn(1);
        when(regraTaxaDeJurosDAO.obterNumeroMaximoPrestacoes()).thenReturn(18);
        
        emprestimoService = new EmprestimoService(regraTaxaDeJurosDAO, regraEmprestimoDAO);
    }
    
    @Theory
    public void testCalcularEmprestimoComMock(EmprestimoEmpregadoDataPoint cenario) throws Exception {
        Assume.assumeTrue(Arrays.asList(emprestimos).contains(cenario));
        
        try{
            Empregado empregado = cenario.getEmpregado();
            Emprestimo emprestimo = emprestimoService.calcularEmprestimo(empregado, cenario.valor, cenario.numeroPrestacoes);
            assertEquals(cenario.numeroPrestacoes, emprestimo.getNumeroPrestacoes());
            assertEquals(cenario.valorTotalEmprestimo/cenario.numeroPrestacoes, emprestimo.getValorPrestacao(1), TPPMConfig.DELTA_COMPARACAO_DOUBLE);
            assertEquals(cenario.valorTotalEmprestimo, emprestimo.getValorTotalPagar(), TPPMConfig.DELTA_COMPARACAO_DOUBLE);
        } catch(Exception e){
            if(e.getClass() != cenario.exceptionEsperada){
                System.out.println("Erro Inesperado: " + e.getMessage() + " Esperava: " + cenario.exceptionEsperada);
                fail(e.getMessage());
            }
        }
    }
}
