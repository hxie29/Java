
public class E0425 {
    public static void main(String[] args) {
        int n1 = (int)(Math.random() * 26);
        int n2 = (int)(Math.random() * 26);
        int n3 = (int)(Math.random() * 26);
        String plate = (char)(n1 + 'A') + "";
        plate += (char)(n2 + 'A');
        plate += (char)(n3 + 'A'); 
        plate += (int)(Math.random()*10) + "";
        plate += (int)(Math.random()*10) + "";
        plate += (int)(Math.random()*10) + "";
        plate += (int)(Math.random()*10) + "";
        plate += (int)(Math.random()*10) + "";
        System.out.println(plate);
    }
}
