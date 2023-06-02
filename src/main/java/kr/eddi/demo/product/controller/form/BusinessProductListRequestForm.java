package kr.eddi.demo.product.controller.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
public class BusinessProductListRequestForm {

    private String userToken;

    public BusinessProductListRequestForm(String userToken) {
        this.userToken = userToken;
    }
}
