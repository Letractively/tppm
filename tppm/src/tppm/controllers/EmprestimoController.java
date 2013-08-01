/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.controllers;

import tppm.domains.Emprestimo;
import tppm.exceptions.DAOExceptions.EmpregadoDAOException;
import tppm.exceptions.DAOExceptions.RegraEmprestimoDAOException;
import tppm.exceptions.DAOExceptions.RegraTaxaDeJurosDAOException;
import tppm.exceptions.NumeroDePrestacoesParserErrorException;
import tppm.exceptions.ValorEmprestimoParserErrorException;
import tppm.exceptions.validacaoEmprestimoExceptions.ValidacaoEmprestimoException;

/**
 *
 * @author Tiago
 */
public interface EmprestimoController {
    Emprestimo calcularEmprestimo(String cpf, String valor, String numeroPrestacoes) throws EmpregadoDAOException, RegraTaxaDeJurosDAOException, ValidacaoEmprestimoException, RegraEmprestimoDAOException, ValorEmprestimoParserErrorException, NumeroDePrestacoesParserErrorException;
}
