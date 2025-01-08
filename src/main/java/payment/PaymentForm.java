package payment;

public class PaymentForm {
    // Method to process payment
    public boolean processPayment(String paymentType, double amount, String accountDetails) {
        // Validate inputs
        if (amount <= 0) {
            System.out.println("Invalid payment amount.");
            return false;
        }

        if (paymentType == null || accountDetails == null || accountDetails.isEmpty()) {
            System.out.println("Invalid payment details.");
            return false;
        }

        // Simulate processing based on payment type
        switch (paymentType.toLowerCase()) {
            case "credit card":
                return processCreditCard(amount, accountDetails);

            case "paypal":
                return processPayPal(amount, accountDetails);

            case "bank transfer":
                return processBankTransfer(amount, accountDetails);

            default:
                System.out.println("Unsupported payment type: " + paymentType);
                return false;
        }
    }

    // Dummy method for processing credit card payments
    private boolean processCreditCard(double amount, String cardNumber) {
        System.out.println("Processing credit card payment...");
        System.out.println("Amount: $" + amount);
        System.out.println("Card Number: " + maskSensitiveData(cardNumber));
        return true; // Assume success
    }

    // Dummy method for processing PayPal payments
    private boolean processPayPal(double amount, String email) {
        System.out.println("Processing PayPal payment...");
        System.out.println("Amount: $" + amount);
        System.out.println("PayPal Account: " + email);
        return true; // Assume success
    }

    // Dummy method for processing bank transfers
    private boolean processBankTransfer(double amount, String accountNumber) {
        System.out.println("Processing bank transfer...");
        System.out.println("Amount: $" + amount);
        System.out.println("Bank Account: " + maskSensitiveData(accountNumber));
        return true; // Assume success
    }

    // Utility method to mask sensitive data
    private String maskSensitiveData(String data) {
        if (data.length() <= 4) {
            return "****";
        }
        return "****" + data.substring(data.length() - 4);
    }
}
