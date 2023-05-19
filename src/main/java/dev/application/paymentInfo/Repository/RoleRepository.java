package dev.application.paymentInfo.Repository;

import dev.application.paymentInfo.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
