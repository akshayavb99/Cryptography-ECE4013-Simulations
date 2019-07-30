#SIMULATION OF AUOTKEY CIPHER (TYPE OF POLYALPHABETIC CIPHER)
#--> Similar to substiution ciphers
#--> Relation between characters of plain text and cipher text is one-to-many
#--> The cipher has provision to hide the most frequently occuring characters/symbols.

alphabet=list("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
def encrypt(plain_txt,key):
    k=key
    cipher_txt=""
    for c in plain_txt:
        c=c.upper()
        n_k = alphabet.index(c)
        i=n_k+k
        #print(i)
        if i>25:
            i=i%26
        cipher_txt=cipher_txt+alphabet[i]
        k=n_k

    print(cipher_txt)
    #print("Encryption")

def decrypt(cipher_txt,key):
    k=key
    plain_txt=""
    for c in cipher_txt:
        c=c.upper()
        n_k=alphabet.index(c)-k
        if n_k<0:
            n_k=n_k+26
        plain_txt=plain_txt+alphabet[n_k]
        k=n_k
    print(plain_txt)
    #print("Decryption")


input_str=(input("Enter the text: "))
key=int(input("Enter the key:"))
choice=int(input("Enter choice of operation: Encryption(0);Decryption(1): "))
if choice==0:
    encrypt(input_str,key)
elif choice==1:
    decrypt(input_str,key)
else:
    print("Invalid choice")
