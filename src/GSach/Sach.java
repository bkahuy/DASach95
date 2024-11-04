/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GSach;

/**
 *
 * @author buikh
 */
public class Sach extends Tailieu{
    private int namxb, giab;

    public int getNamxb() {
        return namxb;
    }

    public int getGiab() {
        return giab;
    }

    public void setNamxb(int namxb) {
        this.namxb = namxb;
    }

    public void setGiab(int giab) {
        this.giab = giab;
    }

    public Sach(int namxb, int giab) {
        this.namxb = namxb;
        this.giab = giab;
    }

    public Sach(String mas, String tens, int namxb, int giab) {
        super(mas, tens);
        this.namxb = namxb;
        this.giab = giab;
    }

    @Override
    public int thanhtien(int namxb, int giab) {
        return super.thanhtien(namxb, giab); 
    }

    
}
