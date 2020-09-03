package com.company;

public class Main {

    public static void main(String[] args) {
	    ITelephone myPhone = new DeskPhone(123456);

	    myPhone.powerOn();
	    myPhone.callPhone(98765);
	    myPhone.answer();

	    myPhone = new MobilePhone(23456);
		myPhone.powerOn();
	    myPhone.callPhone(234);
	    myPhone.answer();
    }
}
