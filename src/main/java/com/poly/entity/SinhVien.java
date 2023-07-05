package com.poly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sinhVien")
@Entity
public class SinhVien {

    @Id
    @Column(name = "maSV")
    private String maSV;

    @Column(name = "tenSV")
    private String tenSV;

    @Column(name = "tuoi")
    private int tuoi;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "gioiTinh")
    private boolean gioiTinh;


    public SinhVien() {
    }

    public SinhVien(String maSV, String tenSV, int tuoi, String diaChi, boolean gioiTinh) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.tuoi = tuoi;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void display() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSV='" + maSV + '\'' +
                ", tenSV='" + tenSV + '\'' +
                ", tuoi=" + tuoi +
                ", diaChi='" + diaChi + '\'' +
                ", gioiTinh=" + gioiTinh +
                '}';
    }
}
