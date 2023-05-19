package dev.application.paymentInfo.Repository;

import dev.application.paymentInfo.Entity.Check;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckRepository extends JpaRepository<Check,Long> {
    Check findCheckById(Long id);
}
