/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TppmExcluirEmpregadoBox.java
 *
 * Created on Jul 29, 2013, 7:48:07 PM
 */
package tppm.views;

import tppm.controllers.EmpregadoController;
import tppm.domains.Empregado;
import tppm.utils.Utils;

/**
 *
 * @author Tiago Neves + Pedro Jardim
 */
public class TppmExcluirEmpregadoBox extends javax.swing.JFrame {

    EmpregadoController empregadoController;
    
    /** Creates new form TppmExcluirEmpregadoBox */
    public TppmExcluirEmpregadoBox() {
        initComponents();
    }
    
    public TppmExcluirEmpregadoBox(EmpregadoController empregadoController) {
        initComponents();
        this.empregadoController = empregadoController;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        inputCpf = new javax.swing.JTextField();
        btExcluirEmpregado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(tppm.views.TppmApp.class).getContext().getResourceMap(TppmExcluirEmpregadoBox.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        inputCpf.setText(resourceMap.getString("inputCpf.text")); // NOI18N
        inputCpf.setName("inputCpf"); // NOI18N

        btExcluirEmpregado.setText(resourceMap.getString("btExcluirEmpregado.text")); // NOI18N
        btExcluirEmpregado.setName("btExcluirEmpregado"); // NOI18N
        btExcluirEmpregado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirEmpregadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(btExcluirEmpregado, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btExcluirEmpregado)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExcluirEmpregadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirEmpregadoActionPerformed
        try{
            String cpf = inputCpf.getText();
            Empregado empregado = empregadoController.procurarEmpregado(cpf);
            if(empregado != null){
                empregadoController.excluirEmpregado(empregado);
                Utils.exibeMensagem(this, "Empregado excluído com sucesso!");
                fecharAlterarEmpregadoBox();
            }
            else{
                Utils.exibeErro(this, "Não existe nenhum empregado com esse cpf cadastrado!");
            }
        }
        catch(Exception e){
            Utils.exibeErro(this, e.getMessage());
        }
    }//GEN-LAST:event_btExcluirEmpregadoActionPerformed

    private void fecharAlterarEmpregadoBox(){
        this.dispose();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcluirEmpregado;
    private javax.swing.JTextField inputCpf;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
