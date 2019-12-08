package com.hcz017.drawingview;

import android.graphics.Bitmap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {

    /** 保存bitmap 图像
     *
     * @param filePath 路径名
     * @param format   存储格式
     * @param quality  质量
     * @return 是否保存成功
     */
    public static boolean saveBitmap(String filePath, Bitmap bitmap, Bitmap.CompressFormat format,
                             int quality) {
        if (quality > 100) {
            quality = 100;
        }
        File file;
        FileOutputStream out = null;
        try {
            switch (format) {
                case JPEG:
                    file = new File(filePath + ".jpg");
                    out = new FileOutputStream(file);
                    return bitmap.compress(Bitmap.CompressFormat.JPEG, quality, out);
                default:
                    file = new File(filePath + ".png");
                    out = new FileOutputStream(file);
                    return bitmap.compress(Bitmap.CompressFormat.PNG, quality, out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
