package webapp.storage;

public class ObjectStreamStorageTest extends AbstractStorageTest {

    @Override
    protected Storage createStorage() {
        return new ObjectStreamStorage(STORAGE_DIR);
    }
}