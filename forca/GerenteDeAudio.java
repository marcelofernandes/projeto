
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class GerenteDeAudio {
	
		private Player player;
		private File arquivoMp3;
		
		public void play(String path) {
			this.arquivoMp3 = new File(path);
			  try { 
	    	        FileInputStream fis     = new FileInputStream(arquivoMp3);
	                BufferedInputStream bis = new BufferedInputStream(fis);
	                this.player = new Player(bis);
	                this.player.play();
		            }
			  catch (Exception e) {
		            System.out.println("Problema ao tocar " + arquivoMp3);
		            e.printStackTrace();
			  }
		}
		
}


    


