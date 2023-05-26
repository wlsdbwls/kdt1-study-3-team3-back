package kr.eddi.demo.account.repository;

import kr.eddi.demo.account.entity.Account;

import java.util.Optional;

public interface UserTokenRepository {
    void save(String userToken, Long id);

    Long findAccountIdByUserToken(String userToken);
}
