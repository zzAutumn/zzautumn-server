package com.yezi.zzautumn.service.impl;

import com.yezi.zzautumn.service.ImageService;
import com.yezi.zzautumn.utils.OperationResult;
import com.yezi.zzautumn.utils.QiniuUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;

/**
 * @Author: yezi
 * @Date: 2019/3/16 08 55
 * @Description:
 */
@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    @Override
    public OperationResult uploadFile(FileInputStream inputStream, String fileName) {
        QiniuUtil qiniuUtil = new QiniuUtil();
        return qiniuUtil.uploadImg(inputStream, fileName);
    }
}
