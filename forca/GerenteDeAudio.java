package br.com.ufpb.projetoPoo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class GerenteDeAudio {
	
	public static void main (String ...args){
		
		new GerenteDeAudio().carregaAudio("C:/Users/lléo/Desktop/Frases/3 - Sorry if i wasn''t done in yours dreams.mp3");
		
	}
		private Player player;
		private File arquivoMp3;
		
		public void carregaAudio(String path){
			this.arquivoMp3 = new File(path);
			play();
		}
	    
		
		public void play() {
			  try { 
	    	        FileInputStream fis     = new FileInputStream(arquivoMp3);
	                BufferedInputStream bis = new BufferedInputStream(fis);
	                this.player = new Player(bis);
	                System.out.println("Tocando!");
	                this.player.play();
	                System.out.println("Terminado!");
		            }
			  catch (Exception e) {
		            System.out.println("Problema ao tocar " + arquivoMp3);
		            e.printStackTrace();
			  }
		}
		
	}


    


