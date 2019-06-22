package demo.entity;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Student {
    @Id
    private String rollNumber;
    private String fullName;
    private String avatarUrl;
    Ref<Account> accountRef;

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Ref<Account> getAccountRef() {
        return accountRef;
    }

    public void setAccountRef(Ref<Account> accountRef) {
        this.accountRef = accountRef;
    }
}
