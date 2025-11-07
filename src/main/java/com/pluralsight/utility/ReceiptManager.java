package com.pluralsight.utility;

import com.pluralsight.order.Order;

public class ReceiptManager {
    final static String receiptFolder = "receipts/";

    public String createReceipt(Order order) {
        // Logic to create a receipt for the given order
        return "Receipt for order #" + order.getId();
    }

    public void loadReceipts() {
        // Logic to load existing receipts from the receiptFolder
    }
}
