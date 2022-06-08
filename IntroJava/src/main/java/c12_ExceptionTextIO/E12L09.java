package c12_ExceptionTextIO;

// Chained Exceptions demo
public class E12L09 {
    public static void main(String[] args){
        try {
            method1();
        }
        catch (Exception ex) {
            //here catches the exception thrown by method1
            ex.printStackTrace();
        }
    }

    public static void method1() throws Exception {
        try {
            method2(); // this method does nothing except throwing an exception for following code to catch 
        }
        catch (Exception ex){
            // here ex is the exception thrown by method2()
            // print (..., ex) also displays cause of the exception (method2)
            //if (,ex) not included, only displays exception f
            throw new Exception ("New info from method1", ex); 
        }
    }

    public static void method2() throws Exception{
        throw new Exception("New info from method2");
    }
}
