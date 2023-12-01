package dklsa.longevity;

 
public class Tool{
    public static void Sleep(int time){
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    /*
     * Get Address here
     */
    public static String getAddress(String[] var) {return Integer.toHexString(var.hashCode());}
    public static String getAddress(char[] var) {return Integer.toHexString(var.hashCode());}
    public static String getAddress(int[] var) {return Integer.toHexString(var.hashCode());}
    public static String getAddress(double[] var) {return Integer.toHexString(var.hashCode());}
    public static String getAddress(boolean[] var) {return Integer.toHexString(var.hashCode());}
    public static String getAddress(String var) {return Integer.toHexString(var.hashCode());}


    /*
     * from primitive[] to String[]
     */
    public static String[] toStringArray(int[] ray){
        String[] result = new String[ray.length];
        for(int i=0;i<ray.length;i++){
            result[i] += ray[i];
            result[i] = result[i].substring(4);
        }
        return result;
    }
    public static String[] toStringArray(int[] ray, String format){
        String[] result = new String[ray.length];
        for(int i=0;i<ray.length;i++){
            result[i] = result[i] + String.format(format, ray[i]);
            result[i] = result[i].substring(4);
        }
        return result;
    }
    public static String[] toStringArray(double[] ray){
        String[] result = new String[ray.length];
        for(int i=0;i<ray.length;i++){
            result[i] += ray[i];
            result[i] = result[i].substring(4);
        }
        return result;
    }
    public static String[] toStringArray(double[] ray, String format){
        String[] result = new String[ray.length];
        for(int i=0;i<ray.length;i++){
            result[i] = result[i] + String.format(format, ray[i]);
            result[i] = result[i].substring(4);
        }
        return result;
    }
    
    /*
     * count int[]
     * Addition Subtraction Multiply Divide
     */
    public static int[] toIntArrayMultiply(int[] a, int[] b){
        int[] result = new int[a.length];
        for(int i=0;i<a.length;i++){
            result[i] = a[i]*b[i];
        }
        return result;
    }
    public static int[] toIntArrayAddition(int[] a, int[] b){
        int[] result = new int[a.length];
        for(int i=0;i<a.length;i++){
            result[i] = a[i]+b[i];
        }
        return result;
    }
    public static int[] toIntArraySubtraction(int[] a, int[] b){
        int[] result = new int[a.length];
        for(int i=0;i<a.length;i++){
            result[i] = a[i]-b[i];
        }
        return result;
    }
    public static int[] toIntArrayDivide(int[] a, int[] b){
        int[] result = new int[a.length];
        for(int i=0;i<a.length;i++){
            result[i] = a[i]/b[i];
        }
        return result;
    }
    // Overload toDoubleArrayDivide 
    public static double[] toDoubleArrayDivide(int[] a, int[] b){
        double[] result = new double[a.length];
        for(int i=0;i<a.length;i++){
            result[i] = (double)a[i]/b[i];
        }
        return result;
    }
    public static double[] toDoubleArrayDivide(double[] a, int[] b){
        double[] result = new double[a.length];
        for(int i=0;i<a.length;i++){
            result[i] = a[i]/b[i];
        }
        return result;
    }
    public static double[] toDoubleArrayDivide(int[] a, double[] b){
        double[] result = new double[a.length];
        for(int i=0;i<a.length;i++){
            result[i] = a[i]/b[i];
        }
        return result;
    }
    public static double[] toDoubleArrayDivide(double[] a, double[] b){
        double[] result = new double[a.length];
        for(int i=0;i<a.length;i++){
            result[i] = a[i]/b[i];
        }
        return result;
    }
    // array[] / divideBy
    public static double[] toDoubleArrayDivide(double[] a, double divideBy){
        double[] result = new double[a.length];
        for(int i=0;i<a.length;i++){
            result[i] = a[i]/divideBy;
        }
        return result;
    }
    public static double[] toDoubleArrayDivide(int[] a, double divideBy){
        double[] result = new double[a.length];
        for(int i=0;i<a.length;i++){
            result[i] = (double)a[i]/divideBy;
        }
        return result;
    }
    // divideBy / array[]
    public static double[] toDoubleArrayDivide(double divideBy, double[] a){
        double[] result = new double[a.length];
        for(int i=0;i<a.length;i++){
            result[i] = divideBy/a[i];
        }
        return result;
    }
    public static double[] toDoubleArrayDivide(double divideBy, int[] a){
        double[] result = new double[a.length];
        for(int i=0;i<a.length;i++){
            result[i] = divideBy/(double)a[i];
        }
        return result;
    }


    /*
     * From String to array string
     * 24/11/2023 13:1 ternyata udah ada  namanya split huhu:(
     */

     /*
      * Table console maker
      */
    // public static void table() {
        
    // }
}
