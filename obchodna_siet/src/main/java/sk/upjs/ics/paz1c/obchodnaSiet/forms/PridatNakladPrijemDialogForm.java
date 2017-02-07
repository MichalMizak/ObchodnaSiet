/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.obchodnaSiet.forms;

import java.sql.Date;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.NakladDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrijemDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Naklad;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prijem;
import sk.upjs.ics.paz1c.obchodnaSiet.other.enums.FrameMode;

/**
 *
 * @author Student
 */
public class PridatNakladPrijemDialogForm extends javax.swing.JDialog {

    /**
     * Creates new form PridatNakladPrijemDialogForm
     */
    private FrameMode mode;
    private Long id;
    
    public PridatNakladPrijemDialogForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    PridatNakladPrijemDialogForm(java.awt.Frame parent, boolean modal, FrameMode mode, Long id) {
        super(parent, modal);
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.mode = mode;
        this.id = id;
        if (mode == FrameMode.Naklad){
            nadpisLabel.setText("Náklad");
        }
        if (mode == FrameMode.Prijem){
            nadpisLabel.setText("Príjem");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nadpisLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        popisTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        datumTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        sumaTextField = new javax.swing.JTextField();
        pridatButton = new javax.swing.JButton();
        spatButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        nadpisLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        nadpisLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nadpisLabel.setText("Nadpis");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Popis:");

        popisTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Dátum:");

        datumTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        datumTextField.setToolTipText("Dátum vo formáte rrrr-mm-dd");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Suma:");

        sumaTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        pridatButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pridatButton.setText("Pridať");
        pridatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridatButtonActionPerformed(evt);
            }
        });

        spatButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        spatButton.setText("Späť");
        spatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spatButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nadpisLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sumaTextField)
                            .addComponent(popisTextField)
                            .addComponent(datumTextField, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pridatButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                        .addComponent(spatButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nadpisLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(popisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(datumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(sumaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pridatButton)
                    .addComponent(spatButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void spatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spatButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_spatButtonActionPerformed

    private void pridatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridatButtonActionPerformed
        if (mode == FrameMode.Naklad){
            Naklad naklad = new Naklad();
            naklad.setPopis(popisTextField.getText());
            naklad.setDatum(Date.valueOf(datumTextField.getText()));
            naklad.setSuma(Double.parseDouble(sumaTextField.getText()));
            naklad.setPrevadzkaId(id);
            NakladDao dao = DaoFactory.INSTANCE.getNakladDao();
            dao.pridajNaklad(naklad);
        }
        if (mode == FrameMode.Prijem){
            Prijem prijem = new Prijem();
            prijem.setPopis(popisTextField.getText());
            prijem.setDatum(Date.valueOf(datumTextField.getText()));
            prijem.setProduktId(Long.parseLong(sumaTextField.getText()));
            prijem.setPrevadzkaId(id);
            PrijemDao dao = DaoFactory.INSTANCE.getPrijemDao();
            dao.save(prijem);
        }
        this.dispose();
    }//GEN-LAST:event_pridatButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField datumTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel nadpisLabel;
    private javax.swing.JTextField popisTextField;
    private javax.swing.JButton pridatButton;
    private javax.swing.JButton spatButton;
    private javax.swing.JTextField sumaTextField;
    // End of variables declaration//GEN-END:variables
}
