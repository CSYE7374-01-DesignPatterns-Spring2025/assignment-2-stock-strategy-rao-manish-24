package edu.neu.csye7374;

public class TeslaStockEagerSingletonFactory implements StockFactory {
    
    private static final TeslaStockEagerSingletonFactory instance = new TeslaStockEagerSingletonFactory();
    
    private TeslaStockEagerSingletonFactory() {}
    
    public static TeslaStockEagerSingletonFactory getInstance() {
        return instance; 
    }
    
    @Override
    public Stock createStock(String name, double price, String description) {
        return new TeslaStock(name, price, description);
    }
} 