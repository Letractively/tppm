/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.domains;

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
}
