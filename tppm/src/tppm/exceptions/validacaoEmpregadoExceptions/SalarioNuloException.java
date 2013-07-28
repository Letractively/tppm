/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmpregadoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class SalarioNuloException extends ValidacaoEmpregadoException {

    /**
     * Creates a new instance of <code>SalarioNuloException</code> without detail message.
     */
    public SalarioNuloException() {
    }

    /**
     * Constructs an instance of <code>SalarioNuloException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public SalarioNuloException(String msg) {
        super(msg);
    }
}
