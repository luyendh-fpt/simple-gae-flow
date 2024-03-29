package demo.entity;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import demo.util.StringUtil;

import java.util.Calendar;

@Entity
public class Account {
    @Id
    private String username;
    private String password;
    private String salt;
    @Index
    private long createdAtMLS;
    @Index
    private long updatedAtMLS;
    @Index
    private int status;

    Ref<Student> studentRef;

    public Account() {
        generateSalt();
        this.createdAtMLS = Calendar.getInstance().getTimeInMillis();
        this.updatedAtMLS = Calendar.getInstance().getTimeInMillis();
        this.status = 1;
    }

    private void generateSalt() {
        this.salt = StringUtil.generateSalt();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void encryptPassword(String password) {
        this.password = StringUtil.hashPassword(password, this.salt);
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public long getCreatedAtMLS() {
        return createdAtMLS;
    }

    public void setCreatedAtMLS(long createdAtMLS) {
        this.createdAtMLS = createdAtMLS;
    }

    public long getUpdatedAtMLS() {
        return updatedAtMLS;
    }

    public void setUpdatedAtMLS(long updatedAtMLS) {
        this.updatedAtMLS = updatedAtMLS;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Ref<Student> getStudentRef() {
        return studentRef;
    }

    public void setStudentRef(Ref<Student> studentRef) {
        this.studentRef = studentRef;
    }
}
