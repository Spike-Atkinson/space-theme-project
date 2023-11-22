public class Astronaut implements Comparable<Astronaut>{
    private String nationality;
    private String rank;
    private int rankNum;
    private int age;

    Astronaut(String nationality, String rank, int rankNum, int age){
        this.nationality = nationality;
        this.rank = rank;
        this.rankNum = rankNum;
        this.age = age;
    }
    @Override
    public String toString(){
        return rank + " (" + nationality + ", " + age + ")";
    }

    //Implement Comparable for the datatype Astronaut and override the compareTo() method.
    // Sorting should be according to rankNum, nationality and finally age (all in ascending order).
    @Override
    public int compareTo(Astronaut previous) {
        int result = 0;
        //sort by rank num first, then nationality
        if (this.rankNum < previous.rankNum){
            result = -1;
        }
        else if (this.rankNum > previous.rankNum){
            result = 1;
        }
        if (result == 0){
            int len = 0;
            //get the length of the shortest nationality
            if (this.nationality.length() < previous.nationality.length()){
                len = this.nationality.length();
            }
            else {
                len = previous.nationality.length();
            }
            //for each letter in it, compare letters
            for (int i = 0; i < len; i++){
                if ((int)this.nationality.charAt(i) == (int)previous.nationality.charAt(i)){
                    continue;
                }
                else if ((int)this.nationality.charAt(i) < (int)previous.nationality.charAt(i)){
                    result = - 1;
                    break;
                }
                else if ((int)this.nationality.charAt(i) > (int)previous.nationality.charAt(i)){
                    result = 1;
                    break;
                }
            }
            // finally sort by age
            if (result == 0){
                if (this.age < previous.age){
                    result = -1;
                }
                else if (this.age > previous.age){
                    result = 1;
                }
            }
        }
        return result;
    }

    //  override the equals method to return true if rank, nationality and age are identical.
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass()) {
            final Astronaut other = (Astronaut) obj;
            if ((this.rankNum == other.rankNum) && (this.nationality == other.nationality) && (this.age == other.age)) {
                return true;
            }
        }
        return false;
    }
}
