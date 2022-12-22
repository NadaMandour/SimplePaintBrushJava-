/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;



import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
/**
 *
 * @author 20127
 */
public class MyProjectPanel extends JPanel {

     int x1,y1 ,x2,y2; 
     int width, hight;
 
  Vector <VectorLines> vecLines= new Vector<>();
  Vector <VectorCircles> vecCircles= new Vector<>();
  Vector <VectorRectangles> vecRects= new Vector<>();
  Vector <VectorCircles> vecBrush= new Vector<>();
  Vector <VectorCircles> vecEraser= new Vector<>();

  int index ,indexC , indexR ,indexFree ,indexErase; 
  
  int flag;
  int filled;
  int dotted;
  
   JButton line;
   JButton circle;
   JButton rect;
   JButton black;
   JButton red;
   JButton green;
   JButton blue;
   JButton clearAll;
   JButton brush;
   JButton eraser;
   
   JCheckBox checkFill;
   JCheckBox checkDotted;
   
   Color color= new Color(0,0,0);
   Color bgcolor= new Color(0,0,0);
 
   public MyProjectPanel() {
        x1=0;
        y1=0;
        x2=0;
        y2=0;
        index=0;
        indexC=0;
        indexR=0;
        indexFree=0;
        indexErase=0;
        flag=0;
        filled=0;
        dotted=0;
        bgcolor=Color.PINK;
        this.setBackground(bgcolor);
        this.setFocusable(true);
       
        
        System.out.println("default consructor ");
       /***********************************/
       checkFill=new JCheckBox("Filled");
       checkFill.addItemListener(new ItemListener (){
            @Override
            public void itemStateChanged(ItemEvent e) {
              if (e.getStateChange()==1)
                   filled=1;
              else  filled=0;
            }
    
        });
        /***********************************/
       checkDotted=new JCheckBox("Dotted");
       checkDotted.addItemListener(new ItemListener (){
            @Override
            public void itemStateChanged(ItemEvent e) {
              if (e.getStateChange()==1)
                   dotted=1;
              else  dotted=0;
            }
    
        });
       
       
/********************************/
        line =new JButton ("line");
        line.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                flag=1;
                
                 System.out.println("buton pressed ");
                       System.out.println("flag "+flag);

           // updateUI();
            }
            
        });
     /*********************************/
     
      circle =new JButton ("Oval");
        circle.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                flag=2;
                
                 System.out.println("buton pressed ");
                       System.out.println("flag " +flag);

           // updateUI();
            }
            
        });
     /*********************************/
      rect =new JButton ("Rectangle");
        rect.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                flag=3;
                
                 System.out.println("buton pressed ");
                       System.out.println("flag "+flag);

           // updateUI();
            }
            
        });
     /*********************************/
    brush =new JButton ("Brush");
        brush.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                flag=4;
                
                 System.out.println("buton pressed ");
                       System.out.println("flag "+flag);

           // updateUI();
            }
            
        });
     
      /****************************/
      
       eraser =new JButton ("Eraser");
        eraser.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                flag=5;
                
                 System.out.println("eraser pressed ");
                       System.out.println("flag "+flag);

           // updateUI();
            }
            
        });
     
      /****************************/
      clearAll =new JButton ("clearAll");
        clearAll.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
             flag=0;
        index=0;
        indexC=0;
        indexR=0;
        indexFree=0;
        indexErase=0;

                  vecLines.clear();
                  System.out.println("clearLines ");
                 vecRects.clear();
                 System.out.println("clearRects ");
                 vecCircles.clear();
                 System.out.println("clearCircle ");
             
                 updateUI();
                
                 System.out.println("clearAll pressed ");
                      
            }
            
        });
        
        
     /*************************************/
     
     // colors button
     /******************************/
     /******************************/
        black =new JButton ("black");
        black.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                color=Color.BLACK;
                
                 System.out.println("black pressed ");
                      
            }
            
        });
      /********************************/
        red =new JButton ("red");
        red.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                color=Color.RED;
                
                 System.out.println("Red pressed ");
                      
            }
            
        });
      /********************************/
green =new JButton ("green");
        green.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                 color=Color.GREEN;
                
                 System.out.println("green pressed ");
                      
            }
            
        });
      /********************************/
       blue =new JButton ("blue");
        blue.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                color=Color.BLUE;
                
                 System.out.println("Blue pressed ");
                      
            }
            
        });
      /********************************/ 
     System.out.println("flag shape "+flag);

        this.addMouseListener( new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                 if (flag==1) //line
                 {
                x1=e.getX();
                y1=e.getY();
               //vecLines.add(new VectorLines(x1,y1 ,x2,y2));

                 }
                 else if (flag==2) //circle
                 {
                  x1=e.getX();
                  y1=e.getY(); 
                 }
                  else if (flag==3) //rect
                 {
                  x1=e.getX();
                  y1=e.getY(); 
                 }
                  else if (flag==4)//brush
                  {
                  x1=e.getX();
                  y1=e.getY();
                   width=5;
                    hight=5;
                   //filled=0;
                  vecBrush.add(indexFree,new VectorCircles(x1,y1 ,width,hight,color,filled,dotted));
                  indexFree++;
                   updateUI();
                  }
                 else if (flag==5)//eraser
                  {
                  x1=e.getX();
                  y1=e.getY();
                   width=8;
                    hight=8;
                  //  filled=1;
                 vecEraser.add(indexErase,new VectorCircles(x1,y1 ,width,hight,bgcolor,filled,dotted));
                  indexErase++;
                   updateUI();
                  }
            }
            
            

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                  if (flag==1) //line
                 {
                x2=e.getX();
                y2=e.getY();
            
                   index++;
        
                 }
                  /***************/
                  else if (flag==2) //circle
                 {
                     
                    width= e.getX() -x1;
                    hight=e.getY()- y1;
//                    if (width<0)
//                        width=width*-1;
//                    if (hight<0)
//                        hight*=-1;
                 indexC++;
                 
                 }
                  /***************/
                   else if (flag==3) //rect
                 {
                    width=e.getX() -x1;
                    hight=e.getY()- y1;
                 indexR++;
                 
                 }
//                   else if (flag==4) //brush
//                 {
//                    width=5;
//                    hight=5;
//               //  indexFree++;
//                 
//                 }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        
        
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              if (flag==1) //line
                 {
               x2=e.getX();
                y2=e.getY();

                vecLines.add(index,new VectorLines(x1,y1 ,x2,y2,color,dotted));
                updateUI();
            
                 }
              
              /**************************/
              else if (flag==2) //circle
                 {
                    width=e.getX() -x1;
                    hight=e.getY()- y1;
//                    if (width<0)
//                        width=width*-1;
//                    if (hight<0)
//                        hight*=-1;
                  vecCircles.add(indexC,new VectorCircles(x1,y1 ,width,hight,color,filled,dotted));
                    
                    updateUI();
                 }
               else if (flag==3) //rect
                 {
                    width=e.getX() -x1;
                    hight=e.getY()- y1;
                  vecRects.add(indexR,new VectorRectangles(x1,y1 ,width,hight,color,filled,dotted));
                    
                    updateUI();
                 }
              else if (flag==4) //brush
                 {
                   x1=e.getX();
                  y1=e.getY();
                    width=5;
                    hight=5;
//                    filled=0;
//                    dotted=0;
                  vecBrush.add(indexFree,new VectorCircles(x1,y1 ,width,hight,color,filled,dotted));
                              indexFree++;       

                    updateUI();
                 }
               else if (flag==5) //Eraser
                 {
                   x1=e.getX();
                  y1=e.getY();
                    width=8;
                    hight=8;
//                    filled=0;
//                    dotted=0;
                  vecEraser.add(indexErase,new VectorCircles(x1,y1 ,width,hight,bgcolor,filled,dotted));
                              indexErase++;       

                    updateUI();
                 }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
 
       
       // adding buttons to panel
       this.add(checkFill);
       this.add(checkDotted);
       this.add(line);
       this.add(circle);
       this.add(rect);
       this.add(brush);

       this.add(black);
       this.add(red);
       this.add(green);
       this.add(blue);
       this.add(eraser);
       this.add(clearAll);

    
    }
  /************************************************************************************/
  //*********************** INNER CLASSES*************************/
  /*************************************************************************************/
 // inner class vector to save the data of the line 
         class VectorLines {
            Color color =new Color(0,0,0);
             int x1,y1 ,x2,y2 ,dotted;
         public VectorLines() {
             }

        public VectorLines(int x1, int y1, int x2, int y2, Color color,int dotted) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.color=color;
            this.dotted=dotted;
            
        }
     }
   
   /***************************************/
        // inner class vector to save the data of the Circle 
         class VectorCircles {
               Color color =new Color(0,0,0);
             int x1,y1 ,width,hight ,filled , dotted;
         public VectorCircles() {
             }

        public VectorCircles(int x1, int y1, int width, int hight,Color color ,int filled, int dotted) {
            this.x1 = x1;
            this.y1 = y1;
            this.width = width;
            this.hight = hight;
            this.color=color;
            this.filled=filled;
            this.dotted=dotted;
        }
     }
   /***************************************/
        
         // inner class vector to save the data of the Rectangle 
         class VectorRectangles{
             Color color =new Color(0,0,0);
             int x1,y1 ,width,hight, filled , dotted;
         public VectorRectangles() {
             }

        public VectorRectangles(int x1, int y1, int width, int hight,Color color,int filled , int dotted) {
            this.x1 = x1;
            this.y1 = y1;
            this.width = width;
            this.hight = hight;
             this.color=color;
             this.filled=filled;
             this.dotted=dotted;
        }
     }
         
    /***************************************/
   /************************************************************************************/
  /*************************************************************************************/ 
    
         @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
          g.setColor(color);
             Graphics2D g2d= (Graphics2D) g.create();
             Stroke dashed= new BasicStroke(1,BasicStroke.CAP_BUTT ,BasicStroke.JOIN_BEVEL ,0,new float[]{9},0);
             g2d.setStroke(dashed);
             
             

 if (flag==1) // line
 {
       g.setColor(color);
    if (dotted==0)
       g.drawLine(x1, y1, x2, y2); 
    else if (dotted==1) g2d.drawLine(x1, y1, x2, y2); 
 }
 /************/
 else if (flag==2) //circle
 {  g.setColor(color);
  
     if (filled==0)// draw not filled 
     { if (dotted==1)   g2d.drawOval(x1, y1, width, hight);   
         else g.drawOval(x1, y1, width, hight);}
     else if(filled==1) g.fillOval(x1, y1, width, hight); //fill 
  
 }
 /************/
 else if (flag==3) //rect
 {  g.setColor(color);
     if (filled==0)// draw
     { if (dotted==1)  g2d.drawRect(x1, y1, width, hight);
        else g.drawRect(x1, y1, width, hight);} 
  else if(filled==1)g.fillRect(x1, y1, width, hight);
 }
 /**************/
 else if (flag==4) //brush
 {  g.setColor(color);
    g.fillOval(x1, y1, width, hight);
 
 }
 /*****************/
 else if (flag==5) //eraser
 {
     g.setColor(bgcolor);
    g.fillOval(x1, y1, width, hight);
 
 }
 
 
        for (int i=0; i<index ; i++)// lines
      {  g.setColor(vecLines.get(i).color);
        if (vecLines.get(i).dotted==0) // not dotted
           g.drawLine(vecLines.get(i).x1, vecLines.get(i).y1, vecLines.get(i).x2, vecLines.get(i).y2);
            else if (vecLines.get(i).dotted==1)
            { g2d.setColor(vecLines.get(i).color);
                g2d.drawLine(vecLines.get(i).x1, vecLines.get(i).y1, vecLines.get(i).x2, vecLines.get(i).y2);
               }
        }
        
  for (int i=0; i<indexC ; i++) //circles 
      {
            g.setColor(vecCircles.get(i).color);
            if (vecCircles.get(i).filled==0){// draw not filled 
                if (vecCircles.get(i).dotted==1)
           g2d.drawOval(vecCircles.get(i).x1, vecCircles.get(i).y1, vecCircles.get(i).width, vecCircles.get(i).hight);
                else g.drawOval(vecCircles.get(i).x1, vecCircles.get(i).y1, vecCircles.get(i).width, vecCircles.get(i).hight); }
           else if (vecCircles.get(i).filled==1) g.fillOval(vecCircles.get(i).x1, vecCircles.get(i).y1, vecCircles.get(i).width, vecCircles.get(i).hight);
      }
  
 for (int i=0; i<indexR ; i++)//rects
      {
            g.setColor(vecRects.get(i).color);
             if (vecRects.get(i).filled==0)// draw
             { if (vecRects.get(i).dotted==1) g2d.drawRect(vecRects.get(i).x1, vecRects.get(i).y1, vecRects.get(i).width, vecRects.get(i).hight);
                else g.drawRect(vecRects.get(i).x1, vecRects.get(i).y1, vecRects.get(i).width, vecRects.get(i).hight);}
            else if (vecRects.get(i).filled==1) g.fillRect(vecRects.get(i).x1, vecRects.get(i).y1, vecRects.get(i).width, vecRects.get(i).hight);
      }
 
  for (int i = 0; i < indexFree ; i++)// brush
  {  g.setColor(vecBrush.get(i).color);
            g.fillOval(vecBrush.get(i).x1, vecBrush.get(i).y1, 5, 5);
    }

    
  for (int i = 0; i < indexErase ; i++) //eraser
  {
      g.setColor(bgcolor);
            g.fillOval(vecEraser.get(i).x1, vecEraser.get(i).y1, 5, 5);
    }
    
    
    
}
}