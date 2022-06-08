package c09_ObjectsClasses;

// Create a TV class and test it with a main method
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
