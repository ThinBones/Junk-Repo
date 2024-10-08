/**
 * Authors: Kaan Demirer, Jack Pender, Maya Taylor
 * Course:  APCSA 3RD HOUR
 * Date:    Sept 2024
 * Desc:    Creates a consumer curve with default
 *          and specified constructor; defines abstract sort()
 */
public class ConsumerCurve extends AbstractCurve
{
    /**
     * defined abstract default curve
     * of ten points with initial point being
     * (10,1) and linear slope decreasing
     */
    public ConsumerCurve()
    {
        // Initialize with default points
        for (int i = 0; i < 10; i++)
        {
            myCurve.set(i, new Point(10 - i, (double) i + 1.0));
        }
    }

    /**
     * Constructor with parameters length
     * startQuantity, startPrice, x value increment(dx), and
     * y value increment(dy) that can be assigned.
     * Constructs array of points with
     * given values and assigns points to designated slots
     */
    public ConsumerCurve(int n, Point startPoint, int dx, double dy)
    {
        super(n,startPoint,dx,dy);
    }

    /**
     * implements insertion sort
     * sorts arrayList by comparing each element
     * to the one before it. If the quantity is smaller than
     * element before then swaps. Can be modified to sort by price.
     */
    @Override
    public void sort()
    {
        for (int i = 1; i < myCurve.size(); i++)
        {
            Point current = myCurve.get(i);
            int j = i-1;
            while ((j >= 0) && ((current.getQuantity()<myCurve.get(j).getQuantity())))
            {
                myCurve.set(j+1, myCurve.get(j));
                j--;
            }
            myCurve.set(j+1, current);
        }
    }
}
