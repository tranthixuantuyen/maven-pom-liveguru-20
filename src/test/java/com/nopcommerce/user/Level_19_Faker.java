package com.nopcommerce.user;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

import java.util.Locale;

public class Level_19_Faker {
    public static  void main(String[] args){
        Faker faker = new Faker();
        System.out.println(faker.address().firstName());
        System.out.println(faker.address().lastName());
        System.out.println(faker.business().creditCardNumber());
        System.out.println(faker.business().creditCardExpiry());

        System.out.println(faker.finance().creditCard(CreditCardType.VISA));

        Faker fakeVi = new Faker((new Locale("vi")));
        System.out.println(fakeVi.address().firstName());
        System.out.println(fakeVi.address().lastName());
    }



}
