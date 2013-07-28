package tppm.dao;

import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tppm.config.TPPMConfig;
import static org.junit.Assert.*;
import tppm.domains.Empregado;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class EmpregadoDAOXMLTest {
    
    static final String CPF_VALIDO = "12862377775";
    static final String CPF_VALIDO2 = "84661136810";
    static final String NOME_VALIDO = "Tiago Neves";
    static final String NOME_VALIDO_ALTERNATIVO = "Tiago de Araujo Neves";
    static final String SEXO_VALIDO = "Masculino";
    static final Date DATA_NASCIMENTO_VALIDA = new GregorianCalendar(1992, GregorianCalendar.APRIL, 14).getTime();
    static final Date DATA_ADMISSAO_VALIDA = new GregorianCalendar(2011, GregorianCalendar.APRIL, 14).getTime();
    static final Double SALARIO_VALIDO = 14235.00;
    static final Date DATA_DESLIGAMENTO_VALIDA = new GregorianCalendar(2012, GregorianCalendar.APRIL, 14).getTime();
    
    static EmpregadoDAOXML empregadoDAOXML;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        empregadoDAOXML = new EmpregadoDAOXML(TPPMConfig.NOME_ARQUIVO_REPOSITORIO_EMPREGADOS_TEST);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        empregadoDAOXML.limparArquivo();
    }
    
    @Before
    public void setUp() throws Exception {
        empregadoDAOXML.incluir(new Empregado(CPF_VALIDO2, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA));
    }
    
    @After
    public void tearDown() throws Exception {
        empregadoDAOXML.limparArquivo();
    }
    
    @Test
    public void testProcurarEmpregadoExistente() throws Exception {
        Empregado empregado = empregadoDAOXML.procurar(CPF_VALIDO2);
        assertNotNull(empregado);
        assertEquals(CPF_VALIDO2, empregado.getCpf());
    }

    @Test
    public void testIncluir() throws Exception {
        Empregado empregado = new Empregado(CPF_VALIDO, NOME_VALIDO, SEXO_VALIDO, DATA_NASCIMENTO_VALIDA, DATA_ADMISSAO_VALIDA, SALARIO_VALIDO, DATA_DESLIGAMENTO_VALIDA); 
        empregadoDAOXML.incluir(empregado);
        Empregado empregadoAchado = empregadoDAOXML.procurar(CPF_VALIDO);
        assertNotNull(empregado);
        assertEquals(empregado, empregadoAchado);
    }

    @Test
    public void testExcluir() throws Exception {
        Empregado empregado = empregadoDAOXML.procurar(CPF_VALIDO2);
        empregadoDAOXML.excluir(empregado);
        Empregado empregadoAchado = empregadoDAOXML.procurar(CPF_VALIDO2);
        assertNull(empregadoAchado);
    }

    @Test
    public void testAlterar() throws Exception {
        Empregado empregado = empregadoDAOXML.procurar(CPF_VALIDO2);
        empregado.setNome(NOME_VALIDO_ALTERNATIVO);
        empregadoDAOXML.alterar(empregado);
        Empregado empregadoAchado = empregadoDAOXML.procurar(CPF_VALIDO2);
        assertNotNull(empregado);
        assertEquals(empregado.getNome(), empregadoAchado.getNome());
    }
}
