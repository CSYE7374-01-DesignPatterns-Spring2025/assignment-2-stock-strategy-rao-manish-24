package edu.neu.csye7374;

public class ByteDanceStockFactory implements StockFactory {
    @Override
    public Stock createStock(String name, double price, String description) {
        return new ByteDanceStock(name, price, description);
    }
} 