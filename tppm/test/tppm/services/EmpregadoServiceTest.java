/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.services;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Assume;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import tppm.domains.dao.EmpregadoDAO;
import tppm.datapoints.EmpregadoDataPoint;
import static org.junit.Assert.*;
import tppm.domains.Empregado;
import tppm.exceptions.validacaoEmpregadoExceptions.CPFInvalidoException;
import tppm.exceptions.validacaoEmpregadoExceptions.CPFJaExisteException;
import tppm.exceptions.validacaoEmpregadoExceptions.CPFVazioException;
import tppm.exceptions.validacaoEmpregadoExceptions.DataAdmissaoAnteriorDataNascimentoException;
import tppm.exceptions.validacaoEmpregadoExceptions.DataAdmissaoNulaException;
import tppm.exceptions.validacaoEmpregadoExceptions.DataAdmissaoPosteriorDataAtualException;
import tppm.exceptions.validacaoEmpregadoExceptions.DataDesligamentoAnteriorDataAdmissaoException;
import tppm.exceptions.validacaoEmpregadoExceptions.DataDesligamentoPosteriorDataAtualException;
import tppm.exceptions.validacaoEmpregadoExceptions.DataNascimentoNulaException;
import tppm.exceptions.validacaoEmpregadoExceptions.DataNascimentoPosteriorDataAtualException;
import tppm.exceptions.validacaoEmpregadoExceptions.IdadeEmpregadoNaoPermitidaNoCadastroException;
import tppm.exceptions.validacaoEmpregadoExceptions.NomeMuitoGrandeException;
import tppm.exceptions.validacaoEmpregadoExceptions.NomeVazioException;
import tppm.exceptions.validacaoEmpregadoExceptions.SalarioInvalidoException;
import tppm.exceptions.validacaoEmpregadoExceptions.SalarioNuloException;
import tppm.exceptions.validacaoEmpregadoExceptions.SexoInvalidoException;
import tppm.exceptions.validacaoEmpregadoExceptions.SexoVazioException;
import tppm.utils.Utils;
import static org.mockito.Mockito.*;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */

@RunWith(Theories.class)
public class EmpregadoServiceTest {
    
    static final String CPF_VALIDO = "12862377775";
    static final String NOME_VALIDO = "Tiago Neves";
    static final String SEXO_VALIDO = "Masculino";
    static final Date DATA_NASCIMENTO_VALIDA = new GregorianCalendar(1992, GregorianCalendar.APRIL, 14).getTime();
    static final Date DATA_ADMISSAO_VALIDA = new GregorianCalendar(2011, GregorianCalendar.APRIL, 14).getTime();
    static final Double SALARIO_VALIDO = 14235.00;
    static final Date DATA_DESLIGAMENTO_VALIDA = new GregorianCalendar(2013, GregorianCalendar.APRIL, 14).getTime();
    
    static final String CPF_INVALIDO = "654";
    static final String NOME_INVALIDO = "carlos alberto de nobrega faria de souza lima faria moutinho cabral álvares soares lima faria moutinho cabral álvares soares lima faria moutinho cabral álvares soares";
    static final String SEXO_INVALIDO = "Homosexual";
    static final Date DATA_NASCIMENTO_INVALIDA = Utils.adicionarDiasNaData(new GregorianCalendar().getTime(), 1);
    static final Date DATA_ADMISSAO_INVALIDA = Utils.adicionarDiasNaData(new GregorianCalendar().getTime(), 1);
    static final Date DATA_ADMISSAO_ANTERIOR_A_DATA_NASCIMENTO = Utils.adicionarAnosNaData(DATA_NASCIMENTO_VALIDA, -1);
    static final Double SALARIO_INVALIDO = 100.00;
    static final Date DATA_NASCIMENTO_INFERIOR_IDADE_MINIMA = Utils.adicionarAnosNaData(DATA_ADMISSAO_VALIDA, -(Empregado.IDADE_MINIMA)+1);
    static final Date DATA_DESLIGAMENTO_INVALIDA = Utils.adicionarDiasNaData(new GregorianCalendar().getTime(), 1);
    static final Date DATA_DESLIGAMENTO_ANTERIOR_ADMISSAO = Utils.adicionarAnosNaData(DATA_ADMISSAO_VALIDA, -1);
    
    @DataPoints
    public static EmpregadoDataPoint[] empregados = {
        new EmpregadoDataPoint(
            new Empregado(CPF_INVALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, null),
            CPFInvalidoException.class
        ),
        new EmpregadoDataPoint(
            new Empregado("", NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, null),
            CPFVazioException.class
        ),
        new EmpregadoDataPoint(
            new Empregado(CPF_VALIDO, "", SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, null),
            NomeVazioException.class
        ),
        new EmpregadoDataPoint(
            new Empregado(CPF_VALIDO, NOME_INVALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, null),
            NomeMuitoGrandeException.class
        ),
        new EmpregadoDataPoint(
            new Empregado(CPF_VALIDO, NOME_VALIDO, "", DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, null),
            SexoVazioException.class
        ),
        new EmpregadoDataPoint(
            new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_INVALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, null),
            SexoInvalidoException.class
        ),
        new EmpregadoDataPoint(
            new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, null, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, null),
            DataNascimentoNulaException.class
        ),
        new EmpregadoDataPoint(
            new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_INVALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, null),
            DataNascimentoPosteriorDataAtualException.class
        ),
        new EmpregadoDataPoint(
            new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_INFERIOR_IDADE_MINIMA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, null),
            IdadeEmpregadoNaoPermitidaNoCadastroException.class
        ),
        new EmpregadoDataPoint(
            new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_ANTERIOR_A_DATA_NASCIMENTO, SALARIO_VALIDO, null),
            DataAdmissaoAnteriorDataNascimentoException.class
        ),
        new EmpregadoDataPoint(
            new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, null, SALARIO_VALIDO, null),
            DataAdmissaoNulaException.class
        ),
        new EmpregadoDataPoint(
            new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_INVALIDA, SALARIO_VALIDO, null),
            DataAdmissaoPosteriorDataAtualException.class
        ),
        new EmpregadoDataPoint(
            new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, null, null),
            SalarioNuloException.class
        ),
        new EmpregadoDataPoint(
            new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_INVALIDO, null),
            SalarioInvalidoException.class
        ),
        new EmpregadoDataPoint(
            new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_INVALIDA),
            DataDesligamentoPosteriorDataAtualException.class
        ),
        new EmpregadoDataPoint(
            new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_ANTERIOR_ADMISSAO),
            DataDesligamentoAnteriorDataAdmissaoException.class
        )
    };
    
    @Test
    public void testIncluirEmpregado() throws Exception {
        Empregado empregado = new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, null);
        
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        when(empregadoDAO.procurar(anyString())).thenReturn(null);
        
        EmpregadoServiceImpl empregadoService = new EmpregadoServiceImpl(empregadoDAO);
        Empregado resultadoEsperado = empregadoService.incluirEmpregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, null);
        
        assertEquals(resultadoEsperado, empregado);
    }
    
    @Test(expected = CPFJaExisteException.class)
    public void testIncluirEmpregadoJaCadastrado() throws Exception {
        Empregado empregado = mock(Empregado.class);
        when(empregado.getCpf()).thenReturn(CPF_VALIDO);
        
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        when(empregadoDAO.procurar(anyString())).thenReturn(empregado);
        
        EmpregadoServiceImpl empregadoService = new EmpregadoServiceImpl(empregadoDAO);
        empregadoService.incluirEmpregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, null);
    }
    
    @Theory
    public void testIncluirEmpregadoComDataPoints(EmpregadoDataPoint cenario) throws Exception {
        Assume.assumeTrue(Arrays.asList(empregados).contains(cenario));
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        EmpregadoServiceImpl empregadoService = new EmpregadoServiceImpl(empregadoDAO);
        try{
            empregadoService.incluirEmpregado(cenario.empregado.getCpf(), cenario.empregado.getNome(), cenario.empregado.getSexo(), cenario.empregado.getDataNascimento(), cenario.empregado.getDataAdmissao(), cenario.empregado.getSalarioAtual(), cenario.empregado.getDataDesligamento());
        }
        catch(Exception e){
            if(cenario.exceptionEsperada != null && e.getClass() != cenario.exceptionEsperada){
                System.out.println("Erro Inesperado: " + e.getMessage() + " Esperava: " + cenario.exceptionEsperada);
                fail(e.getMessage());
            }
        }
    }
}
