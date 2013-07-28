/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmpregadoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class DataAdmissaoNulaException extends ValidacaoEmpregadoException {

    /**
     * Creates a new instance of <code>DataAdmissaoNulaException</code> without detail message.
     */
    public DataAdmissaoNulaException() {
    }

    /**
     * Constructs an instance of <code>DataAdmissaoNulaException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public DataAdmissaoNulaException(String msg) {
        super(msg);
    }
}
