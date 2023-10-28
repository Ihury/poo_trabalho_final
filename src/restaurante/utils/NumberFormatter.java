package restaurante.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatter {
    public static String formatPrice(double price) {
        NumberFormat brazilianFormat = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        return brazilianFormat.format(price);
    }
}
