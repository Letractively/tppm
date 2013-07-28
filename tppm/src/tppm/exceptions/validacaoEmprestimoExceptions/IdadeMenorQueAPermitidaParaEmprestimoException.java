/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmprestimoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class IdadeMenorQueAPermitidaParaEmprestimoException extends ValidacaoEmprestimoException {

    /**
     * Creates a new instance of <code>IdadeMenorQueAPermitidaParaEmprestimoException</code> without detail message.
     */
    public IdadeMenorQueAPermitidaParaEmprestimoException() {
    }

    /**
     * Constructs an instance of <code>IdadeMenorQueAPermitidaParaEmprestimoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public IdadeMenorQueAPermitidaParaEmprestimoException(String msg) {
        super(msg);
    }
}
