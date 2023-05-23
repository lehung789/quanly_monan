package MonAn.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "loaimonan")
public class LoaiMonAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loaimonanid")
    private int loaiMonAnId;
    @Column(name = "tenloai")
    private String tenLoai;
    @Column(name = "mota")
    private String moTa;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "loaiMonAn",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<MonAn> monAns;

    public int getLoaiMonAnId() {
        return loaiMonAnId;
    }

    public void setLoaiMonAnId(int loaiMonAnId) {
        this.loaiMonAnId = loaiMonAnId;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Set<MonAn> getMonAns() {
        return monAns;
    }

    public void setMonAns(Set<MonAn> monAns) {
        this.monAns = monAns;
    }
}
