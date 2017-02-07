package sk.upjs.ics.paz1c.obchodnaSiet.forms;

import java.util.List;
import javax.swing.JOptionPane;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ZamestnanecDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prevadzka;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Zamestnanec;
import sk.upjs.ics.paz1c.obchodnaSiet.model.PrevadzkyComboBoxModel;
import sk.upjs.ics.paz1c.obchodnaSiet.model.ZamestnanecTableModel;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;

public class ZoznamZamestnanciForm extends javax.swing.JFrame {

    private static final String OZNACTE_ZAMESTNANCA_MESSAGE = "Označte zamestnanca";

    private List<Zamestnanec> zamestnanci;
    private ZamestnanecDao zamestnanecDao = DaoFactory.INSTANCE.getZamestnanecDao();

    public ZoznamZamestnanciForm(List<Zamestnanec> zamestnanci) {
        initComponents();
        this.zamestnanci = zamestnanci;

        init();
    }

    public ZoznamZamestnanciForm() {
        initComponents();
        this.zamestnanci = zamestnanecDao.getZamestnanci();

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

        moznostiZobrazeniaButtonGroup = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        pridatZamestnancaNaPrevadzkuButton = new javax.swing.JButton();
        pridatZamestnancaButton = new javax.swing.JButton();
        prevadzkyComboBox = new javax.swing.JComboBox<>();
        spatButton = new javax.swing.JButton();
        odobratZamestnancaButton = new javax.swing.JButton();
        upravitZamestnancaButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        zamestnanecTable = new javax.swing.JTable();
        vsetkyPrevadzkyToggleButton = new javax.swing.JToggleButton();
        jednaPrevadzkaToggleButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Zamestnanci");

        pridatZamestnancaNaPrevadzkuButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pridatZamestnancaNaPrevadzkuButton.setText("Pridať zamestnanca na prevádzku");
        pridatZamestnancaNaPrevadzkuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridatZamestnancaNaPrevadzkuButtonActionPerformed(evt);
            }
        });

        pridatZamestnancaButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pridatZamestnancaButton.setText("Pridať zamestnanca");
        pridatZamestnancaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridatZamestnancaButtonActionPerformed(evt);
            }
        });

        prevadzkyComboBox.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        prevadzkyComboBox.setModel(new sk.upjs.ics.paz1c.obchodnaSiet.model.PrevadzkyComboBoxModel());
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

        spatButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        spatButton.setText("Späť");
        spatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spatButtonActionPerformed(evt);
            }
        });

        odobratZamestnancaButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        odobratZamestnancaButton.setText("Odobrať zamestnanca");
        odobratZamestnancaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odobratZamestnancaButtonActionPerformed(evt);
            }
        });

        upravitZamestnancaButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        upravitZamestnancaButton.setText("Upraviť zamestnanca");
        upravitZamestnancaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upravitZamestnancaButtonActionPerformed(evt);
            }
        });

        zamestnanecTable.setModel(new ZamestnanecTableModel(zamestnanci));
        jScrollPane2.setViewportView(zamestnanecTable);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pridatZamestnancaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(odobratZamestnancaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(upravitZamestnancaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spatButton))
                            .addComponent(pridatZamestnancaNaPrevadzkuButton, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vsetkyPrevadzkyToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jednaPrevadzkaToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prevadzkyComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pridatZamestnancaButton)
                    .addComponent(pridatZamestnancaNaPrevadzkuButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spatButton)
                    .addComponent(odobratZamestnancaButton)
                    .addComponent(upravitZamestnancaButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pridatZamestnancaNaPrevadzkuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridatZamestnancaNaPrevadzkuButtonActionPerformed
        new PridatZamestnancaNaPrevadzkuForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pridatZamestnancaNaPrevadzkuButtonActionPerformed

    private void pridatZamestnancaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridatZamestnancaButtonActionPerformed
        new ZamestnanecForm(zamestnanci).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pridatZamestnancaButtonActionPerformed

    private void spatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spatButtonActionPerformed
        new HlavneOknoForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_spatButtonActionPerformed

    private void odobratZamestnancaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odobratZamestnancaButtonActionPerformed
        Zamestnanec zamestnanec = getSelectedZamestnanec();
        if (zamestnanec == null) {
            JOptionPane.showMessageDialog(this, OZNACTE_ZAMESTNANCA_MESSAGE);
            return;
        }
        new OdobratZamestnancaDialogForm(this, true, zamestnanec.getId()).setVisible(true);
        refreshZamestnanecListModel();
    }//GEN-LAST:event_odobratZamestnancaButtonActionPerformed

    private void upravitZamestnancaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upravitZamestnancaButtonActionPerformed
        Zamestnanec zamestnanec = getSelectedZamestnanec();
        if (zamestnanec == null) {
            JOptionPane.showMessageDialog(this, OZNACTE_ZAMESTNANCA_MESSAGE);
            return;
        }
        new ZamestnanecForm(zamestnanci, zamestnanec).setVisible(true);
        dispose();
    }//GEN-LAST:event_upravitZamestnancaButtonActionPerformed

    private void vsetkyPrevadzkyToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vsetkyPrevadzkyToggleButtonActionPerformed

    }//GEN-LAST:event_vsetkyPrevadzkyToggleButtonActionPerformed

    private void vsetkyPrevadzkyToggleButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vsetkyPrevadzkyToggleButtonMousePressed

        jednaPrevadzkaToggleButton.setSelected(false);
        //vsetkyPrevadzkyToggleButton.setSelected(true);
        getPrevadzkyComboBoxModel().sleep();

        zamestnanci = zamestnanecDao.getZamestnanci();
        getZamestnanecTableModel().refresh(zamestnanci);
    }//GEN-LAST:event_vsetkyPrevadzkyToggleButtonMousePressed


    private void jednaPrevadzkaToggleButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jednaPrevadzkaToggleButtonMousePressed
        vsetkyPrevadzkyToggleButton.setSelected(false);
        //jednaPrevadzkaToggleButton.set
        getPrevadzkyComboBoxModel().refresh();

        Prevadzka selectedPrevadzka = (Prevadzka) prevadzkyComboBox.getSelectedItem();
        if (selectedPrevadzka == null) {
            vsetkyPrevadzkyToggleButtonMousePressed(evt);
            return;
        }
        zamestnanci = zamestnanecDao.getZamestnanecByPrevadzka((selectedPrevadzka).getId());
        getZamestnanecTableModel().refresh(zamestnanci);
    }//GEN-LAST:event_jednaPrevadzkaToggleButtonMousePressed

    private void prevadzkyComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_prevadzkyComboBoxPropertyChange


    }//GEN-LAST:event_prevadzkyComboBoxPropertyChange

    private void prevadzkyComboBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prevadzkyComboBoxMousePressed

    }//GEN-LAST:event_prevadzkyComboBoxMousePressed

    private void prevadzkyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevadzkyComboBoxActionPerformed
        Prevadzka selectedPrevadzka = (Prevadzka) prevadzkyComboBox.getSelectedItem();
        if (selectedPrevadzka == null) {
            return;
            // zamestnanci = zamestnanecDao.getZamestnanci();
        } else {
            zamestnanci = zamestnanecDao.getZamestnanecByPrevadzka((selectedPrevadzka).getId());
        }
        getZamestnanecTableModel().refresh(zamestnanci);
    }//GEN-LAST:event_prevadzkyComboBoxActionPerformed

    private PrevadzkyComboBoxModel getPrevadzkyComboBoxModel() {
        return (PrevadzkyComboBoxModel) prevadzkyComboBox.getModel();
    }

    private Zamestnanec getSelectedZamestnanec() {
        int selectedRow = zamestnanecTable.getSelectedRow();
        if (selectedRow == -1) {
            return null;
        } else {
            return getZamestnanecTableModel().getItemAt(selectedRow);
        }
    }

    private void refreshZamestnanecTableModel() {
        ZamestnanecTableModel model = getZamestnanecTableModel();
        model.refresh(zamestnanci);
    }

    private void refreshZamestnanecListModel() {
        ZamestnanecTableModel model = getZamestnanecTableModel();
        model.refresh(zamestnanci);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jednaPrevadzkaToggleButton;
    private javax.swing.ButtonGroup moznostiZobrazeniaButtonGroup;
    private javax.swing.JButton odobratZamestnancaButton;
    private javax.swing.JComboBox<Prevadzka> prevadzkyComboBox;
    private javax.swing.JButton pridatZamestnancaButton;
    private javax.swing.JButton pridatZamestnancaNaPrevadzkuButton;
    private javax.swing.JButton spatButton;
    private javax.swing.JButton upravitZamestnancaButton;
    private javax.swing.JToggleButton vsetkyPrevadzkyToggleButton;
    private javax.swing.JTable zamestnanecTable;
    // End of variables declaration//GEN-END:variables

    private ZamestnanecTableModel getZamestnanecTableModel() {
        return (ZamestnanecTableModel) zamestnanecTable.getModel();
    }
}