package MonAn.Repository;

import MonAn.Models.CongThuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CongThucRepo extends JpaRepository<CongThuc,Integer> {
}
