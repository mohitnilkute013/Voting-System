import java.util.*;
public class Candidate extends Person{
    
    String name,sign;
    int age;
    private int noOfVotes = 0;

    Candidate(){
        noOfVotes = 0;
    }

    Candidate(String name, int age, String sign){
        super(name, age);
        this.sign = sign;
        noOfVotes = 0;
    }

    Scanner sc=new Scanner(System.in);
    
    @Override
    public void getDetails()
    {
        System.out.println("Enter name, age and sign of this Candidate");
        name = sc.nextLine();
        age = sc.nextInt();
        sc.nextLine();
        sign = sc.nextLine();
    }

    @Override
    public void display()
    {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Sign: " + sign);
        System.out.println("No of Votes got: " + noOfVotes);

    }
    
    public void incrementVote(){
        noOfVotes++;
    }
    public int getVotes(){
        return noOfVotes;
    }
}
