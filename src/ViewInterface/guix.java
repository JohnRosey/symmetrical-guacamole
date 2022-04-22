package ViewInterface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

import Couche.CTransport.TransportCouche;
import Couche.Session.GenerationOfStart.generateSlec;
import Outil.fileUtility;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

import net.miginfocom.swing.*;
/*
 * Created by JFormDesigner on Wed Apr 20 02:41:17 EDT 2022
 * By GANSONRE ISMAEL
 * Copyright (c) 2020 GANSONRE ISMAEL. All rights reserved.
 */


/**
 * @author ismael
 */
public class guix extends JFrame {
    private JTextArea L_lec;
    private JTextArea S_lec;
    private JTextArea S_ecr;
    private JTextArea L_ecr;

    public guix() {
        initComponents();
    }

    private void button1MouseClicked() throws IOException {

        TransportCouche transport = new TransportCouche();
        //fileUtility.Generate_S_lec("Couche/Session/S_lec.txt");
        System.out.println("here");

        transport.DemarrerCommunication();
        System.out.println("Affichage des donnees");


        ShowData();

    }

    private void button2MouseClicked() {
        S_lec.setText("");
        S_ecr.setText("");
        L_ecr.setText("");
        L_lec.setText("");
        fileUtility.Erase("src/Couche/Session/S_ecr.txt");
        fileUtility.Erase("src/Couche/LiasonDonnee/L_ecr.txt");
        fileUtility.Erase("src/Couche/LiasonDonnee/L_lec.txt");
        fileUtility.Erase("src/Couche/Session/S_lec.txt");
        System.out.println("Fichier effacé");
    }

    public void ShowData() {

        try {
            //Probleme ici vous devez ccliquer 2 fois sur le bouton pour lancer la communication
            System.out.println("Communication lancée");
            FileReader reader2 = new FileReader("src/Couche/Session/S_ecr.txt");
            FileReader reader3 = new FileReader("src/Couche/LiasonDonnee/L_ecr.txt");
            FileReader reader4 = new FileReader("src/Couche/LiasonDonnee/L_lec.txt");
            BufferedReader br2 = new BufferedReader(reader2);
            BufferedReader br3 = new BufferedReader(reader3);
            BufferedReader br4 = new BufferedReader(reader4);
            S_ecr.read(br2, null);
            L_ecr.read(br3, null);
            L_lec.read(br4, null);

            br2.close();
            br3.close();
            br4.close();

        } catch (Exception e2) {
            System.out.println(e2);
        }
    }

    private void button4MouseClicked() {
        System.out.println("Chargement des donnees de demonstration");
        String data =
                "Firefox       Edge       CONECT\n" +
                        "Firefox       Edge       DATA       hello word\n" +
                        "Firefox       Edge       LIB\n" +
                        "Chrome       Firefox       CONECT\n" +
                        "Chrome       Firefox       DATA       my enemey\n" +
                        "Chrome       Firefox       LIB\n" +
                        "Brave       Edge       DATA      887499887yu6867u5756u\n" +
                        "Firefox       Brave       CONECT\n" +
                        "Edge       Brave       DATA       nice\n" +
                        "Edge       Chrome       DATA       y6546¬¦¤¢¬345432\n" +
                        "Brave       Firefox       LIB\n" +
                        "1234        22          CONECT      UNDERCORVER\n" +
                        "22          1234        DATA        hello\n" +
                        "22          1234        LIB\n" +
                        "1234        22          CONECT      UNDERCORVER\n" +
                        "22          1234        DATA        hello\n" +
                        "22          1234        LIB";
        File filepath = new File("src/Couche/Session/S_lec.txt");

        try {
            if (!filepath.exists()) {
                final var newFile = filepath.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(filepath);
            fileWriter.write(data);
            fileWriter.flush();
            System.out.println("Fichier demo chargee");
            FileReader reader = new FileReader("src/Couche/Session/S_lec.txt");
            BufferedReader br = new BufferedReader(reader);
            S_lec.read(br, null);
            br.close();
            fileWriter.close();


        } catch (IOException g) {
            g.printStackTrace();
        }
    }

    private void button3MouseClicked() throws IOException {
        generateSlec.RandomData();
        System.out.println("donnees aleatoires generees");
        FileReader reader = new FileReader("src/Couche/Session/S_lec.txt");
        BufferedReader br = new BufferedReader(reader);
        S_lec.read(br, null);
        br.close();
    }

    private void button4(ActionEvent e) {
        // TODO add your code here
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
    }

    private void button5() throws IOException {
        Desktop.getDesktop().open(new File("src/Couche/Session/S_ecr.txt"));

    }

    private void button6() throws IOException {
        Desktop.getDesktop().open(new File("src/Couche/LiasonDonnee/L_ecr.txt"));
    }

    private void button7() throws IOException {
        Desktop.getDesktop().open(new File("src/Couche/LiasonDonnee/L_lec.txt"));

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
        JLabel label1 = new JLabel();
        JLabel label4 = new JLabel();
        JPanel panel1 = new JPanel();
        JScrollPane scrollPane2 = new JScrollPane();
        this.L_lec = new JTextArea();
        JScrollPane scrollPane1 = new JScrollPane();
        this.S_lec = new JTextArea();
        JScrollPane scrollPane4 = new JScrollPane();
        this.S_ecr = new JTextArea();
        JScrollPane scrollPane3 = new JScrollPane();
        this.L_ecr = new JTextArea();
        JLabel label2 = new JLabel();
        /*public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new guix().setVisible(true);
            }
        });*/
        JLabel label3 = new JLabel();
        JPanel panel2 = new JPanel();
        JButton button4 = new JButton();
        JButton button3 = new JButton();
        JPanel panel3 = new JPanel();
        JButton button2 = new JButton();
        JButton button1 = new JButton();
        JPanel panel4 = new JPanel();
        JButton button5 = new JButton();
        JButton button6 = new JButton();
        JButton button7 = new JButton();

        //======== this ========
        setTitle("PROJET DE SESSION INF1009");
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("S_lec");

        //---- label4 ----
        label4.setText("L_ecr");

        //======== panel1 ========
        {
            panel1.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));

            //======== scrollPane2 ========
            {

                //---- L_lec ----
                this.L_lec.setFont(new Font(Font.MONOSPACED, Font.BOLD | Font.ITALIC, 10));
                scrollPane2.setViewportView(this.L_lec);
            }

            //======== scrollPane1 ========
            {

                //---- S_lec ----
                this.S_lec.setFont(new Font(Font.MONOSPACED, Font.BOLD | Font.ITALIC, 10));
                scrollPane1.setViewportView(this.S_lec);
            }

            //======== scrollPane4 ========
            {

                //---- S_ecr ----
                this.S_ecr.setFont(new Font(Font.MONOSPACED, Font.BOLD | Font.ITALIC, 10));
                scrollPane4.setViewportView(this.S_ecr);
            }

            //======== scrollPane3 ========
            {

                //---- L_ecr ----
                this.L_ecr.setFont(new Font(Font.MONOSPACED, Font.BOLD | Font.ITALIC, 10));
                scrollPane3.setViewportView(this.L_ecr);
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                                            .addComponent(scrollPane1))
                                    .addGap(68, 68, 68)
                                    .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(scrollPane4)
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                    .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 11, Short.MAX_VALUE)))
                                    .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))
                                    .addGap(59, 59, 59)
                                    .addGroup(panel1Layout.createParallelGroup()
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
                                                    .addContainerGap(15, Short.MAX_VALUE))
                                            .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)))
            );
        }

        //---- label2 ----
        label2.setText("S_ecr");

        //---- label3 ----
        label3.setText("L_lec");

        //======== panel2 ========
        {
            panel2.setBorder(new BevelBorder(BevelBorder.LOWERED));

            //---- button4 ----
            button4.setText("Demo file");
            button4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button4MouseClicked();
                    button4MouseClicked();
                }
            });
            button4.addActionListener(e -> button4(e));

            //---- button3 ----
            button3.setText("Regener S_lec");
            button3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        button3MouseClicked();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    // button3MouseClicked(e);
                }
            });

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel2Layout.createParallelGroup()
                                            .addComponent(button3, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                            .addComponent(button4, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
                                    .addContainerGap())
            );
            panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(button4)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                    .addComponent(button3)
                                    .addContainerGap())
            );
        }

        //======== panel3 ========
        {
            panel3.setBorder(new BevelBorder(BevelBorder.LOWERED));

            //---- button2 ----
            button2.setText("Reset");
            button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button2MouseClicked();
                    button2MouseClicked();
                }
            });

            //---- button1 ----
            button1.setText("Commencer");
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // button1MouseClicked(e);
                    try {
                        button1MouseClicked();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            button1.addActionListener(this::button1);

            GroupLayout panel3Layout = new GroupLayout(panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(button1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(button2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(39, Short.MAX_VALUE))
            );
            panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                    .addContainerGap(16, Short.MAX_VALUE)
                                    .addComponent(button1)
                                    .addGap(18, 18, 18)
                                    .addComponent(button2)
                                    .addContainerGap())
            );
        }

        //======== panel4 ========
        {
            panel4.setBorder(new BevelBorder(BevelBorder.LOWERED));
            panel4.setLayout(new MigLayout(
                    "hidemode 3",
                    // columns
                    "[fill]" +
                            "[fill]" +
                            "[fill]",
                    // rows
                    "[]" +
                            "[]" +
                            "[]"));

            //---- button5 ----
            button5.setText("Openn S_ecr");
            button5.addActionListener(e -> {
                try {
                    button5();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
            panel4.add(button5, "cell 2 0");

            //---- button6 ----
            button6.setText("Open L_ecr");
            button6.addActionListener(e -> {
                try {
                    button6();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
            panel4.add(button6, "cell 2 1");

            //---- button7 ----
            button7.setText("Open L_lec");
            button7.addActionListener(e -> {
                try {
                    button7();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
            panel4.add(button7, "cell 2 2");
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(label1)
                                        .addComponent(label3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label4))
                                                .addGap(326, 326, 326))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                                                .addGap(124, 124, 124)
                                                                .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                        .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(panel4, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))))
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2)
                                                .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label4)
                                                .addGap(51, 51, 51)
                                                .addComponent(panel4, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                                                .addGap(53, 53, 53))
                                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(label1)
                                                                .addGap(359, 359, 359)
                                                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))))
                                .addGap(13, 48, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
