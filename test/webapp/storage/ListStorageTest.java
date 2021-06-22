package webapp.storage;

import org.junit.Ignore;
import org.junit.Test;
import webapp.exception.StorageException;
import webapp.model.Resume;

public class ListStorageTest extends AbstractStorageTest {

    @Override
    public Storage createStorage() {
        return new ListStorage();
    }
    @Ignore
    @Test(expected = StorageException.class)
    public void storageOverflow() throws Exception {
        for (int i = 0; i <= AbstractArrayStorage.STORAGE_LENGTH + 1; i++) {
            storage.save(new Resume());
        }
    }
}