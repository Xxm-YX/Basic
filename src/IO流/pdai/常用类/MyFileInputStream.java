package IO流.pdai.常用类;

import java.io.*;

public class MyFileInputStream extends FileInputStream {
    public MyFileInputStream(File file) throws FileNotFoundException {
        super(file);
    }

    /**
     * 重写了 finalize 方法，把父类的 finalize 中的方法复制到此处，并且在其中添加打印信息
     *
     * @throws IOException 异常
     */
    @Override
    protected void finalize() throws IOException {
        if ((this.getFD() != null) && (this.getFD() != FileDescriptor.in)) {
            /* if fd is shared, the references in FileDescriptor
             * will ensure that finalizer is only called when
             * safe to do so. All references using the fd have
             * become unreachable. We can call close()
             */
            close();
            System.out.println("finalize and close");
        } else {
            System.out.println("only call finalize");
        }
    }
}