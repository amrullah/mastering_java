package com.company;

public class MobilePhone implements ITelephone {
    private int myNumber;
    private boolean isRinging;
    private boolean isOn;

    public MobilePhone(int myNumber) {
        this.myNumber = myNumber;
        isOn = false;
    }

    @Override
    public void powerOn() {
        isOn = true;
        System.out.println("Mobile phone now powered up");
    }

    @Override
    public void dial(int phoneNumber) {
        if (isOn) {
            System.out.printf("Now ringing %1$s on mobile phone\n", phoneNumber);
        } else {
            System.out.println("Phone is switched off");
        }

    }

    @Override
    public void answer() {
        if (isRinging) {
            System.out.println("Answering the mobile phone");
            isRinging = false;
        }
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (phoneNumber == myNumber && isOn) {
            isRinging = true;
            System.out.println("Tring Tring");
        } else {
            isRinging = false;
        }

        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return false;
    }
}
