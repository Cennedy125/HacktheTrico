import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class bettermain {

	static String [] options = {"No, I'd like to continue. " , "Yes,  I feel better! Exit"};
	public static MyArrayList<Feelings> feelsList;
	public static ArrayList <String> emotionList;
	public static void readData(){
	Scanner input;
	String inFileName= "Data/TestDataMawr.csv";
	String line;
	String line1;
	try{
		feelsList = new MyArrayList<Feelings>();
		emotionList = new ArrayList<String>();
		input= new Scanner(new File(inFileName));
		line1= input.nextLine();
		while (input.hasNextLine()){
		line= input.nextLine(); //.toUpperCase();
		String pieces[] = line.split(",");
		
		//0 is feeling, 1 is solution, 2 is quote
		emotionList.add(pieces[0]);
		Feelings f= new Feelings(pieces[0].toUpperCase(), pieces[1], pieces[2]);
		feelsList.add(f);
		}//while
		input.close();
	}//try
	catch (IOException e){
		System.out.println("Error in opening the file:");
		e.printStackTrace();
		System.exit(1);
	}
}//end readData()

   
	public static int search(MyArrayList<Feelings> p, String userInput){
		for(int i=0; i<feelsList.size(); i++){
			
			if(p.get(i).equals(userInput)){
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int response = 0;
     Scanner console = new Scanner(System.in);
     readData();
     do{
    	 try{
    		 String [] elist={"sad", "happy", "lonely", "stressed", "tired",  "bored"};
    		 
    		 String dataStr = (String)JOptionPane.showInputDialog(null,
    		 "How do you feel?", "Input",
    		 JOptionPane.INFORMATION_MESSAGE, null,
    		 elist, elist[0]);
    		 
    		 if (dataStr !=null){
    		 int results = search(feelsList, dataStr);
    		 if(results==-1){
    			 System.out.println("I'm sorry. I'm not familiar with that emotion. Try again.\n");
    		 }
    		 else{
    			 JOptionPane.showMessageDialog(null, feelsList.get(results));
    		 }
    		 //response
    		 response = JOptionPane.showOptionDialog(null,"Do you feel better?", null,
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null, //do not use custom icon
						options, //the titles of buttons
						options [0]); //default button title
    		 }
    	 } 
    		
    		 catch(Exception e){
    			 System.out.println("Oops! Something went wrong. Try again!");
    		 }
    		 
    	
    	 } 
     //while(response);
    	 while(response==0);
     
    
	}//main()

}//bettermain

