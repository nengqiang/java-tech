package com.hnq.study.util;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author henengqiang
 * @date 2020/1/15
 */
public class ArrayUtils {

    private ArrayUtils() {}

    private static final Random R = new Random();

    public static int[] genIntArr(int size, int bound, boolean neg) {
        return Arrays.stream(genIntegerArr(size, bound, neg)).mapToInt(Integer::intValue).toArray();
    }

    public static Integer[] genIntegerArr(int size, int bound, boolean neg) {
        return genArr(size, bound, neg, Integer.class);
    }

    public static double[] genDouArr(int size, int bound, boolean neg) {
        return Arrays.stream(genDoubleArr(size, bound, neg)).mapToDouble(Double::doubleValue).toArray();
    }

    public static Double[] genDoubleArr(int size, int bound, boolean neg) {
        return genArr(size, bound, neg, Double.class);
    }

    public static float[] genFloArr(int size, int bound, boolean neg) {
        Float[] temp = genFloatArr(size, bound, neg);
        float[] res = new float[size];
        IntStream.range(0, size).forEach(i -> res[i] = temp[i]);
        return res;
    }

    public static Float[] genFloatArr(int size, int bound, boolean neg) {
        return genArr(size, bound, neg, Float.class);
    }

    public static long[] genLonArr(int size, boolean neg) {
        return Arrays.stream(genLongArr(size, neg)).mapToLong(Long::longValue).toArray();
    }

    public static Long[] genLongArr(int size, boolean neg) {
        return genArr(size, 0, neg, Long.class);
    }

    public static boolean[] genBooArr(int size) {
        Boolean[] temp = genBooleanArr(size);
        boolean[] res = new boolean[size];
        for (int i = 0; i < size; i++) {
            res[i] = temp[i];
        }
        return res;
    }

    public static Boolean[] genBooleanArr(int size) {
        return genArr(size, 0, false, Boolean.class);
    }

    /**
     * 生成数组
     *
     * @param size  数组长度
     * @param bound 数组值范围
     * @param neg   是否生成负数值
     * @param clazz 数组类型
     * @param <T>   声明一个泛型T
     * @return      返回type类型数组
     */
    @SuppressWarnings("unchecked")
    private static <T> T[] genArr(int size, int bound, boolean neg, final Class<T> clazz) {
        if (clazz == double.class || clazz == Double.class) {
            Double[] arr = new Double[size];
            for (int i = 0; i < size; i++) {
                double temp = R.nextDouble() + R.nextInt(bound);
                arr[i] = neg ? temp * (R.nextInt(2) == 0 ? 1 : -1) : temp;
            }
            return (T[]) arr;
        }
        if (clazz == float.class || clazz == Float.class) {
            Float[] arr = new Float[size];
            for (int i = 0; i < size; i++) {
                float temp = R.nextFloat() + R.nextInt(bound);
                arr[i] = neg ? temp * (R.nextInt(2) == 0 ? 1 : -1) : temp;
            }
            return (T[]) arr;
        }
        if (clazz == long.class || clazz == Long.class) {
            Long[] arr = new Long[size];
            for (int i = 0; i < size; i++) {
                long temp = R.nextLong();
                arr[i] = neg ? temp * (R.nextInt(2) == 0 ? 1 : -1) : temp;
            }
            return (T[]) arr;
        }
        if (clazz == boolean.class || clazz == Boolean.class) {
            Boolean[] arr = new Boolean[size];
            IntStream.range(0, size).forEach(i -> arr[i] = R.nextBoolean());
            return (T[]) arr;
        }
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            int temp = R.nextInt(bound);
            arr[i] = neg ? temp * (R.nextInt(2) == 0 ? 1 : -1) : temp;
        }
        return (T[]) arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(genIntArr(10, 10, true)));
        System.out.println(Arrays.toString(genIntegerArr(10, 10, false)));
        System.out.println();

        System.out.println(Arrays.toString(genDouArr(5, 10, true)));
        System.out.println(Arrays.toString(genDoubleArr(5, 10, false)));
        System.out.println();

        System.out.println(Arrays.toString(genFloArr(10, 10, true)));
        System.out.println(Arrays.toString(genFloatArr(10, 10, true)));
        System.out.println();

        System.out.println(Arrays.toString(genLonArr(5, true)));
        System.out.println(Arrays.toString(genLongArr(5, false)));
        System.out.println();

        System.out.println(Arrays.toString(genBooArr(10)));
        System.out.println(Arrays.toString(genBooleanArr(10)));
    }

}
