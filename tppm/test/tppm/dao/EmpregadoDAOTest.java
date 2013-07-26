/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.dao;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import static org.junit.Assert.*;
import tppm.domains.Empregado;
import tppm.exceptions.EmpregadoDAOException;
import tppm.services.EmpregadoService;
import static org.mockito.Mockito.*;

/**
 *
 * @author Drope
 */
public class EmpregadoDAOTest {
    
    static final String CPF_VALIDO = "12862377775";
    static final String NOME_VALIDO = "Tiago Neves";
    static final String NOME_VALIDO_ALTERNATIVO = "Tiago de Araujo Neves";
    static final String SEXO_VALIDO = "Masculino";
    static final Date DATA_NASCIMENTO_VALIDA = new Date(1992 - 1900, 3, 14);
    static final Date DATA_ADMISSAO_VALIDA = new Date(2011 - 1900, 2, 25);
    static final Double SALARIO_VALIDO = 14.235;
    static final Date DATA_DESLIGAMENTO_VALIDA = new Date(2012 - 1900, 10, 15);
    
    
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
      EmpregadoDAOXML empregadoDAOXML = new EmpregadoDAOXML();
      
      try{
            empregadoDAOXML.incluir(empregado);
            
        } catch(EmpregadoDAOException e){
            System.out.println("Erro ao incluir"+e.getMessage());
        } 

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of procurar method, of class EmpregadoDAO.
     */
    @Test
    public void testProcurarEmpregadoExistente() throws Exception {
        EmpregadoDAOXML empregadoDAOXML = new EmpregadoDAOXML();
        Empregado empregadoEncontrado = new Empregado();
        Empregado empregadoExperado = new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA); 
        empregadoEncontrado = empregadoDAOXML.procurar(CPF_VALIDO);
        
        assertEquals(empregadoExperado, empregadoEncontrado);
        
    }

    /**
     * Test of incluir method, of class EmpregadoDAO.
     */
    @Test
    public void testIncluir() throws Exception {
      Empregado empregado = new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA); 
      EmpregadoDAOXML empregadoDAOXML = new EmpregadoDAOXML();
      
      try{
            empregadoDAOXML.incluir(empregado);
            
        } catch(EmpregadoDAOException e){
            System.out.println("Erro ao incluir "+e.getMessage());
        } 

    }

    /**
     * Test of excluir method, of class EmpregadoDAO.
     */
    @Test
    public void testExcluir() throws Exception {
        
       EmpregadoDAOXML empregadoDAOXML = new EmpregadoDAOXML();
       Empregado empregado = new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA); 
        
       try{
            empregadoDAOXML.excluir(empregado);
            
        } catch(EmpregadoDAOException e){
            System.out.println("Erro ao excluir "+e.getMessage());
        } 
    }

    /**
     * Test of alterar method, of class EmpregadoDAO.
     */
    @Test
    public void testAlterar() throws Exception {
       EmpregadoDAOXML empregadoDAOXML = new EmpregadoDAOXML();
       Empregado empregado = new Empregado(CPF_VALIDO, NOME_VALIDO_ALTERNATIVO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA);
       
       try{
            empregadoDAOXML.alterar(empregado);
            
        } catch(EmpregadoDAOException e){
            System.out.println("Erro ao alterar "+e.getMessage());
        } 
       
    }

    public class EmpregadoDAOImpl implements EmpregadoDAO {

        public Empregado procurar(String cpf) throws EmpregadoDAOException {
            return null;
        }

        public void incluir(Empregado empregado) throws EmpregadoDAOException {
        }

        public void excluir(Empregado empregado) throws EmpregadoDAOException {
        }

        public void alterar(Empregado empregado) throws EmpregadoDAOException {
        }
    }
}
