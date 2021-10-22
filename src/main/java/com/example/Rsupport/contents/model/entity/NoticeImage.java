package com.example.Rsupport.contents.model.entity;

import com.example.Rsupport.commons.enmuns.Status;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class NoticeImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long noticeImageId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "notice_id")
    private Notice noticeId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "file_id")
    private FileInfo fileInfoId;

    @Column(nullable = false, columnDefinition = "enum('Y','N')")
    @Enumerated(EnumType.STRING)
    private Status status = Status.N;

    private LocalDateTime createdDate;
}
