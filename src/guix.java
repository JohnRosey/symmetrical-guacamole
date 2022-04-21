import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import Couche.CTransport.TransportCouche;
import Couche.Session.GenerationOfStart.Generer;
import Couche.Session.GenerationOfStart.generateSlec;
import Outil.fileUtility;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
/*
 * Created by JFormDesigner on Wed Apr 20 02:41:17 EDT 2022
 */



/**
 * @author ismael
 */
public class guix extends JFrame {
    public guix() {
        initComponents();
        boolean ecrire=false;
    }

    private void button1MouseClicked(MouseEvent e) {

        TransportCouche transport = new TransportCouche();
        //fileUtility.Generate_S_lec("Couche/Session/S_lec.txt");
System.out.println("here");
        transport.DemarrerCommunication();
    }

    private void button2MouseClicked(MouseEvent e) {
        S_lec.setText("");
        S_ecr.setText("");
        L_ecr.setText("");
        L_lec.setText("");
        fileUtility.Erase("src/Couche/Session/S_ecr.txt");
        fileUtility.Erase("src/Couche/LiasonDonnee/L_ecr.txt");
        fileUtility.Erase("src/Couche/LiasonDonnee/L_lec.txt");
        fileUtility.Erase("src/Couche/Session/S_lec.txt");
        System.out.println("erase");
    }

    private void button1(ActionEvent e) {
        try
        {
            //Probleme ici vous devez ccliquer 2 fois sur le bouton pour lancer la communication
            FileReader reader = new FileReader( "src/Couche/Session/S_lec.txt" );
            FileReader reader2 = new FileReader( "src/Couche/Session/S_ecr.txt" );
            FileReader reader3 = new FileReader( "src/Couche/LiasonDonnee/L_ecr.txt" );
            FileReader reader4 = new FileReader( "src/Couche/LiasonDonnee/L_lec.txt" );
            BufferedReader br2 = new BufferedReader( reader2 );
            BufferedReader br = new BufferedReader(reader);
            BufferedReader br3 = new BufferedReader(reader3);
            BufferedReader br4 = new BufferedReader(reader4);
            S_lec.read( br, null );
            S_ecr.read( br2, null );
            L_ecr.read( br3, null );
            L_lec.read( br4, null );

            br.close();
            br2.close();
            br3.close();
            br4.close();

        }
        catch(Exception e2) { System.out.println(e2); }
    }



    private void button4MouseClicked(MouseEvent e) {
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
                        "22          1234        LIB" ;
        File filepath= new File("src/Couche/Session/S_lec.txt");

        try{
            if(!filepath.exists()) {
                final var newFile = filepath.createNewFile();
            }
            FileWriter fileWriter= new FileWriter(filepath);
            fileWriter.write(data);
            fileWriter.flush();
System.out.println("Fichier demo chargee");
fileWriter.close();


        } catch (IOException g) {
            g.printStackTrace();
        }
    }   



    private void button3MouseClicked(MouseEvent e) throws IOException {
        generateSlec.RandomData();
        System.out.println("donnees aleatoires generees");
    }

    private void button4(ActionEvent e) {
        // TODO add your code here
    }




    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - ismael
        this.label1 = new JLabel();
        this.label4 = new JLabel();
        this.panel1 = new JPanel();
        this.scrollPane2 = new JScrollPane();
        this.L_lec = new JTextArea();
        this.scrollPane1 = new JScrollPane();
        this.S_lec = new JTextArea();
        this.scrollPane4 = new JScrollPane();
        this.S_ecr = new JTextArea();
        this.scrollPane3 = new JScrollPane();
        this.L_ecr = new JTextArea();
        this.label2 = new JLabel();
        this.label3 = new JLabel();
        this.panel2 = new JPanel();
        this.button4 = new JButton();
        this.button3 = new JButton();
        this.panel3 = new JPanel();
        this.button2 = new JButton();
        this.button1 = new JButton();

        //======== this ========
        setTitle("PROJET DE SESSION INF1009");
        var contentPane = getContentPane();

        //---- label1 ----
        this.label1.setText("S_lec");

        //---- label4 ----
        this.label4.setText("L_ecr");

        //======== panel1 ========
        {
            this.panel1.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
            this.panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
            swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border
            .TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog"
            ,java.awt.Font.BOLD,12),java.awt.Color.red),this.panel1. getBorder
            ()));this.panel1. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java
            .beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException
            ();}});

            //======== scrollPane2 ========
            {

                //---- L_lec ----
                this.L_lec.setFont(new Font(Font.MONOSPACED, Font.BOLD | Font.ITALIC, 10));
                this.scrollPane2.setViewportView(this.L_lec);
            }

            //======== scrollPane1 ========
            {

                //---- S_lec ----
                this.S_lec.setFont(new Font(Font.MONOSPACED, Font.BOLD | Font.ITALIC, 10));
                this.scrollPane1.setViewportView(this.S_lec);
            }

            //======== scrollPane4 ========
            {

                //---- S_ecr ----
                this.S_ecr.setFont(new Font(Font.MONOSPACED, Font.BOLD | Font.ITALIC, 10));
                this.scrollPane4.setViewportView(this.S_ecr);
            }

            //======== scrollPane3 ========
            {

                //---- L_ecr ----
                this.L_ecr.setFont(new Font(Font.MONOSPACED, Font.BOLD | Font.ITALIC, 10));
                this.scrollPane3.setViewportView(this.L_ecr);
            }

            GroupLayout panel1Layout = new GroupLayout(this.panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(this.scrollPane2, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                            .addComponent(this.scrollPane1))
                        .addGap(68, 68, 68)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(this.scrollPane4)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(this.scrollPane3, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 11, Short.MAX_VALUE)))
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(this.scrollPane4, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.scrollPane1, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(this.scrollPane2, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(15, Short.MAX_VALUE))
                            .addComponent(this.scrollPane3, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)))
            );
        }

        //---- label2 ----
        this.label2.setText("S_ecr");

        //---- label3 ----
        this.label3.setText("L_lec");

        //======== panel2 ========
        {
            this.panel2.setBorder(new BevelBorder(BevelBorder.LOWERED));

            //---- button4 ----
            this.button4.setText("Demo file");
            this.button4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button4MouseClicked(e);
                    button4MouseClicked(e);
                }
            });
            this.button4.addActionListener(e -> button4(e));

            //---- button3 ----
            this.button3.setText("Regener S_lec");
            this.button3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        button3MouseClicked(e);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    //button3MouseClicked(e);
                }
            });

            GroupLayout panel2Layout = new GroupLayout(this.panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel2Layout.createParallelGroup()
                            .addComponent(this.button3, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                            .addComponent(this.button4, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE))
                        .addContainerGap())
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(this.button4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(this.button3)
                        .addContainerGap())
            );
        }

        //======== panel3 ========
        {
            this.panel3.setBorder(new BevelBorder(BevelBorder.LOWERED));

            //---- button2 ----
            this.button2.setText("Reset");
            this.button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button2MouseClicked(e);
                    button2MouseClicked(e);
                }
            });

            //---- button1 ----
            this.button1.setText("Commencer");
            this.button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button1MouseClicked(e);
                    button1MouseClicked(e);
                }
            });
            this.button1.addActionListener(e -> button1(e));

            GroupLayout panel3Layout = new GroupLayout(this.panel3);
            panel3.setLayout(panel3Layout);
            panel3Layout.setHorizontalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(panel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(this.button1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                            .addComponent(this.button2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(39, Short.MAX_VALUE))
            );
            panel3Layout.setVerticalGroup(
                panel3Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                        .addContainerGap(16, Short.MAX_VALUE)
                        .addComponent(this.button1)
                        .addGap(18, 18, 18)
                        .addComponent(this.button2)
                        .addContainerGap())
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(this.label1)
                        .addComponent(this.label3))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(this.panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(this.label2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                .addComponent(this.label4))
                            .addGap(595, 595, 595))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(this.panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                    .addGap(124, 124, 124)
                                    .addComponent(this.panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(this.label2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
                            .addGap(2, 2, 2)
                            .addComponent(this.panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(this.label4)
                            .addGap(84, 84, 84)
                            .addComponent(this.panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(247, 247, 247))
                        .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(this.panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(this.label1)
                                    .addGap(359, 359, 359)
                                    .addComponent(this.label3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))))
                    .addGap(13, 49, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
/*public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new guix().setVisible(true);
            }
        });*/

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - ismael
    private JLabel label1;
    private JLabel label4;
    private JPanel panel1;
    private JScrollPane scrollPane2;
    private JTextArea L_lec;
    private JScrollPane scrollPane1;
    private JTextArea S_lec;
    private JScrollPane scrollPane4;
    private JTextArea S_ecr;
    private JScrollPane scrollPane3;
    private JTextArea L_ecr;
    private JLabel label2;
    private JLabel label3;
    private JPanel panel2;
    private JButton button4;
    private JButton button3;
    private JPanel panel3;
    private JButton button2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
