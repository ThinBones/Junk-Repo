/*
 * @author Braden Samson
 */

public class Producer {
    private ProducerCurve producerCurve;

    public Producer() {
        // creates a consumer curve with a positive slope of 1
        producerCurve = new ProducerCurve();
    }

    public Point respondToBid(Point point) {
        Point quantityPoint = producerCurve.getPointAtQuantity(point.getQuantity());

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
