
package programa3_alc;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import javax.swing.JOptionPane;


public class Canvas extends javax.swing.JFrame {
    static int ScreenSizeHeight; static int ScreenSizeWidth; int OriginX; int OriginY;
    int OriginArrow1X; int OriginArrow1Y;
    int OriginArrow2X; int OriginArrow2Y;
    int OriginArrow3X; int OriginArrow3Y;
    double angulo = (float) 0.02;
    float X; float Y;
    float Xline1; float Yline1; float Xline2; float Yline2;
    float Y_Xline1; float Y_Yline1; float Y_Xline2; float Y_Yline2;
    float Z_Xline1; float Z_Yline1;
    float XbaseX; float XbaseY; float YbaseX; float YbaseY; float ZbaseX; float ZbaseY;
    int drawing_flag = 0;
    Graphics t;
    
    float eje_x, eje_y, eje_z;
    float a_1, a_2, a_3; // Incognitas de la combinación lineal
    float[] incognitas_a = new float[3];

    private float matriz[][] = new float[3][4];
    float determinante;

    
    public Canvas() {
        initComponents();
        setEnviroment();
       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Slider = new javax.swing.JSlider();
        Texto1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Punto = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Base = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Slider.setMajorTickSpacing(10);
        Slider.setMaximum(324);
        Slider.setMinimum(-324);
        Slider.setMinorTickSpacing(50);
        Slider.setValue(2);
        Slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderStateChanged(evt);
            }
        });

        Texto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Texto1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Rotar alrededor del eje z");

        jLabel2.setText("P=");

        Punto.setText("Enter");
        Punto.setToolTipText("");
        Punto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PuntoActionPerformed(evt);
            }
        });

        jLabel3.setText("Base B=");

        Base.setText("Enter");
        Base.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BaseActionPerformed(evt);
            }
        });

        jLabel4.setText("u=");

        jLabel5.setText("v=");

        jLabel6.setText("w=");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Slider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Base))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Texto1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Punto)))))
                        .addGap(18, 18, 18)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(Slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Texto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Punto))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Base)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6))
                    .addComponent(jLabel3))
                .addContainerGap(192, Short.MAX_VALUE))
        );

        Slider.getAccessibleContext().setAccessibleParent(Slider);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Texto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Texto1ActionPerformed

    }//GEN-LAST:event_Texto1ActionPerformed

    private void PuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PuntoActionPerformed
        String entrada = Texto1.getText();
        if (entrada.matches("^[,.0-9]+$")){
            String[] coordenates = entrada.split(",");
            eje_x = Float.parseFloat(coordenates[0]);
            eje_y = Float.parseFloat(coordenates[1]);
            eje_z = Float.parseFloat(coordenates[2]);
            Slider.setValue(2);
            drawing_flag = 1;
            CaculateRotation(eje_x, eje_y, eje_z, angulo);


            
        }
        else
        {
            JOptionPane.showMessageDialog(this, "La entrada ingresada no es permitida.\n El formato es: X,Y,Z","Error",JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_PuntoActionPerformed

     private boolean ObtenerDatos(boolean pCombinacion)
    {
    	String entrada_U = jTextField2.getText(); //"1,0,1"; //jTextField_U.getText();
    	String entrada_V = jTextField5.getText(); //"0,1,1"; //jTextField_V.getText();
    	String entrada_W = jTextField6.getText(); //"1,0,1"; //jTextField_W.getText();

    	 if (entrada_U.matches("^[,.0-9]+$") & entrada_U.matches("^[,.0-9]+$") & entrada_W.matches("^[,.0-9]+$"))
         {
             String[] coordenates_U = entrada_U.split(",");
             String[] coordenates_V = entrada_V.split(",");
             String[] coordenates_W = entrada_W.split(",");

             matriz[0][0] = Float.parseFloat(coordenates_U[0]);
             matriz[0][1] = Float.parseFloat(coordenates_V[0]);
             matriz[0][2] = Float.parseFloat(coordenates_W[0]);

             matriz[1][0] = Float.parseFloat(coordenates_U[1]);
             matriz[1][1] = Float.parseFloat(coordenates_V[1]);
             matriz[1][2] = Float.parseFloat(coordenates_W[1]);

             matriz[2][0] = Float.parseFloat(coordenates_U[2]);
             matriz[2][1] = Float.parseFloat(coordenates_V[2]);
             matriz[2][2] = Float.parseFloat(coordenates_W[2]);

             if (pCombinacion)
             {
            	 matriz[0][3] = eje_x; matriz[1][3] = eje_y; matriz[2][3] = eje_z; // Igualdades de las ecuaciones = 
             }
             else
             {
            	 matriz[0][3] = 0; matriz[1][3] = 0; matriz[2][3] = 0;
             }

         }
         else { return false; }
    	 return true;
    }
     
    private boolean EjecutarBareiss()
    {
    	Bareiss bareiss = new Bareiss(matriz, 3);
    	boolean termino = bareiss.IniciarProceso();

    	if (termino)
    	{
            determinante = Float.parseFloat(bareiss.getDeterminante());
            
            incognitas_a = bareiss.getIncognitasSistema(); // Obtencion de las incognitas de la combinacion lineal
            
            return true;
    	}
    	else { return false; }
    }
    
    private void SliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderStateChanged
        int rotacion = Slider.getValue();
        angulo = -(float)rotacion/100;
        CaculateRotation(a_1, a_2, a_3, angulo);
        RefreshScreen();
    }//GEN-LAST:event_SliderStateChanged

    private void BaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BaseActionPerformed
        boolean continuar = ObtenerDatos(false); // Verificar si es l.independiente

            if (continuar)
            {
            	ObtenerDatos(true); // Obtener los datos pero con la combinacion lineal
            	boolean termino = EjecutarBareiss();

            	if (termino)
            	{ 
                    if (determinante != 0)
                    {
                        a_1 = incognitas_a[0];
                        a_2 = incognitas_a[1];
                        a_3 = incognitas_a[2];
                        
                        //eje_x = a_1; eje_y = a_2; eje_z = a_3;
                        CaculateRotation(a_1, a_2, a_3, angulo);
                        setBaseAxis();
                        RefreshScreen();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "El sistema ingresado no es l.independiente.","Error",JOptionPane.ERROR_MESSAGE);
                    }
            	}
            	else
            	{
                    JOptionPane.showMessageDialog(this, "El sistema ingresado es inválido.","Error",JOptionPane.ERROR_MESSAGE);
            	}
            }
            else
            {
            	JOptionPane.showMessageDialog(this, "Por favor inserte correctamente los valores de los tres conjuntos; U, V y W.","Error",JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_BaseActionPerformed
    
    void setEnviroment(){
        Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        ScreenSizeHeight = ScreenSize.height; ScreenSizeHeight = (ScreenSizeHeight-(ScreenSizeHeight/3));
        ScreenSizeWidth  = ScreenSize.width; ScreenSizeWidth = (ScreenSizeWidth-(ScreenSizeWidth/2)-(ScreenSizeWidth/5));
        OriginX = ScreenSizeWidth/2;
        OriginY = (ScreenSizeHeight/3)*2;
        OriginArrow1X = OriginX; OriginArrow1Y = OriginY-150;
        OriginArrow2X = OriginX-125; OriginArrow2Y = OriginY+65;
        OriginArrow3X = OriginX+125; OriginArrow3Y = OriginY+65;
        this.setSize(ScreenSizeWidth, ScreenSizeHeight);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.decode("#b3e6ff"));
        this.setResizable(false);
        t = this.getGraphics();
    }
  
    void RefreshScreen(){
        if(drawing_flag == 0){return;}
        Graphics obj = this.getGraphics();

        // CLEAN PART ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        obj.clearRect(21, (ScreenSizeHeight/2)-(ScreenSizeHeight/4)+1, (ScreenSizeWidth-45)-1, (ScreenSizeHeight/2)+(ScreenSizeHeight/4)-35);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        t.setColor(Color.decode("#66ccff"));
        t.drawRect(20, (ScreenSizeHeight/2)-(ScreenSizeHeight/4), (ScreenSizeWidth-45), (ScreenSizeHeight/2)+(ScreenSizeHeight/4));
        t.setColor(Color.decode("#ffffff"));
        t.fillRect(21, (ScreenSizeHeight/2)-(ScreenSizeHeight/4)+1, (ScreenSizeWidth-45)-1, (ScreenSizeHeight/2)+(ScreenSizeHeight/4));
        
        
        
        obj.setColor(Color.decode("#b3b3b3"));
          
        Graphics2D flecha = (Graphics2D) obj;
        
        flecha.setStroke(new BasicStroke(2));
        
        // FLECHA EJE Z
        flecha.drawLine(OriginX, OriginY, OriginArrow1X, OriginArrow1Y);
        flecha.drawPolygon(new int[]{OriginArrow1X-8,OriginArrow1X, OriginArrow1X+8}, new int[]{OriginArrow1Y,OriginArrow1Y-15,OriginArrow1Y}, 3);
        flecha.fillPolygon(new int[]{OriginArrow1X-8,OriginArrow1X, OriginArrow1X+8}, new int[]{OriginArrow1Y,OriginArrow1Y-15,OriginArrow1Y}, 3);

        
        
        //Draw X axis dotted line
        flecha.setColor(Color.GREEN);
        Stroke dotted = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] {5}, 0);
        flecha.setStroke(dotted);
        flecha.drawLine(OriginX+(int)Xline1, OriginY-(int)Yline1, OriginX+(int)Xline2, OriginY-(int)Yline2);
        //Draw Y axis dotted line
        flecha.drawLine(OriginX+(int)Y_Xline1, OriginY-(int)Y_Yline1, OriginX+(int)Y_Xline2, OriginY-(int)Y_Yline2);
        //Draw Z axis dotted line
        flecha.drawLine(OriginX+(int)Z_Xline1, OriginY-(int)Z_Yline1, OriginX+(int)X, OriginY-(int)Y);
        
        //Draw red dot
        flecha.setStroke(new BasicStroke(2));
        flecha.setColor(Color.red);
        Ellipse2D.Double shape = new Ellipse2D.Double(OriginX+X-4, OriginY-Y-3, 10, 10);
        flecha.draw(shape);
        flecha.fill(shape);
        
        
        flecha.setColor(Color.BLUE);
        flecha.drawLine(OriginX, OriginY, (int)(OriginX+ZbaseX), (int)(OriginY-ZbaseY));
        flecha.rotate(angulo, OriginX, OriginY);
        flecha.setColor(Color.decode("#b3b3b3"));
        // FLECHA EJE X
        flecha.drawLine(OriginX, OriginY, OriginArrow2X, OriginArrow2Y);
        flecha.drawPolygon(new int[]{OriginArrow2X-11,OriginArrow2X-3,OriginArrow2X+5}, new int[]{OriginArrow2Y+7,OriginArrow2Y-8,OriginArrow2Y+7}, 3);
        flecha.fillPolygon(new int[]{OriginArrow2X-11,OriginArrow2X-3,OriginArrow2X+5}, new int[]{OriginArrow2Y+7,OriginArrow2Y-8,OriginArrow2Y+7}, 3);
        

        

        
        
        // FLECHA EJE Y
        flecha.drawLine(OriginX, OriginY, OriginArrow3X, OriginArrow3Y);
        flecha.drawPolygon(new int[]{OriginArrow3X-5,OriginArrow3X+3,OriginArrow3X+11}, new int[]{OriginArrow3Y+7,OriginArrow3Y-8,OriginArrow3Y+7}, 3);
        flecha.fillPolygon(new int[]{OriginArrow3X-5,OriginArrow3X+3,OriginArrow3X+11}, new int[]{OriginArrow3Y+7,OriginArrow3Y-8,OriginArrow3Y+7}, 3);
        
        
        flecha.setColor(Color.BLUE);
        flecha.drawLine(OriginX, OriginY, (int)(OriginX+XbaseX), (int)(OriginY-XbaseY));
        
        flecha.drawLine(OriginX, OriginY, (int)(OriginX+YbaseX), (int)(OriginY-YbaseY));
        
        
        
        
        flecha.dispose();

    }
    
    void CalculatePoint(float x, float y, float z){
        X = y - x;
        Y = (float)-0.5*(x + y - 2*z); 
        
        //Calculate X axis line
        Xline1 = (y-y) - x; Yline1 = (float)-0.5*(x + (y-y) - 2*(z-z));
        Xline2 = y - x; Yline2 = (float)-0.5*(x + y - 2*(z-z));
        
        //Calculate Y axis line
        Y_Xline1 = y - (x-x); Y_Yline1 = (float)-0.5*((x-x) + y - 2*(z-z));
        Y_Xline2 = y - x; Y_Yline2 = (float)-0.5*(x + y - 2*(z-z));
        
        
        //Calculate Z axis line
        Z_Xline1 = y - x; Z_Yline1 = (float)-0.5*(x + y - 2*(z-z));
        
        
        
    }
    
    void setBaseAxis(){
        XbaseX = 8*matriz[0][1] - 8*matriz[0][0];
        XbaseY = (float)-0.5*(8*matriz[0][0] + 8*matriz[0][1] - 8*2*matriz[0][2]);
        
        YbaseX = 8*matriz[1][1] - 8*matriz[1][0];
        YbaseY = (float)-0.5*(8*matriz[1][0] + 8*matriz[1][1] - 8*2*matriz[1][2]);
        
        ZbaseX = 8*matriz[2][1] - 8*matriz[2][0];
        ZbaseY = (float)-0.5*(8*matriz[2][0] + 8*matriz[2][1] - 8*2*matriz[2][2]);
        
    }
    
    void CaculateRotation(float x, float y, float z, double rotacion){
       rotacion = -rotacion;
       float a = (float)Math.cos(rotacion);float b = -(float)Math.sin(rotacion);float c = 0;
       float d = (float)Math.sin(rotacion);float e = (float)Math.cos(rotacion);float f = 0;
       float g = 0;float h = 0;float i = 1;
       
       float result1 = a*x + b*y + c*z;
       float result2 = d*x + e*y + f*z;
       float result3 = g*x + h*y + i*z;
       
       
       CalculatePoint(result1, result2, result3);
       
       
    }
    
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
            java.util.logging.Logger.getLogger(Canvas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Canvas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Canvas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Canvas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Canvas().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Base;
    private javax.swing.JButton Punto;
    private javax.swing.JSlider Slider;
    private javax.swing.JTextField Texto1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
