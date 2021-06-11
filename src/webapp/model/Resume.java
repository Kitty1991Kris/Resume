package webapp.model;

import java.util.Objects;

public class Resume {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return id.equals(resume.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
