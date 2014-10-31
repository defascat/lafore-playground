package org.andy.study.algorythms.lafore.chapter3;



/**
 *
 * @author andy
 */
public abstract class Sort {
    public int[] sort(int[] items, boolean reverse) {
        int[] copied = new int[items.length];
        System.arraycopy(items, 0, copied, 0, copied.length);
        long time1 = System.currentTimeMillis();
        try {
            return reverse ? sortInternalReverse(copied) : sortInternal(copied);
        } finally {
            if(items.length > 100) {
                System.out.println("Sort " + this.getClass().getSimpleName() + " -> " + (System.currentTimeMillis() - time1));
            }
        }
    }
    
    protected void swap(int[] array, int i, int j) {
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

    protected abstract int[] sortInternal(int[] copied);

    protected int[] sortInternalReverse(int[] copied) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected static interface Compare {
        boolean compare(int[] arr, int index, int index1);
    }
}
