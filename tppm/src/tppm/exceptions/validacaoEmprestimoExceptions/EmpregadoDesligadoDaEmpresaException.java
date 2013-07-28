/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmprestimoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class EmpregadoDesligadoDaEmpresaException extends ValidacaoEmprestimoException {

    /**
     * Creates a new instance of <code>EmpregadoDesligadoDaEmpresaException</code> without detail message.
     */
    public EmpregadoDesligadoDaEmpresaException() {
    }

    /**
     * Constructs an instance of <code>EmpregadoDesligadoDaEmpresaException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public EmpregadoDesligadoDaEmpresaException(String msg) {
        super(msg);
    }
}
