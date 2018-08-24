package sort;

public class Main {

	public static void main(String[] args) {
		int a[] = {66,33,99,55,88,22,44,77};
		int insert[] = new int[8];
		int quick[]=new int[8];
		int bubble[] = new int[8];
		int heap[]=new int[8];
		
		InsertionSort insertionSort=new InsertionSort();
		QuickSort quickSort = new QuickSort();
		BubbleSort bubbleSort=new BubbleSort();
		HeapSort heapSort=new HeapSort();
		
		copyArray(a,insert);
		copyArray(a,quick);
		copyArray(a,bubble);
		copyArray(a,heap);
		
		System.out.print("���� �迭:");
		printArray(a);
		
		insertionSort.sort(insert,insert.length);
		System.out.print("insert sort : ");
		printArray(insert);
		
		quickSort.sort(quick,quick.length);
		System.out.print("quick sort : ");
		printArray(quick);
		
		bubbleSort.sort(bubble,bubble.length);
		System.out.print("bubble sort : ");
		printArray(bubble);

		heapSort.sort(heap,heap.length);
		System.out.print("heap sort : ");
		printArray(heap);
	}
	
	public static void printArray(int a[]) {
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static void copyArray(int a[],int b[]) {
		for(int i=0;i<a.length;i++) {
			b[i]=a[i];
		}
	}

}
