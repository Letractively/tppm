/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmpregadoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class SalarioInvalidoException extends ValidacaoEmpregadoException {

    /**
     * Creates a new instance of <code>SalarioInvalidoException</code> without detail message.
     */
    public SalarioInvalidoException() {
    }

    /**
     * Constructs an instance of <code>SalarioInvalidoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public SalarioInvalidoException(String msg) {
        super(msg);
    }
}
