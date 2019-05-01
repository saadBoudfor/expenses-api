package fr.boudfor.app.persistences;

import fr.boudfor.app.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PaymentRepository  extends JpaRepository<Payment, Long> {
}