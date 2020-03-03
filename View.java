import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class View extends JFrame {

    /**
     * definirea zonelor de unde se citesc datele de intrare
     * txt[0] inseamna coeficient
     * txt[1] inseamna exponent
     * txt[2] inseamna valoare pt evalare
     */
    protected JTextField[] txt = new JTextField[3];

    protected JLabel[] label = new JLabel[6]; //definirea labelu-rilor

    /*
     * butoanele aduaga si sterge
     */
    JButton badd,bdell;

    /**
     * vector pentru butoanele operatiilor
     * but[0] inseamna +
     * but[1] inseamna -
     * but[2] inseamna *
     * but[3] inseamna /
     * but[4] inseamna Derivare
     * but[5] inseamna Calculeaza
     * but[6] inseamna Integreaza
     * but[7] inseamna Schimba
     *
     */
    JButton[] but = new JButton[8];

    /**
     * cele 2 butoane radio
     * butA1 - polinomul A
     * butB1 - polinomul B
     */
    JRadioButton butA1,butB1;

    JPanel radioPanel1;

    /**
     *  zona in care se afiseaza polinoamele
     *  textArea[0] inseamna locul in care se afiseaza rezultatul operatiilor
     *  textArea[1] locul in care se afiseaza Polinomul A
     *  textArea[2] locul in care se afiseaza Polinomul B
     */
    JTextArea textArea[] = new JTextArea[3];

    JScrollPane scrollPane; //scroller-ul
    ButtonGroup group1; //grupul radio-butoanelor

    Control e = new Control(this);

    public static void main (String[] args) {
        View view = new View();
        view.setVisible(true);
    }

    /**
     * constructorul clasei Interfata
     */
    public View()
    {
        super();
        this.setSize(600, 600);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setupComponents();
    }

    /**
     * componentele clasei interfata
     */
    private void setupComponents()
    {
		/*
		 * creare label
		 */
        label[0] = new JLabel("coef");
        label[0].setBounds(10, 120, 150, 25);

        label[1] = new JLabel("exp");
        label[1].setBounds(110, 120, 150, 25);

        label[2] = new JLabel("val");
        label[2].setBounds(160, 370, 150, 25);

        label[3] = new JLabel("Polinomul A:");
        label[3].setBounds(210,155, 70, 25);

        label[4] = new JLabel("Polinomul B:");
        label[4].setBounds(210,255, 70, 25);

        label[5] = new JLabel("Rez:");
        label[5].setBounds(15, 10, 150, 25);
		
		
		/*
		 * crearea butoanelor
		 */
        badd = new JButton("Adauga");
        badd.setBounds(300, 120, 100, 25);

        bdell = new JButton("Sterge");
        bdell.setBounds(300, 90, 100, 25);

        but[0] = new JButton("+");
        but[0].setBounds(50, 155, 70, 25);

        but[1] = new JButton("-");
        but[1].setBounds(130, 155, 70, 25);

        but[2] = new JButton("*");
        but[2].setBounds(50, 185, 70, 25);

        but[3] = new JButton("/");
        but[3].setBounds(130, 185, 70, 25);

        but[4] = new JButton("<html>D<br>e<br>r<br>i<br>v</html>");
        but[4].setBounds(50, 215, 70, 125);

        but[5] = new JButton("Calc");
        but[5].setBounds(50, 345, 70, 25);

        but[6] = new JButton("<html>I<br>n<br>t<br>e<br>g<br>r</html>");
        but[6].setBounds(130, 215, 70, 125);

        but[7] = new JButton("<html>Schimba<br> A cu B</html>");
        but[7].setBounds(50, 395, 150, 50);
		
		/*
		 * crearea textFieldurilor
		 */
        txt[0] = new JTextField("");
        txt[0].setBounds(50, 120, 50, 25);

        txt[1] = new JTextField("0");
        txt[1].setBounds(150, 120, 50, 25);

        txt[2] = new JTextField("");
        txt[2].setBounds(130, 345, 70, 25);
		
		/*
		 * creare radioButton
		 */
        butA1 = new JRadioButton("Pol A");
        butA1.setActionCommand("Pol A");
        butA1.setSelected(true);

        butB1 = new JRadioButton("Pol B");
        butB1.setActionCommand("Pol B");
		
		/*
		 * grupare radio buttons.
		 */
        group1 = new ButtonGroup();
        group1.add(butA1);
        group1.add(butB1);
		
		/*
         * inregistrarea listenerelor pentru radio buttons.
         */
        butA1.addActionListener(e);
        butB1.addActionListener(e);

        /*
         * Punerea radiobuutoanelor intr-o linie.
         */
        radioPanel1 = new JPanel(new GridLayout(1, 0));
        radioPanel1.add(butA1);
        radioPanel1.add(butB1);

        radioPanel1.setBounds(50, 90, 150, 25);
        
        /*
         * inregistrarea keylistenerelor pentru textField.
         */
        for(int i=0;i<txt.length;i++)
        {
            txt[i].addKeyListener(e);
        }
		
		
		/*
		 * adaugare butoane in panel
		 */
        this.add(badd);
        this.add(bdell);
		
		/*
		 * aduagarea textFieldu-rilor in panel
		 */
        for(int i=0;i<txt.length;i++){
            this.add(txt[i]);
        }
		
		/*
		 * adaugare butoane in panel
		 */
        this.add(badd);
        this.add(bdell);
		
		/*
         * inregistrarea listenerelor pentru butoane.
         */
        badd.addActionListener(e);
        bdell.addActionListener(e);
		
		/*
		 * aduagare radiobutoane in panel
		 */
        this.add(radioPanel1);
		
		/*
		 * aduagare butoane in panel
		 */
        for(int i=0;i<but.length;i++){
            this.add(but[i]);
        }
		
		/*
		 * aduagare label in panel
		 */
        for(int i=0;i<label.length;i++){
            this.add(label[i]);
        }
		
		/*
         * inregistrarea listenerelor pentru butoane.
         */
        for(int i=0;i<but.length;i++){
            but[i].addActionListener(e);
        }
		
		/*
		 * creare si aduagare textArea in panel
		 * si a scrollului
		 */

        textArea[0] = new JTextArea(5, 20);
        textArea[0].setEditable(false);

        scrollPane = new JScrollPane(textArea[0]);
        scrollPane.setPreferredSize(new Dimension(200,200));

        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scrollPane.setBounds(50, 10, 350, 75);
        textArea[0].setBounds(50, 10, 350, 75);

        this.setLayout(null);
        this.add(scrollPane);

        textArea[1] = new JTextArea(5, 20);
        textArea[1].setEditable(false);
        textArea[1].setBounds(210, 185, 190, 65);
        this.add(textArea[1]);
        textArea[1].setText("0");

        textArea[2] = new JTextArea(5, 20);
        textArea[2].setEditable(false);
        textArea[2].setBounds(210, 285, 190, 65);
        this.add(textArea[2]);
        textArea[2].setText("0");
    }

}
