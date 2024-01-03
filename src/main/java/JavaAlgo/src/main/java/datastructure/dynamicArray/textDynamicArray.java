package JavaAlgo.src.main.java.datastructure.dynamicArray;

import org.junit.Assert;
import org.junit.Test;
public class textDynamicArray {
    @Test
    public void text1() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.addLast(5);
        dynamicArray.addLast(6);
        dynamicArray.forEach(System.out::println);
        dynamicArray.foreach(System.out::println);

        System.out.println("----------------------");
        int removed = dynamicArray.remove(2);
        Assert.assertEquals(3,removed);
    }


}
