package edu.neu.csye7374;

public class TikTokStockFactory implements StockFactory {
    @Override
    public Stock createStock(String name, double price, String description) {
        return new TikTokStock(name, price, description);
    }
} 