import java.io.*;
public class LoginToken extends AccountID
{
    private String tokenName;
    private String tokenFileName;
    private static int tokenCount = 0;
    private int tokenNumber;
    public LoginToken(AccountID id)
    {
        super(id.getUesrID(),id.getPassword(),id.getCardNumber(),id.getCVC());    
        if (super.isValidAccountCondition()) throw new IllegalArgumentException("Invalid Account");
        tokenCount++;
        tokenNumber = tokenCount;
        tokenName = super.getUesrID();
        tokenFileName = "User_" + tokenName.strip() +".txt";
    }
    public static boolean isLogin() throws IOException
    {
        File c = new File("CurrentLogin.txt");
        if(c.createNewFile())  return false;
        else return c.length() != 0;
    }
    public boolean ValidLoginCondition(String user, String pwd)
    {
        return super.getUesrID().equals(user) && super.getPassword().equals(pwd);
    }
    public String ValidLogin(String user, String pwd) throws FileNotFoundException
    {
        if(this.ValidLoginCondition(user, pwd))
        {
            File c = new File("CurrentLogin.txt");
            PrintWriter w = new PrintWriter(c);
            w.println(super.toString());
            w.close();
            return "Welcome " + super.getUesrID();
        }
        else
        {
            return "Incorrect username or password!";
        }
    }
     public boolean ValidPaymentCondition(String cvc)
    {
        return super.getCVC().equals(cvc);
    }
    public String ValidPayment(String cvc)
    {
        if(this.ValidPaymentCondition(cvc))
        {
            return "Payment Success";
        }
        else
        {
            return "Incorrect CVC";
        }
    }
    public void createTokenfile() throws FileNotFoundException, IOException
    {
          File c = new File(tokenFileName);
          c.createNewFile();
        try (PrintWriter w = new PrintWriter(c)) 
        {
            w.println(super.toString());
        }
    }
}







