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
import controle.ControleVendedor;
import modelo.Vendedor;

public class TelaVendedor extends JDialog {
	private static final long serialVersionUID = 1L;

	ControleVendedor controleVendedor = Main.controleVendedor;
    
    private JButton controleFuncionarioBtnApagarCampos = new JButton();
    private JButton controleFuncionarioBtnEditar = new JButton();
    private JButton controleFuncionarioBtnExcluir = new JButton();
    private JButton controleFuncionarioBtnListarTodos = new JButton();
    private JButton controleFuncionarioBtnPesquisar = new JButton();
    private JButton controleFuncionarioBtnSalvar = new JButton();
    private JPanel controleFuncionarioCadastrar = new JPanel();
    private JPanel controleFuncionarioConsultar = new JPanel();
    private JPanel controleFuncionarioDadosPessoais = new JPanel();
    private JTextField controleFuncionarioInputCod = new JTextField();
    private JTextField controleFuncionarioInputDep = new JTextField();
    private JTextField controleFuncionarioInputEmail = new JTextField();
    private JTextField controleFuncionarioInputNome = new JTextField();
    private JTextField controleFuncionarioInputPesquisarNome = new JTextField();
    private JTabbedPane controleFuncionarioTabbedPane = new JTabbedPane();
    private JTable controleFuncionarioTblFuncionarios = new JTable();
    private JLabel TextoCod = new JLabel();
    private JLabel TextoNomePesquisar = new JLabel();
    private JLabel TextoDep = new JLabel();
    private JLabel TextoNome = new JLabel();
    private JLabel TextoTitulo = new JLabel();
    private JLabel TextoEmail = new JLabel();
    private JScrollPane jScrollPane1 = new JScrollPane();

    public TelaVendedor(Frame parent, boolean modal) {
        super(parent, modal);
        // ATUALIZANDO O INPUT DO COD PARA O PROXIMO A SER CADASTRADO 
        controleFuncionarioInputCod.setText(String.valueOf(controleVendedor.ultimoCodigoCadastrado() + 1));
        
        // O QUE FAZER QUANDO FECHAR, TITULO E LOCALIZAÇÃO
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de funcionarios");
        setLocation(new Point(300, 150));
        
        //CRIAR UMA BORDA AO REDOR DOS INPUTS 
        controleFuncionarioDadosPessoais.setBorder(BorderFactory.createTitledBorder(null, "Dados pessoais", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", 1, 18)));
        
        //CONFIGURANDO TEXTOS
        TextoNomePesquisar.setFont(new Font("Segoe UI", 1, 12));
        TextoNomePesquisar.setText("Nome:");

        TextoCod.setFont(new Font("Segoe UI", 1, 12));
        TextoCod.setText("Código:");

        TextoNome.setFont(new Font("Segoe UI", 1, 12));
        TextoNome.setText("Nome:");

        TextoEmail.setFont(new Font("Segoe UI", 1, 12));
        TextoEmail.setText("E-mail:");

        TextoDep.setFont(new Font("Segoe UI", 1, 12));
        TextoDep.setText("Dep.:");

        TextoTitulo.setFont(new Font("Segoe UI", 1, 24));
        TextoTitulo.setText("CONTROLE DE FUNCIONÁRIOS");

        //BOTÕES
        //BOTÃO APAGAR CAMPO
        controleFuncionarioBtnApagarCampos.setFont(new Font("Segoe UI", 1, 14));
        controleFuncionarioBtnApagarCampos.setText("Apagar campos");
        controleFuncionarioBtnApagarCampos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evento) {
        		controleFuncionarioBtnApagarCamposClique(evento);
        	}
        });
        
        //BOTÃO SALVAR
        controleFuncionarioBtnSalvar.setFont(new Font("Segoe UI", 1, 14));
        controleFuncionarioBtnSalvar.setText("Salvar");
        controleFuncionarioBtnSalvar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evento) {
        		controleFuncionarioBtnSalvarClique(evento);
        	}
        });
        
        // BOTÃO EXCLUIR
        controleFuncionarioBtnExcluir.setFont(new Font("Segoe UI", 1, 14));
        controleFuncionarioBtnExcluir.setText("Excluir");
        controleFuncionarioBtnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                controleFuncionarioBtnExcluirClique(evento);
            }
        });
        
        //BOTÃO EDITAR
        controleFuncionarioBtnEditar.setFont(new Font("Segoe UI", 1, 14));
        controleFuncionarioBtnEditar.setText("Editar");
        controleFuncionarioBtnEditar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evento) {
        		controleFuncionarioBtnEditarActionPerformed(evento);
        	}
        });
        
        //BOTÃO PESQUISAR
        controleFuncionarioBtnPesquisar.setFont(new Font("Segoe UI", 1, 12));
        controleFuncionarioBtnPesquisar.setText("Pesquisar");
        controleFuncionarioBtnPesquisar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evento) {
        		controleFuncionarioBtnPesquisarClique(evento);
        	}
        });
        
        //BOTÃO LISTAR
        controleFuncionarioBtnListarTodos.setFont(new Font("Segoe UI", 1, 12));
        controleFuncionarioBtnListarTodos.setText("Listar todos");
        controleFuncionarioBtnListarTodos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evento) {
        		controleFuncionarioBtnListarTodosClique(evento);
        	}
        });
        
        //TABBEPANE
        //BORDA DO TABBEDPANE
        controleFuncionarioTabbedPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        //ADICIONANDO TABBEDS
        controleFuncionarioTabbedPane.addTab("Cadastrar", controleFuncionarioCadastrar);
        controleFuncionarioTabbedPane.addTab("Consulta de funcionarios", controleFuncionarioConsultar);
        
        //"DESLIGANDO" O INPUT DO COD
        controleFuncionarioInputCod.setEditable(false);
        
        //TABELA DE VENDEDORES
        controleFuncionarioTblFuncionarios.setModel(new DefaultTableModel(
        		new Object [][] {
        			
        		},
        		new String [] {
        				"Código", "Nome", "E-mail", "Departamento"
        		}
        		));
        // SETANDO UM SCROLLPANE NA TABELA
        jScrollPane1.setViewportView(controleFuncionarioTblFuncionarios);
                
        //LAYOUTS
        //LAYOUT DO JPANEL DOS DADOS PESSOAIS
        GroupLayout controleFuncionarioDadosPessoaisLayout = new GroupLayout(controleFuncionarioDadosPessoais);
        controleFuncionarioDadosPessoais.setLayout(controleFuncionarioDadosPessoaisLayout);
        controleFuncionarioDadosPessoaisLayout.setHorizontalGroup(controleFuncionarioDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controleFuncionarioDadosPessoaisLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(controleFuncionarioDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(TextoNome)
            .addComponent(TextoCod))
            .addGap(18, 18, 18)
            .addGroup(controleFuncionarioDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addComponent(controleFuncionarioInputCod, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
            .addComponent(controleFuncionarioInputNome, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(controleFuncionarioDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .addGroup(controleFuncionarioDadosPessoaisLayout.createSequentialGroup()
            .addComponent(TextoEmail)
            .addGap(18, 18, 18)
            .addComponent(controleFuncionarioInputEmail, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE))
            .addGroup(controleFuncionarioDadosPessoaisLayout.createSequentialGroup()
            .addComponent(TextoDep)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(controleFuncionarioInputDep, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)))
            .addGap(13, 13, 13))
        );
        controleFuncionarioDadosPessoaisLayout.setVerticalGroup(controleFuncionarioDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controleFuncionarioDadosPessoaisLayout.createSequentialGroup()
            .addGap(19, 19, 19)
            .addGroup(controleFuncionarioDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(TextoCod)
            .addComponent(controleFuncionarioInputCod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(TextoEmail)
            .addComponent(controleFuncionarioInputEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(controleFuncionarioDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controleFuncionarioDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(TextoDep)
            .addComponent(controleFuncionarioInputDep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(controleFuncionarioInputNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addComponent(TextoNome))
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        //LAYOUT DO JPANEL DE CADASTRO
        GroupLayout controleFuncionarioCadastrarLayout = new GroupLayout(controleFuncionarioCadastrar);
        controleFuncionarioCadastrar.setLayout(controleFuncionarioCadastrarLayout);
        controleFuncionarioCadastrarLayout.setHorizontalGroup(controleFuncionarioCadastrarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controleFuncionarioCadastrarLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(controleFuncionarioCadastrarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(controleFuncionarioDadosPessoais, GroupLayout.PREFERRED_SIZE, 771, Short.MAX_VALUE)
            .addGroup(controleFuncionarioCadastrarLayout.createSequentialGroup()
            .addComponent(controleFuncionarioBtnApagarCampos, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(controleFuncionarioBtnSalvar, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
        );
        controleFuncionarioCadastrarLayout.setVerticalGroup(controleFuncionarioCadastrarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controleFuncionarioCadastrarLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(controleFuncionarioDadosPessoais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(controleFuncionarioCadastrarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(controleFuncionarioBtnApagarCampos, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
            .addComponent(controleFuncionarioBtnSalvar, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
            .addContainerGap(229, Short.MAX_VALUE))
        );

        //LAYOUT DO JPANEL DA CONSULTA
        GroupLayout controleFuncionarioConsultarLayout = new GroupLayout(controleFuncionarioConsultar);
        controleFuncionarioConsultar.setLayout(controleFuncionarioConsultarLayout);
        controleFuncionarioConsultarLayout.setHorizontalGroup(controleFuncionarioConsultarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
            .addGroup(controleFuncionarioConsultarLayout.createSequentialGroup()
            .addGroup(controleFuncionarioConsultarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controleFuncionarioConsultarLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(TextoNomePesquisar)
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(controleFuncionarioInputPesquisarNome, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(controleFuncionarioBtnPesquisar)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(controleFuncionarioBtnListarTodos))
            .addGroup(controleFuncionarioConsultarLayout.createSequentialGroup()
            .addComponent(controleFuncionarioBtnExcluir, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(controleFuncionarioBtnEditar, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(204, Short.MAX_VALUE))
        );
        controleFuncionarioConsultarLayout.setVerticalGroup(controleFuncionarioConsultarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(controleFuncionarioConsultarLayout.createSequentialGroup()
			.addContainerGap()
			.addGroup(controleFuncionarioConsultarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			.addComponent(TextoNomePesquisar)
			.addComponent(controleFuncionarioBtnPesquisar)
			.addComponent(controleFuncionarioBtnListarTodos)
			.addComponent(controleFuncionarioInputPesquisarNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addGroup(controleFuncionarioConsultarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			.addComponent(controleFuncionarioBtnExcluir, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
			.addComponent(controleFuncionarioBtnEditar, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
			.addGap(16, 16, 16))
        );

        //LAYOUR PRINCIPAL
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(controleFuncionarioTabbedPane)
            .addContainerGap())
            .addGroup(layout.createSequentialGroup()
            .addGap(218, 218, 218)
            .addComponent(TextoTitulo)
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(TextoTitulo)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(controleFuncionarioTabbedPane)
            .addContainerGap())
        );
        
        // ACIONANDO O BOTÃO DE LISTAR TODOS OS VENDEDORES
        controleFuncionarioBtnListarTodosClique(null);
    }     
    
    private void controleFuncionarioBtnApagarCamposClique(ActionEvent evento) {                                                                   
    	// APAGANDO TODOS OS CAMPOS
        controleFuncionarioInputNome.setText("");
        controleFuncionarioInputEmail.setText("");
        controleFuncionarioInputDep.setText("");        
		controleFuncionarioInputCod.setText(String.valueOf(controleVendedor.ultimoCodigoCadastrado() + 1)); // ADICIONANDO PROXIMO ID A SER CADASTRADO NO INPUT CODIGO
    }                                                                  

    private void controleFuncionarioBtnEditarActionPerformed(ActionEvent evento) {                                                             
        int linhaSelecionada = controleFuncionarioTblFuncionarios.getSelectedRow(); // PEGANDO LINHA SELECIONADA DA TABELA
        
        // SE NÃO TIVER NENHUMA LINHA SELECIONADA
     	if(linhaSelecionada == -1) { 
     		JOptionPane.showMessageDialog(this, "Selecione uma linha.");
     	}else {
     		// PEGANDO DADOS DA TABELA, DA LINHA SELECIONADA
     		Integer id = (Integer) controleFuncionarioTblFuncionarios.getModel().getValueAt(linhaSelecionada, 0);
         	String nome = (String) controleFuncionarioTblFuncionarios.getModel().getValueAt(linhaSelecionada, 1);
         	String email = (String) controleFuncionarioTblFuncionarios.getModel().getValueAt(linhaSelecionada, 2);
         	String departamento = (String) controleFuncionarioTblFuncionarios.getModel().getValueAt(linhaSelecionada, 3);
         	
         	// ALTERANDO SELEÇÃO DE TABBEDPANE
         	controleFuncionarioTabbedPane.setSelectedIndex(0);
         	
         	// COLOCANDO DADOS A SEREM EDITADOS
         	controleFuncionarioInputCod.setText(String.valueOf(id));
         	controleFuncionarioInputEmail.setText(email);
         	controleFuncionarioInputNome.setText(nome);
         	controleFuncionarioInputDep.setText(departamento);
     	}
    }                                                            

    private void controleFuncionarioBtnExcluirClique(ActionEvent evento) {                                                              
        int linhaSelecionada = controleFuncionarioTblFuncionarios.getSelectedRow(); // PEGANDO LINHA SELECIONADA DA TABELA
        DefaultTableModel tabelaVendedores = (DefaultTableModel) controleFuncionarioTblFuncionarios.getModel(); // PEGANDO MODELO DA TABELA
        
        // SE NÃO TIVER NENHUMA LINHA SELECIONADA
    	if(linhaSelecionada == -1) { 
    		JOptionPane.showMessageDialog(this, "Selecione uma linha.");
    	}else if(tabelaVendedores.getRowCount() == 1 && linhaSelecionada == 0) { // TENTANDO EXCLUIR TABELA COM APENAS 1 CLIENTE
    		JOptionPane.showMessageDialog(this, "É necessário ao menos 1 vendedor no sistema.");    		
    		controleFuncionarioInputCod.setText(String.valueOf(controleVendedor.ultimoCodigoCadastrado() + 1));
    	}else { // EXCLUINDO VENDEDOR SELECIONADO
    		Integer id = (Integer) controleFuncionarioTblFuncionarios.getModel().getValueAt(linhaSelecionada, 0);
    		controleVendedor.apagarVendedor(id);    			
    		controleFuncionarioBtnListarTodosClique(evento);
    		JOptionPane.showMessageDialog(this, "Vendedor apagado!");
    		
    		// ADICIONANDO PROXIMO ID A SER CADASTRADO NO INPUT CODIGO
    		controleFuncionarioInputCod.setText(String.valueOf(controleVendedor.ultimoCodigoCadastrado() + 1));
    	}
    }                                                                                                                       

    private void controleFuncionarioBtnSalvarClique(ActionEvent evento) {                                                             
    	//PEGANDO INFORMAÇÕES DIGITADAS NOS INPUTS
    	Integer cod = Integer.parseInt(controleFuncionarioInputCod.getText());
    	String nome = controleFuncionarioInputNome.getText();
    	String email = controleFuncionarioInputEmail.getText();
    	String departamento = controleFuncionarioInputDep.getText();
    	
        // CHECAGENS
    	if(!controleVendedor.validarEmail(email)) { // VALIDANDO EMAIL
    		JOptionPane.showMessageDialog(this, "E-mail inválido", "Erro", JOptionPane.ERROR_MESSAGE);
    	}else if(controleFuncionarioInputNome.getText().equals("") ||
    			controleFuncionarioInputEmail.getText().equals("") ||
    			controleFuncionarioInputDep.getText().equals("")
    			) { // CAMPOS EM BRANCO
    		JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
    	}else if(controleVendedor.checarId(cod)) { // CHECANDO SE ID JÁ EXISTE NO BANCO DE DADOS
    		controleVendedor.editarVendedor(new Vendedor(cod, nome, email, departamento));
    		// PROXIMO ID A SER CADASTRADO
            controleFuncionarioInputCod.setText(String.valueOf(controleVendedor.ultimoCodigoCadastrado() + 1));
         
            // SETANDO TEXTO PARA NADA.
            controleFuncionarioInputNome.setText("");
            controleFuncionarioInputEmail.setText("");
            controleFuncionarioInputDep.setText("");
            
            // ALTERANDO TABBEDPANE E ATUALIZANDO LISTA
        	controleFuncionarioTabbedPane.setSelectedIndex(1);
        	controleFuncionarioBtnListarTodosClique(evento);
    	}else {
    		controleVendedor.adicionarVendedor(new Vendedor(cod, nome, email, departamento));
    		// PROXIMO ID A SER CADASTRADO
    		controleFuncionarioInputCod.setText(String.valueOf(controleVendedor.ultimoCodigoCadastrado() + 1));
    		
    		// SETANDO TEXTO PARA NADA.
            controleFuncionarioInputNome.setText("");
            controleFuncionarioInputEmail.setText("");
            controleFuncionarioInputDep.setText("");
    		
    		// ALTERANDO TABBEDPANE E ATUALIZANDO LISTA
    		controleFuncionarioTabbedPane.setSelectedIndex(1);
    		controleFuncionarioBtnListarTodosClique(evento);
    	}
    }                                                            

    private void controleFuncionarioBtnPesquisarClique(ActionEvent evento) {  
    	//CAMPO EM BRANCO
    	if(controleFuncionarioInputPesquisarNome.getText().equals("")) {
    		JOptionPane.showMessageDialog(this, "Digite um nome válido!");
    	}else {
	    	// REMOVENDO DADOS DA TABELA
	        while (controleFuncionarioTblFuncionarios.getModel().getRowCount() > 0) {  
	               ((DefaultTableModel) controleFuncionarioTblFuncionarios.getModel()).setRowCount(0);  
	        }
	        
	        DefaultTableModel tabelaVendedores = (DefaultTableModel) controleFuncionarioTblFuncionarios.getModel(); // PEGANDO MODELO DA TABELA
	        
	        // PESQUISANDO NO BANCO DE DADOS E INSERINDO EM VARIAVEIS
	        Vendedor v = controleVendedor.pesquisarPorNome(controleFuncionarioInputPesquisarNome.getText()); 
	        Integer codigo = v.getId(); 
	        String nome = v.getNome();
	        String email = v.getEmail(); 
	        String departamento = v.getDepartamento();
	        
	        // INSERIR DADOS EM UM NOVO ARRAY
	        Object[] novoVendedor = new Object[] {
	            codigo,
	            nome,
	            email,
	            departamento
	        };
	
	        // ADICIONANDO DADOS ENCONTRADOS NA TABELA
	        tabelaVendedores.addRow(novoVendedor);
    	}
    }                                                                                                                          

    private void controleFuncionarioBtnListarTodosClique(ActionEvent evento) {                                                                  
        DefaultTableModel tabelaVendedores = (DefaultTableModel) controleFuncionarioTblFuncionarios.getModel(); //MODELO DA TABELA 
    	List<Vendedor> todosVendedores = controleVendedor.obterTodosVendedores(); //PEGANDO TODOS OS VENDEDORES DO BANCO DE DADOS
    	
    	// REMOVENDO DADOS DA TABELA
        while (controleFuncionarioTblFuncionarios.getModel().getRowCount() > 0) {  
               ((DefaultTableModel) controleFuncionarioTblFuncionarios.getModel()).setRowCount(0);  
        }
        
        // PEGANDO CADA CLIENTE NO BANCO DE DADOS
    	for(Vendedor v: todosVendedores) {
            // PEGANDO DADOS
            Integer codigo = v.getId(); 
            String nome = v.getNome();
            String email = v.getEmail(); 
            String departamento = v.getDepartamento();

            // INSERIR DADOS NUM NOVO ARRAY
            Object[] novoVendedor = new Object[] {
                codigo,
                nome,
                email,
                departamento
            };

            // NOVA LINHA TABELA
            tabelaVendedores.addRow(novoVendedor);
    	}
    }                                                                                                                                                      
}
