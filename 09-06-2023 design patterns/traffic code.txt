package Behaviuorpattrn.simplem;

interface State {
    void switchOn(LightSwitch lightSwitch);
    void switchOff(LightSwitch lightSwitch);
    void nextPoint(LightSwitch lightSwitch);
}

class LightSwitch {
    private State state;

    public LightSwitch() {
        state = new OffState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void switchOn() {
        state.switchOn(this);
    }

    public void switchOff() {
        state.switchOff(this);
    }

    public void nextPoint() {
        state.nextPoint(this);
    }
}

class RedState implements State {
    @Override
    public void switchOn(LightSwitch lightSwitch) {
        System.out.println("Light is already on");
    }

    @Override
    public void switchOff(LightSwitch lightSwitch) {
        System.out.println("Switching light off");
        lightSwitch.setState(new OffState());
    }

    @Override
    public void nextPoint(LightSwitch lightSwitch) {
        System.out.println("Changing traffic light to Green");
        lightSwitch.setState(new GreenState());
    }
}

class GreenState implements State {
    @Override
    public void switchOn(LightSwitch lightSwitch) {
        System.out.println("Light is already on");
    }

    @Override
    public void switchOff(LightSwitch lightSwitch) {
        System.out.println("Switching light off");
        lightSwitch.setState(new OffState());
    }

    @Override
    public void nextPoint(LightSwitch lightSwitch) {
        System.out.println("Changing traffic light to Yellow");
        lightSwitch.setState(new YellowState());
    }
}

class YellowState implements State {
    @Override
    public void switchOn(LightSwitch lightSwitch) {
        System.out.println("Light is already on");
    }

    @Override
    public void switchOff(LightSwitch lightSwitch) {
        System.out.println("Switching light off");
        lightSwitch.setState(new OffState());
    }

    @Override
    public void nextPoint(LightSwitch lightSwitch) {
        System.out.println("Changing traffic light to Red");
        lightSwitch.setState(new RedState());
    }
}

class OffState implements State {
    @Override
    public void switchOn(LightSwitch lightSwitch) {
        System.out.println("Switching light on");
        lightSwitch.setState(new RedState());
    }

    @Override
    public void switchOff(LightSwitch lightSwitch) {
        System.out.println("Light is already off");
    }

    @Override
    public void nextPoint(LightSwitch lightSwitch) {
        System.out.println("Cannot change traffic lights while the light is off");
    }
}

public class StateExample {
    public static void main(String[] args) {
        LightSwitch lightSwitch = new LightSwitch();
        lightSwitch.switchOn();
        lightSwitch.nextPoint();
        lightSwitch.nextPoint();
        lightSwitch.switchOff();
        lightSwitch.switchOff();
        lightSwitch.switchOn();
        lightSwitch.nextPoint();
    }
}