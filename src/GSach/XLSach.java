/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GSach;
import java.sql.*;

/**
 *
 * @author buikh
 */
public class XLSach {
    private static Connection cn;
    
    public static void getcon(){
        if (cn == null){
            try {
                cn = DriverManager.getConnection("jdbc:sqlserver://BKAHUYYYYY;database=DLSach95;user=sa;password=1;trustServerCertificate=true;");
                System.out.println("pass getcon");
            } catch (SQLException e) {
                System.out.println("failed getcon "+ e.getMessage());
            }
        }
    }
    
    public static ResultSet getSA(){
        getcon();
        try {
            Statement st = cn.createStatement();
            return st.executeQuery("select * from tbSach");
        } catch (SQLException e) {
            System.out.println("failed getSA "+ e.getMessage());
            return null;
        }
    }
    
    public static boolean deleteSA(int namxb){
        getcon();
        try {
            PreparedStatement pst = cn.prepareStatement("delete tbSach where namxb = " + namxb);
            int res = pst.executeUpdate();
            return res>0;
        } catch (SQLException e) {
            System.out.println("failed deleteSA "+ e.getMessage());
            return false;
        }
    }
    
    
    //main for console
//    public static void main(String[] args) {
//        getcon();
//        getSA();
//        deleteSA(2020);
//    }
}
