/*
 * TppmApp.java
 */

package tppm.views;

import org.jdesktop.application.Application;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.SingleFrameApplication;
import tppm.config.InicializadorDeDAOsMemoria;
import tppm.config.TPPMConfig;
import tppm.controllers.EmpregadoController;
import tppm.controllers.EmpregadoControllerImpl;
import tppm.controllers.EmprestimoController;
import tppm.controllers.EmprestimoControllerImpl;
import tppm.domains.dao.EmpregadoDAO;
import tppm.domains.dao.EmpregadoDAOXML;
import tppm.exceptions.ErroAoInicializarDAOsMemoriaException;
import tppm.services.EmpregadoService;
import tppm.services.EmpregadoServiceImpl;
import tppm.services.EmprestimoService;
import tppm.services.EmprestimoServiceImpl;

/**
 * The main class of the application.
 */
public class TppmApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        try {
            InicializadorDeDAOsMemoria inicializador = new InicializadorDeDAOsMemoria();
            inicializador.inicializar();
            EmprestimoService emprestimoService = new EmprestimoServiceImpl(inicializador.getRegraTaxaDeJurosDAOMemoria(), inicializador.getRegraEmprestimoDAOMemoria());
            EmpregadoDAO empregadoDAO = new EmpregadoDAOXML(TPPMConfig.NOME_ARQUIVO_REPOSITORIO_EMPREGADOS);
            EmpregadoService empregadoService = new EmpregadoServiceImpl(empregadoDAO);
            EmpregadoController empregadoController = new EmpregadoControllerImpl(empregadoService);
            EmprestimoController emprestimoController = new EmprestimoControllerImpl(emprestimoService, empregadoService);
            FrameView mainView = new TppmView(this, emprestimoController, empregadoController);
            show(mainView);
        } catch (ErroAoInicializarDAOsMemoriaException ex) {
            System.out.println("Erro ao inicializar o programa!");
        }
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of TppmApp
     */
    public static TppmApp getApplication() {
        return Application.getInstance(TppmApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(TppmApp.class, args);
    }
}
