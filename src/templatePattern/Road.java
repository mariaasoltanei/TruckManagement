package templatePattern;

public class Road {
    private String name;
    private int kms;

    public Road(String name, int kms) {
        this.name = name;
        this.kms = kms;
    }

    public int getKms() {
        return kms;
    }

    public String getName() {
        return name;
    }
}
