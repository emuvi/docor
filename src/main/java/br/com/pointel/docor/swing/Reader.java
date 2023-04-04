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
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane scrollMain;
    private javax.swing.JTextArea textMain;
    // End of variables declaration//GEN-END:variables
}
