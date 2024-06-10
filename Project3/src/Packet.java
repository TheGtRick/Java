import java.io.Serializable;

public class Packet implements Serializable {
    String data;
    int serialNo;
    public Packet(int pNo, String data){
        this.data = data;
        this.serialNo = pNo;
    }
    public String getData(){
        return data;
    }
    public int getSerialNo(){
        return serialNo;
    }
    @Override
    public String toString() {
        return serialNo + " " + data;
    }
}
