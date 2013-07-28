/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmprestimoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class IdadeMaiorQueAPermitidaParaEmprestimoException extends ValidacaoEmprestimoException {

    /**
     * Creates a new instance of <code>IdadeMaiorQueAPermitidaParaEmprestimoException</code> without detail message.
     */
    public IdadeMaiorQueAPermitidaParaEmprestimoException() {
    }

    /**
     * Constructs an instance of <code>IdadeMaiorQueAPermitidaParaEmprestimoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public IdadeMaiorQueAPermitidaParaEmprestimoException(String msg) {
        super(msg);
    }
}
