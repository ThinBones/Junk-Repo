/*
 * @author Braden Samson
 */

public class Consumer {
    private ConsumerCurve consumerCurve;

    public Consumer() {
        // creates a consumer curve with a positive slope of 1
        consumerCurve = new ConsumerCurve();
    }

    public Point respondToBid(Point point) {
        Point quantityPoint = consumerCurve.getPointAtQuantity(point.getQuantity());

        // point is on curve
        if (quantityPoint != null) {
            if (point.getQuantity() >= quantityPoint.getQuantity() && point.getPrice() <= quantityPoint.getPrice()) {
                return point;
            }

            if (point.getQuantity() >= quantityPoint.getQuantity() && point.getPrice() >= quantityPoint.getPrice()) {
                return quantityPoint;
            }
        }

        return null;
    }
}
