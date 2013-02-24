RSA
===

RSA java implementation

Straightforward implementation of RSA in java for a cryptography assignment

Code performs the following: 

Generate two distinct 512-bit probable primes p and q
Calculate the product of these two primes N = pq
Calculate the Euler totient function phi(N)
Uses an encryption exponent e = 65537, so you will need to ensure that this is relatively prime to phi(N). If it is not, go back to step 1 and generate new values for p and q
Compute the value for the decryption exponent d, which is the multiplicative inverse of e (mod phi(N)). This uses my own implementation of the extended Euclidean GCD algorithm to calculate the inverse rather than using a library method for this purpose.
We then implement a decryption method which calculates cd (mod N). Again, this uses my own implementation of the Chinese Remainder Theorem to calculate this more efficiently.

Then digitally signs a text file by:

Generating a 256-bit digest of file using SHA-256.
Apply your decryption method to this digest
