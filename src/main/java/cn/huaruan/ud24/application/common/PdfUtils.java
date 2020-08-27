package cn.huaruan.ud24.application.common;

import cn.huaruan.ud24.query.entity.TodaysWaybill;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PdfUtils {

//    static String templatePath = "/file/pdf/order/template1.pdf";
//    static String outPath = "/file/pdf/order/out.pdf";

    static String templatePath = "/opt/file/pdf/waybill_template.pdf";

    static String outPath = "/opt/file/pdf/waybill_out.pdf";

    public static void toPdf(List<Map<String, Object>> contentList) {

        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        List<PdfReader> list = new ArrayList<>();
        try {
            BaseFont bf = BaseFont.createFont("static/font/dx.ttf", BaseFont.IDENTITY_H, false);
            BaseFont bfb = BaseFont.createFont("static/font/dxb.ttf", BaseFont.IDENTITY_H, false);
            // 输出流
            out = new FileOutputStream(outPath);
            // 读取pdf模板
            for (Map<String, Object> map : contentList) {
                reader = new PdfReader(templatePath);
                bos = new ByteArrayOutputStream();
                stamper = new PdfStamper(reader, bos);
                AcroFields form = stamper.getAcroFields();
                //文字类的内容处理
                Map<String, String> textFields = (Map<String, String>) map.get("textFields");
                form.addSubstitutionFont(bf);
                for (String key : textFields.keySet()) {
                    String value = textFields.get(key);
                    form.setField(key, value);
                }
                //遍历条码字段
                int index = 0;
                Map<String, Object> barcodeFields = (Map<String, Object>) map.get("barcodeFields");
                for (Map.Entry<String, Object> entry : barcodeFields.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    // 获取属性的类型
                    if (value != null && form.getField(key) != null) {
                        //获取位置(左上右下)
                        AcroFields.FieldPosition fieldPosition = form.getFieldPositions(key).get(0);
                        //绘制条码
                        //绘制在第一页
                        PdfContentByte cb = stamper.getOverContent(1);
                        Barcode128 barcode128 = new Barcode128();
                        if (index == 0) {
                            barcode128.setSize(8);
                            barcode128.setBarHeight(30);
                            barcode128.setN(10);
                            barcode128.setX(1.2f);
                            barcode128.setBaseline(8);
                        } else {
                            //字号
                            barcode128.setSize(12);
                            //条码高度
                            barcode128.setBarHeight(40);
                            barcode128.setN(10);
                            //条形码宽度
                            barcode128.setX(2f);
                            //条码与数字间距
                            barcode128.setBaseline(12);
                        }
                        barcode128.setFont(bfb);
                        barcode128.setCode(value.toString());
                        barcode128.setStartStopText(false);
                        barcode128.setExtended(true);
                        //生成条码图片
                        Image image128 = barcode128.createImageWithBarcode(cb, null, null);
                        //左边距(居中处理)
                        float marginLeft = (fieldPosition.position.getRight() - fieldPosition.position.getLeft() - image128.getWidth()) / 2;
                        float marginTop = (fieldPosition.position.getBottom() - fieldPosition.position.getTop() - image128.getHeight()) / 2;
                        //条码位置
                        image128.setAbsolutePosition(fieldPosition.position.getLeft() + marginLeft, fieldPosition.position.getTop() + marginTop - 8);
                        //加入条码
                        cb.addImage(image128);
                    }
                    index++;
                }
                stamper.setFormFlattening(true);
                stamper.close();
                PdfReader pdfReader = new PdfReader(bos.toByteArray());
                list.add(pdfReader);
            }
            // 如果为false，生成的PDF文件可以编辑，如果为true，生成的PDF文件不可以编辑
            Document doc = new Document();
            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();
            for (PdfReader pdfReader : list) {
                doc.newPage();
                copy.addDocument(pdfReader);
            }
            doc.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
    }

    public static String printOrder(List<TodaysWaybill> orderList) {
        List<Map<String, Object>> contentList = new ArrayList<>();
        orderList.forEach(order -> {
            Map<String, String> textFields = new HashMap(10);
            textFields.put("area_code", AmapUtils.getAreaCode(order.getReceiverAddress()));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            textFields.put("organization", order.getDestCode());
            textFields.put("create_time", sdf.format(order.getCreateTime()).replace(" ", "\n"));
            textFields.put("receiver", order.getReceiver());
            textFields.put("receiver_tel", order.getReceiverPhone());
            textFields.put("receiver_address", order.getReceiverAddress());
            textFields.put("sender", order.getSender());
            textFields.put("sender_tel", order.getSenderPhone());
            textFields.put("sender_address", order.getSenderAddress());
            textFields.put("remarks", order.getRemarks());
            textFields.put("check", "已视验");

            Map<String, Object> barcodeFields = new HashMap<>(2);
            barcodeFields.put("bar_code_1", order.getTdNo());
            barcodeFields.put("bar_code_2", order.getTdNo());

            Map<String, Object> content = new HashMap(2);
            content.put("textFields", textFields);
            content.put("barcodeFields", barcodeFields);
            contentList.add(content);
        });
        toPdf(contentList);
        return "https://api.24ud.cn/file/pdf/waybill_out.pdf";
    }

}