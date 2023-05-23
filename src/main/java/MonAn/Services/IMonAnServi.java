package MonAn.Services;

import MonAn.Models.CongThuc;
import MonAn.Models.LoaiMonAn;
import MonAn.Models.MonAn;

import java.util.List;
import java.util.Set;

public interface IMonAnServi {
    public MonAn addNewMonAn(MonAn maMoi);
    public CongThuc addNewCongThuc(CongThuc ctMoi);
    public LoaiMonAn removeLoaiMonAn(int loaiMonAnId);
    public Set<MonAn> getMonAnThisTen (String tenMon, String nguyenLieu);
//    public List<MonAn> tinmkiemmonan(String tenmon, String nguyenlieu);
}
