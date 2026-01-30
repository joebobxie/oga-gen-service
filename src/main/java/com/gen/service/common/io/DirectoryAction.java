package com.gen.service.common.io;

import java.io.File;

/**
 * directory actions
 */
public class DirectoryAction {
    
    /**
     * delete directory
     *
     * @param path directory path
     * @return
     */
    public static boolean Delete(String path) {
        try {
            File dir = new File(path);
            if (dir.exists()) {
                for (File file : dir.listFiles()) {
                    if (file.isDirectory()) {
                        Delete(String.format("%s/%s", path, file.getName()));
                    } else {
                        file.delete();
                    }
                }
            }
            dir.delete();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * create directory
     *
     * @param path directory path
     */
    public static boolean Exist(String path) {
        try {
            File dir = new File(path);
            return dir.exists();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * create directory
     *
     * @param path directory path
     */
    public static boolean Create(String path) {
        try {
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * copy directory
     *
     * @param source source directory
     * @param target target directory
     * @return
     */
    public static boolean Copy(String source, String target) {
        return Copy(source, target, true);
    }
    
    /**
     * copy directory
     *
     * @param source   source directory
     * @param target   target directory
     * @param coverlay allow coverlay
     * @return
     */
    public static boolean Copy(String source, String target, boolean coverlay) {
        try {
            if (target.lastIndexOf(File.separator) != target.length() - 1) {
                target = String.format("%s%s", target, File.separator);
            }
            File sdir = new File(source);
            File tdir = new File(target);
            if (!sdir.exists() || !sdir.isDirectory()) {
                return false;
            }
            if (coverlay) {
                Delete(target);
            }
            Create(target);
//            for(File file : sdir.listFiles()){
//                if (file.isDirectory())
//                {
//                    Copy(String.format("%s/%s", path, file.getName()));
//                }
//                else
//                {
//                    file.c
//                }
//            }


//            string[] fileList = Directory.GetFileSystemEntries(sourcePath);
//            // 遍历所有的文件和目录
//            foreach (string file in fileList)
//            {
//                // 先当作目录处理如果存在这个目录就递归Copy该目录下面的文件
//                if (Directory.Exists(file))
//                    CopyDirectory(file, objectPath + Path.GetFileName(file));
//                    // 否则直接Copy文件
//                else
//                    File.Copy(file, objectPath + Path.GetFileName(file), true);
//            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}