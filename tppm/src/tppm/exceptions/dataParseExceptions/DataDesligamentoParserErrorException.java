/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.dataParseExceptions;

/**
 *
 * @author Tiago
 */
public class DataDesligamentoParserErrorException extends DataParseErroException {

    /**
     * Creates a new instance of <code>DataDesligamentoParserErrorException</code> without detail message.
     */
    public DataDesligamentoParserErrorException() {
    }

    /**
     * Constructs an instance of <code>DataDesligamentoParserErrorException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public DataDesligamentoParserErrorException(String msg) {
        super(msg);
    }
}
