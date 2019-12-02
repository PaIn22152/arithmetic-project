package com.payne.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.file
 * Date       2019/04/01 - 15:36
 * Author     Payne.
 * About      类描述：
 */

public class FileUtil {
    public static void del(String path) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String s;
            StringBuilder sb = new StringBuilder();
            while ((s = br.readLine()) != null) {

                    s = s.substring(4);

                sb.append(s).append("\r\n");
            }
            fw = new FileWriter(path);
            fw.write(sb.toString());

        } catch (Exception e) {

        } finally {
            try {
                fr.close();


                fw.close();
            } catch (Exception e) {

            }
        }
    }
}
