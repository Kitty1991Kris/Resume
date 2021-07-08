package webapp.storage;

public class ListStorageTest extends AbstractStorageTest {

    @Override
    public Storage createStorage() {
        return new ListStorage();
    }

}