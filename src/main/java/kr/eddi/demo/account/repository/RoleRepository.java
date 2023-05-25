package kr.eddi.demo.account.repository;

import kr.eddi.demo.account.entity.Role;
import kr.eddi.demo.account.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleType(RoleType roleType);
}
