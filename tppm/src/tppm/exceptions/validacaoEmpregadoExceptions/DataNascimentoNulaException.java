/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmpregadoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class DataNascimentoNulaException extends ValidacaoEmpregadoException {

    /**
     * Creates a new instance of <code>DataNascimentoNulaException</code> without detail message.
     */
    public DataNascimentoNulaException() {
    }

    /**
     * Constructs an instance of <code>DataNascimentoNulaException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public DataNascimentoNulaException(String msg) {
        super(msg);
    }
}
