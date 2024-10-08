/**
 * Authors: Jack Pender,Braden Samson, Ian McGinness
 * Date:    Oct, 2024
 * Class:   APCSA
 * Description: Passes point values from a producer
 * and consumer until an equilibrium, oscillation, or
 * out-of-bounds error occurs.
 */

public class Market {
    private static Consumer mConsumer;
    private static Producer mProducer;
    private static boolean  oscillating;
    private static Point    cPoint;
    private static Point    pPoint;
    private static Point    cPoint2;
    private static Point    pPoint2;

    public static void main(String[] args) {
        mConsumer        = new Consumer();
        mProducer        = new Producer();
        Point initialBid = mProducer.initialBid();

        boolean equilibrium = false;
        cPoint  = mConsumer.respondToBid(initialBid);
        cPoint2 = new Point();
        pPoint  = new Point();
        pPoint2 = new Point();

        while(!equilibrium) {
            if(checkOutOfBounds()) {
                System.out.println("Out of bounds error.");
                System.out.println("Closing program.");
                System.exit(0);
            }

            pPoint = mProducer.respondToBid(cPoint2);
            if(pPoint == cPoint2) {
                equilibrium = true;
            }
            cPoint = mConsumer.respondToBid(pPoint);
            if(pPoint == cPoint) {
                equilibrium = true;
            }
            pPoint2 = mProducer.respondToBid(cPoint);
            if(pPoint2 == cPoint) {
                equilibrium = true;
            }
            cPoint2 = mConsumer.respondToBid(pPoint2);
            if(cPoint2 == pPoint2) {
                equilibrium = true;
            }
            if(pPoint == pPoint2 || cPoint == cPoint2) {
                equilibrium = true;
                oscillating = true;
            }
        }

        if(!oscillating) {
            System.out.println("Equilibrium point at: " +
                    pPoint + ".");
        }
        else {
            System.out.println("Oscillation detected, points at: Producer: " +
                    pPoint + " and Consumer: " + cPoint + ".");
        }
    }

    /**
     * Checks if the price or quantity of any of the points are
     * below zero, thus out of bounds
     * @return
     */
    private static boolean checkOutOfBounds() {
        if((pPoint.getQuantity() <= 0 || cPoint.getQuantity() <= 0) ||
                (pPoint.getPrice() <= 0 || cPoint.getPrice() <= 0)) {
            return true;
        }
        return false;
    }
}
