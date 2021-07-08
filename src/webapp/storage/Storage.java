package webapp.storage;

import webapp.model.Resume;

import java.util.List;

public interface Storage {

    void clear();

    void save(Resume resume);

    void update(Resume resume);

    Resume get(String id);

    void delete(String id);

    List<Resume> getAllSorted();

    int size();
}
