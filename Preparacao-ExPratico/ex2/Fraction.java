import static java.lang.System.*;
import java.util.Scanner;

public class Fraction{
    private int num, den;
    private boolean error= false;

    public Fraction(int num, int den){
        this.num = num;
        this.den = den;
        if(den<0){
            this.num =-num;
            this.den= -den;
        }
    }

    public Fraction(int num){
        this.num = num;
        this.den = 1;
    }

    public void setNum(int num){
        this.num = num;
    }

    public boolean error(){
        return error;
    }

    public int num(){
        return num;
    }

    public int den(){
        return den;
    }
    
    private int mdc(int a, int b){
        int res= a;
        if(b!= 0)
            res= mdc(b, a%b);
        else if (a== 0)
            res = 1;
        return res;
    }

    public Fraction reduce(){
        int mdc= mdc(num, den);
        return new Fraction(num/mdc, den/mdc);
    }
    @Override public String toString(){
    if (this.num == this.den )
        {
            return "1";
        }
        return  this.num + (this.den == 1 ? "" : "/" + this.den );
    }

}