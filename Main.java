import java.util.*;
public class Main {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("Choose an option :\n1.Register Person (Options: Candidate, Voter)\n2.Start Voting\n3.Voting Result\n4.Display Candidates detail\n5.Display Voters detail\n6.Exit");
        int id, task = sc.nextInt();
        sc.nextLine();
        String pType;

        List<Candidate> CandidateList = new ArrayList<Candidate>();
        List<Voter> VoterList = new ArrayList<Voter>();
        BallotManager bm = new BallotManager(VoterList, CandidateList);

        while(task != 6){
            switch(task){
                case 1:
                    System.out.println("Enter type of Person(Options: Candidate, Voter)");
                    
                    pType = sc.nextLine();
                    try{
                        if(pType.equals("Candidate")){
                            Candidate Candidate = new Candidate();
                            Candidate.getDetails();
                            CandidateList.add(Candidate);
                        }
                        else if(pType.equals("Voter")){
                            Voter Voter = new Voter();
                            Voter.getDetails();
        
                            if(Voter.checkEligibility()){
                                VoterList.add(Voter);
                            }
                        }
                        else{
                            throw new PersonInvalidException();
                        }
                    }
                    catch(PersonInvalidException e){
                        System.out.println("Person is Invalid : " + e);
                    }
                    break;

                case 2:
                    
                    bm.startVoting();
                    break;

                case 3:
                    // VotingResult vr = new VotingResult(CandidateList);
                    Candidate winner = bm.getWinner();
                    if(winner.name != null){
                        System.out.println("Winner is : "+winner.name);
                    }
                    else{
                        System.out.println("No winner");
                    }
                    break;
                
                case 4:
                    System.out.println("Enter the name of Candidate of whom you want to get details :");
                    
                    String name = sc.nextLine();
                    for(Candidate candidate: CandidateList){
                        if(candidate.name.equals(name)){
                            candidate.display();
                        }
                    }
                    break;
                
                case 5:
                    System.out.println("Enter the id of Voter of whom you want to get details :");
                    id = sc.nextInt();
                    sc.nextLine();
                    for(Voter voter: VoterList){
                        if(voter.checkID(id)){
                            voter.display();
                        }
                    }
                    break;
                
                default:
                    System.out.println("Invalid Case");
                    
            }
            
            System.out.println("Choose an option :\n1.Register Person (Options: Candidate, Voter)\n2.Start Voting\n3.Voting Result\n4.Display Candidates detail\n5.Display Voters detail\n6.Exit");
            task = sc.nextInt();
            sc.nextLine();
        }
        sc.close();
    }
}
