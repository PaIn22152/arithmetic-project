package com.payne.u3k;

//import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;



public class DecryptUtil {

    public static boolean decryptJarFile(String[] array, String outFileName) {
        boolean isCopy = false;
        InputStream fis = null;
        //String key = DiskLruCacheUtils.hashKeyForDisk(outFileName);
        //DiskLruCache diskLruCacheJar = DiskLruCacheUtils.getInstance().getDiskLruCacheJar();
        //DiskLruCache.Editor editor = null;
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            content.append(array[i]);
        }

        try {
            byte[] bufd = Base64.decode(content.toString(),0);
            //editor = diskLruCacheJar.edit(key);
            FileOutputStream fos = new FileOutputStream(outFileName);
            //OutputStream fos = editor.newOutputStream(0);
            fis = new ByteArrayInputStream(bufd);
            if (fis != null) {
                byte buf[] = new byte[1024];
                int len = 0;
                while ((len = fis.read(buf)) > 0) {
                    fos.write(buf, 0, len);
                }
                fos.close();
                fis.close();
            }
            isCopy = true;
        } catch (Exception e) {
            e.printStackTrace();
            isCopy = false;
        }
        if (isCopy) {
            try {
                //editor.commit();
            } catch (Exception e) {
            }
        } else {
            try {
                //editor.abort();
            } catch (Exception e) {
            }
        }
        try {
            //diskLruCacheJar.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isCopy;
    }

}
