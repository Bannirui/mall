package com.example.mall.user.kafka;

import java.io.*;

/**
 *@author dingrui
 *@date 2021-02-24
 *@description java bean的序列化 反序列化
 */
public class JavaBeanSerializer {
    /**
     * @author dingrui
     * @date 2021/2/24
     * @param obj
     * @return
     * @description 对象序列化为byte数组
     */
    public static byte[] bean2Byte(Object obj) {
        byte[] byteArr = null;
        try (ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
             ObjectOutputStream outputStream = new ObjectOutputStream(byteArray)) {
            outputStream.writeObject(obj);
            outputStream.flush();
            byteArr = byteArray.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArr;
    }

    /**
     * @author dingrui
     * @date 2021/2/24
     * @param bytes
     * @return
     * @description 字节数组转为Object对象
     */
    public static Object byte2Obj(byte[] bytes) {
        Object readObject = null;
        try (ByteArrayInputStream in = new ByteArrayInputStream(bytes);
             ObjectInputStream inputStream = new ObjectInputStream(in)) {
            readObject = inputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readObject;
    }
}
