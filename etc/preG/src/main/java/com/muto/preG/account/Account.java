package com.muto.preG.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Builder @Getter
@NoArgsConstructor @AllArgsConstructor
public class Account {

    @Id @GeneratedValue
    private Long id;

    private String username;

    private String nickname;

    private String email;

    private String provider;

    private String provider_id;

    private String email_check_token;

    private LocalDateTime email_check_token_time;

    private LocalDateTime create_date_time;
}
