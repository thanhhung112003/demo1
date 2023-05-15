import java.util.ArrayList;
import java.util.Scanner;
class NV{
	private String ten,que;
	private double hsl;
	NV(String t1, String q1, double h1)
	{
		ten=t1; que= q1; hsl= h1;
	}
	NV() { ten=""; que=""; hsl=0; }
	void in(){
		System.out.println("\n Ten: "+ ten +  "\t Que: " + que + " HSL= " + hsl);
	}
	double tl( ) { return hsl*1500;}
	void sethsl(double k) {
		hsl =k;
	}
	double gethsl() {
		return hsl;
	}
	String getque() {
		return que;
	}
	void nhap()
	{
		Scanner kb= new Scanner(System.in);
		System.out.println("\n Nhap ho ten:"); ten= kb.nextLine();
		System.out.println("\n Nhap que quan:"); que= kb.nextLine();
		System.out.println("\n Nhap he so luong:"); hsl= kb.nextDouble();
	}
}
class QL extends NV{
	private String cv;
	private double pc;
	void nhap()
	{
		super.nhap();
		Scanner kb= new Scanner(System.in);
		System.out.println("\n Nhap chuc vu:"); cv= kb.nextLine();
		System.out.println("\n Nhap phu cap:"); pc= kb.nextDouble();
	}
	QL(String t1, String q1, double h1, String c1, double p1)
	{
		super(t1, q1, h1); // goi ham tao lop co so
		cv=c1; pc=p1;
	}
	QL(){ super(); cv=""; pc=0;}
	void in(){
		super.in();
		System.out.println("\t Chuc vu: "+ cv +  "\t Phu cap : " + pc);
	}
	double tl( ) { return super.tl() + pc;}
}
class Congtyy{
	String ten;
	ArrayList<NV> a = new ArrayList<NV>();
	void nhap() {
		int n, tl;
		Scanner kb= new Scanner(System.in);
		System.out.println("Nhap vao so nhan vien: ");
		n = kb.nextInt();
		for(int i =1; i<=n;i++) {
			System.out.println("Nhap nhan vien thu "+i);
			System.out.println("Nhan vien hay quan ly (0/1)?");
			tl=kb.nextInt();
			NV e;
			if(tl== 0) {
				e =new NV();
			}
			else e= new QL();
			e.nhap();
			a.add(e);
		}
	}
	void dc_luong() {
		for(int i =0; i<a.size(); i++) {
			NV e = a.get(i);
			if(e.getque().compareTo("Quang nam")==0) {
				e.sethsl(e.gethsl()+0.33);
				a.set(i, e);
			}
		}
	}
	void in() {
		for(NV e:a) e.in();
	}
}

public class Congty {
	public static void main(String[] args) {
//		NV a= new NV("Nguyen Van Binh", "Quang Nam", 3.66);
//		QL b= new QL("Trang Thanh An", "Quang Nam", 4.00, "Truong Phong", 20000);
//		a.in();  System.out.println("\n Tien luong =" + a.tl());
//		b.in();  System.out.println("\n Tien luong =" + b.tl());
		Congtyy ct = new Congtyy();
		ct.nhap();
		ct.in();
		System.out.println("\n XONG!");
	}
}
