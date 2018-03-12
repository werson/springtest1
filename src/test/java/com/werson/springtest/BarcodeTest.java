package com.werson.springtest;

import org.junit.Test;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by wersom on 1/3/2018.
 * 输出条形码
 */
public class BarcodeTest {

    @Test
    public void createBarCode(){
        String msg = "RCBX201801030001";
        String path = "C:/Users/wersom/Desktop/barcode5-128.png";
        File file = new File(path);
        try{
            OutputStream os = new FileOutputStream(file);
            Code39Bean bean = new Code39Bean();
            //Code128Bean bean = new Code128Bean();
            // 配置对象
            final int dpi = 150;
            final double moduleWidth = UnitConv.in2mm(1.0f/dpi);
            bean.setModuleWidth(moduleWidth);
            //bean.setModuleWidth(0.21);
            bean.setWideFactor(3d);
            bean.setBarHeight(6d);
            bean.doQuietZone(true);
            bean.setQuietZone(1.0);
            String format = "image/png";
            try {
                // 输出到流
                BitmapCanvasProvider canvas = new BitmapCanvasProvider(os, format, dpi,
                        BufferedImage.TYPE_BYTE_BINARY, false, 0);
                // 生成条形码
                bean.generateBarcode(canvas, msg);
                // 结束绘制
                canvas.finish();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e){
            e.printStackTrace();
        }



    }

}
