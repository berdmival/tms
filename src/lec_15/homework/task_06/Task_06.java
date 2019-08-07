package lec_15.homework.task_06;

/* Есть два отсортированных массива, необходимо самым оптимальным способом сделать из них один и тоже отсортированный
 * [1,4,5]
 * [0,2,3]
 */

public class Task_06
{
	public static void main(String[] args)
	{
		int[] firstArray = {1, 4, 5};
		int[] secondArray = {0, 2, 3};

        System.out.print("First array: [");
        for ( int element : firstArray
             ) {
            System.out.print(element + ", ");
        }
        System.out.println("]");

        System.out.print("Second array: [");
        for ( int element : secondArray
                ) {
            System.out.print(element + ", ");
        }
        System.out.println("]");
		
		int[] resultArray = mergeArrays(firstArray, secondArray);

        System.out.print("Result of merging arrays: [");
        for ( int element : resultArray
                ) {
            System.out.print(element + ", ");
        }
        System.out.println("]");
	}
	
	static int[] mergeArrays(int[] arrayOne,int[] arrayTwo)
    {
        int totalArraysLength = arrayOne.length + arrayTwo.length;
        int[] accumulatorArray = new int[totalArraysLength];
        int indexForArrayOne = 0;
		int indexForArrayTwo = 0;
		int indexForAccumulatorArray = 0;
		
        while((indexForArrayOne!=arrayOne.length) && (indexForArrayTwo!=arrayTwo.length)){
            if(arrayOne[indexForArrayOne]<=arrayTwo[indexForArrayTwo])
            {
                accumulatorArray[indexForAccumulatorArray++]=arrayOne[indexForArrayOne++];
            }
            else
            {
                accumulatorArray[indexForAccumulatorArray++]=arrayTwo[indexForArrayTwo++];
            }
        }
		
        while(indexForArrayTwo!=arrayTwo.length)
        {
            accumulatorArray[indexForAccumulatorArray++]=arrayTwo[indexForArrayTwo++];
        }
        while(indexForArrayOne!=arrayOne.length)
        {
            accumulatorArray[indexForAccumulatorArray++]=arrayOne[indexForArrayOne++];
        }
		
        return accumulatorArray;
    }
}
