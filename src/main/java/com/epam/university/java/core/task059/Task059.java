package com.epam.university.java.core.task059;

import java.util.List;

/** Given a start <code>path</code> for searching.
 * Return all absolute paths for files, which contain given <code>substring</code>.
 * Use NIO to solve this task.
 *
 */
public interface Task059 {
    /**
     * Method for searching a <code>substring</code>.
     * @param path start <code>path</code> for searching.
     * @param substring searching <code>substring</code>.
     * @return list of paths.
     */
    public List<String> find(String path, String substring);
}
