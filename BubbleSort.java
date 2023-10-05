package codeWithMosh;
	
public class BubbleSort {
		public void sort(int[] arr) {
			for(var i = 0; i<arr.length; i++)
				for(var j = 1; j<arr.length; j++)
					if(arr[j-1]>arr[j])
						swap(arr, j, j-1);
						
		}
		
		private void swap(int[] arr, int index1, int index2) {
			var temp = arr[index1];
			arr[index1]=arr[index2];
			arr[index2]=temp;
		}
}
