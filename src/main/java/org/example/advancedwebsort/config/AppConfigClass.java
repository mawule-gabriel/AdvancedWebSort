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

@EnableWebMvc
@ComponentScan(basePackages = "org.example.advancedwebsort")  // Ensure Spring scans the correct package
@Configuration
public class AppConfigClass {

    @Bean
    public QuickSortService quickSortService() {
        return new QuickSortService();
    }

    @Bean
    public HeapSortService heapSortService() {
        return new HeapSortService();
    }

    @Bean
    public MergeSortService mergeSortService() {
        return new MergeSortService();
    }

    @Bean
    public RadixSortService radixSortService() {
        return new RadixSortService();
    }

    @Bean
    public BucketSortService bucketSortService() {
        return new BucketSortService();
    }

}
