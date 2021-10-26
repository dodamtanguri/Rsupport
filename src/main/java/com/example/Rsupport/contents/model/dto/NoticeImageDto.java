package com.example.Rsupport.contents.model.dto;

import com.example.Rsupport.contents.model.entity.NoticeImage;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoticeImageDto {
    private long noticeId;
    private String originalFileName;
    private String saveFileName;
    private String contentType;

    @Builder
    public NoticeImageDto(long noticeId, String originalFileName, String saveFileName, String contentType) {
        this.noticeId = noticeId;
        this.originalFileName = originalFileName;
        this.saveFileName = saveFileName;
        this.contentType = contentType;
    }

    public NoticeImage toEntity() {
        return NoticeImage.builder()
                .noticeId(noticeId)
                .saveFileName(saveFileName)
                .originalFileName(originalFileName)
                .contentType(contentType)
                .build();
    }

}
