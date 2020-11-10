package com.epam.university.java.core.task060;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Сериализация объектов
 *
 * <p>
 *     Сериализовать объект класса Person двумя способами:
 *     1. Стандартная сериализация
 *
 * </p>
 */

public interface Task060 {
    OutputStream objectSerialization(Object obj) throws IOException;

    Object objectDeserialization(OutputStream outStream) throws IOException, ClassNotFoundException;
}
