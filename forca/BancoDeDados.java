package br.com.ufpb.projetoPoo3a;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class BancoDeDados implements PersistenciaInterface{
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost/forca";
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private int indiceAtual;
	private ArrayList <Integer> lista ;
	

	public BancoDeDados (){
		lista = new ArrayList<Integer>();
		iniciarLista();
		indiceAtual = 0;
		conectarAoBanco();
	}
	
	public void iniciarLista(){
		for(int i = 1; i<=100; i++){
			lista.add(i);
		}
		Collections.shuffle(lista);
	}
		
	public void conectarAoBanco(){
		try{
			connection = DriverManager.getConnection ( DATABASE_URL,"forca","forca" ); 
			statement = connection.createStatement();
			resultSet = statement.executeQuery(
					"SELECT * FROM dados");
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	
	public void desconectar(){
		try{
			resultSet.close();
			statement.close();
			connection.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	
	public String getPalavraPortugues(){
		try {
			resultSet.absolute(lista.get(indiceAtual));
			return (String)resultSet.getObject(3);
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null,"dica n�o encontrada.");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return "";
	}
	
	public String getPalavraIngles(){
		try {
			return (String)resultSet.getObject(2);
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null,"palavra em ingl�s n�o encontrada");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return "";
	}
	
	public String getFrase(){
		try {
			String frase = (String)resultSet.getObject(4);
			indiceAtual++;
			return frase;
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null,"frase n�o encontrada");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return "";
	}

	public String getAudioDaPalavra(){
		try {
			resultSet.absolute(lista.get(indiceAtual));
			return (String)resultSet.getObject(5);
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null,"audio n�o encontrado.");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return "";
	}

	public String getAudioDaFrase(){
		try {
			resultSet.absolute(lista.get(indiceAtual));
			return (String)resultSet.getObject(6);
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null,"audio n�o encontrado.");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return "";
	}
}
