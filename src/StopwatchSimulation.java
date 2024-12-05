import java.util.Scanner;

public class StopwatchSimulation {
	 private long startTime;
	    private long endTime;
	    private boolean isRunning;
	    public void start() {
	        if (!isRunning) {
	            startTime = System.currentTimeMillis();
	            isRunning = true;
	            System.out.println("Stopwatch started.");
	        } else {
	            System.out.println("Stopwatch is already running.");
	        }
	    }
	    public void stop() {
	        if (isRunning) {
	            endTime = System.currentTimeMillis();
	            isRunning = false;
	            System.out.println("Stopwatch stopped.");
	        } else {
	            System.out.println("Stopwatch is not running.");
	        }
	    }
	    public long getElapsedTime() {
	        if (isRunning) {
	            return System.currentTimeMillis() - startTime;
	        } else {
	            return endTime - startTime;
	        }
	    }
	    public void displayElapsedTime() {
	        long elapsedMillis = getElapsedTime();
	        
	        long hours = elapsedMillis / 3600000;
	        long minutes = (elapsedMillis % 3600000) / 60000;
	        long seconds = (elapsedMillis % 60000) / 1000;
	        long millis = elapsedMillis % 1000;

	        System.out.printf("Elapsed Time: %02d:%02d:%02d.%03d%n", 
	                          hours, minutes, seconds, millis);
	    }
	public static void main(String[] args) {
		StopwatchSimulation stopwatch = new StopwatchSimulation();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStopwatch");
            System.out.println("1. Start Stopwatch");
            System.out.println("2. Stop Stopwatch");
            System.out.println("3. Get Elapsed Time");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    stopwatch.start();
                    break;
                case 2:
                    stopwatch.stop();
                    stopwatch.displayElapsedTime();
                    break;
                case 3:
                    if (!stopwatch.isRunning) {
                        System.out.println("Stopwatch is not running.");
                    } else {
                        System.out.println("Current Elapsed Time:");
                        stopwatch.displayElapsedTime();
                    }
                    break;
                case 4:
                    System.out.println("Exiting Stopwatch Program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }		
	}
}
