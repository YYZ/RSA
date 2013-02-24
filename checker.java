import java.math.*;
import java.util.*;
import java.io.*;
import javax.crypto.*;
import java.security.*;

public class checker{
    public static void main(String [] args)throws IOException{
	//Generate digest of code
	//decrypt using e = 65537 and N
	//See if they match, which they should!
	

	BigInteger N = new BigInteger("8f3d2310efa2d59ca98131c403ca6ff2b6caf3f45ed539b0edb1eea572"+
		"4ce070c88b23045ab13baefbaa80c7c006ce84611be9f926eabf91d56513bf6ead3a1306ff78266b1c"+
		"9551e27b412ddd518397593d86d9998b28bd07c8c8fd0e3056afa0c9c853d413989cf00515dcc00a7cff"+
		"65400c63b2c3dedba70cfd1bf867ad1d", 16);

	BigInteger D = new BigInteger("32a3475364a22e4b9fbbbbf360fb41c012313f5693919e85eaa6668393"+
		"35b626c7a62a7ff151a15bbd4c8d1359c0a3d610ef496a18643d699a434dd9e21ded91bcc6b143c7df"+
		"81cb68efe43b3339007512f53996376f51e183fabc1caa3c128c9a503d6c74338262c1cbcde2029a5ec1"+
		"a5e03f2c79e192c8bc2eab89de57e5b0", 16);

	BigInteger e = new BigInteger("65537");


	RandomAccessFile f = new RandomAccessFile("code.txt", "r");
	byte [] p = new byte[(int)f.length()];
	f.read(p);
	BigInteger digest = new BigInteger(p);
	byte [] h = generateHash(digest);
	digest = new BigInteger(1,h);

	BigInteger x = decrypt(D,N,e);

	System.out.println("Code Digest is " +digest.toString(16));
	System.out.println("Unencrypted hash is " + x.toString(16));
    }

public static byte[] generateHash(BigInteger p){
    byte [] digest =  new byte[0];

	try{
		MessageDigest m = MessageDigest.getInstance("SHA-256");
		digest= p.toByteArray();
		m.update(digest);
		digest = m.digest();
	}
	catch (Exception e){System.out.println("Error in generateHash");}

	return digest;
}

public static BigInteger decrypt(BigInteger d, BigInteger N, BigInteger e){
    return d.modPow(e, N);
}
}
