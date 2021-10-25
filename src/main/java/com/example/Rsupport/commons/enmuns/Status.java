package com.example.Rsupport.commons.enmuns;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;



@Getter
@RequiredArgsConstructor
public enum Status {
    Y("DELETED"),
    N("안삭제 뭐라고 해 영어로");
    private final String description;
}
