# BurrowsWheeler
This project is to Burrows Wheeler data compression, with Huffman compression. 
Week 5 assignment of Algorithms, Part II, by Robert Sedgewick in Princeton University.
Score 100/100.

The Burrows–Wheeler data compression algorithm consists of three algorithmic components, which are applied in succession:

1. Burrows–Wheeler transform. Given a typical English text file, transform it into a text file in which sequences of the same character occur near each other many times.
2. Move-to-front encoding. Given a text file in which sequences of the same character occur near each other many times, convert it into a text file in which certain characters appear much more frequently than others.
3. Huffman compression. Given a text file in which certain characters appear much more frequently than others, compress it by encoding frequently occurring characters with short codewords and infrequently occurring characters with long codewords.
https://coursera.cs.princeton.edu/algs4/assignments/burrows/specification.php
