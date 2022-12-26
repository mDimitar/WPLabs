package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepoJPA extends JpaRepository<Order, Long> {
    List<Order> findAllByDateTimeAfterAndDateTimeBefore(LocalDateTime from, LocalDateTime to);
}
