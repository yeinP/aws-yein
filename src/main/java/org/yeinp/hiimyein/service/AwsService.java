package org.yeinp.hiimyein.service;

import org.springframework.web.multipart.MultipartFile;
import org.yeinp.hiimyein.dto.FilesDto;

import java.util.List;

public interface AwsService {
    List<FilesDto> uploadImageMiss(List<MultipartFile> multipartFiles);

    FilesDto uploadPortUrl(MultipartFile multipartFile);
    Object deleteFiles(String fileName);

    String getRenamedFileName(String originalFileName, int count);

}
