package edu.neu.csye7374;

public class ByteDanceStockLazySingletonFactory implements StockFactory {
    private static ByteDanceStockLazySingletonFactory instance;
    
    private ByteDanceStockLazySingletonFactory() {}
    
    public static synchronized ByteDanceStockLazySingletonFactory getInstance() {
        if (instance == null) {
            instance = new ByteDanceStockLazySingletonFactory();
        }
        return instance;
    }
    
    @Override
    public Stock createStock(String name, double price, String description) {
        return new ByteDanceStock(name, price, description);
    }
} 