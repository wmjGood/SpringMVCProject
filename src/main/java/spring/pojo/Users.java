package spring.pojo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;


public class Users {
    private  int id;

    private  String idPicPath;

    @NotNull(message = "用户编码不能为空")
   private String userCode;
    @NotEmpty(message = "用户名不能为空")
   private String userName;
    @Length(min = 6,max = 11,message = "密码长度为6-10")
   private  String userPassword;

    public Users() {
    }

    public Users(int id, String idPicPath, String userCode, String userName, String userPassword) {
        this.id = id;
        this.idPicPath = idPicPath;
        this.userCode = userCode;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getIdPicPath() {
        return idPicPath;
    }

    public void setIdPicPath(String idPicPath) {
        this.idPicPath = idPicPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", idPicPath='" + idPicPath + '\'' +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
