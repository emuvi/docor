package br.com.pointel.docor.swing;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class MarkerCaptureImage extends javax.swing.JFrame {

    private final Marker create;
    
    private boolean confirmed = true;
    private BufferedImage image = null;

    public MarkerCaptureImage(Marker from, BufferedImage image, String name) {
        this.create = from;
        this.image = image;
        initComponents();
        setLocationRelativeTo(from);
        if (name != null) {
            edtName.setText(name);
        }
        labMain.setIcon(new ImageIcon(image));
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public BufferedImage getImage() {
        return this.image;
    }
    
    public void updateDescription(String text) {
        this.edtDescription.setText(text);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrMain = new javax.swing.JScrollPane();
        labMain = new javax.swing.JLabel();
        panUpper = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        edtName = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        edtDescription = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Marker Capture Image");
        setPreferredSize(new java.awt.Dimension(700, 600));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnShortcutKeyPressed(evt);
            }
        });

        labMain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scrMain.setViewportView(labMain);

        panUpper.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnShortcutKeyPressed(evt);
            }
        });

        btnCancel.setMnemonic('X');
        btnCancel.setText("X");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        btnCancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnShortcutKeyPressed(evt);
            }
        });

        edtName.setText("name");

        btnConfirm.setMnemonic('C');
        btnConfirm.setText("C");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        edtDescription.setText("Image");

        javax.swing.GroupLayout panUpperLayout = new javax.swing.GroupLayout(panUpper);
        panUpper.setLayout(panUpperLayout);
        panUpperLayout.setHorizontalGroup(
            panUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panUpperLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(edtName, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addContainerGap())
        );
        panUpperLayout.setVerticalGroup(
            panUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panUpperLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(edtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirm)
                    .addComponent(edtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panUpper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrMain)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panUpper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrMain, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        confirmed = false;
        finished();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnShortcutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnShortcutKeyPressed
        switch (evt.getKeyChar()) {
            case 'c', 'C' -> btnConfirmActionPerformed(null);
            case 'x', 'X' -> btnCancelActionPerformed(null);
        }
    }//GEN-LAST:event_btnShortcutKeyPressed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        confirmed = true;
        finished();
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void finished() {
        if (isConfirmed()) {
            create.addImage(image, edtName.getText(), edtDescription.getText());
        }
        create.closedCaptureImage();
        setVisible(false);
    }
    
    public void updateImage(BufferedImage image) {
        this.image = image;
        labMain.setIcon(new ImageIcon(image));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JTextField edtDescription;
    private javax.swing.JTextField edtName;
    private javax.swing.JLabel labMain;
    private javax.swing.JPanel panUpper;
    private javax.swing.JScrollPane scrMain;
    // End of variables declaration//GEN-END:variables

}
