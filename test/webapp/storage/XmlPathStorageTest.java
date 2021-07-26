package webapp.storage;

import webapp.storage.serializer.XmlStreamSerializer;

public class XmlPathStorageTest extends AbstractStorageTest{
    @Override
    protected Storage createStorage() {
        return new PathStorage(STORAGE_DIR.getAbsolutePath(), new XmlStreamSerializer());
    }
}