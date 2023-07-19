package com.fawry.pack.payment.handler;



import com.fawry.pack.authentication.BankCherker;

public class PaymentByCreditCard implements PaymentStratety{
    private String cardNumber;
    @Override
    public String pay(double ammount) {
        // bank checks validation
        BankCherker bankCherker = new BankCherker();
        bankCherker.checkValidation(cardNumber);
        // apply payment
        System.out.println("apply payment with credit card take " + ammount + " doller");
        return "apply payment with credit card totall ammount = " + ammount + " doller";
    }

    public PaymentByCreditCard(String creditCardNumber) {
        this.cardNumber = creditCardNumber;
    }

}


