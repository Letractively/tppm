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
import tppm.exceptions.EmpregadoDAOException;

/**
 *
 * @author Drope
 */
public class EmpregadoDAOTest {
    
    final String CPF_VALIDO = "12862377775";
    final String NOME_VALIDO = "Tiago Neves";
    final String NOME_VALIDO_ALTERNATIVO = "Tiago de Araujo Neves";
    final String SEXO_VALIDO = "Masculino";
    final Date DATA_NASCIMENTO_VALIDA = new GregorianCalendar(1992, GregorianCalendar.APRIL, 14).getTime();
    final Date DATA_ADMISSAO_VALIDA = new GregorianCalendar(2011, GregorianCalendar.APRIL, 14).getTime();
    final Double SALARIO_VALIDO = 14235.00;
    final Date DATA_DESLIGAMENTO_VALIDA = new GregorianCalendar(2012, GregorianCalendar.APRIL, 14).getTime();
    
    EmpregadoDAOXML empregadoDAOXML;
    
    public EmpregadoDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        Empregado empregado = new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA); 
        empregadoDAOXML = new EmpregadoDAOXML();
        try{
            empregadoDAOXML.incluir(empregado);
        } catch(EmpregadoDAOException e){
            System.out.println("Erro ao incluir "+e.getMessage());
        } 
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testProcurarEmpregadoExistente() throws Exception {
        empregadoDAOXML = new EmpregadoDAOXML();
        Empregado empregadoEncontrado = new Empregado();
        Empregado empregadoExperado = new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA); 
        empregadoEncontrado = empregadoDAOXML.procurar(CPF_VALIDO);

        assertEquals(empregadoExperado, empregadoEncontrado);
        
    }

    @Test
    public void testIncluir() throws Exception {
        Empregado empregado = new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA); 
        empregadoDAOXML = new EmpregadoDAOXML();
               
        empregadoDAOXML.incluir(empregado);
    }

    @Test
    public void testExcluir() throws Exception {
        empregadoDAOXML = new EmpregadoDAOXML();
        Empregado empregado = new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA); 
       
        empregadoDAOXML.excluir(empregado);
    }

    @Test
    public void testAlterar() throws Exception {
        empregadoDAOXML = new EmpregadoDAOXML();
        Empregado empregado = new Empregado(CPF_VALIDO, NOME_VALIDO_ALTERNATIVO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA);

        empregadoDAOXML.alterar(empregado);       
       
    }
}
