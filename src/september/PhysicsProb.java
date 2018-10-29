package september;
//Hassan Farooq
//APCS P.5
//Physics position homework
//Prints out position data based on initial values in a given time period

public class PhysicsProb {
    public static void main(String args[]) {
        int initialPosition = -3; //in m
        int initialVelocity = -5; //in m/s
        double acceleration = 2; //in m/s/s
        int maxTime = 5000; //in milliseconds

        tableOutline(true);

        findValues(initialPosition, initialVelocity, acceleration, maxTime);

        tableOutline(false);
    }

    public static void findValues (int initialPosition, int initialVelocity, double acceleration, int maxTime) {
        double currentTime;

        for (int timeMilliseconds = 0; timeMilliseconds <= maxTime; timeMilliseconds += 200)
        {
            currentTime = timeMilliseconds / 1000.0;
            double position = position(acceleration, currentTime, initialVelocity, initialPosition);
            position = ((int)(position * 1000)) / 1000.0; //rounds to 3 digits after decimal
            System.out.println(currentTime + "     | " + position);
        }
    }

    public static void tableOutline (boolean top) {
        if (top) {
            System.out.println("_____________________");
            System.out.println("--PHYSICS POSITION--");
            System.out.println("TIME(S) | POSITION(M)");
        }
        else {
            System.out.println("_____________________");
        }
    }

    public static double position (double accel, double sec, double iVel, double iPos) {
        double nPosition = (0.5 * accel * Math.pow(sec, 2)) + (iVel * sec) + (iPos);

        return nPosition;
    }
}
