package s01;

import java.util.ConcurrentModificationException;
import java.util.Enumeration;
import java.util.NoSuchElementException;

public class CharStack {
    private char[] buffer;
    private int topIndex;
    private int version;
    private static final int DEFAULT_SIZE = 10;
    public CharStack(int estimatedSize) {
        buffer = new char[estimatedSize];
        this.topIndex = -1;
        version = 1;
    }
    public CharStack() {
        this(DEFAULT_SIZE);
    }
    public boolean isEmpty() {
        if (this.topIndex == -1) {
            return true;
        }
        return false;
    }
    public char top() {
        if (isEmpty()) {
            return '\u0000';
        }
        return buffer[this.topIndex]; // TODO
    }
    public char pop() {
        char x = buffer[this.topIndex];
        buffer[this.topIndex] = '\u0000';
        this.topIndex--;
        this.version++;
        return x;
    }
    public void push(char x) {
        if (topIndex == buffer.length - 1) {
            char[] tab = new char[buffer.length * 2];
            for (int i = 0; i < buffer.length; i++) {
                tab[i] = buffer[i];
            }
            buffer = new char[tab.length];
            for (int i = 0; i < topIndex + 1; i++) {
                buffer[i] = tab[i];
            }
        }
        this.topIndex++;
        this.version++;
        buffer[topIndex] = x;
    }
    /*
    Returns a read-only snapshot, as an Enumeration instance.
     * Typical usage:
     *   Enumeration<Character> en = myStack.topDownTraversal();
     *   while(en.hasMoreElements())
     *     System.out.println(en.nextElement());
     * Note that that according to the specification, nextElement()
     * has to throw a NoSuchElementException
     */
    public Enumeration<Character> topDownTraversal() {
        Enumeration<Character> enumeration = new Enumeration<>() {
            int index = topIndex + 1;
            int versionAtStart = version;

            @Override
            public boolean hasMoreElements() {
                if (versionAtStart != version) {
                    throw new ConcurrentModificationException();
                }
                return index - 1 >= 0;
            }

            @Override
            public Character nextElement() {
                if (versionAtStart != version) {
                    throw new ConcurrentModificationException();
                }
                if (!hasMoreElements()) {
                    throw new NoSuchElementException();
                }
                return buffer[--index];
            }
        };
        return enumeration;
    }
}


