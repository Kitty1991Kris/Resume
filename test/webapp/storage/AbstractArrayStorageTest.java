package webapp.storage;

import org.junit.Assert;
import org.junit.Test;
import webapp.exception.StorageException;
import webapp.model.Resume;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    @Test(expected = StorageException.class)
    public void saveOverFlow() throws Exception{
        try {
            for (int i = 7; i <= AbstractArrayStorage.STORAGE_LENGTH; i++) {
                storage.save(new Resume("name"));
            }
        } catch (StorageException e) {
            Assert.fail();
        }storage.save(new Resume("name"));
    }
}