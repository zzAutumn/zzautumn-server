package com.yezi.zzautumn.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;

import java.io.FileInputStream;

/**
 * @Author: yezi
 * @Date: 2019/3/16 09 47
 * @Description:
 */
public class QiniuUtil {


    public OperationResult uploadImg(FileInputStream fs, String key) {
        OperationResult result = new OperationResult(false);
        // 构造一个带指定Zone对象的配置类 z2 华南
        Configuration cfg = new Configuration(Zone.zone2());
        // ...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //... 生成上传凭证，然后准备上传
        // 默认不指定key的情况下，以文件内容的hash值作为文件名
        try {
            Auth auth = Auth.create(QiniuConstant.accessKey, QiniuConstant.secretKey);
            String upToken = auth.uploadToken(QiniuConstant.bucket);
            try {
                Response response = uploadManager.put(fs, key, upToken, null, null);
                // 解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                String returnPath = QiniuConstant.path + "/" + putRet.key;
                result.setCode(StatusCode.RESULT_OK.getCode());
                result.setMsg("upload img success");
                result.setResult(true);
                result.setData(returnPath);
                return result;
            } catch (QiniuException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(StatusCode.RESULT_FAIL.getCode());
            result.setMsg(e.getMessage());
            return result;
        }
        result.setCode(StatusCode.RESULT_FAIL.getCode());
        return result;
    }


}
