package kr.eddi.demo.account.repository;

import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class UserTokenRepositoryImpl implements UserTokenRepository{
    private static final UserTokenRepository INSTANCE = new UserTokenRepositoryImpl();
    private final Map<String, Long> userTokenMap = new HashMap<>();
    public static UserTokenRepository getInstance () {
        return INSTANCE;
    }
    @Override
    public void save(String userToken, Long id) {
        userTokenMap.put(userToken, id);
    }

    @Override
    public Long findAccountIdByUserToken(String userToken) {
//        userTokenMap.put("3031518d-a116-4244-aa4d-5b90561a2e55",1L)
        // 로그인 후 스프링 재실행 시 상품 등록 테스트할 때 userToken 가지고 하는 방법
        return userTokenMap.get(userToken);
    }
}
