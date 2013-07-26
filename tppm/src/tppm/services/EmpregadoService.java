/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.services;

import java.util.Date;
import java.util.GregorianCalendar;
import tppm.dao.EmpregadoDAO;
import tppm.domains.*;
import tppm.exceptions.*;
import tppm.utils.UtilsValidacao;

/**
 *
 * @author Tiago
 */
public class EmpregadoService {
    
    private EmpregadoDAO empregadoRepositorio;
    
    public EmpregadoService(EmpregadoDAO empregadoRepositorio){
        this.empregadoRepositorio = empregadoRepositorio;
    }
    
    public void salvarEmpregado(Empregado empregado) throws ValidacaoException, EmpregadoDAOException{
        validarDadosEmpregado(empregado);
        empregadoRepositorio.alterar(empregado);
    }
    
    public Empregado incluirEmpregado(String cpf, String nome, String sexo, Date dataNascimento, Date dataAdmissao, Double salarioAtual, Date dataDesligamento) throws ValidacaoException, EmpregadoDAOException {
        Empregado empregado = new Empregado(cpf, nome, sexo, dataNascimento, dataAdmissao, salarioAtual, dataDesligamento);
        validarDadosEmpregado(empregado);
        empregadoRepositorio.incluir(empregado);
        return empregado;
    }
    
    private void validarDadosEmpregado(Empregado empregado) throws ValidacaoException, EmpregadoDAOException{
        validarCpf(empregado.getCpf());
        validarNome(empregado.getNome());
        validarSexo(empregado.getSexo());
        validarDataNascimento(empregado.getDataNascimento());
        validarDataAdmissao(empregado.getDataAdmissao(), empregado.getDataNascimento());
        validarSalarioAtual(empregado.getSalarioAtual());
        validarDataDesligamento(empregado.getDataAdmissao(), empregado.getDataDesligamento());
    }
    
    private void validarCpf(String cpf) throws ValidacaoException, EmpregadoDAOException{
        UtilsValidacao.validaStringObrigatoria(cpf, "CPF");
        UtilsValidacao.validaNumeroCPF(cpf);
        if(verificarSeExisteEmpregadoComCPF(cpf)){
            throw new ValidacaoException("O CPF inserido já está cadastrado no sistema!");
        }
    }
    
    private void validarNome(String nome) throws ValidacaoException{
        UtilsValidacao.validaStringObrigatoria(nome, "NOME");
        if(nome.length() > Empregado.TAMANHO_MAXIMO_NOME){
            throw new ValidacaoException("O nome inserido possui mais de "+Empregado.TAMANHO_MAXIMO_NOME+" caracteres!");
        }
    }
    
    private void validarSexo(String sexo) throws ValidacaoException{
        UtilsValidacao.validaStringObrigatoria(sexo, "SEXO");
        if(!sexo.equals(Empregado.SEXO_MASCULINO) && !sexo.equals(Empregado.SEXO_FEMININO)){
            throw new ValidacaoException("O sexo inserido é inválido!");
        }
    }
    
    private void validarDataNascimento(Date dataNascimento) throws ValidacaoException{
        UtilsValidacao.validaDataObrigatoria(dataNascimento, "DATA DE NASCIMENTO");
        UtilsValidacao.validaSeDataAnteriorADataHoje(dataNascimento, "DATA DE NASCIMENTO");
    }
    
    private void validarSeEmpregadoPossuiIdadePermitida(Date dataNascimento, Date dataAdmissao) throws ValidacaoException{
        GregorianCalendar dataNascimentoMais18Anos = new GregorianCalendar();
        dataNascimentoMais18Anos.setTime(dataNascimento);
        dataNascimentoMais18Anos.add(GregorianCalendar.YEAR, Empregado.IDADE_MINIMA);
        
        if(dataNascimentoMais18Anos.getTime().after(dataAdmissao)){
            throw new ValidacaoException("A idade do empregado é menor que a idade mínima permitida para contratação!");
        }
    }
    
    private void validarDataAdmissao(Date dataAdmissao, Date dataNascimento) throws ValidacaoException{
        UtilsValidacao.validaDataObrigatoria(dataAdmissao, "DATA DE ADMISSÃO");
        UtilsValidacao.validaSeDataAnteriorADataHoje(dataAdmissao, "DATA DE ADMISSÃO");
        if(!dataAdmissao.after(dataNascimento)){
            throw new ValidacaoException("A DATA DE ADMISSÃO deve ser posterior a data de nascimento!");
        }
        validarSeEmpregadoPossuiIdadePermitida(dataNascimento, dataAdmissao);
    }
    
    private void validarSalarioAtual(Double salarioAtual) throws ValidacaoException{
        UtilsValidacao.validaDoubleObrigatorio(salarioAtual, "SALÁRIO ATUAL");
        if(salarioAtual < Empregado.SALARIO_MINIMO || salarioAtual > Empregado.SALARIO_MAXIMO){
            throw new ValidacaoException("O campo 'SALÁRIO ATUAL' deve ser >= "+Empregado.SALARIO_MINIMO+" e <= "+Empregado.SALARIO_MAXIMO+"!");
        }
    }
   
    private void validarDataDesligamento(Date dataAdmissao, Date dataDesligamento) throws ValidacaoException{
        UtilsValidacao.validaDataObrigatoria(dataDesligamento, "DATA DE DESLIGAMENTO");
        UtilsValidacao.validaSeDataAnteriorADataHoje(dataDesligamento, "DATA DE DESLIGAMENTO");
        if(!dataDesligamento.after(dataAdmissao)){
            throw new ValidacaoException("A DATA DE DESLIGAMENTO deve ser posterior a data de admissão!");
        }
    }
    
    private boolean verificarSeExisteEmpregadoComCPF(String cpf)throws EmpregadoDAOException{
        Empregado empregado = empregadoRepositorio.procurar(cpf);
        return (empregado == null) ? false : true;
    }
}
