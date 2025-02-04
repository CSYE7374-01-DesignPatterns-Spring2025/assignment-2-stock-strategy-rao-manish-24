package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static StockMarket instance;
    private List<Stock> stocks;

    private StockMarket() {
        stocks = new ArrayList<>();
    }

    public static synchronized StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
    }

    public void showAllStocks() {
        if (stocks.isEmpty()) {
            System.out.println("No stocks in the market");
            return;
        }

        for (Stock stock : stocks) {
            System.out.println(stock);
            System.out.println("Performance Metric: " + stock.getMetric());
            System.out.println("-------------------");
        }
    }

    public static void demo() {
        System.out.println("============ Stock Market Demo ============");

        StockMarket market = StockMarket.getInstance();

        StockFactory regularByteDanceFactory = new ByteDanceStockFactory();
        StockFactory regularTeslaFactory = new TeslaStockFactory();
        StockFactory regularTikTokFactory = new TikTokStockFactory();

        StockFactory singletonByteDanceFactory = ByteDanceStockLazySingletonFactory.getInstance();
        StockFactory singletonTeslaFactory = TeslaStockEagerSingletonFactory.getInstance();
        StockFactory singletonTikTokFactory = TikTokStockLazySingletonFactory.getInstance();

        Stock teslaStock = singletonTeslaFactory.createStock("Tesla", 175.50, "Tesla Motors Corporation Stock");
        teslaStock.setMarketStrategy(new BullMarketStrategy());
        Stock tikTokStock = singletonTikTokFactory.createStock("TikTok", 425.75, "TikTok Entertainment Platform Stock");
        tikTokStock.setMarketStrategy(new BearMarketStrategy());

        market.addStock(teslaStock);
        market.addStock(tikTokStock);

        System.out.println("\nInitial Stock Market State:");
        market.showAllStocks();

        System.out.println("\nTrading Demonstration:");

        System.out.println("\n========== Tesla Stock ==========");
        System.out.println("Implementing Bull Market Strategy");

        String[] teslaBids = {"192.25", "245.80", "312.45", "287.90", "156.75", "298.50"};

        for (String bid : teslaBids) {
            System.out.println("\nPlacing bid: " + bid);
            teslaStock.setBid(Double.parseDouble(bid));
            System.out.println("Updated Tesla Stock:");
            System.out.println(teslaStock);
            System.out.println("--------------------------------");
        }

        System.out.println("\n========== TikTok Stock ==========");
        System.out.println("Implementing Bear Market Strategy");

        String[] tikTokBids = {"398.75", "256.80", "312.90", "445.25", "289.60", "367.40"};

        for (String bid : tikTokBids) {
            System.out.println("\nPlacing bid: " + bid);
            tikTokStock.setBid(Double.parseDouble(bid));
            System.out.println("Updated TikTok Stock:");
            System.out.println(tikTokStock);
            System.out.println("--------------------------------");
        }

        System.out.println("\nFinal Stock Market State:");
        market.showAllStocks();

        System.out.println("\n========== Demo Complete ==========");
    }
}
