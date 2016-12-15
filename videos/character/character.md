# Character
I am going to given you an overview of some of the lessor known characteristics of the visual symbol known as the "character"

## What does a software engineer need to know about characters?
There is a lot of terminology surrounding characters,
and the terms are so interrelated it is hard to define them all in a non-circular manner.
So I am going to try to provide definitions that are unambiguous even though some are circular. 

## Character Terminology 

### Character
For technical people, usually refers to either a code unit or code point
For business people, usually refers to a grapheme or ligature

### Grapheme
The smallest meaningful contrastive unit of a writing system.
Examples are alphabetic letters, chinese characters, numbers, and punctuation marks.

### Glyph
The shape of a marking representing a grapheme.
Different glyphs may represent the same grapheme. 

### Ligature
Two or more graphemes joined as a single glyph, such as æ.

### Code Point
Represents a single character in a code space.
This is a number that corresponds to a single character.
When an engineer is talking about hte 

### Code Space
A range of numerical values available for encoding characters.

### Code Unit
Smallest computer unit with which to build code points.

### Font
A set of glyphs with a particular set of parameters, such as weight, slope, width, serif, monospaced, etc.

### Font Family / Typeface
A range of fonts that share an overall design

### Encoding
The rules for converting between code units and characters in a charset.

### Charset
A mapping between characters and corresponding numerical values in the code space.

### Unicode
A standard whose charset includes all characters, in an attempt to unify all languages by assigning a code point to each grapheme.

### UTF
Unicode transformation format.  Refers to a set of encodings that support all unicode code points.

### UTF-8
A variable length mapping from 8-bit code units to code points, where each code point may be represented as 1-6 code units.
Designed to be compatible with ASCII.  

### UTF-16
Originally intended to be a fixed length mapping, now a variable length mapping between 16-bit code units and unicode code points.

### Byte Order Mark
A zero width character placed at the beginning of a file or character stream used to designate byte order.
In utf-16, it is 0xFEFF.
When consuming bytes, if they are read as 0xFEFF, the stream is big endian.
If they are read as FFFE, the steam is little endian.

In utf-8, it is 0xEFBBBF, has no meaning, and should be discarded upon being read.

### ASCII
American Standard Code for Information Interchange.  Includes the characters we are most familiar with.

### ISO-8859-1
Character encoding with support for languages used in the Americas, Western Europe, Oceania, and much of Africa.  Noteworthy because it is the default encoding of HTTP content.

### Serif
A small line attached to the ends of glyphs

### Sans Serif
No serif's

[Serif vs. Sans Serif](serif.html)

## Java example

    FileReader fileReader = new FileReader("README.md");

    InputStreamReader inputStreamReader = 
        new InputStreamReader(new FileInputStream("README.md"), Charset.defaultCharset());


## HTML 5 
For html documents, specify the charset in a meta element, like so

    <!DOCTYPE HTML>
    <HTML>
     <HEAD>
      <META CHARSET="UTF-8">
     </HEAD>
    <BODY>

So how do we read the charset attribute without knowing what the charset is? 
> 4.2.5.5 Specifying the document's character encoding
> 
> A character encoding declaration is a mechanism by which the character encoding used to store or transmit a document is specified.
> 
> The following restrictions apply to character encoding declarations:
> 
> The character encoding name given must be an ASCII case-insensitive match for one of the labels of the character encoding used to serialize the file. [ENCODING]
> The character encoding declaration must be serialized without the use of character references or character escapes of any kind.
> The element containing the character encoding declaration must be serialized completely within the first 1024 bytes of the document.

##G Clef Sample

### Symbol

[g clef](http://www.fileformat.info/info/unicode/char/1d11e/index.htm)

### Sample application
[source](core/src/main/scala/com/seanshubin/documentation/core/ClefSample.scala)

| hex | binary |
|-----|--------|
| 0   | 0000   |
| 1   | 0001   |
| 2   | 0010   |
| 3   | 0011   |
| 4   | 0100   |
| 5   | 0101   |
| 6   | 0110   |
| 7   | 0111   |
| 8   | 1000   |
| 9   | 1001   |
| A   | 1010   |
| B   | 1011   |
| C   | 1100   |
| D   | 1101   |
| E   | 1110   |
| F   | 1111   |

```text
utf 8 bytes        (4 bytes) f0 9d 84 9e
unicode code point (4 bytes) 00 01 d1 1e
```

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

### Interpreting the utf-8 bytes
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
            00001 11010001 00011110
code point      1    D   1    1   E
```
