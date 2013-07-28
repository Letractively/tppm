/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmpregadoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class DataAdmissaoPosteriorDataAtualException extends ValidacaoEmpregadoException {

    /**
     * Creates a new instance of <code>DataAdmissaoPosteriorDataAtualException</code> without detail message.
     */
    public DataAdmissaoPosteriorDataAtualException() {
    }

    /**
     * Constructs an instance of <code>DataAdmissaoPosteriorDataAtualException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public DataAdmissaoPosteriorDataAtualException(String msg) {
        super(msg);
    }
}
