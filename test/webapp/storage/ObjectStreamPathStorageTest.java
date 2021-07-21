package webapp.storage;

public class ObjectStreamPathStorageTest extends AbstractStorageTest{
    @Override
    protected Storage createStorage() {
        return new ObjectStreamPathStorage(STORAGE_DIR.getAbsolutePath());
    }
}