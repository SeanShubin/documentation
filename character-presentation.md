## Character Terminology 

### Grapheme
The smallest unit of a writing system

### Glyph
The shape of a marking representing a grapheme

### Font
A set of glyphs in the same typeface with a particular set of parameters, such as weight, slope, width, serif, monospaced, etc.

### Font Family / Typeface
A range of fonts that share an overall design

### Character
Intended to be a computer representation of a grapheme, but it got more complicated than that.

### Code Point
Represents a single character in an encoding

### Code Unit
Smallest computer unit with which to build code points

### Encoding
The rules for converting code units to characters in a charset

### Charset
The set of characters supported by an encoding

### Unicode
A standard whose charset includes all characters, in an attempt to unify all languages by assigning a code point to each grapheme.

### UTF
Unicode transformation format.  A mapping from code units to unicode code points.

### UTF-8
A variable length mapping from 8-bit code units to code points, where each code point may be represented as 1-6 code units.
Designed to be compatible with ASCII.  

### UTF-16
Originally intended to be a fixed length mapping, now a variable length mapping between 16-bit code units and unicode code points.

### Byte Order Mark
A zero width character placed at the beginning of a file or character stream used to designate byte order.
In utf-16, it is FEFF.
If a reader sees it as FEFF, the stream is big endian.
If the stream is little endian, it will be read as FFFE.

### ASCII
American Standard Code for Information Interchange.  Includes the characters we are most familiar with.

### ISO-8859-1
Character encoding with support for languages used in the Americas, Western Europe, Oceania, and much of Africa.  Noteworthy because it is the default encoding of HTTP content.

### Serif
A small line attached to the ends of glyphs

### Sans Serif
No serif's

##G Clef Sample

### Symbol

[g clef](http://www.fileformat.info/info/unicode/char/1d11e/index.htm)

### Sample application
[source](core/src/main/scala/com/seanshubin/documentation/core/ClefSample.scala)

```text
unicode code point (4 bytes) 00 01 d1 1e
high surrogate     (2 bytes) d8 34
low surrogate      (2 bytes) dd 1e
utf 8 bytes        (4 bytes) f0 9d 84 9e
utf 16 bytes       (6 bytes) fe ff d8 34 dd 1e
```

### Interpreting the utf-8 bytes
| Byte 1 | Byte 2 | Byte 3 | Byte 4 | Byte 5 | Byte 6 | Significant Bits |
|--------|--------|--------|--------|--------|--------|------------------|
|0xxxxxxx|        |        |        |        |        | 7                |
|110xxxxx|10xxxxxx|        |        |        |        | 11               |
|1110xxxx|10xxxxxx|10xxxxxx|        |        |        | 16               |
|11110xxx|10xxxxxx|10xxxxxx|10xxxxxx|        |        | 21               |
|111110xx|10xxxxxx|10xxxxxx|10xxxxxx|10xxxxxx|        | 26               |
|1111110x|10xxxxxx|10xxxxxx|10xxxxxx|10xxxxxx|10xxxxxx| 31               |

| hex | binary   |
|-----|----------|
| f0  | 11110000 |
| 9d  | 10011101 |
| 84  | 10000100 |
| 9e  | 10011110 |

```text
hex     01d11e
binary  000000011101000100011110
utf8    11110000 10011101 10000100 10011110
trim         000   011101   000100   011110
compact    000011101000100011110
binary  000000011101000100011110
```
