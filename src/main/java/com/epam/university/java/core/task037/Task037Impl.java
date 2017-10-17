package com.epam.university.java.core.task037;

import com.epam.university.java.core.utils.common.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

/**
 * Class implements <code>Task037</code> interface.
 */
public class Task037Impl implements Task037 {
    private int tickTackNumber = 10;

    /**
     * Add task to <code>FutureTask</code> list.
     *
     * @param tasksList list fot adding the task
     * @param callable  implemented class to run
     * @throws IllegalArgumentException if at least one of parameters is null
     * @throws InterruptedException     @see InterruptedException(String s)
     */
    private void addTask(List<FutureTask<String>> tasksList, Callable<String>
            callable) {
        Validator.validateNotNull(tasksList, callable, Validator
                .MESSAGE_FOR_FIRST_PARAMETER_IF_NULL, Validator
                .MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        FutureTask<String> futureTask = new FutureTask<>(callable);
        tasksList.add(futureTask);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Collection<String> switcher(Callable<String> ticker,
                                       Callable<String> tacker) {
        Validator.validateNotNull(ticker, tacker, Validator
                .MESSAGE_FOR_FIRST_PARAMETER_IF_NULL, Validator
                .MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        List<FutureTask<String>> futureTaskList = new ArrayList<>();
        for (int i = 2; i < tickTackNumber + 2; i++) {
            if (i % 2 == 0) {
                addTask(futureTaskList, ticker);
            } else {
                addTask(futureTaskList, tacker);
            }
        }
        return futureTaskList.stream().map(futureTask -> {
            try {
                return futureTask.get();
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
    }
}