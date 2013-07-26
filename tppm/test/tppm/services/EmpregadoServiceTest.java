/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.services;

import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tppm.dao.EmpregadoDAO;
import static org.junit.Assert.*;
import tppm.domains.Empregado;
import tppm.exceptions.ValidacaoException;
import static org.mockito.Mockito.*;

/**
 *
 * @author Tiago
 */
public class EmpregadoServiceTest {
    
    final String CPF_VALIDO = "12862377775";
    final String NOME_VALIDO = "Tiago Neves";
    final String SEXO_VALIDO = "Masculino";
    final Date DATA_NASCIMENTO_VALIDA = new GregorianCalendar(1992, GregorianCalendar.APRIL, 14).getTime();
    final Date DATA_ADMISSAO_VALIDA = new GregorianCalendar(2011, GregorianCalendar.APRIL, 14).getTime();
    final Double SALARIO_VALIDO = 14235.00;
    final Date DATA_DESLIGAMENTO_VALIDA = new GregorianCalendar(2012, GregorianCalendar.APRIL, 14).getTime();
    
    final String CPF_INVALIDO = "654";
    final String NOME_INVALIDO = "carlos alberto de nobrega faria de souza lima faria moutinho cabral álvares soares lima faria moutinho cabral álvares soares lima faria moutinho cabral álvares soares";
    final String SEXO_INVALIDO = "Homosexual";
    final Date DATA_NASCIMENTO_INVALIDA;
    final Date DATA_ADMISSAO_INVALIDA;
    final Date DATA_ADMISSAO_ANTERIOR_A_DATA_NASCIMENTO;
    final Double SALARIO_INVALIDO = 100.00;
    final Date DATA_NASCIMENTO_INFERIOR_IDADE_MINIMA;
    final Date DATA_DESLIGAMENTO_INVALIDA;
    final Date DATA_DESLIGAMENTO_ANTERIOR_ADMISSAO;
    
    public EmpregadoServiceTest() {
        
        GregorianCalendar amanha = new GregorianCalendar();
        amanha.add(GregorianCalendar.YEAR, 1);
        DATA_NASCIMENTO_INVALIDA = amanha.getTime();
        DATA_ADMISSAO_INVALIDA = amanha.getTime();
        DATA_DESLIGAMENTO_INVALIDA = amanha.getTime();
        
        GregorianCalendar dataAdmissaoAnterioraDataNascimento = new GregorianCalendar();
        dataAdmissaoAnterioraDataNascimento.setTime(DATA_NASCIMENTO_VALIDA);
        dataAdmissaoAnterioraDataNascimento.add(GregorianCalendar.YEAR, -1);
        DATA_ADMISSAO_ANTERIOR_A_DATA_NASCIMENTO = dataAdmissaoAnterioraDataNascimento.getTime();
        
        GregorianCalendar dataNascimentoInferiorIdadeMinima = new GregorianCalendar();
        dataNascimentoInferiorIdadeMinima.setTime(DATA_ADMISSAO_VALIDA);
        dataNascimentoInferiorIdadeMinima.add(GregorianCalendar.YEAR, -(Empregado.IDADE_MINIMA)+1);
        DATA_NASCIMENTO_INFERIOR_IDADE_MINIMA = dataNascimentoInferiorIdadeMinima.getTime();
        
        GregorianCalendar dataDesligamentoAnteriorAdmissao = new GregorianCalendar();
        dataDesligamentoAnteriorAdmissao.setTime(DATA_ADMISSAO_VALIDA);
        dataDesligamentoAnteriorAdmissao.add(GregorianCalendar.YEAR, -1);
        DATA_DESLIGAMENTO_ANTERIOR_ADMISSAO = dataDesligamentoAnteriorAdmissao.getTime();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testIncluirEmpregado() throws Exception {
        Empregado empregado = new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA);
        
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        when(empregadoDAO.procurar(anyString())).thenReturn(null);
        
        EmpregadoService empregadoService = new EmpregadoService(empregadoDAO);
        Empregado expResult = empregadoService.incluirEmpregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA);
        
        assertEquals(expResult, empregado);
    }
    
    @Test
    public void testIncluirEmpregadoJaCadastrado() throws Exception {
        Empregado empregado = mock(Empregado.class);
        when(empregado.getCpf()).thenReturn(CPF_VALIDO);
        
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        when(empregadoDAO.procurar(anyString())).thenReturn(empregado);
        
        EmpregadoService empregadoService = new EmpregadoService(empregadoDAO);
        
        try{
            empregadoService.incluirEmpregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA);
            fail();
        } catch(ValidacaoException e){
            if(!e.getMessage().equals("O CPF inserido já está cadastrado no sistema!")){
                fail(e.getMessage());
            }
        }
    }
    
    @Test
    public void testIncluirEmpregadoCPFInvalido() throws Exception {
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        EmpregadoService empregadoService = new EmpregadoService(empregadoDAO);
        try{
            empregadoService.incluirEmpregado(CPF_INVALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA);
            fail();
        } catch(ValidacaoException e){
            if(!e.getMessage().equals("O CPF inserido não é válido!")){
                fail(e.getMessage());
            }
        }
    }
    
    @Test
    public void testIncluirEmpregadoCPFVazio() throws Exception {
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        EmpregadoService empregadoService = new EmpregadoService(empregadoDAO);
        try{
            empregadoService.incluirEmpregado("", NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA);
            fail();
        } catch(ValidacaoException e){
            if(!e.getMessage().equals("O campo 'CPF' não pode ser vazio!")){
                fail(e.getMessage());
            }
        }
    }
    
    @Test
    public void testIncluirEmpregadoNomeVazio() throws Exception {
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        EmpregadoService empregadoService = new EmpregadoService(empregadoDAO);
        try{
            empregadoService.incluirEmpregado(CPF_VALIDO, "", SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA);
            fail();
        } catch(ValidacaoException e){
            if(!e.getMessage().equals("O campo 'NOME' não pode ser vazio!")){
                fail(e.getMessage());
            }
        }
    }
    
    @Test
    public void testIncluirEmpregadoNomeMuitoGrande() throws Exception {
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        EmpregadoService empregadoService = new EmpregadoService(empregadoDAO);
        try{
            empregadoService.incluirEmpregado(CPF_VALIDO, NOME_INVALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA);
            fail();
        } catch(ValidacaoException e){
            if(!e.getMessage().equals("O nome inserido possui mais de "+Empregado.TAMANHO_MAXIMO_NOME+" caracteres!")){
                fail(e.getMessage());
            }
        }
    }
    
    @Test
    public void testIncluirEmpregadoSexoVazio() throws Exception {
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        EmpregadoService empregadoService = new EmpregadoService(empregadoDAO);
        try{
            empregadoService.incluirEmpregado(CPF_VALIDO, NOME_VALIDO, "", DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA);
            fail();
        } catch(ValidacaoException e){
            if(!e.getMessage().equals("O campo 'SEXO' não pode ser vazio!")){
                fail(e.getMessage());
            }
        }
    }
    
    @Test
    public void testIncluirEmpregadoSexoInvalido() throws Exception {
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        EmpregadoService empregadoService = new EmpregadoService(empregadoDAO);
        try{
            empregadoService.incluirEmpregado(CPF_VALIDO, NOME_VALIDO, SEXO_INVALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA);
            fail();
        } catch(ValidacaoException e){
            if(!e.getMessage().equals("O sexo inserido é inválido!")){
                fail(e.getMessage());
            }
        }
    }
    
    @Test
    public void testIncluirEmpregadoDataNascimentoNula() throws Exception {
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        EmpregadoService empregadoService = new EmpregadoService(empregadoDAO);
        try{
            empregadoService.incluirEmpregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, null, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA);
            fail();
        } catch(ValidacaoException e){
            if(!e.getMessage().equals("O campo 'DATA DE NASCIMENTO' é obrigatório!")){
                fail(e.getMessage());
            }
        }
    }
    
    @Test
    public void testIncluirEmpregadoDataNascimentoInvalida() throws Exception {
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        EmpregadoService empregadoService = new EmpregadoService(empregadoDAO);
        try{
            empregadoService.incluirEmpregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_INVALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA);
            fail();
        } catch(ValidacaoException e){
            if(!e.getMessage().equals("A data 'DATA DE NASCIMENTO' deve ser anterior a data de hoje!")){
                fail(e.getMessage());
            }
        }
    }
    
    @Test
    public void testIncluirEmpregadoIdadeInvalida() throws Exception {
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        EmpregadoService empregadoService = new EmpregadoService(empregadoDAO);
        try{
            empregadoService.incluirEmpregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_INFERIOR_IDADE_MINIMA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA);
            fail();
        } catch(ValidacaoException e){
            if(!e.getMessage().equals("A idade do empregado é menor que a idade mínima permitida para contratação!")){
                fail(e.getMessage());
            }
        }
    }
    
    @Test
    public void testIncluirEmpregadoDataAdmissaoNula() throws Exception {
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        EmpregadoService empregadoService = new EmpregadoService(empregadoDAO);
        try{
            empregadoService.incluirEmpregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, null, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA);
            fail();
        } catch(ValidacaoException e){
            if(!e.getMessage().equals("O campo 'DATA DE ADMISSÃO' é obrigatório!")){
                fail(e.getMessage());
            }
        }
    }
    
    @Test
    public void testIncluirEmpregadoDataAdmissaoInvalida() throws Exception {
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        EmpregadoService empregadoService = new EmpregadoService(empregadoDAO);
        try{
            empregadoService.incluirEmpregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_INVALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA);
            fail();
        } catch(ValidacaoException e){
            if(!e.getMessage().equals("A data 'DATA DE ADMISSÃO' deve ser anterior a data de hoje!")){
                fail(e.getMessage());
            }
        }
    }
    
    @Test
    public void testIncluirEmpregadoDataAdmissaoAnteriorDataNascimento() throws Exception {
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        EmpregadoService empregadoService = new EmpregadoService(empregadoDAO);
        try{
            empregadoService.incluirEmpregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_ANTERIOR_A_DATA_NASCIMENTO, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA);
            fail();
        } catch(ValidacaoException e){
            if(!e.getMessage().equals("A DATA DE ADMISSÃO deve ser posterior a data de nascimento!")){
                fail(e.getMessage());
            }
        }
    }
    
    @Test
    public void testIncluirEmpregadoSalarioNull() throws Exception {
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        EmpregadoService empregadoService = new EmpregadoService(empregadoDAO);
        try{
            empregadoService.incluirEmpregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, null, DATA_DESLIGAMENTO_VALIDA);
            fail();
        } catch(ValidacaoException e){
            if(!e.getMessage().equals("O campo 'SALÁRIO ATUAL' é obrigatório!")){
                fail(e.getMessage());
            }
        }
    }
    
    @Test
    public void testIncluirEmpregadoSalarioInvalido() throws Exception {
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        EmpregadoService empregadoService = new EmpregadoService(empregadoDAO);
        try{
            empregadoService.incluirEmpregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_INVALIDO, DATA_DESLIGAMENTO_VALIDA);
            fail();
        } catch(ValidacaoException e){
            if(!e.getMessage().equals("O campo 'SALÁRIO ATUAL' deve ser >= "+Empregado.SALARIO_MINIMO+" e <= "+Empregado.SALARIO_MAXIMO+"!")){
                fail(e.getMessage());
            }
        }
    }
    
    @Test
    public void testIncluirEmpregadoDataDesligamentoNula() throws Exception {
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        EmpregadoService empregadoService = new EmpregadoService(empregadoDAO);
        try{
            empregadoService.incluirEmpregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, null);
            fail();
        } catch(ValidacaoException e){
            if(!e.getMessage().equals("O campo 'DATA DE DESLIGAMENTO' é obrigatório!")){
                fail(e.getMessage());
            }
        }
    }
    
    @Test
    public void testIncluirEmpregadoDataDesligamentoInvalida() throws Exception {
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        EmpregadoService empregadoService = new EmpregadoService(empregadoDAO);
        try{
            empregadoService.incluirEmpregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_INVALIDA);
            fail();
        } catch(ValidacaoException e){
            if(!e.getMessage().equals("A data 'DATA DE DESLIGAMENTO' deve ser anterior a data de hoje!")){
                fail(e.getMessage());
            }
        }
    }
    
    @Test
    public void testIncluirEmpregadoDataDesligamentoAnteriorDataAdmissao() throws Exception {
        EmpregadoDAO empregadoDAO = mock(EmpregadoDAO.class);
        EmpregadoService empregadoService = new EmpregadoService(empregadoDAO);
        try{
            empregadoService.incluirEmpregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_ANTERIOR_ADMISSAO);
            fail();
        } catch(ValidacaoException e){
            if(!e.getMessage().equals("A DATA DE DESLIGAMENTO deve ser posterior a data de admissão!")){
                fail(e.getMessage());
            }
        }
    }
}
