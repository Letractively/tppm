/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.domains;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class RegraEmprestimo {
    
    private String sexo;
    private int idadeMinima;
    private int idadeMaxima;
    private Double salarioMinimo;
    private Double salarioMaximo;
    private Double porcentagemLimiteSalario;

    public RegraEmprestimo(String sexo, int idadeMinima, int idadeMaxima, Double salarioMinimo, Double salarioMaximo, Double porcentagemLimiteSalario) {
        this.sexo = sexo;
        this.idadeMinima = idadeMinima;
        this.idadeMaxima = idadeMaxima;
        this.salarioMinimo = salarioMinimo;
        this.salarioMaximo = salarioMaximo;
        this.porcentagemLimiteSalario = porcentagemLimiteSalario;
    }
    
    public RegraEmprestimo(RegraEmprestimo regra) {
        this.sexo = regra.getSexo();
        this.idadeMinima = regra.getIdadeMinima();
        this.idadeMaxima = regra.getIdadeMaxima();
        this.salarioMinimo = regra.getSalarioMinimo();
        this.salarioMaximo = regra.getSalarioMaximo();
        this.porcentagemLimiteSalario = regra.getPorcentagemLimiteSalario();
    }
    
    @Override
    public boolean equals(Object empregadoComparado) {
        return getListaPropriedades().equals(((RegraEmprestimo) empregadoComparado).getListaPropriedades());
    }

    private List<?> getListaPropriedades(){
        return Arrays.asList(getSexo(), getIdadeMinima(), getIdadeMaxima(), getSalarioMinimo(), getSalarioMaximo(), getPorcentagemLimiteSalario());
    }
    
    public int getIdadeMaxima() {
        return idadeMaxima;
    }

    public void setIdadeMaxima(int idadeMaxima) {
        this.idadeMaxima = idadeMaxima;
    }

    public int getIdadeMinima() {
        return idadeMinima;
    }

    public void setIdadeMinima(int idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    public Double getPorcentagemLimiteSalario() {
        return porcentagemLimiteSalario;
    }

    public void setPorcentagemLimiteSalario(Double porcentagemLimiteSalario) {
        this.porcentagemLimiteSalario = porcentagemLimiteSalario;
    }

    public Double getSalarioMaximo() {
        return salarioMaximo;
    }

    public void setSalarioMaximo(Double salarioMaximo) {
        this.salarioMaximo = salarioMaximo;
    }

    public Double getSalarioMinimo() {
        return salarioMinimo;
    }

    public void setSalarioMinimo(Double salarioMinimo) {
        this.salarioMinimo = salarioMinimo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Double calculaLimiteEmprestimo(Double salario){
        return salario * getPorcentagemLimiteSalario();
    }
    
    public boolean verificaSeIdadeEstaNaFaixa(int idade){
        return (idade >= getIdadeMinima() && idade <= getIdadeMaxima());
    }
    
    public boolean verificaSeSalarioEstaNaFaixa(Double salario){
        return (salario >= getSalarioMinimo() && salario <= getSalarioMaximo());
    }
}
