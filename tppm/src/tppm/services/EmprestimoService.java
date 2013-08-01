/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.services;

import tppm.domains.Empregado;
import tppm.domains.Emprestimo;
import tppm.exceptions.DAOExceptions.RegraEmprestimoDAOException;
import tppm.exceptions.DAOExceptions.RegraTaxaDeJurosDAOException;
import tppm.exceptions.validacaoEmprestimoExceptions.ValidacaoEmprestimoException;

/**
 *
 * @author Tiago
 */
public interface EmprestimoService {
    Emprestimo calcularEmprestimo(Empregado empregado, Double valor, int numeroPrestacoes) throws RegraTaxaDeJurosDAOException, ValidacaoEmprestimoException, RegraEmprestimoDAOException;
}
