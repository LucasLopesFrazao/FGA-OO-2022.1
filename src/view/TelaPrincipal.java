package view;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.WindowConstants;


public class TelaPrincipal extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	
	private JMenuItem menuControleClientes = new JMenuItem();
    private JMenuItem menuControleFuncionarios = new JMenuItem();
    private JMenuItem menuControleProdutos = new JMenuItem();
    private JMenuItem menuVendaConsultaId = new JMenuItem();
    private JMenuItem menuVendaConsultarVendas = new JMenuItem();
    private JMenuItem menuVendaRealizarVendas = new JMenuItem();
    private JLabel principalFundoImagem = new JLabel();
    private JMenuBar principalMenu = new JMenuBar();
    private JMenu principalMenuClientes = new JMenu();
    private JMenu principalMenuFuncionarios = new JMenu();
    private JMenu principalMenuProdutos = new JMenu();
    private JMenu principalMenuVendas = new JMenu();
	private ImageIcon imagemPrincipal = new ImageIcon(getClass().getResource("/Imagens/fundo2.png"));
	
    public TelaPrincipal() {
    	//CONFIGURAÇÕES INICIAIS
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de controle de Vendas");
        setLocation(new Point(300, 150));
        setResizable(false);
        
        principalFundoImagem.setIcon(imagemPrincipal);

        //MENU CLIENTE
        principalMenuClientes.setText("Clientes");
        menuControleClientes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        menuControleClientes.setText("Controle de clientes");
        menuControleClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                menuControleClientesClique(evento);
            }
        });
        principalMenuClientes.add(menuControleClientes);
        principalMenu.add(principalMenuClientes);

        //VENDEDOR
        principalMenuFuncionarios.setText("Funcionarios");
        menuControleFuncionarios.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_DOWN_MASK));
        menuControleFuncionarios.setText("Controle de funcionarios");
        menuControleFuncionarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                menuControleFuncionariosClique(evento);
            }
        });
        principalMenuFuncionarios.add(menuControleFuncionarios);
        principalMenu.add(principalMenuFuncionarios);

        //PRODUTOS
        principalMenuProdutos.setText("Produtos");
        menuControleProdutos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
        menuControleProdutos.setText("Controle de produtos");
        menuControleProdutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                menuControleProdutosClique(evento);
            }
        });
        principalMenuProdutos.add(menuControleProdutos);
        principalMenu.add(principalMenuProdutos);

        //VENDAS
        principalMenuVendas.setText("Vendas");
        menuVendaRealizarVendas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
        menuVendaRealizarVendas.setText("Realizar venda");
        menuVendaRealizarVendas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                menuVendaRealizarVendasClique(evento);
            }
        });
        principalMenuVendas.add(menuVendaRealizarVendas);
        menuVendaConsultarVendas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.ALT_DOWN_MASK | InputEvent.CTRL_DOWN_MASK));
        menuVendaConsultarVendas.setText("Consultar Vendas por data");
        menuVendaConsultarVendas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                menuVendaConsultarVendasClique(evento);
            }
        });
        principalMenuVendas.add(menuVendaConsultarVendas);
        menuVendaConsultaId.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.ALT_DOWN_MASK));
        menuVendaConsultaId.setText("Consultar Venda por id");
        menuVendaConsultaId.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                menuVendaConsultaIdClique(evento);
            }
        });
        principalMenuVendas.add(menuVendaConsultaId);
        principalMenu.add(principalMenuVendas);

        //MENU PRINCIPAL
        setJMenuBar(principalMenu);

        //LAYOUT
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(principalFundoImagem, GroupLayout.PREFERRED_SIZE, 543, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(principalFundoImagem, GroupLayout.PREFERRED_SIZE, 286, Short.MAX_VALUE)
        );

        pack();
    }
                       
    private void menuControleClientesClique(ActionEvent evento) {                                                     
        TelaCliente controleCliente = new TelaCliente(this, true);
        controleCliente.pack();
        controleCliente.setVisible(true);
    }                                                                                                       

    private void menuControleFuncionariosClique(ActionEvent evento) {                                                         
        TelaVendedor controleFuncionario = new TelaVendedor(this, true);
        controleFuncionario.pack();
        controleFuncionario.setVisible(true);
    }                                                        

    private void menuControleProdutosClique(ActionEvent evento) {                                                     
        TelaProduto controleProduto = new TelaProduto(this, true);
        controleProduto.pack();
        controleProduto.setVisible(true);
    }                                                    

    private void menuVendaRealizarVendasClique(ActionEvent evento) {                                                        
        TelaRealizarVenda realizarVenda = new TelaRealizarVenda(this, true);
        realizarVenda.pack();
        realizarVenda.setVisible(true);
    }                                                       

    private void menuVendaConsultarVendasClique(ActionEvent evento) {                                                         
        TelaConsultarVenda consultarVenda = new TelaConsultarVenda(this, true);
        consultarVenda.pack();
        consultarVenda.setVisible(true);
    }                                                        

    private void menuVendaConsultaIdClique(ActionEvent evento) {                                                    
    	TelaVizualizarVendaUnica consultarVendaUnica = new TelaVizualizarVendaUnica(this, true);
    	consultarVendaUnica.pack();
    	consultarVendaUnica.setVisible(true);
    }                                                   

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }          
}