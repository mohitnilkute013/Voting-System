import java.util.*;
public class BallotManager {

    List<Voter> VoterList;
    List<Candidate> CandidateList;
    Scanner sc=new Scanner(System.in);
    int id;

    BallotManager(List<Voter> VoterList, List<Candidate> CandidateList){
        this.VoterList = VoterList;
        this.CandidateList = CandidateList;
    }

    public void startVoting(){
        System.out.println("Voting Started: Enter Voters id and give vote.");
        while(true){
            System.out.println("Enter your id: (And -1 to exit)");
            id = sc.nextInt();

            if(id == -1){
                break;
            }
            for(Voter voter: VoterList){
                if(voter.checkID(id)){
                    System.out.println("Your name is "+voter.name);

                    System.out.println("Candidate's available are: ");
                    for(Candidate candidate: CandidateList){
                        System.out.println(candidate.name);
                    }
                    voter.giveVote();
                    for(Candidate candidate: CandidateList){
                        if(candidate.name.equals(voter.Vote())){
                            candidate.incrementVote();
                        }
                    }
                }
            }

        }
    }

    public Candidate getWinner(){
        int maxVote = 0;
        Candidate winner = new Candidate();
        for(Candidate candidate : CandidateList){
            if(candidate.getVotes() > maxVote){
                maxVote = candidate.getVotes();
                winner = candidate;
            }
        }
        return winner;
    }
}
