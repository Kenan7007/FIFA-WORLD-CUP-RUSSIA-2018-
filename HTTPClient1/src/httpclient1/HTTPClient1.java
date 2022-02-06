
package httpclient1;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class HTTPClient1 extends JFrame implements ActionListener{
     JTextField t;
    public HTTPClient1()
      {
          
          JLabel l = new JLabel("Enter Web Site");
          l.setBounds(50, 0, 150, 20);
           add(l);
          
          t = new JTextField("http://inf.ucv.ro/~mihaiug/index.html");
          t.setBounds(60, 100, 90, 40);
          t.setFont(new Font("Arial",Font.BOLD,26));
          add(t);
          
          JButton b = new JButton("Download");
          b.setBounds(60, 150, 80, 30);
          b.addActionListener(this);
          add(b);
          
          pack();
          setVisible(true);
          setLayout(new GridLayout());
          setTitle("Ip Finder");
          
      } 
        public static String getTextFile(String pageURL) throws MalformedURLException, IOException{
        URL url = new URL(pageURL);
        URLConnection connection = url.openConnection();
        connection.getHeaderFields();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder sb = new StringBuilder();
        sb.append(connection.getHeaderFields());
        String line = null;
        while ((line = in.readLine()) != null){
            sb.append(line);
            sb.append("\n");
        }
        return sb.toString();
        
    }

  

 
    public static void main(String[] args) {
      new HTTPClient1();

        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         String pageUrl = "http://inf.ucv.ro/~mihaiug/index.html";
          String pageContent = null;
         try {
             pageContent = getTextFile(pageUrl);
             JOptionPane.showMessageDialog(this, pageContent);
         } catch (MalformedURLException e) {
             JOptionPane.showMessageDialog(this, "Adresa web invalida : "+ e.getMessage());
         }
         catch (IOException e) {
             JOptionPane.showMessageDialog(this, "Eroare la downloadarea paginii: "+ e.getMessage());
    }
    
  }
    
}

