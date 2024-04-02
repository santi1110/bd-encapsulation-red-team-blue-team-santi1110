package com.amazon.ata.encapsulation.model;

/**
 * The class representing a customer's payment preferences.
 * This is the intersection of a Customer and the PaymentInstruments they can
 * use. The instruments are in the customer's preferred order.
 * <p>
 * THIS CLASS IS ALREADY VULNERABLE TO EXTERNAL ATTACK.
 * <p>
 * Assume it belongs to a backend package and an attacker has read-only access.
 */
public class CustomerPaymentInstruments {
    private final Customer customer;
    private final PaymentInstrument[] paymentInstruments;

    /**
     * Constructor relating a Customer to their preferred PaymentInstruments.
     *
     * @param customer    The customer whose preferences we're describing.
     * @param instruments Their preferred PaymentInstruments, in order.
     */
    public CustomerPaymentInstruments(final Customer customer, final PaymentInstrument[] instruments) {
        this.customer = customer;
        paymentInstruments = instruments;
    }

    public String getCustomerId() {
        return customer.getId();
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public PaymentInstrument[] getPaymentInstruments() {
        PaymentInstrument [] copies = new PaymentInstrument[paymentInstruments.length];
        for (int i=0; i<paymentInstruments.length; i++) {
         /*   copies[i] = paymentInstruments[i];*/
            copies[i] = new PaymentInstrument(paymentInstruments[i].getInstrumentId());
            copies[i].setInstrumentType(paymentInstruments[i].getInstrumentType());
            copies[i].setAvailableFunds(paymentInstruments[i].getAvailableFunds());
        }
        return copies;
    }
}
