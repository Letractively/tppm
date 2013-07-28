/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmpregadoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class DataAdmissaoAnteriorDataNascimentoException extends ValidacaoEmpregadoException {

    /**
     * Creates a new instance of <code>DataAdmissaoAnteriorDataNascimentoException</code> without detail message.
     */
    public DataAdmissaoAnteriorDataNascimentoException() {
    }

    /**
     * Constructs an instance of <code>DataAdmissaoAnteriorDataNascimentoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public DataAdmissaoAnteriorDataNascimentoException(String msg) {
        super(msg);
    }
}
