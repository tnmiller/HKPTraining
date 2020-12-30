import java.io.*;
import java.util.*;
import javax.swing.*;

public class Day12Work {
    public static void ScannerVideo() {
        int firstNumber;
        int secondNumber;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the first number: ");
        firstNumber = keyboard.nextInt();

        System.out.println("Please enter the second number: ");
        secondNumber = keyboard.nextInt();

        double average = (firstNumber + secondNumber) / 2.0;

        System.out.println("The average is "+average);
        keyboard.close();
    }

    public static void JOptionPlaneVideo(){
        String name;
        String surname;

        name = JOptionPane.showInputDialog("Please enter your name ");
        surname = JOptionPane.showInputDialog("Please enter your surname");
        JOptionPane.showMessageDialog(null, name+ " "+surname);

        int firstNumber = Integer.parseInt(JOptionPane.showInputDialog("Please enter first number"));
        int secondNumber = Integer.parseInt(JOptionPane.showInputDialog("Please enter second number"));

        JOptionPane.showMessageDialog(null, "Average: "+(firstNumber+secondNumber)/2.0);
    }

    public static void SwitchStatments(){
        int number;

        String input = JOptionPane.showInputDialog("Please enter 1, 2, or 3: ");
        number = Integer.parseInt(input);

        switch(number){
            case 1:
                JOptionPane.showMessageDialog(null, "You entered 1!");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "You entered 2!");
                break;  
            case 3:
                JOptionPane.showMessageDialog(null, "You entered 3!");
                break;  
            default:
                JOptionPane.showMessageDialog(null, "You did not enter 1, 2, or 3.");
        }
    }

    public static void RunningTotals(){
        int days;
        double sales;
        double totalSales = 0.0; //running total

        String input = JOptionPane.showInputDialog("For how many days do you have sales?");

        days = Integer.parseInt(input);

        for(int count = 1; count<=days; count++){
            input=JOptionPane.showInputDialog("Enter sales for day "+ count);
            sales = Double.parseDouble(input);
            totalSales+=sales;
        }
        JOptionPane.showMessageDialog(null, "The total sales are: $"+totalSales+" over "+days+" days.");
        System.exit(0);
    }
    public static void SentinelValues(){
        int value;
        int doubleValue;

        String input = JOptionPane.showInputDialog("Please enter a number to double (type 0 to stop)");

        value = Integer.parseInt(input);
        while(value!=0){
            doubleValue = value*2;
            JOptionPane.showMessageDialog(null, value+" doubled is "+doubleValue);
            
            input = JOptionPane.showInputDialog("Please enter a number to double (type 0 to stop)");
            value = Integer.parseInt(input);        
        }
        System.exit(0);
    }


    public static void WritetoFiles() throws Exception{
        PrintWriter output = new PrintWriter("OutputFile.txt");
        output.println("This is line 1");
        output.println("This is line 2");

        output.close();
    }

    public static void ArraysandFiles() throws FileNotFoundException{
        PrintWriter values = new PrintWriter("Values.txt");
        values.println(10);
        values.println(20);
        values.println(30);
        values.println(40);
        values.println(50);
        values.println(60);
        values.println(70);
        values.println(80);
        values.println(90);
        values.println(100);
        values.println(110);

        values.close();

        int [] valuesarr = new int[10];
        int i=0;
        File file = new File("Values.txt");

        if(file.exists()){
            Scanner inputFile = new Scanner(file);
            while(inputFile.hasNext()&&i<valuesarr.length){
                valuesarr[i] = inputFile.nextInt();
                i++;
            }
            inputFile.close();

            for(int value:valuesarr){
                System.out.println(value);
            }
        }
    }

    public static void ArrayLists(){
        ArrayList<String> names = new ArrayList<>(); //basically a vector
        names.add("James"); //index 0
        names.add("Peter"); //index 1
        names.add("John"); //index 2 -> 3
        names.add("Jake"); //index 3 -> 4
        names.add(2,"Paul"); //put Paul at index 2, bumps John and Jake down 1
        names.set(1, "Jim"); //Peter in removed and Jim is put in position 1
        names.remove(0); //removes James

        for(int i=0; i<names.size(); i++){
            System.out.println(names.get(i));
        }
    }

    public static void main(String[] args) {
        //UNCOMMENT WHICHEVER METHOD YOU WANT TO RUN//

        //ScannerVideo();
        //JOptionPlaneVideo();
        //SwitchStatments();
        //RunningTotals();
        //SentinelValues();
        //ArraysandFiles();
        //ArrayLists();
    }
}
