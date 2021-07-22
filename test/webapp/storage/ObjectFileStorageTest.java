package webapp.storage;

import webapp.storage.serializer.ObjectStreamSerializer;

public class ObjectFileStorageTest extends AbstractStorageTest {

    @Override
    protected Storage createStorage() {
        return new FileStorage(STORAGE_DIR, new ObjectStreamSerializer());
    }
}