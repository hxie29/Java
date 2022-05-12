import java.util.ArrayList;
import java.util.Date;

public class E1106{
    public static void main(String[] args){
        ArrayList<Object> list = new ArrayList<>();
        list.add(new Circle(5));
        list.add(new Date());
        list.add(new Account(101, 5000));

        System.out.println(list.get(0).toString());
        System.out.println(list.get(1).toString());
        System.out.println(list.get(2).toString());

    }
}

//Superclass
class GeometricObject {
    //Data encapsulation
    private String color = "white";
    private boolean filled;
    private Date dateCreated;

    //Constructor
    public GeometricObject(){
        dateCreated = new Date();
    }

    public GeometricObject(String color, boolean filled){
        setColor(color);
        setFilled(filled);
        dateCreated = new Date();
    }

    //Methods
    public String getColor(){
        return color;
    }

    public boolean isFilled(){
        return filled;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setFilled(boolean filled){
        this.filled = filled;
    }

    public Date getDate(){
        return dateCreated;
    }

    public String toString(){
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }
}

//Subclass
class Circle extends GeometricObject{
    //Data fields (all data fields in superclass are inherited)
    private double radius;

    //Constructor
    public Circle(){
    }

    public Circle(double radius){
        setRadius(radius);
    }

    public Circle(double radius, String color, boolean filled){
        //Calling constructor from super class  --> always put on the first line of command
        super(color, filled);
        setRadius(radius);
    }

    //Methods
    public double getRadius(){
        return radius;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }

    public double getPerimeter(){
        return Math.PI * radius * 2;
    }

    public void printCircle(){
        System.out.println("The circle is created " + getDate() + " and the radius is " + radius);
    }

    @Override
    public String toString(){
        return super.toString() + "\nradius is " + radius;
    }

}

//Subclass 
class Rectangle extends GeometricObject {
    //data fields
    private double width = 1;
    private double height = 1;

    // constructor
    public Rectangle() {  
    }

    public Rectangle(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    // method
    public double getWidth(){
        return width;
    }

    public double getHeight(){
        return height;
    }

    public void setWidth(double width){
        this.width = width;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width + height) * 2;
    }
}

class Account {
    //Data fields
    private int id ;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated = new Date();

    // Constructor
    public Account(){

    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getAccountID() {
        return id;
    }

    public double getAccountBlance() {
        return balance;
    }

    public double getInterestRate() {
        return annualInterestRate;
    }

    public void changeAccountId(int id) {
        this.id = id;
    }

    public void changeAccountBalance(double balance) {
        this.balance = balance;
    }

    public static void changeInterestRate(double interestRate) {
        annualInterestRate = interestRate;
    }

    public String getDate() {
        return dateCreated.toString();
    }

    public double getMonthlyInterest() {
        return balance * annualInterestRate / 100 / 12;
    }

    public void withdraw(double amount){
        balance -= amount;
        System.out.println("Withdraw fund: $" + amount);
    }

    public void deposit(double amount) {
        balance +=amount;
        System.out.println("Deposit fund: $" + amount);
    }

    @Override
    public String toString(){
        return "\nAccount overview:\nID: " + id + "\nBalance: $" + balance + "\nDate created: " + dateCreated;
    }
   
}
