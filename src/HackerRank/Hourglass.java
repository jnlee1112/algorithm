package HackerRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Hourglass {
	
	/*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
    // Write your code here
    	int maxSum = -9 * 7;
    	int len = arr.size();
    	int[][] sums = new int[len-2][len-2];
    	int sum = 0;
    	
    	for(int i = 0; i < len - 2; i++) {
    		for(int j = 0; j < len - 2; j++) {
    			sum = 0;
    			// 윗 줄
    			sum += arr.get(i).get(j)
    				 + arr.get(i).get(j+1)
    				 + arr.get(i).get(j+2);
    			// 중간 줄
    			sum += arr.get(i+1).get(j+1);
    			// 마지막 줄
    			sum += arr.get(i+2).get(j)
    				 + arr.get(i+2).get(j+1)
    				 + arr.get(i+2).get(j+2);
    			
    			sums[i][j] = sum;

    			if(sum > maxSum) {
    				maxSum = sum;
    			}
    		}
    	}
    	
    	return maxSum;
    }

	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        int result = Hourglass.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
	}

}
