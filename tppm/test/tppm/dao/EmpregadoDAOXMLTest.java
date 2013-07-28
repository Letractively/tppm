package tppm.dao;

import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tppm.domains.Empregado;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class EmpregadoDAOXMLTest {
    
    final String CPF_VALIDO = "12862377775";
    final String CPF_VALIDO2 = "84661136810";
    final String NOME_VALIDO = "Tiago Neves";
    final String NOME_VALIDO_ALTERNATIVO = "Tiago de Araujo Neves";
    final String SEXO_VALIDO = "Masculino";
    final Date DATA_NASCIMENTO_VALIDA = new GregorianCalendar(1992, GregorianCalendar.APRIL, 14).getTime();
    final Date DATA_ADMISSAO_VALIDA = new GregorianCalendar(2011, GregorianCalendar.APRIL, 14).getTime();
    final Double SALARIO_VALIDO = 14235.00;
    final Date DATA_DESLIGAMENTO_VALIDA = new GregorianCalendar(2012, GregorianCalendar.APRIL, 14).getTime();
    
    EmpregadoDAO empregadoDAO;
    
    public EmpregadoDAOXMLTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() throws Exception {
        Empregado empregado = new Empregado(CPF_VALIDO2, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA); 
        empregadoDAO = new EmpregadoDAOXML();
        empregadoDAO.incluir(empregado);
    }
    
    @After
    public void tearDown() {
        
    }

    @Test
    public void testProcurarEmpregadoExistente() throws Exception {
        Empregado empregado = empregadoDAO.procurar(CPF_VALIDO2);
        assertNotNull(empregado);
        assertEquals(CPF_VALIDO2, empregado.getCpf());
    }

    @Test
    public void testIncluir() throws Exception {
        Empregado empregado = new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA); 
        empregadoDAO.incluir(empregado);
        Empregado empregadoAchado = empregadoDAO.procurar(CPF_VALIDO);
        assertNotNull(empregado);
        assertEquals(empregado, empregadoAchado);
    }

    @Test
    public void testExcluir() throws Exception {
        Empregado empregado = empregadoDAO.procurar(CPF_VALIDO2);
        empregadoDAO.excluir(empregado);
        Empregado empregadoAchado = empregadoDAO.procurar(CPF_VALIDO2);
        assertNull(empregadoAchado);
    }

    @Test
    public void testAlterar() throws Exception {
        Empregado empregado = empregadoDAO.procurar(CPF_VALIDO2);
        empregado.setNome(NOME_VALIDO_ALTERNATIVO);
        empregadoDAO.alterar(empregado);
        Empregado empregadoAchado = empregadoDAO.procurar(CPF_VALIDO2);
        assertNotNull(empregado);
        assertEquals(empregado.getNome(), empregadoAchado.getNome());
    }
}
