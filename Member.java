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
