package com.example.nguyenphuc.myapplication;

import java.io.Serializable;

public class Ticket implements Serializable {
    private String maVe, ngayDi, gaDi, gaDen;
    private String hoTen, sDT, ngayDen, nguoi, treEm;
    private boolean khuHoi;

    public Ticket(String maVe, String ngayDi, String gaDi, String gaDen) {
        this.maVe = maVe;
        this.ngayDi = ngayDi;
        this.gaDi = gaDi;
        this.gaDen = gaDen;
    }

    public boolean isKhuHoi() {
        return khuHoi;
    }

    public void setKhuHoi(boolean khuHoi) {
        this.khuHoi = khuHoi;
    }

    public Ticket(String maVe, String ngayDi, String gaDi, String gaDen, String hoTen, String sDT, String ngayDen, String nguoi, String treEm, boolean khuHoi) {
        this.maVe = maVe;
        this.ngayDi = ngayDi;
        this.gaDi = gaDi;
        this.gaDen = gaDen;
        this.hoTen = hoTen;
        this.sDT = sDT;
        this.ngayDen = ngayDen;
        this.nguoi = nguoi;
        this.treEm = treEm;
        this.khuHoi = khuHoi;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getNgayDi() {
        return ngayDi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getNgayDen() {
        return ngayDen;
    }

    public void setNgayDen(String ngayDen) {
        this.ngayDen = ngayDen;
    }

    public String getNguoi() {
        return nguoi;
    }

    public void setNguoi(String nguoi) {
        this.nguoi = nguoi;
    }

    public String getTreEm() {
        return treEm;
    }

    public void setTreEm(String treEm) {
        this.treEm = treEm;
    }

    public void setNgayDi(String ngayDi) {
        this.ngayDi = ngayDi;
    }

    public String getGaDi() {
        return gaDi;
    }

    public void setGaDi(String gaDi) {
        this.gaDi = gaDi;
    }

    public String getGaDen() {
        return gaDen;
    }

    public void setGaDen(String gaDen) {
        this.gaDen = gaDen;
    }
}
