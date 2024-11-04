/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GSach;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author buikh
 */
public class Gui_delSA extends JFrame implements MouseListener, ActionListener{
    
    private JComboBox<String> cbnamxb;
    private JButton btnxoa;
    private JTable tb;
    private DefaultTableModel dfmodel;

    public Gui_delSA(){
        setTitle("xoa sach");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,600);
        
        BuildGui();
        loadData(dfmodel);
    }
    
    private void BuildGui(){
        JPanel pntrai = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // nam xuat ban
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel lbnamxb = new JLabel("nam xuat ban");
        pntrai.add(lbnamxb,gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        cbnamxb = new JComboBox<>(new String[]{"2019", "2020", "2021"});
        pntrai.add(cbnamxb,gbc);
        
        //btn
        gbc.gridx = 1;
        gbc.gridy = 2;
        btnxoa = new JButton("xoa sach");
        btnxoa.addActionListener((e) -> {
            
            XLSach xl = new XLSach();
            int nam = Integer.parseInt(cbnamxb.getSelectedItem().toString());
            boolean res = xl.deleteSA(nam);
            if(res){
                loadData(dfmodel);
                JOptionPane.showMessageDialog(null, "xoa sach thanh cong");
            }
            else {
                JOptionPane.showMessageDialog(null, "xoa khong thanh cong");
            }
        });
        pntrai.add(btnxoa,gbc);
        
        //table
        JPanel pnphai = new JPanel(new GridLayout(1, 1));
        String[] header = {"ma sach", "ten sach", "nam xuat ban", "gia ban", "thanh tien"};
        dfmodel = new DefaultTableModel(header,0);
        tb = new JTable(dfmodel);
        pnphai.add(new JScrollPane(tb));
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(pntrai, BorderLayout.WEST);
        getContentPane().add(pnphai, BorderLayout.CENTER);
    }
    
    private void loadData(DefaultTableModel dfmodel){
        try {
            XLSach xl = new XLSach();
            ResultSet res = xl.getSA();
            if(res != null){
                while(res.next()){
                    Sach s = new Sach(res.getString("mas"), res.getString("tens"), res.getInt("namxb"), res.getInt("giab"));
                    
                    int thanhtien = s.thanhtien(s.getNamxb(), s.getGiab());
                    
                    dfmodel.addRow(new Object[]{
                        s.getMas(),
                        s.getTens(),
                        s.getNamxb(),
                        s.getGiab(),
                        thanhtien
                    });
                }
            }
            dfmodel.fireTableDataChanged();
        } catch (SQLException e) {
            System.out.println("failed loaddata "+ e.getMessage());
        }
    }
    
    
    
    public static void main(String[] args) {
        new Gui_delSA().setVisible(true);
    }
    
    
    
    
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
