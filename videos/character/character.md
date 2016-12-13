# Character
I am going to given you an overview of some of the lessor known characteristics of the visual symbol known as the "character"

## What does a software engineer need to know about characters?
When software engineers talk about characters they are likely referring to code units,
while when their customers talk about characters they are likely referring to graphemes.
There is a lot of terminology surrounding characters,
and the terms are so interrelated it is hard to define them all in a non-circular manner.
So I am going to try to provide definitions that are unambiguous even though some are circular. 

## Character Terminology 

### Grapheme
The smallest meaningful contrastive unit of a writing system.
Examples are alphabetic letters, chinese characters, numbers, and punctuation marks.

### Glyph
The shape of a marking representing a grapheme.
Different glyphs may represent the same grapheme. 

### Font
A set of glyphs with a particular set of parameters, such as weight, slope, width, serif, monospaced, etc.

### Font Family / Typeface
A range of fonts that share an overall design

### Character
Intended to be a computer representation of a grapheme, but it got more complicated than that.

### Code Point
Represents a single character in a code space.
This is a number that corresponds to a single character.

### Code Space
A range of numerical values available for encoding characters.

### Code Unit
Smallest computer unit with which to build code points.

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

## Java example

    FileReader fileReader = new FileReader("README.md");

    InputStreamReader inputStreamReader = 
        new InputStreamReader(new FileInputStream("README.md"), Charset.defaultCharset());


## HTML 5 example
    <!-- In HTML5 -->
    <meta charset="utf-8">

This <meta> element must be inside the <head> element and within the 1024 first bytes of the page, as some browsers only look at these first bytes before choosing a character set for the page.
Authors should not use ASCII-incompatible encodings (i.e. those that don't map the 8-bit code points 0x20 to 0x7E to the Unicode 0x0020 to 0x007E code points) as these represent a security risk: browsers not supporting them may interpret benign content as HTML Elements. This is the case of at least the following charsets: JIS_C6226-1983, JIS_X0212-1990, HZ-GB-2312, JOHAB, the ISO-2022 family, and the EBCDIC family.


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
