/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmprestimoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class ValidacaoEmprestimoException extends RuntimeException {

    /**
     * Creates a new instance of <code>ValidacaoEmprestimoException</code> without detail message.
     */
    public ValidacaoEmprestimoException() {
    }

    /**
     * Constructs an instance of <code>ValidacaoEmprestimoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public ValidacaoEmprestimoException(String msg) {
        super(msg);
    }
}
