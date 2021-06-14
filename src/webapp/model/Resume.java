package webapp.model;

import java.util.UUID;

public class Resume implements Comparable<Resume>{
    private final String id;

    public Resume(String id) {
        this.id = id;
    }

    public Resume() {
        this(UUID.randomUUID().toString());
    }

    @Override
    public int compareTo(Resume o) {
        return id.compareTo(o.id);
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

    public String getId() {
        return id;
    }
}
