/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.services;

import java.util.Date;
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
    
    static final String CPF_VALIDO = "12862377775";
    static final String NOME_VALIDO = "Tiago Neves";
    static final String SEXO_VALIDO = "Masculino";
    static final Date DATA_NASCIMENTO_VALIDA = new Date(1992 - 1900, 3, 14);
    static final Date DATA_ADMISSAO_VALIDA = new Date(2011 - 1900, 2, 25);
    static final Double SALARIO_VALIDO = 14.235;
    static final Date DATA_DESLIGAMENTO_VALIDA = new Date(2012 - 1900, 10, 15);
    
    static final String CPF_INVALIDO = "654";
    static final String NOME_INVALIDO = "carlos alberto de nobrega faria de souza lima faria moutinho cabral álvares soares lima faria moutinho cabral álvares soares lima faria moutinho cabral álvares soares";
    static final String SEXO_INVALIDO = "Homosexual";
    
    public EmpregadoServiceTest() {
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
            if(!e.getMessage().equals("O nome inserido possui mais de 100 caracteres!")){
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
    
    //TODO: implementar restante dos testes conforme cada validação
}
