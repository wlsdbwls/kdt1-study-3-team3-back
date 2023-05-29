package kr.eddi.demo.account.service;

import kr.eddi.demo.account.controller.form.AccountLoginRequestForm;
import kr.eddi.demo.account.controller.form.AccountMyPageResponseForm;
import kr.eddi.demo.account.entity.RoleType;
import kr.eddi.demo.account.service.request.BusinessAccountRegisterRequest;
import kr.eddi.demo.account.service.request.NormalAccountRegisterRequest;

public interface AccountService {
    Boolean normalAccountRegister(NormalAccountRegisterRequest request);
    Boolean businessAccountRegister(BusinessAccountRegisterRequest request);
    String login(AccountLoginRequestForm requestForm);

    RoleType lookup(String userToken);

    Long findAccountId(String userToken);

    Boolean businessCheck(Long accountId);

    String findAccountEmail(Long accountId);
}
