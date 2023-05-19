package dev.application.paymentInfo.Repository;

import dev.application.paymentInfo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.DoubleStream;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User getUserById(Long id);

    User findByUsername(String username);
}
