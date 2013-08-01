/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.controllers;

import tppm.domains.Empregado;
import tppm.domains.Emprestimo;
import tppm.exceptions.DAOExceptions.EmpregadoDAOException;
import tppm.exceptions.DAOExceptions.RegraEmprestimoDAOException;
import tppm.exceptions.DAOExceptions.RegraTaxaDeJurosDAOException;
import tppm.exceptions.NumeroDePrestacoesParserErrorException;
import tppm.exceptions.ValorEmprestimoParserErrorException;
import tppm.exceptions.validacaoEmprestimoExceptions.ValidacaoEmprestimoException;
import tppm.services.EmpregadoService;
import tppm.services.EmprestimoService;

/**
 *
 * Essa classe foi feita para intermediar a comunicação de uma view com um service
 * nessa parte, a view passa os parâmetros em string e essa classe converte e chama o service apropriado,
 * instanciado aqui com a implementação escolhida do DAO do service
 * 
 * @author Tiago Neves + Pedro Jardim
 */
public class EmprestimoControllerImpl implements EmprestimoController{
    
    EmprestimoService emprestimoService;
    EmpregadoService empregadoService;

    public EmprestimoControllerImpl(EmprestimoService emprestimoService, EmpregadoService empregadoService){
        this.emprestimoService = emprestimoService;
        this.empregadoService = empregadoService;
    }
    
    public Emprestimo calcularEmprestimo(String cpf, String valor, String numeroPrestacoes) throws EmpregadoDAOException, RegraTaxaDeJurosDAOException, ValidacaoEmprestimoException, RegraEmprestimoDAOException, ValorEmprestimoParserErrorException, NumeroDePrestacoesParserErrorException{
        Empregado empregado = empregadoService.procurarEmpregado(cpf);
        if(empregado == null) throw new ValidacaoEmprestimoException("Não existe nenhum empregado com esse CPF!");
        Double valorConvertido = converterValorStringParaDouble(valor);
        int numeroPrestacoesConvertido = converterNumeroPrestacoesParaInt(numeroPrestacoes);
        return emprestimoService.calcularEmprestimo(empregado, valorConvertido, numeroPrestacoesConvertido);
    }
    
    private Double converterValorStringParaDouble(String valor) throws ValorEmprestimoParserErrorException{
        try{
            return Double.parseDouble(valor);
        } catch(NumberFormatException e){
            throw new ValorEmprestimoParserErrorException("Oops, houve um erro ao converter o valor do empréstimo! Verifique se ele está no padrão!");
        }
    }

    private int converterNumeroPrestacoesParaInt(String numeroPrestacoes) throws NumeroDePrestacoesParserErrorException {
        try{
            return Integer.parseInt(numeroPrestacoes);
        } catch(NumberFormatException e){
            throw new NumeroDePrestacoesParserErrorException("Oops, houve um erro ao converter o número de prestações! Verifique se ele está no padrão!");
        }
    }
    
    
}
