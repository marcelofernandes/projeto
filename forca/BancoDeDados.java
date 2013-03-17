
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

public class BancoDeDados implements PersistenciaInterface{
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost/forca";
	private Connection connection = null;
	private Statement statement = null;
	private Statement statementRanking = null;
	private ResultSet resultSet = null;
	private ResultSet resultSetRanking;
	private int indiceAtual;
	private int qtdRegistros;
	private ArrayList <Integer> lista ;
	
	public BancoDeDados (){
		lista = new ArrayList<Integer>();
		indiceAtual = 0;
		conectarAoBanco();
		iniciarLista();
	}
	
	
	public void iniciarLista(){
		for(int i = 1; i<=qtdRegistros; i++){
			lista.add(i);
		}
		Collections.shuffle(lista);
	}
		
	public void conectarAoBanco(){
		try{
			connection = DriverManager.getConnection ( DATABASE_URL,"marcelo","marcelo" ); 
			
			statement = connection.createStatement();
			statementRanking = connection.createStatement();
			resultSet = statement.executeQuery(
					"SELECT * FROM dados");
			resultSetRanking = statementRanking.executeQuery(
					"SELECT * FROM ranking");
			resultSet.last();
			qtdRegistros = resultSet.getRow();
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	
	public void fecharConexao(){
		try{
			resultSetRanking.close();
			resultSet.close();
			statementRanking.close();
			statement.close();
			connection.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	
	public List<String> carregarNomesDosJogadores(){
		List<String> nomes = new ArrayList<String>();
		try{
			
			for(int i = 1; i <= 5; i++){
				resultSetRanking.absolute(i);
				String nome = (String)resultSetRanking.getObject(2);
				nomes.add(nome);
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return nomes;
	}
	
	public List<Integer> carregarPontuacoesDosJogadores(){
		List<Integer> pontuacoes = new ArrayList<Integer>();
		try{
			
			for(int i = 1; i <= 5; i++){
				resultSetRanking.absolute(i);
				Integer pontuacao = (Integer)resultSetRanking.getObject(3);
				pontuacoes.add(pontuacao);
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return pontuacoes;
	}
	
	public void salvarRanking(List<String> nomes, List<Integer> pontuacoes){
		for(int i = 0; i<nomes.size(); i++){
		try{
			String nome = nomes.get(i);
			String pontuacao = String.valueOf(pontuacoes.get(i));
				
				statementRanking.execute("UPDATE ranking set nome='"+nome+"',pontuacao="+pontuacao+" WHERE indice="+ (i+1)+";");
			
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		}
	}
	public String getPalavraPortugues(){
		try {
			return (String)resultSet.getObject(2);
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null,"dica não encontrada.");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return "";
	}
	
	public String getPalavraIngles(){
		try {
			resultSet.absolute(lista.get(indiceAtual));
			return (String)resultSet.getObject(1);
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null,"palavra em inglês não encontrada");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return "";
	}
	
	public String getFrase(){
		try {
			String frase = (String)resultSet.getObject(3);
			return frase;
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null,"frase não encontrada");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return "";
	}

	public String getAudioDaPalavra(){
		try {
			return (String)resultSet.getObject(1);
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null,"audio não encontrado.");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return "";
	}

	public String getAudioDaFrase(){
		try {
			indiceAtual++;
			return (String)resultSet.getObject(4);
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null,"audio não encontrado.");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
		return "";
	}
	
	
	public void cadastrarDesafio(){
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
		
		try{
			statement.execute("insert into dados (ingles,portugues,frase, audioInglesFrase) values ('"+ palavraIngles +"','"+ palavraPortugues +"','"+ frase +"','"+ audioFrase +"')");
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	
	@Override
	public void removerDesafio() {
		String palavraIngles = JOptionPane.showInputDialog("Digite a palavra em inglês para remover:");
		try{
			statement.execute("DELETE FROM dados WHERE ingles='"+palavraIngles+"'");
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
}