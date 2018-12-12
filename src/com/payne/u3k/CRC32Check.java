package com.payne.u3k;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;


public class CRC32Check {
    private static int[] genTable(int size) {
        int[] table = new int[size];
        for (int i = 0; i < size; i++) {
            int ret = i;
            for (int j = 0; j < 8; j++) {
                if (ret % 2 != 0) {
                    ret = 0xEDB88320 ^ ret >> 1;
                } else {
                    ret >>= 1;
                }
            }
            table[i] = ret;
        }
        return table;
    }

    public static byte[] intToByteArray(int integer) {
        int byteNum = (40 - Integer.numberOfLeadingZeros(integer < 0 ? integer ^ 0xFFFFFFFF : integer)) / 8;
        byte[] byteArray = new byte[4];
        for (int n = 0; n < byteNum; n++) {
            byteArray[(3 - n)] = ((byte) (integer >>> n * 8));
        }
        return byteArray;
    }

    public static int byteArrayToInt(byte[] b, int offset) {
        int value = 0;
        for (int i = 0; i < 4; i++) {
            int shift = (3 - i) * 8;
            value += ((b[(i + offset)] & 0xFF) << shift);
        }
        return value;
    }

    public static long crcCalcFile(String filePath) {
        long checksum = 0L;
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                return checksum;
            }
            CheckedInputStream cis = null;
            cis = new CheckedInputStream(new FileInputStream(file), new CRC32());

            byte[] buf = new byte[1024];
            while (cis.read(buf) >= 0) {
            }
            checksum = cis.getChecksum().getValue();
            cis.close();
        } catch (IOException e) {
            checksum = 0L;
        }
        return checksum;
    }

    public static int crcCalc(byte[] buf) {
        int ret = 0;

        int[] table = genTable(256);

        ret = -1;
        for (int i = 0; i < buf.length; i++) {
            ret = table[((ret ^ buf[i]) & 0xFF)] ^ ret >> 8;
        }
        ret ^= 0xFFFFFFFF;
        return ret;
    }
}
