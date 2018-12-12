package com.payne.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileHelper {

    /**
     * 删除文件夹及其所有子文件
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            // 递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }

    /**
     * 删除文件夹下所有子文件
     */
    public static boolean deleteSubDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            // 递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return true;
    }


    public static boolean copyFile(String oldPath, String newPath) {
        try {
            boolean create = (new File(newPath)).mkdirs(); // 如果文件夹不存在 则建立新文件夹
            File file = new File(oldPath);
            FileInputStream input = new FileInputStream(file);
            FileOutputStream output = new FileOutputStream(newPath + "/" + (file.getName()).toString());
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = input.read(b)) != -1) {
                output.write(b, 0, len);
            }
            output.flush();
            output.close();
            input.close();
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    /**
     * 复制整个文件夹内容
     *
     * @param oldPath String 原文件路径 如：c:/fqf
     * @param newPath String 复制后路径 如：f:/fqf/ff
     * @return boolean
     */
    public static boolean copyFolder(String oldPath, String newPath) {

        try {
            newPath = newPath.replace("/", File.separator);
            oldPath = oldPath.replace("/", File.separator);
            boolean create = (new File(newPath)).mkdirs(); // 如果文件夹不存在 则建立新文件夹
            // System.out.println(" copyFolder create = " + create + "; newPath = " +
            // newPath);

            File a = new File(oldPath);
            String[] file = a.list();
            File temp = null;
            for (int i = 0; i < file.length; i++) {
                if (oldPath.endsWith(File.separator)) {
                    temp = new File(oldPath + file[i]);
                } else {
                    temp = new File(oldPath + File.separator + file[i]);
                }

                if (temp.isFile()) {

                    FileInputStream input = new FileInputStream(temp);
                    FileOutputStream output = new FileOutputStream(newPath + "/" + (temp.getName()).toString());
                    byte[] b = new byte[1024 * 5];
                    int len;
                    while ((len = input.read(b)) != -1) {
                        output.write(b, 0, len);
                    }
                    output.flush();
                    output.close();
                    input.close();
                }
                if (temp.isDirectory()) {// 如果是子文件夹
                    boolean b = copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
                    if (!b) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            System.out.println("复制整个文件夹内容操作出错");
            e.printStackTrace();
            return false;
        }

    }

    public static boolean moveFloder(String oldPath, String newPath) {
        Boolean copy = copyFolder(oldPath, newPath);
        System.out.println("moveFloder  oldPath = " + oldPath + "; newPath = " + newPath);
        System.out.println("moveFloder  copy = " + copy);

        if (copy) {
            FileHelper.deleteSubDir(new File(oldPath));
            return true;
        } else {
            return false;
        }
    }


    public static boolean createNewFile(String path) {
        try {
            File file = new File(path);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            if (!file.getParentFile().exists()) {
                new File(file.getParent()).mkdirs();
            }
            return file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
