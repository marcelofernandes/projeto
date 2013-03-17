
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Time extends JLabel implements Runnable{

	private int tempoDecorrido;
	
	public int getTempoDecorrido(){
		return this.tempoDecorrido;
	}

	public void setTempoMaximo(int tempoMaximo){
		this.tempoDecorrido = tempoMaximo;
	}
	public void run(){  
		setFont(new Font("Serif", Font.BOLD, 40));
		 while(true){  
			 	if(tempoDecorrido<=5){
			 		setForeground(Color.RED);
			 	}
			 	setText("         Tempo: " + tempoDecorrido);
			 	if(tempoDecorrido == 0){
			 		tempoDecorrido = 0;
			 	}else{
			 		tempoDecorrido--;
			 	}
			try{  
	            Thread.sleep(1000);                                        
	         	}  
	        catch(InterruptedException ie){}     
	      	}        
	   	}    
	     
	}   

	

	