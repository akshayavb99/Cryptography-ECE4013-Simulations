import java.io.*;
import java.util.*;
public class AffinCipher {
	
	private ArrayList<String> plain_txt;
	private ArrayList<String> cipher_txt;
	private int key1,key2;
	private String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public AffinCipher(int k1,int k2)
	{
		key1=k1;
		key2=k2;
		plain_txt=new ArrayList<String>();
		cipher_txt=new ArrayList<String>();
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
			int new_idx=((idx*key1)+key2)%26;
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
		int ikey=key_inv(key1);
		//System.out.println("Inverse key is: "+ikey);
		for (int i=0;i<cipher_txt.size();i++)
		{
			String charac=cipher_txt.get(i);
			char c=(charac.charAt(0));
			int idx=alphabet.indexOf(c);
			int val=idx-key2;
			if (val<0)
			{
				val+=26;
			}
			int new_idx=((val%26)*ikey)%26;
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
		int key1,key2,choice;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the input string: ");
		input=scan.nextLine();
		//scan.nextLine();
		System.out.println("Enter the multiplicative key(k1): ");
		key1=scan.nextInt();
		System.out.println("Enter the additive key(k2): ");
		key2=scan.nextInt();
		System.out.println("Enter your choice of operation - Encryption=0;Decryption=1 : ");
		choice=scan.nextInt();
		
		//Creating a new object
		AffinCipher obj = new AffinCipher(key1,key2);
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
				//System.out.println(obj.cipher_txt);
				obj.decrypt();
				break;
			
			default:
				System.out.println("Invalid input");				
		}
	}

}
