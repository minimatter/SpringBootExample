package exam.service.impl;

import com.github.pagehelper.PageHelper;
import exam.bean.Student;
import exam.bean.StudentMajor;
import exam.bean.UploadFile;
import exam.dao.StudentDao;
import exam.dao.UploadFileDao;
import exam.service.IStudentService;
import exam.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private UploadFileDao uploadFileDao;

    @Override
    public List<Student> selectStudent(int pageNum, int pageSize,Map<String,Object> map) {

        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);

        List<Student> student=studentDao.selectStudent(map);
        for (Student stu:student) {

            String ID=stu.getUploadFileID();
            if(ID !=null && !ID.equals("")){

                List<UploadFile> uploadFileList=new ArrayList<>();

                String[] fileNameSplit=ID.split(",");
                for (String fileNameID:fileNameSplit){
                    int fileNameIDInt= Integer.parseInt(fileNameID);

                    UploadFile uploadFile=uploadFileDao.queryUploadFile(fileNameIDInt).get(0);
                    uploadFileList.add(uploadFile);
                }


                stu.setUploadFileList(uploadFileList);
            }

        }

        return student;



//        if(map.size()==0)
//            return studentDao.selectStudent(null);
//        else{
//                if (map.get("name").equals(""))
//                    return studentDao.selectStudent(null);
//                else return studentDao.selectStudent(map);
//            }

    }

    @Override
    public List<StudentMajor> queryStudentMajor() {
        return studentDao.queryStudentMajor();
    }

    @Override
    public int insertStu(Student student,String uploadPath){
        List<MultipartFile> files=student.getUploadFile();
        String fileNameID="";
        Map<String,String> fileNameMap= FileUtil.uploadFile(files,uploadPath);
        for (String key:fileNameMap.keySet())
        {
            String fileNameSrc=fileNameMap.get(key);

            UploadFile uploadFile=new UploadFile();
            uploadFile.setUploadFileName(key);
            uploadFile.setUploadFileNameSrc(fileNameSrc);

            uploadFileDao.insertUploadFile(uploadFile);
            fileNameID+=uploadFile.getId()+",";

        }
        student.setUploadFileID(fileNameID);
        return studentDao.insertStu(student);
    }

    @Override
    public int updateStudent(Student student,String uploadPath) {
        String studentFileNameIDs="";
        //删除了已存在的附件或者没有删除
        List<UploadFile> uploadFileList=student.getUploadFileList();
        //有值
        if(uploadFileList!=null&&uploadFileList.size()!=0){

            for (UploadFile uploadFile:uploadFileList){
                if(uploadFile.getId()!=0)
                studentFileNameIDs+=uploadFile.getId()+",";
            }
        }

        //添加了新的附件
        List<MultipartFile> studentUploadList=student.getUploadFile();
        //有值
        if(studentUploadList!=null&&studentUploadList.size()!=0){
            Map<String,String> fileNameMap= FileUtil.uploadFile(studentUploadList,uploadPath);

            for (String key:fileNameMap.keySet())
            {
                String fileNameSrc=fileNameMap.get(key);

                UploadFile uploadFile=new UploadFile();
                uploadFile.setUploadFileName(key);
                uploadFile.setUploadFileNameSrc(fileNameSrc);

                uploadFileDao.insertUploadFile(uploadFile);
                studentFileNameIDs+=uploadFile.getId()+",";

            }


        }
        student.setUploadFileID(studentFileNameIDs);


        return studentDao.updateStudent(student);
    }

    @Override
    public int deleteStudent(int id) {
        return studentDao.deleteStudent(id);
    }

    @Override
    public Student selectStudentSingle(Map<String, Object> map) {

        return studentDao.selectStudent(map).get(0);
    }
}
