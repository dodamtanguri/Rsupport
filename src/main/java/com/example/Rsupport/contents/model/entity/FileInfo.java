package com.example.Rsupport.contents.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class FileInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long fileInfoId;

    private String fileName;
    private String saveFileName;
    private String contentType;
    private LocalDateTime createDate;

}
