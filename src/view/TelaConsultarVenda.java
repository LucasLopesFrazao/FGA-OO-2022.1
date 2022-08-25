package view;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import application.Main;
import controle.ControleVenda;
import modelo.Venda;

/**
 * Classe responsável por gerar todo o frontend relacionado com a consulta de {@link Venda} e interagir com o {@link ControleVenda}.
 * A classe é responsável pela listagem de {@link Venda}.
 * Existe 2 inputs de datas e uma tabela, onde as vendas que aparecem são equivalentes ao intervalo das datas digitadas.
 * 
 * @see Venda
 * @see ControleVenda
 * @version 1.0
 * @since 1.0
 * @author Lucas L. Frazão - 211031771
 */
public class TelaConsultarVenda extends JDialog {
	private JButton ConsultarVendaBtnPesquisar = new JButton();
    private JFormattedTextField ConsultarVendaDataFinal = new JFormattedTextField();
    private JFormattedTextField ConsultarVendaDataInicial = new JFormattedTextField();
    private JPanel ConsultarVendaPanelConsulta = new JPanel();
    private JTable ConsultarVendaTblVendas = new JTable();
    private JLabel TextoDataInicial = new JLabel();
    private JLabel TextoDataFinal = new JLabel();
    private JLabel TextoConsultarVenda = new JLabel();
    private JScrollPane jScrollPane1 = new JScrollPane();
	
	private static final long serialVersionUID = 1L;
	
	ControleVenda controleVenda = Main.controleVenda;

    /**
     * Construtor padrão da classe, contém todo o desenho do frontend do projeto relacionado a consulta de {@link Venda}
     */
    public TelaConsultarVenda(Frame parent, boolean modal) {
        super(parent, modal);
   
    	// O QUE FAZER QUANDO FECHAR, TITULO, LOCALIZAÇÃO E SEM REDIMENSIONAMENTO
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Controle de clientes");
        setLocation(new Point(300, 150));
        setResizable(false);

        // FONTES
        TextoConsultarVenda.setFont(new Font("Segoe UI", 1, 24));
        TextoConsultarVenda.setText("Consultar vendas");

        TextoDataInicial.setFont(new Font("Segoe UI", 1, 18));
        TextoDataInicial.setText("Data inicial:");
        
        TextoDataFinal.setFont(new Font("Segoe UI", 1, 18));
        TextoDataFinal.setText("Data fim:");

        //BORDAS
        ConsultarVendaPanelConsulta.setBorder(BorderFactory.createTitledBorder(null, "Consultar por data", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Segoe UI", 1, 18)));

        // BOTÃO PESQUISAR
        ConsultarVendaBtnPesquisar.setFont(new Font("Segoe UI", 1, 18));
        ConsultarVendaBtnPesquisar.setText("Pesquisar");
        ConsultarVendaBtnPesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ConsultarVendaBtnPesquisarClique(evt);
            }
        });

        //MASCARÁ EM CAMPOS
        try {
            ConsultarVendaDataInicial.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
            ConsultarVendaDataFinal.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ConsultarVendaDataInicial.setFont(new Font("Segoe UI", 1, 18));
        ConsultarVendaDataFinal.setFont(new Font("Segoe UI", 1, 18));

        // TABELA DE VENDAS CONSULTADAS
        ConsultarVendaTblVendas.setModel(new DefaultTableModel(
    		new Object [][] {
    			
    		},
    		new String [] {
    				"Código", "Data da venda", "Cliente", "Funcionário", "Total da venda"
    		}
        ));
        //SCROLLPANE PARA A TABELA
        jScrollPane1.setViewportView(ConsultarVendaTblVendas);
        
        //LAYOUTS
        GroupLayout ConsultarVendaPanelConsultaLayout = new GroupLayout(ConsultarVendaPanelConsulta);
        ConsultarVendaPanelConsulta.setLayout(ConsultarVendaPanelConsultaLayout);
        ConsultarVendaPanelConsultaLayout.setHorizontalGroup(ConsultarVendaPanelConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarVendaPanelConsultaLayout.createSequentialGroup()
            .addGroup(ConsultarVendaPanelConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarVendaPanelConsultaLayout.createSequentialGroup()
            .addGap(59, 59, 59)
            .addComponent(TextoDataInicial)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(ConsultarVendaDataInicial, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(TextoDataFinal)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(ConsultarVendaDataFinal, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
            .addGroup(ConsultarVendaPanelConsultaLayout.createSequentialGroup()
            .addGap(259, 259, 259)
            .addComponent(ConsultarVendaBtnPesquisar)))
            .addContainerGap(70, Short.MAX_VALUE))
        );

        ConsultarVendaPanelConsultaLayout.setVerticalGroup(ConsultarVendaPanelConsultaLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(ConsultarVendaPanelConsultaLayout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addGroup(ConsultarVendaPanelConsultaLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(TextoDataInicial)
            .addComponent(TextoDataFinal)
            .addComponent(ConsultarVendaDataInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(ConsultarVendaDataFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(ConsultarVendaBtnPesquisar)
            .addContainerGap(15, Short.MAX_VALUE))
        );
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(228, 228, 228)
            .addComponent(TextoConsultarVenda))
            .addGroup(layout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .addComponent(jScrollPane1)
            .addComponent(ConsultarVendaPanelConsulta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(TextoConsultarVenda)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(ConsultarVendaPanelConsulta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        //DEFININDO O CALENDARIO INICIAL
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        ConsultarVendaDataFinal.setText(sdf.format(c.getTime()));
        
        c.add(Calendar.YEAR, -1);
        Date dataUmAnoAtras = c.getTime();
        ConsultarVendaDataInicial.setText(sdf.format(dataUmAnoAtras));
        ConsultarVendaBtnPesquisarClique(null);
    }                      

    /**
     * Botão responsável por pesquisar todas vendas no {@link ControleVenda} no intervalo fornecido.
     */
    public void ConsultarVendaBtnPesquisarClique(ActionEvent evt) {                                                            
        try {        	
        	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        	Date dataInicial = formato.parse(ConsultarVendaDataInicial.getText());
        	Date dataFinal = formato.parse(ConsultarVendaDataFinal.getText());
        	Calendar cal = Calendar.getInstance();
        	cal.setTime(dataFinal);
        	cal.add(Calendar.DATE, +1);
        	dataFinal = cal.getTime();
        	
        	List<Venda> vendasConsultadas = controleVenda.consultarVendaComData(dataInicial, dataFinal);		
    		DefaultTableModel tabelaVendas = (DefaultTableModel) ConsultarVendaTblVendas.getModel();
    		// REMOVENDO DADOS DA TABELA
            while (ConsultarVendaTblVendas.getModel().getRowCount() > 0) {  
                   ((DefaultTableModel) ConsultarVendaTblVendas.getModel()).setRowCount(0);  
            }
            
            SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
            
            for(Venda v: vendasConsultadas) {
                // PEGANDO DADOS
                Integer codigo = v.getId(); 
                String data = out.format(v.getDataVenda());
                String nomeCliente = v.getCliente().getNome();
                String funcionario = v.getVendedor().getNome();
                String preco = String.format("%.2f", v.getValorVenda());

                // INSERIR DADOS NUM NOVO ARRAY
                Object[] novaVenda = new Object[] {
                    codigo,
                    data,
                    nomeCliente,
                    funcionario,
                    preco
                };

                // NOVA LINHA TABELA
                tabelaVendas.addRow(novaVenda);
        	}
        } catch (ParseException e) {

        }
    }  
             
}
