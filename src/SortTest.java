import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 梦霄
 * @Date: 2021/3/28
 * @Time: 10:05
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class SortTest {
	/**
	 * 随机数组
	 */
	public static Integer[] randomCommon(Integer[]arr, int range) {
		ArrayList<Integer>list=new ArrayList<>();
		Random random=new Random();
		int number;
		for (int i = 0; i < arr.length; i++) {
			number=random.nextInt(range)+1;
			if(!list.contains(number)){
				list.add(number);
			}else {
				i--;
			}
		}
		return list.toArray(arr);
	}

	/**
	 * 主方法
	 * @param args
	 */
		public static void main(String[] args) {
			int length=40;
			Integer[]arr=randomCommon(new Integer[length],length );
			print(arr);
			shellSort(arr);
			System.out.println();
			print(arr);
			System.out.println(binarySearch(arr,30));
	}
	public static void print(Integer[]arr){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if(i<arr.length-1){
				System.out.print(",");
			}
		}
		System.out.println();
	}

	/**
	 * 交换方法
	 * @param left
	 * @param right
	 */
	public static void swap(Integer[]arr, Integer left,Integer right){
		Integer temp=arr[left];
		arr[left]=arr[right];
		arr[right]=temp;
	}

	/**
	 *
	 * @param arr
	 * 冒泡排序
	 */
	public static void bubblingSort(Integer[]arr){
		for (int i = 0; i <arr.length-1 ; i++) {
			for (int j = 0; j < arr.length-i-1; j++) {
				if(arr[j]>arr[j+1]){
					swap(arr,j,j+1 );
				}
			}
		}
	}

	/**
	 *
	 * @param arr
	 * @param low
	 * @param high
	 */
	public static void quickSort(Integer[]arr,int low,int high){
		int start=low;
		int end=high;
		Integer key=arr[start];
		while (end>start){
			//从后往前比较
			while (end>start&&arr[end]>=key)
			{end--;}
				//直到匹配到小于key的值执行交换
				if(arr[end]<=key){
					swap(arr, end,start);
				}
				//然后从前向后比较
			while (end>start&&arr[start]<=key){
				start++;
			}
			//直到匹配到大于key的值执行交换
			if(arr[start]>=key){
				swap(arr,start, end);
			}
			//此时基准值位置已确定，左边比基准值小，右边比基准值大
		}
		//递归左边序列，从第一个索引至基准值索引-1
		if(start>low) {
			quickSort(arr,low ,start-1 );
		}
		//递归右边序列，从基准值索引+1到最后一个位置
		if(end<high){
			quickSort(arr,end+1 , high);
		}
	}
	public static void shellSort(Integer[]arr){
		int dk=arr.length/3+1;
		while (dk!=1){
			shellInsertSort(arr,dk );
			dk=dk/3+1;
		}
		if(dk==1){
			shellInsertSort(arr,dk );
		}
	}
	public static void shellInsertSort(Integer[]arr,int dk){
		//类似插入排序，插入排序增量是1，这里增量是dk
		for(int i=dk;i<arr.length;i++){
			if(arr[i]<arr[i-dk]){
				int j;
				//x为待插入元素
				int x=arr[i];
				arr[i]=arr[i-dk];
				for(j=i-dk;j>=0&&x<arr[j];j=j-dk){
					arr[j+dk]=arr[j];
				}
				arr[j+dk]=x;
			}
		}
	}
	public static int binarySearch(Integer[]arr,int a){
		int low=0;
		int high=arr.length-1;
		int mid;
		while (low<high){
			//中间位置
			mid=(high-low)/2+low;
			if(arr[mid]==a){
				return arr[mid];
				//向左查找
			}else if(a<arr[mid]){
				high=mid-1;
				//向右查找
			}else if(a>arr[mid]){
				low=mid+1;
			}
		}
		return -1;
	}
}
