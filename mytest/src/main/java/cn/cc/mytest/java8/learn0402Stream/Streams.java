package cn.cc.mytest.java8.learn0402Stream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
//import java.nio.file.fi
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
	
	public static void main(String[] args) throws IOException {
		final Collection< Task > tasks = Arrays.asList(
			    new Task( Status.OPEN, 5 ),
			    new Task( Status.OPEN, 13 ),
			    new Task( Status.CLOSED, 8 ) 
			);
		
		final long total0 = tasks
				.stream()
				.filter(task -> task.getStatus() == Status.OPEN)
				.mapToInt(e -> e.getPoints0(2))
				.sum();
		System.out.println(total0);
		
		final long total = tasks
				.stream()
				.filter(task -> task.getStatus() == Status.OPEN)
				.mapToInt(Task :: getPoints)
				.sum();
		System.out.println(total);
		
		final double total2 = tasks
				.stream()
				.parallel()
				.map(Task :: getPoints)
				.reduce(0, Integer :: sum);
		System.out.println(total2);
		
		final Map<Status, List<Task>> map = tasks
				.stream()
				.collect(Collectors.groupingBy(Task :: getStatus));
		System.out.println(map);
		
		
		final Collection<String> result = tasks
				.stream()
				.mapToInt(Task :: getPoints)
				.asLongStream()
				.mapToDouble(points -> points / total2)
				.boxed()
				.mapToLong(weigth -> (long)(weigth *100))
				.mapToObj(percentage -> percentage + "%")
				.collect(Collectors.toList());
		System.out.println(result);
		
		
//		final Path path = new File("E:\\test\\001.txt").toPath();
//		try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
//			lines.onClose(() -> System.out.println("Done!")).forEach(System.out :: println);
//		}
		
		
	}

	private enum Status {
        OPEN, CLOSED
    };
     
    private static final class Task {
        private final Status status;
        private final Integer points;
 
        Task( final Status status, final Integer points ) {
            this.status = status;
            this.points = points;
        }
         
        public Integer getPoints() {
            return points;
        }
        
        public Integer getPoints0(int i) {
            return points * i;
        }
         
        public Status getStatus() {
            return status;
        }
         
        @Override
        public String toString() {
            return String.format( "[%s, %d]", status, points );
        }
    }
}
