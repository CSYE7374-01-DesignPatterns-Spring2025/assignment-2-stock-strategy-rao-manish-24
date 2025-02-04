package edu.neu.csye7374;

public class TikTokStock extends Stock {
    private double lastBid;
    
    public TikTokStock(String name, double price, String description) {
        super(name, price, description);
        this.lastBid = price;
    }
    
    @Override
    public void setBid(String bid) {
        double bidValue = Double.parseDouble(bid);
        this.lastBid = bidValue;
       
        setPrice((getPrice() * 0.6) + (bidValue * 0.4));
    }
    
    @Override
    public String getMetric() {
       
        double priceChange = getPrice() - lastBid;
        double percentageChange = (priceChange / lastBid) * 100;
        return String.format("%.2f%%", percentageChange);
    }
} 