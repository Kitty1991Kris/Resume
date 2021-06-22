package webapp.storage;


import webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(Resume resume, int index) {
        storage[size] = resume;
    }

    @Override
    protected void fillDeletedElement(int index) {
        storage[index] = storage[size - 1];
    }

    protected Integer getSearchKey(String id) {
        for (int i = 0; i < size; i++) {
            if (id.equals(storage[i].getId())) {
                return i;
            }
        }
        return -1;
    }
}
