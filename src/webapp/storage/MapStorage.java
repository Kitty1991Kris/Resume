package webapp.storage;

import webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage<String> {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected String getSearchKey(String id) {
        return id;
    }

    @Override
    protected Resume doGet(String id) {
        return map.get(id);
    }

    @Override
    protected void doSave(Resume resume, String id) {
        map.put(id, resume);
    }

    @Override
    protected void doUpdate(Resume resume, String id) {
        map.put(id, resume);
    }

    @Override
    protected void doDelete(String id) {
        map.remove(id);
    }

    @Override
    protected boolean isExist(String id) {
        return map.containsKey(id);
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
