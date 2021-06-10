package webapp.storage;


import webapp.model.Resume;

public class ArrayStorage {
    private int storageLength = 10000;
    private final Resume[] storage = new Resume[storageLength];
    private int size = 0;

    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    public void save(Resume resume) {
        if (getIndex(resume.getId()) != -1) {
            System.out.println("Resume is present");
        } else if(size == storageLength) {
            System.out.println("Storage overflow");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public void update(Resume resume) {
        if (getIndex(resume.getId()) == -1) {
            System.out.println("Resume not exist");
        } else {
            storage[getIndex(resume.getId())] = resume;
        }
    }

    public Resume get(String id) {
        int index = getIndex(id);
        if (index == -1) {
            System.out.println("Error");
            return null;
        }
        return storage[getIndex(id)];
    }

    public void delete(String id) {
        int index = getIndex(id);
        if (index == -1) {
            System.out.println("Error, resume not exist");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume[] getAll() {
        Resume[] array = new Resume[size];
        for (int i = 0; i < size; i++) {
            array[i] = storage[i];
        }
        return array;
    }

    public int size() {
        return size;
    }

    private int getIndex(String id) {
        for (int i = 0; i < size; i++) {
            if (id.equals(storage[i].getId())) {
                return i;
            }
        }
        return -1;
    }
}
