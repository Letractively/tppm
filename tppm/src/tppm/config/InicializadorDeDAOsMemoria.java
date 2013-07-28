/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tppm.config;

import tppm.dao.RegraEmprestimoDAOMemoria;
import tppm.domains.Empregado;
import tppm.domains.RegraEmprestimo;
import tppm.exceptions.DAOExceptions.RegraEmprestimoDAOException;
import tppm.exceptions.ErroAoInicializarDAOsMemoriaException;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class InicializadorDeDAOsMemoria {

    private RegraEmprestimoDAOMemoria regraEmprestimoDAOMemoria;
    
    public static final RegraEmprestimo[] regras = {
        new RegraEmprestimo(Empregado.SEXO_MASCULINO, 21, 35, 5000.01, Empregado.SALARIO_MAXIMO, 0.7),
        new RegraEmprestimo(Empregado.SEXO_MASCULINO, 21, 35, Empregado.SALARIO_MINIMO, 5000.00, 0.6),
        new RegraEmprestimo(Empregado.SEXO_MASCULINO, 36, 45, 6000.01, Empregado.SALARIO_MAXIMO, 0.55),
        new RegraEmprestimo(Empregado.SEXO_MASCULINO, 36, 45, Empregado.SALARIO_MINIMO, 6000.00, 0.45),
        new RegraEmprestimo(Empregado.SEXO_MASCULINO, 46, 65, Empregado.SALARIO_MINIMO, Empregado.SALARIO_MAXIMO, 0.35),
        new RegraEmprestimo(Empregado.SEXO_FEMININO, 21, 30, Empregado.SALARIO_MINIMO, Empregado.SALARIO_MAXIMO, 0.75),
        new RegraEmprestimo(Empregado.SEXO_FEMININO, 31, 44, Empregado.SALARIO_MINIMO, Empregado.SALARIO_MAXIMO, 0.55),
        new RegraEmprestimo(Empregado.SEXO_FEMININO, 45, 61, Empregado.SALARIO_MINIMO, Empregado.SALARIO_MAXIMO, 0.40)
    };
    
    public InicializadorDeDAOsMemoria(){
        regraEmprestimoDAOMemoria = new RegraEmprestimoDAOMemoria();
    }
    
    public void inicializar() throws ErroAoInicializarDAOsMemoriaException{
        inicializarRegrasDeEmprestimo();
    }
    
    private void inicializarRegrasDeEmprestimo() throws ErroAoInicializarDAOsMemoriaException{
        try{
            for(RegraEmprestimo regra : regras){
                regraEmprestimoDAOMemoria.incluir(regra);
            }
        } catch(RegraEmprestimoDAOException e){
            throw new ErroAoInicializarDAOsMemoriaException(e.getMessage());
        }
    }
}
