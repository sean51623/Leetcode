import java.util.*;
public class LargestRectHist {
	public static void main(String[] args) {
		//System.out.println(largestRectangleArea(new int[]{1,1}));
		//System.out.println(largestRectangleArea(new int[]{1,2,3,4}));
		//System.out.println(largestRectangleArea(new int[]{0,0}));
		//System.out.println(largestRectangleArea(new int[]{4,2}));
		//System.out.println(largestRectangleArea(new int[]{2,0,2,0,2}));
		//System.out.println(largestRectangleArea(new int[]{1,2,3,4,5,4,3,2,1}));
		System.out.println(largestRectangleArea(new int[]{5,4,4,6,3,2,9,5,4,8,1,0,0,4,7,2}));
	}
	
	public static int largestRectangleArea(int[] height) {
		if (height==null) return 0;//Should throw exception
		if (height.length==0) return 0;
		if (height.length==1) return height[0];

		Stack<Integer> stk= new Stack<Integer>();
		int maxarea = 0;
		int top = 0;
		stk.push(0);
		
		for (int i = 1 ; i < height.length ; i++) {
			if (stk.isEmpty() || height[i]>=height[stk.peek()]) stk.push(i);
			else {
				while(!stk.isEmpty() && height[i] <= height[stk.peek()]) {
					top = stk.pop();
					maxarea = Math.max(maxarea, height[top]*(stk.isEmpty()?i:i-1-stk.peek()));
					//System.out.println(top+"  "+maxarea);
				}
				stk.push(i);
			}
		}
		while(!stk.isEmpty()){
			top = stk.pop();
			maxarea = Math.max(maxarea, height[top]*(stk.isEmpty()?height.length:height.length-1-stk.peek()));
			//System.out.println(top+"  "+maxarea);
		}
		return maxarea;
	}
	
	/*
    public static int largestRectangleArea(int[] height) {
		if (height==null) return 0;//Should throw exception
		if (height.length==0) return 0;

		Stack<Integer> index= new Stack<Integer>();
		index.push(-1);
		int max=0;

		for  (int i=0;i<height.length;i++){
				//Start calculate the max value
			while (index.peek()>-1)
				if (height[index.peek()]>height[i]){
					int top=index.pop();                    
					max=Math.max(max,height[top]*(i-1-index.peek()));  
				}
				else break;
			index.push(i);
		}
		while(index.peek()!=-1){
			int top=index.pop();
			max=Math.max(max,height[top]*(height.length-1-index.peek()));
		}        
		return max;
	}
	*/
	
	/*
	public static int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
	*/
}