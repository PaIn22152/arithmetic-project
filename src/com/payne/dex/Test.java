package com.payne.dex;


import com.af.dexdiff.build.DexClassesComparator;
import com.af.dexdiff.build.MD5;
import com.af.dexdiff.build.TinkerPatchException;
import com.af.dexdiff.build.Utils;
import com.af.dexdiff.dex.Dex;
import com.af.dexdiff.enc.AESHelper;
import com.af.dexdiff.launcher.DexDiff;
import com.af.dexdiff.launcher.DexHandler;
import com.af.dexdiff.launcher.DexPatch;
import com.af.dexdiff.launcher.DexPatchApplier;
import com.af.dexdiff.launcher.DexPatchGenerator;
import com.payne.bsdiff.BSDiff;
import com.payne.u3k.CRC32Check;
import com.payne.u3k.DecryptUtil;
import com.payne.u3k.InnerData;
import com.payne.zip.ZipUtils;

import java.io.File;
import java.util.List;
import java.util.Map;


/**
 * Project    arithmetic-project-git
 * Path       com.payne.dex
 * Date       2018/10/10 - 16:33
 * Author     Payne.
 * About      类描述：
 */

public class Test {

    public static final String s="1";

    static String path = "D:\\cache-files\\u3k-diff\\aps\\";

    public static void f1() throws Exception {
        File v8so = new File(path + "ntv0.0.8.jar");
        File v9so = new File(path + "ntv0.0.9.jar");
        File p8_9 = new File(path + "p8_9.bs");
        BSDiff.bsdiff(v8so, v9so, p8_9);
    }

    public static void aps() throws Exception {
//        AESHelper.decryptFile(path + "aps1.1.15.so", path + "aps1.1.15.jar");
//        AESHelper.decryptFile(path + "aps1.1.16.so", path + "aps1.1.16.jar");
//        AESHelper.decryptFile(path + "aps1.2.1.so", path + "aps1.2.1.jar");
//        System.out.println(" decryptFile success ");


        File v8dex = new File(path + "aps1.1.15.jar");
        File v9dex = new File(path + "aps1.1.16.jar");
        File v10dex = new File(path + "aps1.2.1.jar");

        File v9patch = new File(path + "aps1.1.16.dex");
        File v10patch = new File(path + "aps1.2.1.dex");

        File p8_9 = new File(path + "p_5-6.patch");
        File p9_10 = new File(path + "p_6-1.patch");

        new DexPatchGenerator(v8dex, v9dex).executeAndSaveTo(p8_9);
        new DexPatchApplier(v8dex, p8_9).executeAndSaveTo(v9patch);
        checkDexChange(v9dex, v9patch);


        new DexPatchGenerator(v9dex, v10dex).executeAndSaveTo(p9_10);
        new DexPatchApplier(v9dex, p9_10).executeAndSaveTo(v10patch);
        checkDexChange(v10dex, v10patch);
        System.out.println("diff success");
    }

    public static void encFile(String ori, String newF) {
        AESHelper.encryptFile(ori, newF);
    }

    public static void zip() throws Exception {
        // 压缩文件
        ZipUtils.compress("D:\\cache-files\\u3k-diff\\ntv\\p_8-9.patch",
                "D:\\cache-files\\u3k-diff\\ntv\\p_8-9.patch.zip");

        ZipUtils.decompress("D:\\cache-files\\u3k-diff\\ntv\\p_8-9.patch.zip",
                "D:\\cache-files\\u3k-diff\\ntv\\unzip");


        // 压缩文件
        ZipUtils.compress("D:\\cache-files\\u3k-diff\\ntv\\p_9-10.patch",
                "D:\\cache-files\\u3k-diff\\ntv\\p_9-10.patch.zip");

        ZipUtils.decompress("D:\\cache-files\\u3k-diff\\ntv\\p_9-10.patch.zip",
                "D:\\cache-files\\u3k-diff\\ntv\\unzip");


        // 压缩文件
        ZipUtils.compress("D:\\cache-files\\u3k-diff\\ntv\\p_10-11.patch",
                "D:\\cache-files\\u3k-diff\\ntv\\p_10-11.patch.zip");

        ZipUtils.decompress("D:\\cache-files\\u3k-diff\\ntv\\p_10-11.patch.zip",
                "D:\\cache-files\\u3k-diff\\ntv\\unzip");
    }

    private static void f4() {
        File file = new File("D:\\cache-files\\u3k-diff\\ntv\\unzip\\test");
        file.mkdirs();
    }


    private static void enc() {

        //kOleWgGn3FN30mQQ
        AESHelper.encryptFile("D:\\cache-files\\u3k-diff\\ntv\\ntv0.0.8.jar",
                "D:\\cache-files\\u3k-diff\\ntv\\ntv0.0.8.so.jar");

        AESHelper.decryptFile("D:\\cache-files\\u3k-diff\\ntv\\ntv0.0.8.so.jar",
                "D:\\cache-files\\u3k-diff\\ntv\\ntv0.0.8.de.jar");

        System.out.println(equalsMd5("D:\\cache-files\\u3k-diff\\ntv\\ntv0.0.8.jar",
                "D:\\cache-files\\u3k-diff\\ntv\\ntv0.0.8.de.jar"));

    }

    private static boolean equalsMd5(String f1, String f2) {
        try {
            return MD5.getMD5(new File(f1)).equals(MD5.getMD5(new File(f2)));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void patch() {
        File oldfile = new File("D:\\cache-files\\u3k-diff\\ntv\\new\\test\\ntv0.0.8.so");
        File patchfile = new File("D:\\cache-files\\u3k-diff\\ntv\\new\\test\\p_8_9.so");
        File outfile = new File("D:\\cache-files\\u3k-diff\\ntv\\new\\test\\ntv0.0.9.so");
        new DexPatchApplier(oldfile, patchfile).executeAndSaveTo(outfile);

        System.out.println("dea184c8fe3cacf4123275a06991646e".equals(MD5.getMD5(outfile)));
    }

    private static void ntv() {
        String path = "D:/cache-files/u3k-diff/ntv/new/";
        File oldso = new File(path + "ntv0.0.8.so");
        File newso = new File(path + "ntv0.0.9.so");
        File patchSo = new File(path + "p_8_9.so");
        File outso = new File(path + "ntv0.0.9_new.so");

        DexPatch.patch(oldso, patchSo, outso);

        System.out.println("56558027f7feba5fa994bd8e738a3c65".equals(MD5.getMD5(outso)));


    }

    private static void ntve() {
//        String path="D:\\cache-files\\ntv\\p0-1\\";
//        DexPatch.patch(new File(path+"ntv0.0.10.so"),
//                new File(path+"p_10_11.so"),
//                new File(path+"ntv0.0.11.out.so"));

        String path = "D:\\cache-files\\ntv\\p1-2\\";
        DexPatch.patch(new File(path + "ntv0.0.11.out.so"),
                new File(path + "p_11_12.so"),
                new File(path + "ntv0.0.12.out.so"));


        System.out.println(MD5.getMD5(new File(path + "ntv0.0.12.out.so")).equals(
                "e495439163432b8a6f731f6915d44fb4")
        );

    }

    private static void fff() {
        String f1 = "D:\\cache-files\\ntv\\p0-1\\";

        String f2 = "D:\\cache-files\\ntv\\p1-2\\";

        String f3 = "D:\\cache-files\\ntv\\test\\";

        AESHelper.encryptFile(f3 + "hhf_core0.0.1_dex.jar", f3 + "hhf_core0.0.1_dex.so");

        AESHelper.encryptFile(f3 + "hhf_core0.0.2_dex.jar", f3 + "hhf_core0.0.2_dex.so");





        String[] ss={
                f3 + "hhf_core0.0.1_dex.so",
                f3 + "hhf_core0.0.2_dex.so",
                f3 + "pp12.so",
                f3+"pa.json",

                "1",
                "2"
        };

        //DexDiff.main(ss);

//        System.out.println(MD5.getMD5(new File(f3 + "hhf_core0.0.1_dex.jar"))
//                .equals(MD5.getMD5(new File(f3 + "hhf_core0.0.1_dex.so.jar"))));

//        AESHelper.decryptFile(f1+"ntv0.0.11.so",f1+"ntv0.0.11.so.jar");
//
//        AESHelper.decryptFile(f1+"ntv0.0.11.out.so",f1+"ntv0.0.11.out.so.dex");

//        AESHelper.decryptFile(f2+"p_11_12.so",f2+"p_11_12.so.patch");
//
//
//        DexHandler.checkDexChange(new File(f1+"ntv0.0.11.so.jar"),new File(f1+"ntv0.0.11.out.so.dex"));
//        System.out.println(MD5.getMD5(new File(f1+"ntv0.0.11.so.jar"))
//                .equals(MD5.getMD5(new File(f1+"ntv0.0.11.out.so.dex"))));
//
//        new DexPatchApplier(new File(f1+"ntv0.0.11.out.so.dex"),
//                new File(f2+"ntv0.0.11.so#ntv0.0.12.so.patch")).executeAndSaveTo(new File(f2+"ntv12.dex"));
    }

    private static void checkFile(String s1,String s2){
        //AESHelper.decryptFile(s1,s1+".jar");
       // AESHelper.decryptFile(s2,s2+".jar");

       // DexHandler.checkDexChange(new File(s1+".jar"),new File(s2+".jar"));

        DexHandler.checkDexChange(new File(s1),new File(s2));
    }



    private static void fii(){
        String path0="D:\\cache-files\\ntv\\from_tool111\\";
        String path="D:\\cache-files\\ntv\\ft222\\";
        String path2="D:\\cache-files\\ntv\\hand\\";

//        checkFile(path+"ntv_module.ntv0.0.10.so",path+"tool_ntv_module.ntv0.0.10.so");

//        DexPatch.patch(new File(path+"ntv0.0.10.so"),
//                new File(path+"patch#ntv0.0.10#ntv0.0.11.so"),
//                new File(path+"patched_11.so"));
//
//        AESHelper.decryptFile(path+"patched_11.so",path+"1.dex");
//        AESHelper.decryptFile(path+"ntv_module.ntv0.0.11.so",path+"2.jar");
//        DexHandler.checkDexChange(new File(path+"2.jar"),new File(path+"1.dex"));

//        AESHelper.decryptFile(path+"ntv0.0.10.so",path+"n10.so.jar");
//        AESHelper.decryptFile(path+"ntv_module.ntv0.0.10.so",path+"n10.jar");
//        DexHandler.checkDexChange(new File(path+"n10.so.jar"),new File(path+"n10.jar"));


        //DecryptUtil.decryptJarFile(InnerData.nativeDex,path+"ntv10_1.so");

        //checkFile(path2+"1.jar",path2+"2.jar");

        System.out.println("md5 "+equalsMd5(path2+"1.jar",path2+"2.jar"));

        System.out.println("crc32 "+equalsCrc32(path2+"1.jar",path2+"2.jar"));

        System.out.println("suc");

    }

    private static boolean equalsCrc32(String s1,String s2){
        return CRC32Check.crcCalcFile(s1)-CRC32Check.crcCalcFile(s2)==0;
    }


    public static void Test() {

        try {
            //encFile("D:\\cache-files\\u3k-diff\\ntv\\p_8-9.patch","D:\\cache-files\\u3k-diff\\ntv\\p_10-11.patch.so");


           fii();

            if (true) {
                return;
            }


            String path = "D:\\cache-files\\u3k-diff\\ntv\\";
            AESHelper.decryptFile(path + "ntv0.0.8.so", path + "ntv0.0.8.jar");
            AESHelper.decryptFile(path + "ntv0.0.9.so", path + "ntv0.0.9.jar");
            AESHelper.decryptFile(path + "ntv0.0.10.so", path + "ntv0.0.10.jar");
            AESHelper.decryptFile(path + "ntv0.0.11.so", path + "ntv0.0.11.jar");
            System.out.println(" decryptFile success ");

            File v8dex = new File(path + "ntv0.0.8.jar");
            File v9dex = new File(path + "ntv0.0.9.jar");
            File v10dex = new File(path + "ntv0.0.10.jar");
            File v11dex = new File(path + "ntv0.0.11.jar");

            File v9patch = new File(path + "ntv0.0.9.dex");
            File v10patch = new File(path + "ntv0.0.10.dex");
            File v11patch = new File(path + "ntv0.0.11.dex");

            File p8_9 = new File(path + "p_8-9.so");
            File p9_10 = new File(path + "p_9-10.so");
            File p10_11 = new File(path + "p_10-11.so");

            new DexPatchGenerator(v8dex, v9dex).executeAndSaveTo(p8_9);
            new DexPatchApplier(v8dex, p8_9).executeAndSaveTo(v9patch);
            checkDexChange(v9dex, v9patch);


            new DexPatchGenerator(v9dex, v10dex).executeAndSaveTo(p9_10);
            new DexPatchApplier(v9dex, p9_10).executeAndSaveTo(v10patch);
            checkDexChange(v10dex, v10patch);


            new DexPatchGenerator(v10dex, v11dex).executeAndSaveTo(p10_11);
            new DexPatchApplier(v10dex, p10_11).executeAndSaveTo(v11patch);
            checkDexChange(v10dex, v10patch);


            System.out.println("diff success");

            showDiff(v10dex, v11patch);


            //AESHelper.encryptFile(p8_9.getAbsolutePath(),path+"p_8-9.patch.so","kOleWgGn3FN30mQQ");
            //AESHelper.encryptFile(p9_10.getAbsolutePath(),path+"p_9-10.patch.so","kOleWgGn3FN30mQQ");


        } catch (Exception e) {
            System.out.println(" e = " + e);
            e.printStackTrace();
        }
    }

    private static void showDiff(File oriFile, File newFile) {
        showDiff(new Dex(oriFile), new Dex(newFile));
    }

    private static void showDiff(Dex originDex, Dex newDex) {
        DexClassesComparator classesCmptor = new DexClassesComparator("*");
        //classesCmptor.setIgnoredRemovedClassDescPattern(config.mDexLoaderPattern);
        classesCmptor.startCheck(originDex, newDex);

        List<DexClassesComparator.DexClassInfo> addedClassInfos = classesCmptor.getAddedClassInfos();
        boolean isNoClassesAdded = addedClassInfos.isEmpty();

        System.out.println(" addedClassInfos = " + addedClassInfos.size());
        for (DexClassesComparator.DexClassInfo temp : addedClassInfos) {
            System.out.println(temp.toString());
        }


        Map<String, DexClassesComparator.DexClassInfo[]> map;
        map = classesCmptor.getChangedClassDescToInfosMap();
        System.out.println(" getChangedClassDescToInfosMap = " + map.size());
        for (Map.Entry<String, DexClassesComparator.DexClassInfo[]> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey());
        }


        List<DexClassesComparator.DexClassInfo> deletedClassInfos = classesCmptor.getDeletedClassInfos();
        System.out.println(" deletedClassInfos = " + deletedClassInfos.size());
        for (DexClassesComparator.DexClassInfo tem : deletedClassInfos) {
            System.out.println(tem.toString());
        }


    }


    private static void checkDexChange(File oriFile, File newFile) {
        checkDexChange(new Dex(oriFile), new Dex(newFile));
    }

    private static void checkDexChange(Dex originDex, Dex newDex) {
        DexClassesComparator classesCmptor = new DexClassesComparator("*");
        //classesCmptor.setIgnoredRemovedClassDescPattern(config.mDexLoaderPattern);
        classesCmptor.startCheck(originDex, newDex);

        List<DexClassesComparator.DexClassInfo> addedClassInfos = classesCmptor.getAddedClassInfos();
        boolean isNoClassesAdded = addedClassInfos.isEmpty();
        System.out.println(" checkDexChange  isNoClassesAdded = " + isNoClassesAdded);

        Map<String, DexClassesComparator.DexClassInfo[]> changedClassDescToClassInfosMap;
        boolean isNoClassesChanged;


        if (isNoClassesAdded) {
            changedClassDescToClassInfosMap = classesCmptor.getChangedClassDescToInfosMap();
            isNoClassesChanged = changedClassDescToClassInfosMap.isEmpty();
            System.out.println(" checkDexChange  isNoClassesChanged = " + isNoClassesChanged);
        } else {
            throw new TinkerPatchException(
                    "some classes was unexpectedly added in patched new dex, check if there's any bugs in "
                            + "patch algorithm. Related classes: " + Utils.collectionToString(addedClassInfos)
            );
        }

        if (isNoClassesChanged) {
            List<DexClassesComparator.DexClassInfo> deletedClassInfos = classesCmptor.getDeletedClassInfos();
            if (!deletedClassInfos.isEmpty()) {
                throw new TinkerPatchException(
                        "some classes that are not matched to loader class pattern "
                                + "was unexpectedly deleted in patched new dex, check if there's any bugs in "
                                + "patch algorithm. Related classes: "
                                + Utils.collectionToString(deletedClassInfos)
                );
            }
        } else {
            throw new TinkerPatchException(
                    "some classes was unexpectedly changed in patched new dex, check if there's any bugs in "
                            + "patch algorithm. Related classes: "
                            + Utils.collectionToString(changedClassDescToClassInfosMap.keySet())
            );
        }
    }
}
