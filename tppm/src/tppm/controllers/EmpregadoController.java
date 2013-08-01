/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.controllers;

import tppm.domains.Empregado;
import tppm.exceptions.DAOExceptions.EmpregadoDAOException;
import tppm.exceptions.SalarioParserErrorException;
import tppm.exceptions.dataParseExceptions.DataAdmissaoParserErrorException;
import tppm.exceptions.dataParseExceptions.DataDeNascimentoParserErrorException;
import tppm.exceptions.dataParseExceptions.DataDesligamentoParserErrorException;
import tppm.exceptions.validacaoEmpregadoExceptions.ValidacaoEmpregadoException;

/**
 *
 * @author Tiago
 */
public interface EmpregadoController {
    void incluirEmpregado(String cpf, String nome, String sexo, String dataNascimento, String dataAdmissao, String salarioAtual, String dataDesligamento) throws DataDeNascimentoParserErrorException, DataAdmissaoParserErrorException, DataDesligamentoParserErrorException, SalarioParserErrorException, ValidacaoEmpregadoException, EmpregadoDAOException;
    void alterarEmpregado(String cpf, String nome, String sexo, String dataNascimento, String dataAdmissao, String salarioAtual, String dataDesligamento) throws DataDeNascimentoParserErrorException, DataAdmissaoParserErrorException, DataDesligamentoParserErrorException, SalarioParserErrorException, ValidacaoEmpregadoException, EmpregadoDAOException;
    void excluirEmpregado(Empregado empregado) throws ValidacaoEmpregadoException, EmpregadoDAOException;
    Empregado procurarEmpregado(String cpf) throws ValidacaoEmpregadoException, EmpregadoDAOException;
}
