package sk.upjs.ics.paz1c.obchodnaSiet.forms;

import javax.swing.JOptionPane;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.DodavatelDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.StatnyPoplatokDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.StatnyPoplatok;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;

/**
 *
 * @author Mikey
 */
public class StatnyPoplatokForm extends javax.swing.JFrame {

    private StatnyPoplatok statnyPoplatok;
    private StatnyPoplatokDao statnyPoplatokDao = DaoFactory.INSTANCE.getStatnyPoplatokDao();
    private boolean editMode;

    /**
     * Creates new form StatnyPoplatokForm
     */
    public StatnyPoplatokForm() {
        setUndecorated(true);
        initComponents();
        statnyPoplatok = new StatnyPoplatok();
        editMode = false;
        this.setLocationRelativeTo(null);

    }

    public StatnyPoplatokForm(StatnyPoplatok statnyPoplatok) {
        setUndecorated(true);
        initComponents();
        this.statnyPoplatok = statnyPoplatok;
        editMode = true;
        initTextFields();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        krajinaTextField = new javax.swing.JTextField();
        spLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        percentTextField = new javax.swing.JTextField();
        pridajButton = new javax.swing.JButton();
        spatButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Krajina:");

        krajinaTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        spLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        spLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        spLabel.setText("Pridať štátny poplatok");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Poplatok v % :");

        percentTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        pridajButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pridajButton.setText("Pridať");
        pridajButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridajButtonActionPerformed(evt);
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
                    .addComponent(spLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pridajButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spatButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(krajinaTextField)
                            .addComponent(percentTextField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(krajinaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(percentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pridajButton)
                    .addComponent(spatButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void spatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spatButtonActionPerformed
        DodavatelDao dodavatelDao = DaoFactory.INSTANCE.getDodavatelDao();
        new DodavatelForm(dodavatelDao.getDodavatelia()).setVisible(true);
        dispose();
    }//GEN-LAST:event_spatButtonActionPerformed

    private void pridajButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridajButtonActionPerformed
        double percent = 0;
        try {
            percent = Double.parseDouble(percentTextField.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Upravte pole poplatok");
        }

        statnyPoplatok.setPercent(percent);
        statnyPoplatok.setKrajina(krajinaTextField.getText());

        statnyPoplatokDao.saveOrEdit(statnyPoplatok);

        spatButtonActionPerformed(null);
    }//GEN-LAST:event_pridajButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField krajinaTextField;
    private javax.swing.JTextField percentTextField;
    private javax.swing.JButton pridajButton;
    private javax.swing.JLabel spLabel;
    private javax.swing.JButton spatButton;
    // End of variables declaration//GEN-END:variables

    private void initTextFields() {
        krajinaTextField.setText(statnyPoplatok.getKrajina());
        percentTextField.setText((Double.toString(statnyPoplatok.getPercent())));
        pridajButton.setText("Upraviť");
        spLabel.setText("Upraviť štátny poplatok");
    }
}