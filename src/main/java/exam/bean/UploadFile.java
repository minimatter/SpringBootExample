package exam.bean;


public class UploadFile {

  private long id;
  private String uploadFileName;
  private String uploadFileNameSrc;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUploadFileName() {
    return uploadFileName;
  }

  public void setUploadFileName(String uploadFileName) {
    this.uploadFileName = uploadFileName;
  }


  public String getUploadFileNameSrc() {
    return uploadFileNameSrc;
  }

  public void setUploadFileNameSrc(String uploadFileNameSrc) {
    this.uploadFileNameSrc = uploadFileNameSrc;
  }

}
