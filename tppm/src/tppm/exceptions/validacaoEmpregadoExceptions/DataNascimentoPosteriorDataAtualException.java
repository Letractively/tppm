/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmpregadoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class DataNascimentoPosteriorDataAtualException extends ValidacaoEmpregadoException {

    /**
     * Creates a new instance of <code>DataNascimentoPosteriorDataAtualException</code> without detail message.
     */
    public DataNascimentoPosteriorDataAtualException() {
    }

    /**
     * Constructs an instance of <code>DataNascimentoPosteriorDataAtualException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public DataNascimentoPosteriorDataAtualException(String msg) {
        super(msg);
    }
}
