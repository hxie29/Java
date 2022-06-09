package c17_BinaryIO;

import java.io.*;

public class BitOutputStream implements AutoCloseable {
    int bits; // bit buffer
    int bitPos; // bitPos bit index, gets reset when bitPos == 8
    FileOutputStream out;

    public BitOutputStream(File file) throws FileNotFoundException{
        out = new FileOutputStream(file);
    }

    public void writeBit(char bit) throws IOException{
        bits = bits << 1;

        if (bit == '1')
            bits = bits | 1;

        if (++bitPos == 8) {
            out.write(bits);
            bitPos = 0;
        }
    }

    public void writeBit(String bit) throws IOException{
        for (int i = 0; i < bit.length(); i++) {
            writeBit(bit.charAt(i));
        }
    }

    @Override
    public void close() throws IOException{
        if (bitPos > 0) {
            bits = bits << 8 - bitPos; // add 0's to end of byte
            out.write(bits);
        }
        out.close();
    }
    
}
