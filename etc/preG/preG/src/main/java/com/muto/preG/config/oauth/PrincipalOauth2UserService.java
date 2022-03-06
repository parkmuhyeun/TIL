package com.muto.preG.config.oauth;

import com.muto.preG.account.Account;
import com.muto.preG.account.AccountRepository;
import com.muto.preG.account.PrincipalDetails;
import com.muto.preG.config.oauth.provider.GoogleUserInfo;
import com.muto.preG.config.oauth.provider.KakaoUserInfo;
import com.muto.preG.config.oauth.provider.NaverUserInfo;
import com.muto.preG.config.oauth.provider.OAuth2UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    private final AccountRepository accountRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser((userRequest));
        OAuth2UserInfo oAuth2UserInfo = null;

        String FlatForm = userRequest.getClientRegistration().getRegistrationId();
        oAuth2UserInfo = classifyFlatForm(oAuth2User, FlatForm);

        Account account = getAccount(oAuth2UserInfo);

        return new PrincipalDetails(account, oAuth2User.getAttributes());
    }

    private Account getAccount(OAuth2UserInfo oAuth2UserInfo) {
        String provider = oAuth2UserInfo.getProvider();
        String providerId = oAuth2UserInfo.getProviderId();
        String username = provider + "_" + providerId;
        String email = oAuth2UserInfo.getEmail();

        Account account = accountRepository.findByUsername(username);

        if (account == null) {
            account = Account.builder()
                    .username(username)
                    .email(email)
                    .provider(provider)
                    .provider_id(providerId)
                    .build();
            accountRepository.save(account);
        }

        return account;
    }

    private OAuth2UserInfo classifyFlatForm(OAuth2User oAuth2User, String FlatForm) {
        if (FlatForm.equals("google")) {
            return new GoogleUserInfo(oAuth2User.getAttributes());
        } else if (FlatForm.equals("naver")) {
            return new NaverUserInfo((Map) oAuth2User.getAttributes().get("response"));
        } else if (FlatForm.equals("kakao")) {
            return new KakaoUserInfo(oAuth2User.getAttributes());
        }
        // TODO 에러처리
        return null;
    }
}
