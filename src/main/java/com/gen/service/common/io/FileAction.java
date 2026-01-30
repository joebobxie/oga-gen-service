package com.gen.service.common.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * file actions
 */
public class FileAction {
    /**
     * copy single file
     *
     * @param fileName source file name
     * @param target   target directory name
     */
    public static void Copy(String fileName, String target) {
        try {
            FileInputStream in = new FileInputStream(fileName);
            DirectoryAction.Create(target);
            FileOutputStream out = new FileOutputStream(String.format("%s/%s", target, new File(fileName).getName()));
            int len;
            byte buffer[] = new byte[1024];
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * read text file
     *
     * @param fileName text file name
     */
    public static String Read(String fileName) {
        return Read(fileName, "UTF-8");
    }

    /**
     * read text file
     *
     * @param fileName text file name
     * @param encoding default UTF-8
     */
    public static String Read(String fileName, String encoding) {
        StringBuilder sb = new StringBuilder();
        try {
            File file = new File(fileName);
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
                read.close();
            } else {
                System.out.println(String.format("cont find file：%s", fileName));
            }
        } catch (Exception e) {
            System.out.println(String.format("read file error：%s", fileName));
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * create or append file
     *
     * @param fileName file name
     * @param content  file content
     */
    public static void Write(String fileName, String content) {
        System.out.println(fileName);
        try {
            String path = fileName.substring(0, fileName.lastIndexOf("/") + 1);
            DirectoryAction.Create(path);
            BufferedWriter out = null;
            try {
                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true), StandardCharsets.UTF_8));
                out.write(content);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * delete file
     *
     * @param fileName file name
     */
    public static boolean Delete(String fileName) {
        try {
            File file = new File(fileName);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}