package webapp.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Resume implements Comparable<Resume>{
    private final String id;
    private final String fullName;
    private final Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    private final Map<SectionType, Section> section = new EnumMap<>(SectionType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(),fullName);
    }

    public Resume(String id, String fullName) {
        Objects.requireNonNull(id, "id must be not null");
        Objects.requireNonNull(fullName, "fullName must be not null");
        this.id = id;
        this.fullName = fullName;
    }

    public String getContact(ContactType type) {
        return contacts.get(type);
    }

    public Section getSection(SectionType type) {
        return section.get(type);
    }

    @Override
    public int compareTo(Resume o) {
        int i = fullName.compareTo(o.fullName);
        return i != 0 ? i : id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return id + "{ " + fullName + " }";
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        if (!id.equals(resume.id)) return false;
        return fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }
}
