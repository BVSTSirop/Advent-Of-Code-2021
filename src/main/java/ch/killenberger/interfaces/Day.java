package ch.killenberger.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Day<T> {

    public T run() throws IOException;
}
