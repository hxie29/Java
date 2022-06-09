package c17_BinaryIO;/* Filter streams are streams that filter bytes for some purpose. The basic byte input stream
provides a read method that can be used only for reading bytes. If you want to read integers,
doubles, or strings, you need a filter class to wrap the byte input stream. Using a filter class
enables you to read integers, doubles, and strings instead of bytes and characters. Filter-
InputStream and FilterOutputStream are the base classes for filtering data. When you
need to process primitive numeric types, use DataInputStream and DataOutputStream
to filter bytes.
*/

/* DataInputStream reads bytes from the stream and converts them into appropriate primitive type
values or strings. DataOutputStream converts primitive-type values or strings into bytes
and outputs the bytes to the stream.
DataInputStream extends FilterInputStream and implements the DataInput interface,
as shown in Figure 17.9. DataOutputStream extends FilterOutputStream and
implements the DataOutput interface, as shown in

<interface> java.io.DataInput :
+readBoolean(): boolean
+readByte(): byte
+readChar(): char
+readFloat(): float
+readDouble(): double
+readInt(): int
+readLong(): long
+readShort(): short
+readLine(): string
+readUTF(): string

<interface> java.io.DataOutput:
+writeBoolean(b: boolean): void
+writeByte(v: int): void
+writeBytes(s: String): void
+writeFloat(v: float): void
+writeDouble(v: double): void
+writeInt(v: int): void
+writeLong(v: long): void
+writeShort(v: short): void
+writeUTF(String s): void
*/

/* A Unicode character consists of two bytes. The writeChar(char c) method writes the Unicode
of character c to the output. The writeChars(String s) method writes the Unicode
for each character in the string s to the output. The writeBytes(String s) method writes
the lower byte of the Unicode for each character in the string s to the output. The high byte
of the Unicode is discarded. The writeBytes method is suitable for strings that consist of
ASCII characters, since an ASCII code is stored only in the lower byte of a Unicode. If a string
consists of non-ASCII characters, you have to use the writeChars method to write the string.
The writeUTF(String s) method writes a string using the UTF coding scheme. UTF is
efficient for compressing a string with Unicode characters. For more information on UTF, see
Supplement III.Z, UTF in Java. The readUTF() method reads a string that has been written
using the writeUTF method.
 */
import java.io.*;

public class E17L02 {
    public static void main(String[] args) throws IOException {
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream("temp.dat"))) {
            output.writeUTF("John");
            output.writeDouble(85.5);
            output.writeUTF("Jim");
            output.writeDouble(185.5);
            output.writeUTF("George");
            output.writeDouble(105.25);
        }

        try (DataInputStream input = new DataInputStream(new FileInputStream("temp.dat"))) {
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
            System.out.println(input.readUTF() + " " + input.readDouble());
        }
    }
    
}
