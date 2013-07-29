/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.exceptions.dataParseExceptions;

/**
 *
 * @author Tiago
 */
public class DataAdmissaoParserErrorException extends DataParseErroException {

    /**
     * Creates a new instance of <code>DataAdmissaoParserErrorException</code> without detail message.
     */
    public DataAdmissaoParserErrorException() {
    }

    /**
     * Constructs an instance of <code>DataAdmissaoParserErrorException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public DataAdmissaoParserErrorException(String msg) {
        super(msg);
    }
}
