/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.utils;

import java.util.Arrays;
import org.junit.Assume;
import org.junit.Rule;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import tppm.exceptions.validacaoEmpregadoExceptions.CPFInvalidoException;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
@RunWith(Theories.class)
public class UtilsValidacaoTest {
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    public UtilsValidacaoTest() {
        
    }
    
    @DataPoints
    public static String[] cpfsValidos = {
        "04316299433",
        "76312667278",
        "77562527806",
        "43754230565"
    };
    
    @DataPoints
    public static String[] cpfsInvalidos = {
        "1684654",
        "04316299533",
        "04316569433",
        "1646543423254",
        "0",
        "",
        null
    };
    
    @Theory
    public void testValidaNumeroCPFValido(String cenario) {
        Assume.assumeTrue(Arrays.asList(cpfsValidos).contains(cenario));
        UtilsValidacao.validaNumeroCPF(cenario);
    }
    
    @Theory
    public void testValidaNumeroCPFInvalido(String cenario) {
        Assume.assumeTrue(Arrays.asList(cpfsInvalidos).contains(cenario));
        thrown.expect(CPFInvalidoException.class);
        UtilsValidacao.validaNumeroCPF(cenario);
    }
}
