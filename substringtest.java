//Author Peter Adamson

import java.util.Arrays;

public class substringtest
{	
	//main class
	public static void main(String[] args)
	{
		int arr[] = {2, 4, 22, 19,-48, -5, 20, 40};	//test array
		int[] max = OPT(arr);				//call the algorithm
		if(max != null)					//the algorithm has returned a substring
		{
			//print out the substring
			System.out.println("max substring is:");
			for(int i = 0; i < max.length; i++)
			{
				System.out.println(max[i]);
			}
		}
		else						//the algorithm has not returned a substring, so the maximum is 0
		{
			System.out.println("max substring is 0 (the empty string)");
		}
	}

	//finds the substring that results in the maximum sum of a given array
	//maintains two maximum sums (one for the current and one for the most recent or previous sum
	//maintains three indexes: one for the current start index of the maximum substring
	//			one for the start index of the temporary maximum substring
	//			one for the end index of the maximum substring
	public static int[] OPT(int[] arr)
	{
    		int startIn1 = 0;	//keeps track of the start index of the current max substring
    		int startIn2 = 0;	//keeps track of the start index of the most recent max substring (temp index)
    		int endIn = -1;		//keeps track of teh end index of the current max substring
		int maxStart = 0;	//keeps track of the most recent max sum (not current)
    		int maxEnd = 0;		//keeps track of the current max sum

		//loops through the given array
    		for(int i = 0; i < arr.length; i++)
		{

			if(maxEnd <= (maxEnd + arr[i]))	//adding the next value increases our substring sum
			{
				maxEnd = maxEnd + arr[i];	//add the next value to our substring sum
			}

			else				//adding the next value does not increase our substring sum
			{
				maxEnd = 0;		//reset our current max sum
				startIn2 = i + 1;	//set our temp index to the next element, ready to go again
			}

      			if(maxEnd > maxStart) 		//we have increased our substring sum
			{
        			startIn1 = startIn2;	//set our start index to the temp index
				maxStart = maxEnd;	//store the new current max as the most recent
        			endIn = i;		//set our end index to the current position
      			}
   		 }

    		if(startIn1 <= endIn) 			//we have the maximum substring
		{
			//retrieve the relevant substring and return it as an array of it's own
			int store[] = new int[endIn - startIn1 + 1];
			int count = 0;
			for(int i = startIn1; i <= endIn; i++)
			{
				store[count] = arr[i];
				count = count + 1;
			}
			return store;
   		}
		else					//the indexes have remained unchanged
		{
    			return null;			//our maximum substring is the empty string
		}
	}
}
