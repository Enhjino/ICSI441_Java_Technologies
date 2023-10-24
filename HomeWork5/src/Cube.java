import java.io.Serializable;

class Cube implements Serializable {
    int size ;
    String color ;
    String material ;

    public Cube(int size, String color, String material) {
        this.size = size;
        this.color = color;
        this.material = material;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
