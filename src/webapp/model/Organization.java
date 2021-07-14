package webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Organization {
    private final Link homePage;

    private final String title;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String description;

    public Organization(String name, String url, String title, LocalDate startDate, LocalDate endDate, String description) {
        this.homePage = new Link(name, url);
        Objects.requireNonNull(title, "title must be not null");
        this.title = title;
        Objects.requireNonNull(startDate, "startDate must be not null");
        Objects.requireNonNull(endDate, "endDate must be not null");
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", title='" + title + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return homePage.equals(that.homePage) && title.equals(that.title) && startDate.equals(that.startDate) && endDate.equals(that.endDate) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, title, startDate, endDate, description);
    }
}
