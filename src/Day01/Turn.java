package Day01;

public class Turn {
    private final String dir;
    private final int dist;

    public Turn(String dir, int dist){

        this.dir = dir;
        this.dist = dist;
    }

    public String getDir(){
        return this.dir;
    }

    public int getDist(){
        return this.dist;
    }
}
