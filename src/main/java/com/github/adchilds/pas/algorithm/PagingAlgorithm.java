package com.github.adchilds.pas.algorithm;

/**
 * Implementations of demand paging algorithms must implement this interface in order for Paging Allocation Simulator's
 * UI to correctly integrate with the algorithm.
 *
 * These algorithms represent a single strategy for an operating system's demand paging.
 *
 * @author Adam Childs
 * @since 2.0
 */
public interface PagingAlgorithm {

    /**
     * Performs all the algorithmic replacements and fills a 2D array.
     *
     * @param references the data
     * @param frames the number of frames
     * @return data after running the paging algorithm
     */
    int[][] retAllocation(int[] references, int frames);

    /**
     * Returns the number of page faults that occurred from executing the algorithm with input.
     *
     * @return the number of page faults
     */
    int retFault();

    /**
     * Calculates the percentage of page fault occurrences.
     *
     * @param refs
     * @param f
     * @return
     */
    double faultRate(int refs, int f);

}