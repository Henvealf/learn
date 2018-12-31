package xueshengxitong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * ѧ��ϵͳ
 * @author CCITTYY-
 *
 */
public class StudentSystem {
	
	// list�� һ��ѧ��
	private ArrayList<Student> students = new ArrayList<>();
	private String adminName;
	private String adminPwd;
    private final Scanner reader= new Scanner(System.in);
	
	/**
	 * ѧ��ϵͳ���췽������Ҫ���ù���Ա���������롣
	 * @param adminName
	 * @param adminPwd
	 */
	public StudentSystem(String adminName, String adminPwd) {
		this.adminName = adminName;
		this.adminPwd = adminPwd;
		// ����������
//		students.add(new Student("0001","qqq", "nan", 123,123,123));
//		students.add(new Student("0002","fff", "nanv", 34,66,77));
//		students.add(new Student("0003","rrr", "n", 88,22,99));
	}


	public void printNotice() {
        System.out.println("*********************************");
        System.out.println("ɽ���ƾ���ѧ��ӭ��");
        System.out.println("*********************************");
        System.out.println("��ӭʹ��JAVAѧ���ɼ�����ϵͳ������");
        System.out.println("*********************************");
        System.out.println("��ܰ��ʾ������ѧ�Ų��ң��޸�ɾ�����ݣ����� ");
        System.out.println("*********************************");
    }

    public void printHelp() {
        System.out.println("------------- * -------------- * -------------");
        System.out.println(" ## " + adminName + "ͬѧ�� �������ı��� ## \n");
        System.out.println(" ����һ��ѧ����Ϣ�밴��1��");
        System.out.println(" ���Ӷ��ѧ����Ϣ�밴��2��");
        System.out.println(" ɾ�������밴��3��");
        System.out.println(" ���������밴��4��");
        System.out.println(" �޸������밴��5��");
        System.out.println(" ͳ�������밴��6��");
        System.out.println(" ������������밴��7��");
        System.out.println(" ������ȫ����ӡ����Ļ�밴��8��");
        System.out.println(" ���������밴��9��");
        System.out.println(" ��ѯ��ǰѧ�������밴��#��");
        System.out.println(" ��ѯ��ǰ��¼�û��밴��*��");
        System.out.println(" �����ܷ������밴��@��");
        System.out.println(" �޸������밴��&��");
        System.out.println(" �˳������밴��0��");
        System.out.println("---------------------------------------------");
    }

    public void printHeader() {
        System.out.printf("%9s%9s%8s%8s%9s%8s%8s\n", "ѧ��", "����","�Ա�", "Ӣ��", "��ѧ", "Java", "�ܷ�");
    }

    public void login() {

        System.out.println("���½�ʺţ���ENTER������");
        String username =  (String)reader.next();

        System.out.println("���������룺");
        String pwd =  (String)reader.next();

        while ( !checkLoginUser(username, pwd) ){
            System.out.println("��֤ʧ�ܣ����������룺");
            System.out.println("���½�ʺţ���ENTER������");
            username =  (String)reader.next();

            System.out.println("���������룺");
            pwd =  (String)reader.next();
        }
        System.out.println("------------------��ӭ��½����-------------------");
    }

	/**
	 * ����¼�û����˺����롣
	 * @param userName
	 * @param userPwd
	 * @return true ��ʾ���ͨ����
	 */
	public boolean checkLoginUser(String userName, String userPwd) {
		return userName != null && userName.equals(this.adminName) && userPwd != null && userPwd.equals(this.adminPwd);
	}


    public void process() {
        while(true) {

            String c =  reader.next();

            switch(c) {
                case "1" :
                    goAdd();
                    break;
                case "2":
                    goAddMutil();
                    break;
                case "3":
                    goDelete();
                    break;
                case "4":
                    goFind();
                    break;
                case "5":
                    goChange();
                    break;
                case "6":
                    goStaitc();
                    break;
                case "7":
                    clearData();
                    System.out.println("����ɹ�");
                    break;
                case "8":
                    printAllData();
                    break;
                case "9":
                    System.out.println("*******************************");
                    System.out.println("********* ������ fairy *********");
                    System.out.println("*******************************");
                    break;
                case "#":
                    System.out.println("ѧ������Ϊ: " + students.size());
                    break;
                case "*":
                    System.out.println("��ǰ��¼�û�Ϊ�� " + this.adminName);
                    break;
                case "@":
                    printOrderByScore();
                    break;
                case "&":
                    System.out.println("������������");
                    String pwd = reader.next();

                    while (pwd == null || "".equals(pwd)) {
                        System.out.println("���������룡");
                    }
                    this.adminPwd = pwd;
                    System.out.println("�޸ĳɹ���");
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.err.println("����");
            }
            printHelp();
        }
    }



    private void goAdd() {
        Student student = buildStudentFromReader();
        addOne(student);
    }

    private void goAddMutil() {
        System.out.println("�������Ӽ���ѧ����Ϣ����");
        int count = reader.nextInt();
        for (int i = 1; i <= count; i++) {
            System.out.println("��ʼ���ӵ� " + i + " λѧ��");
            goAdd();
        }
        System.out.println(count + " λѧ����Ϣ�����ϣ�" );
    }

    private void goDelete() {
        System.out.println("��������ɾ��ѧ����ѧ��");
        String id = reader.next();
        removeOne(id);
    }


    private void goFind() {
        System.out.println("������������ѧ����ѧ��");
        String id = reader.next();
        Student one = findOne(id);
        if (one != null) {
            System.out.println("�ҳ���ѧ����ϢΪ��\n");
            printHeader();
            System.out.println(one);
        }
    }

    private void goChange() {
        System.out.println("���������޸�ѧ����ѧ��");
        String id = reader.next();

        if (!isExists(id)) {
            System.err.println("�޸�ѧ����Ϣʧ�ܣ���ѧ�������ڣ�");
        }
        Student student = buildStudentFromReader(id);
        changeOne(student);
        System.out.println("�޸ĳɹ���");
    }

    private void goStaitc() {
        System.out.println("������ͳ������:  1:Ӣ��\t2:��ѧ\t3:Java\t4:�ܷ� ");
        int type = reader.nextInt();
        printStatistic(type);
    }






    /**
     * ʹ�����빹��һ��ѧ����
     * @return
     */
    public Student buildStudentFromReader(String id) {
        System.out.println("������������");
        String name = reader.next();

        System.out.println("�������Ա�");
        String sex = reader.next();

        System.out.println("������Ӣ��ɼ���");

        int english = getGrade();


        System.out.println("������java�ɼ���");
        int javacourse = getGrade();


        System.out.println("��������ѧ�ɼ���");
        int math = getGrade();

        if (id == null) {
            System.out.println("������ѧ�ţ�");
            id =reader.next();
        }

        return new Student(id, name, sex, english, javacourse, math);
    }

    private int getGrade() {
        int grade = -1;
        while (grade < 0) {
            try {
                String gradeStr =reader.next();
                grade = Integer.parseInt(gradeStr);
            } catch (Exception e) {
                grade = -1;
            }

            if (grade < 0) {
                System.err.println("�ɼ���ʽ������Ҫ�󣬱���Ϊ��Ȼ�������������룺");
            }
        }
        return grade;
    }

    public Student buildStudentFromReader() {
        return buildStudentFromReader(null);
    }

	/**
	 * ���ѧ���Ƿ���ڡ�
	 * @param id ѧ�š�
	 * @return true Ϊ���ڡ�
	 */
	public boolean isExists(String id) {
		
		if (null == id || "".equals(id)) {
			return false;
		}
		
		// ���ѧ����ϵͳ���Ƿ���ڡ�
		for(Student s : students) {
			String inId = s.getId();
			if( id.equals(inId) ) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isExists(Student student) {
		return null != student && isExists(student.getId());
	}

	/**
	 * ��ϵͳ�����һ��ѧ������
	 * @param student 
	 */
	public boolean addOne(Student student) {
		
		if (isExists(student)) {
			System.err.println("��ӵ�ѧ��ʧ�ܣ���ѧ���Ѿ����ڣ�");
			return false;
		}
		
		// ����ͼӵ��� list �����ά���±�ʲô�ġ�
		boolean result =  students.add(student);
		
		if (result) {
			System.out.println("���ѧ���ɹ���");
		} else {
			System.out.println("���ѧ��ʧ�ܣ�");
		}
		return result;
		
	}
	
	/**
	 * ɾ��һ��ѧ���� ʹ�� id ɾ����
	 * @param id
	 */
	public void removeOne(String id) {
		
		if (null == id) {
			System.err.println("ɾ��ѧ��ʧ�ܣ�ѧ��id����Ϊ��");
			return;
		}
		
		for(Student s : students) {
			String inId = s.getId();
			if( id.equals(inId) ) {
				students.remove(s);
				System.out.println("ɾ��ѧ���ɹ���");
				return;
			}
		}
		
		System.err.println("ɾ��ѧ��ʧ�ܣ���ѧ�������ڣ�");
	}
	
	
	/**
	 * ʹ�� ѧ�� ����ѧ����
	 * @param id ѧ��
	 * @return null ��ʾû���ҵ���
	 */
	public Student findOne(String id) {
		
		if (null == id) {
			System.err.println("��ѯѧ��ʧ�ܣ�ѧ��id����Ϊ��");
			return null;
		}
		
		for(Student s : students) {
			String inId = s.getId();
			if( id.equals(inId) ) {
				return s;
			}
		}
		
		System.err.println("��ѯѧ��ʧ�ܣ���ѧ�������ڣ�");
		return null;
	}
	
	/**
	 * �޸�ѧ����Ϣ��
	 * @param student
	 * @return true Ϊ�޸ĳɹ���
	 */
	public boolean changeOne(Student student) {

        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            String inId = s.getId();
            if( student.getId().equals(inId) ) {
                students.set(i, student);
                System.out.println("�޸�ѧ����Ϣ�ɹ���");
                return true;
            }
        }

		for(Student s : students) {

		}
		return false;
	}
	
	/**
	 * ��ӡ�ɼ�ͳ�ƽ����
	 * @param type ͳ�����ͣ�1��Ӣ��    2����ѧ   3��JAVA   4:�ܷ� 
	 */
	public void printStatistic(int type) {
		if (type < 1 || type > 4 ) {
			System.err.println("��������ȷ����  1:Ӣ��\t2:��ѧ\t3:Java\t4:�ܷ� ");
		}
		int total = 0;
		String course = "";
		// List ���ȡ�
		int size = this.students.size();
		switch (type) {
			case 1:
				for(Student s : students) {
					total += s.getEnglish();
				}
				course = "Ӣ��";
				break;
			case 2:
				for(Student s : students) {
					total += s.getMath();
				}
				course = "��ѧ";
				break;
			case 3:
				for(Student s : students) {
					total += s.getJavacourse();
				}
				course = "Java";
				break;
			case 4:
				for(Student s : students) {
					total += s.getEnglish();
					total += s.getMath();
					total += s.getJavacourse();
				}
				course = "��";
				break;
		}
		
		double avg = total / (double) size;
		System.out.println(course + "�ɼ��ܷ�: " + total);
		System.out.printf(course + "�ɼ�ƽ����: %.2f\n", avg);  // 0.2 ��˼������λС����
	}
	
	/**
	 * ������ݡ�
	 */
	public void clearData() {
		students.clear();
	}
	
	public void printAllData() {
	    if (students.size() == 0) {
            System.err.println("û�з����κ����ݡ�");
            return;
        }
        printHeader();
		for(Student s : students) {
			System.out.println(s);
		}
	}

	public void printOrderByScore() {

	    Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getScore() - o1.getScore();
            }
        });
	    printAllData();
    }

    public void close() {
	    if (null != reader) {
            reader.close();
        }
    }

}
