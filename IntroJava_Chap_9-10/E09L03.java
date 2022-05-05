// Createa a TV class and test it with a main method
public class E09L03{
    public static void main(String[] args) {
        TV tv1 = new TV();
        tv1.turnOn();
        tv1.setChannel(30);
        tv1.setVolume(3);

        TV tv2 = new TV();
        tv2.turnOn();
        tv2.channelUp();
        tv2.volumeUp();

        System.out.println("TV1 's channel is " + tv1.channel + " and volume level is " + tv1.volume);
        System.out.println("TV2 's channel is " + tv2.channel + " and volume level is " + tv2.volume);

    }
}

class TV {
    // Data fields
    int channel = 1; // default channel
    int volume = 1; // default volumne
    boolean on = false; // TV is off

    // Constructor (which is also a method, with the same name as the calss; no return type!)
    TV() {       
    }

    // Define all the methods (with return type 'void' -- its a normal method not a constructor)
    public void turnOn() {
        on = true;
    }

    public void turnOff() {
        on = false;
    }

    public void setChannel(int newChannel) {
        if (on && newChannel >= 1 && newChannel <= 120)
            channel = newChannel;
    }

    public void setVolume(int newVolume) {
        if (on && newVolume >= 1 && newVolume <= 7)
            volume = newVolume;
    }

    public void channelUp() {
        if (on && channel < 120)
            channel++;
    }

    public void channelDown() {
        if (on && channel > 1) 
            channel--;
    }

    public void volumeUp() {
        if (on && volume < 7)
            volume++;
    }

    public void volumeDown() {
        if (on && volume > 1)
            volume--;
    }
}