package MonAn.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "conthuc")
public class CongThuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "conthucid")
    private int conThucId;
    @Column(name = "nguyenlieuid",insertable = false,updatable = false)
    private int nguyenLieuId;
    @Column(name = "monanid",insertable = false,updatable = false)
    private int monAnId;
    @Column(name = "soluong")
    private int soLuong;
    @Column(name = "donvitinh")
    private String donViTinh;
    @ManyToOne
    @JoinColumn(name = "monanid")
    @JsonBackReference
    private MonAn monAn;
    @ManyToOne
    @JoinColumn(name = "nguyenlieuid")
    @JsonBackReference
    private NguyenLieu nguyenLieu;

    public int getConThucId() {
        return conThucId;
    }

    public void setConThucId(int conThucId) {
        this.conThucId = conThucId;
    }

    public int getNguyenLieuId() {
        return nguyenLieuId;
    }

    public void setNguyenLieuId(int nguyenLieuId) {
        this.nguyenLieuId = nguyenLieuId;
    }

    public int getMonAnId() {
        return monAnId;
    }

    public void setMonAnId(int monAnId) {
        this.monAnId = monAnId;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public MonAn getMonAn() {
        return monAn;
    }

    public void setMonAn(MonAn monAn) {
        this.monAn = monAn;
    }

    public NguyenLieu getNguyenLieu() {
        return nguyenLieu;
    }

    public void setNguyenLieu(NguyenLieu nguyenLieu) {
        this.nguyenLieu = nguyenLieu;
    }
}
