
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AccountID 
{
    private String userID,password;
    private String cardNumber,CVC;
    private final int accNo;
    private static int accCount = 0;
    public AccountID()
    {
        accCount++;
        accNo = accCount;
    }
    public AccountID(String id,String pw,String c,String cvc)
    {
        userID = id;
        password = pw;
        cardNumber = c;
        CVC = cvc;
        accCount++;
        accNo = accCount;
    }
    public AccountID(String id,String pw)
    {
        userID = id;
        password = pw;
        cardNumber = "N/A";
        CVC = "N/A";
        accCount++;
        accNo = accCount;
    }
    public void setUesrID(String id)
    {
        userID = id;
    }
    public void setPassword(String pw)
    {
        password = pw;
    }
    public void setCardNumber(String c)
    {
        cardNumber = c;
    }
    public void setCVC(String cvc)
    {
        CVC = cvc;
    }
    public String getUesrID()
    {
        return userID;
    }
    public String getPassword()
    {
        return password;
    }
    public String getCardNumber()
    {
        return cardNumber;
    }
    public String getCVC()
    {
        return CVC;
    }
    public int getAccNo()
    {
        return accNo;
    }
    public boolean isValidID() throws FileNotFoundException
    {
        char FirstupperChar = userID.toUpperCase().charAt(0);
        boolean areTheyAllLetters = true;
        for (int i = 0;i<userID.length();i++)
        {
            if(!(Character.isLetter(userID.charAt(i)))) 
            {
                areTheyAllLetters = false;
                break;
            }
        }
        FileP acc = new FileP("UserList.txt");
        ArrayList<String> a = new ArrayList<>();
        for(String i : acc.readLines())
        {
          a.add(i);
        }
        return FirstupperChar == userID.charAt(0) && areTheyAllLetters && !a.contains(this.userID);
    }
    public boolean isValidPassword()
    {
        return isEnoughUpper(password,1) && isEnoughLower(password,5) && isEnoughNumber(password,3) && isEnoughSpecialCharacter(password,1);
    }
    private boolean isEnoughUpper(String x,int n)
    {
        int counter = 0;
        for (int i = 0;i<x.length();i++)
        {
            if (x.toUpperCase().charAt(i) == x.charAt(i)) counter++;
            if (counter == n) return true;
        }
        return false;
    }
    private boolean isEnoughLower(String x,int n)
    {
        int counter = 0;
        for (int i = 0;i<x.length();i++)
        {
            if (x.toLowerCase().charAt(i) == x.charAt(i)) counter++;
            if (counter == n) return true;
        }
        return false;
    }
    private boolean isEnoughNumber(String x,int n)
    {
        int counter = 0;
        for (int i = 0;i<x.length();i++)
        {
            if (Character.isDigit(x.charAt(i))) counter++;
            if (counter == n) return true;
        }
        return false;
    }
    private boolean isEnoughSpecialCharacter(String x,int n)
    {
        int counter = 0;
        String specialCharacter = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        for (int i = 0;i<x.length();i++)
        {
           for (int j = 0;j<specialCharacter.length();j++)
           {
               if (x.charAt(i) == specialCharacter.charAt(j)) 
               {
               counter++;
               break;
               }
           }
            if (counter == n) return true;
        }
        return false;
    }
    public String isValidAccount()
    {
        if(isValidID() && isValidPassword()) return "All Complete!";
        else if(!isValidID() && isValidPassword())
        {
            return "User ID must contain only English alphabetic characters and start with uppercase.";
        }
        else if(!isValidPassword() && isValidID())
        {
            return "Password needs at least 1 uppercase, 5 lowercases, 3 digits, and 1 special character (!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~).";
        }
        if(!isValidID() && !isValidPassword())
        {
            return "User ID must contain only English alphabetic characters and start with uppercase." + "\nPassword needs at least 1 uppercase, 5 lowercases, 3 numbers, and 1 special character (!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~).";
        }
        else {return "Error";}
    }
    public boolean isValidAccountCondition()
    {
        return isValidID() && isValidPassword();
    }
    public boolean isCardInformationIncluded()
    {
        return !cardNumber.equals("N/A") && !CVC.equals("N/A");
    }
    @Override
    public String toString()
    {
        if(cardNumber.equals("N/A")) return "Account " + Integer.toString(accNo) + " : " + userID + ",\t" + password;
        else return "Account " + Integer.toString(accNo) + " : " + userID + ",\t" + password + ",\t" + cardNumber + ",\t" + CVC;
    }
 }



