public class PaintJobChallenge {
    // exercise about method overloading
    public static void main(String[] args) {
        System.out.println(getBucketCount(-3.4, 2.1, 1.5, 2));
        System.out.println(getBucketCount(3.4, 2.1, 1.5, 2));
        System.out.println(getBucketCount(2.75, 3.25, 2.5, 1));

        System.out.println(getBucketCount(-3.4, 2.1, 1.5));
        System.out.println(getBucketCount(3.4, 2.1, 1.5));
        System.out.println(getBucketCount(7.25, 4.3, 2.35));

        System.out.println(getBucketCount(3.4, 1.5));
        System.out.println(getBucketCount(6.26, 2.2));
        System.out.println(getBucketCount(3.26, 0.75));
    }

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {
        if (isValidated(width) || isValidated(height) || isValidated(areaPerBucket) || extraBuckets < 0) {
            return -1; // validate
        }

        // (area of wall - extra bucket coverage) / area per bucket = paint buckets needed
        return (int) Math.ceil( ((width * height) - extraBuckets * areaPerBucket) / areaPerBucket );
    }

    public static int getBucketCount(double width, double height, double areaPerBucket) {
        if (isValidated(width) || isValidated(height) || isValidated(areaPerBucket)) {
            return -1;
        }
        // just find total buckets
        return (int) Math.ceil( (width * height) / areaPerBucket );
    }

    public static int getBucketCount(double area, double areaPerBucket) {
        if (isValidated(area) || isValidated(areaPerBucket)) {
            return -1;
        }
        // only area needed is known
        return (int) Math.ceil(area/areaPerBucket);
    }

    public static boolean isValidated(double number) {
        return number <= 0;
    }
}