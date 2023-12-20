package pages.homework05.secondTask;

import java.util.List;

public final class Data {

    private List<Tester> objects;

    public Data(List<Tester> objects) {
        this.objects = objects;
    }

    public List<Tester> getObjects() {
        return objects;
    }

    public void setObjects(List<Tester> objects) {
        this.objects = objects;
    }
}
