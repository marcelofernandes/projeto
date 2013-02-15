package br.com.ufpb.projetoPoo3a;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Time extends JPanel implements Runnable{
	public static void main(String []args){
		new Thread(new Time()).start();
			
	}
	
	
	private int tempoDecorrido = 60;
	JFrame frame; 
		
	public Time(){
		int largura = Toolkit.getDefaultToolkit().getScreenResolution();  
		int altura = Toolkit.getDefaultToolkit().getScreenResolution(); 
		this.frame = new JFrame();
		frame.add(this);
		frame.setSize(altura,largura);
		frame.setResizable(false);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public void paintComponent(Graphics g){ 
		  super.paintComponent(g);
	      g.setFont(new Font("Arial", Font.ITALIC, 30));  
	      g.drawString(""+tempoDecorrido , 10, 40);  
	      tempoDecorrido--; //diminui o tempo decorrido
	   }  
	     
	 public void run(){  
	                    
	      while(true){  
	           
	         try{  
	            Thread.sleep(1000);              
	            repaint();                          
	         }  
	         catch(InterruptedException ie){}     
	      }        
	   }     
	     
	}   

	

	