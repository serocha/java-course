public class Monitor extends Product {

    private int refreshRate;
    private int size;
    private String resolution;

    public Monitor(String model, String manufacturer,
                   int refreshRate, int size, String resolution) {
        super(model, manufacturer);
        this.refreshRate = refreshRate;
        this.size = size;
        this.resolution = resolution;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public int getSize() {
        return size;
    }

    public String getResolution() {
        return resolution;
    }

    public void drawPixelAt(int x, int y, String color) {
        System.out.printf("Pixel colored %s at position (%d,%d)%n", color, x, y);
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "refreshRate=" + refreshRate +
                ", size=" + size +
                ", resolution='" + resolution + '\'' +
                "} " + super.toString();
    }
}
