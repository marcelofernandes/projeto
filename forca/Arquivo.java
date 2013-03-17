import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Arquivo implements PersistenciaInterface{
	
	private int indice;
	private List<Integer> listaAleatoria;
	
	public Arquivo(){
		this.indice = 0;
		listaAleatoria = new ArrayList<Integer>();
	}
	
	public String getPalavraPortugues()throws PalavrasAcabaramException{
		ObjectInputStream inPortugues = null;
		List<String> palavrasPortugues = null;
		String palavra = null;
		try {
			inPortugues = new ObjectInputStream(new FileInputStream("./portugues.dat"));
			palavrasPortugues =  (List<String>) inPortugues.readObject(); 
			if(indice>=palavrasPortugues.size()){
				throw new PalavrasAcabaramException();
			}
			palavra = palavrasPortugues.get(listaAleatoria.get(indice));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				inPortugues.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return palavra;
	}
	
	public String getPalavraIngles()throws PalavrasAcabaramException{
		ObjectInputStream inIngles = null;
		List<String> palavrasIngles = null;
		String palavra = null;
		try {
			inIngles = new ObjectInputStream(new FileInputStream("./ingles.dat"));
			palavrasIngles =  (List<String>) inIngles.readObject(); 
			if(indice>=palavrasIngles.size()){
				throw new PalavrasAcabaramException();
			}
			for(int i = 0; i<palavrasIngles.size(); i++){
				listaAleatoria.add(i);
			}
			Collections.shuffle(listaAleatoria);
			palavra = palavrasIngles.get(listaAleatoria.get(indice));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				inIngles.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return palavra;	
	}

	public String getFrase() throws PalavrasAcabaramException{
		ObjectInputStream inFrase = null;
		List<String> frases = null;
		String frase = null;
		try {
			inFrase = new ObjectInputStream(new FileInputStream("./frase.dat"));
			frases =  (List<String>) inFrase.readObject(); 
			if(indice>=frases.size()){
				throw new PalavrasAcabaramException();
			}
			frase = frases.get(listaAleatoria.get(indice));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				inFrase.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return frase;
	}

	public String getAudioDaPalavra()throws PalavrasAcabaramException{
		ObjectInputStream inAudio = null;
		List<String> audioPalavras = null;
		String palavra = null;
		try {
			inAudio = new ObjectInputStream(new FileInputStream("./ingles.dat"));
			audioPalavras =  (List<String>) inAudio.readObject(); 
			if(indice>=audioPalavras.size()){
				throw new PalavrasAcabaramException();
			}
			palavra = audioPalavras.get(listaAleatoria.get(indice));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				inAudio.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return palavra;
	}

	public String getAudioDaFrase()throws PalavrasAcabaramException{
		ObjectInputStream inAudioFrase = null;
		List<String> audiosFrases = null;
		String palavra = null;
		try {
			inAudioFrase = new ObjectInputStream(new FileInputStream("./audio_frase.dat"));
			audiosFrases =  (List<String>) inAudioFrase.readObject(); 
			if(indice>=audiosFrases.size()){
				throw new PalavrasAcabaramException();
			}
			palavra = audiosFrases.get(listaAleatoria.get(indice));
			indice++;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				inAudioFrase.close();	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return palavra;
	}

	@Override
	public void fecharConexao() {
		//não precisa fechar
	}

	@Override
	public void cadastrarDesafio() {
		String palavraIngles = JOptionPane.showInputDialog("Digite a palavra em inglês:");
		if( (palavraIngles==null)||(palavraIngles.equals("")) ){
			return;
		}
		
		String palavraPortugues = JOptionPane.showInputDialog("Digite a palavra em português:");
		if( (palavraPortugues==null)||(palavraPortugues.equals("")) ){
			return;
		}
		
		String frase = JOptionPane.showInputDialog("Digite a frase, junto com tradução:");
		if( (frase==null)||(frase.equals("")) ){
			return;
		}
		
		String audioFrase = JOptionPane.showInputDialog("Digite o nome do arquivo de audio da frase:");
		if( (audioFrase==null)||(audioFrase.equals("")) ){
			return;
		}
		cadastrarPalavraNoArquivo("./ingles.dat", palavraIngles);
		cadastrarPalavraNoArquivo("./portugues.dat", palavraPortugues);
		cadastrarPalavraNoArquivo("./frase.dat", frase);
		cadastrarPalavraNoArquivo("./audio_frase.dat", audioFrase);
	}

	@Override
	public void removerDesafio() {
		String palavra = JOptionPane.showInputDialog("Digite a palavra em inglês para remover:");
		int indice = checaSeExistepalavra(palavra);
		if(indice == -1){
			return;
		}else{
			removerPalavraDoArquivo("./ingles.dat",indice);
			removerPalavraDoArquivo("./portugues.dat",indice);
			removerPalavraDoArquivo("./audio_frase.dat",indice);
			removerPalavraDoArquivo("./frase.dat",indice);
		}
	}

	@Override
	public List<String> carregarNomesDosJogadores() {
		ObjectInputStream inNomes = null;
		List<String> nomes = null;
		try {
			inNomes = new ObjectInputStream(new FileInputStream("./nomes.dat"));
			nomes =  (List<String>) inNomes.readObject(); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				inNomes.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return nomes;
	}

	@Override
	public List<Integer> carregarPontuacoesDosJogadores() {
		List<Integer> pontos = null;
		ObjectInputStream inPontos = null;
		try {
			inPontos = new ObjectInputStream(new FileInputStream("./pontos.dat"));
			pontos =  (List<Integer>) inPontos.readObject(); 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try{
				inPontos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return pontos;
	}

	@Override
	public void salvarRanking(List<String> nomes, List<Integer> pontuacoes) {
		ObjectOutputStream outNomes = null;
		ObjectOutputStream outPontos = null;
		try {
			outNomes = new ObjectOutputStream(new FileOutputStream("./nomes.dat"));
			outNomes.writeObject(nomes);
			outPontos = new ObjectOutputStream(new FileOutputStream("./pontos.dat"));
			outPontos.writeObject(pontuacoes);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				outNomes.close();
				outPontos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private void removerPalavraDoArquivo(String caminho, int indice){
		ObjectInputStream in = null;
		List<String> lista = null;
		try {
			in = new ObjectInputStream(new FileInputStream(caminho));
			lista =  (List<String>) in.readObject();
			lista.remove(indice);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try{
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(caminho));
			out.writeObject(lista);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void cadastrarPalavraNoArquivo(String caminho, String palavra){
		ObjectInputStream in = null;
		List<String> lista = null;
		try{
			in = new ObjectInputStream(new FileInputStream(caminho));
			lista =  (List<String>) in.readObject();
			lista.add(palavra);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try{
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(caminho));
			out.writeObject(lista);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try{
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private int checaSeExistepalavra(String palavra){
		ObjectInputStream in = null;
		List<String> palavras = null;
		int indice = -1;
		try {
			in = new ObjectInputStream(new FileInputStream("./ingles.dat"));
			palavras =  (List<String>) in.readObject();
			indice = palavras.indexOf(palavra);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try{
				in.close();	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return indice;
	}
}