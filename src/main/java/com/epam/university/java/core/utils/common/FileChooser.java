package com.epam.university.java.core.utils.common;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.io.File;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;

/**
 * Class implements choosing the file from Windows OS file system.
 *
 * @author Konstantin Mavropulo
 */
public class FileChooser {
    public String currentDirectory;

    /**
     * Initialising the <code>FileChooser</code>.
     *
     * @param currentDirectory directory to start selection process from
     * @throws IllegalArgumentException if
     *                                  <code>currentDirectory</code> is null
     */
    public FileChooser(String currentDirectory) {
        Validator.validateNotNull(currentDirectory,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        this.currentDirectory = currentDirectory;
    }

    /**
     * Initialising the <code>FileChooser</code>, for Windows OS tries to find
     * the Desktop's path for current user.
     */
    public FileChooser() {
        currentDirectory = FileSystemView.getFileSystemView()
                .getDefaultDirectory().getPath();
        currentDirectory = currentDirectory.replace("\\",
                "/");
        currentDirectory = currentDirectory.replace("Documents",
                "Desktop");
        if (!new File(currentDirectory).exists()) {
            currentDirectory = "";
        }
    }

    /**
     * Create new file or choose existing from file system.
     *
     * @param prompt     - message for dialog title
     * @param fileFilter choose the file's type
     * @return <code>File</code> selected file
     * @throws IllegalArgumentException if at least one of arguments is null
     */
    public File createFile(String prompt, FileFilter fileFilter) {
        Validator.validateNotNull(prompt, fileFilter,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        JFileChooser jFileChooser = new JFileChooser(currentDirectory);
        jFileChooser.setDialogTitle(prompt);
        jFileChooser.setFileFilter(fileFilter);
        jFileChooser.showSaveDialog(new JFrame());
        currentDirectory = jFileChooser.getSelectedFile().getParent();
        return jFileChooser.getSelectedFile();
    }

    /**
     * Choose existing file from file system.
     *
     * @param prompt     - message for dialog title
     * @param fileFilter choose the file's type
     * @return <code>File</code> selected file
     * @throws IllegalArgumentException if at least one of arguments is null
     */
    public File openFile(String prompt, FileFilter fileFilter) {
        Validator.validateNotNull(prompt, fileFilter,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        JFileChooser jFileChooser = new JFileChooser(currentDirectory);
        jFileChooser.setDialogTitle(prompt);
        jFileChooser.setFileFilter(fileFilter);
        jFileChooser.showOpenDialog(new JFrame());
        currentDirectory = jFileChooser.getSelectedFile().getParent();
        return jFileChooser.getSelectedFile();
    }
}