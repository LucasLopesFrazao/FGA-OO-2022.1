package view;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
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
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import application.Main;
import controle.ControleCliente;
import modelo.Cliente;

public class TelaCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JButton controleClienteBtnApagarCampos = new JButton();
    private JButton controleClienteBtnEditar = new JButton();
    private JButton controleClienteBtnExcluir = new JButton();
    private JButton controleClienteBtnListarTodos = new JButton();
    private JButton controleClienteBtnPesquisar = new JButton();
    private JButton controleClienteBtnSalvar = new JButton();
    private JPanel controleClienteCadastrar = new JPanel();
    private JPanel controleClienteConsultar = new JPanel();
    private JPanel controleClienteDadosPessoais = new JPanel();
    private JPanel controleClienteEndereco = new JPanel();
    private JComboBox<String> controleClienteEstados = new JComboBox<String>();
    private JFormattedTextField controleClienteInputCEP = new JFormattedTextField();
    private JFormattedTextField controleClienteInputCPF = new JFormattedTextField();
    private JFormattedTextField controleClienteInputPesquisarCPF = new JFormattedTextField();
    private JFormattedTextField controleClienteInputUF = new JFormattedTextField();
    private JTextField controleClienteInputBairro = new JTextField();
    private JTextField controleClienteInputCidade = new JTextField();
    private JTextField controleClienteInputCod = new JTextField();
    private JTextField controleClienteInputEmail = new JTextField();
    private JTextField controleClienteInputEndereco = new JTextField();
    private JTextField controleClienteInputNome = new JTextField();
    private JTextField controleClienteInputNumero = new JTextField();
    private JTabbedPane controleClienteTabbedPane = new JTabbedPane();
    private JTable controleClienteTblClientes = new JTable();
    private JScrollPane jScrollPane1 = new JScrollPane();  
    private JLabel TextoCodigo = new JLabel();
    private JLabel TextoCidade = new JLabel();
    private JLabel TextoUF = new JLabel();
    private JLabel TextoCPF2 = new JLabel();
    private JLabel TextoNome = new JLabel();
    private JLabel TextoControleCliente = new JLabel();
    private JLabel TextoEmail = new JLabel();
    private JLabel TextoCPF = new JLabel();
    private JLabel TextoCEP = new JLabel();
    private JLabel TextoEndereco = new JLabel();
    private JLabel TextoNumero = new JLabel();
    private JLabel TextoBairro = new JLabel();
    
    ControleCliente controleCliente = Main.controleCliente;

    public TelaCliente(Frame parent, boolean modal) {
        super(parent, modal);
        
        // ATUALIZANDO O INPUT DO COD PARA O PROXIMO A SER CADASTRADO 
        controleClienteInputCod.setText(String.valueOf(controleCliente.ultimoCodigoCadastrado() + 1));
        
        // COLOCANDO VALOR PADRÃO NO DROPBOX
        controleClienteInputUF.setText("DF");
        
        // O QUE FAZER QUANDO FECHAR, TITULO E LOCALIZAÇÃO
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de clientes");
        setLocation(new Point(200, 130));

        //BORDAS
        controleClienteTabbedPane.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
        controleClienteDadosPessoais.setBorder(BorderFactory.createTitledBorder(null, "Dados pessoais", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", 1, 18)));
        controleClienteEndereco.setBorder(BorderFactory.createTitledBorder(null, "Endereço", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", 1, 18)));

        //BOTÕES
        //BOTÃO APAGAR CAMPOS
        controleClienteBtnApagarCampos.setFont(new Font("Segoe UI", 1, 14));
        controleClienteBtnApagarCampos.setText("Apagar campos");
        controleClienteBtnApagarCampos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                controleClienteBtnApagarCamposClique(evento);
            }
        });

        //BOTÃO SALVAR
        controleClienteBtnSalvar.setFont(new Font("Segoe UI", 1, 14));
        controleClienteBtnSalvar.setText("Salvar");
        controleClienteBtnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                controleClienteBtnSalvarClique(evento);
            }
        });
        
        //BOTÃO PESQUISAR
        controleClienteBtnPesquisar.setFont(new Font("Segoe UI", 1, 12));
        controleClienteBtnPesquisar.setText("Pesquisar");
        controleClienteBtnPesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                controleClienteBtnPesquisarClique(evento);
            }
        });

        //BOTÃO LISTAR TODOS
        controleClienteBtnListarTodos.setFont(new Font("Segoe UI", 1, 12));
        controleClienteBtnListarTodos.setText("Listar todos");
        controleClienteBtnListarTodos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                controleClienteBtnListarTodosClique(evento);
            }
        });
        
        //BOTÃO EXCLUIR
        controleClienteBtnExcluir.setFont(new Font("Segoe UI", 1, 14));
        controleClienteBtnExcluir.setText("Excluir");
        controleClienteBtnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                controleClienteBtnExcluirClique(evento);
            }
        });

        //BOTÃO EDITAR
        controleClienteBtnEditar.setFont(new Font("Segoe UI", 1, 14));
        controleClienteBtnEditar.setText("Editar");
        controleClienteBtnEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                controleClienteBtnEditarClique(evento);
            }
        });

        //TEXTOS
        TextoCodigo.setFont(new Font("Segoe UI", 1, 12));
        TextoCodigo.setText("Código:");

        TextoNome.setFont(new Font("Segoe UI", 1, 12));
        TextoNome.setText("Nome:");
        
        TextoEmail.setFont(new Font("Segoe UI", 1, 12));
        TextoEmail.setText("E-mail:");
        
        TextoCPF.setFont(new Font("Segoe UI", 1, 12));
        TextoCPF.setText("CPF:");
        
        TextoCEP.setFont(new Font("Segoe UI", 1, 12));
        TextoCEP.setText("CEP:");
        
        TextoEndereco.setFont(new Font("Segoe UI", 1, 12));
        TextoEndereco.setText("Endereço:");
        
        TextoNumero.setFont(new Font("Segoe UI", 1, 12));
        TextoNumero.setText("Numero:");
        
        TextoBairro.setFont(new Font("Segoe UI", 1, 12));
        TextoBairro.setText("Bairro:");
        
        TextoCidade.setFont(new Font("Segoe UI", 1, 12));
        TextoCidade.setText("Cidade:");
        
        TextoUF.setFont(new Font("Segoe UI", 1, 12));
        TextoUF.setText("UF:");
        
        TextoCPF2.setFont(new Font("Segoe UI", 1, 12));
        TextoCPF2.setText("CPF:");
        
        TextoControleCliente.setFont(new Font("Segoe UI", 1, 24));
        TextoControleCliente.setText("CONTROLE DE CLIENTES");
        
        //INPUTS
        controleClienteInputCod.setEditable(false);
        controleClienteInputUF.setEditable(false);

        //APLICANDO MASCARA NOS INPUTS
        try {
            controleClienteInputCPF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
            controleClienteInputCEP.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("#####-###")));
            controleClienteInputUF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("UU")));
            controleClienteInputPesquisarCPF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        //DROPBOX
        controleClienteEstados.setModel(new DefaultComboBoxModel<>(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MS", "MT", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        controleClienteEstados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                controleClienteEstadosActionPerformed(evento);
            }
        });
        
        //TABBEDPANE
        controleClienteTabbedPane.addTab("Cadastrar", controleClienteCadastrar);
        controleClienteTabbedPane.addTab("Consulta de clientes", controleClienteConsultar);

        //TABELA CLIENTE
        controleClienteTblClientes.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "E-mail", "CPF", "CEP", "Endereco", "Numero", "Bairro", "Cidade", "UF"
            }
        ));
        
        //SCROLLPANE PARA TABELA CLIENTE
        jScrollPane1.setViewportView(controleClienteTblClientes);

        //LAYOUTS
        GroupLayout controleClienteDadosPessoaisLayout = new GroupLayout(controleClienteDadosPessoais);
        controleClienteDadosPessoais.setLayout(controleClienteDadosPessoaisLayout);
        controleClienteDadosPessoaisLayout.setHorizontalGroup(controleClienteDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controleClienteDadosPessoaisLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(controleClienteDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(TextoNome)
            .addComponent(TextoCodigo))
            .addGap(18, 18, 18)
            .addGroup(controleClienteDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .addComponent(controleClienteInputCod, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
            .addComponent(controleClienteInputNome))
            .addGap(18, 18, 18)
            .addGroup(controleClienteDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(TextoEmail, GroupLayout.Alignment.TRAILING)
            .addComponent(TextoCPF, GroupLayout.Alignment.TRAILING))
            .addGap(18, 18, 18)
            .addGroup(controleClienteDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
    		.addComponent(controleClienteInputEmail)
    		.addComponent(controleClienteInputCPF, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE))
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        controleClienteDadosPessoaisLayout.setVerticalGroup(controleClienteDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controleClienteDadosPessoaisLayout.createSequentialGroup()
            .addGap(19, 19, 19)
            .addGroup(controleClienteDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(TextoCodigo)
            .addComponent(controleClienteInputCod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(TextoEmail)
            .addComponent(controleClienteInputEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(controleClienteDadosPessoaisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(TextoNome)
            .addComponent(TextoCPF)
            .addComponent(controleClienteInputCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(controleClienteInputNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout controleClienteEnderecoLayout = new GroupLayout(controleClienteEndereco);
        controleClienteEndereco.setLayout(controleClienteEnderecoLayout);
        controleClienteEnderecoLayout.setHorizontalGroup(controleClienteEnderecoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controleClienteEnderecoLayout.createSequentialGroup()
            .addGroup(controleClienteEnderecoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addGroup(GroupLayout.Alignment.LEADING, controleClienteEnderecoLayout.createSequentialGroup()
            .addGap(25, 25, 25)
            .addGroup(controleClienteEnderecoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addComponent(TextoCidade)
            .addComponent(TextoCEP))
            .addGap(18, 18, 18)
            .addGroup(controleClienteEnderecoLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .addComponent(controleClienteInputCEP, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
            .addComponent(controleClienteInputCidade)))
            .addGroup(GroupLayout.Alignment.LEADING, controleClienteEnderecoLayout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addGroup(controleClienteEnderecoLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addGroup(controleClienteEnderecoLayout.createSequentialGroup()
    		.addComponent(TextoBairro)
            .addGap(18, 18, 18)
            .addComponent(controleClienteInputBairro, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE))
            .addGroup(controleClienteEnderecoLayout.createSequentialGroup()
            .addComponent(TextoUF)
            .addGap(18, 18, 18)
            .addComponent(controleClienteInputUF, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
            .addGroup(controleClienteEnderecoLayout.createSequentialGroup()
            .addComponent(TextoEndereco)
            .addGap(18, 18, 18)
            .addComponent(controleClienteInputEndereco, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE))
            .addGroup(controleClienteEnderecoLayout.createSequentialGroup()
            .addComponent(TextoNumero)
            .addGap(18, 18, 18)
            .addComponent(controleClienteInputNumero, GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addComponent(controleClienteEstados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
            .addGap(0, 488, Short.MAX_VALUE))
        );
        
        controleClienteEnderecoLayout.setVerticalGroup(controleClienteEnderecoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controleClienteEnderecoLayout.createSequentialGroup()
            .addGroup(controleClienteEnderecoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(TextoCEP)
            .addComponent(controleClienteInputCEP, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(controleClienteEnderecoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(TextoCidade)
            .addComponent(controleClienteInputCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(controleClienteEnderecoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(TextoEndereco)
            .addComponent(controleClienteInputEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(controleClienteEnderecoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(TextoNumero)
            .addComponent(controleClienteInputNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(controleClienteEnderecoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(TextoBairro)
            .addComponent(controleClienteInputBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(controleClienteEnderecoLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(TextoUF)
            .addComponent(controleClienteInputUF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(controleClienteEstados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addContainerGap(15, Short.MAX_VALUE))
        );

        GroupLayout controleClienteCadastrarLayout = new GroupLayout(controleClienteCadastrar);
        controleClienteCadastrar.setLayout(controleClienteCadastrarLayout);
        controleClienteCadastrarLayout.setHorizontalGroup(controleClienteCadastrarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controleClienteCadastrarLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(controleClienteCadastrarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(controleClienteDadosPessoais, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(controleClienteCadastrarLayout.createSequentialGroup()
            .addComponent(controleClienteBtnApagarCampos, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(controleClienteBtnSalvar, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(controleClienteEndereco, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
        );
        controleClienteCadastrarLayout.setVerticalGroup(controleClienteCadastrarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controleClienteCadastrarLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(controleClienteDadosPessoais, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(controleClienteEndereco, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(controleClienteCadastrarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(controleClienteBtnApagarCampos, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
            .addComponent(controleClienteBtnSalvar, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
            .addGap(14, 14, 14))
        );

        GroupLayout controleClienteConsultarLayout = new GroupLayout(controleClienteConsultar);
        controleClienteConsultar.setLayout(controleClienteConsultarLayout);
        controleClienteConsultarLayout.setHorizontalGroup(
            controleClienteConsultarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
            .addGroup(controleClienteConsultarLayout.createSequentialGroup()
            .addGroup(controleClienteConsultarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controleClienteConsultarLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(TextoCPF2)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(controleClienteInputPesquisarCPF, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(controleClienteBtnPesquisar)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(controleClienteBtnListarTodos))
            .addGroup(controleClienteConsultarLayout.createSequentialGroup()
            .addComponent(controleClienteBtnExcluir, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(controleClienteBtnEditar, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(429, Short.MAX_VALUE))
        );
        controleClienteConsultarLayout.setVerticalGroup(controleClienteConsultarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(controleClienteConsultarLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(controleClienteConsultarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(TextoCPF2)
            .addComponent(controleClienteBtnPesquisar)
            .addComponent(controleClienteBtnListarTodos)
            .addComponent(controleClienteInputPesquisarCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(controleClienteConsultarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(controleClienteBtnExcluir, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
            .addComponent(controleClienteBtnEditar, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
            .addGap(16, 16, 16))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(255, 255, 255)
            .addComponent(TextoControleCliente)
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(controleClienteTabbedPane)
            .addContainerGap())
        );
        
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(TextoControleCliente)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(controleClienteTabbedPane)
            .addContainerGap())
        );
        
        //CHAMANDO BOTÃO DE LISTAR TODOS
        controleClienteBtnListarTodosClique(null);
    }                 
    
    private void controleClienteBtnApagarCamposClique(ActionEvent evento) {                                                               
        // APAGANDO TODOS OS CAMPOS
    	controleClienteInputCod.setText(String.valueOf(controleCliente.ultimoCodigoCadastrado() + 1)); // SETANDO COD PARA O PROXIMO A SER CADASTRADO
    	controleClienteInputEmail.setText("");
    	controleClienteInputNome.setText("");
    	controleClienteInputCPF.setText("");
    	controleClienteInputCEP.setText("");
    	controleClienteInputCidade.setText("");
    	controleClienteInputEndereco.setText("");
    	controleClienteInputNumero.setText("");
    	controleClienteInputBairro.setText("");
    	controleClienteInputUF.setText("");
    }                                                              

    private void controleClienteBtnEditarClique(ActionEvent evento) {                                                         
        int linhaSelecionada = controleClienteTblClientes.getSelectedRow(); // PEGANDO LINHA SELECIONADA DA TABELA
    	
        // SE NÃO TIVER NENHUMA LINHA SELECIONADA
    	if(linhaSelecionada == -1) { 
    		JOptionPane.showMessageDialog(this, "Selecione uma linha.");
    	}else {
    		// PEGANDO DADOS DA LINHA SELECIONADA
    		Integer id = (Integer) controleClienteTblClientes.getModel().getValueAt(linhaSelecionada, 0);
        	String nome = (String) controleClienteTblClientes.getModel().getValueAt(linhaSelecionada, 1);
        	String email = (String) controleClienteTblClientes.getModel().getValueAt(linhaSelecionada, 2);
        	String cpf = (String) controleClienteTblClientes.getModel().getValueAt(linhaSelecionada, 3);
        	String cep = (String) controleClienteTblClientes.getModel().getValueAt(linhaSelecionada, 4);
        	String endereco = (String) controleClienteTblClientes.getModel().getValueAt(linhaSelecionada, 5);
        	String numero = (String) controleClienteTblClientes.getModel().getValueAt(linhaSelecionada, 6);
        	String bairro = (String) controleClienteTblClientes.getModel().getValueAt(linhaSelecionada, 7);
        	String cidade = (String) controleClienteTblClientes.getModel().getValueAt(linhaSelecionada, 8);
        	String uf = (String) controleClienteTblClientes.getModel().getValueAt(linhaSelecionada, 9);
        	
        	// ALTERANDO SELEÇÃO DA TABBEDPANE
        	controleClienteTabbedPane.setSelectedIndex(0);
        	
        	// COLOCANDO DADOS A SEREM EDITADOS NOS INPUTS
        	controleClienteInputCod.setText(String.valueOf(id));
        	controleClienteInputEmail.setText(email);
        	controleClienteInputNome.setText(nome);
        	controleClienteInputCPF.setText(cpf);
        	controleClienteInputCEP.setText(cep);
        	controleClienteInputCidade.setText(cidade);
        	controleClienteInputEndereco.setText(endereco);
        	controleClienteInputNumero.setText(numero);
        	controleClienteInputBairro.setText(bairro);
        	controleClienteInputUF.setText(uf);
    	}
    }                                                        

    private void controleClienteBtnExcluirClique(ActionEvent evento) {                                                          
        int linhaSelecionada = controleClienteTblClientes.getSelectedRow(); // PEGANDO LINHA SELECIONADA DA TABELA
        DefaultTableModel tabelaClientes = (DefaultTableModel) controleClienteTblClientes.getModel(); // PEGANDO MODELO DA TABELA
        
        // SE NÃO TIVER NENHUMA LINHA SELECIONADA
    	if(linhaSelecionada == -1) { 
    		JOptionPane.showMessageDialog(this, "Selecione uma linha.");
    	}else if(tabelaClientes.getRowCount() == 1 && linhaSelecionada == 0){ // TENTANDO EXCLUIR TABELA COM APENAS 1 CLIENTE
    		JOptionPane.showMessageDialog(this, "É necessário ao menos 1 cliente no sistema.");    		
    		controleClienteInputCod.setText(String.valueOf(controleCliente.ultimoCodigoCadastrado() + 1));
    	}else { // EXCLUINDO CLIENTE SELECIONADO
    		String cpf = (String) controleClienteTblClientes.getModel().getValueAt(linhaSelecionada, 3); // PEGANDO CPF DA LINHA SELECIONADA
    		controleCliente.excluirCliente(cpf);    			
    		controleClienteBtnListarTodosClique(evento);
    		JOptionPane.showMessageDialog(this, "Cliente apagado!", "Finalizado", JOptionPane.INFORMATION_MESSAGE);
    		
    		// ADICIONANDO PROXIMO ID A SER CADASTRADO NO INPUT CODIGO
    		controleClienteInputCod.setText(String.valueOf(controleCliente.ultimoCodigoCadastrado() + 1));
    	}
    }                                                                                                                

    private void controleClienteBtnSalvarClique(ActionEvent evento) {        
    	//PEGANDO INFORMAÇÕES DIGITADAS NOS INPUTS
    	Integer novoCodigoCliente = Integer.parseInt(controleClienteInputCod.getText());
    	String nomeCliente = controleClienteInputNome.getText();
    	String emailCliente = controleClienteInputEmail.getText();
    	String cpf = controleClienteInputCPF.getText();
    	String cepCliente = controleClienteInputCEP.getText();
    	String cidadeCliente = controleClienteInputCidade.getText();
    	String enderecoCliente = controleClienteInputEndereco.getText();
    	String numeroCliente = controleClienteInputNumero.getText();
    	String bairroCliente = controleClienteInputBairro.getText();
    	String ufCliente = controleClienteInputUF.getText();
    	
    	// CHECAGENS
    	if(!controleCliente.validarCPF(cpf)) { // CPF INVÁLIDO
    		JOptionPane.showMessageDialog(this, "CPF inválido", "Erro", JOptionPane.ERROR_MESSAGE);
    	}else if(controleClienteInputNome.getText().equals("") ||
    			controleClienteInputEmail.getText().equals("") ||
    			controleClienteInputCPF.getText().equals("") ||
    			controleClienteInputCEP.getText().equals("") ||
    			controleClienteInputCidade.getText().equals("") ||
    			controleClienteInputNumero.getText().equals("") ||
    			controleClienteInputBairro.getText().equals("") ||
    			controleClienteInputUF.getText().equals("")
    			) { // CAMPOS EM BRANCO
    		JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
    	}else if(!controleCliente.validarEmail(emailCliente)) { // EMAIL INVÁLIDO
    		JOptionPane.showMessageDialog(this, "E-mail inválido!");
    	}
    	else if(controleCliente.checarId(novoCodigoCliente)) { // CHECANDO SE O ID DO CLIENTE JÁ EXISTE E OS DADOS ESTÃO SENDO EDITADOS
    		controleCliente.editarCliente(new Cliente(novoCodigoCliente, nomeCliente, emailCliente, cpf, cepCliente, cidadeCliente, enderecoCliente, numeroCliente, bairroCliente, ufCliente));
    		
    		// APAGANDO OS INPUTS DIGITADOS
    		controleClienteInputEmail.setText("");
    		controleClienteInputNome.setText("");
    		controleClienteInputCPF.setText("");
    		controleClienteInputCEP.setText("");
    		controleClienteInputCidade.setText("");
    		controleClienteInputEndereco.setText("");
    		controleClienteInputNumero.setText("");
    		controleClienteInputBairro.setText("");
    		controleClienteInputUF.setText("");
    		
    		// ADICIONANDO PROXIMO ID A SER CADASTRADO NO INPUT CODIGO
    		controleClienteInputCod.setText(String.valueOf(controleCliente.ultimoCodigoCadastrado() + 1));
    		
    		// ALTERANDO TABBEDPANE E ATUALIZANDO LISTA
    		controleClienteTabbedPane.setSelectedIndex(1);
    		controleClienteBtnListarTodosClique(evento);
    	}else { // CLIENTE COM ID NOVO
    		if(controleCliente.cpfNoSistema(cpf)) {
    			JOptionPane.showMessageDialog(this, "CPF já cadastrado no sistema!");
    		}else {
	    		controleCliente.adicionarCliente(new Cliente(novoCodigoCliente, nomeCliente, emailCliente, cpf, cepCliente, cidadeCliente, enderecoCliente, numeroCliente, bairroCliente, ufCliente));
	    		// APAGANDO OS INPUTS DIGITADOS
	    		controleClienteInputEmail.setText("");
	    		controleClienteInputNome.setText("");
	    		controleClienteInputCPF.setText("");
	    		controleClienteInputCEP.setText("");
	    		controleClienteInputCidade.setText("");
	    		controleClienteInputEndereco.setText("");
	    		controleClienteInputNumero.setText("");
	    		controleClienteInputBairro.setText("");
	    		controleClienteInputUF.setText("");
	    		
	    		// ADICIONANDO PROXIMO ID A SER CADASTRADO NO INPUT CODIGO
	    		controleClienteInputCod.setText(String.valueOf(controleCliente.ultimoCodigoCadastrado() + 1));
	    		
	    		// ALTERANDO TABBEDPANE E ATUALIZANDO LISTA
	    		controleClienteTabbedPane.setSelectedIndex(1);
	    		controleClienteBtnListarTodosClique(evento);
    		}
    	}
    }                                                        

    private void controleClienteBtnPesquisarClique(ActionEvent evento) {
    	//VALIDANDO CPF
    	if(!controleCliente.validarCPF(controleClienteInputPesquisarCPF.getText())) {
    		JOptionPane.showMessageDialog(this, "CPF inválido!");
    	}else {
	        // REMOVENDO DADOS DA TABELA
	        while (controleClienteTblClientes.getModel().getRowCount() > 0) {  
	               ((DefaultTableModel) controleClienteTblClientes.getModel()).setRowCount(0);  
	        }
	        
	        DefaultTableModel tabelaClientes = (DefaultTableModel) controleClienteTblClientes.getModel(); // PEGANDO MODELO DA TABELA
	        
	        // PESQUISANDO NO BANCO DE DADOS E INSERINDO EM VARIAVEIS
	        Cliente c = controleCliente.pesquisarClientePorCPF(controleClienteInputPesquisarCPF.getText()); 
	        Integer codigo = c.getId(); 
	        String nome = c.getNome();
	        String email = c.getEmail(); 
	        String cpf = c.getCpf();
	        String cep = c.getEndereco().getCep(); 
	        String endereco = c.getEndereco().getEndereco(); 
	        String numero = c.getEndereco().getNumero();
	        String bairro = c.getEndereco().getBairro();
	        String cidade = c.getEndereco().getCidade();
	        String uf = c.getEndereco().getUf();
	
	        // INSERIR DADOS EM UM NOVO ARRAY
	        Object[] novoCliente = new Object[] {
	            codigo,
	            nome,
	            email,
	            cpf,
	            cep,
	            endereco,
	            numero,
	            bairro,
	            cidade,
	            uf
	        };
	
	        // ADICIONANDO DADOS ENCONTRADOS NA TABELA
	        tabelaClientes.addRow(novoCliente);
    	}
    }                                                                                                                 

    private void controleClienteBtnListarTodosClique(ActionEvent evento) {                                                              
        DefaultTableModel tabelaClientes = (DefaultTableModel) controleClienteTblClientes.getModel(); // PEGANDO MODELO DA TABELA
    	List<Cliente> todosClientes = controleCliente.obterTodosClientes(); // PEGANDO TODOS OS CLIENTES DO BANCO DE DADOS
    	
    	// REMOVENDO DADOS DA TABELA
        while (controleClienteTblClientes.getModel().getRowCount() > 0) {  
               ((DefaultTableModel) controleClienteTblClientes.getModel()).setRowCount(0);  
        }

        // INSERINDO CADA CLIENTE NA TABELA
    	for(Cliente c: todosClientes) {
            // PEGANDO DADOS
            Integer codigo = c.getId(); 
            String nome = c.getNome();
            String email = c.getEmail(); 
            String cpf = c.getCpf();
            String cep = c.getEndereco().getCep(); 
            String endereco = c.getEndereco().getEndereco(); 
            String numero = c.getEndereco().getNumero();
            String bairro = c.getEndereco().getBairro();
            String cidade = c.getEndereco().getCidade();
            String uf = c.getEndereco().getUf();

            // INSERIR DADOS NUM NOVO ARRAY
            Object[] novoCliente = new Object[] {
                codigo,
                nome,
                email,
                cpf,
                cep,
                endereco,
                numero,
                bairro,
                cidade,
                uf
            };

            // NOVA LINHA TABELA
            tabelaClientes.addRow(novoCliente);
    	}	
    }                                                                                                                   

    private void controleClienteEstadosActionPerformed(ActionEvent evento) {                                                       
	        String estadoSelecionado = controleClienteEstados.getSelectedItem().toString();
	        controleClienteInputUF.setText(estadoSelecionado);
    }                                                                    
}