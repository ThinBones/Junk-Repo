/**
 * Names:      	Kaan Demirer
 * 				Jackson Pender
 *      		Maya Taylor
 * Date:        9SEPT2024
 * Course:      APCSA 3RD HOUR
 * Description: ProducerCurve class creates array
 * 				of linear points. This class can
 * 				add, remove, or search for points.
 */

public class ProducerCurve extends AbstractCurve
{
    /**
     * defines abstract default curve
     * of ten points with initial point being
     * (1,10) and linear slope increasing
     */
    public ProducerCurve() {
        super();
    }

    /**
     * Constructor with parameters length
     * startQuantity, startPrice, dx, and dy that can
     * be assigned. Constructs array of points with
     * given values and assigns points to designated slots
     */
    public ProducerCurve(int n, Point startPoint, int dx, double dy) {
        super(n,startPoint,dx,dy);
    }

    /**
     * implements selection sort
     * organizes arrayList by repeatedly selecting smallest
     * quantity element from unsorted selection and then
     * swapping with first unsorted element. Can be modified
     * to sort by price.
     */
    @Override
    public void sort()
    {
        for(int i=0; i<myCurve.size()-1; i++)
        {
            int minIndex = i;
            for(int j = i+1;j<myCurve.size();j++)
            {
                if(myCurve.get(j).getQuantity()<myCurve.get(minIndex).getQuantity())
                {
                    minIndex = j;
                }
            }
            Point temp = myCurve.get(minIndex);
            myCurve.set(minIndex, myCurve.get(i));
            myCurve.set(i, temp);
        }
    }
}

