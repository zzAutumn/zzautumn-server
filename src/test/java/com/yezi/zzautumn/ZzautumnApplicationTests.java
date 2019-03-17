package com.yezi.zzautumn;

import com.yezi.zzautumn.utils.QiniuConstant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZzautumnApplicationTests {


    @Test
    public void contextLoads() {
    }

    @Test
    public void testProperty() {
        System.out.println(QiniuConstant.accessKey);
    }

}

