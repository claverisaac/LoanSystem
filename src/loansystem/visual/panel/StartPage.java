/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loansystem.visual.panel;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JPanel;
import loansystem.Principal;
import loansystem.bd.Conexion;
import loansystem.dao.GraficoDAO;
import loansystem.entidad.GraficoEntidad;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;

/**
 *
 * @author cgarcia
 */
public class StartPage extends javax.swing.JPanel {

    private GraficoDAO gDao;
    private Conexion con;
    private Principal prin;
    private final int BAR = 1, PIE = 2, LINE=3;
    /**
     * Creates new form StartPage
     */
    public StartPage(Principal prin, Conexion con) {
        this.prin = prin;
        this.con = con;
        initComponents();

        gDao = new GraficoDAO(con.getCon());
        graficoPrestamoXMes2();
        graficoOtorgadoVsCobrado();
        graficoPorEstado();
    }

    private void graficoPrestamoXMes() {
        ArrayList<GraficoEntidad> graficos;
        graficos = gDao.obtenerPrestamosPorMes();

        if (graficos.size() > 0) {
            DefaultCategoryDataset datos = new DefaultCategoryDataset();

            for (GraficoEntidad result : graficos) {
                datos.addValue(result.getValor(), result.getSerie(), result.getValorEje());
            }

            JFreeChart grafica = ChartFactory.createBarChart("Registros Por Mes",
                    "Mes", "Préstamos", datos,
                    PlotOrientation.VERTICAL, true, true, false);
            ChartPanel panel = new ChartPanel(grafica);
            pnelPrestamosMes.add(panel);
            pnelPrestamosMes.revalidate();
            pnelPrestamosMes.repaint();

        }

    }

    private void graficoPrestamoXMes2() {
        ArrayList<GraficoEntidad> graficos;
        graficos = gDao.obtenerPrestamosPorMes();

        if (graficos.size() > 0) {
            DefaultCategoryDataset datos = new DefaultCategoryDataset();

            for (GraficoEntidad result : graficos) {
                datos.setValue(result.getValor(), result.getSerie(), result.getValorEje());
            }
            
             dibujarGrafico(datos, BAR, "Registros Por Mes", "Mes", "Préstamos",PlotOrientation.VERTICAL, pnelPrestamosMes);


        }

    }

    /**
     *
     */
    private void graficoOtorgadoVsCobrado() {
        ArrayList<GraficoEntidad> graficos;
        graficos = gDao.obtenerMontoPagoXMoneda();

        if (graficos.size() > 0) {
            DefaultCategoryDataset datos = new DefaultCategoryDataset();

            for (GraficoEntidad result : graficos) {
                datos.setValue(result.getValor(), result.getSerie(), result.getValorEje());
            }

            dibujarGrafico(datos, BAR, "Otorgado vs Recuperado", "Moneda", "Monto",PlotOrientation.VERTICAL,pnelOtorgadoRecuperado);

        }

    }
    
    private void dibujarGrafico(DefaultCategoryDataset datos, int tipoGrafico, String titulo, String ejeX, String ejeY, PlotOrientation orientacion, JPanel contenedor){
        JFreeChart grafica = null;
        
        switch(tipoGrafico)
        {
            case BAR:
                 grafica = ChartFactory.createBarChart3D(titulo, ejeX, ejeY,
                    datos, orientacion, true, true, false);
                break;
            case LINE:
                
                break;
                
            case PIE:
                
                break;
        }
        
            grafica.getTitle().setPaint(Color.black);
            
            CategoryPlot p = grafica.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);

            CategoryItemRenderer renderer = ((CategoryPlot) grafica.getPlot()).getRenderer();
            renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            renderer.setBaseItemLabelsVisible(true);
            ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12,
                    TextAnchor.BASELINE_CENTER);
            renderer.setBasePositiveItemLabelPosition(position);

            int style = Font.BOLD;
            Font font = new Font("Tahoma", style, 12);
            renderer.setItemLabelFont(font);

            ChartPanel panel = new ChartPanel(grafica);
            contenedor.add(panel);
            contenedor.revalidate();
            contenedor.repaint();
    }
    
    private void graficoPorEstado()
    {
         ArrayList<GraficoEntidad> graficos;
         graficos = gDao.obtenerPrestamosPorEstado();
         DefaultPieDataset data = new DefaultPieDataset();
        
         if (graficos.size() > 0) {
           

            for (GraficoEntidad result : graficos) {
               //datos.setValue(result.getValor(), result.getSerie(), result.getValorEje());
               data.setValue( result.getValorEje(), result.getValor());
            }

            //dibujarGrafico(datos, BAR, "Otorgado vs Recuperado", "Moneda", "Monto",PlotOrientation.VERTICAL,pnelOtorgadoRecuperado);

             // Creando el Grafico
            /*JFreeChart grafica = ChartFactory.createPieChart(
             "Préstamos por Estado", 
             data, 
             true, 
             true, 
             false);*/
            
          JFreeChart grafica = ChartFactory.createPieChart3D("Préstamos por Estado", data, true, true, false);
           grafica.setBackgroundPaint(Color.white); 
        PiePlot3D plot = (PiePlot3D) grafica.getPlot();
        plot.setForegroundAlpha(0.6f);
        plot.setCircular(true);
        plot.setLabelGap(0.01);
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} {1} ({2})"));
        plot.setBackgroundPaint(null);
        
                 
            
            // Mostrar Grafico
            ChartPanel panel = new ChartPanel(grafica);
                pnelPorEstado.add(panel);
                pnelPorEstado.revalidate();
                pnelPorEstado.repaint();
            
            
        }
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        pnelCentro = new javax.swing.JPanel();
        pnelPrestamos = new javax.swing.JPanel();
        pnelPrestamosMes = new javax.swing.JPanel();
        pnelOtorgado = new javax.swing.JPanel();
        pnelOtorgadoRecuperado = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnelPorEstado = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 0, 102));
        com.l2fprod.common.swing.PercentLayout percentLayout1 = new com.l2fprod.common.swing.PercentLayout();
        percentLayout1.setOrientation(1);
        percentLayout1.setGap(10);
        setLayout(percentLayout1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loansystem/recursos/reportes.png"))); // NOI18N
        jLabel3.setText("DASHBOARD DE USO");
        add(jLabel3);

        pnelCentro.setBackground(new java.awt.Color(0, 0, 102));
        pnelCentro.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 15));

        pnelPrestamos.setBackground(new java.awt.Color(255, 255, 255));
        pnelPrestamos.setLayout(new java.awt.BorderLayout());

        pnelPrestamosMes.setBackground(new java.awt.Color(255, 255, 255));
        pnelPrestamosMes.setPreferredSize(new java.awt.Dimension(400, 200));
        pnelPrestamosMes.setLayout(new java.awt.GridLayout(1, 0));
        pnelPrestamos.add(pnelPrestamosMes, java.awt.BorderLayout.CENTER);

        pnelCentro.add(pnelPrestamos);

        pnelOtorgado.setBackground(new java.awt.Color(255, 255, 255));
        pnelOtorgado.setPreferredSize(new java.awt.Dimension(400, 200));
        pnelOtorgado.setLayout(new java.awt.BorderLayout());

        pnelOtorgadoRecuperado.setBackground(new java.awt.Color(255, 255, 255));
        pnelOtorgadoRecuperado.setPreferredSize(new java.awt.Dimension(500, 300));
        pnelOtorgadoRecuperado.setLayout(new java.awt.GridLayout(1, 0));
        pnelOtorgado.add(pnelOtorgadoRecuperado, java.awt.BorderLayout.CENTER);

        pnelCentro.add(pnelOtorgado);

        add(pnelCentro);

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        pnelPorEstado.setBackground(new java.awt.Color(255, 255, 255));
        pnelPorEstado.setPreferredSize(new java.awt.Dimension(400, 200));
        pnelPorEstado.setLayout(new java.awt.GridLayout(1, 0));
        jPanel1.add(pnelPorEstado);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnelCentro;
    private javax.swing.JPanel pnelOtorgado;
    private javax.swing.JPanel pnelOtorgadoRecuperado;
    private javax.swing.JPanel pnelPorEstado;
    private javax.swing.JPanel pnelPrestamos;
    private javax.swing.JPanel pnelPrestamosMes;
    // End of variables declaration//GEN-END:variables
}
