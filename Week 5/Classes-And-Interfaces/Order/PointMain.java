import java.util.Scanner;

public class PointMain
{
    public static Point getPoint(Scanner in)
    {
        return new Point(in.nextDouble(), in.nextDouble());
    }
    
    private static void swap(Order [] items, int a, int b)
    {
        Order tmp;
        tmp = items[a];
        items[a] = items[b];
        items[b] = tmp;
    }
    
    // This method is going to sort a list of items. The only thing it knows about these items is that
    // they implement the Order interface and therefore they have a lessThan method
    public static void sort(Order [] items)
    {
        // Use selection sort
        for(int i = 0; i < items.length - 1; i++)
        {
            // Find the smallest and put it in the current position
            int min = i; // Assume it's the first
            for(int j = i + 1; j < items.length; j++)
                if(items[j].lessThan(items[min]))
                    min = j; // something is lessThan our current min ... so update min
                    
            swap(items, i, min); // Put the smallest in the correct location
        }
    }
    
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Point [] points = new Point[n];
        for(int i = 0; i < n; i++)
            points[i] = getPoint(in);
            
        sort((Order []) points);
        
        // Print out the sorted points
        System.out.println("The sorted points:");
        for(int i = 0; i < n; i++)
            System.out.println(points[i]);
    }
}
