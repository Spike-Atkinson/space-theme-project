import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.Math;


public class Crew {
    private static final String[] RANKS = new String[] {"Commander", "Pilot", "Payload Commander", "Mission Specialist", "Spaceflight Participant"};
    private String[] nationalities = new String[0];
    private List<Astronaut> crew = new ArrayList<Astronaut>();

    // constructor takes the directory of nationalities file, and saves it to array
    // it then fills the crew list with an an astronaut for each nationality and rank
    Crew(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner nation = new Scanner(file);
        ArrayList<String> arrayList = new ArrayList<String>();
        while (nation.hasNext()) {
            String line = nation.nextLine();
            arrayList.add(line);
        }
        nationalities = arrayList.toArray(nationalities);

        for (int r = 0; r < RANKS.length; r++){
            for (int n = 0; n < nationalities.length; n++){
                int age = 30 + (int)(Math.random()*30 ) - (int)(r*1.5);
                crew.add(new Astronaut(nationalities[n], RANKS[r], r, age));
            }
        }
    }
    public void printCrew(){
        System.out.println(crew);
    }

    public void sortCrew(){
        // sort the crew list
        Collections.sort(crew);
    }
    
    public void shuffleCrew(){
        //shuffle the crew list
        Collections.shuffle(crew);
    }

    public Map assembleMissionCrew(){
        // duplicate crew list and create a map for the assembled crew
        List<Astronaut> candidates = new ArrayList<>();
        candidates.addAll(crew);
        TreeMap<String, Astronaut> missionCrew = new TreeMap();

        // for each rank that exists, create a new array, and fill it with astronauts of the current rank
        for(int i = 0; i < RANKS.length;i++){
            List<Astronaut> rankCandidates = new ArrayList<>();
            for (int c = 0; c < candidates.size(); c++) {
                String[] rankSplit = RANKS[i].split(" ");
                String[] candidateSplit = candidates.get(c).toString().split(" ");
                if (candidateSplit[0].contains(rankSplit[0])) {
                    rankCandidates.add(candidates.get(c));
                }
            }
            // choose a random astronaut from the new array for current rank
            int randomIndex = (int) (Math.random() * rankCandidates.size());
            missionCrew.put(RANKS[i], rankCandidates.get(randomIndex));

        }
        // Return the five selected astronauts
        return missionCrew;
    }
}
