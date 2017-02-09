package sk.upjs.ics.paz1c.obchodnaSiet.forms;

import java.util.List;
import javax.swing.JOptionPane;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.NakladNaProduktyDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.PrijemDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prevadzka;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.NakladNaProdukty;
import sk.upjs.ics.paz1c.obchodnaSiet.model.NakladNaProduktyTableModel;
import sk.upjs.ics.paz1c.obchodnaSiet.model.PrevadzkaComboBoxModel;
import sk.upjs.ics.paz1c.obchodnaSiet.model.PrijemTableModel;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;
import sk.upjs.ics.paz1c.obchodnaSiet.other.enums.FrameMode;

/**
 *
 * @author Mikey
 */
public class ZoznamNakladNaProduktyForm extends javax.swing.JFrame {

   private static final String OZNACTE_NAKLAD_MESSAGE = "Označte náklad";

    private List<NakladNaProdukty> naklady;
    private NakladNaProduktyDao prijemDao = DaoFactory.INSTANCE.getNakladNaProduktyDao();
        
    public ZoznamNakladNaProduktyForm() {
        setUndecorated(true);
        initComponents();
        this.naklady = prijemDao.getPrijmy();
        init();
    }

    private void init() {
        setLocationRelativeTo(null);
        refreshZamestnanecTableModel();
        vsetkyPrevadzkyToggleButton.setSelected(true);
        getPrevadzkyComboBoxModel().sleep();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        vsetkyPrevadzkyToggleButton = new javax.swing.JToggleButton();
        jednaPrevadzkaToggleButton = new javax.swing.JToggleButton();
        prevadzkyComboBox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        prijemTable = new javax.swing.JTable();
        pridatZamestnancaButton = new javax.swing.JButton();
        odobratZamestnancaButton = new javax.swing.JButton();
        upravitZamestnancaButton = new javax.swing.JButton();
        spatButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Náklady");

        vsetkyPrevadzkyToggleButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        vsetkyPrevadzkyToggleButton.setText("Všetky prevádzky");
        vsetkyPrevadzkyToggleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                vsetkyPrevadzkyToggleButtonMousePressed(evt);
            }
        });
        vsetkyPrevadzkyToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vsetkyPrevadzkyToggleButtonActionPerformed(evt);
            }
        });

        jednaPrevadzkaToggleButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jednaPrevadzkaToggleButton.setText("Podľa prevádzky");
        jednaPrevadzkaToggleButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jednaPrevadzkaToggleButtonMousePressed(evt);
            }
        });

        prevadzkyComboBox.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        prevadzkyComboBox.setModel(new sk.upjs.ics.paz1c.obchodnaSiet.model.PrevadzkaComboBoxModel());
        prevadzkyComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                prevadzkyComboBoxMousePressed(evt);
            }
        });
        prevadzkyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevadzkyComboBoxActionPerformed(evt);
            }
        });
        prevadzkyComboBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                prevadzkyComboBoxPropertyChange(evt);
            }
        });

        prijemTable.setModel(new NakladNaProduktyTableModel(naklady));
        jScrollPane2.setViewportView(prijemTable);

        pridatZamestnancaButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pridatZamestnancaButton.setText("Pridať náklad");
        pridatZamestnancaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridatZamestnancaButtonActionPerformed(evt);
            }
        });

        odobratZamestnancaButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        odobratZamestnancaButton.setText("Odobrať náklad");
        odobratZamestnancaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odobratZamestnancaButtonActionPerformed(evt);
            }
        });

        upravitZamestnancaButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        upravitZamestnancaButton.setText("Upraviť náklad");
        upravitZamestnancaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upravitZamestnancaButtonActionPerformed(evt);
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
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vsetkyPrevadzkyToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jednaPrevadzkaToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prevadzkyComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pridatZamestnancaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(odobratZamestnancaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(upravitZamestnancaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spatButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vsetkyPrevadzkyToggleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prevadzkyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jednaPrevadzkaToggleButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pridatZamestnancaButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spatButton)
                    .addComponent(odobratZamestnancaButton)
                    .addComponent(upravitZamestnancaButton))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vsetkyPrevadzkyToggleButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vsetkyPrevadzkyToggleButtonMousePressed

        jednaPrevadzkaToggleButton.setSelected(false);
        //vsetkyPrevadzkyToggleButton.setSelected(true);
        getPrevadzkyComboBoxModel().sleep();

        naklady = prijemDao.getPrijmy();
        getPrijemTableModel().refresh(naklady);
    }//GEN-LAST:event_vsetkyPrevadzkyToggleButtonMousePressed

    private void vsetkyPrevadzkyToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vsetkyPrevadzkyToggleButtonActionPerformed

    }//GEN-LAST:event_vsetkyPrevadzkyToggleButtonActionPerformed

    private void jednaPrevadzkaToggleButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jednaPrevadzkaToggleButtonMousePressed
        vsetkyPrevadzkyToggleButton.setSelected(false);
        //jednaPrevadzkaToggleButton.set
        getPrevadzkyComboBoxModel().refresh();

        Prevadzka selectedPrevadzka = (Prevadzka) prevadzkyComboBox.getSelectedItem();
        if (selectedPrevadzka == null) {
            vsetkyPrevadzkyToggleButtonMousePressed(evt);
            return;
        }
        naklady = prijemDao.getPrijmyByPrevadzka((selectedPrevadzka).getId());
        getPrijemTableModel().refresh(naklady);
    }//GEN-LAST:event_jednaPrevadzkaToggleButtonMousePressed

    private void prevadzkyComboBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prevadzkyComboBoxMousePressed

    }//GEN-LAST:event_prevadzkyComboBoxMousePressed

    private void prevadzkyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevadzkyComboBoxActionPerformed
        Prevadzka selectedPrevadzka = (Prevadzka) prevadzkyComboBox.getSelectedItem();
        if (selectedPrevadzka == null) {
            return;
            // zamestnanci = zamestnanecDao.getZamestnanci();
        } else {
            naklady = prijemDao.getPrijmyByPrevadzka((selectedPrevadzka).getId());
        }
        getPrijemTableModel().refresh(naklady);
    }//GEN-LAST:event_prevadzkyComboBoxActionPerformed

    private void prevadzkyComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_prevadzkyComboBoxPropertyChange

    }//GEN-LAST:event_prevadzkyComboBoxPropertyChange

    private void pridatZamestnancaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridatZamestnancaButtonActionPerformed
        new PrijemNakladNaProduktyForm(naklady, FrameMode.Naklad).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pridatZamestnancaButtonActionPerformed

    private void odobratZamestnancaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odobratZamestnancaButtonActionPerformed
        NakladNaProdukty prijem = getSelectedPrijem();
        if (prijem == null) {
            JOptionPane.showMessageDialog(this, OZNACTE_NAKLAD_MESSAGE);
            return;
        }
        prijemDao.delete(prijem);
        //  new OdobratZamestnancaDialogForm(this, true, prijem.getId()).setVisible(true);
        refreshZamestnanecListModel();
    }//GEN-LAST:event_odobratZamestnancaButtonActionPerformed

    private void upravitZamestnancaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upravitZamestnancaButtonActionPerformed
        NakladNaProdukty prijem = getSelectedPrijem();
        if (prijem == null) {
            JOptionPane.showMessageDialog(this, OZNACTE_NAKLAD_MESSAGE);
            return;
        }
        new PrijemNakladNaProduktyForm(naklady, prijem, FrameMode.Naklad).setVisible(true);
        dispose();
    }//GEN-LAST:event_upravitZamestnancaButtonActionPerformed

    private void spatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spatButtonActionPerformed
        new ZoznamPrevadzkyForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_spatButtonActionPerformed


      private PrevadzkaComboBoxModel getPrevadzkyComboBoxModel() {
        return (PrevadzkaComboBoxModel) prevadzkyComboBox.getModel();
    }

      private NakladNaProduktyTableModel getPrijemTableModel() {
        return (NakladNaProduktyTableModel) prijemTable.getModel();
    }
      
       private NakladNaProdukty getSelectedPrijem() {
        int selectedRow = prijemTable.getSelectedRow();
        if (selectedRow == -1) {
            return null;
        } else {
            return getPrijemTableModel().getItemAt(selectedRow);
        }
    }

    private void refreshZamestnanecTableModel() {
        NakladNaProduktyTableModel model = getPrijemTableModel();
        model.refresh(naklady);
    }

    private void refreshZamestnanecListModel() {
        NakladNaProduktyTableModel model = getPrijemTableModel();
        model.refresh(naklady);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jednaPrevadzkaToggleButton;
    private javax.swing.JButton odobratZamestnancaButton;
    private javax.swing.JComboBox<Prevadzka> prevadzkyComboBox;
    private javax.swing.JButton pridatZamestnancaButton;
    private javax.swing.JTable prijemTable;
    private javax.swing.JButton spatButton;
    private javax.swing.JButton upravitZamestnancaButton;
    private javax.swing.JToggleButton vsetkyPrevadzkyToggleButton;
    // End of variables declaration//GEN-END:variables
}
