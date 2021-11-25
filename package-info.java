package com.onlineexam.rajat;
import java.awt.event.*;  
import javax.swing.*;  
  
class OnlineTest extends JFrame implements ActionListener  
{  
   
	private static final long serialVersionUID = 1L;
	JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    OnlineTest(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Bookmark");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1:Who invented Java Programming?");  
            jb[0].setText("Guido van Rossum");jb[1].setText("James Gosling");jb[2].setText("Dennis Ritchie");jb[3].setText("Bjarne Stroustrup");   
        }  
        if(current==1)  
        {  
            l.setText("Que2: Which statement is true about Java?");  
            jb[0].setText("Java is a sequence-dependent programming language");jb[1].setText("Java is a code dependent programming language");jb[2].setText("Java is a platform independent programming language");jb[3].setText("Java is a platform-dependent programming language");  
        }  
        if(current==2)  
        {  
            l.setText("Que3: Which of these cannot be used for a variable name in Java?");  
            jb[0].setText("identifier & keyword");jb[1].setText("identifier");jb[2].setText("none of the mentioned");jb[3].setText("keyword");  
        }
        if(current==3)  
        {  
            l.setText("Que4: String class is defined in which package?");  
            jb[0].setText("lang");jb[1].setText("Swing");jb[2].setText("Applet");jb[3].setText("awt");  
        } 
        if(current==4)  
        {  
            l.setText("Que5: What is not the use of “this” keyword in Java?");  
            jb[0].setText("Passing itself to the method of the same class");jb[1].setText("Referring to the instance variable when a local variable has the same name");jb[2].setText("Passing itself to another method");jb[3].setText("Calling another constructor in constructor chaining");  
        }
        if(current==5)  
        {  
            l.setText("Que6: Which of the following is a type of polymorphism in Java Programming?");  
            jb[0].setText("Multiple polymorphism");jb[1].setText("Run time polymorphism");jb[2].setText("Compile time polymorphism");jb[3].setText(" Execution time polymorphism");  
        }
        if(current==6)  
        {  
            l.setText("Que7: Which of the following package is used for text formatting in Java programming language?");  
            jb[0].setText("java.io");jb[1].setText("java.text");jb[2].setText("java.awt.text");  
                        jb[3].setText("java.awt");  
        }
        if(current==7)  
        {  
            l.setText("Que8:Which of the following is not a segment of memory in java?");  
            jb[0].setText("Code Segment");jb[1].setText("Stack Segment");jb[2].setText(" Heap Segment");  
                        jb[3].setText("Register Segment");         
        }
        if(current==8)  
        {  
            l.setText("Que9: What is Truncation in Java?");  
            jb[0].setText("Floating-point value assigned to a Floating type");jb[1].setText(" Floating-point value assigned to an integer type");jb[2].setText("Integer value assigned to floating type");jb[3].setText("Integer value assigned to floating type");  
        }
        if(current==9)  
        {  
            l.setText("Que10: Which one among these is not a valid component?");  
            jb[0].setText("JButton");jb[1].setText("JList");jb[2].setText("JButtonGroup");  
                        jb[3].setText("JTextArea");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[1].isSelected());  
        if(current==1)  
            return(jb[2].isSelected());  
        if(current==2)  
            return(jb[3].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[2].isSelected());  
        if(current==5)  
            return(jb[2].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[3].isSelected());  
        if(current==8)  
            return(jb[1].isSelected());  
        if(current==9)  
            return(jb[2].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new OnlineTest("Online Test Of Java");  
    }  
}  

        
        
     