import java.util.*;
public class Person {
    String name;
    int age;
    Scanner sc=new Scanner(System.in);

    Person(){}
    
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void getDetails(){
        System.out.println("Enter name, age and sign of this Candidate");
        name = sc.nextLine();
        age = sc.nextInt();
        sc.nextLine();
    }

    public void display(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
