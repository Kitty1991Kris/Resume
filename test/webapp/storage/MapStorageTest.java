package webapp.storage;

import static org.junit.Assert.*;

public class MapStorageTest extends AbstractStorageTest {
    public Storage createStorage() {
        return new MapStorage();
    }

}