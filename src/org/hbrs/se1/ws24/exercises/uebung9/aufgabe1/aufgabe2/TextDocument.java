package org.hbrs.se1.ws24.exercises.uebung9.aufgabe1.aufgabe2;

public class TextDocument extends CoreDocument {
    private String content;
    private Encoding encoding;

    public TextDocument(String content, Encoding encoding) {
        this.content = content;
        this.encoding = encoding;
    }

    @Override
    public int getSize() {
        try {
            return switch (encoding) {
                case UTF8 -> content.getBytes("UTF-8").length;
                case UTF16 -> content.getBytes("UTF-16").length;
                case UTF32 -> content.getBytes("UTF-32").length;
            };
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}