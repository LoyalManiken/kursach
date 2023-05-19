package dev.application.paymentInfo.Repository;

import dev.application.paymentInfo.Entity.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentType,Long> {
    PaymentType getPaymentTypeById(Long id);
}
