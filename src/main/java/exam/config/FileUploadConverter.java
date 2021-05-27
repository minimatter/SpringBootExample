package exam.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


/**
 * 上传文件自定义转换类，解决空文件上传报错问题
 *  问题原因:在同步提交的时候，Spring把空上传是做null来处理的，而在异步提交的时候，Spring把文件域的值当作空字符串看待的。
 *  在Spring做请求转换的时候（request–>MultipartHttpServletRequest）底层的TypeConverter接口实现对null和""是做了不同操作的
 *
 */
@Component
public class FileUploadConverter implements Converter<String, MultipartFile> {
    @Override
    public MultipartFile convert(String s) {
        return null;
    }
}
