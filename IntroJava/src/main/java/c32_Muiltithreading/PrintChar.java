package c32_Muiltithreading;

class PrintChar implements Runnable {
    private char c;
    private int times;

    public PrintChar(char c, int times) {
        this.c = c;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.print(c);
        }
    }
}
