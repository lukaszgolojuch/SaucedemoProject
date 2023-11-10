package enums;

public enum Products {
    SAUCE_LABS_BACKPACK ("Sauce Labs Backpack",
            "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
            29.99,
            2.40),
    SAUCE_LABS_BIKE_LIGHT ("Sauce Labs Bike Light",
            "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
            9.99,
            0.80);

    private final String productName;
    private final String description;
    private final Double price;
    private final Double tax;

    Products(String productName, String description, double price, double tax) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.tax = tax;
    }

    public String productName() { return productName; }
    public String description() { return description; }
    public Double price() { return price; }
    public Double tax() { return tax; }
}
