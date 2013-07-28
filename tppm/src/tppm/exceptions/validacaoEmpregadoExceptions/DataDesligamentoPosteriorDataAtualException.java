/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmpregadoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class DataDesligamentoPosteriorDataAtualException extends ValidacaoEmpregadoException {

    /**
     * Creates a new instance of <code>DataDesligamentoPosteriorDataAtualException</code> without detail message.
     */
    public DataDesligamentoPosteriorDataAtualException() {
    }

    /**
     * Constructs an instance of <code>DataDesligamentoPosteriorDataAtualException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public DataDesligamentoPosteriorDataAtualException(String msg) {
        super(msg);
    }
}
