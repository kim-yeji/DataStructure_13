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
				adjust(this.newData,i,j); //j:���Ľ����ذ͵��� ���� ���� �������� lastLeaf����
			}
			swap(1,j); //ù��°�� �ִ� ��带 �ڷ� ���Ľ����ش�
		}
		for(int j=0;j<size;j++) {
			a[j]=this.newData[j+1]; //0�� �ε����� �����ϰ� 1���� �ֱ� ���ؼ�
		}
		System.out.println();
	}
	
	//root -> index
	//lastLeaf(=n) -> index
	//child -> index
	//rootKey -> ��Ʈ�� value
	public void adjust(int[] newData, int root, int lastLeaf) {
		int child, rootkey;
		rootkey = newData[root];
		child = 2*root;
		
		while(child <= lastLeaf) { 
			//���ʰ� �������� ���Ѵ�.
			int idx = child; //child�� �ε��� ���� ����
			int bigger = newData[child]; //�ϴ� ���� �ڽĳ�带 �־ �ʱ�ȭ
			if(child+1 <= lastLeaf) { //child+1�� lastLeaf���� ũ�� ������ �ڽĳ�尡 ���ٴ� ��
				if(newData[child] > newData[child+1]) { //���� �������߿� �� ū ���� bigger�� �ִ´�
					bigger = newData[child];
					idx = child;
				}else{
					bigger = newData[child+1];
					idx = child+1; 
				}
			}			
			//root�� child�� ���Ѵ�.
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
