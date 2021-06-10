package lt.viko.eif.generatoriai.demo.model;

import java.util.List;

public class Transport {
    private String title;
    private List<String> addres;

    public Transport(String title, List<String> addres) {
        this.title = title;
        this.addres = addres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAddres() {
        return addres;
    }

    public void setAddres(List<String> addres) {
        this.addres = addres;
    }
}
