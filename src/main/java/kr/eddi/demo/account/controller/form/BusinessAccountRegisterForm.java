package kr.eddi.demo.account.controller.form;

import kr.eddi.demo.account.entity.RoleType;
import kr.eddi.demo.account.service.request.BusinessAccountRegisterRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BusinessAccountRegisterForm {
    final private String email;
    final private String password;
    final private RoleType roleType;
    final private Long businessNumber; //사업자 등록번호

    public BusinessAccountRegisterRequest toAccountRegisterRequest () {

        return new BusinessAccountRegisterRequest(
                email, password, roleType, businessNumber);
    }
}
