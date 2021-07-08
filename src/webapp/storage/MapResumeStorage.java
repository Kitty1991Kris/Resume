package webapp.storage;

import webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected Resume getSearchKey(String id) {
        return map.get(id);
    }

    @Override
    protected Resume doGet(Object resume) {
        return (Resume) resume;
    }

    @Override
    protected void doSave(Resume r, Object resume) {
        map.put(r.getId(), r);
    }

    @Override
    protected void doUpdate(Resume r, Object resume) {
        map.put(r.getId(), r);
    }

    @Override
    protected void doDelete(Object resume) {
        map.remove(((Resume) resume).getId());
    }

    @Override
    protected boolean isExist(Object resume) {
        return resume != null;
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
