package webapp.storage;

import webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected Object getSearchKey(String id) {
        return id;
    }

    @Override
    protected Resume doGet(Object id) {
        return map.get((String) id);
    }

    @Override
    protected void doSave(Resume resume, Object id) {
        map.put((String) id, resume);
    }

    @Override
    protected void doUpdate(Resume resume, Object id) {
        map.put((String) id, resume);
    }

    @Override
    protected void doDelete(Object id) {
        map.remove((String) id);
    }

    @Override
    protected boolean isExist(Object id) {
        return map.containsKey((String) id);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }
}
