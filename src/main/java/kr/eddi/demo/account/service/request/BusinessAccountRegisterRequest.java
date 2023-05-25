package kr.eddi.demo.account.service.request;

import kr.eddi.demo.account.entity.Account;
import kr.eddi.demo.account.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessAccountRegisterRequest {
    final private String email;
    final private String password;
    final private RoleType roleType;
    final private Long businessNumber;

    public Account toAccount () {
        return new Account(email, password);
    }
}
