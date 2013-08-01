/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.services;

import tppm.domains.dao.RegraEmprestimoDAO;
import tppm.domains.dao.RegraTaxaDeJurosDAO;
import tppm.domains.Empregado;
import tppm.domains.Emprestimo;
import tppm.domains.RegraEmprestimo;
import tppm.domains.RegraTaxaDeJuros;
import tppm.exceptions.DAOExceptions.RegraEmprestimoDAOException;
import tppm.exceptions.DAOExceptions.RegraTaxaDeJurosDAOException;
import tppm.exceptions.validacaoEmprestimoExceptions.EmpregadoDesligadoDaEmpresaException;
import tppm.exceptions.validacaoEmprestimoExceptions.IdadeMaiorQueAPermitidaParaEmprestimoException;
import tppm.exceptions.validacaoEmprestimoExceptions.IdadeMenorQueAPermitidaParaEmprestimoException;
import tppm.exceptions.validacaoEmprestimoExceptions.NumeroDePrestacoesMaiorQueOPermitidoException;
import tppm.exceptions.validacaoEmprestimoExceptions.NumeroDePrestacoesMenorQueOPermitidoException;
import tppm.exceptions.validacaoEmprestimoExceptions.ValidacaoEmprestimoException;
import tppm.exceptions.validacaoEmprestimoExceptions.ValorSolicitadoMaiorQueOPermitidoException;

/**
 *
 * Nas classes de service os dados passam pelas validações das regras de negócio estabelecidas
 * e são encaminhadas ao respectivo domínio, instanciando as classes de domínio
 * e salvando somente se forem validadas
 * 
 * @author Tiago Neves + Pedro Jardim
 */
public class EmprestimoServiceImpl implements EmprestimoService{
    
    private RegraTaxaDeJurosDAO regraTaxaDeJurosRepositorio;
    private RegraEmprestimoDAO regraEmprestimoRepositorio;
    
    public EmprestimoServiceImpl(RegraTaxaDeJurosDAO regraTaxaDeJurosPrestacoesRepositorio, RegraEmprestimoDAO regraEmprestimoRepositorio){
        this.regraTaxaDeJurosRepositorio = regraTaxaDeJurosPrestacoesRepositorio;
        this.regraEmprestimoRepositorio = regraEmprestimoRepositorio;
    }
    
    public Emprestimo calcularEmprestimo(Empregado empregado, Double valor, int numeroPrestacoes) throws RegraTaxaDeJurosDAOException, ValidacaoEmprestimoException, RegraEmprestimoDAOException{
        validarParametrosParaEmprestimo(empregado, valor, numeroPrestacoes);
        RegraTaxaDeJuros taxaDeJuros = regraTaxaDeJurosRepositorio.procurar(numeroPrestacoes);
        return new Emprestimo(empregado, valor, numeroPrestacoes, taxaDeJuros);
    }
    
    private void validarParametrosParaEmprestimo(Empregado empregado, Double valor, int numeroPrestacoes) throws ValidacaoEmprestimoException, RegraTaxaDeJurosDAOException, RegraEmprestimoDAOException{
        validarNumeroPrestacoes(numeroPrestacoes);
        validarSituacaoEmpregado(empregado);
        validarIdadeEmpregado(empregado);
        validarValorEmprestimo(empregado, valor);
    }
    
    private void validarNumeroPrestacoes(int numeroPrestacoes) throws ValidacaoEmprestimoException, RegraTaxaDeJurosDAOException{
        if(numeroPrestacoes < regraTaxaDeJurosRepositorio.obterNumeroMinimoPrestacoes())
            throw new NumeroDePrestacoesMenorQueOPermitidoException("O número de prestações é menor que o número mínimo permitido!");
        if(numeroPrestacoes > regraTaxaDeJurosRepositorio.obterNumeroMaximoPrestacoes())
            throw new NumeroDePrestacoesMaiorQueOPermitidoException("O número de prestações é maior que o número máximo permitido!");
    }
    
    private void validarSituacaoEmpregado(Empregado empregado) throws ValidacaoEmprestimoException{
        if(empregado.getDataDesligamento() != null) 
            throw new EmpregadoDesligadoDaEmpresaException("O empregado já foi desligado da empresa, portanto o empréstimo não pode ser concedido!");
    }
    
    private void validarIdadeEmpregado(Empregado empregado) throws ValidacaoEmprestimoException, RegraEmprestimoDAOException{
        if(empregado.getIdade() < regraEmprestimoRepositorio.obterIdadeMinima(empregado.getSexo()))
            throw new IdadeMenorQueAPermitidaParaEmprestimoException("O empregado possui idade menor que a idade mínima permitida!");
        if(empregado.getIdade() > regraEmprestimoRepositorio.obterIdadeMaxima(empregado.getSexo()))
            throw new IdadeMaiorQueAPermitidaParaEmprestimoException("O empregado possui idade maior que a idade máxima permitida!");
    }
    
    private void validarValorEmprestimo(Empregado empregado, Double valor) throws ValidacaoEmprestimoException, RegraEmprestimoDAOException{
        RegraEmprestimo regraEmprestimo = regraEmprestimoRepositorio.procurar(empregado.getSexo(), empregado.getIdade(), empregado.getSalarioAtual());
        if(valor > regraEmprestimo.calculaLimiteEmprestimo(empregado.getSalarioAtual()))
            throw new ValorSolicitadoMaiorQueOPermitidoException("O valor de empréstimo solicitado é maior que o valor permitido para esse empregado!");
    }
}
