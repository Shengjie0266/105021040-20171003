import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private Container cp;
    private JButton jbtn1 = new JButton("Example");
    private JButton jbtn2 = new JButton("Encrypt");
    private JButton jbtn3 = new JButton("Clear");
    private JButton jbtn4 = new JButton("Exit");
    private JLabel jlb = new JLabel("Key");
    private JPanel jpac = new JPanel(new GridLayout(6,1,3,3));
    private JTextArea jtaL = new JTextArea();
    private JTextArea jtaR = new JTextArea();
    private JScrollPane jspL = new JScrollPane(jtaL);
    private JScrollPane jspR = new JScrollPane(jtaR);
    private JTextField jtfKey = new JTextField();

    int count = 0;

    public MainFrame(){
        init();
    }
    private void init(){
       this.setBounds(100,100,500,400);
       this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       cp = this.getContentPane();
       cp.setLayout(new BorderLayout(3,3));
       cp.add(jpac,BorderLayout.CENTER);
       cp.add(jspL,BorderLayout.WEST);
       cp.add(jspR,BorderLayout.EAST);
       jtaL.setPreferredSize(new Dimension(200,400));
       jtaR.setPreferredSize(new Dimension(200,400));
       jtaL.setLineWrap(true);
       jtaR.setLineWrap(true);
       jpac.add(jbtn1);
       jpac.add(jbtn2);
       jpac.add(jlb);
       jpac.add(jtfKey);
       jpac.add(jbtn3);
       jpac.add(jbtn4);
       jlb.setHorizontalAlignment(JLabel.CENTER);
        jbtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaL.setText("The Department of Computer Science and Information Engineering," +
                        " formerly the Department of Information Technology, was established in 2001." +
                        " The department first offered a Master program only. In 2002, the undergraduate " +
                        "program was established. The Doctoral program was established in 2006. Each year " +
                        "the department admits about 80 undergraduates, 15 graduate students and 3 Ph.D. students.");
            }
        });
        jbtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char data[] = jtaL.getText().toCharArray();
                int len = data.length,key=Integer.parseInt(jtfKey.getText());
                for(int i = 0;i<len;i++){
                    data[i] += key;
                }
                jtaR.setText(new String(data));
            }
        });
        jbtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtaL.setText(" ");
            }
        });
        jbtn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}
