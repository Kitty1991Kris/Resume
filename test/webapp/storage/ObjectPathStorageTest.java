package webapp.storage;

import webapp.storage.serializer.ObjectStreamSerializer;

public class ObjectPathStorageTest extends AbstractStorageTest{
    @Override
    protected Storage createStorage() {
        return new PathStorage(STORAGE_DIR.getAbsolutePath(), new ObjectStreamSerializer());
    }
}