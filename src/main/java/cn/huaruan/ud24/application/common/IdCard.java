/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package cn.huaruan.ud24.application.common;


import cn.huaruan.ud24.application.AppAsserts;
import cn.huaruan.ud24.application.exception.AppRunException;
import cn.huaruan.ud24.vo.IdCardUpload;
import cn.huaruan.ud24.vo.IdCards;
import com.google.gson.internal.LinkedTreeMap;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLEncoder;

/**
 * 身份证识别
 *
 * @author qq
 */
public class IdCard {


    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static Object recognize(IdCardUpload idCardUpload) {
        MultipartFile file = idCardUpload.getFile();
        if (file == null || file.isEmpty()) {
            AppAsserts.no(true, "请选择文件！");
        }
        String path = FileUtils.upload("timely_courier/id_card/"+idCardUpload.getTel(), file);
        // 身份证识别url
        String idcardIdentificate = "https://aip.baidubce.com/rest/2.0/ocr/v1/idcard";
        // 本地图片路径
        IdCards idCards = new IdCards();
        LinkedTreeMap hashMap = new LinkedTreeMap();
        try {
            byte[] imgData = FileUtils.readFileByBytes(FileUtils.PATH + path);
            String imgStr = Base64Util.encode(imgData);

            // 识别身份证正面id_card_side=front;识别身份证背面id_card_side=back;
            String params = "id_card_side=" + ((idCardUpload.getType() == 1) ? "front" : "back") + "&detect_direction=true&" + URLEncoder.encode("image", "UTF-8") + "="
                    + URLEncoder.encode(imgStr, "UTF-8");
            /**
             * 线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
             */
            String accessToken = AuthService.getAuth();
            String result = HttpUtil.post(idcardIdentificate, accessToken, params);
            hashMap = GsonUtils.toObject(result, LinkedTreeMap.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (("normal").equals(hashMap.get("image_status"))) {
            if (idCardUpload.getType() == 1) {
                idCards.setSide(1);
                idCards.setAddress(transition(hashMap, "住址"));
                idCards.setName(transition(hashMap, "姓名"));
                idCards.setNumber(transition(hashMap, "公民身份号码"));
                idCards.setBirthday(transition(hashMap, "出生"));
                idCards.setSex(transition(hashMap, "性别"));
                idCards.setNation(transition(hashMap, "民族"));
            } else {
                idCards.setSide(2);
            }
            idCards.setPath(FileUtils.URL + path);
            return idCards;
        } else {
            throw new AppRunException("身份证识别失败！");
        }
    }


    public static String transition(LinkedTreeMap hashMap, String key) {
        String result = (String) ((LinkedTreeMap) (((LinkedTreeMap) hashMap.get("words_result"))).get(key)).get("words");
        return result;
    }
}
