/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.pointel.docor.swing;

import br.com.pointel.docor.Kindred;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Marker extends javax.swing.JFrame {

    private boolean hasChanges = false;

    private MarkerCaptureText captureText = null;
    private MarkerCaptureImage captureImage = null;

    public Marker(JFrame from) {
        initComponents();
        setLocationRelativeTo(from);
        editFolder.setText(System.getProperty("user.home") + File.separator + "Documents");
        textMain.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent e) {
                signalChanges();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                signalChanges();
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                signalChanges();
            }
        });
    }

    private void signalChanges() {
        hasChanges = true;
        editStatus.setText("Has changes...");
    }

    public void closedCaptureText() {
        this.captureText = null;
    }

    public void closedCaptureImage() {
        this.captureImage = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuTools = new javax.swing.JPopupMenu();
        menuGroupImages = new javax.swing.JMenuItem();
        menuSpeedReader = new javax.swing.JMenuItem();
        panUpper = new javax.swing.JPanel();
        checkCapture = new javax.swing.JCheckBox();
        btnSaveAs = new javax.swing.JButton();
        edtTitle = new javax.swing.JTextField();
        editFolder = new javax.swing.JTextField();
        cbxSave = new javax.swing.JCheckBox();
        buttonFolderSelect = new javax.swing.JButton();
        btnTools = new javax.swing.JButton();
        buttonFolderOpen = new javax.swing.JButton();
        checkDefining = new javax.swing.JCheckBox();
        buttonTitle = new javax.swing.JButton();
        buttonSubtitle = new javax.swing.JButton();
        buttonDivision = new javax.swing.JButton();
        buttonParagraph = new javax.swing.JButton();
        buttonItalic = new javax.swing.JButton();
        buttonBold = new javax.swing.JButton();
        buttonListItem = new javax.swing.JButton();
        buttonNumberItem = new javax.swing.JButton();
        scrollMain = new javax.swing.JScrollPane();
        textMain = new javax.swing.JTextArea();
        editStatus = new javax.swing.JTextField();

        menuGroupImages.setText("Group Images");
        menuGroupImages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGroupImagesActionPerformed(evt);
            }
        });
        menuTools.add(menuGroupImages);

        menuSpeedReader.setText("Speed Reader");
        menuSpeedReader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSpeedReaderActionPerformed(evt);
            }
        });
        menuTools.add(menuSpeedReader);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Marker");

        checkCapture.setText("Capture");
        checkCapture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCaptureActionPerformed(evt);
            }
        });

        btnSaveAs.setText("Save As");
        btnSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAsActionPerformed(evt);
            }
        });

        edtTitle.setText("content");

        editFolder.setText("folder");

        cbxSave.setText("Save");
        cbxSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxSaveActionPerformed(evt);
            }
        });

        buttonFolderSelect.setText("&");
        buttonFolderSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFolderSelectActionPerformed(evt);
            }
        });

        btnTools.setText("Tools");
        btnTools.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToolsActionPerformed(evt);
            }
        });

        buttonFolderOpen.setText("^");
        buttonFolderOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFolderOpenActionPerformed(evt);
            }
        });

        checkDefining.setText("Defining");

        buttonTitle.setMnemonic('T');
        buttonTitle.setText("T");
        buttonTitle.setToolTipText("Title");
        buttonTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTitleActionPerformed(evt);
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

        buttonDivision.setMnemonic('D');
        buttonDivision.setText("D");
        buttonDivision.setToolTipText("Division");
        buttonDivision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDivisionActionPerformed(evt);
            }
        });

        buttonParagraph.setMnemonic('P');
        buttonParagraph.setText("P");
        buttonParagraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonParagraphActionPerformed(evt);
            }
        });

        buttonItalic.setMnemonic('I');
        buttonItalic.setText("I");
        buttonItalic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonItalicActionPerformed(evt);
            }
        });

        buttonBold.setMnemonic('B');
        buttonBold.setText("B");
        buttonBold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBoldActionPerformed(evt);
            }
        });

        buttonListItem.setMnemonic('*');
        buttonListItem.setText("*");
        buttonListItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonListItemActionPerformed(evt);
            }
        });

        buttonNumberItem.setMnemonic('+');
        buttonNumberItem.setText("+");
        buttonNumberItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNumberItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panUpperLayout = new javax.swing.GroupLayout(panUpper);
        panUpper.setLayout(panUpperLayout);
        panUpperLayout.setHorizontalGroup(
            panUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panUpperLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkCapture)
                    .addComponent(checkDefining))
                .addGap(18, 18, 18)
                .addGroup(panUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panUpperLayout.createSequentialGroup()
                        .addComponent(cbxSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editFolder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonFolderSelect)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonFolderOpen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaveAs))
                    .addGroup(panUpperLayout.createSequentialGroup()
                        .addComponent(buttonTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSubtitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDivision)
                        .addGap(18, 18, 18)
                        .addComponent(buttonParagraph)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonItalic)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonBold)
                        .addGap(18, 18, 18)
                        .addComponent(buttonListItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonNumberItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
                        .addComponent(btnTools)))
                .addContainerGap())
        );
        panUpperLayout.setVerticalGroup(
            panUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panUpperLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkCapture)
                    .addComponent(btnSaveAs)
                    .addComponent(edtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxSave)
                    .addComponent(buttonFolderSelect)
                    .addComponent(buttonFolderOpen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkDefining)
                    .addGroup(panUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonTitle)
                        .addComponent(buttonSubtitle)
                        .addComponent(buttonDivision)
                        .addComponent(buttonParagraph)
                        .addComponent(buttonItalic)
                        .addComponent(buttonBold)
                        .addComponent(buttonListItem)
                        .addComponent(buttonNumberItem)
                        .addComponent(btnTools))))
        );

        textMain.setColumns(20);
        textMain.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        textMain.setLineWrap(true);
        textMain.setRows(5);
        textMain.setWrapStyleWord(true);
        scrollMain.setViewportView(textMain);

        editStatus.setEditable(false);
        editStatus.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        editStatus.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panUpper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editStatus)
                    .addComponent(scrollMain))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panUpper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollMain, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAsActionPerformed
        try {
            var chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(editFolder.getText()));
            chooser.setFileFilter(new FileNameExtensionFilter("Marked *.md", "md"));
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                var file = chooser.getSelectedFile();
                if (!file.getName().toLowerCase().endsWith(".md")) {
                    file = new File(file.getAbsolutePath() + ".md");
                }
                Files.write(file.toPath(), textMain.getText().getBytes("UTF-8"));
                hasChanges = false;
                editStatus.setText("Saved.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnSaveAsActionPerformed

    private void checkCaptureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCaptureActionPerformed
        startAutoCapture();
    }//GEN-LAST:event_checkCaptureActionPerformed

    private void cbxSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxSaveActionPerformed
        startAutoSave();
    }//GEN-LAST:event_cbxSaveActionPerformed

    private void buttonFolderSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFolderSelectActionPerformed
        var chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(editFolder.getText()));
        chooser.setDialogTitle("Destination folder");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            editFolder.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_buttonFolderSelectActionPerformed

    private void btnToolsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToolsActionPerformed
        menuTools.show(btnTools, 0, btnTools.getHeight());
    }//GEN-LAST:event_btnToolsActionPerformed

    private void menuGroupImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGroupImagesActionPerformed
        try {
            var chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(editFolder.getText()));
            chooser.setFileFilter(new FileNameExtensionFilter("Images *.png", "png"));
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                var destiny = chooser.getSelectedFile();
                if (!destiny.getName().toLowerCase().endsWith(".png")) {
                    destiny = new File(destiny.getAbsolutePath() + ".png");
                }
                var text = textMain.getText();
                var folder = new File(editFolder.getText());
                new MarkerGroupImages(text, folder, destiny).save();
                editStatus.setText("Saved Grouped Images.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_menuGroupImagesActionPerformed

    private void menuSpeedReaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSpeedReaderActionPerformed
        var speed = new SpeedReader(textMain.getText());
        speed.setLocationRelativeTo(this);
        speed.setVisible(true);
    }//GEN-LAST:event_menuSpeedReaderActionPerformed

    private void buttonFolderOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFolderOpenActionPerformed
        try {
            Desktop.getDesktop().open(new File(editFolder.getText()));
        } catch (IOException ex) {
            Logger.getLogger(Marker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonFolderOpenActionPerformed

    private void buttonTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTitleActionPerformed

    }//GEN-LAST:event_buttonTitleActionPerformed

    private void buttonSubtitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSubtitleActionPerformed

    }//GEN-LAST:event_buttonSubtitleActionPerformed

    private void buttonDivisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDivisionActionPerformed

    }//GEN-LAST:event_buttonDivisionActionPerformed

    private void buttonParagraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonParagraphActionPerformed

    }//GEN-LAST:event_buttonParagraphActionPerformed

    private void buttonItalicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonItalicActionPerformed

    }//GEN-LAST:event_buttonItalicActionPerformed

    private void buttonBoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBoldActionPerformed

    }//GEN-LAST:event_buttonBoldActionPerformed

    private void buttonListItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonListItemActionPerformed

    }//GEN-LAST:event_buttonListItemActionPerformed

    private void buttonNumberItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNumberItemActionPerformed

    }//GEN-LAST:event_buttonNumberItemActionPerformed

    private void startAutoCapture() {
        new Thread() {
            @Override
            public void run() {
                String priorText = null;
                BufferedImage priorImage = null;
                while (isVisible() && checkCapture.isSelected()) {
                    try {
                        Thread.sleep(700);
                        var actualText = getStringOnClipboard();
                        if (actualText != null) {
                            if (!actualText.equals(priorText)) {
                                priorText = actualText;
                                captureText(actualText);
                            }
                        }
                        var actualImage = getImageOnClipboard();
                        if (actualImage != null) {
                            if (!isEquals(actualImage, priorImage)) {
                                priorImage = actualImage;
                                captureImage(actualImage);
                            }
                        }
                    } catch (Exception e) {
                        editStatus.setText("Erro: " + e.getMessage());
                    }
                }
            }

            private void captureText(String text) {
                if (checkDefining.isSelected()) {
                    if (captureImage != null) {
                        var cleaned = cleanText(text);
                        SwingUtilities.invokeLater(() -> {
                            captureImage.updateDescription(cleaned);
                            captureImage.setVisible(true);
                            captureImage.toFront();
                            captureImage.requestFocus();
                        });
                    } else if (captureText == null) {
                        SwingUtilities.invokeLater(() -> {
                            captureText = new MarkerCaptureText(Marker.this, text);
                            captureText.setVisible(true);
                            captureText.toFront();
                            captureText.requestFocus();
                        });
                    } else {
                        SwingUtilities.invokeLater(() -> {
                            captureText.appendText(text);
                            captureText.setVisible(true);
                            captureText.toFront();
                            captureText.requestFocus();
                        });
                    }
                } else {
                    SwingUtilities.invokeLater(() -> {
                        var prior = textMain.getText();
                        if (!prior.isBlank()) {
                            textMain.setText(prior + "\n" + text);
                        } else {
                            textMain.setText(text);
                        }
                    });
                }
            }

            private void captureImage(BufferedImage image) {
                if (checkDefining.isSelected()) {
                    if (captureImage == null) {
                        SwingUtilities.invokeLater(() -> {
                            captureImage = new MarkerCaptureImage(Marker.this, image, getNextImageName());
                            captureImage.setVisible(true);
                            captureImage.toFront();
                            captureImage.requestFocus();
                        });
                    } else {
                        SwingUtilities.invokeLater(() -> {
                            captureImage.updateImage(image);
                            captureImage.setVisible(true);
                            captureImage.toFront();
                            captureImage.requestFocus();
                        });
                    }
                } else {
                    throw new RuntimeException("Not yet implemented.");
                }
            }
        }.start();
    }

    public boolean isEquals(BufferedImage image1, BufferedImage image2) {
        if (image1 == image2) {
            return true;
        }
        if (image1 == null || image2 == null) {
            return false;
        }
        if (image1.getWidth() != image2.getWidth()) {
            return false;
        }
        if (image1.getHeight() != image2.getHeight()) {
            return false;
        }
        for (int i = 0; i < image1.getWidth(); i++) {
            for (int j = 0; j < image1.getHeight(); j++) {
                if (image1.getRGB(i, j) != image2.getRGB(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void startAutoSave() {
        new Thread(() -> {
            while (isVisible() && cbxSave.isSelected()) {
                try {
                    Thread.sleep(700);
                    if (hasChanges) {
                        File folder = new File(editFolder.getText());
                        if (!folder.exists()) {
                            editStatus.setText("Erro: Folder not exists.");
                            continue;
                        }
                        if (!folder.isDirectory()) {
                            editStatus.setText("Erro: Path is not a directory.");
                            continue;
                        }
                        var file = new File(folder, edtTitle.getText() + ".md");
                        Files.write(file.toPath(), textMain.getText().getBytes("UTF-8"));
                        hasChanges = false;
                        editStatus.setText("Saved.");
                    }
                } catch (Exception e) {
                    editStatus.setText("Erro: " + e.getMessage());
                }
            }
        }).start();
    }

    public void addCapturedText(Kindred kind, String text) {
        switch (kind) {
            case TITLE ->
                addHeaderOne(text);
            case SUBTITLE ->
                addHeaderTwo(text);
            case DIVISION ->
                addHeaderThree(text);
            case PARAGRAPH ->
                addParagraph(text);
            case ITEM_LIST ->
                addItemList(text);
            case ITEM_NUMBER ->
                addItemNumber(text);
            case APPEND ->
                addAppend(text);
            default ->
                throw new AssertionError();
        }
    }

    public void addHeaderOne(String text) {
        if (!textMain.getText().isBlank()) {
            textMain.append("\n\n");
        }
        textMain.append("# ");
        textMain.append(cleanText(text));
        goToBottom();
    }

    public void addHeaderTwo(String text) {
        if (!textMain.getText().isBlank()) {
            textMain.append("\n\n");
        }
        textMain.append("## ");
        textMain.append(cleanText(text));
        goToBottom();
    }

    public void addHeaderThree(String text) {
        if (!textMain.getText().isBlank()) {
            textMain.append("\n\n");
        }
        textMain.append("### ");
        textMain.append(cleanText(text));
        goToBottom();
    }

    public void addParagraph(String text) {
        if (!textMain.getText().isBlank()) {
            textMain.append("\n\n");
        }
        textMain.append(cleanText(text));
        goToBottom();
    }

    public void addItemList(String text) {
        var lastLine = getLastLine();
        var newList = !lastLine.startsWith("-");
        if (newList && !textMain.getText().isBlank()) {
            textMain.append("\n");
        }
        if (!textMain.getText().isBlank()) {
            textMain.append("\n");
        }
        textMain.append("- ");
        textMain.append(cleanText(text));
        goToBottom();
    }

    public void addItemNumber(String text) {
        var lastLine = getLastLine();
        var newList = true;
        var index = 1;
        var dot = lastLine.indexOf('.');
        if (dot > -1) {
            try {
                index = Integer.parseInt(lastLine.substring(0, dot));
                index++;
                newList = false;
            } catch (Exception e) {
            }
        }
        if (newList && !textMain.getText().isBlank()) {
            textMain.append("\n");
        }
        if (!textMain.getText().isBlank()) {
            textMain.append("\n");
        }
        textMain.append(index + ". ");
        textMain.append(cleanText(text));
        goToBottom();
    }

    public void addAppend(String text) {
        textMain.append(cleanText(text));
        goToBottom();
    }

    public void addImage(BufferedImage image, String name, String description) {
        try {
            name = name + ".png";
            var folder = new File(editFolder.getText());
            var file = new File(folder, name);
            ImageIO.write(image, "PNG", file);
            if (!textMain.getText().isBlank()) {
                textMain.append("\n\n");
            }
            textMain.append("![" + description + "](" + name + ")");
            goToBottom();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public String getLastLine() {
        String[] lines = textMain.getText().trim().split("\\n");
        if (lines.length > 0) {
            return lines[lines.length - 1].trim();
        } else {
            return "";
        }
    }

    public String getStringOnClipboard() throws Exception {
        Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable clipboardContents = systemClipboard.getContents(null);
        if (clipboardContents != null) {
            try {
                if (clipboardContents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                    return (String) clipboardContents.getTransferData(DataFlavor.stringFlavor);
                }
            } catch (Exception ex) {
                editStatus.setText("Error: " + ex.getMessage());
            }
        }
        return null;
    }

    public BufferedImage getImageOnClipboard() throws Exception {
        Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable clipboardContents = systemClipboard.getContents(null);
        if (clipboardContents != null) {
            try {
                if (clipboardContents.isDataFlavorSupported(DataFlavor.imageFlavor)) {
                    return (BufferedImage) clipboardContents.getTransferData(DataFlavor.imageFlavor);
                }
            } catch (Exception ex) {
                editStatus.setText("Error: " + ex.getMessage());
            }
        }
        return null;
    }

    public String cleanText(String text) {
        text = text.replaceAll("\\s+", " ");
        text = text.replaceAll("\\-\\s+", "");
        return text.trim();
    }

    public void goToBottom() {
        scrollMain.getVerticalScrollBar().setValue(scrollMain.getVerticalScrollBar().getMaximum());
    }

    public String getNextImageName() {
        var index = 1;
        var folder = new File(editFolder.getText());
        if (folder.exists() && folder.isDirectory()) {
            while (true) {
                var image = new File(folder, "image-" + index + ".png");
                if (!image.exists()) {
                    break;
                } else {
                    index++;
                }
            }
        }
        return "image-" + index;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSaveAs;
    private javax.swing.JButton btnTools;
    private javax.swing.JButton buttonBold;
    private javax.swing.JButton buttonDivision;
    private javax.swing.JButton buttonFolderOpen;
    private javax.swing.JButton buttonFolderSelect;
    private javax.swing.JButton buttonItalic;
    private javax.swing.JButton buttonListItem;
    private javax.swing.JButton buttonNumberItem;
    private javax.swing.JButton buttonParagraph;
    private javax.swing.JButton buttonSubtitle;
    private javax.swing.JButton buttonTitle;
    private javax.swing.JCheckBox cbxSave;
    private javax.swing.JCheckBox checkCapture;
    private javax.swing.JCheckBox checkDefining;
    private javax.swing.JTextField editFolder;
    private javax.swing.JTextField editStatus;
    private javax.swing.JTextField edtTitle;
    private javax.swing.JMenuItem menuGroupImages;
    private javax.swing.JMenuItem menuSpeedReader;
    private javax.swing.JPopupMenu menuTools;
    private javax.swing.JPanel panUpper;
    private javax.swing.JScrollPane scrollMain;
    private javax.swing.JTextArea textMain;
    // End of variables declaration//GEN-END:variables
}
