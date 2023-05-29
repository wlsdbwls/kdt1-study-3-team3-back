package kr.eddi.demo.account.controller.form;

import kr.eddi.demo.account.entity.RoleType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountMyPageResponseForm {
    final private String email;
    final private RoleType roleType;
}
