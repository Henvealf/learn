//package xueshengxitong;
//import java.util.Scanner;
//public class xueshengxitong extends main{
//static xueshengxitong[] Stu=new xueshengxitong[100];
//static int number=0;
//static Scanner scanner=new Scanner(System.in);
//private static int setScore;
//	public xueshengxitong(String name, String sex, int english, int javacourse, int math, int num) {
//}
//	public xueshengxitong() {
//	}
//	public static void main(String[] args){
//		System.out.println("*********************************");
//		System.out.println("ɽ���ƾ���ѧ��ӭ��");
//		System.out.println("*********************************");
//		System.out.println("��ӭʹ��JAVAѧ���ɼ�����ϵͳ������");
//		System.out.println("*********************************");
//		System.out.println("��ܰ��ʾ������ѧ�Ų��ң��޸�ɾ�����ݣ����� ");
//		System.out.println("*********************************");
//		Scanner reader= new Scanner(System.in);
//		String a;
//		System.out.println("���½�ʺţ���ENTER������");
//		a =  (String)reader.next();
//		String z;
//		System.out.println("���������룺");
//		z =  (String)reader.next();
//		if( a.equals("java")&&z.equals("java")){
//		System.out.println("�Թ���Ա��ݵ�½����ѡ�����Ĳ���");
//		System.out.println("����һ��ѧ����Ϣ�밴��1��");
//		System.out.println("���Ӷ��ѧ����Ϣ�밴��2��");
//		System.out.println("ɾ�������밴��3��");
//		System.out.println("���������밴��4��");
//		System.out.println("�޸������밴��5��");
//		System.out.println("ͳ�������밴��6��");
//		System.out.println("������������밴��7��");
//		System.out.println("������ȫ����ӡ����Ļ�밴��8��");
//		System.out.println("���������밴��9��");
//		System.out.println("��ѯ��ǰѧ�������밴��#��");
//		System.out.println("��ѯ��ǰid�����밴��*��");
//		System.out.println("�����ܷ������밴��@��");
//		System.out.println("�޸������밴��&��");
//		System.out.println("�˳������밴��0��");}
//		while(true) {
//		String c =  reader.next();
//		switch(c) {
//		case "1":setlove1();break;
//		case "2":getlove2();break;
//		case "3":love3();break;
//		case "4":love4();break;
//		case "5":love5();break;
//		case "6":ame6();break;
//		case "7":love7();break;
//		case "8":love8();break;
//		case "9":love9();break;
//		case "#":loveq();break;
//		case "*":lovew();break;
//		case "@":lovee();break;
//		case "&":lover();break;
//		case "0":System.exit(0);break;
//			default:System.out.println("����");
//			}System.out.println("�Թ���Ա��ݼ���");
//	}}
//
//
//
//
//	private static void setlove1(){
//		Scanner reader= new Scanner(System.in);
//
//		String name;
//		System.out.println("������������");
//		name =reader.next();
//		String sex;
//		System.out.println("�������Ա�");
//		sex =reader.next();
//		int english;
//		System.out.println("������Ӣ��ɼ���");
//		english =reader.nextInt();
//		int javacourse;
//		System.out.println("������java�ɼ���");
//		javacourse =reader.nextInt();
//		int math;
//		System.out.println("��������ѧ�ɼ���");
//		math =reader.nextInt();
//		int num;
//		System.out.println("������ѧ�ţ�");
//		num =reader.nextInt();
//		Stu[number++]=new xueshengxitong(name,sex,english,javacourse,math,num);
//
//
//	}
//	private static void getlove2(){
//		Scanner reader= new Scanner(System.in);
//		System.out.println("�������Ӽ���ѧ����Ϣ����");
//		 int b =  reader.nextInt();
//		for(int x=1;x<=b;x++) {
//			String name;
//			System.out.println("������������");
//			name =reader.next();
//			String sex;
//			System.out.println("�������Ա�");
//			sex =reader.next();
//			int english;
//			System.out.println("������Ӣ��ɼ���");
//			english =reader.nextInt();
//			int javacourse;
//			System.out.println("������java�ɼ���");
//			javacourse =reader.nextInt();
//			int math;
//			System.out.println("��������ѧ�ɼ���");
//			math =reader.nextInt();
//			int num;
//			System.out.println("������ѧ�ţ�");
//			num =reader.nextInt();
//			Stu[number++]=new xueshengxitong(name,sex,english,javacourse,math,num);
//
//		System.out.println("��ӳɹ�");
//	}}
//	private static void love3(){
//		System.out.println("������ѧ�ţ�");
//		Scanner input=new Scanner(System.in) ;
//		int a=input.nextInt()-1;
//		if(number==0||a>=number)
//			System.out.println("���޴���");
//		else {
//			Stu[a].setName(null);
//			Stu[a].setNum(null);
//			Stu[a].setSex(null);
//			Stu[a].setJavacourse(0);
//			Stu[a].setMath(0);
//			Stu[a].setEnglish(0);
//			Stu[a].setScore=0;
//			System.out.println("ɾ���ɹ�");
//		}
//	}
//    private static void love4(){
//    	System.out.println("������ѧ�ţ�");
//    	Scanner reader=new Scanner(System.in);
//    	int i = reader.nextInt()-1;
//    	if(i<0||i>=number)
//    		System.out.print("�޴�����");
//    	else {
//    		String a=Stu[i].getNum();
//    		String b=Stu[i].getName();
//    		String c=Stu[i].getSex();
//    		int d =Stu[i].getMath();
//    		int e=Stu[i].getEnglish();
//    		int f=Stu[i].getJavacourse();
//System.out.println("ѧ�ţ�"+a+"������"+b+"�Ա�"+c+"��ѧ�ɼ���"+d+"Ӣ��ɼ���"+e+"Java�ɼ���"+f);
//	}}
//
//    private static void love5(){
//    	System.out.println("������ѧ�ţ�");
//		String xuehao =scanner.next();
//		for(int i=0;i<number;i++){
//			if (xuehao.equals( Stu[i].getNum())){
//    			System.out.println("������Ҫ�޸ĵ�ѧ����Ϣ");
//    			System.out.println("������������");
//    			Stu[i].setName(scanner.next());
//    			System.out.println("�������Ա�");
//    			Stu[i].setSex(scanner.next());
//    			System.out.println("������Java�ɼ���");
//    			Stu[i].setJavacourse(scanner.nextInt());
//    			System.out.println("��������ѧ�ɼ���");
//    			Stu[i].setMath(scanner.nextInt());
//    			System.out.println("������Ӣ��ɼ���");
//    			Stu[i].setEnglish(scanner.nextInt());
//    			Stu[i].setScore=Stu[number].getJavacourse()+Stu[number].getMath()+Stu[number].getEnglish();
//    			break;
//    		}
//			}}
//
//	private static void ame6(){
//		Scanner reader= new Scanner(System.in);
//		System.out.println("����ͳ�ƣ�1��Ӣ��2����ѧ3��JAVA4:�ܷ�5���˳�");
//		String qw;
//		qw =  reader.next();
//		switch(qw) {
//		case "1":
//			for(int i=0;i<=number;i++){
//			int sum=0;
//			sum+=Stu[i].getEnglish();
//		System.out.println("Ӣ��ɼ��ܷ�"+sum);
//		int pingjun;
//		pingjun=sum/i;
//		System.out.println("Ӣ��ɼ��ܷ�"+pingjun);
//		}	break;
//		case "2":
//			for(int i=0;i<=number;i++){
//			int sum=0;
//			sum+=Stu[i].getMath();
//		System.out.println("��ѧ�ɼ��ܷ�"+sum);
//		int pingjun;
//		pingjun=sum/i;
//		System.out.println("��ѧ�ɼ��ܷ�"+pingjun);
//		}break;
//		case"3":
//			for(int i=0;i<=number;i++){
//			int sum=0;
//			sum+=Stu[i].getJavacourse();
//		System.out.println("java�ɼ��ܷ�"+sum);
//		int pingjun;
//		pingjun=sum/i;
//		System.out.println("java�ɼ��ܷ�"+pingjun);
//		}break;
//		case"4":
//			for(int i=0;i<=number;i++){
//			int sum=0;
//			int sum1=0;
//			int sum2=0;
//			sum1+=Stu[i].getEnglish();
//			sum2+=Stu[i].getJavacourse();
//			sum+=Stu[i].getMath();
//		System.out.println("�ܷ�"+sum+sum1+sum2);
//		}break;
//		default:break;
//		}
//
//	}
//    private static void love7(){
//    	number = 0;
//		System.out.println("���������");
//
//    }
//    private static void love8(){
//		for( int i=0;i<number;i++){
//				System.out.println("ѧ�ţ�"+Stu[i].getNum()+"������"+Stu[i].getName()+"�Ա�"+Stu[i].getSex()+"��ѧ�ɼ���"+Stu[i].getMath()+"Ӣ��ɼ���"+Stu[i].getEnglish()+"Java�ɼ���"+Stu[i].getJavacourse());
//			}
//	}
//    private static void love9(){
//		System.out.println("������ fairy");
//	}
//    private static void loveq(){
//		System.out.println("ѧ��������"+number);
//	}
//    private static void lovew(){
//		xueshengxitong.main(null);
//		System.out.println("��ǰid����java");
//	}
//    private static void lovee(){
//		int j;
//		xueshengxitong paiming =new xueshengxitong();
//		for(int i=0;i<number;i++){
//			for(j=i+1;j<number;j++)
//				if(Stu[i].getScore()>Stu[j].getScore()){
//					paiming=Stu[i];Stu[i]=Stu[j];Stu[j]=paiming;
//				}
//		}int i = 0;
//		for( i=0;i<number;i++){
//			System.out.println("ѧ�ţ�"+Stu[i].getNum()+"������"+Stu[i].getName()+"�Ա�"+Stu[i].getSex()+"��ѧ�ɼ���"+Stu[i].getMath()+"Ӣ��ɼ���"+Stu[i].getEnglish()+"Java�ɼ���"+Stu[i].getJavacourse());
//		}
//	}
//
//	private static void lover(){
//		Scanner reader= new Scanner(System.in);
//		String name = null;
//		String inputpass;
//		String newpassword;
//		String repassword;
//		String inputname="";
//		String admin="";
//		String administator="";
//		String password = null;
//		System.out.println("���½�ʺţ���ENTER������");
//	Scanner input=new Scanner(System.in);
//	inputname=input.next();
//		System.out.println("���������룺");
//	inputpass=input.next();
//	if(inputname.equals(name)&inputpass.equals(password)){
//		System.out.println("������������");
//		newpassword= input.next();
//		System.out.println("��ȷ��������");
//		repassword= input.next();
//		while (!(newpassword.equals(repassword))){
//			System.out.println("�������벻һ��");
//			newpassword= input.next();
//			System.out.println("��ȷ��������");
//			repassword= input.next();
//		}System.out.println("�޸�����ɹ�����������"+repassword);
//	}
//	}
//}
//
//
