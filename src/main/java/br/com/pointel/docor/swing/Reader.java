package br.com.pointel.docor.swing;

import javax.swing.JFrame;

public class Reader extends javax.swing.JFrame {

    public Reader(JFrame from, String text) {
        initComponents();
        setLocationRelativeTo(from);
        textMain.setText(text);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollMain = new javax.swing.JScrollPane();
        textMain = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reader");

        textMain.setEditable(false);
        textMain.setColumns(20);
        textMain.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        textMain.setLineWrap(true);
        textMain.setRows(5);
        textMain.setWrapStyleWord(true);
        textMain.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textMainKeyPressed(evt);
            }
        });
        scrollMain.setViewportView(textMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollMain, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollMain, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textMainKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMainKeyPressed
        switch (evt.getKeyChar()) {
            case 'A', 'a' -> buttonSelectAllActionPerformed(null);
            case 'R', 'r' -> buttonSpeedReaderActionPerformed(null);
            case 'X', 'x' -> buttonCloseActionPerformed(null);
        }
    }//GEN-LAST:event_textMainKeyPressed
    
    private void buttonSpeedReaderActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        var selected = textMain.getSelectedText();
        if (selected == null || selected.isBlank()) {
            selected = textMain.getText();
        }
        new ReaderSpeed(this, selected).setVisible(true);
    }   
    
    private void buttonSelectAllActionPerformed(java.awt.event.ActionEvent evt) {                                                
        textMain.selectAll();
    }        
    
     private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {                                            
        setVisible(false);
        dispose();
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollMain;
    private javax.swing.JTextArea textMain;
    // End of variables declaration//GEN-END:variables
}
