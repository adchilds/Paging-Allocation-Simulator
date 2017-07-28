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
     * @param references
     * @param frames
     * @return
     */
    int[][] retAllocation(int[] references, int frames);

}