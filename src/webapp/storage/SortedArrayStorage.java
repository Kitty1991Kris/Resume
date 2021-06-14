package webapp.storage;

import webapp.model.Resume;
import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void insertElement(Resume resume, int index) {
        int indexToInsert = - index - 1;
        System.arraycopy(storage, indexToInsert, storage, indexToInsert + 1, size - indexToInsert);
        storage[indexToInsert] = resume;
    }

    @Override
    protected void fillDeletedElement(int index) {
        int numbToInsert = size - index - 1;
        if (numbToInsert > 0) {
            System.arraycopy(storage, index + 1, storage, index, numbToInsert);
        }
    }

    @Override
    protected int getIndex(String id) {
        Resume keySearch = new Resume(id);
        return Arrays.binarySearch(storage, 0, size, keySearch);
    }
}
