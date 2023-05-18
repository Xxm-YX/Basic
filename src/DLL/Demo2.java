package DLL;

public class Demo2 {

    static {
        System.loadLibrary("libMyDLL");
    }
    public static void main(String[] args) {
        HelloWorld();
    }
    public static native void HelloWorld();
}
