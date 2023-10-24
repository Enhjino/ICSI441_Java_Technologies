public class FindMaxAndMinCurrencyRateChange {

    public static void main(String[] args) {
        Bank<Currency> bank1 = new Bank<>("ХХБ");

        Currency USD1 = new Currency("Доллар", 3447.00, 3465.00, 3447.00, 3455.00);
        Currency EUR1 = new Currency("Евро", 3626.00, 3719.00, 3626.00, 3704.00);
        Currency JPY1 = new Currency("Иен", 22.89, 23.42, 22.96, 23.33);
        Currency GBP1 = new Currency("Фунт", 4209.00, 4305.00, 4209.00, 4288.00);
        Currency CNY1 = new Currency("Юань", 471.00, 476.20, 471.00, 475.00);
        Currency KRW1 = new Currency("Вон", 2.46, 2.63, 2.55, 2.62);

        bank1.addCurrency(USD1);
        bank1.addCurrency(EUR1);
        bank1.addCurrency(JPY1);
        bank1.addCurrency(GBP1);
        bank1.addCurrency(CNY1);
        bank1.addCurrency(KRW1);


        Bank<Currency> bank2 = new Bank<>("Голомт банк");

        Currency USD2 = new Currency("Доллар", 3446.00, 3446.00, 3446.00, 3446.00);
        Currency EUR2 = new Currency("Евро", 3631.00, 3710.00, 3625.00, 3625.00);
        Currency JPY2 = new Currency("Иен", 22.90, 23.37, 22.92, 22.92);
        Currency GBP2 = new Currency("Фунт", 4211.00, 4294.00, 4207.00, 4207.00);
        Currency CNY2 = new Currency("Юань", 470.70, 475.50, 470.70, 470.70);
        Currency KRW2 = new Currency("Вон", 2.46, 2.62, 2.47, 2.47);

        bank2.addCurrency(USD2);
        bank2.addCurrency(EUR2);
        bank2.addCurrency(JPY2);
        bank2.addCurrency(GBP2);
        bank2.addCurrency(CNY2);
        bank2.addCurrency(KRW2);

        Bank<Currency> bank3 = new Bank<>("Ариг банк");

        Currency USD3 = new Currency("Доллар", 3446.00, 3446.00, 3446.00, 3456.00);
        Currency EUR3 = new Currency("Евро", 3620.00, 3720.00, 3620.00, 3710.00);
        Currency JPY3 = new Currency("Иен", 22.90, 23.50, 22.90, 23.40);
        Currency GBP3 = new Currency("Фунт", 4150.00, 4310.00, 4150.00, 4310.00);
        Currency CNY3 = new Currency("Юань", 470.50, 477.00, 470.50, 475.50);
        Currency KRW3 = new Currency("Вон", 2.40, 2.63, 2.53, 2.62);

        bank3.addCurrency(USD3);
        bank3.addCurrency(EUR3);
        bank3.addCurrency(JPY3);
        bank3.addCurrency(GBP3);
        bank3.addCurrency(CNY3);
        bank3.addCurrency(KRW3);

        Bank<Currency> bank4 = new Bank<>("Төрийн банк");

        Currency USD4 = new Currency("Доллар", 3445.00, 3465.00, 3445.00, 3455.00);
        Currency EUR4 = new Currency("Евро", 3636.00, 3724.00, 3622.00, 3709.00);
        Currency JPY4 = new Currency("Иен", 22.91, 23.48, 22.91, 23.38);
        Currency GBP4 = new Currency("Фунт", 4211.00, 4294.00, 4207.00, 4207.00);
        Currency CNY4 = new Currency("Юань", 470.80, 477.40, 470.80, 475.00);
        Currency KRW4 = new Currency("Вон", 2.51, 2.64, 2.51, 2.62);

        bank4.addCurrency(USD4);
        bank4.addCurrency(EUR4);
        bank4.addCurrency(JPY4);
        bank4.addCurrency(GBP4);
        bank4.addCurrency(CNY4);
        bank4.addCurrency(KRW4);

        Bank<Currency> bank5 = new Bank<>("Богд банк");

        Currency USD5 = new Currency("Доллар", 3448.00, 3464.00, 3448.00, 3456.00);
        Currency EUR5 = new Currency("Евро", 3526.00, 3826.00, 3526.00, 3811.00);
        Currency JPY5 = new Currency("Иен", 22.60, 24.05, 22.60, 23.90);
        Currency GBP5 = new Currency("Фунт", 4102.60, 4433.60, 4110.00, 4396.00);
        Currency CNY5 = new Currency("Юань", 471.00, 476.90, 471.00, 475.50);
        Currency KRW5 = new Currency("Вон", 2.51, 2.64, 2.54, 2.61);

        bank5.addCurrency(USD5);
        bank5.addCurrency(EUR5);
        bank5.addCurrency(JPY5);
        bank5.addCurrency(GBP5);
        bank5.addCurrency(CNY5);
        bank5.addCurrency(KRW5);

        findAndPrintMaxMinRateChange(bank1, true);
        findAndPrintMaxMinRateChange(bank1, false);

        findAndPrintMaxMinRateChange(bank2, true);
        findAndPrintMaxMinRateChange(bank2, false);

        findAndPrintMaxMinRateChange(bank3, true);
        findAndPrintMaxMinRateChange(bank3, false);

        findAndPrintMaxMinRateChange(bank4, true);
        findAndPrintMaxMinRateChange(bank4, false);

        findAndPrintMaxMinRateChange(bank5, true);
        findAndPrintMaxMinRateChange(bank5, false);
    }

    public static void findAndPrintMaxMinRateChange(Bank<Currency> bank, boolean isCash) {
        Currency maxRateChangeCurrency = bank.findMaxRateChangeCurrency(isCash);
        Currency minRateChangeCurrency = bank.findMinRateChangeCurrency(isCash);

        if (maxRateChangeCurrency != null) {
            System.out.println("Ханшийн өөрчлөлт " + bank.getName() + " -ны " + (isCash ? "бэлэн" : "бэлэн бус") + " валют " + maxRateChangeCurrency.getName() + " зөрүү " +
                    (maxRateChangeCurrency.getSellCashPrice() - maxRateChangeCurrency.getBuyCashPrice()));
        }

        if (minRateChangeCurrency != null) {
            System.out.println("Их ханшийн өөрчлөлт буурсан" + bank.getName() + " -ны " + (isCash ? "бэлэн" : "бэлэн бус") + " валют " + minRateChangeCurrency.getName() + " зөрүү " +
                    (minRateChangeCurrency.getSellNonCashPrice() - minRateChangeCurrency.getBuyNonCashPrice()));
        }
    }

}

