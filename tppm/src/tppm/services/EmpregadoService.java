/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.services;

import tppm.exceptions.DAOExceptions.EmpregadoDAOException;
import tppm.exceptions.validacaoEmpregadoExceptions.CPFJaExisteException;
import tppm.exceptions.validacaoEmpregadoExceptions.ValidacaoEmpregadoException;
import java.util.Date;
import tppm.domains.dao.EmpregadoDAO;
import tppm.domains.*;
import tppm.exceptions.validacaoEmpregadoExceptions.CPFNaoEstaCadastradoException;
import tppm.exceptions.validacaoEmpregadoExceptions.CPFVazioException;
import tppm.exceptions.validacaoEmpregadoExceptions.DataAdmissaoAnteriorDataNascimentoException;
import tppm.exceptions.validacaoEmpregadoExceptions.DataAdmissaoNulaException;
import tppm.exceptions.validacaoEmpregadoExceptions.DataAdmissaoPosteriorDataAtualException;
import tppm.exceptions.validacaoEmpregadoExceptions.DataDesligamentoAnteriorDataAdmissaoException;
import tppm.exceptions.validacaoEmpregadoExceptions.DataDesligamentoPosteriorDataAtualException;
import tppm.exceptions.validacaoEmpregadoExceptions.DataNascimentoNulaException;
import tppm.exceptions.validacaoEmpregadoExceptions.DataNascimentoPosteriorDataAtualException;
import tppm.exceptions.validacaoEmpregadoExceptions.IdadeEmpregadoNaoPermitidaNoCadastroException;
import tppm.exceptions.validacaoEmpregadoExceptions.NomeMuitoGrandeException;
import tppm.exceptions.validacaoEmpregadoExceptions.NomeVazioException;
import tppm.exceptions.validacaoEmpregadoExceptions.SalarioInvalidoException;
import tppm.exceptions.validacaoEmpregadoExceptions.SalarioNuloException;
import tppm.exceptions.validacaoEmpregadoExceptions.SexoInvalidoException;
import tppm.exceptions.validacaoEmpregadoExceptions.SexoVazioException;
import tppm.utils.Utils;
import tppm.utils.UtilsValidacao;

/**
 *
 * Nas classes de service os dados passam pelas validações das regras de negócio estabelecidas
 * e são encaminhadas ao respectivo domínio, instanciando as classes de domínio
 * e salvando somente se forem validadas
 * 
 * @author Tiago Neves + Pedro Jardim
 */
public class EmpregadoService {
    
    private EmpregadoDAO empregadoRepositorio;
    
    public EmpregadoService(EmpregadoDAO empregadoRepositorio){
        this.empregadoRepositorio = empregadoRepositorio;
    }
    
    public void alterarEmpregado(Empregado empregado) throws ValidacaoEmpregadoException, EmpregadoDAOException{
        validarDadosAlterarEmpregado(empregado);
        empregadoRepositorio.alterar(empregado);
    }
    
    public Empregado incluirEmpregado(String cpf, String nome, String sexo, Date dataNascimento, Date dataAdmissao, Double salarioAtual, Date dataDesligamento) throws ValidacaoEmpregadoException, EmpregadoDAOException {
        Empregado empregado = new Empregado(cpf, nome, sexo, dataNascimento, dataAdmissao, salarioAtual, dataDesligamento);
        validarDadosIncluirEmpregado(empregado);
        empregadoRepositorio.incluir(empregado);
        return empregado;
    }
    
    public void excluirEmpregado(Empregado empregado) throws EmpregadoDAOException, ValidacaoEmpregadoException{
        empregadoRepositorio.excluir(empregado);
    }
    
    public Empregado procurarEmpregado(String cpf) throws EmpregadoDAOException, ValidacaoEmpregadoException{
        UtilsValidacao.validaNumeroCPF(cpf);
        return empregadoRepositorio.procurar(cpf);
    }
    
    private void validarDadosAlterarEmpregado(Empregado empregado) throws ValidacaoEmpregadoException, EmpregadoDAOException{
        validarDadosEmpregado(empregado);
        if(!existeEmpregadoComCPF(empregado.getCpf())) 
            throw new CPFNaoEstaCadastradoException("Erro. Você está tentando alterar um empregado que não existe no repositório!");
    }
    
    private void validarDadosIncluirEmpregado(Empregado empregado) throws ValidacaoEmpregadoException, EmpregadoDAOException{
        validarDadosEmpregado(empregado);
        if(existeEmpregadoComCPF(empregado.getCpf())) 
            throw new CPFJaExisteException("O CPF inserido já está cadastrado no sistema!");
    }
    
    private void validarDadosEmpregado(Empregado empregado) throws ValidacaoEmpregadoException, EmpregadoDAOException{
        validarCpf(empregado.getCpf());
        validarNome(empregado.getNome());
        validarSexo(empregado.getSexo());
        validarDataNascimento(empregado.getDataNascimento());
        validarDataAdmissao(empregado.getDataAdmissao(), empregado.getDataNascimento());
        validarSalario(empregado.getSalarioAtual());
        validarDataDesligamento(empregado.getDataAdmissao(), empregado.getDataDesligamento());
    }
    
    private void validarCpf(String cpf) throws ValidacaoEmpregadoException, EmpregadoDAOException{
        if(cpf == null || cpf.equals("")) 
            throw new CPFVazioException("O CPF não pode ser vazio!");
        UtilsValidacao.validaNumeroCPF(cpf);
    }
    
    private void validarNome(String nome) throws ValidacaoEmpregadoException{
        if(nome == null || nome.equals("")) 
            throw new NomeVazioException("O Nome não pode ser vazio!");
        if(nome.length() > Empregado.TAMANHO_MAXIMO_NOME)
            throw new NomeMuitoGrandeException("O Nome possui mais de "+Empregado.TAMANHO_MAXIMO_NOME+" caracteres!");
    }
    
    private void validarSexo(String sexo) throws ValidacaoEmpregadoException{
        if(sexo == null || sexo.equals("")) 
            throw new SexoVazioException("O campo Sexo não pode ser vazio!");
        if(!sexo.equals(Empregado.SEXO_MASCULINO) && !sexo.equals(Empregado.SEXO_FEMININO))
            throw new SexoInvalidoException("O Sexo inserido é inválido!");
    }
    
    private void validarDataNascimento(Date dataNascimento) throws ValidacaoEmpregadoException{
        if(dataNascimento == null) 
            throw new DataNascimentoNulaException("O campo Data de Nascimento não pode ser nulo!");
        if(!dataNascimento.before(Utils.dataAtual()))
            throw new DataNascimentoPosteriorDataAtualException("A Data de Nascimento deve ser anterior a data de hoje!");
    }
    
    private void validarDataAdmissao(Date dataAdmissao, Date dataNascimento) throws ValidacaoEmpregadoException{
        if(dataAdmissao == null) 
            throw new DataAdmissaoNulaException("O campo Data de Admissão não pode ser nulo!");
        if(!dataAdmissao.before(Utils.dataAtual()))
            throw new DataAdmissaoPosteriorDataAtualException("A Data de Admissão deve ser anterior a data de hoje!");
        if(!dataAdmissao.after(dataNascimento))
            throw new DataAdmissaoAnteriorDataNascimentoException("A Data de Admissão deve ser posterior a data de nascimento!");
        
        validarSeEmpregadoPossuiIdadePermitida(dataNascimento, dataAdmissao);
    }
    
    private void validarSeEmpregadoPossuiIdadePermitida(Date dataNascimento, Date dataAdmissao) throws ValidacaoEmpregadoException{
        int idadeEmpregadoNaDataAdmissao = Utils.calculaDiferencaAnos(dataNascimento, dataAdmissao);
        if(idadeEmpregadoNaDataAdmissao < Empregado.IDADE_MINIMA){
            throw new IdadeEmpregadoNaoPermitidaNoCadastroException("A idade do empregado é menor que a idade mínima permitida para contratação!");
        }
    }
    
    private void validarSalario(Double salarioAtual) throws ValidacaoEmpregadoException{
        if(salarioAtual == null) 
            throw new SalarioNuloException("O campo Salário atual não pode ser nulo!");
        if(salarioAtual < Empregado.SALARIO_MINIMO || salarioAtual > Empregado.SALARIO_MAXIMO){
            throw new SalarioInvalidoException("O Salário deve estar entre "+Empregado.SALARIO_MINIMO+" e "+Empregado.SALARIO_MAXIMO+"!");
        }
    }
   
    private void validarDataDesligamento(Date dataAdmissao, Date dataDesligamento) throws ValidacaoEmpregadoException{
        if(dataDesligamento == null) return;
        if(!dataDesligamento.before(Utils.dataAtual()))
            throw new DataDesligamentoPosteriorDataAtualException("A Data de Desligamento deve ser anterior a data de hoje!");
        if(!dataDesligamento.after(dataAdmissao))
            throw new DataDesligamentoAnteriorDataAdmissaoException("A Data de Desligamento deve ser posterior a data de admissão!");
    }
    
    private boolean existeEmpregadoComCPF(String cpf) throws EmpregadoDAOException{
        Empregado empregado = empregadoRepositorio.procurar(cpf);
        return (empregado == null) ? false : true;
    }
}
