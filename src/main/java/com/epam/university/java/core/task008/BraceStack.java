package com.epam.university.java.core.task008;

/**
 * Stack implementation class as collection for Braces.
 *
 * @author Sergei Titov
 */
public class BraceStack {

    BraceEntry head = null;

    boolean isEmpty() {
        return (null == head);
    }

    boolean tryPopValue(Brace brace) {
        if( isEmpty() )
            return false;

        if (brace == getHead()) {
            pop();
            return true;
        } else {
            return false;
        }
    }

    void push(Brace brace) {
        head = new BraceEntry(brace, head);
    }

    void pop() {
        if (!isEmpty()) {
            head = head.getPrev();
        }
    }

    Brace getHead() {
        return head.brace;
    }

    /**
     * Enumerates all the possible braces.
     */
    public enum Brace {
        ROUND,
        SQUIRE,
        FIGURED
    }

    /**
     * Entry class - brace holder.
     */
    public class BraceEntry {

        final BraceEntry prev;

        Brace brace;

        BraceEntry(Brace brace, BraceEntry prev) {
            this.brace = brace;
            this.prev = prev;
        }

        BraceEntry getPrev() {
            return prev;
        }
    }
}
