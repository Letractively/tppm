/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.dao;

import tppm.domains.dao.RegraEmprestimoDAOMemoria;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tppm.config.InicializadorDeDAOsMemoria;
import tppm.config.TPPMConfig;
import tppm.domains.Empregado;
import static org.junit.Assert.*;
import tppm.domains.RegraEmprestimo;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class RegraEmprestimoDAOMemoriaTest {
    
    public static final String SEXO_TESTE_PROCURAR = Empregado.SEXO_MASCULINO;
    public static final int IDADE_TESTE_PROCURAR = 23;
    public static final Double SALARIO_TESTE_PROCURAR = 6523.23;
    public static final Double PORCENTAGEM_RESPOSTA_TESTE_PROCURAR = 0.7;
    
    public static final int IDADE_MINIMA_HOMEM = 21;
    public static final int IDADE_MAXIMA_MULHER = 61;
    
    public static final String SEXO_TESTE_NOVA_REGRA = Empregado.SEXO_MASCULINO;
    public static final int IDADE_TESTE_NOVA_REGRA = 70;
    public static final Double SALARIO_TESTE_NOVA_REGRA = 18236.23;
    public static final Double PORCENTAGEM_TESTE_NOVA_REGRA = 0.2;
    public static final int IDADE_MAXIMA_TESTE_NOVA_REGRA = 70;
    public static final int IDADE_MINIMA_TESTE_NOVA_REGRA = 70;
    
    public static final Double PORCENTAGEM_TESTE_ALTERAR = 0.9;
    
    static RegraEmprestimoDAOMemoria regraEmprestimoDAOMemoria;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        regraEmprestimoDAOMemoria = new RegraEmprestimoDAOMemoria();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        regraEmprestimoDAOMemoria.excluirTudo();
    }
    
    @Before
    public void setUp() throws Exception {
        for(RegraEmprestimo regra : InicializadorDeDAOsMemoria.regrasEmprestimo){
            regraEmprestimoDAOMemoria.incluir(regra);
        }
    }
    
    @After
    public void tearDown() throws Exception  {
        regraEmprestimoDAOMemoria.excluirTudo();
    }

    @Test
    public void testProcurar() throws Exception {
        RegraEmprestimo resultado = regraEmprestimoDAOMemoria.procurar(SEXO_TESTE_PROCURAR, IDADE_TESTE_PROCURAR, SALARIO_TESTE_PROCURAR);
        assertEquals(PORCENTAGEM_RESPOSTA_TESTE_PROCURAR, resultado.getPorcentagemLimiteSalario(), TPPMConfig.DELTA_COMPARACAO_DOUBLE);
    }

    @Test
    public void testObterIdadeMinima() throws Exception {
        int resultado = regraEmprestimoDAOMemoria.obterIdadeMinima(Empregado.SEXO_MASCULINO);
        assertEquals(IDADE_MINIMA_HOMEM, resultado);
    }

    @Test
    public void testObterIdadeMaxima() throws Exception {
        int resultado = regraEmprestimoDAOMemoria.obterIdadeMaxima(Empregado.SEXO_FEMININO);
        assertEquals(IDADE_MAXIMA_MULHER, resultado);
    }

    @Test
    public void testIncluir() throws Exception {
        RegraEmprestimo novaRegra = new RegraEmprestimo(Empregado.SEXO_MASCULINO, IDADE_MINIMA_TESTE_NOVA_REGRA, IDADE_MAXIMA_TESTE_NOVA_REGRA, Empregado.SALARIO_MINIMO, Empregado.SALARIO_MAXIMO, PORCENTAGEM_TESTE_NOVA_REGRA);
        regraEmprestimoDAOMemoria.incluir(novaRegra);
        RegraEmprestimo regraRetornada = regraEmprestimoDAOMemoria.procurar(Empregado.SEXO_MASCULINO, IDADE_TESTE_NOVA_REGRA, SALARIO_TESTE_NOVA_REGRA);
        assertEquals(novaRegra, regraRetornada);
    }

    @Test
    public void testExcluir() throws Exception {
        RegraEmprestimo regra = regraEmprestimoDAOMemoria.procurar(SEXO_TESTE_PROCURAR, IDADE_TESTE_PROCURAR, SALARIO_TESTE_PROCURAR);
        regraEmprestimoDAOMemoria.excluir(regra);
        RegraEmprestimo regraAposExcluir = regraEmprestimoDAOMemoria.procurar(SEXO_TESTE_PROCURAR, IDADE_TESTE_PROCURAR, SALARIO_TESTE_PROCURAR);
        assertNull(regraAposExcluir);
    }

    @Test
    public void testAlterar() throws Exception {
        RegraEmprestimo regra = regraEmprestimoDAOMemoria.procurar(SEXO_TESTE_PROCURAR, IDADE_TESTE_PROCURAR, SALARIO_TESTE_PROCURAR);
        regra.setPorcentagemLimiteSalario(PORCENTAGEM_TESTE_ALTERAR);
        regraEmprestimoDAOMemoria.alterar(regra);
        RegraEmprestimo regraAposAlterar = regraEmprestimoDAOMemoria.procurar(SEXO_TESTE_PROCURAR, IDADE_TESTE_PROCURAR, SALARIO_TESTE_PROCURAR);
        assertEquals(PORCENTAGEM_TESTE_ALTERAR, regraAposAlterar.getPorcentagemLimiteSalario());
    }
}
