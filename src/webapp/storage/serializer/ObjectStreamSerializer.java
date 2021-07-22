package webapp.storage.serializer;

import webapp.exception.StorageException;
import webapp.model.Resume;

import java.io.*;

public class ObjectStreamSerializer implements StreamSerializerStrategy {

    @Override
    public void doWrite(Resume resume, OutputStream file) throws IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(file)) {
            os.writeObject(resume);
        }
    }

    @Override
    public Resume doRead(InputStream file) throws IOException {
        try (ObjectInputStream is = new ObjectInputStream(file)) {
            return (Resume) is.readObject();
        } catch (ClassNotFoundException e) {
            throw new StorageException("Error read", null, e);
        }
    }
}
