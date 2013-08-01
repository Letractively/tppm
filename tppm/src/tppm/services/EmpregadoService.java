/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.services;

import java.util.Date;
import tppm.domains.Empregado;
import tppm.exceptions.DAOExceptions.EmpregadoDAOException;
import tppm.exceptions.validacaoEmpregadoExceptions.ValidacaoEmpregadoException;

/**
 *
 * @author Tiago
 */
public interface EmpregadoService {
    void alterarEmpregado(Empregado empregado) throws ValidacaoEmpregadoException, EmpregadoDAOException;
    Empregado incluirEmpregado(String cpf, String nome, String sexo, Date dataNascimento, Date dataAdmissao, Double salarioAtual, Date dataDesligamento) throws ValidacaoEmpregadoException, EmpregadoDAOException;
    void excluirEmpregado(Empregado empregado) throws EmpregadoDAOException, ValidacaoEmpregadoException;
    Empregado procurarEmpregado(String cpf) throws EmpregadoDAOException, ValidacaoEmpregadoException;
}
