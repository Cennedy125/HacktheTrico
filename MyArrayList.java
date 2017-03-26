import java.util.Arrays;
public class MyArrayList <E> implements ListInterface<E> {
private static final int INC=10; //initial capacity
private E[] theData;
private int size=0;
private int capacity=0;
//constructor
public MyArrayList(){
	capacity=INC;
	theData= (E[]) new Object[capacity];
}

//method for adding to the end of an array
public boolean add(E item){
	if (size==capacity){
		reallocate();
	}
	theData[size] = item;
	size++;
	return true;
}//add
//method for adding an item to a specific place in array
public boolean add(int index, E item){
	if(index<0 || index>size){
		throw new ArrayIndexOutOfBoundsException(index);
	}
	if(size== capacity){ //number of items equals capacity
		reallocate();
	}
	for( int i=size; i>index; i--){
		theData[i]=theData[i-1];
	}
	theData[index]=item;
	size++;
	return true;
}//add#2
public E get(int index){ //get object public Object get(int index)
//public Object get(int index){
	if(index<0 || index>=size){
		throw new ArrayIndexOutOfBoundsException(index);
	}
	return theData[index];
}
public E set(int index, E newValue){
	if (index<0 ||index>= size){
		throw new ArrayIndexOutOfBoundsException(index);
	}
	E oldValue= theData[index];
	theData[index]=newValue;
	return oldValue;
}//set
public E remove(int index){
	if (index<0 || index>=size){ //check if it an valid index
		throw new ArrayIndexOutOfBoundsException(index);
	}
	E returnValue= theData[index];
	for(int i=index+1; i<size; i++){
		theData[i-1]= theData[i]; //putting everything from a given index one back
	}
	size--;
	return returnValue;
}
public boolean isEmpty(){
	return size==0;
}//isEmpty
public void clear(){
	size=0;
}
public boolean contains (E item){
	for(int i=0; i<theData.length; i++){
		
		if(item.equals(theData[i])){
			return true;
		}
		
	}
	return false;
}
public int size(){
	return  size;//theData.length;
}
private void reallocate(){
	capacity= 2*capacity;
	theData=Arrays.copyOf(theData, capacity);
}
}



