package org.yeinp.hiimyein.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FilesDto {

    private String originFileName;
    private String renamedFileName;
    private String fileUrl;
}
