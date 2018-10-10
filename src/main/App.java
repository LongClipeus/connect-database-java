/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.MySqlCon;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.JType;

/**
 *
 * @author root
 */
public class App {

    private static List<Object> mListJ;

    private static JFrame mMainFrame;

    private static void initView() {
        mListJ = new ArrayList<>();
        mMainFrame = new JFrame("Vi du Java Swing");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        initView();

        try {
            // TODO code application logic here
            MySqlCon connect = new MySqlCon();
            if (connect.getMySQLConnection() != null) {
                System.out.println("thanh cong " + connect);
            } else {
                System.out.println("that bai");
            }

            mListJ = connect.select();

            int i = mListJ.size();
            while (i != 0) {
                --i;
                JType jType = (JType) mListJ.get(i);
                if (jType.getType().equals("JFrame")) {
                    mMainFrame.setSize(400, 400);
//                    mMainFrame.setLayout(null);
                    mMainFrame.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent windowEvent) {
                            System.exit(0);
                        }
                    });
                } else if (jType.getType().equals("JLabel")) {
                    JLabel welcome = new JLabel(jType.getText());
                   // welcome.setText(jType.getText());
                    welcome.setOpaque(true);
                    welcome.setBackground(Color.GRAY);
                    welcome.setForeground(Color.WHITE);
                    mMainFrame.add(welcome);
                } else if (jType.getType().equals("Button")) {
                    JButton btn = new JButton(jType.getText());
                    btn.setBounds(100,100,100,30);
                    btn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.out.println("click button Ok");
                        }
                    });
                    mMainFrame.add(btn);
                }
            }
//            Test h = new Test();
//            new Statement(h, "myFunc", new Object[]{"Hello world"}).execute();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        mMainFrame.setVisible(true);
    }

}
