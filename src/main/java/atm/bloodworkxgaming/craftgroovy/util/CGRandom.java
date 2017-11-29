package atm.bloodworkxgaming.craftgroovy.util;

import de.bloodworkxgaming.groovysandboxedlauncher.annotations.GSLWhitelistMember;

import java.util.concurrent.ThreadLocalRandom;

public class CGRandom {
    static ThreadLocalRandom rand = ThreadLocalRandom.current();

    /**
     * Returns a pseudorandom {@code int} value.
     *
     * @return a pseudorandom {@code int} value
     */
    @GSLWhitelistMember
    public static int nextInt() {
        return rand.nextInt();
    }

    /**
     * Returns a pseudorandom {@code int} value between zero (inclusive)
     * and the specified bound (exclusive).
     *
     * @param bound the upper bound (exclusive).  Must be positive.
     * @return a pseudorandom {@code int} value between zero
     *         (inclusive) and the bound (exclusive)
     * @throws IllegalArgumentException if {@code bound} is not positive
     */
    @GSLWhitelistMember
    public static int nextInt(int bound) {
        return rand.nextInt(bound);
    }

    /**
     * Returns a pseudorandom {@code int} value between the specified
     * origin (inclusive) and the specified bound (exclusive).
     *
     * @param origin the least value returned
     * @param bound the upper bound (exclusive)
     * @return a pseudorandom {@code int} value between the origin
     *         (inclusive) and the bound (exclusive)
     * @throws IllegalArgumentException if {@code origin} is greater than
     *         or equal to {@code bound}
     */
    @GSLWhitelistMember
    public static int nextInt(int origin, int bound) {
        return rand.nextInt(origin, bound);
    }

    /**
     * Returns a pseudorandom {@code long} value.
     *
     * @return a pseudorandom {@code long} value
     */
    @GSLWhitelistMember
    public static long nextLong() {
        return rand.nextLong();
    }

    /**
     * Returns a pseudorandom {@code long} value between zero (inclusive)
     * and the specified bound (exclusive).
     *
     * @param bound the upper bound (exclusive).  Must be positive.
     * @return a pseudorandom {@code long} value between zero
     *         (inclusive) and the bound (exclusive)
     * @throws IllegalArgumentException if {@code bound} is not positive
     */
    @GSLWhitelistMember
    public static long nextLong(long bound) {
        return rand.nextLong(bound);
    }

    /**
     * Returns a pseudorandom {@code long} value between the specified
     * origin (inclusive) and the specified bound (exclusive).
     *
     * @param origin the least value returned
     * @param bound the upper bound (exclusive)
     * @return a pseudorandom {@code long} value between the origin
     *         (inclusive) and the bound (exclusive)
     * @throws IllegalArgumentException if {@code origin} is greater than
     *         or equal to {@code bound}
     */
    @GSLWhitelistMember
    public static long nextLong(long origin, long bound) {
        return rand.nextLong(origin, bound);
    }

    /**
     * Returns a pseudorandom {@code double} value between zero
     * (inclusive) and one (exclusive).
     *
     * @return a pseudorandom {@code double} value between zero
     *         (inclusive) and one (exclusive)
     */
    @GSLWhitelistMember
    public static double nextDouble() {
        return rand.nextDouble();
    }

    /**
     * Returns a pseudorandom {@code double} value between 0.0
     * (inclusive) and the specified bound (exclusive).
     *
     * @param bound the upper bound (exclusive).  Must be positive.
     * @return a pseudorandom {@code double} value between zero
     *         (inclusive) and the bound (exclusive)
     * @throws IllegalArgumentException if {@code bound} is not positive
     */
    @GSLWhitelistMember
    public static double nextDouble(double bound) {
        return rand.nextDouble(bound);
    }

    /**
     * Returns a pseudorandom {@code double} value between the specified
     * origin (inclusive) and bound (exclusive).
     *
     * @param origin the least value returned
     * @param bound the upper bound (exclusive)
     * @return a pseudorandom {@code double} value between the origin
     *         (inclusive) and the bound (exclusive)
     * @throws IllegalArgumentException if {@code origin} is greater than
     *         or equal to {@code bound}
     */
    @GSLWhitelistMember
    public static double nextDouble(double origin, double bound) {
        return rand.nextDouble(origin, bound);
    }

    /**
     * Returns a pseudorandom {@code boolean} value.
     *
     * @return a pseudorandom {@code boolean} value
     */
    @GSLWhitelistMember
    public static boolean nextBoolean() {
        return rand.nextBoolean();
    }

    /**
     * Returns a pseudorandom {@code float} value between zero
     * (inclusive) and one (exclusive).
     *
     * @return a pseudorandom {@code float} value between zero
     *         (inclusive) and one (exclusive)
     */
    @GSLWhitelistMember
    public static float nextFloat() {
        return rand.nextFloat();
    }

    @GSLWhitelistMember
    public static double nextGaussian() {
        return rand.nextGaussian();
    }
}
