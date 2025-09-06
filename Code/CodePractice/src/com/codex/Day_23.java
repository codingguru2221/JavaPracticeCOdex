package com.codex;

import java.util.concurrent.*;

// Separate Task class
class MyTask implements Callable<String> {
    private final String taskName;
    private final int duration;

    public MyTask(String taskName, int duration) {
        this.taskName = taskName;
        this.duration = duration;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(duration); // simulate work
        return taskName + " finished in " + duration + " ms";
    }
}

public class Day_23 {
    public static void main(String[] args) {
        // Create ExecutorService with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Use CompletionService to get results as tasks complete
        CompletionService<String> completionService = new ExecutorCompletionService<>(executor);

        // Submit tasks
        completionService.submit(new MyTask("Task 1", 2000));
        completionService.submit(new MyTask("Task 2", 1000));
        completionService.submit(new MyTask("Task 3", 3000));

        try {
            // Fetch results as soon as each task finishes
            for (int i = 0; i < 3; i++) {
                Future<String> result = completionService.take();
                System.out.println(result.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
