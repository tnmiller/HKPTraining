public class Day2 {
    public static int[] searchRange(int[] arr, int target) {
        int[] ans = {-1,-1};
        for(int i=0; i<arr.length; i++){
            if(arr[i]>target){ //since the array is ordered, if the array number is greater than the target number then the target number isn't in the array
                break;
            }
            else if(arr[i]<target){ //if the array number is less than the target number, keep going through the array
                continue;
            }
            else{ //the number must equal the target number
                ans[0]=i; //changes the values of the array to be returned
                ans[1]=i; //if there is only 1 instance
                for(int j=i+1; j<arr.length; j++){ //finds the rest of the instances
                    if(arr[i]!=arr[j]){ //stops once there are no more instances of the target number
                        ans[1]=j-1; 
                        break;
                    }
                }
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) { //to test the function
        int[] nums = {5,7,7,8,8,10}; //example array
        int[] x = searchRange(nums, 8); //call the function
        for(int item : x){ //print out the array created
            System.out.println(item);
        }
    }
}
