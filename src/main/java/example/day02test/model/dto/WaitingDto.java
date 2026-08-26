package example.day02test.model.dto;

public class WaitingDto {
    private String phone;
    private int headcount;

    public WaitingDto() { }
    public WaitingDto(String phone, int headcount) {
        this.phone = phone;
        this.headcount = headcount;
    }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public int getHeadcount() { return headcount; }
    public void setHeadcount(int headcount) { this.headcount = headcount; }

    @Override
    public String toString() {
        return "WaitingDto [phone=" + phone + ", headcount=" + headcount + "]";
    }
}