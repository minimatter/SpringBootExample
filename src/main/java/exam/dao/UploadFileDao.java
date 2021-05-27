package exam.dao;

import exam.bean.UploadFile;

import java.util.List;

public interface UploadFileDao {


    public boolean insertUploadFile(UploadFile uploadFile);

    public List<UploadFile> queryUploadFile(int id);

    public boolean deleteUploadFile(int id);

}
