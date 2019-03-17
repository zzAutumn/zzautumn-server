package com.yezi.zzautumn.controller;

import com.yezi.zzautumn.service.ImageService;
import com.yezi.zzautumn.utils.OperationResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: yezi
 * @Date: 2019/3/16 08 40
 * @Description:
 */
@Api(value = "上传图片", description = "上传图片")
@RestController
@RequestMapping("/zzautumn/v1/upload")
public class UploadController extends BaseController{

    @Autowired
    ImageService imageService;

    @PostMapping(value = "/img", consumes = "multipart/*", headers = "content-type=multipart/form-data")
    public OperationResult uploadImg(@ApiParam(name="file",allowMultiple = true,required = true) MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        return imageService.uploadFile((FileInputStream)file.getInputStream(), fileName);
    }

}
