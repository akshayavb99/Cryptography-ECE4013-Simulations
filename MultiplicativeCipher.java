/* Multiplicative Cipher is a type of Substitution Cipher where the key and plain text are multiplied to give the cipher text
 * If P = Plain Text, k=Key, C=Cipher Text
 * (i) Encryption : C=[P*k]%26
 * (ii) Decryption : P=[C*k^-1]%26
 * */
import java.io.*;
import java.util.*;
public class MultiplicativeCipher {
	
	private ArrayList<String> plain_txt;
	private ArrayList<String> cipher_txt;
	private int key;
	private String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public MultiplicativeCipher(int k)
	{
		plain_txt=new ArrayList<String>();
		cipher_txt=new ArrayList<String>();
		key=k;
	
	}
	
	public int key_inv(int key)
	{
		//System.out.println("Finding inverse key.....");
		int ikey=-1;
		int i=1;
		int rem=0;
		loop:while(rem!=1)
		{
			rem=(key*i)%26;
			if (rem==1)
			{
				ikey=i;
				break loop;
			}
			i++;
		}
		return ikey;
	}
	
	public void encrypt()
	{
		for (int i=0;i<plain_txt.size();i++)
		{
			String charac=plain_txt.get(i);
			char c=(charac.charAt(0));
			int idx=alphabet.indexOf(c);
			int new_idx=(idx*key)%26;
			cipher_txt.add(alphabet.charAt(new_idx)+"");
			//System.out.println(plain_txt.get(i)+"--->"+cipher_txt.get(i));
			
		}
		System.out.print("Encrypted text: ");
		for (int i=0;i<cipher_txt.size();i++)
		{
			System.out.print(cipher_txt.get(i));
		}
		System.out.println(" ");	
	}
	
	public void decrypt()
	{
		int ikey=key_inv(key);
		//System.out.println("Inverse key is: "+ikey);
		for (int i=0;i<cipher_txt.size();i++)
		{
			String charac=cipher_txt.get(i);
			char c=(charac.charAt(0));
			int idx=alphabet.indexOf(c);
			int new_idx=((idx%26)*ikey)%26;
			plain_txt.add(alphabet.charAt(new_idx)+"");
			//System.out.println(cipher_txt.get(i)+"--->"+plain_txt.get(i));
		}
		
		System.out.print("Decrypted text: ");
		for (int i=0;i<plain_txt.size();i++)
		{
			System.out.print(plain_txt.get(i));
		}
		System.out.println(" ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input;
		int key,choice;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the input string: ");
		input=scan.nextLine();
		//scan.nextLine();
		System.out.println("Enter the key: ");
		key=scan.nextInt();
		System.out.println("Enter your choice of operation - Encryption=0;Decryption=1 : ");
		choice=scan.nextInt();
		
		//Creating a new object
		MultiplicativeCipher obj = new MultiplicativeCipher(key);
		switch(choice)
		{
			case 0:
				for (int i=0;i<input.length();i++)
				{
					obj.plain_txt.add(Character.toUpperCase(input.charAt(i))+"");
				}
				System.out.println(obj.plain_txt);
				obj.encrypt();
				break;
				
			case 1:
				for (int i=0;i<input.length();i++)
				{
					obj.cipher_txt.add(Character.toUpperCase(input.charAt(i))+"");
				}
				System.out.println(obj.cipher_txt);
				obj.decrypt();
				break;
			
			default:
				System.out.println("Invalid input");				
		}
		

	}

}
