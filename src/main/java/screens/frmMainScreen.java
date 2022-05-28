package screens;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.List;
import javax.swing.JOptionPane;
import utils.ModelMessage;
import utils.SocketMethods;

public class frmMainScreen extends javax.swing.JFrame {

    private SocketMethods socket = new SocketMethods();
    private String name;

    public frmMainScreen(String name) {
        this.name = name;

        initComponents();
        setPropertyJtxtLoop(false);

        jtxtInputChat.requestFocus();

        socket.listen().on("recived", (var args) -> {
            List<ModelMessage> message = socket.convertToJson(args[0].toString(), new TypeReference<List<ModelMessage>>() {
            });

            message.stream().forEach((ModelMessage msg) -> {
                jtxaDisplay.append(msg.getName() + ": " + msg.getMessage() + "\n");
            });
        });
    }

    public static String validatorName(String name) {
        if (name.trim().isEmpty()) {
            return "Rellene el campo";
        } else if (name.trim().length() < 3) {
            return "Ingrese un nombre valido";
        }
        return "";
    }

    public void setPropertyJtxtLoop(boolean isVisible) {
        this.jtxtContenidoLoop.setVisible(isVisible);
        this.jtxtNumRepeticiones.setVisible(isVisible);
        this.jbtnSetLoop.setVisible(isVisible);
    }

    public void looper(String mensaje, int num) {

        if (num <= 50) {
            for (int i = 0; i < num; ++i) {
                socket.sendEvent(this.name, mensaje);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Excedio el numero maximo de repeticion que se pueden realizar - Maxiomo 50");
        }
        setPropertyJtxtLoop(false);
        this.jtxtContenidoLoop.setText("");
        this.jtxtNumRepeticiones.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jbtnSend = new javax.swing.JButton();
        jtxtInputChat = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtxaDisplay = new javax.swing.JTextArea();
        jtxtNumRepeticiones = new javax.swing.JTextField();
        jtxtContenidoLoop = new javax.swing.JTextField();
        jbtnSetLoop = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbtnSend.setText("Send");
        jbtnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSendActionPerformed(evt);
            }
        });

        jtxtInputChat.setBackground(new java.awt.Color(255, 255, 255));
        jtxtInputChat.setFont(new java.awt.Font("Victor Mono SemiBold", 1, 12)); // NOI18N
        jtxtInputChat.setForeground(new java.awt.Color(0, 0, 0));
        jtxtInputChat.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)), "Message", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Victor Mono SemiBold", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jtxtInputChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtInputChatActionPerformed(evt);
            }
        });
        jtxtInputChat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtInputChatKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("Chat Basic");

        jtxaDisplay.setColumns(20);
        jtxaDisplay.setRows(5);
        jScrollPane3.setViewportView(jtxaDisplay);

        jtxtNumRepeticiones.setBackground(new java.awt.Color(255, 255, 255));
        jtxtNumRepeticiones.setFont(new java.awt.Font("Victor Mono SemiBold", 1, 12)); // NOI18N
        jtxtNumRepeticiones.setForeground(new java.awt.Color(0, 0, 0));
        jtxtNumRepeticiones.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)), "Numero Repeticiones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Victor Mono SemiBold", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jtxtNumRepeticiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNumRepeticionesActionPerformed(evt);
            }
        });
        jtxtNumRepeticiones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtNumRepeticionesKeyPressed(evt);
            }
        });

        jtxtContenidoLoop.setBackground(new java.awt.Color(255, 255, 255));
        jtxtContenidoLoop.setFont(new java.awt.Font("Victor Mono SemiBold", 1, 12)); // NOI18N
        jtxtContenidoLoop.setForeground(new java.awt.Color(0, 0, 0));
        jtxtContenidoLoop.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)), "Mensaje", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Victor Mono SemiBold", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jtxtContenidoLoop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtContenidoLoopActionPerformed(evt);
            }
        });
        jtxtContenidoLoop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtContenidoLoopKeyPressed(evt);
            }
        });

        jbtnSetLoop.setText("Send");
        jbtnSetLoop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSetLoopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jbtnSend))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtNumRepeticiones, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtInputChat, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtContenidoLoop, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jbtnSetLoop)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addComponent(jtxtInputChat, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jbtnSend)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jtxtContenidoLoop, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtxtNumRepeticiones, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnSetLoop)
                .addGap(13, 13, 13))
            .addComponent(jScrollPane3)
        );

        jTabbedPane1.addTab("Main", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 714, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("List Commands", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSendActionPerformed
        String txt = jtxtInputChat.getText();

        if (!txt.trim().isEmpty()) {
            switch (txt.toLowerCase().trim()) {
                case "::exit":
                    System.exit(0);
                case "::clearchat":
                    jtxaDisplay.setText("");
                    break;
                case "::helloworld":
                    JOptionPane.showMessageDialog(null, """
                                                        public class Proyect {
                                                            public static void main(String[] args) {
                                                                System.out.print("Hello World");
                                                            }
                                                        """);
                    break;
                case "::loop":
                    setPropertyJtxtLoop(true);
                    this.jtxtContenidoLoop.requestFocus();

                    break;
                default:
                    String ctn = "";
                    String[] arrMsg = jtxtInputChat.getText().split("");
                    if (arrMsg.length <= 1) {
                        jtxtInputChat.setText(jtxtInputChat.getText());
                    } else {

                        for (int i = 0; i < arrMsg.length; ++i) {
                            if (arrMsg[i].equals(":") && arrMsg[i + 1].equals(")")) {
                                ctn += "😀";
                            } else if (arrMsg[i].equals(":") && arrMsg[i + 1].equals("(")) {
                                ctn += "😞";
                            } else if (!arrMsg[i].contains("(") && !arrMsg[i].contains(")")) {
                                ctn += arrMsg[i];
                            }

                        }
                        jtxtInputChat.setText(ctn);
                    }
                    socket.sendEvent(this.name, jtxtInputChat.getText().trim());
                    break;
            }
            jtxtInputChat.setText("");
        }
    }//GEN-LAST:event_jbtnSendActionPerformed

    private void jtxtInputChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtInputChatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtInputChatActionPerformed

    private void jtxtInputChatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtInputChatKeyPressed
        if (evt.getKeyCode() == 10) {
            jbtnSendActionPerformed(null);
        }
    }//GEN-LAST:event_jtxtInputChatKeyPressed

    private void jtxtNumRepeticionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNumRepeticionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNumRepeticionesActionPerformed

    private void jtxtNumRepeticionesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNumRepeticionesKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNumRepeticionesKeyPressed

    private void jtxtContenidoLoopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtContenidoLoopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtContenidoLoopActionPerformed

    private void jtxtContenidoLoopKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtContenidoLoopKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtContenidoLoopKeyPressed

    private void jbtnSetLoopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSetLoopActionPerformed
        String contenidoLoop = jtxtContenidoLoop.getText();
        int numRepeticiones = Integer.parseInt(jtxtNumRepeticiones.getText());

        if (contenidoLoop.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un mensaje");
        } else if (numRepeticiones <= 0) {
            JOptionPane.showMessageDialog(null, "Ingrese un numero de repeticiones valido");
        } else {
            looper(contenidoLoop, numRepeticiones);
        }
    }//GEN-LAST:event_jbtnSetLoopActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new frmMainScreen("defualt").setVisible(true);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtnSend;
    private javax.swing.JButton jbtnSetLoop;
    private javax.swing.JTextArea jtxaDisplay;
    private javax.swing.JTextField jtxtContenidoLoop;
    private javax.swing.JTextField jtxtInputChat;
    private javax.swing.JTextField jtxtNumRepeticiones;
    // End of variables declaration//GEN-END:variables
}
