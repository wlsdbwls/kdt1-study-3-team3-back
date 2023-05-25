package kr.eddi.demo.account.controller.form;

import kr.eddi.demo.account.entity.RoleType;
import kr.eddi.demo.account.service.request.NormalAccountRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NormalAccountRegisterForm {

    final private String email;
    final private String password;
    final private RoleType roleType;

    public NormalAccountRegisterRequest toAccountRegisterRequest () {

        return new NormalAccountRegisterRequest(
                email, password, roleType);
    }
}
