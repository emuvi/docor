package br.com.pointel.docor.swing;

import br.com.pointel.docor.Kindred;

public class MarkerCaptureText extends javax.swing.JFrame {

    private final Marker create;
    
    private boolean confirmed = true;
    private Kindred kind = Kindred.PARAGRAPH;

    public MarkerCaptureText(Marker from, String text) {
        this.create = from;
        initComponents();
        setLocationRelativeTo(from);
        textMain.setText(text);
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public Kindred getKindred() {
        return kind;
    }

    public String getText() {
        return textMain.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panUpper = new javax.swing.JPanel();
        buttonTitle = new javax.swing.JButton();
        buttonSubtitle = new javax.swing.JButton();
        buttonDivision = new javax.swing.JButton();
        buttonParagraph = new javax.swing.JButton();
        btnItalic = new javax.swing.JButton();
        btnBold = new javax.swing.JButton();
        btnListItem = new javax.swing.JButton();
        btnNumberItem = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnAppend = new javax.swing.JButton();
        scrollMain = new javax.swing.JScrollPane();
        textMain = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Marker Capture Text");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnShortcutKeyPressed(evt);
            }
        });

        panUpper.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnShortcutKeyPressed(evt);
            }
        });

        buttonTitle.setMnemonic('T');
        buttonTitle.setText("T");
        buttonTitle.setToolTipText("Title");
        buttonTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTitleActionPerformed(evt);
            }
        });
        buttonTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnShortcutKeyPressed(evt);
            }
        });

        buttonSubtitle.setMnemonic('S');
        buttonSubtitle.setText("S");
        buttonSubtitle.setToolTipText("Subtitle");
        buttonSubtitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSubtitleActionPerformed(evt);
            }
        });
        buttonSubtitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnShortcutKeyPressed(evt);
            }
        });

        buttonDivision.setMnemonic('D');
        buttonDivision.setText("D");
        buttonDivision.setToolTipText("Division");
        buttonDivision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDivisionActionPerformed(evt);
            }
        });
        buttonDivision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnShortcutKeyPressed(evt);
            }
        });

        buttonParagraph.setMnemonic('P');
        buttonParagraph.setText("P");
        buttonParagraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonParagraphActionPerformed(evt);
            }
        });
        buttonParagraph.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnShortcutKeyPressed(evt);
            }
        });

        btnItalic.setMnemonic('I');
        btnItalic.setText("I");
        btnItalic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItalicActionPerformed(evt);
            }
        });
        btnItalic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnShortcutKeyPressed(evt);
            }
        });

        btnBold.setMnemonic('B');
        btnBold.setText("B");
        btnBold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoldActionPerformed(evt);
            }
        });
        btnBold.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnShortcutKeyPressed(evt);
            }
        });

        btnListItem.setMnemonic('*');
        btnListItem.setText("*");
        btnListItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListItemActionPerformed(evt);
            }
        });
        btnListItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnShortcutKeyPressed(evt);
            }
        });

        btnNumberItem.setMnemonic('+');
        btnNumberItem.setText("+");
        btnNumberItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumberItemActionPerformed(evt);
            }
        });
        btnNumberItem.addKeyListener(new java.awt.event.KeyAdapter() {
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

        btnAppend.setMnemonic('A');
        btnAppend.setText("A");
        btnAppend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAppendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panUpperLayout = new javax.swing.GroupLayout(panUpper);
        panUpper.setLayout(panUpperLayout);
        panUpperLayout.setHorizontalGroup(
            panUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panUpperLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSubtitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDivision)
                .addGap(18, 18, 18)
                .addComponent(buttonParagraph)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnItalic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBold)
                .addGap(18, 18, 18)
                .addComponent(btnListItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNumberItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 386, Short.MAX_VALUE)
                .addComponent(btnAppend)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel)
                .addContainerGap())
        );
        panUpperLayout.setVerticalGroup(
            panUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panUpperLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonTitle)
                    .addComponent(buttonSubtitle)
                    .addComponent(buttonDivision)
                    .addComponent(buttonParagraph)
                    .addComponent(btnItalic)
                    .addComponent(btnBold)
                    .addComponent(btnListItem)
                    .addComponent(btnNumberItem)
                    .addComponent(btnCancel)
                    .addComponent(btnAppend))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
            .addComponent(panUpper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollMain)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panUpper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollMain, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTitleActionPerformed
        kind = Kindred.TITLE;
        finished();
    }//GEN-LAST:event_buttonTitleActionPerformed

    private void buttonSubtitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSubtitleActionPerformed
        kind = Kindred.SUBTITLE;
        finished();
    }//GEN-LAST:event_buttonSubtitleActionPerformed

    private void buttonDivisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDivisionActionPerformed
        kind = Kindred.DIVISION;
        finished();
    }//GEN-LAST:event_buttonDivisionActionPerformed

    private void buttonParagraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonParagraphActionPerformed
        kind = Kindred.PARAGRAPH;
        finished();
    }//GEN-LAST:event_buttonParagraphActionPerformed

    private void btnItalicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItalicActionPerformed
        var start = textMain.getSelectionStart();
        var end = textMain.getSelectionEnd();
        if (start > -1 && end > -1 && end > start) {
            var text = textMain.getText();
            textMain.setText(text.substring(0, start) 
                    + "*" + text.substring(start, end) 
                    + "*" + text.substring(end));
            textMain.setSelectionStart(start);
            textMain.setSelectionEnd(end + 2);
        }
        textMain.requestFocus();
    }//GEN-LAST:event_btnItalicActionPerformed

    private void btnBoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoldActionPerformed
        var start = textMain.getSelectionStart();
        var end = textMain.getSelectionEnd();
        if (start > -1 && end > -1 && end > start) {
            var text = textMain.getText();
            textMain.setText(text.substring(0, start) 
                    + "**" + text.substring(start, end) 
                    + "**" + text.substring(end));
            textMain.setSelectionStart(start);
            textMain.setSelectionEnd(end + 4);
        }
        textMain.requestFocus();
    }//GEN-LAST:event_btnBoldActionPerformed

    private void btnListItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListItemActionPerformed
        kind = Kindred.ITEM_LIST;
        finished();
    }//GEN-LAST:event_btnListItemActionPerformed

    private void btnNumberItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumberItemActionPerformed
        kind = Kindred.ITEM_NUMBER;
        finished();
    }//GEN-LAST:event_btnNumberItemActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        confirmed = false;
        finished();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnShortcutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnShortcutKeyPressed
        switch (evt.getKeyChar()) {
            case 't', 'T' -> buttonTitleActionPerformed(null);
            case 's', 'S' -> buttonSubtitleActionPerformed(null);
            case 'd', 'D' -> buttonDivisionActionPerformed(null);
            case 'p', 'P', 'c', 'C' -> buttonParagraphActionPerformed(null);
            case 'i', 'I' -> btnItalicActionPerformed(null);
            case 'b', 'B' -> btnBoldActionPerformed(null);
            case '*' -> btnListItemActionPerformed(null);
            case '+' -> btnNumberItemActionPerformed(null);
            case 'a', 'A' -> btnAppendActionPerformed(null);
            case 'x', 'X' -> btnCancelActionPerformed(null);
            case 'e', 'E' -> textMain.requestFocus();
        }
    }//GEN-LAST:event_btnShortcutKeyPressed

    private void btnAppendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAppendActionPerformed
        kind = Kindred.APPEND;
        finished();
    }//GEN-LAST:event_btnAppendActionPerformed

    private void finished() {
        if (isConfirmed()) {
            create.addCapturedText(getKindred(), getText());
        }
        create.closedCaptureText();
        setVisible(false);
    }
    
    public void appendText(String text) {
        textMain.append(text);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAppend;
    private javax.swing.JButton btnBold;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnItalic;
    private javax.swing.JButton btnListItem;
    private javax.swing.JButton btnNumberItem;
    private javax.swing.JButton buttonDivision;
    private javax.swing.JButton buttonParagraph;
    private javax.swing.JButton buttonSubtitle;
    private javax.swing.JButton buttonTitle;
    private javax.swing.JPanel panUpper;
    private javax.swing.JScrollPane scrollMain;
    private javax.swing.JTextArea textMain;
    // End of variables declaration//GEN-END:variables

}
