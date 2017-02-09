package sk.upjs.ics.paz1c.obchodnaSiet.forms;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktDao;
import sk.upjs.ics.paz1c.obchodnaSiet.dao.interfaces.ProduktNaPredajniDao;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Prevadzka;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.Produkt;
import sk.upjs.ics.paz1c.obchodnaSiet.entity.ProduktNaPredajni;
import sk.upjs.ics.paz1c.obchodnaSiet.model.PrevadzkaComboBoxModel;
import sk.upjs.ics.paz1c.obchodnaSiet.model.ProduktTableModel;
import sk.upjs.ics.paz1c.obchodnaSiet.other.DaoFactory;

public class ZoznamProduktyForm extends javax.swing.JFrame {

    private static final String OZNACTE_PRODUKT_MESSAGE = "Označte produkt";

    private List<Produkt> produkty;
    private ProduktDao produktDao = DaoFactory.INSTANCE.getProduktDao();

    private List<ProduktNaPredajni> pnps;
    private ProduktNaPredajniDao pnpDao = DaoFactory.INSTANCE.getProduktNaPredajniDao();

    public ZoznamProduktyForm(List<Produkt> produkty) {
        initComponents();
        this.produkty = produkty;
        init();
    }
    
     private void init() {
        setLocationRelativeTo(null);
         refreshProduktModel();
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
        jLabel1 = new javax.swing.JLabel();
        pridatProduktNaPredajnuButton = new javax.swing.JButton();
        pridatProduktButton = new javax.swing.JButton();
        spatButton = new javax.swing.JButton();
        odobratProduktButton = new javax.swing.JButton();
        upravitProduktButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        produktTable = new javax.swing.JTable();
        vsetkyPrevadzkyToggleButton = new javax.swing.JToggleButton();
        jednaPrevadzkaToggleButton = new javax.swing.JToggleButton();
        prevadzkyComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Produkty");

        pridatProduktNaPredajnuButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pridatProduktNaPredajnuButton.setText("Pridať produkt na prevádzku");
        pridatProduktNaPredajnuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridatProduktNaPredajnuButtonActionPerformed(evt);
            }
        });

        pridatProduktButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        pridatProduktButton.setText("Pridať produkt");
        pridatProduktButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pridatProduktButtonActionPerformed(evt);
            }
        });

        spatButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        spatButton.setText("Späť");
        spatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spatButtonActionPerformed(evt);
            }
        });

        odobratProduktButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        odobratProduktButton.setText("Odobrať produkt");
        odobratProduktButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odobratProduktButtonActionPerformed(evt);
            }
        });

        upravitProduktButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        upravitProduktButton.setText("Upraviť produkt");
        upravitProduktButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upravitProduktButtonActionPerformed(evt);
            }
        });

        produktTable.setModel(new ProduktTableModel(produkty, null));
        jScrollPane2.setViewportView(produktTable);

        vsetkyPrevadzkyToggleButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        vsetkyPrevadzkyToggleButton.setText("Typy produktov");
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
                            .addComponent(pridatProduktButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(odobratProduktButton, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(upravitProduktButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spatButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(pridatProduktNaPredajnuButton, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vsetkyPrevadzkyToggleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jednaPrevadzkaToggleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prevadzkyComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vsetkyPrevadzkyToggleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prevadzkyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jednaPrevadzkaToggleButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pridatProduktButton)
                    .addComponent(pridatProduktNaPredajnuButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spatButton)
                    .addComponent(odobratProduktButton)
                    .addComponent(upravitProduktButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void spatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spatButtonActionPerformed
        new HlavneOknoForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_spatButtonActionPerformed

    private void pridatProduktButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridatProduktButtonActionPerformed
        new ProduktForm(produkty).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pridatProduktButtonActionPerformed

    private void odobratProduktButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odobratProduktButtonActionPerformed
        Produkt produkt = getSelectedProdukt();
        if (produkt == null) {
            JOptionPane.showMessageDialog(this, OZNACTE_PRODUKT_MESSAGE);
            return;
        }
        //new OdobratProduktDialogForm(this, true, produkt).setVisible(true);
        produktDao.delete(produkt.getId());
        produkty = produktDao.getProdukty();

        refreshProduktModel();
    }//GEN-LAST:event_odobratProduktButtonActionPerformed

    private void pridatProduktNaPredajnuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pridatProduktNaPredajnuButtonActionPerformed
        new PridatProduktNaPrevadzkuForm(produkty).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pridatProduktNaPredajnuButtonActionPerformed

    private void upravitProduktButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upravitProduktButtonActionPerformed
        Produkt produkt = getSelectedProdukt();
        if (produkt == null) {
            JOptionPane.showMessageDialog(this, OZNACTE_PRODUKT_MESSAGE);
            return;
        }
        new ProduktForm(produkty, produkt).setVisible(true);
        dispose();
    }//GEN-LAST:event_upravitProduktButtonActionPerformed

    private void vsetkyPrevadzkyToggleButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vsetkyPrevadzkyToggleButtonMousePressed

        jednaPrevadzkaToggleButton.setSelected(false);
        //vsetkyPrevadzkyToggleButton.setSelected(true);
        getPrevadzkyComboBoxModel().sleep();

        pnps = null;
        produkty = produktDao.getProdukty();
        
        getProduktTableModel().refresh(produkty, pnps);
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
        produkty = null;
        pnps = pnpDao.getByPrevadzka(selectedPrevadzka.getId());

        refreshProduktModel();
    }//GEN-LAST:event_jednaPrevadzkaToggleButtonMousePressed

    private void prevadzkyComboBoxMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prevadzkyComboBoxMousePressed

    }//GEN-LAST:event_prevadzkyComboBoxMousePressed

    private void prevadzkyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevadzkyComboBoxActionPerformed
        Prevadzka selectedPrevadzka = (Prevadzka) prevadzkyComboBox.getSelectedItem();
        if (selectedPrevadzka == null) {
            if (produkty == null) {
                pnps = null;
                produkty = produktDao.getProdukty();
            }
            // zamestnanci = zamestnanecDao.getZamestnanci();
        } else {
            produkty = null;
            pnps = pnpDao.getByPrevadzka(selectedPrevadzka.getId());
        }
        refreshProduktModel();

    }//GEN-LAST:event_prevadzkyComboBoxActionPerformed

    private void prevadzkyComboBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_prevadzkyComboBoxPropertyChange

    }//GEN-LAST:event_prevadzkyComboBoxPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jednaPrevadzkaToggleButton;
    private javax.swing.ButtonGroup moznostiZobrazeniaButtonGroup;
    private javax.swing.JButton odobratProduktButton;
    private javax.swing.JComboBox<Prevadzka> prevadzkyComboBox;
    private javax.swing.JButton pridatProduktButton;
    private javax.swing.JButton pridatProduktNaPredajnuButton;
    private javax.swing.JTable produktTable;
    private javax.swing.JButton spatButton;
    private javax.swing.JButton upravitProduktButton;
    private javax.swing.JToggleButton vsetkyPrevadzkyToggleButton;
    // End of variables declaration//GEN-END:variables

    private Produkt getSelectedProdukt() {
        int selectedRow = produktTable.getSelectedRow();
        if (selectedRow == -1) {
            return null;
        } else {
            return getProduktTableModel().getItemAt(selectedRow);
        }
    }

    private void refreshProduktModel() {
        ProduktTableModel model = getProduktTableModel();
        model.refresh(produkty, pnps);
    }

    private ProduktTableModel getProduktTableModel() {
        return (ProduktTableModel) produktTable.getModel();
    }

    private PrevadzkaComboBoxModel getPrevadzkyComboBoxModel() {
        return (PrevadzkaComboBoxModel) prevadzkyComboBox.getModel();
    }
}
