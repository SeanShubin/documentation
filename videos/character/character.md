# What does a software engineer need to know about characters?

## Example of why characters are more confusing than they seem
Sample using the word [fiancé](fiance.html)

## Character Terminology 
There is a lot of terminology surrounding characters,
and the terms are so interrelated it is hard to define them all in a non-circular manner.
So I am going to try to provide definitions that are meaningful even though some are circular. 

### Character
For technical people, usually refers to either a code unit or code point.
For business people, usually refers to a grapheme or ligature.
The different ways this word is used is a source of a lot of confusion, especially since it is used in the definitions of other terms, but if once you know the entire vocabulary, you can usually figure out what it means from context. 

### Grapheme
The smallest meaningful contrastive unit of a writing system.
Contrastive, means they are designed to be distinguished from one another.
For example, a 'c' is different than an 'e', yet two 'c's are the same even if they have slight differences in their shape.
Examples of graphemes are alphabetic letters, chinese characters, numbers, and punctuation marks.

### Glyph
The shape of a marking representing a grapheme.
Different glyphs may represent the same grapheme.
For example, there are many different styles an 'a' can be written in that still represent an 'a'.

### Ligature
Two or more graphemes joined as a single glyph, such as the ash character 'æ'

### Code Point
Represents a single character in a code space.
This is a number that corresponds to a single character.

### Code Space
A range of numerical values that have corresponding characters.

### Code Unit
Smallest computer unit with which to build code points.
In most programming languages, when you get the length of a string, you are counting the number of code units.

### Charset
A set of characters that can be mapped into a code space.
Unfortunately, in some languages, the word charset is used when what is really meant is encoding.

### Encoding
The rules for converting between code units and characters in a charset.
If the size of a code unit can be different from the size of a code point, this will involve converting between code units and code points as well.

### Font
A set of glyphs with a particular set of parameters, such as weight, slope, width, serif, monospaced, etc.

### Font Family / Typeface
A range of fonts that share an overall design.
Common font families are Helvetica, Arial, Times New Roman, and Courier.

### Unicode
A standard who's goal is to unify all languages by providing a consistent way to encode text.
This means assigning a number to every graphme, ligature, accent, punctuation mark, and so on.
Even some obscure alphabets that are no longer used are included.
For some of these alphabets we don't even have complete information about the meaning of the letters such as the alphabetical order.
Emoji support was added as of unicode 6.0.

### UTF
Unicode transformation format.
It refers to a set of encodings that support all unicode code points.

### UTF-8
A variable length mapping between 8-bit code units and unicode code points, where each code point may be represented as between 1 and 6 code units.
UTF-8 is designed to be compatible with ASCII.
Currently, no unicode code point requires more than 4 UTF-8 code units.  

### UTF-16
Originally intended to be a fixed length mapping,
It is now a variable length mapping between 16-bit code units and unicode code points.
That UTF-16 is such a common representation in so many languages is unfortunate.
UTF-16 has the disadvantage of taking more space than UTF-8 for the most common characters, with none of the advantages that would have come with being a fixed length encoding.
So between UTF-8, variable but concise, and UTF-32, fixed but taking up much more space, we have the worst of both worlds.  

### Byte Order Mark
A sequence of bytes placed at the beginning of a file or character stream used to designate byte order.
This is skipped over and not considered a character, as it is metadata indicating whether or not bytes should be reversed before being encoded into characters.
In UTF-16, it is 0xFEFF.
When consuming bytes, if they are read as 0xFEFF, the stream is big endian.
If they are read as 0xFFFE, the steam is little endian.

In UTF-8, there is an optional byte order mark of 0xEFBBBF
It has no meaning, and should be discarded upon being read.
If you don't account for the possibility of a byte order mark existing, this can lead to some confusing behavior in your program.

### ASCII
American Standard Code for Information Interchange.  Includes the characters Americans are most familiar with.

### ISO-8859-1
Character encoding with support for languages used in the Americas, Western Europe, Oceania, and much of Africa.
It is noteworthy because it is the default encoding of HTTP content.

### Serif
A small line attached to the ends of glyphs

### Sans Serif
No serif's

[Serif vs. Sans Serif](serif.html)

## Java example

How does this affect the way I code?
Consider the following Java code:

    FileReader fileReader = new FileReader("README.md");

In Java, the "*Reader" classes read characters, not bytes.
It is not possible to convert from bytes to characters, or characters to bytes without knowing the encoding.
If you remember nothing else about characters in software engineering, remember this.
It is not possible to convert from bytes to characters, or characters to bytes without knowing the encoding.
So how exactly do we know what encoding we are dealing with?
You don't see it specified here, so something else must be happening.
What is happening is that the file reader is choosing a default encoding based on the platform on which Java is currently running.
This necessarily means this code is platform dependent, it is not guaranteed to do the same thing if run elsewhere.
If you do some digging into the Java library source code, you will find the code is doing something similar to this:

    InputStreamReader inputStreamReader = 
        new InputStreamReader(new FileInputStream("README.md"), Charset.defaultCharset());

Now the previously hidden input to the function is revealed.
In general, you should be specific about what encoding you are using, so instead of going with the default encoding, do something like this.

    InputStreamReader inputStreamReader = 
        new InputStreamReader(new FileInputStream("README.md"), StandardCharsets.UTF_8);

This example illustrates two mistakes in the Java libraries.
One mistake is that FileReader does not take an encoding, even though it absolutely needs one to convert bytes to characters.
This constructor should not even exist, and instead there should be a constructor that takes an encoding.
Another mistake is the use of the word charset where encoding is really what is meant.
For example, UTF-8 and UTF-16 have the same charset but different encodings.


## HTML 5 
For html documents the encoding is specified in the CHARSET meta element, like so

    <!DOCTYPE HTML>
    <HTML>
     <HEAD>
      <META CHARSET="UTF-8">
     </HEAD>
    <BODY>

Given that it is bytes, not characters, that are transmitted over the internet protocol, can you see a problem with this?
To get the encoding, we need to convert bytes to characters.
To convert bytes to characters, we need the encoding.

From the [html 5 specification](https://www.w3.org/TR/html5/)
> 4.2.5.5 Specifying the document's character encoding
> 
> A character encoding declaration is a mechanism by which the character encoding used to store or transmit a document is specified.
> 
> The following restrictions apply to character encoding declarations:
> 
> The character encoding name given must be an ASCII case-insensitive match for one of the labels of the character encoding used to serialize the file. [ENCODING]
> The character encoding declaration must be serialized without the use of character references or character escapes of any kind.
> The element containing the character encoding declaration must be serialized completely within the first 1024 bytes of the document.

from https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meta
> * Authors are encouraged to use UTF-8.
> * Authors should not use ASCII-incompatible encodings (i.e. those that don't map the 8-bit code points 0x20 to 0x7E to the Unicode 0x0020 to 0x007E code points) as these represent a security risk: browsers not supporting them may interpret benign content as HTML Elements. This is the case of at least the following charsets: JIS_C6226-1983, JIS_X0212-1990, HZ-GB-2312, JOHAB, the ISO-2022 family, and the EBCDIC family.
> * Authors must not use CESU-8, UTF-7, BOCU-1 and SCSU, also falling in that category and not intended to be used on the web. Cross-scripting attacks with some of these encodings have been documented.
> * Authors should not use UTF-32 because not all HTML5 encoding algorithms can distinguish it from UTF-16.

What this distills down to is that in order to ensure you can reliably interpret the characters in an HTML document, you need to do two things:
- Make sure the encoding is specified within the first 1024 bytes of the html document.
- Make sure all of the bytes encountered before the CHARSET meta tag are compatible with ASCII.

##G Clef Sample

### Symbol

[g clef](http://www.fileformat.info/info/unicode/char/1d11e/index.htm)

```text
UTF 8 bytes        (4 bytes) F0 9D 84 9E
unicode code point (4 bytes) 00 01 D1 1E
```

| decimal | hex | binary |
|---------|-----|--------|
|  0      | 0   | 0000   |
|  1      | 1   | 0001   |
|  2      | 2   | 0010   |
|  3      | 3   | 0011   |
|  4      | 4   | 0100   |
|  5      | 5   | 0101   |
|  6      | 6   | 0110   |
|  7      | 7   | 0111   |
|  8      | 8   | 1000   |
|  9      | 9   | 1001   |
| 10      | A   | 1010   |
| 11      | B   | 1011   |
| 12      | C   | 1100   |
| 13      | D   | 1101   |
| 14      | E   | 1110   |
| 15      | F   | 1111   |

| hex | binary   |
|-----|----------|
| F0  | 11110000 |
| 9D  | 10011101 |
| 84  | 10000100 |
| 9E  | 10011110 |

| hex | binary   |
|-----|----------|
| 00  | 00000000 |
| 01  | 00000001 |
| D1  | 11010001 |
| 1E  | 00011110 |

### Interpreting the UTF-8 bytes
| Byte 1 | Byte 2 | Byte 3 | Byte 4 | Byte 5 | Byte 6 | Significant Bits |
|--------|--------|--------|--------|--------|--------|------------------|
|0xxxxxxx|        |        |        |        |        | 7                |
|110xxxxx|10xxxxxx|        |        |        |        | 11               |
|1110xxxx|10xxxxxx|10xxxxxx|        |        |        | 16               |
|11110xxx|10xxxxxx|10xxxxxx|10xxxxxx|        |        | 21               |
|111110xx|10xxxxxx|10xxxxxx|10xxxxxx|10xxxxxx|        | 26               |
|1111110x|10xxxxxx|10xxxxxx|10xxxxxx|10xxxxxx|10xxxxxx| 31               |

```text
utf8-hex       F   0    9   D    8   4    9   E
utf8        11110000 10011101 10000100 10011110
significant      000   011101   000100   011110
21 bit      000011101000100011110
            00001 11010001 00011110
code point      1    D   1    1   E
```
