package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import application.Main;
import controle.ControleCliente;
import controle.ControleProduto;
import controle.ControleVenda;
import controle.ControleVendedor;
import exceptions.CampoEmBrancoException;
import exceptions.CarrinhoException;
import exceptions.EstoqueException;
import exceptions.IdProdutoException;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;
import modelo.Venda;
import modelo.Vendedor;

/**
 * Classe responsável por gerar todo o frontend relacionado com a realização de uma {@link Venda} e interagir com o {@link ControleVenda}, {@link ControleProduto}, {@link ControleCliente}, {@link ControleVendedor}.
 * A classe é responsável pela realização de uma nova {@link Venda}.
 * Existe 1 botão para pesquisar um {@link Cliente}, 1 botão para pesquisar {@link Vendedor} e uma área para pesquisar/adicionar {@link Produto} em um carrinho e finalmente, 1 botão para concluir a venda ou cancelar.
 * 
 * @see Venda
 * @see Produto
 * @see Cliente
 * @see Vendedor
 * @see ControleVenda
 * @see ControleCliente
 * @see ControleVendedor
 * @see ControleProduto
 * @version 1.0
 * @since 1.0
 * @author Lucas L. Frazão - 211031771
 */
public class TelaRealizarVenda extends JDialog {
	
    private JButton RealizarVendaBtnAdicionarCarrinho = new JButton();
    private JButton RealizarVendaBtnCancelarVenda = new JButton();
    private JButton RealizarVendaBtnPesquisarCliente = new JButton();
    private JButton RealizarVendaBtnPesquisarProduto = new JButton();
    private JButton RealizarVendaBtnPesquisarVendedor = new JButton();
    private JButton RealizarVendaBtnRealizarVenda = new JButton();
    private JFormattedTextField RealizarVendaInputCPF = new JFormattedTextField();
    private JTextField RealizarVendaInputCodProduto = new JTextField();
    private JTextField RealizarVendaInputNomeCliente = new JTextField();
    private JTextField RealizarVendaInputNomeProduto = new JTextField();
    private JTextField RealizarVendaInputNomeVendedor = new JTextField();
    private JTextField RealizarVendaInputPrecoProduto = new JTextField();
    private JTextField RealizarVendaInputQtdProduto = new JTextField();
    private JTextField RealizarVendaInputTotalVendaInput = new JTextField();
    private JPanel RealizarVendaPanelCliente = new JPanel();
    private JPanel RealizarVendaPanelProdutos = new JPanel();
    private JPanel RealizarVendaPanelTbl = new JPanel();
    private JPanel RealizarVendaPanelTotalVenda = new JPanel();
    private JPanel RealizarVendaPanelVendedor = new JPanel();
    private JTable RealizarVendaTblCarrinho = new JTable();
    private JLabel TextoPreco = new JLabel();
    private JLabel TextoQuantidade = new JLabel();
    private JLabel TextoTotalVenda = new JLabel();
    private JLabel TextoNome3 = new JLabel();
    private JLabel TextoRealizarVenda = new JLabel();
    private JLabel TextoCPF = new JLabel();
    private JLabel Codigo = new JLabel();
    private JLabel TextoNome2 = new JLabel();
    private JLabel TextoNome = new JLabel();
    private JScrollPane jScrollPane1 = new JScrollPane();
	
	private static final long serialVersionUID = 1L;
	
	//CONTROLES
    ControleCliente controleCliente = Main.controleCliente;
    ControleVendedor controleVendedor = Main.controleVendedor;
    ControleProduto controleProduto = Main.controleProduto;
    ControleVenda controleVenda = Main.controleVenda;

    /**
     * Construtor padrão da classe, contém todo o desenho do frontend do projeto relacionado a realização de uma {@link Venda}.
     */
    public TelaRealizarVenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        // O QUE FAZER QUANDO FECHAR, TITULO, LOCALIZAÇÃO E SEM REDIMENSIONAMENTO	
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Realizar Venda");
        setLocation(new java.awt.Point(200, 50));
        
        // CONFIGURANDO TEXTOS
        TextoRealizarVenda.setFont(new java.awt.Font("Segoe UI", 1, 24));
        TextoRealizarVenda.setText("REALIZAR VENDA");

        TextoTotalVenda.setFont(new java.awt.Font("Segoe UI", 1, 18));
        TextoTotalVenda.setText("TOTAL DA VENDA:");

        RealizarVendaInputTotalVendaInput.setEditable(false);
        RealizarVendaInputTotalVendaInput.setFont(new java.awt.Font("Segoe UI", 1, 18));
        RealizarVendaInputTotalVendaInput.setText("0.0");
        
        Codigo.setText("Código:");

        TextoNome.setText("Nome:");
        
        TextoPreco.setText("Preço:");
        
        TextoQuantidade.setText("Quantidade:");

        TextoNome2.setText("Nome:");

        TextoNome3.setText("Nome:");
        
        TextoCPF.setText("CPF:");

        //BORDAS
        RealizarVendaPanelTbl.setBorder(BorderFactory.createTitledBorder(null, "Carrinho de compras", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18)));
        RealizarVendaPanelTotalVenda.setBorder(BorderFactory.createTitledBorder(null, "Total da venda", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18)));
        RealizarVendaPanelProdutos.setBorder(BorderFactory.createTitledBorder(null, "Dados do produto", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18)));
        RealizarVendaPanelVendedor.setBorder(BorderFactory.createTitledBorder(null, "Dados do vendedor", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18)));
        RealizarVendaPanelCliente.setBorder(BorderFactory.createTitledBorder(null, "Dados do cliente", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18)));

        //TABELA DO CARRINHO
        RealizarVendaTblCarrinho.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Quantidade", "Preço", "Subtotal"
            }
        ));
        //SCROLLPANE PARA O CARRINHO DE COMPRA
        jScrollPane1.setViewportView(RealizarVendaTblCarrinho);

        //BOTÕES
        RealizarVendaBtnPesquisarProduto.setText("Pesquisar");
        RealizarVendaBtnPesquisarProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                RealizarVendaBtnPesquisarProdutoClique(evento);
            }
        });

        //BOTÃO ADICIONAR NO CARRINHO
        RealizarVendaBtnAdicionarCarrinho.setFont(new java.awt.Font("Segoe UI", 1, 12));
        RealizarVendaBtnAdicionarCarrinho.setText("Adicionar ao carrinho");
        RealizarVendaBtnAdicionarCarrinho.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evento) {
        		RealizarVendaBtnAdicionarCarrinhoClique(evento);
        	}
        });

        //BOTÃO PESQUISAR VENDEDOR
        RealizarVendaBtnPesquisarVendedor.setText("Pesquisar");
        RealizarVendaBtnPesquisarVendedor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evento) {
        		RealizarVendaBtnPesquisarVendedorClique(evento);
        	}
        });

        //BOTÃO CANCELAR VENDA
        RealizarVendaBtnCancelarVenda.setFont(new java.awt.Font("Segoe UI", 1, 14));
        RealizarVendaBtnCancelarVenda.setText("CANCELAR VENDA");
        RealizarVendaBtnCancelarVenda.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evento) {
        		RealizarVendaBtnCancelarVendaClique(evento);
        	}
        });

        //BOTÃO PESQUISAR CLIENTE
        RealizarVendaBtnPesquisarCliente.setText("Pesquisar");
        RealizarVendaBtnPesquisarCliente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evento) {
        		RealizarVendaBtnPesquisarClienteClique(evento);
        	}
        });

        //BOTÃO REALIZAR VENDA
        RealizarVendaBtnRealizarVenda.setFont(new java.awt.Font("Segoe UI", 1, 14));
        RealizarVendaBtnRealizarVenda.setText("REALIZAR VENDA");
        RealizarVendaBtnRealizarVenda.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evento) {
        		RealizarVendaBtnRealizarVendaClique(evento);
        	}
        });

        // CONFIGURANDO INPUTS
        //DESLIGANDO INPUTS
        RealizarVendaInputNomeProduto.setEditable(false);
        RealizarVendaInputPrecoProduto.setEditable(false);
        RealizarVendaInputNomeCliente.setEditable(false);
        
        //APLICANDO MASCARA NOS INPUTS
        try {
        	RealizarVendaInputCPF.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
        	ex.printStackTrace();
        }
        
        GroupLayout RealizarVendaPanelTblLayout = new GroupLayout(RealizarVendaPanelTbl);
        RealizarVendaPanelTbl.setLayout(RealizarVendaPanelTblLayout);
        RealizarVendaPanelTblLayout.setHorizontalGroup(RealizarVendaPanelTblLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        
        RealizarVendaPanelTblLayout.setVerticalGroup(
            RealizarVendaPanelTblLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
        );
        
        GroupLayout RealizarVendaPanelTotalVendaLayout = new GroupLayout(RealizarVendaPanelTotalVenda);
        RealizarVendaPanelTotalVenda.setLayout(RealizarVendaPanelTotalVendaLayout);
        RealizarVendaPanelTotalVendaLayout.setHorizontalGroup(RealizarVendaPanelTotalVendaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(RealizarVendaPanelTotalVendaLayout.createSequentialGroup()
	        .addGap(103, 103, 103)
	        .addComponent(TextoTotalVenda)
	        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	        .addComponent(RealizarVendaInputTotalVendaInput, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
	        .addContainerGap(118, Short.MAX_VALUE))
        );
        RealizarVendaPanelTotalVendaLayout.setVerticalGroup(RealizarVendaPanelTotalVendaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(RealizarVendaPanelTotalVendaLayout.createSequentialGroup()
            .addGap(38, 38, 38)
            .addGroup(RealizarVendaPanelTotalVendaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(TextoTotalVenda)
            .addComponent(RealizarVendaInputTotalVendaInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addContainerGap(43, Short.MAX_VALUE))
        );
        
        GroupLayout RealizarVendaPanelProdutosLayout = new GroupLayout(RealizarVendaPanelProdutos);
        RealizarVendaPanelProdutos.setLayout(RealizarVendaPanelProdutosLayout);
        RealizarVendaPanelProdutosLayout.setHorizontalGroup(RealizarVendaPanelProdutosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(RealizarVendaPanelProdutosLayout.createSequentialGroup()
			.addContainerGap()
			.addGroup(RealizarVendaPanelProdutosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(RealizarVendaPanelProdutosLayout.createSequentialGroup()
			.addComponent(Codigo)
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(RealizarVendaInputCodProduto, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(RealizarVendaBtnPesquisarProduto))
			.addGroup(GroupLayout.Alignment.TRAILING, RealizarVendaPanelProdutosLayout.createSequentialGroup()
			.addGroup(RealizarVendaPanelProdutosLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
			.addGroup(RealizarVendaPanelProdutosLayout.createSequentialGroup()
			.addComponent(TextoPreco)
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			.addGroup(RealizarVendaPanelProdutosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(RealizarVendaPanelProdutosLayout.createSequentialGroup()
			.addGap(2, 2, 2)
			.addComponent(RealizarVendaInputPrecoProduto, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(TextoQuantidade)
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(RealizarVendaInputQtdProduto))
			.addComponent(RealizarVendaBtnAdicionarCarrinho, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
			.addGroup(RealizarVendaPanelProdutosLayout.createSequentialGroup()
			.addComponent(TextoNome)
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(RealizarVendaInputNomeProduto)))
			.addGap(1, 1, 1)))
			.addGap(16, 16, 16))
        );
        RealizarVendaPanelProdutosLayout.setVerticalGroup(RealizarVendaPanelProdutosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(RealizarVendaPanelProdutosLayout.createSequentialGroup()
			.addGroup(RealizarVendaPanelProdutosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			.addComponent(Codigo)
			.addComponent(RealizarVendaBtnPesquisarProduto)
			.addComponent(RealizarVendaInputCodProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addGroup(RealizarVendaPanelProdutosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			.addComponent(TextoNome)
			.addComponent(RealizarVendaInputNomeProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addGroup(RealizarVendaPanelProdutosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(RealizarVendaPanelProdutosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			.addComponent(TextoPreco)
			.addComponent(RealizarVendaInputPrecoProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addGroup(RealizarVendaPanelProdutosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			.addComponent(TextoQuantidade)
			.addComponent(RealizarVendaInputQtdProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
			.addComponent(RealizarVendaBtnAdicionarCarrinho, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
			.addContainerGap())
        );
        
        GroupLayout RealizarVendaPanelVendedorLayout = new GroupLayout(RealizarVendaPanelVendedor);
        RealizarVendaPanelVendedor.setLayout(RealizarVendaPanelVendedorLayout);
        RealizarVendaPanelVendedorLayout.setHorizontalGroup(RealizarVendaPanelVendedorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(RealizarVendaPanelVendedorLayout.createSequentialGroup()
			.addContainerGap()
			.addComponent(TextoNome2)
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(RealizarVendaBtnPesquisarVendedor)
			.addGap(18, 18, 18))
			.addGroup(RealizarVendaPanelVendedorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(RealizarVendaPanelVendedorLayout.createSequentialGroup()
			.addGap(56, 56, 56)
			.addComponent(RealizarVendaInputNomeVendedor, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
			.addContainerGap(105, Short.MAX_VALUE)))
        );
        
        RealizarVendaPanelVendedorLayout.setVerticalGroup(RealizarVendaPanelVendedorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(RealizarVendaPanelVendedorLayout.createSequentialGroup()
			.addGap(16, 16, 16)
			.addGroup(RealizarVendaPanelVendedorLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			.addComponent(TextoNome2)
			.addComponent(RealizarVendaBtnPesquisarVendedor))
			.addContainerGap(20, Short.MAX_VALUE))
			.addGroup(RealizarVendaPanelVendedorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(RealizarVendaPanelVendedorLayout.createSequentialGroup()
			.addGap(18, 18, 18)
			.addComponent(RealizarVendaInputNomeVendedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addContainerGap(18, Short.MAX_VALUE)))
        );
        
        GroupLayout RealizarVendaPanelClienteLayout = new GroupLayout(RealizarVendaPanelCliente);
        RealizarVendaPanelCliente.setLayout(RealizarVendaPanelClienteLayout);
        RealizarVendaPanelClienteLayout.setHorizontalGroup(RealizarVendaPanelClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(RealizarVendaPanelClienteLayout.createSequentialGroup()
			.addContainerGap()
			.addGroup(RealizarVendaPanelClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addComponent(TextoNome3)
			.addComponent(TextoCPF))
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			.addGroup(RealizarVendaPanelClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(RealizarVendaPanelClienteLayout.createSequentialGroup()
			.addComponent(RealizarVendaInputCPF)
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			.addComponent(RealizarVendaBtnPesquisarCliente))
			.addComponent(RealizarVendaInputNomeCliente))
			.addGap(17, 17, 17))
        );
        
        RealizarVendaPanelClienteLayout.setVerticalGroup(RealizarVendaPanelClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(RealizarVendaPanelClienteLayout.createSequentialGroup()
			.addContainerGap()
			.addGroup(RealizarVendaPanelClienteLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
			.addComponent(TextoCPF)
			.addComponent(RealizarVendaInputCPF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addComponent(RealizarVendaBtnPesquisarCliente))
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			.addGroup(RealizarVendaPanelClienteLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addComponent(TextoNome3)
			.addComponent(RealizarVendaInputNomeCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addContainerGap(20, Short.MAX_VALUE))
        );
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        	.addGroup(layout.createSequentialGroup()
        	.addGap(336, 336, 336)
        	.addComponent(TextoRealizarVenda)
        	.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			.addGroup(layout.createSequentialGroup()
			.addContainerGap()
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
			.addComponent(RealizarVendaPanelCliente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(RealizarVendaPanelVendedor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(RealizarVendaPanelProdutos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
			.addGap(18, 18, Short.MAX_VALUE)
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addComponent(RealizarVendaPanelTbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addGroup(layout.createSequentialGroup()
			.addComponent(RealizarVendaPanelTotalVenda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addGap(0, 0, Short.MAX_VALUE)))
			.addGap(17, 17, 17))
			.addGroup(layout.createSequentialGroup()
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(RealizarVendaBtnCancelarVenda)
			.addGap(37, 37, 37)
			.addComponent(RealizarVendaBtnRealizarVenda, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
			.addGap(128, 128, 128))))
        );
        
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
			.addGap(4, 4, 4)
			.addComponent(TextoRealizarVenda)
			.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
			.addGroup(layout.createSequentialGroup()
			.addComponent(RealizarVendaPanelTbl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(RealizarVendaPanelTotalVenda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addGroup(layout.createSequentialGroup()
			.addComponent(RealizarVendaPanelCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addComponent(RealizarVendaPanelVendedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(RealizarVendaPanelProdutos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
			.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
			.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			.addComponent(RealizarVendaBtnRealizarVenda, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			.addComponent(RealizarVendaBtnCancelarVenda, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
			.addContainerGap())
        );        
    }
    
    /**
     * Botão responsável por pesquisar um {@link Cliente}.
     * Pesquisa um {@link Cliente} no {@link ControleCliente} por meio de um CPF digitado.
     */
    public void RealizarVendaBtnPesquisarClienteClique(ActionEvent evento) {                                                                 
        Cliente c = controleCliente.pesquisarClientePorCPF(RealizarVendaInputCPF.getText()); // PESQUISANDO CLIENTE POR CPF NO BANCO DE DADOS
        RealizarVendaInputNomeCliente.setText(c.getNome()); // ADICIONANDO AO INPUT
    }                                                                

    /**
     * Botão responsável por pesquisar um {@link Vendedor}.
     * Pesquisa um {@link Vendedor} no {@link controleVenda} por meio de um nome digitado.
     */
    public void RealizarVendaBtnPesquisarVendedorClique(ActionEvent evento) {                                                                  
        Vendedor v = controleVendedor.pesquisarPorNome(RealizarVendaInputNomeVendedor.getText());  // PESQUISANDO VENDEDOR NO BANCO DE DADOS
        RealizarVendaInputNomeVendedor.setText(v.getNome()); // ADICIONANDO AO INPUT
    }                                                                                                                               

    /**
     * Botão responsável por pesquisar um {@link Produto}.
     * Pesquisa um {@link Produto} no {@link ControleProduto} por meio de um codigo digitado.
     * Adiciona o nome e o preço do produto pesquisado nos inputs.
     */
    public void RealizarVendaBtnPesquisarProdutoClique(ActionEvent evento) {     
    	try {
    		Produto p = controleProduto.pesquisarProdutoId(Integer.parseInt(RealizarVendaInputCodProduto.getText())); // PESQUISANDO PRODUTO POR ID NO BANCO DE DADOS
    		controleProduto.checarIdNoSistema(Integer.parseInt(RealizarVendaInputCodProduto.getText())); // CHECANDO SE INPUT DIGITADO EXISTE NO BANCO DE DADOS
    		RealizarVendaInputNomeProduto.setText(p.getNome()); // SETANDO INPUT
    		RealizarVendaInputPrecoProduto.setText(String.format("%.2f", p.getPreco())); // SETANDO INPUT
    	}catch(NumberFormatException | IdProdutoException e) {
    		JOptionPane.showMessageDialog(this, "Código inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
    	}
    }                                                                

    /**
     * Botão responsável por cancelar uma {@link Venda}
     * Fecha a janela e volta o estoque dos produtos adicionados no carrinho.
     */
    public void RealizarVendaBtnCancelarVendaClique(ActionEvent evento) {
    	int totalRows = RealizarVendaTblCarrinho.getRowCount(); // PEGANDO QTD DE LINHAS DA TABELA
    	for(int i = 0; i < totalRows; i++) { // ADICIONANDO O ESTOQUE DE VOLTA
    		Integer cod = (Integer) RealizarVendaTblCarrinho.getModel().getValueAt(i, 0);
    		Integer quantidade = (Integer) RealizarVendaTblCarrinho.getModel().getValueAt(i, 2);
    		controleProduto.aumentarEstoque(cod, quantidade);
    	}
        dispose(); // FECHANDO O PROGRAMA
    }                                                             

    /**
     * Botão responsável por realizar uma {@link Venda}.
     * Valida todos os campos necessários, faz uma List de {@link Pedido} com todos os itens do carrinho e adiciona uma nova {@link Venda} no {@link ControleVenda}.
     */
    public void RealizarVendaBtnRealizarVendaClique(ActionEvent evento) {                                                              
        try {
        	int totalRows = RealizarVendaTblCarrinho.getRowCount(); // PEGANDO QTD DE LINHAS DA TABELA 
        	if(totalRows == 0) { // SE LINHAS FOREM ZERO
        		throw new CarrinhoException("Carrinho vázio!"); 
        	}
        	
        	List<Pedido> pedidos = new ArrayList<>();
        	
        	for(int i = 0; i < totalRows; i++) { // GERANDO UM NOVO PEDIDO DE ACORDO COM A TABELA
        		
        		Integer cod = (Integer) RealizarVendaTblCarrinho.getModel().getValueAt(i, 0);
        		String nome = (String) RealizarVendaTblCarrinho.getModel().getValueAt(i, 1);
        		Integer quantidade = (Integer) RealizarVendaTblCarrinho.getModel().getValueAt(i, 2);
        		Double preco = Double.parseDouble(String.valueOf(RealizarVendaTblCarrinho.getModel().getValueAt(i, 3)).replace(",", "."));
        		Double precoTotal = Double.parseDouble(String.valueOf(RealizarVendaTblCarrinho.getModel().getValueAt(i, 4)).replace(",", "."));
        		Double precoAnterior = preco;
        		
        		Pedido p = new Pedido(new Produto(cod, preco, nome), quantidade, precoTotal, precoAnterior);
        		pedidos.add(p);
        	}
        	
        	Cliente cliente = controleCliente.pesquisarClientePorCPF(RealizarVendaInputCPF.getText()); // PEGANDO CLIENTE 
        	Vendedor vendedor = controleVendedor.pesquisarPorNome(RealizarVendaInputNomeVendedor.getText()); // PEGANDO VENDEDOR
        	if(cliente.getCpf() == null || vendedor.getNome() == null) { // CAMPOS EM BRANCO
        		throw new CampoEmBrancoException(""); 
        	}
        	
        	controleVenda.adicionarVenda(new Venda(
        			controleVenda.ultimoCodigoCadastrado() + 1, 
        			new Date(), 
        			controleVenda.totalVenda(pedidos), 
        			vendedor, 
        			cliente, 
        			pedidos)); // ADICIONANDO VENDA AO BANCO DE DADOS
        	JOptionPane.showMessageDialog(this, "Venda realizada com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE); // MSG SUCESSO
        	dispose(); // FECHANDO PROGRAMA
        } catch(CampoEmBrancoException e) {
        	JOptionPane.showMessageDialog(this, "Campos inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (CarrinhoException e) {
        	JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
    }                                                                                                                      

    /**
     * Botão responsável por adicionar um {@link Produto} no carrinho.
     * Primeiro pega a quantidade do produto pesquisado e valida o estoque, após isso, adiciona no carrinho
     */
    public void RealizarVendaBtnAdicionarCarrinhoClique(ActionEvent evento) {
    	try {
            DefaultTableModel tabelaCarrinho = (DefaultTableModel) RealizarVendaTblCarrinho.getModel(); //MODELO DA TABELA
            
            //PEGANDO INFORMAÇÕES DIGITADAS
        	Integer cod = Integer.parseInt(RealizarVendaInputCodProduto.getText());        	
        	String nome = RealizarVendaInputNomeProduto.getText();
        	Integer qtd = Integer.parseInt(RealizarVendaInputQtdProduto.getText());
        	if(qtd <= 0) {
        		throw new EstoqueException("Quantidade não pode ser 0!"); // QTD IGUAL A ZERO
        	}
        	
        	// PEGANDO VALORES EM REAL E TRANSFORMANDO
        	Double preco = Double.parseDouble(String.valueOf(RealizarVendaInputPrecoProduto.getText()).replace(",", "."));
        	Double total = qtd * preco;
        	String precoReal = String.format("%.2f", Double.parseDouble(String.valueOf(RealizarVendaInputPrecoProduto.getText()).replace(",", ".")));
        	String totalFormatado = String.format("%.2f", total);
        	
        	//DIMINUINDO ESTOQUE
        	controleProduto.diminuirEstoque(cod, qtd);
        	
        	// NOVO ARRAY COM O ITEM
        	Object[] novoItem = new Object[] {
        			cod,
        			nome,
        			qtd,
        			precoReal,
        			totalFormatado
                };
        	
        	tabelaCarrinho.addRow(novoItem); // NOVA LINHA TABELA
        	
        	//MOSTRANDO TOTAL
        	Double precoAnterior = Double.parseDouble(RealizarVendaInputTotalVendaInput.getText().replace(",", "."));
        	Double novoPreco = precoAnterior + total;
        	RealizarVendaInputTotalVendaInput.setText(String.format("%.2f", novoPreco));
        	
        	//APAGANDO CAMPOS
        	RealizarVendaInputCodProduto.setText("");
        	RealizarVendaInputNomeProduto.setText("");
        	RealizarVendaInputPrecoProduto.setText("");
        	RealizarVendaInputQtdProduto.setText("");
    	}catch(NumberFormatException e) {
    		JOptionPane.showMessageDialog(this, "Campos inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
    	} catch (EstoqueException e) {
    		JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
    }                                                                                 
}
