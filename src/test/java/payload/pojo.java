package payload;

public class pojo {

    public pojo() {}

    public pojo(String from, String to, String q) {
        this.from = from;
        this.to = to;
        this.q = q;
    }

    String from;
    String to;

    String q;

    public String getFrom() {  return from; }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {   return to;   }

    public void setTo(String to) {
        this.to = to;
    }

    public String getQ() {   return q;   }

    public void setQ(String q) {
        this.q = q;
    }


}
