package com.java.design.adapter;

public class PowerAdapter {

    enum PowerType{
        V5,V220
    }

    private Power input;

    public PowerAdapter(Power power){
        input = power;
    }

    public Power Output(PowerType powerType){
//        System.out.println("before my power is "+input.power);

        switch (powerType){
            case V5:
                V5Power v5Power = new V5Power();
                System.out.println("now my power is "+v5Power.power);
                return v5Power;
            case V220:
                V220Power v220Power = new V220Power();
                System.out.println("now my power is "+v220Power.power);
                return v220Power;
            default:
                break;
        }
        return null;
    }

    public static void main(String[] args) {
        V5Power v5Power = new V5Power();
        PowerAdapter powerAdapter = new PowerAdapter(v5Power);
        powerAdapter.Output(PowerType.V220);
    }
}
