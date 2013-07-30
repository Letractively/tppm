/*
 * TppmView.java
 */

package tppm.views;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import tppm.controllers.EmpregadoController;
import tppm.controllers.EmprestimoController;
import tppm.domains.Emprestimo;
import tppm.exceptions.ErroAoInicializarDAOsMemoriaException;
import tppm.utils.Utils;

/**
 * The application's main frame.
 */
public class TppmView extends FrameView {

    EmprestimoController emprestimoController;
    EmpregadoController empregadoController;
    
    public TppmView(SingleFrameApplication app) {
        super(app);

        initComponents();
        
        try {
            emprestimoController = new EmprestimoController();
        } catch (ErroAoInicializarDAOsMemoriaException ex) {
            Utils.exibeErro(getFrame(), "Oops, houve um erro ao inicializar os dados das regras de empréstimo!");
        }
        
        empregadoController = new EmpregadoController();
        
        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = TppmApp.getApplication().getMainFrame();
            aboutBox = new TppmAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        TppmApp.getApplication().show(aboutBox);
    }
    
    @Action
    public void showIncluirEmpregadoBox() {
        JFrame mainFrame = TppmApp.getApplication().getMainFrame();
        incluirEmpregadoBox = new TppmIncluirEmpregadoBox();
        incluirEmpregadoBox.setLocationRelativeTo(mainFrame);
        TppmApp.getApplication().show(incluirEmpregadoBox);
    }
    
    @Action
    public void showAlterarEmpregadoBox() {
        if (alterarEmpregadoBox == null) {
            JFrame mainFrame = TppmApp.getApplication().getMainFrame();
            alterarEmpregadoBox = new TppmAlterarEmpregadoBox(mainFrame, true);
            alterarEmpregadoBox.setLocationRelativeTo(mainFrame);
        }
        TppmApp.getApplication().show(alterarEmpregadoBox);
    }
    
    @Action
    public void showExcluirEmpregadoBox() {
        if (excluirEmpregadoBox == null) {
            JFrame mainFrame = TppmApp.getApplication().getMainFrame();
            excluirEmpregadoBox = new TppmExcluirEmpregadoBox();
            excluirEmpregadoBox.setLocationRelativeTo(mainFrame);
        }
        TppmApp.getApplication().show(excluirEmpregadoBox);
    }

    private void showResultadoEmprestimoBox(Emprestimo emprestimo) {
        JFrame mainFrame = TppmApp.getApplication().getMainFrame();
        resultadoEmprestimoBox = new TppmResultadoCalculoEmprestimoBox(emprestimo);
        resultadoEmprestimoBox.setLocationRelativeTo(mainFrame);
        TppmApp.getApplication().show(resultadoEmprestimoBox);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cpfInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        valorInput = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        numeroPrestacoesInput = new javax.swing.JTextField();
        btCalcularEmprestimo = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        menuEmpregados = new javax.swing.JMenu();
        incluirEmpregadoMenuItem = new javax.swing.JMenuItem();
        excluirEmpregadoMenuItem = new javax.swing.JMenuItem();
        alterarEmpregadoMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        mainPanel.setName("mainPanel"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(tppm.views.TppmApp.class).getContext().getResourceMap(TppmView.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        cpfInput.setText(resourceMap.getString("cpfInput.text")); // NOI18N
        cpfInput.setName("cpfInput"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        valorInput.setText(resourceMap.getString("valorInput.text")); // NOI18N
        valorInput.setName("valorInput"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        numeroPrestacoesInput.setText(resourceMap.getString("numeroPrestacoesInput.text")); // NOI18N
        numeroPrestacoesInput.setName("numeroPrestacoesInput"); // NOI18N

        btCalcularEmprestimo.setText(resourceMap.getString("btCalcularEmprestimo.text")); // NOI18N
        btCalcularEmprestimo.setName("btCalcularEmprestimo"); // NOI18N
        btCalcularEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalcularEmprestimoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2))
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel4))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(numeroPrestacoesInput)
                            .addComponent(valorInput)
                            .addComponent(cpfInput, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(283, Short.MAX_VALUE)
                .addComponent(btCalcularEmprestimo)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cpfInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valorInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(numeroPrestacoesInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCalcularEmprestimo)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(tppm.views.TppmApp.class).getContext().getActionMap(TppmView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setText(resourceMap.getString("exitMenuItem.text")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        menuEmpregados.setText(resourceMap.getString("menuEmpregados.text")); // NOI18N
        menuEmpregados.setName("menuEmpregados"); // NOI18N

        incluirEmpregadoMenuItem.setAction(actionMap.get("showIncluirEmpregadoBox")); // NOI18N
        incluirEmpregadoMenuItem.setText(resourceMap.getString("incluirEmpregadoMenuItem.text")); // NOI18N
        incluirEmpregadoMenuItem.setName("incluirEmpregadoMenuItem"); // NOI18N
        menuEmpregados.add(incluirEmpregadoMenuItem);

        excluirEmpregadoMenuItem.setAction(actionMap.get("showExcluirEmpregadoBox")); // NOI18N
        excluirEmpregadoMenuItem.setText(resourceMap.getString("excluirEmpregadoMenuItem.text")); // NOI18N
        excluirEmpregadoMenuItem.setName("excluirEmpregadoMenuItem"); // NOI18N
        menuEmpregados.add(excluirEmpregadoMenuItem);

        alterarEmpregadoMenuItem.setAction(actionMap.get("showAlterarEmpregadoBox")); // NOI18N
        alterarEmpregadoMenuItem.setText(resourceMap.getString("alterarEmpregadoMenuItem.text")); // NOI18N
        alterarEmpregadoMenuItem.setName("alterarEmpregadoMenuItem"); // NOI18N
        menuEmpregados.add(alterarEmpregadoMenuItem);

        menuBar.add(menuEmpregados);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setText(resourceMap.getString("aboutMenuItem.text")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void btCalcularEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalcularEmprestimoActionPerformed
        try{
            String cpf = cpfInput.getText();
            String valor = valorInput.getText();
            String numeroPrestacoes = numeroPrestacoesInput.getText();
            Emprestimo emprestimo = emprestimoController.calcularEmprestimo(cpf, valor, numeroPrestacoes);
            showResultadoEmprestimoBox(emprestimo);
        } catch(Exception e){
            Utils.exibeErro(getFrame(), e.getMessage());
        }
    }//GEN-LAST:event_btCalcularEmprestimoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem alterarEmpregadoMenuItem;
    private javax.swing.JButton btCalcularEmprestimo;
    private javax.swing.JTextField cpfInput;
    private javax.swing.JMenuItem excluirEmpregadoMenuItem;
    private javax.swing.JMenuItem incluirEmpregadoMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuEmpregados;
    private javax.swing.JTextField numeroPrestacoesInput;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JTextField valorInput;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
    private JFrame incluirEmpregadoBox;
    private JDialog alterarEmpregadoBox;
    private JFrame excluirEmpregadoBox;
    private JFrame resultadoEmprestimoBox;

}
