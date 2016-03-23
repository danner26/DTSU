public class Password
{
    public String password;
    // Constructors
    public Password()
    {
        password = "";
    }
    public Password(String pass)
    {
        password = pass;
    }
    
    public void setPassword(String pass)
    {
        password = pass;
    }
    public String getPassword()
    {
        return password;
    }
    
    public boolean empty()
    {
        return password.isEmpty();
    }
    public int indexOfSpace()
    {
        return password.indexOf(" ");
    }
    public static int lengthOfPassword(String password)
    {
        return password.length();
    }
    public boolean containsKnownWord()
    {
        String[] knownWords = { "password", "12345678", "123456789", "iloveyou", "adobe123", "1234567890", "letmein","photoshop", "sunshine", "password1", "princess", "trustno1"}; 
        for ( int i = 0; i < knownWords.length; i++)
        {
            if (password.equalsIgnoreCase(knownWords[i]))
                return true;
            continue;
        }
        return false;
    }
    public boolean containsNum()
    {
        CharSequence[] num = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < num.length; i++)
        {
            if (password.contains(num[i]))
                return true;
            continue;
        }
        return false;
    }
    public boolean containsCap()
    {
        CharSequence[] caps = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        for (int i = 0; i < caps.length; i++)
        {
            if (password.contains(caps[i]))
                return true;
            continue;
        }
        return false;
    }
    public boolean containsPunc()
    {
        CharSequence[] punc = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")", ",", ".", "/", ":", ";", "'", "[", "]", "{", "}", "-", "=", "+", "_", "|"};
        for (int i = 0; i < punc.length; i++)
        {
            if (password.contains(punc[i]))
                return true;
            continue;
        }
        return false;
        
    }
}