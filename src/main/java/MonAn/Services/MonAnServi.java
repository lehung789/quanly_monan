package MonAn.Services;

import MonAn.Models.CongThuc;
import MonAn.Models.LoaiMonAn;
import MonAn.Models.MonAn;
import MonAn.Models.NguyenLieu;
import MonAn.Repository.CongThucRepo;
import MonAn.Repository.LoaiMonAnRepo;
import MonAn.Repository.MonAnRepo;
import MonAn.Repository.NguyenLieuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class MonAnServi implements IMonAnServi {
    @Autowired
    private MonAnRepo monAnRepo;
    @Autowired
    private CongThucRepo congThucRepo;
    @Autowired
    private NguyenLieuRepo nguyenLieuRepo;
    @Autowired
    private LoaiMonAnRepo loaiMonAnRepo;

    @Override
    public MonAn addNewMonAn(MonAn maMoi) {
        monAnRepo.save(maMoi);
        return maMoi;
    }

    @Override
    public CongThuc addNewCongThuc(CongThuc ctMoi) {
        congThucRepo.save(ctMoi);
        Optional<MonAn> ma = monAnRepo.findById(ctMoi.getMonAn().getMonAnId());
        Optional<NguyenLieu> nl = nguyenLieuRepo.findById(ctMoi.getNguyenLieu().getNguyenLieuId());
        ma.get().setCachLam(ma.get().getCachLam() +" "+nl.get().getTenNguyenLieu()+" "+String.valueOf(ctMoi.getSoLuong())+" "+ctMoi.getDonViTinh());
        monAnRepo.save(ma.get());
        return ctMoi;
    }

//    @Override
//    public CongThuc addNewCongThuc(CongThuc ctMoi) {
//        CongThuc congThuc = congThucRepo.save(ctMoi);
//        Optional<MonAn> optionalMonAn = monAnRepo.findById(ctMoi.getMonAnId());
//        Optional<NguyenLieu> optionalNguyenLieu = nguyenLieuRepo.findById(ctMoi.getNguyenLieuId());
//
//        if (optionalMonAn.isPresent() && optionalNguyenLieu.isPresent()) {
//            MonAn monAn = optionalMonAn.get();
//            NguyenLieu nguyenLieu = optionalNguyenLieu.get();
//
//            String cachLam = monAn.getCachLam() + "\n" + nguyenLieu.getTenNguyenLieu() + ": " + ctMoi.getSoLuong() + " " + ctMoi.getDonViTinh();
//            monAn.setCachLam(cachLam);
//            monAnRepo.save(monAn);
//            return congThuc;
//        } else {
//            throw new RuntimeException("Không tìm thấy món ăn hoặc nguyên liệu tương ứng");
//        }
//    }

    @Override
    public LoaiMonAn removeLoaiMonAn(int loaiMonAnId) {
        Optional<LoaiMonAn> loaiMonAn = loaiMonAnRepo.findById(loaiMonAnId);
        if (loaiMonAn.isEmpty())
            return null;
        loaiMonAnRepo.delete(loaiMonAn.get());
        return loaiMonAn.get();
    }

    @Override
    public Set<MonAn> getMonAnThisTen(String tenMon, String nguyenLieu) {
        Set<MonAn> monAns = new HashSet<>();
        monAnRepo.findAll().forEach(x-> {
            if (x.getTenMon().toLowerCase().contains(tenMon.toLowerCase())) {
                if (x.getCachLam().toLowerCase().contains(nguyenLieu.toLowerCase()))
                monAns.add(x);
                x.getCongThucs().forEach(y -> {
                    if (y.getNguyenLieu().getTenNguyenLieu().toLowerCase().contains(nguyenLieu.toLowerCase()))
                        monAns.add(x);

                });
            }
        });
        return monAns;
    }
//    @Override
//    public List<MonAn> tinmkiemmonan(String tenmon,String nguyenlieu) {
//        List<MonAn> monAnList =new ArrayList<>();
//
//        List<CongThuc> lstCongThuc = congThucRepo.findAll();
//
//        for(MonAn x : monAnRepo.findAll()){
//            if(x.getTenMon().toLowerCase().contains(tenmon.toLowerCase())){
//                monAnList.add(x);
//            }
//        }
//        List<MonAn> result = new ArrayList<>();
//
//        for (MonAn mon: monAnList){
//            List<CongThuc> lst = new ArrayList<>();
//            for (CongThuc ct: lstCongThuc
//            ) {
//                if(ct.getMonAns().getMonanid() == mon.getMonanid())
//                {
//                    if(ct.getNguyenLieus().getTenNguyenLieu().toLowerCase().contains(nguyenlieu.toLowerCase()))
//                    {
//                        result.add(mon);
//                    }
//                }
//
//            }
//        }
//        return result;
//    }

}