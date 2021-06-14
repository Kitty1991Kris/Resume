package webapp.storage;

import webapp.exception.ExistStorageException;
import webapp.exception.NotExistStorageException;
import webapp.exception.StorageException;
import webapp.model.Resume;
import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LENGTH = 10_000;
    protected final Resume[] storage = new Resume[STORAGE_LENGTH];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getId());
        if (index >= 0) {
            throw new ExistStorageException(resume.getId());
        } else if(size == STORAGE_LENGTH) {
            throw new StorageException("Storage overflow", resume.getId());
        } else {
            insertElement(resume, index);
            size++;
        }
    }

    public void update(Resume resume) {
        if (getIndex(resume.getId()) >= 0) {
            throw new NotExistStorageException(resume.getId());
        } else {
            storage[getIndex(resume.getId())] = resume;
        }
    }

    public void delete(String id) {
        int index = getIndex(id);
        if (index < 0) {
            throw new NotExistStorageException(id);
        } else {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0 , size);
    }

    public Resume get(String id) {
        int index = getIndex(id);
        if (index < 0) {
            throw new NotExistStorageException(id);
        }
        return storage[getIndex(id)];
    }

    protected abstract int getIndex(String id);
    protected abstract void insertElement(Resume resume, int index);
    protected abstract void fillDeletedElement(int index);
}
