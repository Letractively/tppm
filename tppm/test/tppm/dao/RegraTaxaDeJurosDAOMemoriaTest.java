/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.dao;

import tppm.domains.dao.RegraTaxaDeJurosDAOMemoria;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tppm.config.InicializadorDeDAOsMemoria;
import tppm.config.TPPMConfig;
import tppm.domains.RegraTaxaDeJuros;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class RegraTaxaDeJurosDAOMemoriaTest {
    
    static final int NUMERO_PRESTACOES_TESTE_PROCURAR = 2;
    static final Double TAXA_TESTE_PROCURAR = 0.05;

    static final int NUMERO_MINIMO_PRESTACOES = 1;
    static final int NUMERO_MAXIMO_PRESTACOES = 18;
    
    static final int NUMERO_MINIMO_PRESTACOES_TESTE_INSERIR = 19;
    static final int NUMERO_MAXIMO_PRESTACOES_TESTE_INSERIR = 25;
    static final Double TAXA_TESTE_INSERIR = 0.15;
    static final int NUMERO_PRESTACOES_TESTE_INSERIR = 22;
    
    static final int NUMERO_PRESTACOES_TESTE_EXCLUIR = 5;
    
    static final int NUMERO_PRESTACOES_TESTE_ALTERAR = 11;
    static final Double TAXA_TESTE_ALTERAR = 0.9;
    
    static RegraTaxaDeJurosDAOMemoria regraTaxaDeJurosDAOMemoria;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        regraTaxaDeJurosDAOMemoria = new RegraTaxaDeJurosDAOMemoria();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        regraTaxaDeJurosDAOMemoria.excluirTudo();
    }
    
    @Before
    public void setUp() throws Exception {
        for(RegraTaxaDeJuros regra : InicializadorDeDAOsMemoria.regrasTaxaDeJuros){
            regraTaxaDeJurosDAOMemoria.incluir(regra);
        }
    }
    
    @After
    public void tearDown() throws Exception  {
        regraTaxaDeJurosDAOMemoria.excluirTudo();
    }

    @Test
    public void testProcurar() throws Exception {
        RegraTaxaDeJuros resultado = regraTaxaDeJurosDAOMemoria.procurar(NUMERO_PRESTACOES_TESTE_PROCURAR);
        assertEquals(TAXA_TESTE_PROCURAR, resultado.getTaxaDeJuros(), TPPMConfig.DELTA_COMPARACAO_DOUBLE);
    }

    @Test
    public void testObterNumeroMinimoPrestacoes() throws Exception {
        int resultado = regraTaxaDeJurosDAOMemoria.obterNumeroMinimoPrestacoes();
        assertEquals(NUMERO_MINIMO_PRESTACOES, resultado);
    }

    @Test
    public void testObterNumeroMaximoPrestacoes() throws Exception {
        int resultado = regraTaxaDeJurosDAOMemoria.obterNumeroMaximoPrestacoes();
        assertEquals(NUMERO_MAXIMO_PRESTACOES, resultado);
    }

    @Test
    public void testIncluir() throws Exception {
        RegraTaxaDeJuros novaRegra = new RegraTaxaDeJuros(NUMERO_MINIMO_PRESTACOES_TESTE_INSERIR, NUMERO_MAXIMO_PRESTACOES_TESTE_INSERIR, TAXA_TESTE_INSERIR);
        regraTaxaDeJurosDAOMemoria.incluir(novaRegra);
        RegraTaxaDeJuros regraRetornada = regraTaxaDeJurosDAOMemoria.procurar(NUMERO_PRESTACOES_TESTE_INSERIR);
        assertEquals(novaRegra, regraRetornada);
    }

    @Test
    public void testExcluir() throws Exception {
        RegraTaxaDeJuros regra = regraTaxaDeJurosDAOMemoria.procurar(NUMERO_PRESTACOES_TESTE_EXCLUIR);
        regraTaxaDeJurosDAOMemoria.excluir(regra);
        RegraTaxaDeJuros regraAposExcluir = regraTaxaDeJurosDAOMemoria.procurar(NUMERO_PRESTACOES_TESTE_EXCLUIR);
        assertNull(regraAposExcluir);
    }

    @Test
    public void testAlterar() throws Exception {
        RegraTaxaDeJuros regra = regraTaxaDeJurosDAOMemoria.procurar(NUMERO_PRESTACOES_TESTE_ALTERAR);
        regra.setTaxaDeJuros(TAXA_TESTE_ALTERAR);
        regraTaxaDeJurosDAOMemoria.alterar(regra);
        RegraTaxaDeJuros regraAposAlterar = regraTaxaDeJurosDAOMemoria.procurar(NUMERO_PRESTACOES_TESTE_ALTERAR);
        assertEquals(TAXA_TESTE_ALTERAR, regraAposAlterar.getTaxaDeJuros());
    }
}
