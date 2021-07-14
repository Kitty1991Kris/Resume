package webapp.model;

public enum ContactType {
    PHONE("Телефон"),
    MOBILE("Мобильный"),
    HOME_PHONE("Домашний"),
    MAIL("Почта"),
    SKYPE("Skype"),
    ZOOM("Zoom"),
    LINKEDIN("Профиль LinkedIn"),
    GITHUB("Профиль GitHub"),
    STACKOVERFLOW("Профиль StackOverFlow"),
    HOME_PAGE("Домашняя страница"),
    OTHER("Другое");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
