package exam.bean;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public class Student {
    private Integer id;

    private String name;

    private int age;

    private int major;

    private String majorStr;

    private Date registrantDate;



    //多文件上传
    private List<UploadFile> uploadFileList;

    private List<MultipartFile> uploadFile;

    private String uploadFileID;

    private String uploadFileName;

    private String fileNameSrc;

    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date admissionDate;

    public List<UploadFile> getUploadFileList() {
        return uploadFileList;
    }

    public void setUploadFileList(List<UploadFile> uploadFileList) {
        this.uploadFileList = uploadFileList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public String getMajorStr() {
        return majorStr;
    }

    public void setMajorStr(String majorStr) {
        this.majorStr = majorStr;
    }

    public Date getRegistrantDate() {
        return registrantDate;
    }

    public void setRegistrantDate(Date registrantDate) {
        this.registrantDate = registrantDate;
    }

    public List<MultipartFile> getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(List<MultipartFile> uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getFileNameSrc() {
        return fileNameSrc;
    }

    public void setFileNameSrc(String fileNameSrc) {
        this.fileNameSrc = fileNameSrc;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getUploadFileID() {
        return uploadFileID;
    }

    public void setUploadFileID(String uploadFileID) {
        this.uploadFileID = uploadFileID;
    }
}
