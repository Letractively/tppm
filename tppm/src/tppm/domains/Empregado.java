/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.domains;

import java.util.Date;

/**
 *
 * @author Tiago
 */
public class Empregado {
    
    public static String SEXO_MASCULINO = "Masculino";
    public static String SEXO_FEMININO = "Feminino";
    
    private String cpf;
    private String nome;
    private String sexo;
    private Date dataNascimento;
    private Date dataAdmissao;
    private Double salarioAtual;
    private Date dataDesligamento;

    public Empregado(String cpf, String nome, String sexo, Date dataNascimento, Date dataAdmissao, Double salarioAtual, Date dataDesligamento) {
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.dataAdmissao = dataAdmissao;
        this.salarioAtual = salarioAtual;
        this.dataDesligamento = dataDesligamento;
    }

    public Empregado() {
    }

    @Override
    public boolean equals(Object empregadoComparado) {
        return getCpf().equals(((Empregado) empregadoComparado).getCpf());
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Date getDataDesligamento() {
        return dataDesligamento;
    }

    public void setDataDesligamento(Date dataDesligamento) {
        this.dataDesligamento = dataDesligamento;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalarioAtual() {
        return salarioAtual;
    }

    public void setSalarioAtual(Double salarioAtual) {
        this.salarioAtual = salarioAtual;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Empregado{" + "cpf=" + cpf + ", nome=" + nome + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento + ", dataAdmissao=" + dataAdmissao + ", salarioAtual=" + salarioAtual + ", dataDesligamento=" + dataDesligamento + '}';
    }
    
}
