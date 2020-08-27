package cn.huaruan.ud24.application.common;

import cn.huaruan.ud24.application.AppAsserts;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文件上传工具类
 *
 * @author outas
 */
public final class FileUtils {

    static final String PATH = "/opt/file/";

    static final String URL = "https://api.24ud.cn/file/";

    /**
     * 文件上传
     *
     * @param path
     * @param file
     * @return 文件url
     */
    public static String upload2Url(String path, MultipartFile file) {
        return URL + upload(path, file);
    }

    /**
     * 文件上传
     *
     * @param path
     * @param file
     * @return 文件绝对路径
     */
    public static String upload2Path(String path, MultipartFile file) {
        return PATH + upload(path, file);
    }

    /**
     * 文件上传
     *
     * @param path
     * @param file
     * @return 文件相对路径
     */
    public static String upload(String path, MultipartFile file) {
        AppAsserts.hasText(path, "id不能为空");
        AppAsserts.notNull(file, "文件不能为空");
        // 获取文件名
        String originalFileName = file.getOriginalFilename();
        // 获取文件后缀名
        String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));
        // 生成保存在服务器的文件名
        String fileName = UUIDUtil.get() + suffix;
        String filePath = path + "/" + fileName;
        try {
            File dest = new File(PATH + filePath);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                // 目录不存在则新建文件夹
                dest.getParentFile().mkdirs();
            }
            // 文件写入
            file.transferTo(dest);
        } catch (IOException e) {
            AppAsserts.no(true, "文件上传失败");
        }
        return filePath;
    }

    /**
     * 根据文件路径读取byte[] 数组
     */
    public static byte[] readFileByBytes(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(filePath);
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
            BufferedInputStream in = null;

            try {
                in = new BufferedInputStream(new FileInputStream(file));
                short bufSize = 1024;
                byte[] buffer = new byte[bufSize];
                int len1;
                while (-1 != (len1 = in.read(buffer, 0, bufSize))) {
                    bos.write(buffer, 0, len1);
                }

                byte[] var7 = bos.toByteArray();
                return var7;
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException var14) {
                    var14.printStackTrace();
                }

                bos.close();
            }
        }
    }

    /**
     * 批量上传
     *
     * @param path
     * @param files
     * @return
     */
    public static List<String> uploadAll(String path, List<MultipartFile> files) {
        AppAsserts.notEmpty(files, "请选择文件");
        AppAsserts.no(files.size() > 8, "批量上传最多一次性上传8个文件");
        return files.stream().map(file -> upload2Url(path, file)).collect(Collectors.toList());
    }


    /**
     * 删除文件
     *
     * @param path 要删除的文件路径
     * @return
     */
    public static void delete(String path) {
        //删除文件
        File deleteFile = new File(path);
        AppAsserts.yes(deleteFile.delete(), "删除失败，请检查文件路径是否正确");
    }

    /**
     * 批量删除
     *
     * @param pathList
     */
    public static void deleteAll(List<String> pathList) {
        pathList.forEach(path -> delete(path));
    }
}
