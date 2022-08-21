package view;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import application.Main;
import controle.ControleProduto;
import modelo.Produto;

public class TelaProduto extends JDialog {
	ControleProduto controleProduto = Main.controleProduto;

	private static final long serialVersionUID = 1L;
	
	private JButton controleProdutoBtnApagarCampos = new JButton();
    private JButton controleProdutoBtnEditar = new JButton();
    private JButton controleProdutoBtnExcluir = new JButton();
    private JButton controleProdutoBtnListarTodos = new JButton();
    private JButton controleProdutoBtnPesquisar = new JButton();
    private JButton controleProdutoBtnSalvar = new JButton();
    private JPanel controleProdutoCadastrar = new JPanel();
    private JPanel controleProdutoConsultar = new JPanel();
    private JPanel controleProdutoDadosPessoais = new JPanel();
    private JTextField controleProdutoInputCod = new JTextField();
    private JTextField controleProdutoInputEstoque = new JTextField();
    private JTextField controleProdutoInputNome = new JTextField();
    private JTextField controleProdutoInputPesquisarNome = new JTextField();
    private JTextField controleProdutoInputPreco = new JTextField();
    private JTabbedPane controleProdutoTabbedPane = new JTabbedPane();
    private JTable controleProdutoTblProdutos = new JTable();
    private JLabel TextoCodigo = new JLabel();
    private JLabel TextoNome2 = new JLabel();
    private JLabel TextoEstoque = new JLabel();
    private JLabel TextoNome = new JLabel();
    private JLabel TextoControleProduto = new JLabel();
    private JLabel TextoPreco = new JLabel();
    private JScrollPane jScrollPane1 = new JScrollPane();
	
    public TelaProduto(Frame parent, boolean modal) {
        super(parent, modal);
        controleProdutoInputCod.setText(String.valueOf(controleProduto.ultimoCodigoCadastrado()+1));
        
        // O QUE FAZER QUANDO FECHAR, TITULO, LOCALIZAÇÃO
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de produtos");
        setLocation(new Point(300, 150));

        // BORDA
        controleProdutoTabbedPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        controleProdutoDadosPessoais.setBorder(BorderFactory.createTitledBorder(null, "Dados do produto", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", 1, 18))); 

        // BOTÕES
        // BOTÃO APAGAR CAMPO
        controleProdutoBtnApagarCampos.setFont(new Font("Segoe UI", 1, 14)); 
        controleProdutoBtnApagarCampos.setText("Apagar campos");
        controleProdutoBtnApagarCampos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evento) {
        		controleProdutoBtnApagarCamposCliente(evento);
        	}
        });
        
        //BOTÃO SALVAR
        controleProdutoBtnSalvar.setFont(new Font("Segoe UI", 1, 14)); 
        controleProdutoBtnSalvar.setText("Salvar");
        controleProdutoBtnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                controleProdutoBtnSalvarClique(evento);
            }
        });

        //BOTÃO EXCLUIR
        controleProdutoBtnExcluir.setFont(new Font("Segoe UI", 1, 14)); 
        controleProdutoBtnExcluir.setText("Excluir");
        controleProdutoBtnExcluir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evento) {
        		controleProdutoBtnExcluirClique(evento);
        	}
        });

        //BOTÃO EDITAR
        controleProdutoBtnEditar.setFont(new Font("Segoe UI", 1, 14)); 
        controleProdutoBtnEditar.setText("Editar");
        controleProdutoBtnEditar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evento) {
        		controleProdutoBtnEditarClique(evento);
        	}
        });
        
        //BOTÃO PESQUISAR
        controleProdutoBtnPesquisar.setFont(new Font("Segoe UI", 1, 12)); 
        controleProdutoBtnPesquisar.setText("Pesquisar");
        controleProdutoBtnPesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                controleProdutoBtnPesquisarClique(evento);
            }
        });

        //BOTÃO LISTAR TODOS
        controleProdutoBtnListarTodos.setFont(new Font("Segoe UI", 1, 12)); 
        controleProdutoBtnListarTodos.setText("Listar todos");
        controleProdutoBtnListarTodos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                controleProdutoBtnListarTodosClique(evento);
            }
        });
        
        //DESLIGANDO INPUT
        controleProdutoInputCod.setEditable(false);
        
        // TEXTOS
        TextoCodigo.setFont(new Font("Segoe UI", 1, 12)); 
        TextoCodigo.setText("Código:");

        TextoNome.setFont(new Font("Segoe UI", 1, 12)); 
        TextoNome.setText("Nome:");

        TextoPreco.setFont(new Font("Segoe UI", 1, 12)); 
        TextoPreco.setText("Preço:");

        TextoEstoque.setFont(new Font("Segoe UI", 1, 12)); 
        TextoEstoque.setText("Estoque:");

        TextoControleProduto.setFont(new Font("Segoe UI", 1, 24)); 
        TextoControleProduto.setText("CONTROLE DE PRODUTOS");

        TextoNome2.setFont(new Font("Segoe UI", 1, 12)); 
        TextoNome2.setText("Nome:");

        //TABBEPANE
        controleProdutoTabbedPane.addTab("Cadastrar", controleProdutoCadastrar);
        controleProdutoTabbedPane.addTab("Consulta de produtos", controleProdutoConsultar);
        
        //TABELA 
        controleProdutoTblProdutos.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Preço (R$)", "Estoque"
            }
        ));
        //SCROLLPANE PARA A TABELA
        jScrollPane1.setViewportView(controleProdutoTblProdutos);

        //LAYOUTS
        GroupLayout controleProdutoDadosPessoaisLayout = new GroupLayout(controleProdutoDadosPessoais);
        controleProdutoDadosPessoais.setLayout(controleProdutoDadosPessoaisLayout);
        controleProdutoDadosPessoaisLayout.setHorizontalGroup(controleProdutoDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controleProdutoDadosPessoaisLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(controleProdutoDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(TextoNome)
            .addComponent(TextoCodigo))
            .addGap(18, 18, 18)
            .addGroup(controleProdutoDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addComponent(controleProdutoInputCod, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
            .addComponent(controleProdutoInputNome, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(controleProdutoDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
			.addGroup(controleProdutoDadosPessoaisLayout.createSequentialGroup()
            .addComponent(TextoPreco)
            .addGap(18, 18, 18)
            .addComponent(controleProdutoInputPreco, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE))
			.addGroup(controleProdutoDadosPessoaisLayout.createSequentialGroup()
			.addComponent(TextoEstoque)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(controleProdutoInputEstoque, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)))
            .addGap(13, 13, 13))
        );
        
        controleProdutoDadosPessoaisLayout.setVerticalGroup(controleProdutoDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controleProdutoDadosPessoaisLayout.createSequentialGroup()
            .addGap(19, 19, 19)
            .addGroup(controleProdutoDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(TextoCodigo)
            .addComponent(controleProdutoInputCod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(TextoPreco)
            .addComponent(controleProdutoInputPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(controleProdutoDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controleProdutoDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(TextoEstoque)
            .addComponent(controleProdutoInputEstoque, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(controleProdutoInputNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addComponent(TextoNome))
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout controleProdutoCadastrarLayout = new GroupLayout(controleProdutoCadastrar);
        controleProdutoCadastrar.setLayout(controleProdutoCadastrarLayout);
        controleProdutoCadastrarLayout.setHorizontalGroup(controleProdutoCadastrarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controleProdutoCadastrarLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(controleProdutoCadastrarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(controleProdutoDadosPessoais, GroupLayout.PREFERRED_SIZE, 771, Short.MAX_VALUE)
            .addGroup(controleProdutoCadastrarLayout.createSequentialGroup()
            .addComponent(controleProdutoBtnApagarCampos, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(controleProdutoBtnSalvar, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
        );
        
        controleProdutoCadastrarLayout.setVerticalGroup(controleProdutoCadastrarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controleProdutoCadastrarLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(controleProdutoDadosPessoais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(controleProdutoCadastrarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(controleProdutoBtnApagarCampos, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
            .addComponent(controleProdutoBtnSalvar, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
            .addContainerGap(229, Short.MAX_VALUE))
        );
        
        GroupLayout controleProdutoConsultarLayout = new GroupLayout(controleProdutoConsultar);
        controleProdutoConsultar.setLayout(controleProdutoConsultarLayout);
        controleProdutoConsultarLayout.setHorizontalGroup(controleProdutoConsultarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
            .addGroup(controleProdutoConsultarLayout.createSequentialGroup()
            .addGroup(controleProdutoConsultarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controleProdutoConsultarLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(TextoNome2)
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(controleProdutoInputPesquisarNome, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(controleProdutoBtnPesquisar)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(controleProdutoBtnListarTodos))
            .addGroup(controleProdutoConsultarLayout.createSequentialGroup()
            .addComponent(controleProdutoBtnExcluir, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(controleProdutoBtnEditar, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(204, Short.MAX_VALUE))
        );
        
        controleProdutoConsultarLayout.setVerticalGroup(
            controleProdutoConsultarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controleProdutoConsultarLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(controleProdutoConsultarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(TextoNome2)
            .addComponent(controleProdutoBtnPesquisar)
            .addComponent(controleProdutoBtnListarTodos)
            .addComponent(controleProdutoInputPesquisarNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(controleProdutoConsultarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(controleProdutoBtnExcluir, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
            .addComponent(controleProdutoBtnEditar, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
            .addGap(16, 16, 16))
        );


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(controleProdutoTabbedPane)
            .addContainerGap())
            .addGroup(layout.createSequentialGroup()
            .addGap(218, 218, 218)
            .addComponent(TextoControleProduto)
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(TextoControleProduto)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(controleProdutoTabbedPane)
            .addContainerGap())
        );
    
        controleProdutoBtnListarTodosClique(null);
    }                       

    private void controleProdutoBtnApagarCamposCliente(ActionEvent evento) {                                                               
        // APAGANDO INPUTS
    	controleProdutoInputNome.setText("");
    	controleProdutoInputEstoque.setText("");
    	controleProdutoInputPreco.setText("");
    	controleProdutoInputCod.setText(String.valueOf(controleProduto.ultimoCodigoCadastrado()+1));
    }                                                              

    private void controleProdutoBtnEditarClique(ActionEvent evento) {                                                         
        int linhaSelecionada = controleProdutoTblProdutos.getSelectedRow(); // PEGANDO LINHA SELECIONADA
     	
     	if(linhaSelecionada == -1) { // SE NÃO TIVER NENHUMA LINHA SELECIONADA
     		JOptionPane.showMessageDialog(this, "Selecione uma linha.");
     	}else {
     		// PEGANDO DADOS DA TABELA, DA LINHA SELECIONADA
     		Integer id = (Integer) controleProdutoTblProdutos.getModel().getValueAt(linhaSelecionada, 0);
         	String nome = (String) controleProdutoTblProdutos.getModel().getValueAt(linhaSelecionada, 1);
         	Double preco = Double.parseDouble(String.valueOf(controleProdutoTblProdutos.getModel().getValueAt(linhaSelecionada, 2)).replace(",", ".")); 
         	Integer estoque = (Integer) controleProdutoTblProdutos.getModel().getValueAt(linhaSelecionada, 3);
         	
         	// ALTERANDO SELEÇÃO DE TABBEDPANE
         	controleProdutoTabbedPane.setSelectedIndex(0);
         	
         	//MUDANDO TEXTO
         	controleProdutoInputCod.setText(String.valueOf(id));
         	controleProdutoInputNome.setText(nome);
        	controleProdutoInputEstoque.setText(String.valueOf(estoque));
        	controleProdutoInputPreco.setText(String.valueOf(preco));
     	}
    }                                                        

    private void controleProdutoBtnExcluirClique(ActionEvent evento) {                                                          
        int linhaSelecionada = controleProdutoTblProdutos.getSelectedRow(); // PEGANDO LINHA SELECIONADA
        DefaultTableModel tabelaProdutos = (DefaultTableModel) controleProdutoTblProdutos.getModel(); // MODELO DA TABELA
    	
    	if(linhaSelecionada == -1) { // SE NÃO TIVER NENHUMA LINHA SELECIONADA
    		JOptionPane.showMessageDialog(this, "Selecione uma linha.");
    	}else if(tabelaProdutos.getRowCount() == 1 && linhaSelecionada == 0) { // APAGAR PRODUTO COM 1 ITEM
    		JOptionPane.showMessageDialog(this, "É necessário ao menos 1 produto no sistema.");    		
    		controleProdutoInputCod.setText(String.valueOf(controleProduto.ultimoCodigoCadastrado()+1));
    	}else { //EXCLUINDO PRODUTO
    		Integer id = (Integer) controleProdutoTblProdutos.getModel().getValueAt(linhaSelecionada, 0);
    		controleProduto.excluirProduto(id);    			
    		controleProdutoBtnListarTodosClique(null);
    		JOptionPane.showMessageDialog(this, "Produto apagado!");
    		
    		// ADICIONANDO PROXIMO ID A SER CADASTRADO NO INPUT CODIGO
    		controleProdutoInputCod.setText(String.valueOf(controleProduto.ultimoCodigoCadastrado()+1));
    	}
    }                                                                                                                 

    private void controleProdutoBtnSalvarClique(ActionEvent evento) {  
    	boolean precoValido = false;
    	boolean estoqueValido = false;
        // PEGANDO INFORMAÇÕES DOS CAMPOS
    	Integer cod = Integer.parseInt(controleProdutoInputCod.getText());
    	String nome = controleProdutoInputNome.getText();
    	Double preco = 0.0;
    	Integer estoque = 1;
    	
    	try {
    		String precoDigitado = controleProdutoInputPreco.getText().replace(",", ".");
    		preco = Double.parseDouble(precoDigitado);
    		precoValido = true;
    	}catch(NumberFormatException e) {
    	
    	}
    	
    	try {
    		estoque = Integer.parseInt(controleProdutoInputEstoque.getText());
    		estoqueValido = true;
    	}catch(NumberFormatException e) {
    	
    	}
    	
        // ADICIONANDO AO BANCO DE DADOS
    	if(!precoValido) {
    		JOptionPane.showMessageDialog(this, "Preço inválido!", "Erro", JOptionPane.ERROR_MESSAGE);    		    		
    	}else if(!estoqueValido) {
    		JOptionPane.showMessageDialog(this, "Estoque inválido!", "Erro", JOptionPane.ERROR_MESSAGE);    		    		    		
    	}else if(controleProdutoInputNome.getText().equals("")) {
    		JOptionPane.showMessageDialog(this, "Insira um nome!", "Erro", JOptionPane.ERROR_MESSAGE);    		    		    		    		
    	} else
			if(controleProduto.checarId(cod)) { // CHECANDO SE JÁ EXISTE
				controleProduto.editarProduto(new Produto(cod, preco, estoque, nome));
				// SETANDO TEXTO PARA NADA.
				controleProdutoInputNome.setText("");
				controleProdutoInputEstoque.setText("");
				controleProdutoInputPreco.setText("");
				
				// PROXIMO ID A SER CADASTRADO
				controleProdutoInputCod.setText(String.valueOf(controleProduto.ultimoCodigoCadastrado()+1));
			    
			    // ALTERANDO TABBEDPANE E ATUALIZANDO LISTA
				controleProdutoTabbedPane.setSelectedIndex(1);
				controleProdutoBtnListarTodosClique(null);
			}else {
				controleProduto.adicionarProduto(new Produto(cod, preco, estoque, nome));
				// SETANDO TEXTO PARA NADA.
				controleProdutoInputNome.setText("");
				controleProdutoInputEstoque.setText("");
				controleProdutoInputPreco.setText("");
			
				// PROXIMO ID A SER CADASTRADO
				controleProdutoInputCod.setText(String.valueOf(controleProduto.ultimoCodigoCadastrado()+1));
			    
			    // ALTERANDO TABBEDPANE E ATUALIZANDO LISTA
				controleProdutoTabbedPane.setSelectedIndex(1);
				controleProdutoBtnListarTodosClique(null);
			} 
    }                                                        

    private void controleProdutoBtnPesquisarClique(ActionEvent evento) {                                                            
    	if(controleProdutoInputPesquisarNome.getText().equals("")) { // INPUT VAZIO
    		JOptionPane.showMessageDialog(this, "Digite um nome válido!", "Erro", JOptionPane.ERROR_MESSAGE);
    	}else {
	    	// REMOVENDO DADOS DA TABELA
	        while (controleProdutoTblProdutos.getModel().getRowCount() > 0) {  
	               ((DefaultTableModel) controleProdutoTblProdutos.getModel()).setRowCount(0);  
	        }
	        
	        DefaultTableModel tabelaProdutos = (DefaultTableModel) controleProdutoTblProdutos.getModel(); // MODELO DA TABELA
	        
	        // PESQUISANDO NO BANCO DE DADOS E INSERINDO EM VARIAVEIS
	        Produto p = controleProduto.pesquisarProduto(controleProdutoInputNome.getText());
	        // PEGANDO DADOS
	        Integer codigo = p.getId(); 
	        String nome = p.getNome();
	        String preco = String.format("%.2f", p.getPreco());
	        Integer estoque = p.getQtdEstoque();
	        
	        // INSERIR DADOS NUM NOVO ARRAY
	        Object[] novoProduto = new Object[] {
	            codigo,
	            nome,
	            preco,
	            estoque
	        };
	
	        // NOVA LINHA TABELA
	        tabelaProdutos.addRow(novoProduto);
    	}
    }                                                                                                                   

    private void controleProdutoBtnListarTodosClique(ActionEvent evento) {                                                              
        DefaultTableModel tabelaProdutos = (DefaultTableModel) controleProdutoTblProdutos.getModel(); // MODELO TABELA
    	List<Produto> todosProdutos = controleProduto.obterTodosProdutos(); // PEGANDO TODOS OS PRODUTOS DO BANCO DE DADOS
    	
    	// REMOVENDO DADOS DA TABELA
        while (controleProdutoTblProdutos.getModel().getRowCount() > 0) {  
               ((DefaultTableModel) controleProdutoTblProdutos.getModel()).setRowCount(0);  
        }
        
        // PEGANDO CADA CLIENTE NO BANCO DE DADOS
    	for(Produto p: todosProdutos) {
            // PEGANDO DADOS
            Integer codigo = p.getId(); 
            String nome = p.getNome();
            String preco = String.format("%.2f", p.getPreco());
            Integer estoque = p.getQtdEstoque();

            // INSERIR DADOS NUM NOVO ARRAY
            Object[] novoProduto = new Object[] {
                codigo,
                nome,
                preco,
                estoque
            };

            // NOVA LINHA TABELA
            tabelaProdutos.addRow(novoProduto);
    	}
    }                                                                                                                                  
}
