package webapp.storage;

import webapp.exception.ExistStorageException;
import webapp.exception.NotExistStorageException;
import webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<Key> implements Storage {
    private static final Logger LOGGER = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract Key getSearchKey(String id);

    protected abstract Resume doGet(Key searchKey);

    protected abstract void doSave(Resume resume, Key searchKey);

    protected abstract void doUpdate(Resume resume, Key searchKey);

    protected abstract void doDelete(Key searchKey);

    protected abstract boolean isExist(Key searchKey);

    protected abstract List<Resume> doCopyAll();

    @Override
    public void save(Resume resume) {
            LOGGER.info("Save " + resume);
        Key searchKey = getNotExitedSearchKey(resume.getId());
        doSave(resume, searchKey);

    }

    @Override
    public void update(Resume resume) {
        LOGGER.info("Update " + resume);
        Key searchKey = getExitedSearchKey(resume.getId());
        doUpdate(resume, searchKey);

    }

    @Override
    public void delete(String id) {
        LOGGER.info("Delete " + id);
        Key searchKey = getExitedSearchKey(id);
        doDelete(searchKey);
    }

    @Override
    public Resume get(String id) {
        LOGGER.info("Get " + id);
        Key searchKey = getExitedSearchKey(id);
        return doGet(searchKey);
    }


    private Key getExitedSearchKey(String id) {
        Key searchKey = getSearchKey(id);
        if (!isExist(searchKey)) {
            LOGGER.warning("Resume " + id + " not exist");
            throw new NotExistStorageException(id);
        }
        return searchKey;
    }

    private Key getNotExitedSearchKey(String id) {
        Key searchKey = getSearchKey(id);
        if (isExist(searchKey)) {
            LOGGER.warning("Resume " + id + " is exist");
            throw new ExistStorageException(id);
        }
        return searchKey;
    }

    public List<Resume> getAllSorted() {
        LOGGER.info("getAllSorted");
        List<Resume> list = doCopyAll();
        Collections.sort(list);
        return list;
    }

}
