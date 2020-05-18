package my.likeaglow.kuzuroshop.domain;

import java.util.Date;

public class MemberVO {

//    CREATE TABLE tbl_memebr (
//            userId VARCHAR(50) NOT NULL,
//            userPass VARCHAR(100) NOT NULL,
//            userName VARCHAR(30) NOT NULL,
//            userPhone VARCHAR(20) NOT NULL,
//            userAddr1 VARCHAR(20) NULL,
//            userAddr2 VARCHAR(50) NULL,
//            userAddr3 VARCHAR(50) NULL,
//            regDage TIMEstamp DEFAULT NOW(),
//            verify INT DEFAULT 0,
//            PRIMARY KEY(userId)
//            );

    private String userId;
    private String userPass;
    private String userName;
    private String userPhon;
    private String userAddr1;
    private String userAddr2;
    private String userAddr3;
    private Date regiDate;
    private int verify;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhon() {
        return userPhon;
    }

    public void setUserPhon(String userPhone) {
        this.userPhon = userPhone;
    }

    public String getUserAddr1() {
        return userAddr1;
    }

    public void setUserAddr1(String userAddr1) {
        this.userAddr1 = userAddr1;
    }

    public String getUserAddr2() {
        return userAddr2;
    }

    public void setUserAddr2(String userAddr2) {
        this.userAddr2 = userAddr2;
    }

    public String getUserAddr3() {
        return userAddr3;
    }

    public void setUserAddr3(String userAddr3) {
        this.userAddr3 = userAddr3;
    }

    public Date getRegiDate() {
        return regiDate;
    }

    public void setRegiDate(Date regiDate) {
        this.regiDate = regiDate;
    }

    public int getVerify() {
        return verify;
    }

    public void setVerify(int verify) {
        this.verify = verify;
    }
}