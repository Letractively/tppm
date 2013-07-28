/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmpregadoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class CPFInvalidoException extends ValidacaoEmpregadoException {

    /**
     * Creates a new instance of <code>CPFInvalidoException</code> without detail message.
     */
    public CPFInvalidoException() {
    }

    /**
     * Constructs an instance of <code>CPFInvalidoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public CPFInvalidoException(String msg) {
        super(msg);
    }
}
