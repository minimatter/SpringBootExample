package exam.bean;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public class Company {

  private int id;
  private String undertake;
  private String companyName;
  private String companyNature;
  private String companyType;
  private String sign;
  private Date storageDate;
  @DateTimeFormat(pattern = "yyy-MM-dd")
  private Date signingDateEnd;
  private String companySize;
  private String contacts;
  private String attachment;

  private String remarks;
  private String identity;

  private List<UploadFile> uploadFileList;

  private List<MultipartFile> attachmentFile;

  private String uploadFileID;

  private String uploadFileName;

  private String fileNameSrc;

  public Date getStorageDate() {
    return storageDate;
  }

  public void setStorageDate(Date storageDate) {
    this.storageDate = storageDate;
  }

  public List<UploadFile> getUploadFileList() {
    return uploadFileList;
  }

  public void setUploadFileList(List<UploadFile> uploadFileList) {
    this.uploadFileList = uploadFileList;
  }

  public String getUploadFileID() {
    return uploadFileID;
  }

  public void setUploadFileID(String uploadFileID) {
    this.uploadFileID = uploadFileID;
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

  public List<MultipartFile> getAttachmentFile() {
    return attachmentFile;
  }

  public void setAttachmentFile(List<MultipartFile> attachmentFile) {
    this.attachmentFile = attachmentFile;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUndertake() {
    return undertake;
  }

  public void setUndertake(String undertake) {
    this.undertake = undertake;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getCompanyNature() {
    return companyNature;
  }

  public void setCompanyNature(String companyNature) {
    this.companyNature = companyNature;
  }

  public String getCompanyType() {
    return companyType;
  }

  public void setCompanyType(String companyType) {
    this.companyType = companyType;
  }

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }



  public Date getSigningDateEnd() {
    return signingDateEnd;
  }

  public void setSigningDateEnd(Date signingDateEnd) {
    this.signingDateEnd = signingDateEnd;
  }

  public String getCompanySize() {
    return companySize;
  }

  public void setCompanySize(String companySize) {
    this.companySize = companySize;
  }

  public String getContacts() {
    return contacts;
  }

  public void setContacts(String contacts) {
    this.contacts = contacts;
  }

  public String getAttachment() {
    return attachment;
  }

  public void setAttachment(String attachment) {
    this.attachment = attachment;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public String getIdentity() {
    return identity;
  }

  public void setIdentity(String identity) {
    this.identity = identity;
  }
}
