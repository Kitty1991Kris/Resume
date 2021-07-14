package webapp.storage;

import webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected Resume getSearchKey(String id) {
        return map.get(id);
    }

    @Override
    protected Resume doGet(Resume resume) {
        return resume;
    }

    @Override
    protected void doSave(Resume r, Resume resume) {
        map.put(r.getId(), r);
    }

    @Override
    protected void doUpdate(Resume r, Resume resume) {
        map.put(r.getId(), r);
    }

    @Override
    protected void doDelete(Resume resume) {
        map.remove(resume.getId());
    }

    @Override
    protected boolean isExist(Resume resume) {
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
