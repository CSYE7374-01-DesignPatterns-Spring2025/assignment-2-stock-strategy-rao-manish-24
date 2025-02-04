package edu.neu.csye7374;

public class TeslaStockFactory implements StockFactory {
    @Override
    public Stock createStock(String name, double price, String description) {
        return new TeslaStock(name, price, description);
    }
} 