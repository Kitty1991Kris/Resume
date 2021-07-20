package webapp.model;

import java.util.Objects;

public class TextSection extends Section {
    private static final long serialVersionUID = 1L;
    private final String content;

    public TextSection(String content) {
        Objects.requireNonNull(content, "content must be not null");
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextSection that = (TextSection) o;
        return content.equals(that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
