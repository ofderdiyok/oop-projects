import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        //javac *java
        //java Main students.txt courses.txt grades.txt commands.txt
        //dosyaları args ile termianleden alcağımızdan dolayı ilk başta stringe çevirdim çünkü kod daha temiz olacak.
        String studentFile = "students.txt"; //"students.txt"
        String coursesFile = "courses.txt"; //
        String gradesFile = "grades.txt"; //
        String commandFile = "commands.txt"; //
        String outputFile = "output.txt"; //
        Methods.writeFileasString(commandFile,"\r"); //thanks to that we are reading last line in command file.
        Methods.writeFileasString(gradesFile,"\r");

        //verileri dosyadan alıp tutmak için kullanılan arraylistler
        ArrayList<Student> StudentsData = new ArrayList<>();
        ArrayList<Courses> CoursesData = new ArrayList<>();
        ArrayList<Grades> GradesData = new ArrayList<>();

        for (int i=0;i<Methods.CreateList(studentFile).length;i++)
        {
            String[] templine = Methods.CreateList(studentFile)[i].split(" ");
            String student_ID = templine[0];
            String student_name = templine[1];
            String student_surname = templine[2];
            StudentsData.add(new Student(student_ID,student_name,student_surname));
        }

        for (int i=0;i<Methods.CreateList(coursesFile).length;i++)
        {
            String[] templine = Methods.CreateList(coursesFile)[i].split(" ");
            String lecture_code = templine[0];
            String lecture_name = templine[1];
            CoursesData.add(new Courses(lecture_code,lecture_name));
        }

        for (int i=0;i<Methods.CreateList(gradesFile).length;i++)
        {
            String[] templine = Methods.CreateList(gradesFile)[i].split(" ");
            templine[templine.length-1]=templine[templine.length-1].substring(0,templine[templine.length-1].length() - 1);

            if (templine.length==5){
                String lecture_code = templine[0];
                String student_ID = templine[1];
                String mt1 = templine[2];
                String mt2 = templine[3];
                String finalExam = templine[4];
                double finalGrade = Methods.calculateFinalGrade(mt1,mt2,finalExam);
                GradesData.add(new Grades(lecture_code,student_ID,mt1,mt2,finalExam,finalGrade));
            }
            else if (templine.length<=1){
                continue;
            }
            else{
                String lecture_code = templine[0];
                String student_ID = templine[1];
                String mt1 = templine[2];
                String finalExam = templine[3];
                double finalGrade = Methods.calculateFinalGrade(mt1,finalExam);
                GradesData.add(new Grades(lecture_code,student_ID,mt1,finalExam,finalGrade));
            }
        }

        for (int i=0; i<Methods.CreateList(commandFile).length;i++)
        {
            String[] templine = Methods.CreateList(commandFile)[i].split(" ");
            templine[templine.length-1]=templine[templine.length-1].substring(0,templine[templine.length-1].length() - 1);

            //Command 1 +
            if (templine[0].equals("LIST") && templine[1].equals("COURSES") && templine[2].equals("ALL"))
            {
                Methods.writeFileasString(outputFile,"COMMAND:");
                Methods.writeFileasString(outputFile,templine[0]+ " " +templine[1] + " " + templine[2]);
                Methods.writeFileasString(outputFile,"RESULT:");
                for (Courses var : CoursesData){
                    Methods.writeFileasString(outputFile,var.getLectureCode() + " " + var.getLectureName());
                }
                Methods.writeFileasString(outputFile,"");
            }

            //Command 2 +
            else if (templine[0].equals("LIST") && templine[1].equals("STUDENTS"))
            {
                Methods.writeFileasString(outputFile,"COMMAND:");
                Methods.writeFileasString(outputFile,templine[0]+ " " +templine[1] + " " + templine[2] + " " +templine[3] + " " + templine[4]);
                Methods.writeFileasString(outputFile,"RESULT:");

                for (Grades var : GradesData){
                    if (var.getLectureCode().equals(templine[4])){
                        for (Student stuVar: StudentsData){
                            if (var.getStudentID().equals(stuVar.getStudentID())){
                                Methods.writeFileasString(outputFile,stuVar.getStudentID() + " " + stuVar.getStudentName() + " " + stuVar.getStudentSurname());
                            }
                        }
                    }
                }

                Methods.writeFileasString(outputFile,"");
            }

            //Command 3 +
            else if (templine[0].equals("LIST") && templine[1].equals("COURSES") && templine[2].equals("FOR"))
            {
                Methods.writeFileasString(outputFile,"COMMAND:");
                Methods.writeFileasString(outputFile,templine[0]+ " " +templine[1] + " " + templine[2] + " " +templine[3] + " " + templine[4]);
                Methods.writeFileasString(outputFile,"RESULT:");

                for (Grades var : GradesData){
                    if (var.getStudentID().equals(templine[4])){
                        for (Courses varCourses: CoursesData){
                            if (varCourses.getLectureCode().equals(var.getLectureCode())){
                                Methods.writeFileasString(outputFile,varCourses.getLectureCode() + " " + varCourses.getLectureName());
                            }
                        }
                    }
                }

                Methods.writeFileasString(outputFile,"");
            }

            //Command 4 +
            else if (templine[0].equals("LIST") && templine[1].equals("GRADES") && templine[3].equals("COURSE"))
            {
                Methods.writeFileasString(outputFile,"COMMAND:");
                Methods.writeFileasString(outputFile,templine[0]+ " " +templine[1] + " " + templine[2] + " " +templine[3] + " " + templine[4] + " " + templine[5] + " " +templine[6] + " " + templine[7]);
                Methods.writeFileasString(outputFile,"RESULT:");

                String courseID = templine[4];
                String studentID = templine[7];
                for (Grades var : GradesData){
                    if (var.getLectureCode().equals(courseID) && var.getStudentID().equals(studentID)){
                        if (var.getMt2()==null){
                            Methods.writeFileasString(outputFile,var.getMt1() + " " + var.getFinalExam());
                        }
                        else {
                            Methods.writeFileasString(outputFile,var.getMt1() + " " + var.getMt2() + " " + var.getFinalExam());
                        }
                    }
                }

                Methods.writeFileasString(outputFile,"");
            }

            //Command 5 +
            else if (templine[0].equals("LIST") && templine[1].equals("GRADES") && templine[3].equals("STUDENT"))
            {
                Methods.writeFileasString(outputFile,"COMMAND:");
                Methods.writeFileasString(outputFile,templine[0]+ " " +templine[1] + " " + templine[2] + " " +templine[3] + " " + templine[4]);
                Methods.writeFileasString(outputFile,"RESULT:");

                for (Grades var : GradesData){
                    if (var.getStudentID().equals(templine[4])){
                        if (var.getMt2()==null){
                            Methods.writeFileasString(outputFile,var.getLectureCode() + " " + var.getMt1() + " " + var.getFinalExam());
                        }
                        else {
                            Methods.writeFileasString(outputFile,var.getLectureCode() + " " + var.getMt1() + " " + var.getMt2() + " " + var.getFinalExam());
                        }
                    }
                }

                Methods.writeFileasString(outputFile,"");
            }

            //Command 6 + (double sonuçta düzenleme gerekiyor - - düzenleme yapıldı)
            else if(templine[0].equals("CALCULATE") && templine[1].equals("FINALGRADE"))
            {
                Methods.writeFileasString(outputFile,"COMMAND: ");
                Methods.writeFileasString(outputFile,templine[0]+ " " +templine[1] + " " + templine[2] + " " +templine[3] + " " + templine[4] + " " + templine[5] + " " +templine[6] + " " + templine[7]);
                Methods.writeFileasString(outputFile,"RESULT:");

                for (Grades var : GradesData){
                    if (var.getLectureCode().equals(templine[4]) && var.getStudentID().equals(templine[7])){
                        Methods.writeFileasString(outputFile,"" + Methods.doubleFormat(var.getFinalGrade()));
                    }
                }

                Methods.writeFileasString(outputFile,"");
            }

            //Command 7 + (double sonuçta düzenleme gerekiyor - düzenleme yapıldı)
            else if(templine[0].equals("CALCULATE") && templine[1].equals("ALL"))
            {
                Methods.writeFileasString(outputFile,"COMMAND:");
                Methods.writeFileasString(outputFile,templine[0]+ " " +templine[1] + " " + templine[2] + " " +templine[3] + " " + templine[4] +" " + templine[5]);
                Methods.writeFileasString(outputFile,"RESULT:");

                for (Grades var : GradesData){
                    if (var.getStudentID().equals(templine[5])){
                        Methods.writeFileasString(outputFile,var.getLectureCode() + " " + Methods.doubleFormat(var.getFinalGrade()));
                    }
                }

                Methods.writeFileasString(outputFile,"");
            }

            //Command 8 +
            else if(templine[0].equals("CALCULATE") && templine[1].equals("AVERAGE"))
            {
                Methods.writeFileasString(outputFile,"COMMAND:");
                Methods.writeFileasString(outputFile,templine[0]+ " " +templine[1] + " " + templine[2] + " " +templine[3] + " " + templine[4] + " " + templine[5]);
                Methods.writeFileasString(outputFile,"RESULT:");
                double totalMT1 = 0;
                double totalMT2 = 0;
                double totalFinal = 0;
                int counter = 0;

                for (Grades var : GradesData){
                    if (templine[5].equals(var.getLectureCode())){
                        counter +=1;
                        if (var.getMt2()==null){
                            totalMT1 += Double.parseDouble(var.getMt1());
                            totalFinal += Double.parseDouble(var.getFinalExam());
                        }
                        else{
                            totalMT1 += Double.parseDouble(var.getMt1());
                            totalMT2 += Double.parseDouble(var.getMt2());
                            totalFinal += Double.parseDouble(var.getFinalExam());
                        }
                    }
                }

                if (totalMT2==0){
                    Methods.writeFileasString(outputFile,Methods.doubleFormat(totalMT1/counter) + " " + Methods.doubleFormat(totalFinal/counter));
                }
                else{
                    Methods.writeFileasString(outputFile,Methods.doubleFormat(totalMT1/counter) + " " +Methods.doubleFormat(totalMT2/counter) + " " + Methods.doubleFormat(totalFinal/counter));
                }

                Methods.writeFileasString(outputFile,"");
            }

            //Command 9 +
            else if(templine[0].equals("FIND"))
            {
                Methods.writeFileasString(outputFile,"COMMAND:");
                Methods.writeFileasString(outputFile,templine[0]+ " " +templine[1] + " " + templine[2] + " " +templine[3] + " " + templine[4]);
                Methods.writeFileasString(outputFile,"RESULT:");

                TreeSet<Double> ref = new TreeSet<>();
                ArrayList<String> gradesBiggest = new ArrayList<>();

                for (Grades var : GradesData){
                    if (var.getLectureCode().equals(templine[4])){
                        ref.add(var.getFinalGrade());
                    }
                }

                Enumeration e = Collections.enumeration(ref);
                while(e.hasMoreElements()){
                    String temp = e.nextElement() + "";
                    gradesBiggest.add(temp);
                }

                double bestNote = Double.parseDouble(gradesBiggest.get(gradesBiggest.size()-1));

                for (Grades var : GradesData){
                    if (var.getLectureCode().equals(templine[4]) && var.getFinalGrade()==bestNote){
                        for (Student varStudent : StudentsData){
                            if (var.getStudentID().equals(varStudent.getStudentID())){
                                Methods.writeFileasString(outputFile,varStudent.getStudentID() + " " + varStudent.getStudentName() + " " + Methods.returnFirstDigits(varStudent.getStudentSurname()) + " " + Methods.doubleFormat(var.getFinalGrade()));
                            }
                        }
                    }
                }
                Methods.writeFileasString(outputFile,"");
            }
        }
    }
}
