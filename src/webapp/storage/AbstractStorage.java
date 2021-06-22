package webapp.storage;

import webapp.exception.ExistStorageException;
import webapp.exception.NotExistStorageException;
import webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract Object getSearchKey(String id);

    protected abstract Resume doGet(Object searchKey);

    protected abstract void doSave(Resume resume, Object searchKey);

    protected abstract void doUpdate(Resume resume, Object searchKey);

    protected abstract void doDelete(Object searchKey);

    protected abstract boolean isExist(Object searchKey);

    @Override
    public void save(Resume resume) {
        Object searchKey = getNotExitedSearchKey(resume.getId());
        doSave(resume, searchKey);

    }

    @Override
    public void update(Resume resume) {
        Object searchKey = getExitedSearchKey(resume.getId());
        doUpdate(resume, searchKey);

    }

    @Override
    public void delete(String id) {
        Object searchKey = getExitedSearchKey(id);
        doDelete(searchKey);
    }

    @Override
    public Resume get(String id) {
        Object searchKey = getExitedSearchKey(id);
        return doGet(searchKey);
    }


    private Object getExitedSearchKey(String id) {
        Object searchKey = getSearchKey(id);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(id);
        }
        return searchKey;
    }

    private Object getNotExitedSearchKey(String id) {
        Object searchKey = getSearchKey(id);
        if (isExist(searchKey)) {
            throw new ExistStorageException(id);
        }
        return searchKey;
    }
}
