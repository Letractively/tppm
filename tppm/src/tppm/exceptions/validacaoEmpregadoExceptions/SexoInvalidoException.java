/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmpregadoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class SexoInvalidoException extends ValidacaoEmpregadoException {

    /**
     * Creates a new instance of <code>SexoInvalidoException</code> without detail message.
     */
    public SexoInvalidoException() {
    }

    /**
     * Constructs an instance of <code>SexoInvalidoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public SexoInvalidoException(String msg) {
        super(msg);
    }
}
