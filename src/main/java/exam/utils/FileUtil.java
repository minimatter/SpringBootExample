package exam.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 文件工具类
 *
 */
public class FileUtil {


    /**
     *  多文件上传工具类
     * @param fileList
     *              需要上传的文件数组
     * @param folderPath
     *              存放的服务器目标文件
     * @return
     *           UUID之后的新文件名，多文件以逗号隔开
     */
    public static Map<String,String> uploadFile(List<MultipartFile> fileList,String folderPath){

        Map<String ,String> fileNameMap=new HashMap<>();


        //上传协议到服务器文件夹地址
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < fileList.size(); ++i) {
            file = fileList.get(i);
            if (!file.isEmpty()) {
                try {
                    String newFile = uploadFileSingle(file, folderPath);

                    String fileNameSrc=file.getOriginalFilename();
                    //存入数据库文件名
                    fileNameMap.put(newFile,fileNameSrc);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }


        return fileNameMap;
    }

    /**
     * 单文件上传
     * @param file
     *          需要上传的文件
     * @param folderPath
     *          存在的服务器目标文件夹
     * @return
     *          上传文件名
     */
    public static String uploadFileSingle(MultipartFile file,String folderPath){

        //新上传文件名
        String newFile="";
        try {

            File filePath=new File(folderPath);
            if(!filePath.exists()){
                filePath.mkdirs();
            }

            //获取文件后缀名
           // String suffixName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

            //UUID下的新文件名
            newFile=UUID.randomUUID()+"" ;

            byte[] bytes = file.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                    new File(folderPath+newFile)));
            stream.write(bytes);
            stream.close();



        } catch (Exception e) {
            e.printStackTrace();
        }

        return newFile;
    }

    /**
     * 下载文件
     * @param response
     * @param folderPath
     *              服务器文件地址
     * @param fileName
     *              文件名
     */
    public static void downloadFile(HttpServletResponse response,String folderPath,String fileName){

        File file = new File(folderPath, fileName);

        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition",
                    "attachment;fileName=" + fileName);// 设置文件名
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

}
