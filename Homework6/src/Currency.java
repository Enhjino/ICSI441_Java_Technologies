class Currency {
    private String name;
    private double buyCashPrice;
    private double sellCashPrice;
    private double buyNonCashPrice;
    private double sellNonCashPrice;

    public Currency(String name, double buyCashPrice, double sellCashPrice, double buyNonCashPrice, double sellNonCashPrice) {
        this.name = name;
        this.buyCashPrice = buyCashPrice;
        this.sellCashPrice = sellCashPrice;
        this.buyNonCashPrice = buyNonCashPrice;
        this.sellNonCashPrice = sellNonCashPrice;
    }

    public String getName() {
        return name;
    }

    public double getBuyCashPrice() {
        return buyCashPrice;
    }

    public double getSellCashPrice() {
        return sellCashPrice;
    }

    public double getBuyNonCashPrice() {
        return buyNonCashPrice;
    }

    public double getSellNonCashPrice() {
        return sellNonCashPrice;
    }
}
