package com.yezi.zzautumn.service;

import com.yezi.zzautumn.utils.OperationResult;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @Author: yezi
 * @Date: 2019/3/16 08 53
 * @Description:
 */
public interface ImageService {

    OperationResult uploadFile(FileInputStream inputStream, String fileName);
}
