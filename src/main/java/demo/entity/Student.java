package demo.entity;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Student {
    @Id
    private String username;
    private String fullName;
    Ref<Account> accountRef;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
