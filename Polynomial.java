
public class Polynomial {
    private int grad;
    private int [] coef;

    public Polynomial(int grad) {
        this.grad = grad;
        this.coef = new int[grad + 1];
        int i;
        for(i = 0; i <= grad; i++) {
            this.coef[i] = 0;
        }
    }

    public int getGrad() {
        return this.grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public void setCoeficient(int index, int valoare) {
        this.coef[index] = valoare;
    }

    public int getCoeficient(int index) {
        return this.coef[index];
    }

    public int calculVal(int x) {
        int val, i;
        val = 0;
        for(i = 0; i <= this.getGrad(); i++) {
            if(this.getCoeficient(i) != 0)
                val += this.getCoeficient(i) * Math.pow(x, i);
        }
        return val;
    }

    public void setMaxGrad() {
        while(this.getCoeficient(this.getGrad()) == 0) {
            grad = grad - 1;
        }
    }

    public String concatPolinom1() {
        int i, ok=0;
        String rez = "";
        for(i = 0; i <= this.getGrad(); i++) {
            //daca coeficientul nu e 0, atunci adaug termen in rezultat
            if(this.getCoeficient(i) != 0) {
				/*
				 * daca coeficientul e pozitiv atunci adaug + in string
				 * altfel il pun cum e
				 */
                if(this.getCoeficient(i) > 0) {
                    rez += "+" + this.getCoeficient(i);
                }
                else {
                    rez += this.getCoeficient(i);
                }
                //adaug variabila
                switch(i) {
                    case 0:
                        rez += "";
                        break;
                    case 1:
                        rez += "x";
                        break;
                    default:
                        rez += "x^" + i;
                }
                ok = 1;
            }
        }
        if(ok == 0) rez += 0;
        return rez;
    }

    public void resetPolinom() {
        for(int i=0; i <= this.getGrad(); i++)
            this.setCoeficient(i, 0);
    }
}
