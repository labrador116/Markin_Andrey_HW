/**
 * Created by Andrey_pers on 19.10.2016.
 */

public abstract class Product implements ICharacteristics  {

    private String name;
    private String colour;
    private float weight;
    private int price;

    public Product(String name, String colour, float weight, int price) {
        this.name = name;
        this.colour = colour;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String GetName() {
        return name;
    }

    @Override
    public String GetColour() {
        return colour;
    }

    @Override
    public int GetPrice() {
        return price;
    }

    @Override
    public float GetWeight() {
        return weight;
    }
}
