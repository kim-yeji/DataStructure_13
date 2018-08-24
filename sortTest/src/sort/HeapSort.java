package sort;

public class HeapSort {
	int[] newData;
	
	public void sort(int[] a, int size) {
		this.newData=new int[size+1];
		this.newData[0]=0;
		for(int i=0;i<size;i++) {
			this.newData[i+1]=a[i];
		}
		int i;
		for(int j=size;j>0;j--) {
			for(i=size/2;i>0;i--) { 
				adjust(this.newData,i,j); //j:정렬시켜준것들을 빼고 제일 마지막을 lastLeaf노드로
			}
			swap(1,j); //첫번째에 있는 노드를 뒤로 정렬시켜준다
		}
		for(int j=0;j<size;j++) {
			a[j]=this.newData[j+1]; //0번 인덱스를 제외하고 1부터 넣기 위해서
		}
		System.out.println();
	}
	
	//root -> index
	//lastLeaf(=n) -> index
	//child -> index
	//rootKey -> 루트의 value
	public void adjust(int[] newData, int root, int lastLeaf) {
		int child, rootkey;
		rootkey = newData[root];
		child = 2*root;
		
		while(child <= lastLeaf) { 
			//왼쪽과 오른쪽을 비교한다.
			int idx = child; //child의 인덱스 값을 저장
			int bigger = newData[child]; //일단 왼쪽 자식노드를 넣어서 초기화
			if(child+1 <= lastLeaf) { //child+1이 lastLeaf보다 크면 오른쪽 자식노드가 없다는 것
				if(newData[child] > newData[child+1]) { //왼쪽 오른쪽중에 더 큰 값을 bigger에 넣는다
					bigger = newData[child];
					idx = child;
				}else{
					bigger = newData[child+1];
					idx = child+1; 
				}
			}			
			//root와 child를 비교한다.
			if(rootkey < bigger) {
				swap(root,idx); 
			}
			child = idx*2;
			root = child/2;
			rootkey = newData[root];
		}
	}
	
	private void swap(int root,int child) {
		int tmp;
		tmp = newData[root];
		newData[root] = newData[child];
		newData[child] = tmp;
	}
}
