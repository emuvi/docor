package br.com.pointel.docor.swing;

import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

public class ReaderSpeed extends javax.swing.JFrame {

    private final String[] words;
    private volatile boolean running = false;
    private volatile int index = -1;
    private volatile int waitTime = 200;
    
    public ReaderSpeed(JFrame from, String text) {
        initComponents();
        setLocationRelativeTo(from);
        this.words = text.split("\\s+");
        spinnerRate.setModel(new SpinnerNumberModel(500, 0, 1000, 10));
        sliderWords.setMaximum(words.length -1);
        sliderWords.setValue(0);
        startTimer();
        getRootPane().registerKeyboardAction((ev) -> {
            buttonStartActionPerformed(ev);
        }, KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
        getRootPane().registerKeyboardAction((ev) -> {
            setVisible(false);
            dispose();
        }, KeyStroke.getKeyStroke(KeyEvent.VK_X, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
    }
    
    private void nextWord() {
        if (index < words.length -1) {
            sliderWords.setValue(index + 1);
        }
    }
    
    private void startTimer() {
         new Thread() {
            @Override
            public void run() {
                try {
                    long last = System.currentTimeMillis();
                    while (isDisplayable()) {
                        if (running) {
                            long now = System.currentTimeMillis();
                            if (now >= last + waitTime) {
                                last = now;
                                SwingUtilities.invokeAndWait(() -> nextWord());
                            } else { 
                                sleep(10);
                            }
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ReaderSpeed.this, ex.getMessage());
                }
            }
        }.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUpper = new javax.swing.JPanel();
        buttonStart = new javax.swing.JButton();
        spinnerRate = new javax.swing.JSpinner();
        sliderWords = new javax.swing.JSlider();
        labelWord = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Speed Reader");

        buttonStart.setText("Start");
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });

        spinnerRate.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerRateStateChanged(evt);
            }
        });

        sliderWords.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderWordsStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelUpperLayout = new javax.swing.GroupLayout(panelUpper);
        panelUpper.setLayout(panelUpperLayout);
        panelUpperLayout.setHorizontalGroup(
            panelUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUpperLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sliderWords, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelUpperLayout.setVerticalGroup(
            panelUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUpperLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sliderWords, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonStart))
                .addContainerGap())
        );

        labelWord.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        labelWord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelUpper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelUpper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelWord, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sliderWordsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderWordsStateChanged
        index = (int) sliderWords.getValue();
        labelWord.setText(words[index]);
    }//GEN-LAST:event_sliderWordsStateChanged

    private void spinnerRateStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerRateStateChanged
        waitTime = 60_000 / (int) spinnerRate.getValue();
    }//GEN-LAST:event_spinnerRateStateChanged

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
        running = !running;
        buttonStart.setText(running ? "Stop" : "Start");
    }//GEN-LAST:event_buttonStartActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonStart;
    private javax.swing.JLabel labelWord;
    private javax.swing.JPanel panelUpper;
    private javax.swing.JSlider sliderWords;
    private javax.swing.JSpinner spinnerRate;
    // End of variables declaration//GEN-END:variables
}
