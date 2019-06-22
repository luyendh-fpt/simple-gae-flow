package demo.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.util.Calendar;
import java.util.HashMap;

@Entity
public class ClassRoom {
    @Id
    private long id;
    @Index
    private String name;
    private String imageUrl;
    private String description;
    @Index
    private long createdAtMLS;
    @Index
    private long updatedAtMLS;
    @Index
    private int status;

    public ClassRoom() {
        initComponent();
    }

    public ClassRoom(String name, String description) {
        initComponent();
        this.name = name;
        this.description = description;
    }

    private void initComponent(){
        this.id = Calendar.getInstance().getTimeInMillis();
        this.createdAtMLS = Calendar.getInstance().getTimeInMillis();
        this.updatedAtMLS = Calendar.getInstance().getTimeInMillis();
        this.status = ClassRoom.Status.ACTIVE.getValue();
        this.name = "";
        this.description = "";
    }

    public HashMap<String, String> validate() {
        HashMap<String, String> errors = new HashMap<>();
        if (name == null || name.isEmpty()) {
            errors.put("name", "Name is required!");
        }
        if (description == null || description.isEmpty()) {
            errors.put("description", "Description is required!");
        }
        return errors;
    }

    public enum Status {
        ACTIVE(1), DEACTIVE(0), DELETED(-1);

        int value;

        Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setStatus(Status status) {
        this.status = status.getValue();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
