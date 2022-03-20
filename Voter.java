import java.util.*;
class Voter extends Person{
    String name;
    int age, id;
    private String vote;

    Voter(){}
    
    Voter(String name,int age, int id){
        super(name, age);
        this.id = id;
    }

    Scanner sc=new Scanner(System.in);

    @Override
    public void getDetails()
    {
        System.out.println("Enter name, age, id of this voter");
        name=sc.nextLine();
        age=sc.nextInt();
        id=sc.nextInt();
    }

    @Override
    public void display()
    {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Id: " + id);
        System.out.println("Vote given to: " + vote);

    }
    public void giveVote(){
        System.out.println("Enter the name of Candidate you want to vote: ");
        sc.nextLine();
        vote = sc.nextLine();
        System.out.println("You voted: "+vote);
    }
    public String Vote()
    {
        return vote;
    }
    public boolean checkEligibility(){
        if(age < 18){
            System.out.println("You are not Eligible to vote");
            return false;
        }
        return true;
    }
    public boolean checkID(int voterID){
        if(id == voterID){
            return true;
        }
        else{
            return false;
        }
    }
}