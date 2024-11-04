/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GSach;

/**
 *
 * @author buikh
 */
public class Tailieu {
    private String mas, tens;
    private int namxb, giab;

    public String getMas() {
        return mas;
    }

    public String getTens() {
        return tens;
    }

    public int getNamxb() {
        return namxb;
    }

    public int getGiab() {
        return giab;
    }

    public void setMas(String mas) {
        this.mas = mas;
    }

    public void setTens(String tens) {
        this.tens = tens;
    }

    public void setNamxb(int namxb) {
        this.namxb = namxb;
    }

    public void setGiab(int giab) {
        this.giab = giab;
    }

    public Tailieu() {
        this.mas = "";
        this.tens = "";
        this.namxb = 0;
        this.giab = 0;
    }

    public Tailieu(String mas, String tens, int namxb, int giab) {
        this.mas = mas;
        this.tens = tens;
        this.namxb = namxb;
        this.giab = giab;
    }

    public Tailieu(String mas, String tens) {
        this.mas = mas;
        this.tens = tens;
    }
      
    public int thanhtien(int namxb, int giab){
        int thanhtien = 0;
        if(namxb <= 2015){
            thanhtien = giab * 85 / 100;
        }
        else {
            thanhtien = giab * 95 /100;
        }
        return thanhtien;
    }
    
}
