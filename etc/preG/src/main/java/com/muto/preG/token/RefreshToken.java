package com.muto.preG.token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder @Getter @NoArgsConstructor @AllArgsConstructor
public class RefreshToken {

    @Id @GeneratedValue
    private Long id;

    private String token;
}
