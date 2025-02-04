package edu.neu.csye7374;

public class TikTokStockLazySingletonFactory implements StockFactory {
    private static TikTokStockLazySingletonFactory instance;
    
    private TikTokStockLazySingletonFactory() {}
    
    public static synchronized TikTokStockLazySingletonFactory getInstance() {
        if (instance == null) {
            instance = new TikTokStockLazySingletonFactory();
        }
        return instance;
    }
    
    @Override
    public Stock createStock(String name, double price, String description) {
        return new TikTokStock(name, price, description);
    }
} 