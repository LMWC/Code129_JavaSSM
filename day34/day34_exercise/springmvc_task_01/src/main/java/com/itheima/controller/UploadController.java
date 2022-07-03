package com.itheima.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @PostMapping
    public String upload(HttpServletRequest request,MultipartFile file)throws Exception{
        //1.获取项目根路径下 images的具体路径
        String path = request.getServletContext().getRealPath("/images");
        //2.获取文件的名称
        String fileName = file.getOriginalFilename();
        //3.将文件名使用UUID进行替换，避免出现重名导致的错误
        //3.1获取文件的后缀名
        String extName = fileName.substring(fileName.lastIndexOf("."));
        //3.2使用UUID生成新的文件名
        String newFileName = UUID.randomUUID()+ extName;
        //4.将文件进行拷贝
        file.transferTo(new File(path+"/"+newFileName));
        return "success";
    }
}
