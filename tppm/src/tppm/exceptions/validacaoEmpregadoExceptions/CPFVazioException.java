/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmpregadoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class CPFVazioException extends ValidacaoEmpregadoException {

    /**
     * Creates a new instance of <code>CPFVazioException</code> without detail message.
     */
    public CPFVazioException() {
    }

    /**
     * Constructs an instance of <code>CPFVazioException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public CPFVazioException(String msg) {
        super(msg);
    }
}
