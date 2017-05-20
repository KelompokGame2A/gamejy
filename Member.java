package application;

public class Member {
    private String clan;
    private String namaMbr;
    private int th;
    private int lv;
    private int pr;
    
    public Member(){
        this.clan = "";
        this.namaMbr = "";
        this.th = 0;
        this.lv = 0;
        this.pr = 0;
    }
    public String getClan() {
        return clan;
    }
    public void setClan(String clan) {
        this.clan = clan;
    }
    public String getNamaMbr() {
        return namaMbr;
    }
     public void setNamaMbr(String namaMbr) {
        this.namaMbr = namaMbr;
    }
    public int getTh() {
        return th;
    }
    public void setTh(int th) {
        this.th = th;
    }
    public int getLv() {
        return lv;
    }
    public void setLv(int lv) {
        this.lv = lv;
    }
    public int getPr() {
        return pr;
    }
    public void setPr(int pr) {
        this.pr = pr  ;
    }
    
}
