package 并发.final详解;

public class FinalReferenceDemo {
    final int[] arrays;
    private FinalReferenceDemo finalReferenceDemo;

    public FinalReferenceDemo() {
        arrays = new int[1];    //1
        arrays[0] = 1;      //2
    }

    public void writerOne(){
        finalReferenceDemo = new FinalReferenceDemo();//3
    }

    public void writerTwo(){
        arrays[0] = 2;
    }

    public void reader(){
        if(finalReferenceDemo != null){     //5
            int temp = finalReferenceDemo.arrays[0];    //6
        }
    }
}
