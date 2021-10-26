package com.example.Rsupport.contents.model.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class NoticeImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "notice_id",nullable = false)
//    private NoticeEntity noticeId;

    @Column(nullable = false)
    private long noticeId;

    @Column(nullable = false)
    private String originalFileName;  // 파일 원본명

    @Column(nullable = false)
    private String saveFileName;  // 저장 파일 이름

    @Column(nullable = false)
    private String contentType;

    @Builder
    public NoticeImage( long noticeId, String originalFileName, String saveFileName, String contentType) {
        this.noticeId = noticeId;
        this.originalFileName = originalFileName;
        this.saveFileName = saveFileName;
        this.contentType = contentType;
    }

}
