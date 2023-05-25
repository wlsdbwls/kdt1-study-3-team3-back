package kr.eddi.demo.account.repository;

import kr.eddi.demo.account.entity.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRoleRepository extends JpaRepository<AccountRole, Long> {
    Optional<AccountRole> findByBusinessNumber(Long businessNumber);
}
