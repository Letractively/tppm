/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmpregadoExceptions;

import tppm.exceptions.validacaoEmpregadoExceptions.ValidacaoEmpregadoException;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class CPFJaExisteException extends ValidacaoEmpregadoException {

    /**
     * Creates a new instance of <code>CPFJaExisteException</code> without detail message.
     */
    public CPFJaExisteException() {
    }

    /**
     * Constructs an instance of <code>CPFJaExisteException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public CPFJaExisteException(String msg) {
        super(msg);
    }
}
