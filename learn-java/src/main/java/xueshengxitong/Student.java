package xueshengxitong;

/**
 * ����һ��ѧ����
 * @author CCITTYY-
 *
 */
public class Student {
	
	private String id;
	private String name;
	private String sex;
	private int english;
	private int math;
	private int javacourse;
	private int score;
	
	
	/**
	 * ����һ�����췽�������ڹ���һ������
	 * @param id ѧ��
	 * @param name ����
	 * @param sex �Ա�
	 * @param english Ӣ��ɼ�
	 * @param javacourse java �ɼ�
	 * @param math ��ѧ�ɼ�
	 */
	public Student(String id, String name, String sex, int english, int javacourse, int math) {
		// this �������Լ��ı���/�ֶ�
		this.name = name;
		this.sex = sex;
		this.english = english;
		this.javacourse = javacourse;
		this.math = math;
		this.id = id;
		this.score = english + math + javacourse;
	}
	
	public String getName() {
		return name;
	}
	
	 public void setName(String name) {
		 this.name=name;
	 }
	 
	 public String getId() {
		 return id;
	 }
	 
	 public void setId(String id) {
		 this.id = id;
	 }
	 
	 public String getSex() {
		 return sex;
	 }
	 public void setSex(String sex) {
		 this.sex=sex;
	 }
	 public int getEnglish() {
		 return english;
	 }
	 public void setEnglish(int english) {
		 this.english=english;
	 }
	 public int getMath() {
		 return math;
	 }
	 public void setMath(int math) {
		 this.math=math;
	 }
	 public int getJavacourse() {
		 return javacourse;
	 }
	 public void setJavacourse(int javacourse) {
		 this.javacourse=javacourse;
	 }
	 public int getScore() {
		 return score;
	 }
	 public void setScore(int score) {
		 this.score=score;
	 }

	@Override
	public String toString() {
		return String.format("%10s%10s%10s%10d%10d%8d%10d", id, name, sex, english, math, javacourse, score);
//		return id + "\t\t" + name + "\t\t" + sex + "\t\t" + english + "\t\t" + math + "\t\t" + javacourse + "\t\t" + score;
	}

}
