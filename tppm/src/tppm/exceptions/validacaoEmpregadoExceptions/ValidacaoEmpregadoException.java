/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmpregadoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class ValidacaoEmpregadoException extends RuntimeException {

    /**
     * Creates a new instance of <code>ValidacaoEmpregadoException</code> without detail message.
     */
    public ValidacaoEmpregadoException() {
    }

    /**
     * Constructs an instance of <code>ValidacaoEmpregadoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ValidacaoEmpregadoException(String msg) {
        super(msg);
    }
}
