
public class ReaderNode {

    Reader info;
    ReaderNode next;

    ReaderNode() {
    }
    ReaderNode(Reader info, ReaderNode next){
        this.info = info;
        this.next = next;
    }
    
    ReaderNode(Reader x){
        this(x, null);
    }
}
