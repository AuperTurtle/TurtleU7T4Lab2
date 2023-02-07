
import java.util.ArrayList;

public class GroceryStore
{
    /** An array of products normally stocked at the grocery store
     *  Guaranteed not to be null and to contain only non-null entries
     */
    private Product[] productsStocked;

    public GroceryStore(Product[] initialInventory)
    {
        productsStocked = initialInventory;
    }

    /** Returns an ArrayList of indices for Product elements in the
     *  productsStocked array that need to be reordered, as described in part (a)
     *  Precondition: min > 0 */
    public ArrayList<Integer> getReorderList(int min) {
        ArrayList<Integer> tempArray = new ArrayList<Integer>();
        for (int i = 0; i < productsStocked.length; i++) {
            if (productsStocked[i].getQuantity() <= min) {
                tempArray.add(i);
            }
        }
        return tempArray;
    }

    /** Returns true if all products named in shoppingList are available for purchase
     *  and returns false otherwise, as described in part (b)
     *  Precondition: The products named in shoppingList are found exactly once
     *  in the productsStocked array.
     */
    public boolean checkAvailability(ArrayList<String> shoppingList) {
        boolean temp = false;
        int findItem = -1;
        for (int i = 0; i < shoppingList.size() ; i++) {
            temp = false;
            for (int z = 0; z < productsStocked.length; z++) {
                if ((productsStocked[z].getName()).equals(shoppingList.get(i))) {
                    findItem = z;
                }
            }
            if (productsStocked[findItem].getQuantity() >= 1) {
                temp = true;
            }
            if (!temp) {
                return false;
            }
        }
        return true;
    }
}