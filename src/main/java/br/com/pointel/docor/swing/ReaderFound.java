package br.com.pointel.docor.swing;

import br.com.pointel.docor.Found;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ReaderFound extends javax.swing.JFrame {

    private final Found found;
    
    private int starIndex = 0;
    private int meetIndex = 0;
    
    public ReaderFound(JFrame from, Found found, String text) {
        initComponents();
        setLocationRelativeTo(from);
        this.found = found;
        textMain.setText(text);
        find();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollMain = new javax.swing.JScrollPane();
        textMain = new javax.swing.JTextArea();
        panelUpper = new javax.swing.JPanel();
        buttonPriorStar = new javax.swing.JButton();
        buttonPriorMeet = new javax.swing.JButton();
        buttonNextMeet = new javax.swing.JButton();
        buttonNextStar = new javax.swing.JButton();
        buttonClose = new javax.swing.JButton();

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

        buttonPriorStar.setMnemonic('{');
            buttonPriorStar.setText("{");
            buttonPriorStar.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonPriorStarActionPerformed(evt);
                }
            });

            buttonPriorMeet.setMnemonic('[');
            buttonPriorMeet.setText("[");
            buttonPriorMeet.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonPriorMeetActionPerformed(evt);
                }
            });

            buttonNextMeet.setMnemonic(']');
            buttonNextMeet.setText("]");
            buttonNextMeet.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    buttonNextMeetActionPerformed(evt);
                }
            });

            buttonNextStar.setMnemonic('}');
        buttonNextStar.setText("}");
        buttonNextStar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextStarActionPerformed(evt);
            }
        });

        buttonClose.setMnemonic('X');
        buttonClose.setText("X");
        buttonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelUpperLayout = new javax.swing.GroupLayout(panelUpper);
        panelUpper.setLayout(panelUpperLayout);
        panelUpperLayout.setHorizontalGroup(
            panelUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUpperLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonPriorStar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPriorMeet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonNextMeet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonNextStar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonClose)
                .addContainerGap())
        );
        panelUpperLayout.setVerticalGroup(
            panelUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUpperLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPriorStar)
                    .addComponent(buttonPriorMeet)
                    .addComponent(buttonNextMeet)
                    .addComponent(buttonNextStar)
                    .addComponent(buttonClose))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollMain, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addComponent(panelUpper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelUpper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollMain, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPriorStarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPriorStarActionPerformed
        if (starIndex == 0) {
            return;
        }
        starIndex--;
        meetIndex = found.getStars().get(starIndex).meets().size() -1;
        find();
    }//GEN-LAST:event_buttonPriorStarActionPerformed

    private void buttonPriorMeetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPriorMeetActionPerformed
        if (meetIndex == 0) {
            buttonPriorStarActionPerformed(evt);
            return;
        }
        meetIndex--;
        find();
    }//GEN-LAST:event_buttonPriorMeetActionPerformed

    private void buttonNextMeetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextMeetActionPerformed
        if (meetIndex == found.getStars().get(starIndex).meets().size() -1) {
            buttonNextStarActionPerformed(evt);
            return;
        }
        meetIndex++;
        find();
    }//GEN-LAST:event_buttonNextMeetActionPerformed

    private void buttonNextStarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextStarActionPerformed
        if (starIndex == found.getStars().size() -1) {
            return;
        }
        starIndex++;
        meetIndex = 0;
        find();
    }//GEN-LAST:event_buttonNextStarActionPerformed

    private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_buttonCloseActionPerformed

    private void textMainKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textMainKeyPressed
        switch (evt.getKeyChar()) {
            case '{' -> buttonPriorStarActionPerformed(null);
            case '[' -> buttonPriorMeetActionPerformed(null);
            case ']' -> buttonNextMeetActionPerformed(null);
            case '}' -> buttonNextStarActionPerformed(null);
            case 'X', 'x' -> buttonCloseActionPerformed(null);
        }
    }//GEN-LAST:event_textMainKeyPressed
    
    private void find() {
        var selected = found.getStars().get(starIndex).meets().get(meetIndex).part.getText().trim();
        var position = textMain.getText().indexOf(selected);
        if (position > -1) {
            textMain.setSelectionStart(position);
            textMain.setSelectionEnd(position + selected.length());
            textMain.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Could not find: " + selected);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonClose;
    private javax.swing.JButton buttonNextMeet;
    private javax.swing.JButton buttonNextStar;
    private javax.swing.JButton buttonPriorMeet;
    private javax.swing.JButton buttonPriorStar;
    private javax.swing.JPanel panelUpper;
    private javax.swing.JScrollPane scrollMain;
    private javax.swing.JTextArea textMain;
    // End of variables declaration//GEN-END:variables
}
