package MonAn.Repository;

import MonAn.Models.MonAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonAnRepo extends JpaRepository<MonAn,Integer> {
}
