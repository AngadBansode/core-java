/*
package reactive;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
public class ReactiveDemo {
    public static void main(String[] args)
    {

        // Create a Flux of integers from 1 to 10
        Flux<Integer> flux = Flux.range(1, 10);

        // Use reactive operators to
        // transform and process the data

        // Filter out odd numbers
        flux.filter(i -> i % 2 == 0)
                // Double the remaining numbers
                .map(i -> i * 2)
                // Publish on parallel scheduler
                // for concurrent execution
                .publishOn(Schedulers.parallel())
                // Subscribe to the final data
                // stream and print the results
                .subscribe(System.out::println);

        // Wait for a moment to allow the
        // async processing to complete
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
*/
