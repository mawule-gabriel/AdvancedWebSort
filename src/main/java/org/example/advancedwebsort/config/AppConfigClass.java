package org.example.advancedwebsort.config;

import org.example.advancedwebsort.service.QuickSortService;
import org.example.advancedwebsort.service.HeapSortService;
import org.example.advancedwebsort.service.MergeSortService;
import org.example.advancedwebsort.service.RadixSortService;
import org.example.advancedwebsort.service.BucketSortService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Configuration class to enable Spring MVC and define beans for various sorting services.
 */
@EnableWebMvc
@ComponentScan(basePackages = "org.example.advancedwebsort")
@Configuration
public class AppConfigClass {

    /**
     * Bean definition for QuickSortService.
     *
     * @return a new instance of QuickSortService.
     */
    @Bean
    public QuickSortService quickSortService() {
        return new QuickSortService();
    }


    /**
     * Bean definition for HeapSortService.
     *
     * @return a new instance of HeapSortService.
     */
    @Bean
    public HeapSortService heapSortService() {
        return new HeapSortService();
    }

    /**
     * Bean definition for MergeSortService.
     *
     * @return a new instance of MergeSortService.
     */
    @Bean
    public MergeSortService mergeSortService() {
        return new MergeSortService();
    }

    /**
     * Bean definition for RadixSortService.
     *
     * @return a new instance of RadixSortService.
     */
    @Bean
    public RadixSortService radixSortService() {
        return new RadixSortService();
    }

    /**
     * Bean definition for BucketSortService.
     *
     * @return a new instance of BucketSortService.
     */
    @Bean
    public BucketSortService bucketSortService() {
        return new BucketSortService();
    }

}
