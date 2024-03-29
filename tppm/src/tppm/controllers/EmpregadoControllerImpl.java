/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.controllers;

import java.util.Date;
import tppm.domains.Empregado;
import tppm.exceptions.DAOExceptions.EmpregadoDAOException;
import tppm.exceptions.SalarioParserErrorException;
import tppm.exceptions.dataParseExceptions.DataAdmissaoParserErrorException;
import tppm.exceptions.dataParseExceptions.DataDeNascimentoParserErrorException;
import tppm.exceptions.dataParseExceptions.DataDesligamentoParserErrorException;
import tppm.exceptions.dataParseExceptions.DataParseErroException;
import tppm.exceptions.validacaoEmpregadoExceptions.ValidacaoEmpregadoException;
import tppm.services.EmpregadoService;
import tppm.utils.Utils;

/**
 *
 * Essa classe foi feita para intermediar a comunicação de uma view com um service
 * nessa parte, a view passa os parâmetros em string e essa classe converte e chama o service apropriado,
 * instanciado aqui com a implementação escolhida do DAO do service
 * 
 * @author Tiago Neves + Pedro Jardim
 */
public class EmpregadoControllerImpl implements EmpregadoController{
    
    EmpregadoService empregadoService;

    public EmpregadoControllerImpl(EmpregadoService empregadoService) {
        this.empregadoService = empregadoService;
    }
    
    public static String[] obtemListaSexosDisponiveis(){
        String[] listaOpcoes = {Empregado.SEXO_MASCULINO, Empregado.SEXO_FEMININO};
        return listaOpcoes;
    }
    
    public void incluirEmpregado(String cpf, String nome, String sexo, String dataNascimento, String dataAdmissao, String salarioAtual, String dataDesligamento) throws DataDeNascimentoParserErrorException, DataAdmissaoParserErrorException, DataDesligamentoParserErrorException, SalarioParserErrorException, ValidacaoEmpregadoException, EmpregadoDAOException{
        Date dataNascimentoConvertida = converterStringDataDeNascimentoParaData(dataNascimento);
        Date dataAdmissaoConvertida = converterStringDataAdmissaoParaData(dataAdmissao);
        Date dataDesligamentoConvertida = converterStringDataDesligamentoParaData(dataDesligamento);
        Double salarioAtualConvertido = converterStringSalarioParaDouble(salarioAtual);
        empregadoService.incluirEmpregado(cpf, nome, sexo, dataNascimentoConvertida, dataAdmissaoConvertida, salarioAtualConvertido, dataDesligamentoConvertida);
    }
    
    private Date converterStringDataDeNascimentoParaData(String dataNascimento) throws DataDeNascimentoParserErrorException{
        try{
            return Utils.converterStringParaData(dataNascimento);
        } catch(DataParseErroException e){
            throw new DataDeNascimentoParserErrorException("Erro ao converter a data de nascimento! verifique se a data digitada está no padrão!");
        }
    }
    
    private Date converterStringDataAdmissaoParaData(String dataAdmissao) throws DataAdmissaoParserErrorException{
        try{
            return Utils.converterStringParaData(dataAdmissao);
        } catch(DataParseErroException e){
            throw new DataAdmissaoParserErrorException("Erro ao converter a data de admissão! verifique se a data digitada está no padrão!");
        }
    }
    
    private Date converterStringDataDesligamentoParaData(String dataDesligamento) throws DataDesligamentoParserErrorException{
        try{
            return Utils.converterStringParaData(dataDesligamento);
        } catch(DataParseErroException e){
            throw new DataDesligamentoParserErrorException("Erro ao converter a data de desligamento! verifique se a data digitada está no padrão!");
        }
    }
    
    private Double converterStringSalarioParaDouble(String salario) throws SalarioParserErrorException {
        try {
            if(salario.length() == 0) return null;
            return Double.parseDouble(salario);
        } catch(Exception e){
            throw new SalarioParserErrorException("Erro. O salário inserido não pode ser lido conforme o padrão!");
        }
    }
    
    public void alterarEmpregado(String cpf, String nome, String sexo, String dataNascimento, String dataAdmissao, String salarioAtual, String dataDesligamento) throws DataDeNascimentoParserErrorException, DataAdmissaoParserErrorException, DataDesligamentoParserErrorException, SalarioParserErrorException, ValidacaoEmpregadoException, EmpregadoDAOException{
        Date dataNascimentoConvertida = converterStringDataDeNascimentoParaData(dataNascimento);
        Date dataAdmissaoConvertida = converterStringDataAdmissaoParaData(dataAdmissao);
        Date dataDesligamentoConvertida = converterStringDataDesligamentoParaData(dataDesligamento);
        Double salarioAtualConvertido = converterStringSalarioParaDouble(salarioAtual);
        Empregado empregado = new Empregado(cpf, nome, sexo, dataNascimentoConvertida, dataAdmissaoConvertida, salarioAtualConvertido, dataDesligamentoConvertida);
        empregadoService.alterarEmpregado(empregado);
    }
    
    public void excluirEmpregado(Empregado empregado) throws ValidacaoEmpregadoException, EmpregadoDAOException{
        empregadoService.excluirEmpregado(empregado);
    }
    
    public Empregado procurarEmpregado(String cpf) throws ValidacaoEmpregadoException, EmpregadoDAOException {
        return empregadoService.procurarEmpregado(cpf);
    }
}
