import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Control implements KeyListener, ActionListener{

    private View panou;
    private Polynomial polinomA, polinomB;
    private static final int MAX_POL_SIZE=1000;
    private Operations operations = new Operations();

    public Control(View inter)
    {
        panou = inter;
        this.setupComponent();
    }

    /**
     * initializare obiecte de tip polinom
     */
    private void setupComponent()
    {
        polinomA = new Polynomial(MAX_POL_SIZE); // deoarece nu stim initial care va fi gradul maxim
        polinomA.setGrad(0);

        polinomB = new Polynomial(MAX_POL_SIZE); // alocam suficiente elemente pentru vectorul de coeficienti
        polinomB.setGrad(0);
    }

    @Override
    /**
     * tratarea evenimentelor
     */
    public void actionPerformed(ActionEvent e) {

		/*
		 * cautam butonul care s-a apasat
		 */

        for(int i = 0; i < panou.but.length; i++)
        {

            if(e.getSource() == panou.but[i])
            {
                Polynomial polinomC; // polinom auxiliar
                switch(i)
                {
                    case 0:
					/*
					 * s-a apasat butonul aduna
					 */

                        if(polinomA.getGrad() > polinomB.getGrad())
                            polinomC = new Polynomial(polinomA.getGrad());
                        else
                            polinomC = new Polynomial(polinomB.getGrad());

                        polinomC = operations.polinomSum(polinomA, polinomB);
                        panou.textArea[0].append("SUM=" + polinomC.concatPolinom1() + '\n');
                        break;
                    case 1:
					/*
					 * s-a apasat butonul scade
					 */
                        if(polinomA.getGrad() > polinomB.getGrad())
                            polinomC = new Polynomial(polinomA.getGrad());
                        else
                            polinomC = new Polynomial(polinomB.getGrad());

                        polinomC = operations.polinomDif(polinomA, polinomB);
                        panou.textArea[0].append("DIF=" + polinomC.concatPolinom1() + '\n');
                        break;
                    case 2:
					/*
					 * s-a apasat butonul inmulteste
					 */

                        polinomC = new Polynomial(polinomA.getGrad() + polinomB.getGrad());
                        polinomC = operations.polinomInm(polinomA, polinomB);
                        panou.textArea[0].append("INM=" + polinomC.concatPolinom1() + '\n');
                        break;
                    case 3:
					/*
					 * s-a apasat butonul imparte
					 */

                        if(polinomB.getGrad() <= 0)
                            panou.textArea[0].setText("impartirea la constanta nu are sens");
                        else
                        {

                            Polynomial Cat;
                            Polynomial Rest;

                            if(polinomA.getGrad() >= polinomB.getGrad())
                            {
                                Cat = new Polynomial(polinomA.getGrad() - polinomB.getGrad());
                                Rest = new Polynomial(polinomB.getGrad());
                            }
                            else
                            {
                                Cat = new Polynomial(0);
                                Rest = new Polynomial(polinomA.getGrad());
                            }

//                            Cat = operations.polinomImp(polinomA, polinomB);
//                            panou.textArea[0].append("Cat=" + Cat.concatPolinom2() + '\n');
//                            panou.textArea[0].append("Rest=" + Rest.concatPolinom2() + '\n');
                        }
                        break;
                    case 4:
					/*
					 * s-a apasat butonul deriveaza
					 */
                        if(panou.butA1.isSelected())
                        {
                            Polynomial Deriv = new Polynomial(polinomA.getGrad());
                            Deriv = operations.polinomDeriv(polinomA);
                            panou.textArea[0].append("DERIV=" + Deriv.concatPolinom1() + '\n');
                        }

                        if(panou.butB1.isSelected())
                        {
                            Polynomial DerivB = new Polynomial(polinomB.getGrad());
                            polinomB = operations.polinomDeriv(polinomB);
                            panou.textArea[0].append("DERIV=" + DerivB.concatPolinom1() + '\n');
                        }
                        break;
                    case 5:
					/*
					 * calculul unei valori
					 */
                        try
                        {
                            if(panou.butA1.isSelected())
                            {
							/*
							 * daca s-a selectat butonul A
							 */

                                int x = Integer.parseInt( panou.txt[2].getText().trim());
                                int resval = polinomA.calculVal(x);
                                panou.textArea[0].append("f(x)=" + resval + '\n');
                            }
                            if(panou.butB1.isSelected())
                            {
							/*
							 * daca s-a selectat butonul B
							 */

                                int x = Integer.parseInt( panou.txt[2].getText().trim() );
                                int resval = polinomB.calculVal(x);
                                panou.textArea[0].append("f(x)=" + resval +'\n');
                            }
                        }
                        catch(Exception exp)
                        {
                            panou.label[2].setText("Gresit");
                            panou.label[2].setForeground(Color.red);
                            panou.txt[2].setEditable(false);
                        }
                        break;

                    case 6:
					/*
					 * integrarea unui polinom
					 */

                        if(panou.butA1.isSelected())
                        {
						/*
						 * daca s-a selectat polinomul A
						 */

                            Polynomial rezultat = new Polynomial(polinomA.getGrad() + 1);
                            rezultat = operations.polinomIntegr(polinomA);

                            panou.textArea[0].append("INTEGR=" + rezultat.concatPolinom1() + '\n');
                        }
                        if(panou.butB1.isSelected())
                        {
						/*
						 * daca s-a selectat polinomul B
						 */

                            Polynomial  rezultat = new Polynomial(polinomB.getGrad() + 1);

                            rezultat = operations.polinomIntegr(polinomB);
                            panou.textArea[0].append("INTEGR=" + rezultat.concatPolinom1() + '\n' );
                        }
                        break;
                    case 7:
					/*
					 * scimba polinoamele intre ele;
					 */
                        operations.Interschimba(polinomA, polinomB);

                        panou.textArea[1].setText(polinomA.concatPolinom1());
                        panou.textArea[2].setText(polinomB.concatPolinom1());

                }
            }
        }

		/*
		 * daca s-a apasat butonul adauga
		 */
        if(e.getSource() == panou.badd)
        {
            if(panou.butA1.isSelected())
            {
				/*
				 * adauga termen la polinomul A
				 */
                String coef = panou.txt[0].getText();
                String exp = panou.txt[1].getText();

                int index, val;

                index = Integer.parseInt(exp);
                val = Integer.parseInt(coef);

                try
                {
                    if(index > polinomA.getGrad())
                    {
                        polinomA.setGrad(index);
                    }
                    polinomA.setCoeficient(index, val);

                    panou.textArea[1].setText("");
                    panou.textArea[1].append(polinomA.concatPolinom1());
                }
                catch(Exception exc)
                {
                    panou.label[1].setText("Gresit");
                    panou.label[1].setForeground(Color.red);
                    panou.txt[1].setEditable(false);
                }
            }

            if(panou.butB1.isSelected())
            {
				/*
				 * adauga termen in polinomul B
				 */
                String coef = panou.txt[0].getText();
                String exp = panou.txt[1].getText();

                int index, val;

                index = Integer.parseInt(exp.trim());
                val = Integer.parseInt(coef.trim());


                try
                {
                    polinomB.setCoeficient(index, val);
                    if(polinomB.getGrad() < index)
                    {
                        polinomB.setGrad(index);
                    }

                    panou.textArea[2].setText("");
                    panou.textArea[2].append(polinomB.concatPolinom1());
                }
                catch(Exception exc)
                {
                    panou.label[1].setText("Gresit");
                    panou.label[1].setForeground(Color.red);
                    panou.txt[1].setEditable(false);
                }

            }
        }


		/*
		 * sterge polinoamele
		 */
        if(e.getSource() == panou.bdell)
        {

            if(panou.butA1.isSelected())
            {
				/*
				 * sterge polinom A
				 */
                polinomA.resetPolinom();
                panou.textArea[1].setText("0");
            }

            if(panou.butB1.isSelected())
            {
				/*
				 * sterge polinom A
				 */
                polinomB.resetPolinom();
                panou.textArea[2].setText("0");
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }


}
