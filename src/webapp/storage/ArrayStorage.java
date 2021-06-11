package webapp.storage;


import webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage implements Storage {
    private static final int STORAGE_LENGTH = 10000;
    private final Resume[] storage = new Resume[STORAGE_LENGTH];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (getIndex(resume.getId()) != -1) {
            System.out.println("Resume is present");
        } else if(size == STORAGE_LENGTH) {
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
        return Arrays.copyOfRange(storage, 0 , size);
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
