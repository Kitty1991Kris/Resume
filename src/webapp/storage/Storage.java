package webapp.storage;

import webapp.model.Resume;

public interface Storage {

    void clear();

    void save(Resume resume);

    void update(Resume resume);

    Resume get(String id);

    void delete(String id);

    Resume[] getAll();

    int size();
}
