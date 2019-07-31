package lec_14.homework.set_elements;

public class Phone {
    private String model;
    private String producer;
    private int price;

    public Phone(String model, String producer, int price) {
        this.model = model;
        this.producer = producer;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
