package com.example.kkulaproject.FilesManage;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import org.springframework.web.multipart.MultipartFile;

@Service
public class Filesave {

    public String FilesaveGetUrl(MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String filecode = FileUploadUtil.saveFile(fileName, multipartFile);
        return "/downloadFile/" + filecode;
    }
    
}
