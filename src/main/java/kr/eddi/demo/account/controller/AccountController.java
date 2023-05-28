package kr.eddi.demo.account.controller;

import kr.eddi.demo.account.controller.form.AccountLoginRequestForm;
import kr.eddi.demo.account.controller.form.BusinessAccountRegisterForm;
import kr.eddi.demo.account.controller.form.BusinessCheckRequestForm;
import kr.eddi.demo.account.controller.form.NormalAccountRegisterForm;
import kr.eddi.demo.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    final private AccountService accountService;

    @PostMapping("/normal-register")
    public Boolean normalAccountRegister (@RequestBody NormalAccountRegisterForm requestForm) {
        return accountService.normalAccountRegister(requestForm.toAccountRegisterRequest());
    }

    @PostMapping("/business-register")
    public Boolean businessAccountRegister (@RequestBody BusinessAccountRegisterForm requestForm) {
        return accountService.businessAccountRegister(requestForm.toAccountRegisterRequest());
    }

    @PostMapping("/login")
    public String accountLogin(@RequestBody AccountLoginRequestForm accountLoginRequestForm) {
        String userToken = accountService.login(accountLoginRequestForm);
        return userToken;
    }
    @PostMapping("/businessCheck")
    public Boolean isBusiness(@RequestBody BusinessCheckRequestForm requestForm){
       log.info(requestForm.getUserToken());
       String userToken= requestForm.getUserToken();
        Long businessId=accountService.findAccountId(userToken);
        log.info("businessId: "+businessId);
        if (businessId==null){
            return false;
        }
        Boolean isBusinessMan= accountService.businessCheck(businessId);
        log.info(String.valueOf(isBusinessMan));
        return isBusinessMan;
    }
}
