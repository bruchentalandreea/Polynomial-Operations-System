
public class Operations {
    public Polynomial polinomSum(Polynomial p1, Polynomial p2)
    {
        int i, grad;
        Polynomial rezultat;

        //obtinem gradul rezultatului
        if(p1.getGrad() > p2.getGrad())
        {
            grad = p1.getGrad();
        }
        else
        {
            grad = p2.getGrad();
        }

        //initializam rezultatul => toti coeficientii sunt 0
        rezultat = new Polynomial(grad);

        //adunam primul polinom la rezultat (obtinem un rezultat partial)
        for(i = 0; i <= p1.getGrad(); i++)
            rezultat.setCoeficient(i, p1.getCoeficient(i));

        //adunam al 2-lea polinom (obtinem rezultatul final)
        for(i = 0; i <= p2.getGrad(); i++)
            rezultat.setCoeficient(i, rezultat.getCoeficient(i) + p2.getCoeficient(i));

        return rezultat;
    }

    public Polynomial polinomDif(Polynomial p1, Polynomial p2)
    {
        int i;
        Polynomial rezultat;
        if(p1.getGrad() > p2.getGrad())
            rezultat = new Polynomial(p1.getGrad());
        else
            rezultat = new Polynomial(p2.getGrad());

        for(i = 0; i <= p1.getGrad(); i++)
        {
            rezultat.setCoeficient(i, p1.getCoeficient(i));
        }

        for(i = 0; i <= p2.getGrad(); i++)
        {
            rezultat.setCoeficient(i, rezultat.getCoeficient(i) - p2.getCoeficient(i));
        }

        return rezultat;
    }

    public Polynomial polinomInm(Polynomial p1, Polynomial p2)
    {
        int i, j, k;
        Polynomial rezultat = new Polynomial(p2.getGrad() + p1.getGrad());

        for(i = 0; i <= p1.getGrad(); i++)
        {
            for(j = 0; j <= p2.getGrad(); j++)
            {
                k = p1.getCoeficient(i) * p2.getCoeficient(j);
                rezultat.setCoeficient(i + j, rezultat.getCoeficient(i+j) + k);
            }
        }
        return rezultat;
    }

    public Polynomial polinomDeriv(Polynomial p)
    {
        int i;
        Polynomial rezultat = new Polynomial(p.getGrad());

        for(i = 1; i <= p.getGrad(); i++)
        {
            rezultat.setCoeficient(i-1, i * p.getCoeficient(i));
        }

        return rezultat;

    }

    public Polynomial polinomIntegr(Polynomial p)
    {
        int i;
        Polynomial rezultat = new Polynomial(p.getGrad() + 1);

        for(i=1; i<=p.getGrad() + 1; i++)
        {

            rezultat.setCoeficient(i, p.getCoeficient(i - 1) / i  );
        }

        return rezultat;
    }

    public void Interschimba(Polynomial p1, Polynomial p2)
    {
        int i;
        Polynomial aux = new Polynomial(p1.getGrad());

        for(i = 0; i<= p1.getGrad(); i++)
        {
            aux.setCoeficient(i, p1.getCoeficient(i));
        }

        p1.setGrad(p2.getGrad());

        for(i = 0; i <= p1.getGrad(); i++)
        {
            p1.setCoeficient(i, p2.getCoeficient(i));
        }


        p2.setGrad(aux.getGrad());
        for(i = 0; i <= aux.getGrad(); i++)
        {
            p2.setCoeficient(i, aux.getCoeficient(i));
        }

    }

}
