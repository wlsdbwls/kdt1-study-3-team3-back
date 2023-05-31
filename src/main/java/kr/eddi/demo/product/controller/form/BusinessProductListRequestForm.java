package kr.eddi.demo.product.controller.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
public class BusinessProductListRequestForm {

    private String userToken;

    public BusinessProductListRequestForm(String userToken) {
        this.userToken = userToken;
    }
}
