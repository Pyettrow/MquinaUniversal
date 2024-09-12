/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import Controller.InterpretadorMonolitico;
import Model.Registrador;

/**
 *
 * @author PC
 */
public class frmPrincipal extends javax.swing.JFrame {
    ArrayList<String> fLinhasMonolitico = new ArrayList<>();
    ArrayList<Registrador> fListRegistradores = new ArrayList<>();
    
    public frmPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        txtResultado.setEditable(false);
        
        txtCaminho.setText("C:\\Users\\PC\\Documents\\GitHub\\MaquinaUniversal\\EntradaTesteMenor.txt");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btExecutar = new javax.swing.JButton();
        txtQtdRegistradores = new javax.swing.JTextField();
        btAbrir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCaminho = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Máquina Universal");

        btExecutar.setText("Executar");
        btExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExecutarActionPerformed(evt);
            }
        });

        btAbrir.setText("...");
        btAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirActionPerformed(evt);
            }
        });

        jLabel1.setText("Selecionar arquivo:");

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        jLabel2.setText("Resultado:");

        jLabel3.setText("Quantidade de registradores:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAbrir))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQtdRegistradores, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(btExecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtQtdRegistradores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAbrir))
                .addGap(18, 18, 18)
                .addComponent(btExecutar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirActionPerformed
        JFileChooser fileChooser = new JFileChooser();

        // Filtro para mostrar apenas arquivos .txt
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        fileChooser.setFileFilter(filter);

        // Abrir a janela de diálogo para selecionar o arquivo
        int result = fileChooser.showOpenDialog(null);

        // Pega o arquivo selecionado
        if (result == JFileChooser.APPROVE_OPTION) {
            txtCaminho.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_btAbrirActionPerformed

    private void btExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExecutarActionPerformed
        if (txtQtdRegistradores.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Inform a quantidade de registradores.");
            return;
        }
        
        if (Integer.parseInt(txtQtdRegistradores.getText()) <= 0) {
            JOptionPane.showMessageDialog(null, "Necessário informar pelo menos um registrador.");
            return;
        }
        
        if(txtCaminho.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Necessário selecionar txt com programa.");
            return;
        }
        
        for (int i = 0; i < Integer.parseInt(txtQtdRegistradores.getText()); i++) {        
            Registrador reg = new Registrador(i, Integer.parseInt(JOptionPane.showInputDialog(null, "Valor do " + (i + 1) + " registrador: ")));
            fListRegistradores.add(reg);
        }
        
        //Transforma o arquivo lido em linhas para poder tratar.
        try (BufferedReader br = new BufferedReader(new FileReader(txtCaminho.getText()))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                fLinhasMonolitico.add(linha);
            }
        } catch (IOException e ) {
            JOptionPane.showMessageDialog(null, "Problema com leitura do arquivo");
        }
        
        txtResultado.setText("");
        InterpretadorMonolitico interpretador = new InterpretadorMonolitico(fLinhasMonolitico, fListRegistradores, this, 0);
        interpretador.executar();
        
        fListRegistradores.clear();
        fLinhasMonolitico.clear();
    }//GEN-LAST:event_btExecutarActionPerformed

    public void EscreveResultado(String byNovaLinha){
        txtResultado.setText(txtResultado.getText().concat(byNovaLinha + "\n\r"));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAbrir;
    private javax.swing.JButton btExecutar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCaminho;
    private javax.swing.JTextField txtQtdRegistradores;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
