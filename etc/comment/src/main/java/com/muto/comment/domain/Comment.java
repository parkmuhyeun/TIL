package com.muto.comment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder @NoArgsConstructor @AllArgsConstructor
public class Comment {

    @Id @GeneratedValue
    private Long id;

    private String content;

    private int groupNumber;

    private int groupOrder;

    private LocalDateTime createDateTime;
}
