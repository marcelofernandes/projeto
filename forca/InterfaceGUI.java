import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InterfaceGUI extends JFrame implements InterfaceComUsuario{
	private OpcoesDoJogo opcao;
	private String opcaoDoNivel;
	private String texto;
	private String ingles;
	private boolean continua = true;
	private Background imagePanel;
	private Time tempo;
	private Image image;
	private ImageIcon imagem1;
	private ImageIcon imagem2;
	private ImageIcon imagem3;
	private ImageIcon imagem4;
	private ImageIcon imagem5;
	private ImageIcon imagem6;
	private JLabel label;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JButton botao1;
	private JButton botao2;
	private JTextArea textArea;
	private JMenuBar menuBar;  
	private JMenu ferramentas;  
	private JMenu arquivo;
	private JMenu exibir;
	private JMenu ajuda;  
	private JMenuItem cadastrarDesafio; 
	private JMenuItem removerDesafio; 
	private JMenuItem zerarRanking; 
	private JMenuItem sair; 
	private JMenuItem voltarMenu; 
	private JMenuItem instrucoes; 
	private JMenuItem creditos; 
	private GridBagLayout layout;
	private GridBagConstraints gbc;
	private GridBagConstraints gbc2;
	private GridBagConstraints gbc3;
	private GridBagConstraints gbc4;
	private MouseListener listener1;
	private MouseListener listener2;
	private MouseListener listener4;
	private Thread t;

	public InterfaceGUI(){
		super("Jogo Forca Inglês");
		gbc = new GridBagConstraints();
		gbc2 = new GridBagConstraints();
		gbc3 = new GridBagConstraints();
		gbc4 = new GridBagConstraints();
		tempo = new Time();
		menuBar = new JMenuBar();  
		arquivo = new JMenu("Arquivo"); 
		exibir = new JMenu("Exibir"); 
		ferramentas = new JMenu("Ferramentas"); 
		ajuda = new JMenu("Ajuda"); 
		sair = new JMenuItem("Sair");  
		cadastrarDesafio = new JMenuItem("Cadastrar novo desafio");  
		voltarMenu = new JMenuItem("Ir para menu principal");  
		removerDesafio = new JMenuItem("Remover desafio");
		zerarRanking = new JMenuItem("Zerar ranking");
		instrucoes = new JMenuItem("Instruções");  
		creditos = new JMenuItem("Créditos");  
		arquivo.add(sair);
		exibir.add(voltarMenu);
		ferramentas.add(cadastrarDesafio);
		ferramentas.add(removerDesafio);
		ferramentas.add(zerarRanking);
		ajuda.add(instrucoes);
		ajuda.add(creditos);
		menuBar.add(arquivo);  
		menuBar.add(exibir);  
		menuBar.add(ferramentas);  
		menuBar.add(ajuda);
		setJMenuBar(menuBar); 
		voltarMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				opcao = OpcoesDoJogo.VOLTAR_PARA_MENU;
				continua = false;
			}
		});
		sair.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				opcao = OpcoesDoJogo.SAIR;
				continua = false;
			}
		});
		zerarRanking.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				opcao = OpcoesDoJogo.ZERAR_RANKING;
				continua = false;
			}
		});
		cadastrarDesafio.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				opcao = OpcoesDoJogo.CADASTRAR_DESAFIO;
				continua = false;
			}
		});
		removerDesafio.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				opcao = OpcoesDoJogo.REMOVER_DESAFIO;
				continua = false;
			}
		});
		creditos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null, "Programa criado em 2013." +
						"\nPor Ahemenson fernandes Cavalcante." +
						"\nLeonardo dos Santos Costa." +
						"\nMarcelo de Melo Fernandes.");
			}
		});
		instrucoes.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				opcao = OpcoesDoJogo.MOSTRAR_INSTRUCOES;
				continua = false;
			}
		});
		layout = new GridBagLayout();
		Toolkit tk = Toolkit.getDefaultToolkit();  
	    	Dimension d = tk.getScreenSize();  
	    	setPreferredSize(d); 
		setResizable(false);
		addWindowListener(new WindowAdapter() {  
	         		public void windowClosing(WindowEvent e) {  
	        	 		if(imagem2==null){
	        		 		opcao = OpcoesDoJogo.SAIR;
	        	 		}else{
	        		 		opcao = OpcoesDoJogo.PROXIMO_DESAFIO; 
	        	 		}
	        	 		continua = false;
	         		}  
	   	 });    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		setLocationByPlatform(true);
        		image = new ImageIcon(getClass().getResource("/Imagens_botões/fundo-letras.gif")).getImage();
       		imagePanel = new Background(image);
       	 	imagePanel.setLayout(layout);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc2.gridx = 0;
		gbc2.gridy = 1;
		gbc3.gridx = 0;
		gbc3.gridy = 2;
		gbc4.gridx = 0;
		gbc4.gridy = 3;
	}
	
	public OpcoesDoJogo mostrarMenu(){
		continua = true;
		voltarMenu.setEnabled(false);
		zerarRanking.setEnabled(false);
		sair.setEnabled(false);
		cadastrarDesafio.setEnabled(false);
		removerDesafio.setEnabled(false);
		instrucoes.setEnabled(false);
		creditos.setEnabled(false);
		imagem1 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_jogar.png"));
		imagem2 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_inst.png"));
		imagem3 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_rank.png"));
		imagem4 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_sair.png"));
		label = new JLabel(imagem1);
		label2 = new JLabel(imagem2);
		label3 = new JLabel(imagem3);
		label4 = new JLabel(imagem4);
	    	listener1 = new MouseAdapter(){
	    		public void mouseReleased(MouseEvent e){
	    			opcao = OpcoesDoJogo.JOGAR;
	    			continua = false;
	    		}
	    		public void mouseEntered(MouseEvent e){
	    			imagem1 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_jogar_amarelo.png"));
	    			label.setIcon(imagem1);
	    		}
	    		public void mouseExited(MouseEvent e){
	    			imagem1 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_jogar.png"));
	    			label.setIcon(imagem1);
	    		}
	    	};
	    	label.addMouseListener(listener1);
	   	label2.addMouseListener(new MouseAdapter(){
	    		public void mouseReleased(MouseEvent e){
	    			opcao = OpcoesDoJogo.INSTRUCOES;
	    			continua = false;
	    		}
	    		public void mouseEntered(MouseEvent e){
	    			imagem2 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_inst_amarelo.png"));
	    			label2.setIcon(imagem2);
	    		}
	    		public void mouseExited(MouseEvent e){
	    			imagem2 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_inst.png"));
	    			label2.setIcon(imagem2);
	    		}
	   	});
	    
	   	listener2 = new MouseAdapter(){
	    		public void mouseReleased(MouseEvent e){
	    			opcao = OpcoesDoJogo.RANKING;
	    			continua = false;
	    		}
	    		public void mouseEntered(MouseEvent e){
	    			imagem3 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_rank_amarelo.png"));
	    			label3.setIcon(imagem3);
	    		}
	    		public void mouseExited(MouseEvent e){
	    			imagem3 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_rank.png"));
	    			label3.setIcon(imagem3);
	    		}
	   	 };
	   	label3.addMouseListener(listener2);
	   	listener4 = new MouseAdapter(){
	    		public void mouseReleased(MouseEvent e){
	    			opcao = OpcoesDoJogo.SAIR;
	    			continua = false;
	    		}
	    		public void mouseEntered(MouseEvent e){
	    			imagem4 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_sair_amarelo.png"));
	    			label4.setIcon(imagem4);
	    		}
	    		public void mouseExited(MouseEvent e){
	    			imagem4 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_sair.png"));
	    			label4.setIcon(imagem4);
	    		}
	   	 };
	   	label4.addMouseListener(listener4);
	    	imagePanel.add(label, gbc); 
	    	imagePanel.add(label2, gbc2); 
	   	imagePanel.add(label3, gbc3);
	   	imagePanel.add(label4, gbc4);
	    	setContentPane(imagePanel);
        		pack();
        		setVisible(true);
	    	while(continua){}
		return opcao;
	}

	public String escolherNivel(){
		continua = true;
		voltarMenu.setEnabled(false);
		zerarRanking.setEnabled(false);
		sair.setEnabled(false);
		cadastrarDesafio.setEnabled(false);
		removerDesafio.setEnabled(false);
		instrucoes.setEnabled(false);
		creditos.setEnabled(false);
		imagem1 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_escolha.png"));
		imagem3 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_facil.png"));
		imagem4 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_dificil.png"));
		label.removeMouseListener(listener1);
		label3.removeMouseListener(listener2);
		label4.removeMouseListener(listener4);	
	    	label3.addMouseListener(new MouseAdapter(){
	    		public void mouseReleased(MouseEvent e){
	    			opcaoDoNivel = "1";
	    			continua = false;
	    		}
	    		public void mouseEntered(MouseEvent e){
	    			imagem3 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_facil_amarelo.png"));
	    			label3.setIcon(imagem3);
	    		}
	    		public void mouseExited(MouseEvent e){
	    			imagem3 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_facil.png"));
	    			label3.setIcon(imagem3);
	    		}
	   	});
	    	listener4 = new MouseAdapter(){
	    		public void mouseReleased(MouseEvent e){
	    			opcaoDoNivel = "2";
	    			continua = false;
	    		}
	    		public void mouseEntered(MouseEvent e){
	    			imagem4 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_dificil_amarelo.png"));
	    			label4.setIcon(imagem4);
	    		}
	    		public void mouseExited(MouseEvent e){
	    			imagem4 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_dificil.png"));
	    			label4.setIcon(imagem4);
	    		}
	    	};
	    	label4.addMouseListener(listener4);
		label.setIcon(imagem1);
		imagePanel.remove(label2);
	    	label3.setIcon(imagem3);
	    	label4.setIcon(imagem4);
	    	while(continua){}
		return opcaoDoNivel;
	}

	public String nomeDoJogador(){
		continua = true;
		voltarMenu.setEnabled(false);
		zerarRanking.setEnabled(false);
		sair.setEnabled(false);
		cadastrarDesafio.setEnabled(false);
		removerDesafio.setEnabled(false);
		instrucoes.setEnabled(false);
		creditos.setEnabled(false);
		imagem1 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_digite_nome.png"));
		imagem4 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_criar_jogador.png"));
		label.setIcon(imagem1);
		label4.setIcon(imagem4);
		imagePanel.remove(label3);
		label4.removeMouseListener(listener4);
		final JTextField field = new JTextField(7);
		Font fonte = new Font("Arial",Font.PLAIN,30); 
		field.setFont(fonte);
		field.setHorizontalAlignment(JTextField.CENTER);
		field.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				texto = field.getText();
	    		continua = false;
			}
		});
		listener4 = new MouseAdapter(){
	    		public void mouseReleased(MouseEvent e){
	    			texto = field.getText();
	    			continua = false;
	    		}
			public void mouseEntered(MouseEvent e){
	    			imagem4 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_criar_jogador_apertado.png"));
	    			label4.setIcon(imagem4);
	    		}
	    		public void mouseExited(MouseEvent e){
	    			imagem4 = new ImageIcon(getClass().getResource("/Imagens_botões/bt_criar_jogador.png"));
	    			label4.setIcon(imagem4);
	    		}
	    	};
	    	label4.addMouseListener(listener4);
		imagePanel.add(field, gbc2); 
		setContentPane(imagePanel);
        		pack();
        		setVisible(true);
		while(continua){}
		remove(label);
		remove(label4);
		remove(imagePanel);
		remove(field);
		if((texto==null)||texto.equals("")){
			return "Jogador";
		}
		else{
			if(texto.length()<10){
				return texto;
			}else{
				return texto.substring(0,10);	
			}
		}
	}

	public OpcoesDoJogo telaDoJogo(String nome, int pontuacao, char [] vetorPalavra, Nivel nivel){
		ingles = "";
		continua = true;
		voltarMenu.setEnabled(true);
		zerarRanking.setEnabled(true);
		sair.setEnabled(true);
		cadastrarDesafio.setEnabled(true);
		removerDesafio.setEnabled(true);
		instrucoes.setEnabled(true);
		creditos.setEnabled(true);
	    	remove(imagePanel);
	    	JPanel panel = new JPanel();
		label4 = new JLabel(nome);
		label4.setFont(new Font("Serif", Font.BOLD, 40));
		label3 = new JLabel("Pontuação: " + String.valueOf(pontuacao));
		label3.setFont(new Font("Serif", Font.BOLD, 40));
		setContentPane(panel);
		panel.setLayout(new GridLayout(5,1));
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER,25,15)); 
		panel2.add(label4);
		panel2.add(label3);
		panel2.add(tempo);
		JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER,25,15));
		JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER,25,15));
		JLabel mensagem = new JLabel(" A palavra é:");
		mensagem.setFont(new Font("Serif", Font.BOLD, 40));
		for(int i = 0; i<vetorPalavra.length; i++){
			if(vetorPalavra[i]=='*'){
				ingles = ingles + "__"+"  ";
			}
			else{
				ingles = ingles + Character.toUpperCase(vetorPalavra[i]) +"  ";
			}
		}
		JLabel palavra = new JLabel(ingles);
		palavra.setFont(new Font("Serif", Font.BOLD, 40));
		panel4.add(palavra);
		panel.add(panel2);
		panel3.add(mensagem);
		panel.add(panel3);
		panel.add(panel4);
		
		imagem5 = new ImageIcon(getClass().getResource("/Imagens_botões/chutarLetra.png"));
		final JLabel label5 = new JLabel(imagem5);
		label5.setToolTipText("Clique para chutar uma letra");
	    	label5.addMouseListener(new MouseAdapter(){
	    		public void mouseReleased(MouseEvent e){
	    			opcao = OpcoesDoJogo.CHUTAR_LETRA;
	    			continua = false;
	    		}
	    		public void mouseEntered(MouseEvent e){
	    			imagem5 = new ImageIcon(getClass().getResource("/Imagens_botões/chutarLetra2.png"));
	    			label5.setIcon(imagem5);
	    		}
	    		public void mouseExited(MouseEvent e){
	    			imagem5 = new ImageIcon(getClass().getResource("/Imagens_botões/chutarLetra.png"));
	    			label5.setIcon(imagem5);
	    	
	    		}
	    	});
	    	imagem6 = new ImageIcon(getClass().getResource("/Imagens_botões/chutarPalavra.png"));
	    	final JLabel label6 = new JLabel(imagem6);
		label6.setToolTipText("Clique para chutar uma palavra");
	    	label6.addMouseListener(new MouseAdapter(){
	    		public void mouseReleased(MouseEvent e){
	    			opcao = OpcoesDoJogo.CHUTAR_PALAVRA;
	    			continua = false;
	    		}
	    		public void mouseEntered(MouseEvent e){
	    			imagem6 = new ImageIcon(getClass().getResource("/Imagens_botões/chutarPalavra2.png"));
	    			label6.setIcon(imagem6);
	    		}
	    		public void mouseExited(MouseEvent e){
	    			imagem6 = new ImageIcon(getClass().getResource("/Imagens_botões/chutarPalavra.png"));
	    			label6.setIcon(imagem6);
	    		}
	    	});
		JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.CENTER,25,15));
		panel5.add(label5);
		panel5.add(label6);
		panel.add(panel5);
		JPanel panel6 = new JPanel(new FlowLayout(FlowLayout.CENTER,100,15));
		imagem3 = new ImageIcon(getClass().getResource("/Imagens_botões/proximo.png"));
		final JLabel label7 = new JLabel(imagem3);
		label7.setToolTipText("Clique para ir para o próximo desafio .");
	    	label7.addMouseListener(new MouseAdapter(){
	    		public void mouseReleased(MouseEvent e){
	    			opcao = OpcoesDoJogo.PROXIMO_DESAFIO;
	    			continua = false;
	    			pararCronometro();
	    		}
	    		public void mouseEntered(MouseEvent e){
	    			imagem3 = new ImageIcon(getClass().getResource("/Imagens_botões/proximo_apertado.png"));
	    			label7.setIcon(imagem3);
	    		}
	    		public void mouseExited(MouseEvent e){
	    			imagem3 = new ImageIcon(getClass().getResource("/Imagens_botões/proximo.png"));
	    			label7.setIcon(imagem3);
	    		}
	    	});
	    	imagem4 = new ImageIcon(getClass().getResource("/Imagens_botões/images.png"));
		final JLabel label8 = new JLabel(imagem4);
		label8.setToolTipText("Clique para ver as letras que já saíram.");
		listener1 = new MouseAdapter(){
	    		public void mouseReleased(MouseEvent e){
	    			opcao = OpcoesDoJogo.LETRAS_SAIDAS;
	    			continua = false;
	    		}
	    		public void mouseEntered(MouseEvent e){
	    			imagem4 = new ImageIcon(getClass().getResource("/Imagens_botões/images_apertada.png"));
	    			label8.setIcon(imagem4);
	    		}
	    		public void mouseExited(MouseEvent e){
	    			imagem4 = new ImageIcon(getClass().getResource("/Imagens_botões/images.png"));
	    			label8.setIcon(imagem4);
	    		}
	    	};
	    	label8.addMouseListener(listener1);
		imagem2 = new ImageIcon(getClass().getResource("/Imagens_botões/botao_Ajuda.png"));
		final JLabel label9 = new JLabel(imagem2);
		label9.setToolTipText("Clique para mostrar ajuda.");
	    	label9.addMouseListener(new MouseAdapter(){
	    		public void mouseReleased(MouseEvent e){
	    			opcao = OpcoesDoJogo.AJUDA;
	    			continua = false;
	    		}
	    		public void mouseEntered(MouseEvent e){
	    			imagem2 = new ImageIcon(getClass().getResource("/Imagens_botões/botao_Ajuda_apertado.png"));
	    			label9.setIcon(imagem2);
	    		}
	    		public void mouseExited(MouseEvent e){
	    			imagem2 = new ImageIcon(getClass().getResource("/Imagens_botões/botao_Ajuda.png"));
	    			label9.setIcon(imagem2);
	    		}
	    	});
		imagem1 = new ImageIcon(getClass().getResource("/Imagens_botões/sair.png"));
		final JLabel label10 = new JLabel(imagem1);
		label10.setToolTipText("Clique para sair.");
		listener4 = new MouseAdapter(){
	    		public void mouseReleased(MouseEvent e){
	    			opcao = OpcoesDoJogo.SAIR;
	    			continua = false;
	    			pararCronometro();
	    		}
	    		public void mouseEntered(MouseEvent e){
	    			imagem1 = new ImageIcon(getClass().getResource("/Imagens_botões/sair_apertado.png"));
	    			label10.setIcon(imagem1);
	    		}
	    		public void mouseExited(MouseEvent e){
	    			imagem1 = new ImageIcon(getClass().getResource("/Imagens_botões/sair.png"));
	    			label10.setIcon(imagem1);
	    		}
	    	};
	    	label10.addMouseListener(listener4);
		panel6.add(label7);
		panel6.add(label8);
		panel6.add(label9);
		panel6.add(label10);
		panel.add(panel6);
		while(continua){
			if(tempo.getTempoDecorrido()<=0){
				opcao = OpcoesDoJogo.TEMPO_ENCERRADO;
				break;
			}
		}
		remove(palavra);
		remove(mensagem);
		remove(label3);
		remove(label4);
		remove(panel);
		return opcao;
	}
	
	public void iniciarCronometro(Nivel nivel){
		tempo = new Time();
		if(nivel == Nivel.FACIL){
			tempo.setTempoMaximo(60);
		}else{
			tempo.setTempoMaximo(30);
		}
		t = new Thread(tempo);
		t.start();
	}
	
	public void pararCronometro(){
		if(t.isAlive()){
			t.interrupt();
		}
	}

	@Override
	public void imprimirRanking(String dadosDoRanking) {
		continua = true;
		voltarMenu.setEnabled(false);
		zerarRanking.setEnabled(false);
		sair.setEnabled(false);
		cadastrarDesafio.setEnabled(false);
		removerDesafio.setEnabled(false);
		instrucoes.setEnabled(false);
		creditos.setEnabled(false);
		imagePanel.remove(label4);
		imagePanel.remove(label3);
		imagePanel.remove(label2);
		imagePanel.remove(label);
		label = new JLabel("Ranking");
		label.setFont(new Font("Arial",Font.PLAIN,30));
		textArea = new JTextArea();
		textArea.setText(dadosDoRanking);
		textArea.setBackground(Color.GRAY);
		textArea.setEditable(false);
		textArea.setFont(new Font("Arial",Font.PLAIN,25));
		botao1 = new JButton("Voltar");
        		botao1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				continua = false;
			}
		});
		imagePanel.add(label, gbc); 
		imagePanel.add(textArea, gbc2); 
		imagePanel.add(botao1, gbc3); 
		setContentPane(imagePanel);
        		pack();
        		setVisible(true);
		while(continua){}
		imagePanel.remove(label); 
		imagePanel.remove(textArea); 
		imagePanel.remove(botao1);
	}

	@Override
	public String chutarPalavra() {
		return JOptionPane.showInputDialog(this, "Digite a palavra: ");
	}

	@Override
	public char chutarLetra() {
		String str = JOptionPane.showInputDialog(this, "Digite a letra: ");
		if( ((str==null)||str.length()>1)||(str.equals(""))){
			return ' ';
		}else{
			return str.charAt(0);
		}
		
	}
	
	public void mostrarDica(String dica){
		JOptionPane.showMessageDialog(this, "A palavra em português é: " + dica,"Dica", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostrarLetrasQueSairam(List<Character> lista){
		String str = "";
		for(Character c:lista){
			str += c + " ";
		}
		JOptionPane.showMessageDialog(this, str,"Letras que já saíram", JOptionPane.INFORMATION_MESSAGE);
	}
	public String alterarNome(){
		return JOptionPane.showInputDialog(null, "Digite o nome: ");
	}
	
	@Override
	public void mostrarInstrucoes(String inst) {
		voltarMenu.setEnabled(false);
		zerarRanking.setEnabled(false);
		sair.setEnabled(false);
		cadastrarDesafio.setEnabled(false);
		removerDesafio.setEnabled(false);
		instrucoes.setEnabled(false);
		creditos.setEnabled(false);
		continua = true;
		imagePanel.remove(label4);
		imagePanel.remove(label3);
		imagePanel.remove(label2);
		imagePanel.remove(label);
		label = new JLabel("Instruções:");
		label.setFont(new Font("Arial",Font.PLAIN,30));
		textArea = new JTextArea();
		textArea.setText(inst);
		textArea.setBackground(Color.GRAY);
		textArea.setEditable(false);
		textArea.setFont(new Font("Arial",Font.PLAIN,25));
		botao2 = new JButton("Voltar");
        		botao2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				continua = false;
			}
		});
		imagePanel.add(label, gbc); 
		imagePanel.add(textArea, gbc2); 
		imagePanel.add(botao2, gbc3); 
		setContentPane(imagePanel);
        		pack();
        		setVisible(true);
		while(continua){}
		imagePanel.remove(label); 
		imagePanel.remove(textArea); 
		imagePanel.remove(botao2);
	}
	
	@Override
	public void mensagemFimDeJogo(){
		JOptionPane.showMessageDialog(this, "Parabéns você chegou ao final do jogo.");
	}
	
	@Override
	public void mensagemDeAcertoupalavra(String frase){
		JOptionPane.showMessageDialog(this, "Parabéns você acertou a palavra.\nExemplo " +
				"de uma frase com a palavra: \n" + frase);
	}
	
	@Override
	public void mensagemTempoEncerrado(){
		JOptionPane.showMessageDialog(this, "Fim de jogo, Tempo encerrado.");
	}
	
	@Override
	public void instrucoes(String instrucoes){
		JOptionPane.showMessageDialog(this, instrucoes);
	}

}