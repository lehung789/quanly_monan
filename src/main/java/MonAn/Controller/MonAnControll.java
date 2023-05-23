package MonAn.Controller;

import MonAn.Models.CongThuc;
import MonAn.Models.LoaiMonAn;
import MonAn.Models.MonAn;
import MonAn.Services.MonAnServi;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class MonAnControll {
    @Autowired
    private MonAnServi monAnServi;
    @RequestMapping(value = "them1monan", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public MonAn addNewMonAn(@RequestBody String maMoi){
        Gson gson = new Gson();
        MonAn ma = gson.fromJson(maMoi, MonAn.class);
         monAnServi.addNewMonAn(ma);
        return ma;
    }
    @RequestMapping(value = "themcongthuc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public CongThuc addNewCongThuc(@RequestBody String ctMoi){
        Gson gson = new Gson();
        CongThuc ct = gson.fromJson(ctMoi, CongThuc.class);
        monAnServi.addNewCongThuc(ct);
        return ct;
    }
    @RequestMapping(value = "xoaloaimonan", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoaiMonAn removeLoaiMonAn(@RequestParam int loaiMonAnId){
        return monAnServi.removeLoaiMonAn(loaiMonAnId);
    }
    @RequestMapping(value = "laymonan",method = RequestMethod.GET)
    public Set<MonAn> getMonAnThisTen (@RequestParam String tenMon, @RequestParam String nguyenLieu){
        return monAnServi.getMonAnThisTen(tenMon,nguyenLieu);
    }
//    @RequestMapping(value = "timkiemmonan",method = RequestMethod.GET)
//    public List<MonAn> tinmkiemmonan (@RequestParam String tenmon, @RequestParam String nguyenlieu){
//        return monAnServi.tinmkiemmonan(tenmon,nguyenlieu);

}
