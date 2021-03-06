/*
 * Projeto Ocean - Previsao de Tempo e Mares
 * Engenharia de Software III
 * Faculdade de Tecnologia - UNICAMP
 */
package view;

import control.Controle;
import diu.swe.habib.JPanelSlider.JPanelSlider;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import model.Alerta;
import model.PrevisaoCompleta;

/**
 *
 * @author Daniel
 */
public class TelaPrincipal extends javax.swing.JFrame {
    
    private Point posicao;
    private int active = 0;
    private String dia="";
    
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        UIManager.getDefaults().put("TabbedPane.contentBorderInsets", new Insets(0,1,1,1));
        UIManager.getDefaults().put("TabbedPane.tabsOverlapBorder", true);
        UIManager.getDefaults().put("TabbedPane.contentOpaque", false);
        UIManager.getDefaults().put("ScrollPanelTAbbe.contentOpaque", false);
        
        LocalDateTime localDate = LocalDateTime.now();
        dia = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localDate);
        
        initComponents();
        
        jTextFieldCodCidade.setEditable(false);
        jTextFieldAntCodCidade.setEditable(false);
        jLabelVoltar.setVisible(false);
        jLabelAvancar.setVisible(false);
        jPanelSliderPrevisoes.setVisible(false);
        jPanelSliderAntPrevisoes.setVisible(false);
        jXDatePickerPeriodo.getMonthView().setUpperBound(jXDatePickerPeriodo.getLinkDay());
        jXDatePickerPeriodo.setDate(jXDatePickerPeriodo.getLinkDay());
        jScrollPaneAlertas.getViewport().setBackground(new Color(0, 0, 102));
        updateAlertas();
        getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
        setIcon();
        
        start();
    }
    
    private void start(){
        jLabelAtualizando.setText("Atualizando dados...");
        jProgressBarAtualiza.setIndeterminate(true);
        jButtonAtualiza.setEnabled(false);
        SwingWorker worker = new SwingWorker() {
          @Override
          public Void doInBackground() throws Exception {
              Controle.inicializar();
              return null;
          }
          
          @Override
          public void done(){
              jProgressBarAtualiza.setIndeterminate(false);
              jProgressBarAtualiza.setValue(100);
              jButtonAtualiza.setEnabled(true);
              jLabelAtualizando.setText("Dados atualizados.");
          }
         };

         worker.execute();
    }
    
    public final void updateAlertas(){
        jTableAlertas.setModel(Controle.updateAlertas());
        
        jTableAlertas.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTableAlertas.getColumnModel().getColumn(0).setMinWidth(40);
        jTableAlertas.getColumnModel().getColumn(0).setMaxWidth(40);
        jTableAlertas.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTableAlertas.getColumnModel().getColumn(1).setMaxWidth(100);
        jTableAlertas.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer(){
            JLabel lbl = new JLabel();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
                    String src = null;

                    if(jTableAlertas.getValueAt(row, column).equals("1")){
                        src = "/imagens/moderado.png";
                    }else{
                        src = "/imagens/ruim.png";
                    }                
                    ImageIcon icon = new ImageIcon(getClass().getResource(src));
                    lbl.setIcon(icon);
                    lbl.setSize(25, 40);
                    lbl.setHorizontalAlignment(SwingConstants.CENTER);
                    return lbl;
                }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanelBackground = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jTabbedPanePrevisoes = new javax.swing.JTabbedPane();
        jPanelPrevisoes = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxEstado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxCidade = new javax.swing.JComboBox<>();
        jButtonBuscar = new javax.swing.JButton();
        jButtonRelatorio = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanelSliderPrevisoes = new diu.swe.habib.JPanelSlider.JPanelSlider();
        jPanelDia1 = new javax.swing.JPanel();
        jLabelDia1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelCondicao1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelMaxima1 = new javax.swing.JLabel();
        jLabelMinima1 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabelOndas00h_1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabelVentoVel00h_1 = new javax.swing.JLabel();
        jLabelVentoDir00h_1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabelOndas03h_1 = new javax.swing.JLabel();
        jLabelVentoVel03h_1 = new javax.swing.JLabel();
        jLabelVentoDir03h_1 = new javax.swing.JLabel();
        jLabelOndas06h_1 = new javax.swing.JLabel();
        jLabelVentoVel06h_1 = new javax.swing.JLabel();
        jLabelVentoDir06h_1 = new javax.swing.JLabel();
        jLabelOndas09h_1 = new javax.swing.JLabel();
        jLabelVentoVel09h_1 = new javax.swing.JLabel();
        jLabelVentoDir09h_1 = new javax.swing.JLabel();
        jLabelOndas12h_1 = new javax.swing.JLabel();
        jLabelVentoVel12h_1 = new javax.swing.JLabel();
        jLabelVentoDir12h_1 = new javax.swing.JLabel();
        jLabelOndas15h_1 = new javax.swing.JLabel();
        jLabelVentoVel15h_1 = new javax.swing.JLabel();
        jLabelVentoDir15h_1 = new javax.swing.JLabel();
        jLabelOndas18h_1 = new javax.swing.JLabel();
        jLabelVentoVel18h_1 = new javax.swing.JLabel();
        jLabelVentoDir18h_1 = new javax.swing.JLabel();
        jLabelOndas21h_1 = new javax.swing.JLabel();
        jLabelVentoVel21h_1 = new javax.swing.JLabel();
        jLabelVentoDir21h_1 = new javax.swing.JLabel();
        jPanelDia2 = new javax.swing.JPanel();
        jLabelDia2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabelCondicao2 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabelMaxima2 = new javax.swing.JLabel();
        jLabelMinima2 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabelOndas00h_2 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabelVentoVel00h_2 = new javax.swing.JLabel();
        jLabelVentoDir00h_2 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabelOndas03h_2 = new javax.swing.JLabel();
        jLabelVentoVel03h_2 = new javax.swing.JLabel();
        jLabelVentoDir03h_2 = new javax.swing.JLabel();
        jLabelOndas06h_2 = new javax.swing.JLabel();
        jLabelVentoVel06h_2 = new javax.swing.JLabel();
        jLabelVentoDir06h_2 = new javax.swing.JLabel();
        jLabelOndas09h_2 = new javax.swing.JLabel();
        jLabelVentoVel09h_2 = new javax.swing.JLabel();
        jLabelVentoDir09h_2 = new javax.swing.JLabel();
        jLabelOndas12h_2 = new javax.swing.JLabel();
        jLabelVentoVel12h_2 = new javax.swing.JLabel();
        jLabelVentoDir12h_2 = new javax.swing.JLabel();
        jLabelOndas15h_2 = new javax.swing.JLabel();
        jLabelVentoVel15h_2 = new javax.swing.JLabel();
        jLabelVentoDir15h_2 = new javax.swing.JLabel();
        jLabelOndas18h_2 = new javax.swing.JLabel();
        jLabelVentoVel18h_2 = new javax.swing.JLabel();
        jLabelVentoDir18h_2 = new javax.swing.JLabel();
        jLabelOndas21h_2 = new javax.swing.JLabel();
        jLabelVentoVel21h_2 = new javax.swing.JLabel();
        jLabelVentoDir21h_2 = new javax.swing.JLabel();
        jPanelDia3 = new javax.swing.JPanel();
        jLabelDia3 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabelCondicao3 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabelMaxima3 = new javax.swing.JLabel();
        jLabelMinima3 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabelOndas00h_3 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabelVentoVel00h_3 = new javax.swing.JLabel();
        jLabelVentoDir00h_3 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabelOndas03h_3 = new javax.swing.JLabel();
        jLabelVentoVel03h_3 = new javax.swing.JLabel();
        jLabelVentoDir03h_3 = new javax.swing.JLabel();
        jLabelOndas06h_3 = new javax.swing.JLabel();
        jLabelVentoVel06h_3 = new javax.swing.JLabel();
        jLabelVentoDir06h_3 = new javax.swing.JLabel();
        jLabelOndas09h_3 = new javax.swing.JLabel();
        jLabelVentoVel09h_3 = new javax.swing.JLabel();
        jLabelVentoDir09h_3 = new javax.swing.JLabel();
        jLabelOndas12h_3 = new javax.swing.JLabel();
        jLabelVentoVel12h_3 = new javax.swing.JLabel();
        jLabelVentoDir12h_3 = new javax.swing.JLabel();
        jLabelOndas15h_3 = new javax.swing.JLabel();
        jLabelVentoVel15h_3 = new javax.swing.JLabel();
        jLabelVentoDir15h_3 = new javax.swing.JLabel();
        jLabelOndas18h_3 = new javax.swing.JLabel();
        jLabelVentoVel18h_3 = new javax.swing.JLabel();
        jLabelVentoDir18h_3 = new javax.swing.JLabel();
        jLabelOndas21h_3 = new javax.swing.JLabel();
        jLabelVentoVel21h_3 = new javax.swing.JLabel();
        jLabelVentoDir21h_3 = new javax.swing.JLabel();
        jPanelDia4 = new javax.swing.JPanel();
        jLabelDia4 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabelCondicao4 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabelMaxima4 = new javax.swing.JLabel();
        jLabelMinima4 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel46 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jLabelOndas00h_4 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabelVentoVel00h_4 = new javax.swing.JLabel();
        jLabelVentoDir00h_4 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabelOndas03h_4 = new javax.swing.JLabel();
        jLabelVentoVel03h_4 = new javax.swing.JLabel();
        jLabelVentoDir03h_4 = new javax.swing.JLabel();
        jLabelOndas06h_4 = new javax.swing.JLabel();
        jLabelVentoVel06h_4 = new javax.swing.JLabel();
        jLabelVentoDir06h_4 = new javax.swing.JLabel();
        jLabelOndas09h_4 = new javax.swing.JLabel();
        jLabelVentoVel09h_4 = new javax.swing.JLabel();
        jLabelVentoDir09h_4 = new javax.swing.JLabel();
        jLabelOndas12h_4 = new javax.swing.JLabel();
        jLabelVentoVel12h_4 = new javax.swing.JLabel();
        jLabelVentoDir12h_4 = new javax.swing.JLabel();
        jLabelOndas15h_4 = new javax.swing.JLabel();
        jLabelVentoVel15h_4 = new javax.swing.JLabel();
        jLabelVentoDir15h_4 = new javax.swing.JLabel();
        jLabelOndas18h_4 = new javax.swing.JLabel();
        jLabelVentoVel18h_4 = new javax.swing.JLabel();
        jLabelVentoDir18h_4 = new javax.swing.JLabel();
        jLabelOndas21h_4 = new javax.swing.JLabel();
        jLabelVentoVel21h_4 = new javax.swing.JLabel();
        jLabelVentoDir21h_4 = new javax.swing.JLabel();
        jPanelDia5 = new javax.swing.JPanel();
        jLabelDia5 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabelCondicao5 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabelMaxima5 = new javax.swing.JLabel();
        jLabelMinima5 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel58 = new javax.swing.JLabel();
        jSeparator13 = new javax.swing.JSeparator();
        jLabelOndas00h_5 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabelVentoVel00h_5 = new javax.swing.JLabel();
        jLabelVentoDir00h_5 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabelOndas03h_5 = new javax.swing.JLabel();
        jLabelVentoVel03h_5 = new javax.swing.JLabel();
        jLabelVentoDir03h_5 = new javax.swing.JLabel();
        jLabelOndas06h_5 = new javax.swing.JLabel();
        jLabelVentoVel06h_5 = new javax.swing.JLabel();
        jLabelVentoDir06h_5 = new javax.swing.JLabel();
        jLabelOndas09h_5 = new javax.swing.JLabel();
        jLabelVentoVel09h_5 = new javax.swing.JLabel();
        jLabelVentoDir09h_5 = new javax.swing.JLabel();
        jLabelOndas12h_5 = new javax.swing.JLabel();
        jLabelVentoVel12h_5 = new javax.swing.JLabel();
        jLabelVentoDir12h_5 = new javax.swing.JLabel();
        jLabelOndas15h_5 = new javax.swing.JLabel();
        jLabelVentoVel15h_5 = new javax.swing.JLabel();
        jLabelVentoDir15h_5 = new javax.swing.JLabel();
        jLabelOndas18h_5 = new javax.swing.JLabel();
        jLabelVentoVel18h_5 = new javax.swing.JLabel();
        jLabelVentoDir18h_5 = new javax.swing.JLabel();
        jLabelOndas21h_5 = new javax.swing.JLabel();
        jLabelVentoVel21h_5 = new javax.swing.JLabel();
        jLabelVentoDir21h_5 = new javax.swing.JLabel();
        jPanelDia6 = new javax.swing.JPanel();
        jLabelDia6 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabelCondicao6 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabelMaxima6 = new javax.swing.JLabel();
        jLabelMinima6 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel70 = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        jLabelOndas00h_6 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabelVentoVel00h_6 = new javax.swing.JLabel();
        jLabelVentoDir00h_6 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabelOndas03h_6 = new javax.swing.JLabel();
        jLabelVentoVel03h_6 = new javax.swing.JLabel();
        jLabelVentoDir03h_6 = new javax.swing.JLabel();
        jLabelOndas06h_6 = new javax.swing.JLabel();
        jLabelVentoVel06h_6 = new javax.swing.JLabel();
        jLabelVentoDir06h_6 = new javax.swing.JLabel();
        jLabelOndas09h_6 = new javax.swing.JLabel();
        jLabelVentoVel09h_6 = new javax.swing.JLabel();
        jLabelVentoDir09h_6 = new javax.swing.JLabel();
        jLabelOndas12h_6 = new javax.swing.JLabel();
        jLabelVentoVel12h_6 = new javax.swing.JLabel();
        jLabelVentoDir12h_6 = new javax.swing.JLabel();
        jLabelOndas15h_6 = new javax.swing.JLabel();
        jLabelVentoVel15h_6 = new javax.swing.JLabel();
        jLabelVentoDir15h_6 = new javax.swing.JLabel();
        jLabelOndas18h_6 = new javax.swing.JLabel();
        jLabelVentoVel18h_6 = new javax.swing.JLabel();
        jLabelVentoDir18h_6 = new javax.swing.JLabel();
        jLabelOndas21h_6 = new javax.swing.JLabel();
        jLabelVentoVel21h_6 = new javax.swing.JLabel();
        jLabelVentoDir21h_6 = new javax.swing.JLabel();
        jLabelAvancar = new javax.swing.JLabel();
        jLabelVoltar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCodCidade = new javax.swing.JTextField();
        jPanelPrevisoesAnt = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxAntEstado = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxAntCidade = new javax.swing.JComboBox<>();
        jButtonAntBuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldAntCodCidade = new javax.swing.JTextField();
        jXDatePickerPeriodo = new org.jdesktop.swingx.JXDatePicker();
        jLabel19 = new javax.swing.JLabel();
        jPanelSliderAntPrevisoes = new diu.swe.habib.JPanelSlider.JPanelSlider();
        jPanelDiaAnt = new javax.swing.JPanel();
        jLabelDia7 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabelCondicao7 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabelMaxima7 = new javax.swing.JLabel();
        jLabelMinima7 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel55 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jLabelOndas00h_7 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabelVentoVel00h_7 = new javax.swing.JLabel();
        jLabelVentoDir00h_7 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabelOndas03h_7 = new javax.swing.JLabel();
        jLabelVentoVel03h_7 = new javax.swing.JLabel();
        jLabelVentoDir03h_7 = new javax.swing.JLabel();
        jLabelOndas06h_7 = new javax.swing.JLabel();
        jLabelVentoVel06h_7 = new javax.swing.JLabel();
        jLabelVentoDir06h_7 = new javax.swing.JLabel();
        jLabelOndas09h_7 = new javax.swing.JLabel();
        jLabelVentoVel09h_7 = new javax.swing.JLabel();
        jLabelVentoDir09h_7 = new javax.swing.JLabel();
        jLabelOndas12h_7 = new javax.swing.JLabel();
        jLabelVentoVel12h_7 = new javax.swing.JLabel();
        jLabelVentoDir12h_7 = new javax.swing.JLabel();
        jLabelOndas15h_7 = new javax.swing.JLabel();
        jLabelVentoVel15h_7 = new javax.swing.JLabel();
        jLabelVentoDir15h_7 = new javax.swing.JLabel();
        jLabelOndas18h_7 = new javax.swing.JLabel();
        jLabelVentoVel18h_7 = new javax.swing.JLabel();
        jLabelVentoDir18h_7 = new javax.swing.JLabel();
        jLabelOndas21h_7 = new javax.swing.JLabel();
        jLabelVentoVel21h_7 = new javax.swing.JLabel();
        jLabelVentoDir21h_7 = new javax.swing.JLabel();
        jLabelFechar = new javax.swing.JLabel();
        jLabelMinimizar = new javax.swing.JLabel();
        jPanelAlertas = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jScrollPaneAlertas = new javax.swing.JScrollPane();
        jTableAlertas = new javax.swing.JTable();
        jButtonLimpar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabelAtualizando = new javax.swing.JLabel();
        jProgressBarAtualiza = new javax.swing.JProgressBar();
        jButtonAtualiza = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jButtonRelatorios = new javax.swing.JButton();
        jButtonAjuda = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ocean");
        setBackground(new java.awt.Color(153, 153, 255));
        setUndecorated(true);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        jPanelBackground.setLayout(null);

        jPanel1.setOpaque(false);

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/oceanico.png"))); // NOI18N
        jLabelTitulo.setText("Ocean");
        jLabelTitulo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabelTituloMouseDragged(evt);
            }
        });
        jLabelTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelTituloMousePressed(evt);
            }
        });

        jTabbedPanePrevisoes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPanePrevisoes.setFocusable(false);
        jTabbedPanePrevisoes.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jPanelPrevisoes.setBackground(new java.awt.Color(0, 0, 102));
        jPanelPrevisoes.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Estado:");

        jComboBoxEstado.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alagoas", "Amapá", "Bahia", "Ceará", "Espírito Santo", "Maranhão", "Paraná", "Paraíba", "Pará", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Santa Catarina", "Sergipe", "São Paulo" }));
        jComboBoxEstado.setSelectedItem(null);
        jComboBoxEstado.setFocusable(false);
        jComboBoxEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxEstadoItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cidade:");

        jComboBoxCidade.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxCidade.setSelectedItem(null);
        jComboBoxCidade.setFocusable(false);
        jComboBoxCidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCidadeItemStateChanged(evt);
            }
        });

        jButtonBuscar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setEnabled(false);
        jButtonBuscar.setFocusable(false);
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonRelatorio.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRelatorio.setText("Gerar Relatório");
        jButtonRelatorio.setEnabled(false);
        jButtonRelatorio.setFocusable(false);
        jButtonRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelatorioActionPerformed(evt);
            }
        });

        jPanelSliderPrevisoes.setBackground(new java.awt.Color(0, 0, 102));
        jPanelSliderPrevisoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanelDia1.setBackground(new java.awt.Color(0, 0, 102));
        jPanelDia1.setName("Dia1"); // NOI18N

        jLabelDia1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelDia1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setBackground(new java.awt.Color(0, 0, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Condição Climática:");
        jLabel8.setOpaque(true);

        jLabelCondicao1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelCondicao1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Tempo");

        jLabelMaxima1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMaxima1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMaxima1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/maxima.png"))); // NOI18N
        jLabelMaxima1.setToolTipText("Máxima");

        jLabelMinima1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMinima1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMinima1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/minima.png"))); // NOI18N
        jLabelMinima1.setToolTipText("Mínima");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Ondas");

        jLabelOndas00h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas00h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas00h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas00h_1.setToolTipText("Agitação do Mar");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("00h");

        jLabelVentoVel00h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel00h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel00h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel00h_1.setToolTipText("Velocidade do Vento");

        jLabelVentoDir00h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir00h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir00h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir00h_1.setToolTipText("Direção do Vento");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("03h");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("06h");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("09h");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("12h");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("15h");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("18h");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("21h");

        jLabelOndas03h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas03h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas03h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas03h_1.setToolTipText("Agitação do Mar");

        jLabelVentoVel03h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel03h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel03h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel03h_1.setToolTipText("Velocidade do Vento");

        jLabelVentoDir03h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir03h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir03h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir03h_1.setToolTipText("Direção do Vento");

        jLabelOndas06h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas06h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas06h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas06h_1.setToolTipText("Agitação do Mar");

        jLabelVentoVel06h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel06h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel06h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel06h_1.setToolTipText("Velocidade do Vento");

        jLabelVentoDir06h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir06h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir06h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir06h_1.setToolTipText("Direção do Vento");

        jLabelOndas09h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas09h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas09h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas09h_1.setToolTipText("Agitação do Mar");

        jLabelVentoVel09h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel09h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel09h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel09h_1.setToolTipText("Velocidade do Vento");

        jLabelVentoDir09h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir09h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir09h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir09h_1.setToolTipText("Direção do Vento");

        jLabelOndas12h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas12h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas12h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas12h_1.setToolTipText("Agitação do Mar");

        jLabelVentoVel12h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel12h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel12h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel12h_1.setToolTipText("Velocidade do Vento");

        jLabelVentoDir12h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir12h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir12h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir12h_1.setToolTipText("Direção do Vento");

        jLabelOndas15h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas15h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas15h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas15h_1.setToolTipText("Agitação do Mar");

        jLabelVentoVel15h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel15h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel15h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel15h_1.setToolTipText("Velocidade do Vento");

        jLabelVentoDir15h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir15h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir15h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir15h_1.setToolTipText("Direção do Vento");

        jLabelOndas18h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas18h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas18h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas18h_1.setToolTipText("Agitação do Mar");

        jLabelVentoVel18h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel18h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel18h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel18h_1.setToolTipText("Velocidade do Vento");

        jLabelVentoDir18h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir18h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir18h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir18h_1.setToolTipText("Direção do Vento");

        jLabelOndas21h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas21h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas21h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas21h_1.setToolTipText("Agitação do Mar");

        jLabelVentoVel21h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel21h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel21h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel21h_1.setToolTipText("Velocidade do Vento");

        jLabelVentoDir21h_1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir21h_1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir21h_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir21h_1.setToolTipText("Direção do Vento");

        javax.swing.GroupLayout jPanelDia1Layout = new javax.swing.GroupLayout(jPanelDia1);
        jPanelDia1.setLayout(jPanelDia1Layout);
        jPanelDia1Layout.setHorizontalGroup(
            jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDia1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDia1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCondicao1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabelDia1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelDia1Layout.createSequentialGroup()
                        .addGroup(jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelMinima1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMaxima1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelDia1Layout.createSequentialGroup()
                                .addGroup(jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelOndas00h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelVentoVel00h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelVentoDir00h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDia1Layout.createSequentialGroup()
                                        .addComponent(jLabelOndas03h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas06h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas09h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas12h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas15h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas18h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelOndas21h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDia1Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDia1Layout.createSequentialGroup()
                                        .addGroup(jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel03h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir03h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel06h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir06h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel09h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir09h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel12h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir12h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelDia1Layout.createSequentialGroup()
                                                .addComponent(jLabelVentoDir15h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelVentoDir18h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelVentoDir21h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanelDia1Layout.createSequentialGroup()
                                                .addComponent(jLabelVentoVel15h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelVentoVel18h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelVentoVel21h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jSeparator5))))
                .addContainerGap())
        );
        jPanelDia1Layout.setVerticalGroup(
            jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDia1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCondicao1, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(jLabelDia1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDia1Layout.createSequentialGroup()
                        .addGroup(jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDia1Layout.createSequentialGroup()
                        .addComponent(jLabelMaxima1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelMinima1))
                    .addGroup(jPanelDia1Layout.createSequentialGroup()
                        .addGroup(jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelDia1Layout.createSequentialGroup()
                                .addGroup(jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelOndas00h_1)
                                        .addComponent(jLabelOndas06h_1, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabelOndas09h_1)
                                    .addComponent(jLabelOndas12h_1)
                                    .addComponent(jLabelOndas15h_1)
                                    .addComponent(jLabelOndas18h_1)
                                    .addComponent(jLabelOndas21h_1)))
                            .addComponent(jLabelOndas03h_1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVentoVel00h_1)
                            .addComponent(jLabelVentoVel03h_1)
                            .addComponent(jLabelVentoVel06h_1)
                            .addComponent(jLabelVentoVel09h_1)
                            .addComponent(jLabelVentoVel12h_1)
                            .addComponent(jLabelVentoVel15h_1)
                            .addComponent(jLabelVentoVel18h_1)
                            .addComponent(jLabelVentoVel21h_1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDia1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVentoDir00h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir03h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir06h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir09h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir12h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir15h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir18h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir21h_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );

        jPanelSliderPrevisoes.add(jPanelDia1, "card2");

        jPanelDia2.setBackground(new java.awt.Color(0, 0, 102));
        jPanelDia2.setName("Dia2"); // NOI18N

        jLabelDia2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelDia2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel20.setBackground(new java.awt.Color(0, 0, 255));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Condição Climática:");
        jLabel20.setOpaque(true);

        jLabelCondicao2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelCondicao2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Tempo");

        jLabelMaxima2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMaxima2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMaxima2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/maxima.png"))); // NOI18N
        jLabelMaxima2.setToolTipText("Máxima");

        jLabelMinima2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMinima2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMinima2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/minima.png"))); // NOI18N
        jLabelMinima2.setToolTipText("Mínima");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Ondas");

        jLabelOndas00h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas00h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas00h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas00h_2.setToolTipText("Agitação do Mar");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("00h");

        jLabelVentoVel00h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel00h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel00h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel00h_2.setToolTipText("Velocidade do Vento");

        jLabelVentoDir00h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir00h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir00h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir00h_2.setToolTipText("Direção do Vento");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("03h");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("06h");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("09h");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("12h");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("15h");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("18h");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("21h");

        jLabelOndas03h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas03h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas03h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas03h_2.setToolTipText("Agitação do Mar");

        jLabelVentoVel03h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel03h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel03h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel03h_2.setToolTipText("Velocidade do Vento");

        jLabelVentoDir03h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir03h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir03h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir03h_2.setToolTipText("Direção do Vento");

        jLabelOndas06h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas06h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas06h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas06h_2.setToolTipText("Agitação do Mar");

        jLabelVentoVel06h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel06h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel06h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel06h_2.setToolTipText("Velocidade do Vento");

        jLabelVentoDir06h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir06h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir06h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir06h_2.setToolTipText("Direção do Vento");

        jLabelOndas09h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas09h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas09h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas09h_2.setToolTipText("Agitação do Mar");

        jLabelVentoVel09h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel09h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel09h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel09h_2.setToolTipText("Velocidade do Vento");

        jLabelVentoDir09h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir09h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir09h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir09h_2.setToolTipText("Direção do Vento");

        jLabelOndas12h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas12h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas12h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas12h_2.setToolTipText("Agitação do Mar");

        jLabelVentoVel12h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel12h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel12h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel12h_2.setToolTipText("Velocidade do Vento");

        jLabelVentoDir12h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir12h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir12h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir12h_2.setToolTipText("Direção do Vento");

        jLabelOndas15h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas15h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas15h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas15h_2.setToolTipText("Agitação do Mar");

        jLabelVentoVel15h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel15h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel15h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel15h_2.setToolTipText("Velocidade do Vento");

        jLabelVentoDir15h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir15h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir15h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir15h_2.setToolTipText("Direção do Vento");

        jLabelOndas18h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas18h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas18h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas18h_2.setToolTipText("Agitação do Mar");

        jLabelVentoVel18h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel18h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel18h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel18h_2.setToolTipText("Velocidade do Vento");

        jLabelVentoDir18h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir18h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir18h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir18h_2.setToolTipText("Direção do Vento");

        jLabelOndas21h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas21h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas21h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas21h_2.setToolTipText("Agitação do Mar");

        jLabelVentoVel21h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel21h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel21h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel21h_2.setToolTipText("Velocidade do Vento");

        jLabelVentoDir21h_2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir21h_2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir21h_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir21h_2.setToolTipText("Direção do Vento");

        javax.swing.GroupLayout jPanelDia2Layout = new javax.swing.GroupLayout(jPanelDia2);
        jPanelDia2.setLayout(jPanelDia2Layout);
        jPanelDia2Layout.setHorizontalGroup(
            jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDia2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDia2Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCondicao2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabelDia2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelDia2Layout.createSequentialGroup()
                        .addGroup(jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelMinima2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMaxima2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelDia2Layout.createSequentialGroup()
                                .addGroup(jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelOndas00h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelVentoVel00h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelVentoDir00h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDia2Layout.createSequentialGroup()
                                        .addComponent(jLabelOndas03h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas06h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas09h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas12h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas15h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas18h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelOndas21h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDia2Layout.createSequentialGroup()
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDia2Layout.createSequentialGroup()
                                        .addGroup(jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel03h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir03h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel06h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir06h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel09h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir09h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel12h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir12h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelDia2Layout.createSequentialGroup()
                                                .addComponent(jLabelVentoDir15h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelVentoDir18h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelVentoDir21h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanelDia2Layout.createSequentialGroup()
                                                .addComponent(jLabelVentoVel15h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelVentoVel18h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelVentoVel21h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jSeparator7))))
                .addContainerGap())
        );
        jPanelDia2Layout.setVerticalGroup(
            jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDia2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCondicao2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDia2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDia2Layout.createSequentialGroup()
                        .addGroup(jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDia2Layout.createSequentialGroup()
                        .addComponent(jLabelMaxima2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelMinima2))
                    .addGroup(jPanelDia2Layout.createSequentialGroup()
                        .addGroup(jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelDia2Layout.createSequentialGroup()
                                .addGroup(jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel30))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelOndas00h_2)
                                        .addComponent(jLabelOndas06h_2, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabelOndas09h_2)
                                    .addComponent(jLabelOndas12h_2)
                                    .addComponent(jLabelOndas15h_2)
                                    .addComponent(jLabelOndas18h_2)
                                    .addComponent(jLabelOndas21h_2)))
                            .addComponent(jLabelOndas03h_2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVentoVel00h_2)
                            .addComponent(jLabelVentoVel03h_2)
                            .addComponent(jLabelVentoVel06h_2)
                            .addComponent(jLabelVentoVel09h_2)
                            .addComponent(jLabelVentoVel12h_2)
                            .addComponent(jLabelVentoVel15h_2)
                            .addComponent(jLabelVentoVel18h_2)
                            .addComponent(jLabelVentoVel21h_2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDia2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVentoDir00h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir03h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir06h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir09h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir12h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir15h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir18h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir21h_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );

        jPanelSliderPrevisoes.add(jPanelDia2, "card2");

        jPanelDia3.setBackground(new java.awt.Color(0, 0, 102));
        jPanelDia3.setName("Dia3"); // NOI18N

        jLabelDia3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelDia3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel32.setBackground(new java.awt.Color(0, 0, 255));
        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Condição Climática:");
        jLabel32.setOpaque(true);

        jLabelCondicao3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelCondicao3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Tempo");

        jLabelMaxima3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMaxima3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMaxima3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/maxima.png"))); // NOI18N
        jLabelMaxima3.setToolTipText("Máxima");

        jLabelMinima3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMinima3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMinima3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/minima.png"))); // NOI18N
        jLabelMinima3.setToolTipText("Mínima");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Ondas");

        jLabelOndas00h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas00h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas00h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas00h_3.setToolTipText("Agitação do Mar");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("00h");

        jLabelVentoVel00h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel00h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel00h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel00h_3.setToolTipText("Velocidade do Vento");

        jLabelVentoDir00h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir00h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir00h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir00h_3.setToolTipText("Direção do Vento");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("03h");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("06h");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("09h");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("12h");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("15h");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("18h");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("21h");

        jLabelOndas03h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas03h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas03h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas03h_3.setToolTipText("Agitação do Mar");

        jLabelVentoVel03h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel03h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel03h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel03h_3.setToolTipText("Velocidade do Vento");

        jLabelVentoDir03h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir03h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir03h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir03h_3.setToolTipText("Direção do Vento");

        jLabelOndas06h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas06h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas06h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas06h_3.setToolTipText("Agitação do Mar");

        jLabelVentoVel06h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel06h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel06h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel06h_3.setToolTipText("Velocidade do Vento");

        jLabelVentoDir06h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir06h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir06h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir06h_3.setToolTipText("Direção do Vento");

        jLabelOndas09h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas09h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas09h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas09h_3.setToolTipText("Agitação do Mar");

        jLabelVentoVel09h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel09h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel09h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel09h_3.setToolTipText("Velocidade do Vento");

        jLabelVentoDir09h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir09h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir09h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir09h_3.setToolTipText("Direção do Vento");

        jLabelOndas12h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas12h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas12h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas12h_3.setToolTipText("Agitação do Mar");

        jLabelVentoVel12h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel12h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel12h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel12h_3.setToolTipText("Velocidade do Vento");

        jLabelVentoDir12h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir12h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir12h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir12h_3.setToolTipText("Direção do Vento");

        jLabelOndas15h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas15h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas15h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas15h_3.setToolTipText("Agitação do Mar");

        jLabelVentoVel15h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel15h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel15h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel15h_3.setToolTipText("Velocidade do Vento");

        jLabelVentoDir15h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir15h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir15h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir15h_3.setToolTipText("Direção do Vento");

        jLabelOndas18h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas18h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas18h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas18h_3.setToolTipText("Agitação do Mar");

        jLabelVentoVel18h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel18h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel18h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel18h_3.setToolTipText("Velocidade do Vento");

        jLabelVentoDir18h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir18h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir18h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir18h_3.setToolTipText("Direção do Vento");

        jLabelOndas21h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas21h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas21h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas21h_3.setToolTipText("Agitação do Mar");

        jLabelVentoVel21h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel21h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel21h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel21h_3.setToolTipText("Velocidade do Vento");

        jLabelVentoDir21h_3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir21h_3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir21h_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir21h_3.setToolTipText("Direção do Vento");

        javax.swing.GroupLayout jPanelDia3Layout = new javax.swing.GroupLayout(jPanelDia3);
        jPanelDia3.setLayout(jPanelDia3Layout);
        jPanelDia3Layout.setHorizontalGroup(
            jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDia3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDia3Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCondicao3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabelDia3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelDia3Layout.createSequentialGroup()
                        .addGroup(jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelMinima3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMaxima3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelDia3Layout.createSequentialGroup()
                                .addGroup(jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelOndas00h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelVentoVel00h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelVentoDir00h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDia3Layout.createSequentialGroup()
                                        .addComponent(jLabelOndas03h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas06h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas09h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas12h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas15h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas18h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelOndas21h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDia3Layout.createSequentialGroup()
                                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDia3Layout.createSequentialGroup()
                                        .addGroup(jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel03h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir03h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel06h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir06h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel09h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir09h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel12h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir12h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelDia3Layout.createSequentialGroup()
                                                .addComponent(jLabelVentoDir15h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelVentoDir18h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelVentoDir21h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanelDia3Layout.createSequentialGroup()
                                                .addComponent(jLabelVentoVel15h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelVentoVel18h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelVentoVel21h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jSeparator9))))
                .addContainerGap())
        );
        jPanelDia3Layout.setVerticalGroup(
            jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDia3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCondicao3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDia3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDia3Layout.createSequentialGroup()
                        .addGroup(jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDia3Layout.createSequentialGroup()
                        .addComponent(jLabelMaxima3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelMinima3))
                    .addGroup(jPanelDia3Layout.createSequentialGroup()
                        .addGroup(jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelDia3Layout.createSequentialGroup()
                                .addGroup(jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel40)
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel42))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelOndas00h_3)
                                        .addComponent(jLabelOndas06h_3, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabelOndas09h_3)
                                    .addComponent(jLabelOndas12h_3)
                                    .addComponent(jLabelOndas15h_3)
                                    .addComponent(jLabelOndas18h_3)
                                    .addComponent(jLabelOndas21h_3)))
                            .addComponent(jLabelOndas03h_3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVentoVel00h_3)
                            .addComponent(jLabelVentoVel03h_3)
                            .addComponent(jLabelVentoVel06h_3)
                            .addComponent(jLabelVentoVel09h_3)
                            .addComponent(jLabelVentoVel12h_3)
                            .addComponent(jLabelVentoVel15h_3)
                            .addComponent(jLabelVentoVel18h_3)
                            .addComponent(jLabelVentoVel21h_3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDia3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVentoDir00h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir03h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir06h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir09h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir12h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir15h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir18h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir21h_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );

        jPanelSliderPrevisoes.add(jPanelDia3, "card2");

        jPanelDia4.setBackground(new java.awt.Color(0, 0, 102));
        jPanelDia4.setName("Dia4"); // NOI18N

        jLabelDia4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelDia4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel44.setBackground(new java.awt.Color(0, 0, 255));
        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Condição Climática:");
        jLabel44.setOpaque(true);

        jLabelCondicao4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelCondicao4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Tempo");

        jLabelMaxima4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMaxima4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMaxima4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/maxima.png"))); // NOI18N
        jLabelMaxima4.setToolTipText("Máxima");

        jLabelMinima4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMinima4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMinima4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/minima.png"))); // NOI18N
        jLabelMinima4.setToolTipText("Mínima");

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Ondas");

        jLabelOndas00h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas00h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas00h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas00h_4.setToolTipText("Agitação do Mar");

        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("00h");

        jLabelVentoVel00h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel00h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel00h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel00h_4.setToolTipText("Velocidade do Vento");

        jLabelVentoDir00h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir00h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir00h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir00h_4.setToolTipText("Direção do Vento");

        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("03h");

        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("06h");

        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("09h");

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("12h");

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("15h");

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("18h");

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("21h");

        jLabelOndas03h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas03h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas03h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas03h_4.setToolTipText("Agitação do Mar");

        jLabelVentoVel03h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel03h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel03h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel03h_4.setToolTipText("Velocidade do Vento");

        jLabelVentoDir03h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir03h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir03h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir03h_4.setToolTipText("Direção do Vento");

        jLabelOndas06h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas06h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas06h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas06h_4.setToolTipText("Agitação do Mar");

        jLabelVentoVel06h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel06h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel06h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel06h_4.setToolTipText("Velocidade do Vento");

        jLabelVentoDir06h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir06h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir06h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir06h_4.setToolTipText("Direção do Vento");

        jLabelOndas09h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas09h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas09h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas09h_4.setToolTipText("Agitação do Mar");

        jLabelVentoVel09h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel09h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel09h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel09h_4.setToolTipText("Velocidade do Vento");

        jLabelVentoDir09h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir09h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir09h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir09h_4.setToolTipText("Direção do Vento");

        jLabelOndas12h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas12h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas12h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas12h_4.setToolTipText("Agitação do Mar");

        jLabelVentoVel12h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel12h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel12h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel12h_4.setToolTipText("Velocidade do Vento");

        jLabelVentoDir12h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir12h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir12h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir12h_4.setToolTipText("Direção do Vento");

        jLabelOndas15h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas15h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas15h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas15h_4.setToolTipText("Agitação do Mar");

        jLabelVentoVel15h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel15h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel15h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel15h_4.setToolTipText("Velocidade do Vento");

        jLabelVentoDir15h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir15h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir15h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir15h_4.setToolTipText("Direção do Vento");

        jLabelOndas18h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas18h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas18h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas18h_4.setToolTipText("Agitação do Mar");

        jLabelVentoVel18h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel18h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel18h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel18h_4.setToolTipText("Velocidade do Vento");

        jLabelVentoDir18h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir18h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir18h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir18h_4.setToolTipText("Direção do Vento");

        jLabelOndas21h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas21h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas21h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas21h_4.setToolTipText("Agitação do Mar");

        jLabelVentoVel21h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel21h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel21h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel21h_4.setToolTipText("Velocidade do Vento");

        jLabelVentoDir21h_4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir21h_4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir21h_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir21h_4.setToolTipText("Direção do Vento");

        javax.swing.GroupLayout jPanelDia4Layout = new javax.swing.GroupLayout(jPanelDia4);
        jPanelDia4.setLayout(jPanelDia4Layout);
        jPanelDia4Layout.setHorizontalGroup(
            jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDia4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDia4Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCondicao4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabelDia4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelDia4Layout.createSequentialGroup()
                        .addGroup(jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelMinima4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMaxima4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelDia4Layout.createSequentialGroup()
                                .addGroup(jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelOndas00h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelVentoVel00h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelVentoDir00h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDia4Layout.createSequentialGroup()
                                        .addComponent(jLabelOndas03h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas06h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas09h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas12h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas15h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas18h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelOndas21h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDia4Layout.createSequentialGroup()
                                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDia4Layout.createSequentialGroup()
                                        .addGroup(jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel03h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir03h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel06h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir06h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel09h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir09h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel12h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir12h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelDia4Layout.createSequentialGroup()
                                                .addComponent(jLabelVentoDir15h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelVentoDir18h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelVentoDir21h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanelDia4Layout.createSequentialGroup()
                                                .addComponent(jLabelVentoVel15h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelVentoVel18h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelVentoVel21h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jSeparator11))))
                .addContainerGap())
        );
        jPanelDia4Layout.setVerticalGroup(
            jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDia4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCondicao4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDia4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDia4Layout.createSequentialGroup()
                        .addGroup(jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(jLabel46))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDia4Layout.createSequentialGroup()
                        .addComponent(jLabelMaxima4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelMinima4))
                    .addGroup(jPanelDia4Layout.createSequentialGroup()
                        .addGroup(jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelDia4Layout.createSequentialGroup()
                                .addGroup(jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel47)
                                    .addComponent(jLabel48)
                                    .addComponent(jLabel49)
                                    .addComponent(jLabel50)
                                    .addComponent(jLabel51)
                                    .addComponent(jLabel52)
                                    .addComponent(jLabel53)
                                    .addComponent(jLabel54))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelOndas00h_4)
                                        .addComponent(jLabelOndas06h_4, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabelOndas09h_4)
                                    .addComponent(jLabelOndas12h_4)
                                    .addComponent(jLabelOndas15h_4)
                                    .addComponent(jLabelOndas18h_4)
                                    .addComponent(jLabelOndas21h_4)))
                            .addComponent(jLabelOndas03h_4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVentoVel00h_4)
                            .addComponent(jLabelVentoVel03h_4)
                            .addComponent(jLabelVentoVel06h_4)
                            .addComponent(jLabelVentoVel09h_4)
                            .addComponent(jLabelVentoVel12h_4)
                            .addComponent(jLabelVentoVel15h_4)
                            .addComponent(jLabelVentoVel18h_4)
                            .addComponent(jLabelVentoVel21h_4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDia4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVentoDir00h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir03h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir06h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir09h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir12h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir15h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir18h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir21h_4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );

        jPanelSliderPrevisoes.add(jPanelDia4, "card2");

        jPanelDia5.setBackground(new java.awt.Color(0, 0, 102));
        jPanelDia5.setName("Dia5"); // NOI18N

        jLabelDia5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelDia5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel56.setBackground(new java.awt.Color(0, 0, 255));
        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Condição Climática:");
        jLabel56.setOpaque(true);

        jLabelCondicao5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelCondicao5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel57.setText("Tempo");

        jLabelMaxima5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMaxima5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMaxima5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/maxima.png"))); // NOI18N
        jLabelMaxima5.setToolTipText("Máxima");

        jLabelMinima5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMinima5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMinima5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/minima.png"))); // NOI18N
        jLabelMinima5.setToolTipText("Mínima");

        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("Ondas");

        jLabelOndas00h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas00h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas00h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas00h_5.setToolTipText("Agitação do Mar");

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("00h");

        jLabelVentoVel00h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel00h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel00h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel00h_5.setToolTipText("Velocidade do Vento");

        jLabelVentoDir00h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir00h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir00h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir00h_5.setToolTipText("Direção do Vento");

        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("03h");

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("06h");

        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel62.setText("09h");

        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setText("12h");

        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("15h");

        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("18h");

        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("21h");

        jLabelOndas03h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas03h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas03h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas03h_5.setToolTipText("Agitação do Mar");

        jLabelVentoVel03h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel03h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel03h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel03h_5.setToolTipText("Velocidade do Vento");

        jLabelVentoDir03h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir03h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir03h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir03h_5.setToolTipText("Direção do Vento");

        jLabelOndas06h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas06h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas06h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas06h_5.setToolTipText("Agitação do Mar");

        jLabelVentoVel06h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel06h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel06h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel06h_5.setToolTipText("Velocidade do Vento");

        jLabelVentoDir06h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir06h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir06h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir06h_5.setToolTipText("Direção do Vento");

        jLabelOndas09h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas09h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas09h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas09h_5.setToolTipText("Agitação do Mar");

        jLabelVentoVel09h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel09h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel09h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel09h_5.setToolTipText("Velocidade do Vento");

        jLabelVentoDir09h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir09h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir09h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir09h_5.setToolTipText("Direção do Vento");

        jLabelOndas12h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas12h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas12h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas12h_5.setToolTipText("Agitação do Mar");

        jLabelVentoVel12h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel12h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel12h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel12h_5.setToolTipText("Velocidade do Vento");

        jLabelVentoDir12h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir12h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir12h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir12h_5.setToolTipText("Direção do Vento");

        jLabelOndas15h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas15h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas15h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas15h_5.setToolTipText("Agitação do Mar");

        jLabelVentoVel15h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel15h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel15h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel15h_5.setToolTipText("Velocidade do Vento");

        jLabelVentoDir15h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir15h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir15h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir15h_5.setToolTipText("Direção do Vento");

        jLabelOndas18h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas18h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas18h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas18h_5.setToolTipText("Agitação do Mar");

        jLabelVentoVel18h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel18h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel18h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel18h_5.setToolTipText("Velocidade do Vento");

        jLabelVentoDir18h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir18h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir18h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir18h_5.setToolTipText("Direção do Vento");

        jLabelOndas21h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas21h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas21h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas21h_5.setToolTipText("Agitação do Mar");

        jLabelVentoVel21h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel21h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel21h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel21h_5.setToolTipText("Velocidade do Vento");

        jLabelVentoDir21h_5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir21h_5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir21h_5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir21h_5.setToolTipText("Direção do Vento");

        javax.swing.GroupLayout jPanelDia5Layout = new javax.swing.GroupLayout(jPanelDia5);
        jPanelDia5.setLayout(jPanelDia5Layout);
        jPanelDia5Layout.setHorizontalGroup(
            jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDia5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDia5Layout.createSequentialGroup()
                        .addComponent(jLabel56)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCondicao5, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabelDia5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelDia5Layout.createSequentialGroup()
                        .addGroup(jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelMinima5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jSeparator12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMaxima5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelDia5Layout.createSequentialGroup()
                                .addGroup(jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelOndas00h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelVentoVel00h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelVentoDir00h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDia5Layout.createSequentialGroup()
                                        .addComponent(jLabelOndas03h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas06h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas09h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas12h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas15h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas18h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelOndas21h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDia5Layout.createSequentialGroup()
                                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDia5Layout.createSequentialGroup()
                                        .addGroup(jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel03h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir03h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel06h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir06h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel09h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir09h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel12h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir12h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelDia5Layout.createSequentialGroup()
                                                .addComponent(jLabelVentoDir15h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelVentoDir18h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelVentoDir21h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanelDia5Layout.createSequentialGroup()
                                                .addComponent(jLabelVentoVel15h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelVentoVel18h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelVentoVel21h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jSeparator13))))
                .addContainerGap())
        );
        jPanelDia5Layout.setVerticalGroup(
            jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDia5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCondicao5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDia5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDia5Layout.createSequentialGroup()
                        .addGroup(jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(jLabel58))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDia5Layout.createSequentialGroup()
                        .addComponent(jLabelMaxima5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelMinima5))
                    .addGroup(jPanelDia5Layout.createSequentialGroup()
                        .addGroup(jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelDia5Layout.createSequentialGroup()
                                .addGroup(jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel59)
                                    .addComponent(jLabel60)
                                    .addComponent(jLabel61)
                                    .addComponent(jLabel62)
                                    .addComponent(jLabel63)
                                    .addComponent(jLabel64)
                                    .addComponent(jLabel65)
                                    .addComponent(jLabel66))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelOndas00h_5)
                                        .addComponent(jLabelOndas06h_5, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabelOndas09h_5)
                                    .addComponent(jLabelOndas12h_5)
                                    .addComponent(jLabelOndas15h_5)
                                    .addComponent(jLabelOndas18h_5)
                                    .addComponent(jLabelOndas21h_5)))
                            .addComponent(jLabelOndas03h_5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVentoVel00h_5)
                            .addComponent(jLabelVentoVel03h_5)
                            .addComponent(jLabelVentoVel06h_5)
                            .addComponent(jLabelVentoVel09h_5)
                            .addComponent(jLabelVentoVel12h_5)
                            .addComponent(jLabelVentoVel15h_5)
                            .addComponent(jLabelVentoVel18h_5)
                            .addComponent(jLabelVentoVel21h_5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDia5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVentoDir00h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir03h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir06h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir09h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir12h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir15h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir18h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir21h_5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );

        jPanelSliderPrevisoes.add(jPanelDia5, "card2");

        jPanelDia6.setBackground(new java.awt.Color(0, 0, 102));
        jPanelDia6.setName("Dia6"); // NOI18N

        jLabelDia6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelDia6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel68.setBackground(new java.awt.Color(0, 0, 255));
        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("Condição Climática:");
        jLabel68.setOpaque(true);

        jLabelCondicao6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelCondicao6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel69.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("Tempo");

        jLabelMaxima6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMaxima6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMaxima6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/maxima.png"))); // NOI18N
        jLabelMaxima6.setToolTipText("Máxima");

        jLabelMinima6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMinima6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMinima6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/minima.png"))); // NOI18N
        jLabelMinima6.setToolTipText("Mínima");

        jLabel70.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("Ondas");

        jLabelOndas00h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas00h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas00h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas00h_6.setToolTipText("Agitação do Mar");

        jLabel71.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setText("00h");

        jLabelVentoVel00h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel00h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel00h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel00h_6.setToolTipText("Velocidade do Vento");

        jLabelVentoDir00h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir00h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir00h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir00h_6.setToolTipText("Direção do Vento");

        jLabel72.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setText("03h");

        jLabel73.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("06h");

        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("09h");

        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("12h");

        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("15h");

        jLabel77.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("18h");

        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("21h");

        jLabelOndas03h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas03h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas03h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas03h_6.setToolTipText("Agitação do Mar");

        jLabelVentoVel03h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel03h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel03h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel03h_6.setToolTipText("Velocidade do Vento");

        jLabelVentoDir03h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir03h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir03h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir03h_6.setToolTipText("Direção do Vento");

        jLabelOndas06h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas06h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas06h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas06h_6.setToolTipText("Agitação do Mar");

        jLabelVentoVel06h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel06h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel06h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel06h_6.setToolTipText("Velocidade do Vento");

        jLabelVentoDir06h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir06h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir06h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir06h_6.setToolTipText("Direção do Vento");

        jLabelOndas09h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas09h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas09h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas09h_6.setToolTipText("Agitação do Mar");

        jLabelVentoVel09h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel09h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel09h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel09h_6.setToolTipText("Velocidade do Vento");

        jLabelVentoDir09h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir09h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir09h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir09h_6.setToolTipText("Direção do Vento");

        jLabelOndas12h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas12h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas12h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas12h_6.setToolTipText("Agitação do Mar");

        jLabelVentoVel12h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel12h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel12h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel12h_6.setToolTipText("Velocidade do Vento");

        jLabelVentoDir12h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir12h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir12h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir12h_6.setToolTipText("Direção do Vento");

        jLabelOndas15h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas15h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas15h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas15h_6.setToolTipText("Agitação do Mar");

        jLabelVentoVel15h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel15h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel15h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel15h_6.setToolTipText("Velocidade do Vento");

        jLabelVentoDir15h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir15h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir15h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir15h_6.setToolTipText("Direção do Vento");

        jLabelOndas18h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas18h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas18h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas18h_6.setToolTipText("Agitação do Mar");

        jLabelVentoVel18h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel18h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel18h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel18h_6.setToolTipText("Velocidade do Vento");

        jLabelVentoDir18h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir18h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir18h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir18h_6.setToolTipText("Direção do Vento");

        jLabelOndas21h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas21h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas21h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas21h_6.setToolTipText("Agitação do Mar");

        jLabelVentoVel21h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel21h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel21h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel21h_6.setToolTipText("Velocidade do Vento");

        jLabelVentoDir21h_6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir21h_6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir21h_6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir21h_6.setToolTipText("Direção do Vento");

        javax.swing.GroupLayout jPanelDia6Layout = new javax.swing.GroupLayout(jPanelDia6);
        jPanelDia6.setLayout(jPanelDia6Layout);
        jPanelDia6Layout.setHorizontalGroup(
            jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDia6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDia6Layout.createSequentialGroup()
                        .addComponent(jLabel68)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCondicao6, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabelDia6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelDia6Layout.createSequentialGroup()
                        .addGroup(jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelMinima6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jSeparator14, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMaxima6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelDia6Layout.createSequentialGroup()
                                .addGroup(jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelOndas00h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelVentoVel00h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelVentoDir00h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDia6Layout.createSequentialGroup()
                                        .addComponent(jLabelOndas03h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas06h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas09h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas12h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas15h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas18h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelOndas21h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDia6Layout.createSequentialGroup()
                                        .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDia6Layout.createSequentialGroup()
                                        .addGroup(jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel03h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir03h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel06h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir06h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel09h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir09h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel12h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir12h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelDia6Layout.createSequentialGroup()
                                                .addComponent(jLabelVentoDir15h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelVentoDir18h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelVentoDir21h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanelDia6Layout.createSequentialGroup()
                                                .addComponent(jLabelVentoVel15h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelVentoVel18h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelVentoVel21h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jSeparator15))))
                .addContainerGap())
        );
        jPanelDia6Layout.setVerticalGroup(
            jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDia6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCondicao6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDia6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDia6Layout.createSequentialGroup()
                        .addGroup(jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel69)
                            .addComponent(jLabel70))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDia6Layout.createSequentialGroup()
                        .addComponent(jLabelMaxima6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelMinima6))
                    .addGroup(jPanelDia6Layout.createSequentialGroup()
                        .addGroup(jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelDia6Layout.createSequentialGroup()
                                .addGroup(jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel71)
                                    .addComponent(jLabel72)
                                    .addComponent(jLabel73)
                                    .addComponent(jLabel74)
                                    .addComponent(jLabel75)
                                    .addComponent(jLabel76)
                                    .addComponent(jLabel77)
                                    .addComponent(jLabel78))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelOndas00h_6)
                                        .addComponent(jLabelOndas06h_6, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabelOndas09h_6)
                                    .addComponent(jLabelOndas12h_6)
                                    .addComponent(jLabelOndas15h_6)
                                    .addComponent(jLabelOndas18h_6)
                                    .addComponent(jLabelOndas21h_6)))
                            .addComponent(jLabelOndas03h_6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVentoVel00h_6)
                            .addComponent(jLabelVentoVel03h_6)
                            .addComponent(jLabelVentoVel06h_6)
                            .addComponent(jLabelVentoVel09h_6)
                            .addComponent(jLabelVentoVel12h_6)
                            .addComponent(jLabelVentoVel15h_6)
                            .addComponent(jLabelVentoVel18h_6)
                            .addComponent(jLabelVentoVel21h_6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDia6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVentoDir00h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir03h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir06h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir09h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir12h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir15h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir18h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir21h_6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );

        jPanelSliderPrevisoes.add(jPanelDia6, "card2");

        jLabelAvancar.setBackground(new java.awt.Color(0, 0, 102));
        jLabelAvancar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/avancar.png"))); // NOI18N
        jLabelAvancar.setToolTipText("Próxima");
        jLabelAvancar.setOpaque(true);
        jLabelAvancar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelAvancarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelAvancarMouseReleased(evt);
            }
        });

        jLabelVoltar.setBackground(new java.awt.Color(0, 0, 102));
        jLabelVoltar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/voltar.png"))); // NOI18N
        jLabelVoltar.setToolTipText("Anterior");
        jLabelVoltar.setOpaque(true);
        jLabelVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelVoltarMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelVoltarMouseReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Código:");

        jTextFieldCodCidade.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanelPrevisoesLayout = new javax.swing.GroupLayout(jPanelPrevisoes);
        jPanelPrevisoes.setLayout(jPanelPrevisoesLayout);
        jPanelPrevisoesLayout.setHorizontalGroup(
            jPanelPrevisoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrevisoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPrevisoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanelPrevisoesLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldCodCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonRelatorio)))
                .addContainerGap())
            .addGroup(jPanelPrevisoesLayout.createSequentialGroup()
                .addComponent(jLabelVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelSliderPrevisoes, javax.swing.GroupLayout.PREFERRED_SIZE, 1143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAvancar, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
        );
        jPanelPrevisoesLayout.setVerticalGroup(
            jPanelPrevisoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrevisoesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelPrevisoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxCidade, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelPrevisoesLayout.createSequentialGroup()
                        .addGroup(jPanelPrevisoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldCodCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPrevisoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelSliderPrevisoes, javax.swing.GroupLayout.PREFERRED_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(jLabelAvancar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(827, 827, 827))
        );

        jTabbedPanePrevisoes.addTab("Previsões", jPanelPrevisoes);

        jPanelPrevisoesAnt.setBackground(new java.awt.Color(0, 0, 102));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Estado:");

        jComboBoxAntEstado.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxAntEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alagoas", "Amapá", "Bahia", "Ceará", "Espírito Santo", "Maranhão", "Paraná", "Paraíba", "Pará", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Santa Catarina", "Sergipe", "São Paulo" }));
        jComboBoxAntEstado.setSelectedItem(null);
        jComboBoxAntEstado.setFocusable(false);
        jComboBoxAntEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxAntEstadoItemStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cidade:");

        jComboBoxAntCidade.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBoxAntCidade.setSelectedItem(null);
        jComboBoxAntCidade.setFocusable(false);
        jComboBoxAntCidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxAntCidadeItemStateChanged(evt);
            }
        });

        jButtonAntBuscar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAntBuscar.setText("Buscar");
        jButtonAntBuscar.setEnabled(false);
        jButtonAntBuscar.setFocusable(false);
        jButtonAntBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAntBuscarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Código:");

        jTextFieldAntCodCidade.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jXDatePickerPeriodo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jXDatePickerPeriodo.setOpaque(true);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Período:");

        jPanelSliderAntPrevisoes.setBackground(new java.awt.Color(0, 0, 102));
        jPanelSliderAntPrevisoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanelDiaAnt.setBackground(new java.awt.Color(0, 0, 102));
        jPanelDiaAnt.setName("Dia1"); // NOI18N

        jLabelDia7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelDia7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel31.setBackground(new java.awt.Color(0, 0, 255));
        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Condição Climática:");
        jLabel31.setOpaque(true);

        jLabelCondicao7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelCondicao7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Tempo");

        jLabelMaxima7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMaxima7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMaxima7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/maxima.png"))); // NOI18N
        jLabelMaxima7.setToolTipText("Máxima");

        jLabelMinima7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMinima7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMinima7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/minima.png"))); // NOI18N
        jLabelMinima7.setToolTipText("Mínima");

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Ondas");

        jLabelOndas00h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas00h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas00h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas00h_7.setToolTipText("Agitação do Mar");

        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("00h");

        jLabelVentoVel00h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel00h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel00h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel00h_7.setToolTipText("Velocidade do Vento");

        jLabelVentoDir00h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir00h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir00h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir00h_7.setToolTipText("Direção do Vento");

        jLabel79.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("03h");

        jLabel80.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel80.setText("06h");

        jLabel81.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel81.setText("09h");

        jLabel82.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("12h");

        jLabel83.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("15h");

        jLabel84.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel84.setText("18h");

        jLabel85.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setText("21h");

        jLabelOndas03h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas03h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas03h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas03h_7.setToolTipText("Agitação do Mar");

        jLabelVentoVel03h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel03h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel03h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel03h_7.setToolTipText("Velocidade do Vento");

        jLabelVentoDir03h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir03h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir03h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir03h_7.setToolTipText("Direção do Vento");

        jLabelOndas06h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas06h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas06h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas06h_7.setToolTipText("Agitação do Mar");

        jLabelVentoVel06h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel06h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel06h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel06h_7.setToolTipText("Velocidade do Vento");

        jLabelVentoDir06h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir06h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir06h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir06h_7.setToolTipText("Direção do Vento");

        jLabelOndas09h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas09h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas09h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas09h_7.setToolTipText("Agitação do Mar");

        jLabelVentoVel09h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel09h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel09h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel09h_7.setToolTipText("Velocidade do Vento");

        jLabelVentoDir09h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir09h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir09h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir09h_7.setToolTipText("Direção do Vento");

        jLabelOndas12h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas12h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas12h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas12h_7.setToolTipText("Agitação do Mar");

        jLabelVentoVel12h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel12h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel12h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel12h_7.setToolTipText("Velocidade do Vento");

        jLabelVentoDir12h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir12h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir12h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir12h_7.setToolTipText("Direção do Vento");

        jLabelOndas15h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas15h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas15h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas15h_7.setToolTipText("Agitação do Mar");

        jLabelVentoVel15h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel15h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel15h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel15h_7.setToolTipText("Velocidade do Vento");

        jLabelVentoDir15h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir15h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir15h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir15h_7.setToolTipText("Direção do Vento");

        jLabelOndas18h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas18h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas18h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas18h_7.setToolTipText("Agitação do Mar");

        jLabelVentoVel18h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel18h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel18h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel18h_7.setToolTipText("Velocidade do Vento");

        jLabelVentoDir18h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir18h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir18h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir18h_7.setToolTipText("Direção do Vento");

        jLabelOndas21h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelOndas21h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelOndas21h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ondas.png"))); // NOI18N
        jLabelOndas21h_7.setToolTipText("Agitação do Mar");

        jLabelVentoVel21h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoVel21h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoVel21h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/velocidade.png"))); // NOI18N
        jLabelVentoVel21h_7.setToolTipText("Velocidade do Vento");

        jLabelVentoDir21h_7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelVentoDir21h_7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelVentoDir21h_7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/direcao.png"))); // NOI18N
        jLabelVentoDir21h_7.setToolTipText("Direção do Vento");

        javax.swing.GroupLayout jPanelDiaAntLayout = new javax.swing.GroupLayout(jPanelDiaAnt);
        jPanelDiaAnt.setLayout(jPanelDiaAntLayout);
        jPanelDiaAntLayout.setHorizontalGroup(
            jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDiaAntLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDiaAntLayout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCondicao7, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabelDia7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelDiaAntLayout.createSequentialGroup()
                        .addGroup(jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabelMinima7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jSeparator16, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMaxima7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanelDiaAntLayout.createSequentialGroup()
                                .addGroup(jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelOndas00h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelVentoVel00h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelVentoDir00h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDiaAntLayout.createSequentialGroup()
                                        .addComponent(jLabelOndas03h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas06h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas09h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas12h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas15h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelOndas18h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelOndas21h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDiaAntLayout.createSequentialGroup()
                                        .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDiaAntLayout.createSequentialGroup()
                                        .addGroup(jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel03h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir03h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel06h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir06h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel09h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir09h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelVentoVel12h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelVentoDir12h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelDiaAntLayout.createSequentialGroup()
                                                .addComponent(jLabelVentoDir15h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelVentoDir18h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelVentoDir21h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanelDiaAntLayout.createSequentialGroup()
                                                .addComponent(jLabelVentoVel15h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabelVentoVel18h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelVentoVel21h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jSeparator17))))
                .addContainerGap())
        );
        jPanelDiaAntLayout.setVerticalGroup(
            jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDiaAntLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCondicao7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDia7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDiaAntLayout.createSequentialGroup()
                        .addGroup(jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(jLabel55))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDiaAntLayout.createSequentialGroup()
                        .addComponent(jLabelMaxima7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelMinima7))
                    .addGroup(jPanelDiaAntLayout.createSequentialGroup()
                        .addGroup(jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelDiaAntLayout.createSequentialGroup()
                                .addGroup(jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel67)
                                    .addComponent(jLabel79)
                                    .addComponent(jLabel80)
                                    .addComponent(jLabel81)
                                    .addComponent(jLabel82)
                                    .addComponent(jLabel83)
                                    .addComponent(jLabel84)
                                    .addComponent(jLabel85))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelOndas00h_7)
                                        .addComponent(jLabelOndas06h_7, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabelOndas09h_7)
                                    .addComponent(jLabelOndas12h_7)
                                    .addComponent(jLabelOndas15h_7)
                                    .addComponent(jLabelOndas18h_7)
                                    .addComponent(jLabelOndas21h_7)))
                            .addComponent(jLabelOndas03h_7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVentoVel00h_7)
                            .addComponent(jLabelVentoVel03h_7)
                            .addComponent(jLabelVentoVel06h_7)
                            .addComponent(jLabelVentoVel09h_7)
                            .addComponent(jLabelVentoVel12h_7)
                            .addComponent(jLabelVentoVel15h_7)
                            .addComponent(jLabelVentoVel18h_7)
                            .addComponent(jLabelVentoVel21h_7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDiaAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelVentoDir00h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir03h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir06h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir09h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir12h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir15h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir18h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelVentoDir21h_7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );

        jPanelSliderAntPrevisoes.add(jPanelDiaAnt, "card2");

        javax.swing.GroupLayout jPanelPrevisoesAntLayout = new javax.swing.GroupLayout(jPanelPrevisoesAnt);
        jPanelPrevisoesAnt.setLayout(jPanelPrevisoesAntLayout);
        jPanelPrevisoesAntLayout.setHorizontalGroup(
            jPanelPrevisoesAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrevisoesAntLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPrevisoesAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanelPrevisoesAntLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxAntEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxAntCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAntCodCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jXDatePickerPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(141, 141, 141)
                        .addComponent(jButtonAntBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanelPrevisoesAntLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanelSliderAntPrevisoes, javax.swing.GroupLayout.PREFERRED_SIZE, 1143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanelPrevisoesAntLayout.setVerticalGroup(
            jPanelPrevisoesAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrevisoesAntLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelPrevisoesAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxAntCidade)
                    .addGroup(jPanelPrevisoesAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrevisoesAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldAntCodCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGroup(jPanelPrevisoesAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBoxAntEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanelPrevisoesAntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jXDatePickerPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAntBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelSliderAntPrevisoes, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPanePrevisoes.addTab("Previsões Anteriores", jPanelPrevisoesAnt);

        jLabelFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fecharCinza.png"))); // NOI18N
        jLabelFechar.setToolTipText("Fechar");
        jLabelFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelFecharMouseReleased(evt);
            }
        });

        jLabelMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/minimizarCinza.png"))); // NOI18N
        jLabelMinimizar.setToolTipText("Minimizar");
        jLabelMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabelMinimizarMouseReleased(evt);
            }
        });

        jPanelAlertas.setBackground(new java.awt.Color(0, 0, 102));
        jPanelAlertas.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, null));

        jLabel86.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setText("Painel de Alertas - Condição de Navegação");

        jScrollPaneAlertas.setBackground(new java.awt.Color(0, 0, 102));
        jScrollPaneAlertas.setForeground(new java.awt.Color(255, 255, 255));

        jTableAlertas.setBackground(new java.awt.Color(0, 0, 102));
        jTableAlertas.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTableAlertas.setForeground(new java.awt.Color(255, 255, 255));
        jTableAlertas.setModel(Controle.updateAlertas());
        jTableAlertas.setFocusable(false);
        jTableAlertas.setGridColor(new java.awt.Color(204, 204, 204));
        jTableAlertas.setOpaque(false);
        jTableAlertas.setRowHeight(25);
        jTableAlertas.setSelectionBackground(new java.awt.Color(0, 0, 204));
        jTableAlertas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableAlertas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAlertasMouseClicked(evt);
            }
        });
        jScrollPaneAlertas.setViewportView(jTableAlertas);

        jButtonLimpar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonLimpar.setText("Limpar Tudo");
        jButtonLimpar.setFocusable(false);
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAlertasLayout = new javax.swing.GroupLayout(jPanelAlertas);
        jPanelAlertas.setLayout(jPanelAlertasLayout);
        jPanelAlertasLayout.setHorizontalGroup(
            jPanelAlertasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlertasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAlertasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneAlertas)
                    .addGroup(jPanelAlertasLayout.createSequentialGroup()
                        .addComponent(jLabel86)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                        .addComponent(jButtonLimpar)))
                .addContainerGap())
        );
        jPanelAlertasLayout.setVerticalGroup(
            jPanelAlertasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlertasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAlertasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel86, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneAlertas, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setOpaque(false);

        jLabelAtualizando.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelAtualizando.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAtualizando.setText("Atualizando Dados...");

        jProgressBarAtualiza.setIndeterminate(true);

        jButtonAtualiza.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAtualiza.setText("Verificar Atualizações");
        jButtonAtualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelAtualizando)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jProgressBarAtualiza, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAtualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelAtualizando)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBarAtualiza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAtualiza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Legenda Alertas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setOpaque(false);

        jLabel87.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ruim.png"))); // NOI18N
        jLabel87.setText("- Ruim");

        jLabel88.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/moderado.png"))); // NOI18N
        jLabel88.setText("- Moderado");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel88)
                .addGap(19, 19, 19)
                .addComponent(jLabel87)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel87, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
            .addComponent(jLabel88, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ocean.png"))); // NOI18N

        jButtonRelatorios.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonRelatorios.setText("Relatórios");
        jButtonRelatorios.setFocusable(false);
        jButtonRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelatoriosActionPerformed(evt);
            }
        });

        jButtonAjuda.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButtonAjuda.setText("Ajuda");
        jButtonAjuda.setFocusable(false);
        jButtonAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 1176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabelMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelFechar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanelAlertas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel89, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButtonRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonAjuda, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jTabbedPanePrevisoes, javax.swing.GroupLayout.PREFERRED_SIZE, 1237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMinimizar)
                    .addComponent(jLabelFechar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPanePrevisoes, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelAlertas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonRelatorios)
                                    .addComponent(jButtonAjuda))
                                .addGap(28, 28, 28))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)))
                        .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(442, Short.MAX_VALUE))
        );

        jPanelBackground.add(jPanel1);
        jPanel1.setBounds(2, 0, 1272, 1120);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo-azul-degrade.jpg"))); // NOI18N
        jPanelBackground.add(jLabel1);
        jLabel1.setBounds(-10, -4, 1300, 1320);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 1262, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
    private void jLabelFecharMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelFecharMouseReleased
        if(JOptionPane.showOptionDialog(null, 
            "Encerrar o programa?", 
            "Sair", 
            JOptionPane.YES_OPTION, 
            JOptionPane.NO_OPTION, 
            null, 
            new String[]{"Sim", "Não"},
            "default") == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_jLabelFecharMouseReleased

    private void jLabelMinimizarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinimizarMouseReleased
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinimizarMouseReleased

    private void jLabelTituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTituloMousePressed
        posicao = evt.getPoint();
        getComponentAt(posicao);
    }//GEN-LAST:event_jLabelTituloMousePressed

    private void jLabelTituloMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTituloMouseDragged
        int thisX = this.getLocation().x;
        int thisY = this.getLocation().y;

        int xMoved = (thisX + evt.getX()) - (thisX + posicao.x);
        int yMoved = (thisY + evt.getY()) - (thisY + posicao.y);

        int X = thisX + xMoved;
        int Y = thisY + yMoved;
        this.setLocation(X, Y);
    }//GEN-LAST:event_jLabelTituloMouseDragged

    private void jComboBoxAntEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxAntEstadoItemStateChanged
        Controle controle = new Controle();
        jComboBoxAntCidade.setModel(controle.getCidades(jComboBoxAntEstado.getSelectedItem()));
        jComboBoxAntCidade.setSelectedItem(null);
    }//GEN-LAST:event_jComboBoxAntEstadoItemStateChanged

    private void jComboBoxEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEstadoItemStateChanged
        Controle controle = new Controle();
        jComboBoxCidade.setModel(controle.getCidades(jComboBoxEstado.getSelectedItem()));
        jComboBoxCidade.setSelectedItem(null);
    }//GEN-LAST:event_jComboBoxEstadoItemStateChanged

    private Component previousPanel(String panel){
        Component component = null;
        switch (panel) {
            case "Dia1":
                active = 5;
                component = jPanelDia6;
                break;
            case "Dia2":
                active = 0;
                component = jPanelDia1;
                break;
            case "Dia3":
                active = 1;
                component = jPanelDia2;
                break;
            case "Dia4":
                active = 2;
                component = jPanelDia3;
                break;
            case "Dia5":
                active = 3;
                component = jPanelDia4;
                break;
            case "Dia6":
                active = 4;
                component = jPanelDia5;
                break;
            default:
                break;
        }
        return component;
    }
    
    private Component nextPanel(String panel){
        Component component = null;
        switch (panel) {
            case "Dia1":
                active = 1;
                component = jPanelDia2;
                break;
            case "Dia2":
                active = 2;
                component = jPanelDia3;
                break;
            case "Dia3":
                active = 3;
                component = jPanelDia4;
                break;
            case "Dia4":
                active = 4;
                component = jPanelDia5;
                break;
            case "Dia5":
                active = 5;
                component = jPanelDia6;
                break;
            case "Dia6":
                active = 0;
                component = jPanelDia1;
                break;
            default:
                break;
        }
        return component;
    }
    
    private void jLabelVoltarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVoltarMouseReleased
        jLabelVoltar.setBackground(new java.awt.Color(0, 0, 102));
        jPanelSliderPrevisoes.nextPanel(10, previousPanel(jPanelSliderPrevisoes.getComponent(active).getName()), JPanelSlider.right);
    }//GEN-LAST:event_jLabelVoltarMouseReleased

    private void jLabelAvancarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvancarMouseReleased
        jLabelAvancar.setBackground(new java.awt.Color(0, 0, 102));
        jPanelSliderPrevisoes.nextPanel(10, nextPanel(jPanelSliderPrevisoes.getComponent(active).getName()), JPanelSlider.left);
    }//GEN-LAST:event_jLabelAvancarMouseReleased

    private void jComboBoxCidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCidadeItemStateChanged
        if(jComboBoxCidade.getSelectedItem() != null){
            Controle controle = new Controle();
            jTextFieldCodCidade.setText(Integer.toString(controle.getCodCidade(jComboBoxEstado.getSelectedItem().toString(), jComboBoxCidade.getSelectedItem().toString())));
            jButtonBuscar.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBoxCidadeItemStateChanged

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        Controle controle = new Controle();
        List<PrevisaoCompleta> previsoes = controle.obterPrevisoes(Integer.parseInt(jTextFieldCodCidade.getText()), dia);
        
        jLabelDia1.setText(previsoes.get(0).getPrevisaoTempo().getDiaFormatado());
        jLabelCondicao1.setText(previsoes.get(0).getPrevisaoTempo().legendaTempo());
        jLabelMaxima1.setText(Integer.toString(previsoes.get(0).getPrevisaoTempo().getMaxima())+" °C");
        jLabelMinima1.setText(Integer.toString(previsoes.get(0).getPrevisaoTempo().getMinima())+" °C");        
        jLabelOndas00h_1.setText(previsoes.get(0).getPrevisaoOndas().get(0).getAgitacao());
        jLabelVentoVel00h_1.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(0).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(0).getPrevisaoOndas().get(0).getVentoVel())+" km/h");
        jLabelVentoDir00h_1.setText(previsoes.get(0).getPrevisaoOndas().get(0).getVentoDir());
        jLabelOndas03h_1.setText(previsoes.get(0).getPrevisaoOndas().get(1).getAgitacao());
        jLabelVentoVel03h_1.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(1).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(0).getPrevisaoOndas().get(1).getVentoVel())+" km/h");
        jLabelVentoDir03h_1.setText(previsoes.get(0).getPrevisaoOndas().get(1).getVentoDir());
        jLabelOndas06h_1.setText(previsoes.get(0).getPrevisaoOndas().get(2).getAgitacao());
        jLabelVentoVel06h_1.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(2).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(0).getPrevisaoOndas().get(2).getVentoVel())+" km/h");
        jLabelVentoDir06h_1.setText(previsoes.get(0).getPrevisaoOndas().get(2).getVentoDir());
        jLabelOndas09h_1.setText(previsoes.get(0).getPrevisaoOndas().get(3).getAgitacao());
        jLabelVentoVel09h_1.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(3).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(0).getPrevisaoOndas().get(3).getVentoVel())+" km/h");
        jLabelVentoDir09h_1.setText(previsoes.get(0).getPrevisaoOndas().get(3).getVentoDir());
        jLabelOndas12h_1.setText(previsoes.get(0).getPrevisaoOndas().get(4).getAgitacao());
        jLabelVentoVel12h_1.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(4).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(0).getPrevisaoOndas().get(4).getVentoVel())+" km/h");
        jLabelVentoDir12h_1.setText(previsoes.get(0).getPrevisaoOndas().get(4).getVentoDir());
        jLabelOndas15h_1.setText(previsoes.get(0).getPrevisaoOndas().get(5).getAgitacao());
        jLabelVentoVel15h_1.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(5).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(0).getPrevisaoOndas().get(5).getVentoVel())+" km/h");
        jLabelVentoDir15h_1.setText(previsoes.get(0).getPrevisaoOndas().get(5).getVentoDir());
        jLabelOndas18h_1.setText(previsoes.get(0).getPrevisaoOndas().get(6).getAgitacao());
        jLabelVentoVel18h_1.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(6).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(0).getPrevisaoOndas().get(6).getVentoVel())+" km/h");
        jLabelVentoDir18h_1.setText(previsoes.get(0).getPrevisaoOndas().get(6).getVentoDir());
        jLabelOndas21h_1.setText(previsoes.get(0).getPrevisaoOndas().get(7).getAgitacao());
        jLabelVentoVel21h_1.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(7).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(0).getPrevisaoOndas().get(7).getVentoVel())+" km/h");
        jLabelVentoDir21h_1.setText(previsoes.get(0).getPrevisaoOndas().get(7).getVentoDir());
        
        jLabelDia2.setText(previsoes.get(1).getPrevisaoTempo().getDiaFormatado());
        jLabelCondicao2.setText(previsoes.get(1).getPrevisaoTempo().legendaTempo());
        jLabelMaxima2.setText(Integer.toString(previsoes.get(1).getPrevisaoTempo().getMaxima())+" °C");
        jLabelMinima2.setText(Integer.toString(previsoes.get(1).getPrevisaoTempo().getMinima())+" °C");        
        jLabelOndas00h_2.setText(previsoes.get(1).getPrevisaoOndas().get(0).getAgitacao());
        jLabelVentoVel00h_2.setText(Float.toString(previsoes.get(1).getPrevisaoOndas().get(0).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(1).getPrevisaoOndas().get(0).getVentoVel())+" km/h");
        jLabelVentoDir00h_2.setText(previsoes.get(1).getPrevisaoOndas().get(0).getVentoDir());
        jLabelOndas03h_2.setText(previsoes.get(1).getPrevisaoOndas().get(1).getAgitacao());
        jLabelVentoVel03h_2.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(1).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(1).getPrevisaoOndas().get(1).getVentoVel())+" km/h");
        jLabelVentoDir03h_2.setText(previsoes.get(1).getPrevisaoOndas().get(1).getVentoDir());
        jLabelOndas06h_2.setText(previsoes.get(1).getPrevisaoOndas().get(2).getAgitacao());
        jLabelVentoVel06h_2.setText(Float.toString(previsoes.get(1).getPrevisaoOndas().get(2).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(1).getPrevisaoOndas().get(2).getVentoVel())+" km/h");
        jLabelVentoDir06h_2.setText(previsoes.get(1).getPrevisaoOndas().get(2).getVentoDir());
        jLabelOndas09h_2.setText(previsoes.get(1).getPrevisaoOndas().get(3).getAgitacao());
        jLabelVentoVel09h_2.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(3).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(1).getPrevisaoOndas().get(3).getVentoVel())+" km/h");
        jLabelVentoDir09h_2.setText(previsoes.get(1).getPrevisaoOndas().get(3).getVentoDir());
        jLabelOndas12h_2.setText(previsoes.get(1).getPrevisaoOndas().get(4).getAgitacao());
        jLabelVentoVel12h_2.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(4).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(1).getPrevisaoOndas().get(4).getVentoVel())+" km/h");
        jLabelVentoDir12h_2.setText(previsoes.get(1).getPrevisaoOndas().get(4).getVentoDir());
        jLabelOndas15h_2.setText(previsoes.get(1).getPrevisaoOndas().get(5).getAgitacao());
        jLabelVentoVel15h_2.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(5).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(1).getPrevisaoOndas().get(5).getVentoVel())+" km/h");
        jLabelVentoDir15h_2.setText(previsoes.get(1).getPrevisaoOndas().get(5).getVentoDir());
        jLabelOndas18h_2.setText(previsoes.get(1).getPrevisaoOndas().get(6).getAgitacao());
        jLabelVentoVel18h_2.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(6).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(1).getPrevisaoOndas().get(6).getVentoVel())+" km/h");
        jLabelVentoDir18h_2.setText(previsoes.get(1).getPrevisaoOndas().get(6).getVentoDir());
        jLabelOndas21h_2.setText(previsoes.get(1).getPrevisaoOndas().get(7).getAgitacao());
        jLabelVentoVel21h_2.setText(Float.toString(previsoes.get(1).getPrevisaoOndas().get(7).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(1).getPrevisaoOndas().get(7).getVentoVel())+" km/h");
        jLabelVentoDir21h_2.setText(previsoes.get(1).getPrevisaoOndas().get(7).getVentoDir());
        
        jLabelDia3.setText(previsoes.get(2).getPrevisaoTempo().getDiaFormatado());
        jLabelCondicao3.setText(previsoes.get(2).getPrevisaoTempo().legendaTempo());
        jLabelMaxima3.setText(Integer.toString(previsoes.get(2).getPrevisaoTempo().getMaxima())+" °C");
        jLabelMinima3.setText(Integer.toString(previsoes.get(2).getPrevisaoTempo().getMinima())+" °C");        
        jLabelOndas00h_3.setText(previsoes.get(2).getPrevisaoOndas().get(0).getAgitacao());
        jLabelVentoVel00h_3.setText(Float.toString(previsoes.get(2).getPrevisaoOndas().get(0).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(2).getPrevisaoOndas().get(0).getVentoVel())+" km/h");
        jLabelVentoDir00h_3.setText(previsoes.get(2).getPrevisaoOndas().get(0).getVentoDir());
        jLabelOndas03h_3.setText(previsoes.get(2).getPrevisaoOndas().get(1).getAgitacao());
        jLabelVentoVel03h_3.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(1).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(2).getPrevisaoOndas().get(1).getVentoVel())+" km/h");
        jLabelVentoDir03h_3.setText(previsoes.get(2).getPrevisaoOndas().get(1).getVentoDir());
        jLabelOndas06h_3.setText(previsoes.get(2).getPrevisaoOndas().get(2).getAgitacao());
        jLabelVentoVel06h_3.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(2).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(2).getPrevisaoOndas().get(2).getVentoVel())+" km/h");
        jLabelVentoDir06h_3.setText(previsoes.get(2).getPrevisaoOndas().get(2).getVentoDir());
        jLabelOndas09h_3.setText(previsoes.get(2).getPrevisaoOndas().get(3).getAgitacao());
        jLabelVentoVel09h_3.setText(Float.toString(previsoes.get(2).getPrevisaoOndas().get(3).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(2).getPrevisaoOndas().get(3).getVentoVel())+" km/h");
        jLabelVentoDir09h_3.setText(previsoes.get(2).getPrevisaoOndas().get(3).getVentoDir());
        jLabelOndas12h_3.setText(previsoes.get(2).getPrevisaoOndas().get(4).getAgitacao());
        jLabelVentoVel12h_3.setText(Float.toString(previsoes.get(2).getPrevisaoOndas().get(4).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(2).getPrevisaoOndas().get(4).getVentoVel())+" km/h");
        jLabelVentoDir12h_3.setText(previsoes.get(2).getPrevisaoOndas().get(4).getVentoDir());
        jLabelOndas15h_3.setText(previsoes.get(2).getPrevisaoOndas().get(5).getAgitacao());
        jLabelVentoVel15h_3.setText(Float.toString(previsoes.get(2).getPrevisaoOndas().get(5).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(2).getPrevisaoOndas().get(5).getVentoVel())+" km/h");
        jLabelVentoDir15h_3.setText(previsoes.get(2).getPrevisaoOndas().get(5).getVentoDir());
        jLabelOndas18h_3.setText(previsoes.get(2).getPrevisaoOndas().get(6).getAgitacao());
        jLabelVentoVel18h_3.setText(Float.toString(previsoes.get(2).getPrevisaoOndas().get(6).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(2).getPrevisaoOndas().get(6).getVentoVel())+" km/h");
        jLabelVentoDir18h_3.setText(previsoes.get(2).getPrevisaoOndas().get(6).getVentoDir());
        jLabelOndas21h_3.setText(previsoes.get(2).getPrevisaoOndas().get(7).getAgitacao());
        jLabelVentoVel21h_3.setText(Float.toString(previsoes.get(2).getPrevisaoOndas().get(7).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(2).getPrevisaoOndas().get(7).getVentoVel())+" km/h");
        jLabelVentoDir21h_3.setText(previsoes.get(2).getPrevisaoOndas().get(7).getVentoDir());
        
        jLabelDia4.setText(previsoes.get(3).getPrevisaoTempo().getDiaFormatado());
        jLabelCondicao4.setText(previsoes.get(3).getPrevisaoTempo().legendaTempo());
        jLabelMaxima4.setText(Integer.toString(previsoes.get(3).getPrevisaoTempo().getMaxima())+" °C");
        jLabelMinima4.setText(Integer.toString(previsoes.get(3).getPrevisaoTempo().getMinima())+" °C");        
        jLabelOndas00h_4.setText(previsoes.get(3).getPrevisaoOndas().get(0).getAgitacao());
        jLabelVentoVel00h_4.setText(Float.toString(previsoes.get(3).getPrevisaoOndas().get(0).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(3).getPrevisaoOndas().get(0).getVentoVel())+" km/h");
        jLabelVentoDir00h_4.setText(previsoes.get(3).getPrevisaoOndas().get(0).getVentoDir());
        jLabelOndas03h_4.setText(previsoes.get(3).getPrevisaoOndas().get(1).getAgitacao());
        jLabelVentoVel03h_4.setText(Float.toString(previsoes.get(3).getPrevisaoOndas().get(1).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(3).getPrevisaoOndas().get(1).getVentoVel())+" km/h");
        jLabelVentoDir03h_4.setText(previsoes.get(3).getPrevisaoOndas().get(1).getVentoDir());
        jLabelOndas06h_4.setText(previsoes.get(3).getPrevisaoOndas().get(2).getAgitacao());
        jLabelVentoVel06h_4.setText(Float.toString(previsoes.get(3).getPrevisaoOndas().get(2).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(3).getPrevisaoOndas().get(2).getVentoVel())+" km/h");
        jLabelVentoDir06h_4.setText(previsoes.get(3).getPrevisaoOndas().get(2).getVentoDir());
        jLabelOndas09h_4.setText(previsoes.get(3).getPrevisaoOndas().get(3).getAgitacao());
        jLabelVentoVel09h_4.setText(Float.toString(previsoes.get(3).getPrevisaoOndas().get(3).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(3).getPrevisaoOndas().get(3).getVentoVel())+" km/h");
        jLabelVentoDir09h_4.setText(previsoes.get(3).getPrevisaoOndas().get(3).getVentoDir());
        jLabelOndas12h_4.setText(previsoes.get(3).getPrevisaoOndas().get(4).getAgitacao());
        jLabelVentoVel12h_4.setText(Float.toString(previsoes.get(3).getPrevisaoOndas().get(4).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(3).getPrevisaoOndas().get(4).getVentoVel())+" km/h");
        jLabelVentoDir12h_4.setText(previsoes.get(3).getPrevisaoOndas().get(4).getVentoDir());
        jLabelOndas15h_4.setText(previsoes.get(3).getPrevisaoOndas().get(5).getAgitacao());
        jLabelVentoVel15h_4.setText(Float.toString(previsoes.get(3).getPrevisaoOndas().get(5).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(3).getPrevisaoOndas().get(5).getVentoVel())+" km/h");
        jLabelVentoDir15h_4.setText(previsoes.get(3).getPrevisaoOndas().get(5).getVentoDir());
        jLabelOndas18h_4.setText(previsoes.get(3).getPrevisaoOndas().get(6).getAgitacao());
        jLabelVentoVel18h_4.setText(Float.toString(previsoes.get(3).getPrevisaoOndas().get(6).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(3).getPrevisaoOndas().get(6).getVentoVel())+" km/h");
        jLabelVentoDir18h_4.setText(previsoes.get(3).getPrevisaoOndas().get(6).getVentoDir());
        jLabelOndas21h_4.setText(previsoes.get(3).getPrevisaoOndas().get(7).getAgitacao());
        jLabelVentoVel21h_4.setText(Float.toString(previsoes.get(3).getPrevisaoOndas().get(7).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(3).getPrevisaoOndas().get(7).getVentoVel())+" km/h");
        jLabelVentoDir21h_4.setText(previsoes.get(3).getPrevisaoOndas().get(7).getVentoDir());
        
        jLabelDia5.setText(previsoes.get(4).getPrevisaoTempo().getDiaFormatado());
        jLabelCondicao5.setText(previsoes.get(4).getPrevisaoTempo().legendaTempo());
        jLabelMaxima5.setText(Integer.toString(previsoes.get(4).getPrevisaoTempo().getMaxima())+" °C");
        jLabelMinima5.setText(Integer.toString(previsoes.get(4).getPrevisaoTempo().getMinima())+" °C");        
        jLabelOndas00h_5.setText(previsoes.get(4).getPrevisaoOndas().get(0).getAgitacao());
        jLabelVentoVel00h_5.setText(Float.toString(previsoes.get(4).getPrevisaoOndas().get(0).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(4).getPrevisaoOndas().get(0).getVentoVel())+" km/h");
        jLabelVentoDir00h_5.setText(previsoes.get(4).getPrevisaoOndas().get(0).getVentoDir());
        jLabelOndas03h_5.setText(previsoes.get(4).getPrevisaoOndas().get(1).getAgitacao());
        jLabelVentoVel03h_5.setText(Float.toString(previsoes.get(4).getPrevisaoOndas().get(1).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(4).getPrevisaoOndas().get(1).getVentoVel())+" km/h");
        jLabelVentoDir03h_5.setText(previsoes.get(4).getPrevisaoOndas().get(1).getVentoDir());
        jLabelOndas06h_5.setText(previsoes.get(4).getPrevisaoOndas().get(2).getAgitacao());
        jLabelVentoVel06h_5.setText(Float.toString(previsoes.get(4).getPrevisaoOndas().get(2).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(4).getPrevisaoOndas().get(2).getVentoVel())+" km/h");
        jLabelVentoDir06h_5.setText(previsoes.get(4).getPrevisaoOndas().get(2).getVentoDir());
        jLabelOndas09h_5.setText(previsoes.get(4).getPrevisaoOndas().get(3).getAgitacao());
        jLabelVentoVel09h_5.setText(Float.toString(previsoes.get(4).getPrevisaoOndas().get(3).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(4).getPrevisaoOndas().get(3).getVentoVel())+" km/h");
        jLabelVentoDir09h_5.setText(previsoes.get(4).getPrevisaoOndas().get(3).getVentoDir());
        jLabelOndas12h_5.setText(previsoes.get(4).getPrevisaoOndas().get(4).getAgitacao());
        jLabelVentoVel12h_5.setText(Float.toString(previsoes.get(4).getPrevisaoOndas().get(4).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(4).getPrevisaoOndas().get(4).getVentoVel())+" km/h");
        jLabelVentoDir12h_5.setText(previsoes.get(4).getPrevisaoOndas().get(4).getVentoDir());
        jLabelOndas15h_5.setText(previsoes.get(4).getPrevisaoOndas().get(5).getAgitacao());
        jLabelVentoVel15h_5.setText(Float.toString(previsoes.get(4).getPrevisaoOndas().get(5).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(4).getPrevisaoOndas().get(5).getVentoVel())+" km/h");
        jLabelVentoDir15h_5.setText(previsoes.get(4).getPrevisaoOndas().get(5).getVentoDir());
        jLabelOndas18h_5.setText(previsoes.get(4).getPrevisaoOndas().get(6).getAgitacao());
        jLabelVentoVel18h_5.setText(Float.toString(previsoes.get(4).getPrevisaoOndas().get(6).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(4).getPrevisaoOndas().get(6).getVentoVel())+" km/h");
        jLabelVentoDir18h_5.setText(previsoes.get(4).getPrevisaoOndas().get(6).getVentoDir());
        jLabelOndas21h_5.setText(previsoes.get(4).getPrevisaoOndas().get(7).getAgitacao());
        jLabelVentoVel21h_5.setText(Float.toString(previsoes.get(4).getPrevisaoOndas().get(7).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(4).getPrevisaoOndas().get(7).getVentoVel())+" km/h");
        jLabelVentoDir21h_5.setText(previsoes.get(4).getPrevisaoOndas().get(7).getVentoDir());
        
        jLabelDia6.setText(previsoes.get(5).getPrevisaoTempo().getDiaFormatado());
        jLabelCondicao6.setText(previsoes.get(5).getPrevisaoTempo().legendaTempo());
        jLabelMaxima6.setText(Integer.toString(previsoes.get(5).getPrevisaoTempo().getMaxima())+" °C");
        jLabelMinima6.setText(Integer.toString(previsoes.get(5).getPrevisaoTempo().getMinima())+" °C");        
        jLabelOndas00h_6.setText(previsoes.get(5).getPrevisaoOndas().get(0).getAgitacao());
        jLabelVentoVel00h_6.setText(Float.toString(previsoes.get(5).getPrevisaoOndas().get(0).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(5).getPrevisaoOndas().get(0).getVentoVel())+" km/h");
        jLabelVentoDir00h_6.setText(previsoes.get(5).getPrevisaoOndas().get(0).getVentoDir());
        jLabelOndas03h_6.setText(previsoes.get(5).getPrevisaoOndas().get(1).getAgitacao());
        jLabelVentoVel03h_6.setText(Float.toString(previsoes.get(5).getPrevisaoOndas().get(1).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(5).getPrevisaoOndas().get(1).getVentoVel())+" km/h");
        jLabelVentoDir03h_6.setText(previsoes.get(5).getPrevisaoOndas().get(1).getVentoDir());
        jLabelOndas06h_6.setText(previsoes.get(5).getPrevisaoOndas().get(2).getAgitacao());
        jLabelVentoVel06h_6.setText(Float.toString(previsoes.get(5).getPrevisaoOndas().get(2).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(5).getPrevisaoOndas().get(2).getVentoVel())+" km/h");
        jLabelVentoDir06h_6.setText(previsoes.get(5).getPrevisaoOndas().get(2).getVentoDir());
        jLabelOndas09h_6.setText(previsoes.get(5).getPrevisaoOndas().get(3).getAgitacao());
        jLabelVentoVel09h_6.setText(Float.toString(previsoes.get(5).getPrevisaoOndas().get(3).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(5).getPrevisaoOndas().get(3).getVentoVel())+" km/h");
        jLabelVentoDir09h_6.setText(previsoes.get(5).getPrevisaoOndas().get(3).getVentoDir());
        jLabelOndas12h_6.setText(previsoes.get(5).getPrevisaoOndas().get(4).getAgitacao());
        jLabelVentoVel12h_6.setText(Float.toString(previsoes.get(5).getPrevisaoOndas().get(4).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(5).getPrevisaoOndas().get(4).getVentoVel())+" km/h");
        jLabelVentoDir12h_6.setText(previsoes.get(5).getPrevisaoOndas().get(4).getVentoDir());
        jLabelOndas15h_6.setText(previsoes.get(5).getPrevisaoOndas().get(5).getAgitacao());
        jLabelVentoVel15h_6.setText(Float.toString(previsoes.get(5).getPrevisaoOndas().get(5).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(5).getPrevisaoOndas().get(5).getVentoVel())+" km/h");
        jLabelVentoDir15h_6.setText(previsoes.get(5).getPrevisaoOndas().get(5).getVentoDir());
        jLabelOndas18h_6.setText(previsoes.get(5).getPrevisaoOndas().get(6).getAgitacao());
        jLabelVentoVel18h_6.setText(Float.toString(previsoes.get(5).getPrevisaoOndas().get(6).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(5).getPrevisaoOndas().get(6).getVentoVel()));
        jLabelVentoDir18h_6.setText(previsoes.get(5).getPrevisaoOndas().get(6).getVentoDir());
        jLabelOndas21h_6.setText(previsoes.get(5).getPrevisaoOndas().get(7).getAgitacao());
        jLabelVentoVel21h_6.setText(Float.toString(previsoes.get(5).getPrevisaoOndas().get(7).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(5).getPrevisaoOndas().get(7).getVentoVel()));
        jLabelVentoDir21h_6.setText(previsoes.get(5).getPrevisaoOndas().get(7).getVentoDir());
        
        jPanelSliderPrevisoes.setVisible(true);
        jLabelVoltar.setVisible(true);
        jLabelAvancar.setVisible(true);
        jButtonRelatorio.setEnabled(true);
        
        List<Alerta> alertas = controle.verificarAlertas(previsoes);
        if(!alertas.isEmpty()){
            JOptionPane.showMessageDialog(null, "Novo(s) alerta(s)!");
            updateAlertas();
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jLabelVoltarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVoltarMousePressed
        jLabelVoltar.setBackground(new java.awt.Color(0, 0, 110));
    }//GEN-LAST:event_jLabelVoltarMousePressed

    private void jLabelAvancarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAvancarMousePressed
        jLabelAvancar.setBackground(new java.awt.Color(0, 0, 110));
    }//GEN-LAST:event_jLabelAvancarMousePressed

    private void jButtonRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelatorioActionPerformed
        Controle controle = new Controle();
        
        File file = controle.gerarRelatorio(Integer.parseInt(jTextFieldCodCidade.getText()), dia);
        
        if(file != null){
            if(JOptionPane.showOptionDialog(null, 
            "Relatório gerado com sucesso!", 
            "Relatório", 
            JOptionPane.YES_OPTION, 
            JOptionPane.NO_OPTION, 
            null, 
            new String[]{"Abrir Relatório", "OK"},
            "default") == JOptionPane.YES_OPTION){
                if(Desktop.isDesktopSupported()){
                    try {
                        Desktop.getDesktop().open(file);
                    } catch (IOException ex) {
                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao gerar o relatório!", "Erro", 0);
        }
    }//GEN-LAST:event_jButtonRelatorioActionPerformed

    private void jButtonAntBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAntBuscarActionPerformed
        DateFormat df = new SimpleDateFormat("yyy/MM/dd");
        Controle controle = new Controle();
        List<PrevisaoCompleta> previsoes = controle.obterPrevisao(Integer.parseInt(jTextFieldAntCodCidade.getText()), df.format(jXDatePickerPeriodo.getDate()));
        if(!previsoes.isEmpty()){
            jLabelDia7.setText(previsoes.get(0).getPrevisaoTempo().getDiaFormatado());
            jLabelCondicao7.setText(previsoes.get(0).getPrevisaoTempo().legendaTempo());
            jLabelMaxima7.setText(Integer.toString(previsoes.get(0).getPrevisaoTempo().getMaxima())+" °C");
            jLabelMinima7.setText(Integer.toString(previsoes.get(0).getPrevisaoTempo().getMinima())+" °C");        
            jLabelOndas00h_7.setText(previsoes.get(0).getPrevisaoOndas().get(0).getAgitacao());
            jLabelVentoVel00h_7.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(0).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(0).getPrevisaoOndas().get(0).getVentoVel())+" km/h");
            jLabelVentoDir00h_7.setText(previsoes.get(0).getPrevisaoOndas().get(0).getVentoDir());
            jLabelOndas03h_7.setText(previsoes.get(0).getPrevisaoOndas().get(1).getAgitacao());
            jLabelVentoVel03h_7.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(1).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(0).getPrevisaoOndas().get(1).getVentoVel())+" km/h");
            jLabelVentoDir03h_7.setText(previsoes.get(0).getPrevisaoOndas().get(1).getVentoDir());
            jLabelOndas06h_7.setText(previsoes.get(0).getPrevisaoOndas().get(2).getAgitacao());
            jLabelVentoVel06h_7.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(2).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(0).getPrevisaoOndas().get(2).getVentoVel())+" km/h");
            jLabelVentoDir06h_7.setText(previsoes.get(0).getPrevisaoOndas().get(2).getVentoDir());
            jLabelOndas09h_7.setText(previsoes.get(0).getPrevisaoOndas().get(3).getAgitacao());
            jLabelVentoVel09h_7.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(3).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(0).getPrevisaoOndas().get(3).getVentoVel())+" km/h");
            jLabelVentoDir09h_7.setText(previsoes.get(0).getPrevisaoOndas().get(3).getVentoDir());
            jLabelOndas12h_7.setText(previsoes.get(0).getPrevisaoOndas().get(4).getAgitacao());
            jLabelVentoVel12h_7.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(4).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(0).getPrevisaoOndas().get(4).getVentoVel())+" km/h");
            jLabelVentoDir12h_7.setText(previsoes.get(0).getPrevisaoOndas().get(4).getVentoDir());
            jLabelOndas15h_7.setText(previsoes.get(0).getPrevisaoOndas().get(5).getAgitacao());
            jLabelVentoVel15h_7.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(5).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(0).getPrevisaoOndas().get(5).getVentoVel())+" km/h");
            jLabelVentoDir15h_7.setText(previsoes.get(0).getPrevisaoOndas().get(5).getVentoDir());
            jLabelOndas18h_7.setText(previsoes.get(0).getPrevisaoOndas().get(6).getAgitacao());
            jLabelVentoVel18h_7.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(6).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(0).getPrevisaoOndas().get(6).getVentoVel())+" km/h");
            jLabelVentoDir18h_7.setText(previsoes.get(0).getPrevisaoOndas().get(6).getVentoDir());
            jLabelOndas21h_7.setText(previsoes.get(0).getPrevisaoOndas().get(7).getAgitacao());
            jLabelVentoVel21h_7.setText(Float.toString(previsoes.get(0).getPrevisaoOndas().get(7).getVentoVel()).equals("-1.0") ? "Indisponível" : Float.toString(previsoes.get(0).getPrevisaoOndas().get(7).getVentoVel())+" km/h");
            jLabelVentoDir21h_7.setText(previsoes.get(0).getPrevisaoOndas().get(7).getVentoDir());

            jPanelSliderAntPrevisoes.setVisible(true);

        }else{
            JOptionPane.showMessageDialog(null, "Previsão indisponível no dia selecionado.");
        }
    }//GEN-LAST:event_jButtonAntBuscarActionPerformed

    private void jComboBoxAntCidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxAntCidadeItemStateChanged
        if(jComboBoxAntCidade.getSelectedItem() != null){
            Controle controle = new Controle();
            jTextFieldAntCodCidade.setText(Integer.toString(controle.getCodCidade(jComboBoxAntEstado.getSelectedItem().toString(), jComboBoxAntCidade.getSelectedItem().toString())));
            jButtonAntBuscar.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBoxAntCidadeItemStateChanged

    private void jButtonAtualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizaActionPerformed
        start();
    }//GEN-LAST:event_jButtonAtualizaActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        if(JOptionPane.showOptionDialog(null, 
            "Limpar todos os alertas?", 
            "Limpar Tudo", 
            JOptionPane.YES_OPTION, 
            JOptionPane.NO_OPTION, 
            null, 
            new String[]{"Sim", "Não"},
            "default") == JOptionPane.YES_OPTION){
            Controle controle = new Controle();
            controle.limparAlertas();
            updateAlertas();
        }
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        jTableAlertas.clearSelection();
    }//GEN-LAST:event_formMouseReleased

    private void jTableAlertasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAlertasMouseClicked
        JTable table =(JTable) evt.getSource();
        if (evt.getClickCount() == 2) {
            String nivel = (String) jTableAlertas.getValueAt(jTableAlertas.getSelectedRow(), 0);
            String[] split = ((String) jTableAlertas.getValueAt(jTableAlertas.getSelectedRow(), 1)).split("/");
            String data = split[2]+"/"+split[1]+"/"+split[0];
            String cidade = (String) jTableAlertas.getValueAt(jTableAlertas.getSelectedRow(), 2);
            String estado = (String) jTableAlertas.getValueAt(jTableAlertas.getSelectedRow(), 3);
            TelaAlerta detalhes = new TelaAlerta(null, true, nivel, data, cidade, estado);
            detalhes.setVisible(true);
        }
    }//GEN-LAST:event_jTableAlertasMouseClicked

    private void jButtonRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelatoriosActionPerformed
        String cdir = System.getProperty("user.dir");
        File dir = new File(cdir+File.separator+"Relatorios");
        if(dir.exists()){        
            try {
                Desktop desktop = Desktop.getDesktop();
                desktop.open(dir);
            } catch (IOException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Nenhum relatório armazenado!");
        }
    }//GEN-LAST:event_jButtonRelatoriosActionPerformed

    private void jButtonAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjudaActionPerformed
        TelaAjuda tela = new TelaAjuda(this, true);
        tela.setVisible(true);
    }//GEN-LAST:event_jButtonAjudaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjuda;
    private javax.swing.JButton jButtonAntBuscar;
    private javax.swing.JButton jButtonAtualiza;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonRelatorio;
    private javax.swing.JButton jButtonRelatorios;
    private javax.swing.JComboBox<String> jComboBoxAntCidade;
    private javax.swing.JComboBox<String> jComboBoxAntEstado;
    private javax.swing.JComboBox<String> jComboBoxCidade;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAtualizando;
    private javax.swing.JLabel jLabelAvancar;
    private javax.swing.JLabel jLabelCondicao1;
    private javax.swing.JLabel jLabelCondicao2;
    private javax.swing.JLabel jLabelCondicao3;
    private javax.swing.JLabel jLabelCondicao4;
    private javax.swing.JLabel jLabelCondicao5;
    private javax.swing.JLabel jLabelCondicao6;
    private javax.swing.JLabel jLabelCondicao7;
    private javax.swing.JLabel jLabelDia1;
    private javax.swing.JLabel jLabelDia2;
    private javax.swing.JLabel jLabelDia3;
    private javax.swing.JLabel jLabelDia4;
    private javax.swing.JLabel jLabelDia5;
    private javax.swing.JLabel jLabelDia6;
    private javax.swing.JLabel jLabelDia7;
    private javax.swing.JLabel jLabelFechar;
    private javax.swing.JLabel jLabelMaxima1;
    private javax.swing.JLabel jLabelMaxima2;
    private javax.swing.JLabel jLabelMaxima3;
    private javax.swing.JLabel jLabelMaxima4;
    private javax.swing.JLabel jLabelMaxima5;
    private javax.swing.JLabel jLabelMaxima6;
    private javax.swing.JLabel jLabelMaxima7;
    private javax.swing.JLabel jLabelMinima1;
    private javax.swing.JLabel jLabelMinima2;
    private javax.swing.JLabel jLabelMinima3;
    private javax.swing.JLabel jLabelMinima4;
    private javax.swing.JLabel jLabelMinima5;
    private javax.swing.JLabel jLabelMinima6;
    private javax.swing.JLabel jLabelMinima7;
    private javax.swing.JLabel jLabelMinimizar;
    private javax.swing.JLabel jLabelOndas00h_1;
    private javax.swing.JLabel jLabelOndas00h_2;
    private javax.swing.JLabel jLabelOndas00h_3;
    private javax.swing.JLabel jLabelOndas00h_4;
    private javax.swing.JLabel jLabelOndas00h_5;
    private javax.swing.JLabel jLabelOndas00h_6;
    private javax.swing.JLabel jLabelOndas00h_7;
    private javax.swing.JLabel jLabelOndas03h_1;
    private javax.swing.JLabel jLabelOndas03h_2;
    private javax.swing.JLabel jLabelOndas03h_3;
    private javax.swing.JLabel jLabelOndas03h_4;
    private javax.swing.JLabel jLabelOndas03h_5;
    private javax.swing.JLabel jLabelOndas03h_6;
    private javax.swing.JLabel jLabelOndas03h_7;
    private javax.swing.JLabel jLabelOndas06h_1;
    private javax.swing.JLabel jLabelOndas06h_2;
    private javax.swing.JLabel jLabelOndas06h_3;
    private javax.swing.JLabel jLabelOndas06h_4;
    private javax.swing.JLabel jLabelOndas06h_5;
    private javax.swing.JLabel jLabelOndas06h_6;
    private javax.swing.JLabel jLabelOndas06h_7;
    private javax.swing.JLabel jLabelOndas09h_1;
    private javax.swing.JLabel jLabelOndas09h_2;
    private javax.swing.JLabel jLabelOndas09h_3;
    private javax.swing.JLabel jLabelOndas09h_4;
    private javax.swing.JLabel jLabelOndas09h_5;
    private javax.swing.JLabel jLabelOndas09h_6;
    private javax.swing.JLabel jLabelOndas09h_7;
    private javax.swing.JLabel jLabelOndas12h_1;
    private javax.swing.JLabel jLabelOndas12h_2;
    private javax.swing.JLabel jLabelOndas12h_3;
    private javax.swing.JLabel jLabelOndas12h_4;
    private javax.swing.JLabel jLabelOndas12h_5;
    private javax.swing.JLabel jLabelOndas12h_6;
    private javax.swing.JLabel jLabelOndas12h_7;
    private javax.swing.JLabel jLabelOndas15h_1;
    private javax.swing.JLabel jLabelOndas15h_2;
    private javax.swing.JLabel jLabelOndas15h_3;
    private javax.swing.JLabel jLabelOndas15h_4;
    private javax.swing.JLabel jLabelOndas15h_5;
    private javax.swing.JLabel jLabelOndas15h_6;
    private javax.swing.JLabel jLabelOndas15h_7;
    private javax.swing.JLabel jLabelOndas18h_1;
    private javax.swing.JLabel jLabelOndas18h_2;
    private javax.swing.JLabel jLabelOndas18h_3;
    private javax.swing.JLabel jLabelOndas18h_4;
    private javax.swing.JLabel jLabelOndas18h_5;
    private javax.swing.JLabel jLabelOndas18h_6;
    private javax.swing.JLabel jLabelOndas18h_7;
    private javax.swing.JLabel jLabelOndas21h_1;
    private javax.swing.JLabel jLabelOndas21h_2;
    private javax.swing.JLabel jLabelOndas21h_3;
    private javax.swing.JLabel jLabelOndas21h_4;
    private javax.swing.JLabel jLabelOndas21h_5;
    private javax.swing.JLabel jLabelOndas21h_6;
    private javax.swing.JLabel jLabelOndas21h_7;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelVentoDir00h_1;
    private javax.swing.JLabel jLabelVentoDir00h_2;
    private javax.swing.JLabel jLabelVentoDir00h_3;
    private javax.swing.JLabel jLabelVentoDir00h_4;
    private javax.swing.JLabel jLabelVentoDir00h_5;
    private javax.swing.JLabel jLabelVentoDir00h_6;
    private javax.swing.JLabel jLabelVentoDir00h_7;
    private javax.swing.JLabel jLabelVentoDir03h_1;
    private javax.swing.JLabel jLabelVentoDir03h_2;
    private javax.swing.JLabel jLabelVentoDir03h_3;
    private javax.swing.JLabel jLabelVentoDir03h_4;
    private javax.swing.JLabel jLabelVentoDir03h_5;
    private javax.swing.JLabel jLabelVentoDir03h_6;
    private javax.swing.JLabel jLabelVentoDir03h_7;
    private javax.swing.JLabel jLabelVentoDir06h_1;
    private javax.swing.JLabel jLabelVentoDir06h_2;
    private javax.swing.JLabel jLabelVentoDir06h_3;
    private javax.swing.JLabel jLabelVentoDir06h_4;
    private javax.swing.JLabel jLabelVentoDir06h_5;
    private javax.swing.JLabel jLabelVentoDir06h_6;
    private javax.swing.JLabel jLabelVentoDir06h_7;
    private javax.swing.JLabel jLabelVentoDir09h_1;
    private javax.swing.JLabel jLabelVentoDir09h_2;
    private javax.swing.JLabel jLabelVentoDir09h_3;
    private javax.swing.JLabel jLabelVentoDir09h_4;
    private javax.swing.JLabel jLabelVentoDir09h_5;
    private javax.swing.JLabel jLabelVentoDir09h_6;
    private javax.swing.JLabel jLabelVentoDir09h_7;
    private javax.swing.JLabel jLabelVentoDir12h_1;
    private javax.swing.JLabel jLabelVentoDir12h_2;
    private javax.swing.JLabel jLabelVentoDir12h_3;
    private javax.swing.JLabel jLabelVentoDir12h_4;
    private javax.swing.JLabel jLabelVentoDir12h_5;
    private javax.swing.JLabel jLabelVentoDir12h_6;
    private javax.swing.JLabel jLabelVentoDir12h_7;
    private javax.swing.JLabel jLabelVentoDir15h_1;
    private javax.swing.JLabel jLabelVentoDir15h_2;
    private javax.swing.JLabel jLabelVentoDir15h_3;
    private javax.swing.JLabel jLabelVentoDir15h_4;
    private javax.swing.JLabel jLabelVentoDir15h_5;
    private javax.swing.JLabel jLabelVentoDir15h_6;
    private javax.swing.JLabel jLabelVentoDir15h_7;
    private javax.swing.JLabel jLabelVentoDir18h_1;
    private javax.swing.JLabel jLabelVentoDir18h_2;
    private javax.swing.JLabel jLabelVentoDir18h_3;
    private javax.swing.JLabel jLabelVentoDir18h_4;
    private javax.swing.JLabel jLabelVentoDir18h_5;
    private javax.swing.JLabel jLabelVentoDir18h_6;
    private javax.swing.JLabel jLabelVentoDir18h_7;
    private javax.swing.JLabel jLabelVentoDir21h_1;
    private javax.swing.JLabel jLabelVentoDir21h_2;
    private javax.swing.JLabel jLabelVentoDir21h_3;
    private javax.swing.JLabel jLabelVentoDir21h_4;
    private javax.swing.JLabel jLabelVentoDir21h_5;
    private javax.swing.JLabel jLabelVentoDir21h_6;
    private javax.swing.JLabel jLabelVentoDir21h_7;
    private javax.swing.JLabel jLabelVentoVel00h_1;
    private javax.swing.JLabel jLabelVentoVel00h_2;
    private javax.swing.JLabel jLabelVentoVel00h_3;
    private javax.swing.JLabel jLabelVentoVel00h_4;
    private javax.swing.JLabel jLabelVentoVel00h_5;
    private javax.swing.JLabel jLabelVentoVel00h_6;
    private javax.swing.JLabel jLabelVentoVel00h_7;
    private javax.swing.JLabel jLabelVentoVel03h_1;
    private javax.swing.JLabel jLabelVentoVel03h_2;
    private javax.swing.JLabel jLabelVentoVel03h_3;
    private javax.swing.JLabel jLabelVentoVel03h_4;
    private javax.swing.JLabel jLabelVentoVel03h_5;
    private javax.swing.JLabel jLabelVentoVel03h_6;
    private javax.swing.JLabel jLabelVentoVel03h_7;
    private javax.swing.JLabel jLabelVentoVel06h_1;
    private javax.swing.JLabel jLabelVentoVel06h_2;
    private javax.swing.JLabel jLabelVentoVel06h_3;
    private javax.swing.JLabel jLabelVentoVel06h_4;
    private javax.swing.JLabel jLabelVentoVel06h_5;
    private javax.swing.JLabel jLabelVentoVel06h_6;
    private javax.swing.JLabel jLabelVentoVel06h_7;
    private javax.swing.JLabel jLabelVentoVel09h_1;
    private javax.swing.JLabel jLabelVentoVel09h_2;
    private javax.swing.JLabel jLabelVentoVel09h_3;
    private javax.swing.JLabel jLabelVentoVel09h_4;
    private javax.swing.JLabel jLabelVentoVel09h_5;
    private javax.swing.JLabel jLabelVentoVel09h_6;
    private javax.swing.JLabel jLabelVentoVel09h_7;
    private javax.swing.JLabel jLabelVentoVel12h_1;
    private javax.swing.JLabel jLabelVentoVel12h_2;
    private javax.swing.JLabel jLabelVentoVel12h_3;
    private javax.swing.JLabel jLabelVentoVel12h_4;
    private javax.swing.JLabel jLabelVentoVel12h_5;
    private javax.swing.JLabel jLabelVentoVel12h_6;
    private javax.swing.JLabel jLabelVentoVel12h_7;
    private javax.swing.JLabel jLabelVentoVel15h_1;
    private javax.swing.JLabel jLabelVentoVel15h_2;
    private javax.swing.JLabel jLabelVentoVel15h_3;
    private javax.swing.JLabel jLabelVentoVel15h_4;
    private javax.swing.JLabel jLabelVentoVel15h_5;
    private javax.swing.JLabel jLabelVentoVel15h_6;
    private javax.swing.JLabel jLabelVentoVel15h_7;
    private javax.swing.JLabel jLabelVentoVel18h_1;
    private javax.swing.JLabel jLabelVentoVel18h_2;
    private javax.swing.JLabel jLabelVentoVel18h_3;
    private javax.swing.JLabel jLabelVentoVel18h_4;
    private javax.swing.JLabel jLabelVentoVel18h_5;
    private javax.swing.JLabel jLabelVentoVel18h_6;
    private javax.swing.JLabel jLabelVentoVel18h_7;
    private javax.swing.JLabel jLabelVentoVel21h_1;
    private javax.swing.JLabel jLabelVentoVel21h_2;
    private javax.swing.JLabel jLabelVentoVel21h_3;
    private javax.swing.JLabel jLabelVentoVel21h_4;
    private javax.swing.JLabel jLabelVentoVel21h_5;
    private javax.swing.JLabel jLabelVentoVel21h_6;
    private javax.swing.JLabel jLabelVentoVel21h_7;
    private javax.swing.JLabel jLabelVoltar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelAlertas;
    private javax.swing.JPanel jPanelBackground;
    private javax.swing.JPanel jPanelDia1;
    private javax.swing.JPanel jPanelDia2;
    private javax.swing.JPanel jPanelDia3;
    private javax.swing.JPanel jPanelDia4;
    private javax.swing.JPanel jPanelDia5;
    private javax.swing.JPanel jPanelDia6;
    private javax.swing.JPanel jPanelDiaAnt;
    private javax.swing.JPanel jPanelPrevisoes;
    private javax.swing.JPanel jPanelPrevisoesAnt;
    private diu.swe.habib.JPanelSlider.JPanelSlider jPanelSliderAntPrevisoes;
    private diu.swe.habib.JPanelSlider.JPanelSlider jPanelSliderPrevisoes;
    private javax.swing.JProgressBar jProgressBarAtualiza;
    private javax.swing.JScrollPane jScrollPaneAlertas;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPanePrevisoes;
    private javax.swing.JTable jTableAlertas;
    private javax.swing.JTextField jTextFieldAntCodCidade;
    private javax.swing.JTextField jTextFieldCodCidade;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerPeriodo;
    // End of variables declaration//GEN-END:variables
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/earth.png")));
    }
}
