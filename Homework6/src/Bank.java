import java.util.ArrayList;
import java.util.List;

class Bank<C extends Currency> {
    private final String name;
    private final List<C> currencies;

    public Bank(String name) {
        this.name = name;
        this.currencies = new ArrayList<>();
    }

    public void addCurrency(C currency) {
        currencies.add(currency);
    }

    public String getName() {
        return name;
    }

    public List<C> getCurrencies() {
        return currencies;
    }

    public C findMaxRateChangeCurrency(boolean isCash) {
        C maxRateChangeCurrency = null;
        double maxRateChange = 0;

        for (C currency : currencies) {
            double buyPrice, sellPrice;
            if (isCash) {
                buyPrice = currency.getBuyCashPrice();
                sellPrice = currency.getSellCashPrice();
            } else {
                buyPrice = currency.getBuyNonCashPrice();
                sellPrice = currency.getSellNonCashPrice();
            }

            double rateChange = sellPrice - buyPrice;
            if (rateChange > maxRateChange) {
                maxRateChange = rateChange;
                maxRateChangeCurrency = currency;
            }
        }

        return maxRateChangeCurrency;
    }
    public C findMinRateChangeCurrency(boolean isCash) {
        C minRateChangeCurrency = null;
        double minRateChange = 0;

        for (C currency : currencies) {
            double buyPrice, sellPrice;
            if (isCash) {
                buyPrice = currency.getBuyCashPrice();
                sellPrice = currency.getSellCashPrice();
            } else {
                buyPrice = currency.getBuyNonCashPrice();
                sellPrice = currency.getSellNonCashPrice();
            }

            double rateChange = sellPrice - buyPrice;
            if (rateChange < minRateChange) {
                minRateChange = rateChange;
                minRateChangeCurrency = currency;
            }
        }

        return minRateChangeCurrency;
    }
}