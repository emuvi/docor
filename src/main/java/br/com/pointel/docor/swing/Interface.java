package br.com.pointel.docor.swing;

import br.com.pointel.docor.Conditions;
import br.com.pointel.docor.Found;
import br.com.pointel.docor.LoadPDF;
import br.com.pointel.docor.Paced;
import br.com.pointel.docor.Utils;
import com.formdev.flatlaf.FlatDarculaLaf;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import org.apache.commons.math3.util.Pair;

public class Interface extends javax.swing.JFrame {

    private DefaultMutableTreeNode root = new DefaultMutableTreeNode("Loaded");
    private DefaultTreeModel tree = new DefaultTreeModel(root);
    private List<Paced> body = Collections.synchronizedList(new ArrayList<>());

    public Interface() {
        initComponents();
        getRootPane().setDefaultButton(btnSearch);
        treeBody.expandPath(new TreePath(root.getPath()));
        treeBody.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panUpper = new javax.swing.JPanel();
        btnLoad = new javax.swing.JButton();
        edtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        panLower = new javax.swing.JPanel();
        edtOutput = new javax.swing.JTextField();
        edtStatus = new javax.swing.JTextField();
        btnClose = new javax.swing.JButton();
        tpnMain = new javax.swing.JTabbedPane();
        panBody = new javax.swing.JPanel();
        scpBody = new javax.swing.JScrollPane();
        treeBody = new javax.swing.JTree();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Docor");
        setPreferredSize(new java.awt.Dimension(700, 600));

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panUpperLayout = new javax.swing.GroupLayout(panUpper);
        panUpper.setLayout(panUpperLayout);
        panUpperLayout.setHorizontalGroup(
            panUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panUpperLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCreate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear)
                .addContainerGap())
        );
        panUpperLayout.setVerticalGroup(
            panUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panUpperLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panUpperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoad)
                    .addComponent(btnSearch)
                    .addComponent(edtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear)
                    .addComponent(btnCreate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        edtOutput.setEditable(false);
        edtOutput.setBorder(null);

        edtStatus.setEditable(false);
        edtStatus.setBorder(null);

        btnClose.setText("Close");

        javax.swing.GroupLayout panLowerLayout = new javax.swing.GroupLayout(panLower);
        panLower.setLayout(panLowerLayout);
        panLowerLayout.setHorizontalGroup(
            panLowerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panLowerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(edtOutput)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose)
                .addContainerGap())
        );
        panLowerLayout.setVerticalGroup(
            panLowerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panLowerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panLowerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(edtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        treeBody.setModel(tree);
        treeBody.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                treeBodyMouseClicked(evt);
            }
        });
        scpBody.setViewportView(treeBody);

        javax.swing.GroupLayout panBodyLayout = new javax.swing.GroupLayout(panBody);
        panBody.setLayout(panBodyLayout);
        panBodyLayout.setHorizontalGroup(
            panBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scpBody, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );
        panBodyLayout.setVerticalGroup(
            panBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scpBody, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );

        tpnMain.addTab("Body", panBody);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panUpper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panLower, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpnMain)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panUpper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tpnMain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panLower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        try {
            var chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                var selected = chooser.getSelectedFile();
                startLoading(selected);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnLoadActionPerformed

    private void startLoading(File selected) {
        var charge = new ConcurrentLinkedDeque<Pair<File, DefaultMutableTreeNode>>();
        var mapped = new AtomicBoolean(false);
        var making = new CountDownLatch(5);

        new Thread("Mapping") {
            @Override
            public void run() {
                try {
                    if (selected.isDirectory()) {
                        loadDirectory(selected, root);
                    } else {
                        charge.push(new Pair<>(selected, root));
                    }
                } catch (Exception e) {
                    logError(e);
                } finally {
                    mapped.set(true);
                    making.countDown();
                }
            }

            private void loadDirectory(File directory, DefaultMutableTreeNode parent) throws Exception {
                if (directory.getName().startsWith("_docor_temp_")) {
                    return;
                }
                var node = new DefaultMutableTreeNode(directory.getName());
                SwingUtilities.invokeLater(() -> parent.add(node));
                for (var inside : directory.listFiles()) {
                    if (inside.isDirectory()) {
                        loadDirectory(inside, node);
                    }
                }
                for (var inside : directory.listFiles()) {
                    if (inside.isFile()) {
                        charge.push(new Pair<>(inside, node));
                    }
                }
            }
        }.start();

        for (int i = 1; i <= 4; i++) {
            new Thread("Discharge " + i) {
                @Override
                public void run() {
                    try {
                        while (true) {
                            var charged = charge.poll();
                            if (charged == null) {
                                if (mapped.get()) {
                                    break;
                                } else {
                                    continue;
                                }
                            }
                            try {
                                loadFile(charged.getFirst(), charged.getSecond());
                            } catch (Exception e) {
                                logError(e);
                            }
                        }
                    } catch (Exception e) {
                        logError(e);
                    } finally {
                        making.countDown();
                    }
                }

                private void loadFile(File file, DefaultMutableTreeNode parent) throws Exception {
                    if (!file.getName().toLowerCase().endsWith(".pdf")) {
                        file = Utils.convertToPDF(file);
                    }
                    if (file == null) {
                        return;
                    }
                    var paced = new LoadPDF(file).load();
                    if (paced == null) {
                        return;
                    }
                    body.add(paced);
                    var node = new DefaultMutableTreeNode(paced);
                    SwingUtilities.invokeLater(() -> parent.add(node));
                    logInfo("Loaded: " + file.getName());
                }
            }.start();
        }

        new Thread("Finalize") {
            @Override
            public void run() {
                try {
                    making.await();
                    treeBody.setModel(null);
                    treeBody.setModel(tree);
                    setNodeExpandedState(treeBody, root, true);
                } catch (Exception e) {
                    logError(e);
                }
            }
        }.start();
    }

    private void logInfo(String message) {
        if (SwingUtilities.isEventDispatchThread()) {
            edtOutput.setText(message);
        } else {
            SwingUtilities.invokeLater(() -> edtOutput.setText(message));
        }
    }

    private void logError(Throwable exception) {
        exception.printStackTrace();
        if (SwingUtilities.isEventDispatchThread()) {
            edtOutput.setText(exception.getMessage());
        } else {
            SwingUtilities.invokeLater(() -> edtOutput.setText(exception.getMessage()));
        }
    }

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        var conditions = Conditions.parse(edtSearch.getText());
        var allFounds = new ArrayList<Found>();
        for (var doc : body) {
            var docFounds = doc.search(conditions);
            if (docFounds != null) {
                allFounds.add(docFounds);
            }
        }
        if (!allFounds.isEmpty()) {
            Collections.sort(allFounds, (o1, o2) -> {
                return o2.score.compareTo(o1.score);
            });
            var cols = new Object[]{"Score", "Name", "Folder", "Text"};
            var rows = new DefaultTableModel();
            rows.setColumnIdentifiers(cols);
            for (var found : allFounds) {
                rows.addRow(found.toRow());
            }
            JTable table = new JTable(rows);
            table.setDefaultEditor(Object.class, null);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            var total = tpnMain.getWidth() - 80;
            table.getColumnModel().getColumn(0).setPreferredWidth(total * 8 / 100);
            table.getColumnModel().getColumn(1).setPreferredWidth(total * 10 / 100);
            table.getColumnModel().getColumn(2).setPreferredWidth(total * 36 / 100);
            table.getColumnModel().getColumn(3).setPreferredWidth(total * 40 / 100);
            table.getColumnModel().getColumn(0).setCellRenderer(tableCell);
            table.getColumnModel().getColumn(1).setCellRenderer(tableCell);
            table.getColumnModel().getColumn(2).setCellRenderer(tableCell);
            table.getColumnModel().getColumn(3).setCellRenderer(tableCell);
            JScrollPane scroll = new JScrollPane(table);
            tpnMain.addTab("Found", scroll);
            tpnMain.setSelectedComponent(scroll);
            var from = this;
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() >= 2 && table.getSelectedRow() > -1) {
                        new Reader(from, (String) table.getValueAt(table.getSelectedRow(), 3)).setVisible(true);
                    }
                }
            });
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        while (tpnMain.getComponentCount() > 1) {
            tpnMain.remove(1);
        }
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        new Marker(this).setVisible(true);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void treeBodyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_treeBodyMouseClicked
        if (evt.getClickCount() >= 2 && treeBody.getSelectionCount() > 0) {
            var node = (DefaultMutableTreeNode) treeBody.getSelectionPath().getLastPathComponent();
            var item = node.getUserObject();
            if (item instanceof Paced paced) {
                new Reader(this, paced.getText()).setVisible(true);
            }
        }
    }//GEN-LAST:event_treeBodyMouseClicked

    public static void start(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Interface().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSearch;
    private javax.swing.JTextField edtOutput;
    private javax.swing.JTextField edtSearch;
    private javax.swing.JTextField edtStatus;
    private javax.swing.JPanel panBody;
    private javax.swing.JPanel panLower;
    private javax.swing.JPanel panUpper;
    private javax.swing.JScrollPane scpBody;
    private javax.swing.JTabbedPane tpnMain;
    private javax.swing.JTree treeBody;
    // End of variables declaration//GEN-END:variables

    private DefaultTableCellRenderer tableCell = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setFont(getFont().deriveFont(12.0f));
            setBorder(cellPadding);
            table.setRowHeight(row, getPreferredSize().height);
            return this;
        }
    };

    private Border cellPadding = BorderFactory.createEmptyBorder(5, 5, 5, 5);

    public static void setNodeExpandedState(JTree tree, DefaultMutableTreeNode node, boolean expanded) {
        var children = node.children();
        while (children.hasMoreElements()) {
            var child = (DefaultMutableTreeNode) children.nextElement();
            setNodeExpandedState(tree, child, expanded);
        }
        if (!expanded && node.isRoot()) {
            return;
        }
        TreePath path = new TreePath(node.getPath());
        if (expanded) {
            tree.expandPath(path);
        } else {
            tree.collapsePath(path);
        }
    }
}
