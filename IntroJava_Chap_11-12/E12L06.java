// Test Exception class's methods
public class E12L06{
    public static void main(String[] args){
        try {
            System.out.println(sum (new int[] {1, 2, 3, 4, 5}));
        }
        catch (Exception ex) {
            ex.printStackTrace();
            
            // this prints only the message but not the exception object
            System.out.println("\n" + ex.getMessage()); 
            
            // this prints the first line of printStackTrace() including the exception object + the message
            System.out.println("\n" + ex.toString()); 
            
            StackTraceElement[] traceElements = ex.getStackTrace();
            for (int i = 0; i < traceElements.length; i++) {
                //trace elements - method name
                System.out.println("method " + traceElements[i].getMethodName());
                //trace elements - class name: showing E12L06
                System.out.println(traceElements[i].getClassName());
                //trace elements - line number
                System.out.println(traceElements[i].getLineNumber());
            }
        }
    }

    public static int sum(int[] list) {
        int sum = 0;
        //Place a mistake in index out of bounds
        for (int i = 0; i < list.length; i++) {
            sum += list[i];
        }
        return sum;
    }
}
