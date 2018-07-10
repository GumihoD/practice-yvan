package com.yvan.practice.test.java8;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    private enum Status {OPEN, CLOSED}

    @Getter
    private static final class Task {
        private final Status status;
        private final Integer points;

        Task(final Status status, final Integer points) {
            this.status = status;
            this.points = points;
        }

        @Override
        public String toString() {
            return String.format("[%s, %d]", status, points);
        }
    }

    public void test() throws IOException {
        final Collection<Task> tasks = Arrays.asList(new Task(Status.OPEN, 5), new Task(Status.OPEN, 13), new Task(Status.CLOSED, 8));
        final double totalPoints = tasks.stream().parallel().map(Task::getPoints).reduce(0, Integer::sum);
        Stream<Integer> integerStream = tasks.parallelStream().map(Task::getPoints);
        System.out.println("Total points (all tasks): " + totalPoints);
        final Collection<String> result = tasks.stream().mapToInt(Task::getPoints).asLongStream().mapToDouble(points -> points / totalPoints).boxed().mapToLong(weigth -> (long) (weigth * 100)).mapToObj(percentage -> percentage + "%").collect(Collectors.toList());
        System.out.println(result);

        final Path path = new File("C:\\Users\\admin\\Desktop\\Note.md").toPath();
        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            lines.onClose(() -> System.out.println("Done!")).forEach(System.out::println);
        }
    }

}