package Repository;

import java.util.ArrayList;

public abstract class MainRepository<repoType> implements IRepository<repoType> {
    protected final ArrayList<repoType> arrayList = new ArrayList<>();


    @Override
    public void add(repoType object) {
        if(!arrayList.contains(object)) {
            arrayList.add(object);
        }
    }

    @Override
    public void update(repoType object1, repoType object2) {
        if(arrayList.contains(object1)) {
            arrayList.remove(object1);
            arrayList.add(object2);
        }
    }

    @Override
    public void delete(repoType object) {
        if(arrayList.contains(object)) {
            arrayList.remove(object);
        }
    }

    @Override
    public ArrayList<repoType> getAll() {
        return new ArrayList<>(arrayList);
    }
}
