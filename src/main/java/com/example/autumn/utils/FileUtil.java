package com.example.autumn.utils;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Jagi
 * @Date 2020/11/29
 */

public class FileUtil {


    /**
     * 获取文件后缀名
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 使用uuid作为图片的新文件名
     * @param fileOriginName
     * @return
     */
    public static String getFileName(String fileOriginName) {
        return getUUID() + getSuffix(fileOriginName);
    }

    /**
     * 生成随机的UUID
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String upload(MultipartFile file, String path, String fileName) {
        String newFileName = getFileName(fileName);
        String realPath = path + newFileName;
        File dest = new File(realPath);

        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try {
            file.transferTo(dest);
            return newFileName;
        } catch (IllegalStateException | IOException e){
            e.printStackTrace();
            return null;
        }
    }


}
