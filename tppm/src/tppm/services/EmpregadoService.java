/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.services;

import java.util.Date;
import tppm.dao.EmpregadoDAO;
import tppm.domains.*;
import tppm.exceptions.*;
import tppm.utils.ValidacaoUtils;

/**
 *
 * @author Tiago
 */
public class EmpregadoService {
    
    private EmpregadoDAO empregadoRepositorio;
    
    public EmpregadoService(EmpregadoDAO empregadoRepositorio){
        this.empregadoRepositorio = empregadoRepositorio;
    }
    
    public Empregado incluirEmpregado(String cpf, String nome, String sexo, Date dataNascimento, Date dataAdmissao, Double salarioAtual, Date dataDesligamento) throws ValidacaoException{
        validarDadosEmpregado(cpf, nome, sexo, dataNascimento, dataAdmissao, salarioAtual, dataDesligamento);
        Empregado empregado = new Empregado(cpf, nome, sexo, dataNascimento, dataAdmissao, salarioAtual, dataDesligamento);
        this.empregadoRepositorio.incluir(empregado);
        return empregado;
    }
    
    private void validarDadosEmpregado(String cpf, String nome, String sexo, Date dataNascimento, Date dataAdmissao, Double salarioAtual, Date dataDesligamento) throws ValidacaoException{
        validarCpf(cpf);
        validarNome(nome);
        validarSexo(sexo);
        validarDataNascimento(dataNascimento);
        validarDataAdmissao(dataAdmissao, dataNascimento);
        validarSalarioAtual(salarioAtual);
        validarDataDesligamento(dataAdmissao, dataDesligamento);
    }
    
    private void validarCpf(String cpf) throws ValidacaoException{
        ValidacaoUtils.validaStringObrigatoria(cpf, "CPF");
        ValidacaoUtils.validaNumeroCPF(cpf);
        if(verificarSeExisteEmpregadoComCPF(cpf)){
            throw new ValidacaoException("O CPF inserido já está cadastrado no sistema!");
        }
    }
    
    private void validarNome(String nome) throws ValidacaoException{
        ValidacaoUtils.validaStringObrigatoria(nome, "NOME");
        if(nome.length() > 100){
            throw new ValidacaoException("O nome inserido possui mais de 100 caracteres!");
        }
    }
    
    private void validarSexo(String sexo) throws ValidacaoException{
        ValidacaoUtils.validaStringObrigatoria(sexo, "SEXO");
        if(!sexo.equals(Empregado.SEXO_MASCULINO) && !sexo.equals(Empregado.SEXO_FEMININO)){
            throw new ValidacaoException("O sexo inserido é inválido!");
        }
    }
    
    private void validarDataNascimento(Date dataNascimento) throws ValidacaoException{
        ValidacaoUtils.validaDataObrigatoria(dataNascimento, "DATA DE NASCIMENTO");
        ValidacaoUtils.validaSeDataAnteriorADataHoje(dataNascimento, "DATA DE NASCIMENTO");
    }
    
    private void validarDataAdmissao(Date dataAdmissao, Date dataNascimento) throws ValidacaoException{
        ValidacaoUtils.validaDataObrigatoria(dataAdmissao, "DATA DE ADMISSÃO");
        ValidacaoUtils.validaSeDataAnteriorADataHoje(dataAdmissao, "DATA DE ADMISSÃO");
        if(!dataAdmissao.after(dataNascimento)){
            throw new ValidacaoException("A DATA DE ADMISSÃO deve ser posterior a data de nascimento!");
        }
    }
    
    private void validarSalarioAtual(Double salarioAtual) throws ValidacaoException{
        ValidacaoUtils.validaDoubleObrigatorio(salarioAtual, "SALÁRIO ATUAL");
        
    }
   
    private void validarDataDesligamento(Date dataAdmissao, Date dataDesligamento) throws ValidacaoException{
        ValidacaoUtils.validaDataObrigatoria(dataDesligamento, "DATA DE DESLIGAMENTO");
        ValidacaoUtils.validaSeDataAnteriorADataHoje(dataDesligamento, "DATA DE DESLIGAMENTO");
        if(!dataDesligamento.after(dataAdmissao)){
            throw new ValidacaoException("A DATA DE DESLIGAMENTO deve ser posterior a data de admissão!");
        }
    }
    
    private boolean verificarSeExisteEmpregadoComCPF(String cpf){
        Empregado empregado = this.empregadoRepositorio.procurar(cpf);
        return (empregado == null) ? false : true;
    }
}
