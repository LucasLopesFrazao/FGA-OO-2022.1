package view;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
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

import application.Main;
import controle.ControleVenda;
import exceptions.CampoEmBrancoException;
import modelo.Pedido;
import modelo.Venda;

public class TelaVizualizarVendaUnica extends JDialog {
	ControleVenda controleVenda = Main.controleVenda;

	private static final long serialVersionUID = 1L;
	
	private JPanel ConsultarVendaPanelConsulta = new JPanel();
    private JButton VendaUnicaBtnPesquisar = new JButton();
    private JTextField VendaUnicaInputCliente = new JTextField();
    private JTextField VendaUnicaInputCod = new JTextField();
    private JTextField VendaUnicaInputVendedor = new JTextField();
    private JTextField VendaUnicaPrecoTotal = new JTextField();
    private JTable VendaUnicaTblProdutos = new JTable();
    private JLabel TextoVendedor = new JLabel();
    private JLabel TextoCliente = new JLabel();
    private JLabel TextoTitulo = new JLabel();
    private JLabel TextoTotalVenda = new JLabel();
    private JLabel TextoTabelaProduto = new JLabel();
    private JScrollPane jScrollPane1 = new JScrollPane();

    public TelaVizualizarVendaUnica(Frame parent, boolean modal) {
        super(parent, modal);
        
        // O QUE FAZER QUANDO FECHAR, TITULO, LOCALIZAÇÃO E SEM REDIMENSIONAMENTO
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar venda ID");
        setLocation(new Point(300, 150));
        setResizable(false);
        
        //BORDA
        ConsultarVendaPanelConsulta.setBorder(BorderFactory.createTitledBorder(null, "Dados da venda", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", 1, 18)));

        //CONFIGURANDO TEXTOS
        TextoTitulo.setFont(new Font("Segoe UI", 1, 24));
        TextoTitulo.setText("Consultar venda por ID");

        TextoVendedor.setText("Vendedor:");
        
        TextoCliente.setText("Cliente:");
        
        TextoTotalVenda.setText("Total da venda:");
        
        TextoTabelaProduto.setText("Produtos:");
       
        //"DESLIGANDO" INPUTS
        VendaUnicaInputVendedor.setEditable(false);
        VendaUnicaInputCliente.setEditable(false);
        VendaUnicaPrecoTotal.setEditable(false);

        //BOTÃO PESQUISAR
        VendaUnicaBtnPesquisar.setText("Pesquisar ID");
        VendaUnicaBtnPesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                VendaUnicaBtnPesquisarClique(evento);
            }
        });

        //TABELA DE PRODUTOS
        VendaUnicaTblProdutos.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Quantidade", "Preço", "Subtotal"
            }
        ));
        //SCROLLPANE PARA A TABELA DE PRODUTO
        jScrollPane1.setViewportView(VendaUnicaTblProdutos);

        //LAYOUT
        GroupLayout ConsultarVendaPanelConsultaLayout = new GroupLayout(ConsultarVendaPanelConsulta);
        ConsultarVendaPanelConsulta.setLayout(ConsultarVendaPanelConsultaLayout);
        ConsultarVendaPanelConsultaLayout.setHorizontalGroup(ConsultarVendaPanelConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarVendaPanelConsultaLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(ConsultarVendaPanelConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarVendaPanelConsultaLayout.createSequentialGroup()
            .addComponent(TextoTotalVenda)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(VendaUnicaPrecoTotal, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
            .addGroup(ConsultarVendaPanelConsultaLayout.createSequentialGroup()
            .addComponent(VendaUnicaInputCod, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(VendaUnicaBtnPesquisar))
            .addGroup(GroupLayout.Alignment.TRAILING, ConsultarVendaPanelConsultaLayout.createSequentialGroup()
            .addGroup(ConsultarVendaPanelConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, ConsultarVendaPanelConsultaLayout.createSequentialGroup()
            .addComponent(TextoVendedor)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
            .addGroup(ConsultarVendaPanelConsultaLayout.createSequentialGroup()
            .addComponent(TextoCliente)
            .addGap(20, 20, 20)))
            .addGroup(ConsultarVendaPanelConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .addComponent(VendaUnicaInputCliente)
            .addComponent(VendaUnicaInputVendedor, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
            .addGroup(ConsultarVendaPanelConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
            .addComponent(TextoTabelaProduto))
            .addGap(15, 15, 15))
        );
        
        ConsultarVendaPanelConsultaLayout.setVerticalGroup(ConsultarVendaPanelConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarVendaPanelConsultaLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(ConsultarVendaPanelConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarVendaPanelConsultaLayout.createSequentialGroup()
            .addGroup(ConsultarVendaPanelConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(VendaUnicaBtnPesquisar)
            .addComponent(VendaUnicaInputCod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(ConsultarVendaPanelConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(TextoVendedor)
            .addComponent(VendaUnicaInputVendedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(15, 15, 15)
            .addGroup(ConsultarVendaPanelConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(TextoCliente)
            .addComponent(VendaUnicaInputCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(ConsultarVendaPanelConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(TextoTotalVenda)
            .addComponent(VendaUnicaPrecoTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
            .addGroup(ConsultarVendaPanelConsultaLayout.createSequentialGroup()
            .addComponent(TextoTabelaProduto)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(14, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addComponent(ConsultarVendaPanelConsulta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
            .addGroup(layout.createSequentialGroup()
            .addGap(208, 208, 208)
            .addComponent(TextoTitulo)
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(TextoTitulo)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(ConsultarVendaPanelConsulta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
        );
    }                        

    private void VendaUnicaBtnPesquisarClique(ActionEvent evento) {   
    	try {
    		//MODELO DA TABELA
            DefaultTableModel tabelaPedidos = (DefaultTableModel) VendaUnicaTblProdutos.getModel();
        	
            Integer id = Integer.parseInt(VendaUnicaInputCod.getText());
            if(VendaUnicaInputCod.getText().equals("")) {
            	throw new CampoEmBrancoException("Código inválido!");
            }
            Venda vendaConsultada = controleVenda.consultarVenda(id);
            if(vendaConsultada == null) {
            	throw new CampoEmBrancoException("Código inválido!");            	
            }
            VendaUnicaInputCliente.setText(vendaConsultada.getCliente().getNome());
            VendaUnicaInputVendedor.setText(vendaConsultada.getVendedor().getNome());
            VendaUnicaPrecoTotal.setText(String.valueOf(String.format("%.2f", vendaConsultada.getValorVenda())));
            
            // REMOVENDO DADOS DA TABELA
            while (VendaUnicaTblProdutos.getModel().getRowCount() > 0) {  
                   ((DefaultTableModel) VendaUnicaTblProdutos.getModel()).setRowCount(0);  
            }
            for(Pedido p: vendaConsultada.getCarrinho()) {
            	String preco = String.format("%.2f", p.getProduto().getPreco());
            	String totalFormatado = String.format("%.2f", p.getPrecoTotal());
            	Object[] novoItem = new Object[] {
            			p.getProduto().getId(),
            			p.getProduto().getNome(),
            			p.getQuantidade(),
            			preco,
            			totalFormatado

                    };
            	
            	// NOVA LINHA TABELA
            	tabelaPedidos.addRow(novoItem);
            }
    	}catch (CampoEmBrancoException | NumberFormatException e) {
    		JOptionPane.showMessageDialog(this, "Código inválido", "Erro", JOptionPane.ERROR_MESSAGE);
		}
    }                                                                           
}
