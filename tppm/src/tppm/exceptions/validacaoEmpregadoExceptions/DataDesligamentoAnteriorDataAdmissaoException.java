/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.validacaoEmpregadoExceptions;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class DataDesligamentoAnteriorDataAdmissaoException extends ValidacaoEmpregadoException {

    /**
     * Creates a new instance of <code>DataDesligamentoAnteriorDataAdmissaoException</code> without detail message.
     */
    public DataDesligamentoAnteriorDataAdmissaoException() {
    }

    /**
     * Constructs an instance of <code>DataDesligamentoAnteriorDataAdmissaoException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public DataDesligamentoAnteriorDataAdmissaoException(String msg) {
        super(msg);
    }
}
