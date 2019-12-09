package framework;

public class TimeElapsedStopStrategy implements IStopStrategy {

    private long algorithmEndTime;

   public TimeElapsedStopStrategy(long algorithmTime){
       this.algorithmEndTime=algorithmTime + System.currentTimeMillis();
   }

    public boolean isAlgorithmWorking() {
        return ( System.currentTimeMillis() < algorithmEndTime );
    }
}
